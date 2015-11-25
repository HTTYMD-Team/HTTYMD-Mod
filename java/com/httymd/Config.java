package com.httymd;

import com.httymd.util.Utils;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class Config {

	private static final String STRING_PREFIX = "config.";
	private final Configuration config;
	private int startEntityID = -1;
	private boolean canOwnMultipleDragons = true;
	private boolean debugMode = false;
	private boolean experimentalMode = false;
	private boolean useBG2 = true;
	private boolean useBg2Daggers = true;
	private boolean useBg2ForWarhammer = true;

	public Config(FMLPreInitializationEvent evt) {
		this.config = new Configuration(evt.getSuggestedConfigurationFile());

		this.syncConfig();
	}

	public Configuration getConfig() {
		return this.config;
	}

	protected String getLocalKey(String ending) {
		return Utils.getLocalString(STRING_PREFIX + ending);
	}

	public boolean getMultiDragonOwnership() {
		return this.canOwnMultipleDragons;
	}

	public int getStartEntityID() {
		return this.startEntityID;
	}

	public boolean isDebugMode() {
		return this.debugMode;
	}

	public boolean isExperimental() {
		return this.experimentalMode;
	}
	
	public boolean canUseBg2() {
		return this.useBG2;
	}
	
	public boolean useBg2Daggers() {
		return this.useBg2Daggers;
	}
	
	public boolean useBg2ForWarhammer() {
		return this.useBg2ForWarhammer;
	}

	public void syncConfig() {

		this.startEntityID = this.config.getInt("DragonEntityID", Configuration.CATEGORY_GENERAL, this.startEntityID,
				-1, 255,
				"Overrides the entity ID for dragons to fix problems with manual IDs from other mods.\nSet to -1 for automatic assignment (recommended).\nWarning: wrong values may cause crashes and loss of data! Must restart Minecraft to take effect",
				this.getLocalKey("startEntityID"));
		this.canOwnMultipleDragons = this.config.getBoolean("MultiDragonOwnership", Configuration.CATEGORY_GENERAL,
				true, "Provides ability to own multiple dragons", this.getLocalKey("multiDragonOwnership"));
		this.debugMode = this.config.getBoolean("DebugMode", Configuration.CATEGORY_GENERAL, false,
				"Enable debug mode, developers recommended", this.getLocalKey("debugMode"));
		this.experimentalMode = this.config.getBoolean("ExperimentalMode", Configuration.CATEGORY_GENERAL, false,
				"Enable an experimental version (warning: may be less stable)", this.getLocalKey("experimentalMode"));
		
		this.useBG2 = this.config.getBoolean("UseBG2", Configuration.CATEGORY_GENERAL, true, "Enables the use of BG2 (if installed)", this.getLocalKey("useBG2"));
		this.useBg2Daggers = this.config.getBoolean("UseBG2Daggers", Configuration.CATEGORY_GENERAL, true, "Allows you to specifiy whether to use Battlegear 2 to replace HTTYMD dagger behavior with BG2 dagger behavior", this.getLocalKey("useBG2Daggers"));
		this.useBg2ForWarhammer  = this.config.getBoolean("UseBG2ForWarhammer", Configuration.CATEGORY_GENERAL, true, "Allows you to specifiy whether to use Battlegear 2 for HTTYMD Warhammers", this.getLocalKey("useBG2ForWarhammer"));
		
		if (this.config.hasChanged())
			this.config.save();
	}
}
