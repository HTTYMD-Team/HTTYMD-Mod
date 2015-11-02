package com.httymd.common;

import com.httymd.HTTYMDMod;
import com.httymd.entity.dragon.EntityNightFury;
import com.httymd.entity.dragon.EntitySkrill;
import com.httymd.entity.dragon.EntityTerribleTerror;
import com.httymd.event.MobEventHandler;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.item.registry.MaterialRegistry;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	private SimpleNetworkWrapper network;

	public SimpleNetworkWrapper getNetwork() {
		return network;
	}

	public void onPreInit(FMLPreInitializationEvent event) {
		MaterialRegistry.init();
		ItemRegistry.init();
	}

	public void onInit(FMLInitializationEvent evt) {
		this.registerEntities();
		this.registerHandlers();

		network = NetworkRegistry.INSTANCE.newSimpleChannel("HTTYMDChannel");
		// network.registerMessage(ControlMessageHandler.class,
		// ControlMessage.class, 0, Side.SERVER);
	}

	public void onPostInit(FMLPostInitializationEvent event) {
	}

	// Server Functions
	@SuppressWarnings("unused")
	public void onServerStarted(FMLServerStartedEvent evt) {
		MinecraftServer server = MinecraftServer.getServer();
		ServerCommandManager cmdman = (ServerCommandManager) server.getCommandManager();
	}

	public void onServerStopped(FMLServerStoppedEvent evt) {
	}
	// End Server Functions

	// Registries
	private void registerHandlers() {
		MinecraftForge.EVENT_BUS.register(new MobEventHandler());
	}

	private void registerEntities() {
		HTTYMDMod.registerEntity(EntityTerribleTerror.class, "TerribleTerror", 0x00FF00, 0x44FF44);
		HTTYMDMod.registerEntity(EntitySkrill.class, "Skrill", 0xFF0000, 0xFF4444);
		HTTYMDMod.registerEntity(EntityNightFury.class, "NightFury", 0x000000, 0x222222);
	}
	// End Registries
}
