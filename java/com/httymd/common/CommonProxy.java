package com.httymd.common;

import com.httymd.HTTYMDMod;
import com.httymd.block.registry.BlockRegistry;
import com.httymd.common.network.PlyJumpMessage;
import com.httymd.entity.dragon.EntityNadder;
import com.httymd.entity.dragon.EntityNightFury;
import com.httymd.entity.dragon.EntitySkrill;
import com.httymd.entity.dragon.EntityTerribleTerror;
import com.httymd.event.ForgeEventHandler;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.item.registry.MaterialRegistry;
import com.httymd.item.registry.WorldItemRegistry;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	private SimpleNetworkWrapper network;

	/**
	 * Retrieves {@link SimpleNetworkWrapper} of this proxy
	 */
	public SimpleNetworkWrapper getNetwork() {
		return this.network;
	}

	public void onInit(FMLInitializationEvent evt) {
		this.registerEntities();
		this.registerHandlers();

		this.network = NetworkRegistry.INSTANCE.newSimpleChannel(HTTYMDMod.ID+"Channel");
		this.network.registerMessage(PlyJumpMessage.PlyJumpMsgHandler.class, PlyJumpMessage.class, 0, Side.SERVER);
	}

	public void onPostInit(FMLPostInitializationEvent event) {
	}

	public void onPreInit(FMLPreInitializationEvent event) {
		MaterialRegistry.init();
		ItemRegistry.init();
		BlockRegistry.init();
		WorldItemRegistry.init();
	}

	///////////////////////////////////////
	// Server Functions
	///////////////////////////////////////
	public void onServerStarted(FMLServerStartedEvent evt) {
		MinecraftServer server = MinecraftServer.getServer();
		server.getCommandManager();
	}

	public void onServerStopped(FMLServerStoppedEvent evt) {
	}
	///////////////////////////////////////
	// End Server Functions
	///////////////////////////////////////
	
	private void registerEntities() {
		HTTYMDMod.registerEntity(EntityTerribleTerror.class, "TerribleTerror", 0x00FF00, 0x44FF44);
		HTTYMDMod.registerEntity(EntitySkrill.class, "Skrill", 0xFF0000, 0xFF4444);
		HTTYMDMod.registerEntity(EntityNightFury.class, "NightFury", 0x000000, 0x222222);
		// HTTYMDMod.registerEntity(EntityNightmare.class, "MountrousNightmare", 0xE3172F, 0x000000);
		HTTYMDMod.registerEntity(EntityNadder.class, "DeadlyNadder", 0x1B99BF, 0xE3E017);
	}
	
	protected void registerHandlers() {
		MinecraftForge.EVENT_BUS.register(new ForgeEventHandler());
	}
}
