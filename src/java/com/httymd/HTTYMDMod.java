package com.httymd;

import java.io.File;

import net.minecraft.entity.Entity;

import org.apache.logging.log4j.Logger;

import com.httymd.common.CommonProxy;
import com.httymd.creativetab.CreativeTab;
import com.httymd.stats.StatListMod;
import com.httymd.util.AddonUtils.Battlegear2;
import com.httymd.util.EntityUtils;

import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = HTTYMDMod.ID, name = HTTYMDMod.NAME, guiFactory = HTTYMDMod.GUIFACORY, dependencies = "after:"
		+ Battlegear2.modId)
public class HTTYMDMod {
	
	//////////////////////////////////////////////////////
	// Constant Identifier Variables
	//////////////////////////////////////////////////////
	public static final String CLIENT_PROXY = "com.httymd.client.ClientProxy";
	public static final String SERVER_PROXY = "com.httymd.server.ServerProxy";
	public static final String COMMON_PROXY = "com.httymd.common.CommonProxy";
	public static final String GUIFACORY = "com.httymd.client.GuiFactoryDragons";
	public static final String ID = "httymd";
	public static final String NAME = "HTTYMD";
	//////////////////////////////////////////////////////
	// End Constant Identifier Variables
	//////////////////////////////////////////////////////

	@Instance(ID)
	public static HTTYMDMod INSTANCE;
	
	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	public static CommonProxy proxy;
	
	private Config config;
	private File configDirectory;
	private Logger log;
	private ModMetadata metadata;

	/**
	 * Retrieves the config for the mod
	 */
	public static Config getConfig() {
		return INSTANCE.config;
	}
	
	/**
	 * Retrieves the config directory {@link File}
	 */
	public static File getConfigDirectory() {
		return INSTANCE.configDirectory;
	}

	/**
	 * Retrieves the mod Creative Tab instance
	 */
	public static CreativeTab getCreativeTab() {
		return CreativeTab.DRAGON_TAB;
	}

	/**
	 * Retrieves the mod's logger
	 */
	public static Logger getLogger() {
		return INSTANCE.log;
	}

	/**
	 * Retrieves the mod's metadata object
	 */
	public static ModMetadata getMetadata() {
		return INSTANCE.metadata;
	}

	public static void registerEntity(Class<? extends Entity> entityClass, String entityName, int solidColor,
			int spotColor) {
		EntityUtils.createEntity(entityClass, entityName, solidColor, spotColor);
	}

	@EventHandler
	public void modInit(FMLInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(this);
		proxy.onInit(event);
	}

	@EventHandler
	public void modPostInit(FMLPostInitializationEvent event) {
		proxy.onPostInit(event);
	}

	@EventHandler
	public void modPreInit(FMLPreInitializationEvent event) {
		this.log = event.getModLog();
		this.configDirectory = event.getModConfigurationDirectory();
		this.config = new Config(event);
		this.metadata = event.getModMetadata();
		proxy.onPreInit(event);
		StatListMod.registerStats(); // Guarantees stats register with all information (not used yet)
	}

	@SubscribeEvent
	public void onConfigChanged(OnConfigChangedEvent eventArgs) {
		if (eventArgs.modID.equals(ID))
			this.config.syncConfig();
	}

	@EventHandler
	public void onServerStarted(FMLServerStartedEvent evt) {
		proxy.onServerStarted(evt);
	}

	@EventHandler
	public void onServerStopped(FMLServerStoppedEvent evt) {
		proxy.onServerStopped(evt);
	}
}
