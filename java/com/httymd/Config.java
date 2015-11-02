package com.httymd;

import com.httymd.util.Utils;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class Config {

	private final Configuration config;
	private static final String STRING_PREFIX = "config.";
	private int startEntityID = -1;
	private boolean canOwnMultipleDragons = true;
	private boolean debugMode = false;
	private boolean experimentalMode = false;

	public Config(FMLPreInitializationEvent evt) {
		config = new Configuration(evt.getSuggestedConfigurationFile());

		syncConfig();
	}

	public void syncConfig() {

		startEntityID = config.getInt("DragonEntityID", Configuration.CATEGORY_GENERAL, startEntityID, -1, 255,
				"Overrides the entity ID for dragons to fix problems with manual IDs from other mods.\nSet to -1 for automatic assignment (recommended).\nWarning: wrong values may cause crashes and loss of data! Must restart Minecraft to take effect",
				getLocalKey("startEntityID"));
		canOwnMultipleDragons = config.getBoolean("MultiDragonOwnership", Configuration.CATEGORY_GENERAL, true,
				"Provides ability to own multiple dragons", getLocalKey("multiDragonOwnership"));
		debugMode = config.getBoolean("DebugMode", Configuration.CATEGORY_GENERAL, false,
				"Enable debug mode, developers recommended", getLocalKey("debugMode"));
		experimentalMode = config.getBoolean("ExperimentalMode", Configuration.CATEGORY_GENERAL, false,
				"Enable an experimental version (warning: may be less stable)", getLocalKey("experimentalMode"));

		if (config.hasChanged())
			config.save();
	}

	protected String getLocalKey(String ending) {
		return Utils.getLocalString(STRING_PREFIX + ending);
	}

	public Configuration getConfig() {
		return config;
	}

	public int getStartEntityID() {
		return startEntityID;
	}

	public boolean getMultiDragonOwnership() {
		return canOwnMultipleDragons;
	}

	public boolean isDebugMode() {
		return debugMode;
	}

	public boolean isExperimental() {
		return experimentalMode;
	}
}
