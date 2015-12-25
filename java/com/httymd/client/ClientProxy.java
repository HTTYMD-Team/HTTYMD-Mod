package com.httymd.client;

import com.httymd.client.event.PlayerClientHandler;
import com.httymd.client.model.dragon.ModelNightFury;
import com.httymd.client.model.dragon.ModelSkrill;
import com.httymd.client.model.dragon.ModelTerribleTerror;
import com.httymd.client.render.dragon.RenderNightFury;
import com.httymd.client.render.dragon.RenderSkrill;
import com.httymd.client.render.dragon.RenderTerribleTerror;
import com.httymd.client.util.KeyInputHandler;
import com.httymd.common.CommonProxy;
import com.httymd.entity.dragon.EntityNightFury;
import com.httymd.entity.dragon.EntitySkrill;
import com.httymd.entity.dragon.EntityTerribleTerror;
import com.httymd.event.KeyPressEventHandler;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	public static KeyInputHandler keybindHandler;

	@Override
	public void onInit(FMLInitializationEvent evt) {
		super.onInit(evt);
		this.registerEntityRendering();
		this.registerItemRendering();

		keybindHandler = new KeyInputHandler(this.getNetwork());

		MinecraftForge.EVENT_BUS.register(new PlayerClientHandler());
	}

	private void registerEntityRendering() {
		// RenderingRegistry.registerEntityRenderingHandler(EntityGronkle.class, new RenderGronkle(new ModelGronkle(), 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityNightFury.class, new RenderNightFury(new ModelNightFury(), 2));
		// RenderingRegistry.registerEntityRenderingHandler(EntityNightmare.class, new RenderNightmare(new ModelNightmare(), 1));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkrill.class, new RenderSkrill(new ModelSkrill(), 2));
		RenderingRegistry.registerEntityRenderingHandler(EntityTerribleTerror.class, new RenderTerribleTerror(new ModelTerribleTerror(), 1));
		// RenderingRegistry.registerEntityRenderingHandler(EntityZippleback.class, new RenderZippleback(new ModelZippleback(), 1));
	}

	private void registerItemRendering() {
		// MinecraftForgeClient.registerItemRenderer(ItemRegistry.zippleGasContainer, new RenderItemContainer());
		// empty for 1.8 compat
	}
	
	protected void registerHandlers() {
		super.registerHandlers();
		FMLCommonHandler.instance().bus().register(new KeyPressEventHandler());
	}
}
