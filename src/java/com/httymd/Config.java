package com.httymd;

import java.util.HashMap;

import com.httymd.entity.EntityTameableFlying;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.config.Configuration;

/**
 * Configuration Management class of the HTTYMD Mod
 * 
 * @author George Albany
 *
 */
public class Config {

	public static String CATEGORYS[] = {"dragons", "testing", "bg2"};
	private static final String STRING_PREFIX = "config."+HTTYMDMod.ID+":";
	
	static {
		for(int i = 0; i < CATEGORYS.length; i++)
			CATEGORYS[i] = STRING_PREFIX+"category."+CATEGORYS[i];
	}
	
	private final Configuration config;
	private int startEntityID = -1;
	/////////////////
	// Dragons Cat
	/////////////////
	private boolean verticalDragonRiding = true;
	private boolean canOwnMultipleDragons = true;
	private boolean feedHealsDragons = true;
	private String forcedTameable = "";
	/////////////////
	// Testing Cat
	/////////////////
	private boolean debugMode;
	private boolean experimentalMode;
	/////////////////
	// BG2 Cat
	/////////////////
	private boolean useBG2 = true;
	private boolean useBg2Daggers = true;
	private boolean useBg2ForWarhammer = true;
	
	private HashMap<Class<? extends EntityLivingBase>, Boolean> forcedTameCache = new HashMap<Class<? extends EntityLivingBase>, Boolean>();

	public Config(FMLPreInitializationEvent evt) {
		this.config = new Configuration(evt.getSuggestedConfigurationFile());

		this.syncConfig();
	}

	/**
	 * Retrieves the Forge {@link Configuration}
	 */
	public Configuration getConfig() {
		return this.config;
	}

	protected String getLocalKey(String ending) {
		return STRING_PREFIX + ending;
	}
	
	/**
	 * Determines whether vertical climbing is based on pitch on dragons
	 */
	public boolean getVerticalDragonRiding() {
		return this.verticalDragonRiding;
	}

	/**
	 * Determines whether someone may own multiple dragons (may fade out with tame system)
	 */
	public boolean getMultiDragonOwnership() {
		return this.canOwnMultipleDragons;
	}

	/**
	 * Originally would determine start entity Id for dragons
	 * @deprecated Does nothing
	 */
	@Deprecated
	public int getStartEntityID() {
		return this.startEntityID;
	}

	/**
	 * Whether a developer debug mode is enabled
	 */
	public boolean isDebugMode() {
		return this.debugMode;
	}

	/**
	 * Whether the experimental mode is enabled
	 */
	public boolean isExperimental() {
		return this.experimentalMode;
	}
	
	/**
	 * Whether to use Battlegear 2 alongside HTTYMD
	 * @return
	 */
	public boolean canUseBg2() {
		return this.useBG2;
	}
	
	/**
	 * Whether HTTYMD Daggers act as Battlegear 2 daggers
	 */
	public boolean useBg2Daggers() {
		return this.useBg2Daggers;
	}
	
	/**
	 * Whether HTTYMD Warhammers use Battlegear 2
	 */
	public boolean useBg2ForWarhammer() {
		return this.useBg2ForWarhammer;
	}
	
	/**
	 * Whether an entity is tameable due to the tame system in place (note: will change)
	 * @param tameable The entity to check
	 */
	public boolean isTameable(EntityTameableFlying tameable) {
		Boolean result = this.forcedTameCache.get(tameable.getClass());
		if(result != null) return result.booleanValue();
		String name = EntityList.getEntityString(tameable).replace(" ", "").replace(HTTYMDMod.ID+".", "").toLowerCase();
		String checkStr = this.forcedTameable.replace(" ", "").toLowerCase();
		result = checkStr.indexOf(name) != -1;
		this.forcedTameCache.put(tameable.getClass(), result);
		return result;
	}
	
	/**
	 * Whether feeding a dragon food may heal them
	 */
	public boolean canFeedHeal() {
		return this.feedHealsDragons;
	}

	public void syncConfig() {

		/*this.startEntityID = this.config.getInt("DragonEntityID", Configuration.CATEGORY_GENERAL, this.startEntityID, -1, 255,
				"Overrides the entity ID for dragons to fix problems with manual IDs from other mods.\nSet to -1 for automatic assignment (recommended).\nWarning: wrong values may cause crashes and loss of data! Must restart Minecraft to take effect",
				this.getLocalKey("startEntityID"));*/
		
		String cat = Configuration.CATEGORY_GENERAL;
		
		cat = CATEGORYS[0];
		this.verticalDragonRiding = this.config.getBoolean("Vertical Riding", cat, true, "Enable the vertical climb when riding by looking up or down", this.getLocalKey("verticalDragonRiding"));
		this.canOwnMultipleDragons = this.config.getBoolean("Multi Ownership", cat, true, "Provides ability to own multiple dragons", this.getLocalKey("multiOwn"));
		this.feedHealsDragons = this.config.getBoolean("Feed Heals", cat, true, "Determines whether feeding dragons heals them", this.getLocalKey("feedHeals"));
		this.forcedTameable = this.config.getString("Force Tameable", cat, "", "A list of entity names which are forced to be tameable (seperator may be anything ths isn't a space)", this.getLocalKey("forcedTameable"));
		
		cat = CATEGORYS[1];
		this.debugMode = this.config.getBoolean("Debug Mode", cat, false, "Enable debug mode, developers recommended", this.getLocalKey("debugMode"));
		this.experimentalMode = this.config.getBoolean("Experimental Mode", cat, false, "Enable an experimental version (warning: may be less stable)", this.getLocalKey("experimentalMode"));
		
		cat = CATEGORYS[2];
		this.useBG2 = this.config.getBoolean("Use BG2", cat, true, "Enables the use of BG2 (if installed)", this.getLocalKey("useBG2"));
		this.useBg2Daggers = this.config.getBoolean("Use BG2 Daggers", cat, true, "Allows you to specifiy whether to use Battlegear 2 to replace HTTYMD dagger behavior with BG2 dagger behavior", this.getLocalKey("useBg2Daggers"));
		this.useBg2ForWarhammer  = this.config.getBoolean("Use BG2 Warhammers", cat, true, "Allows you to specifiy whether to use Battlegear 2 for HTTYMD Warhammers", this.getLocalKey("useBg2ForWarhammer"));
		
		if (this.config.hasChanged())
			this.config.save();
	}
}
