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

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	public static KeyInputHandler keybindHandler;

	@Override
	public void onInit(FMLInitializationEvent evt) {
		super.onInit(evt);
		this.registerRendering();

		keybindHandler = new KeyInputHandler(getNetwork());

		MinecraftForge.EVENT_BUS.register(new PlayerClientHandler());
	}

	private void registerRendering() {
		// RenderingRegistry.registerEntityRenderingHandler(EntityGronkle.class,
		// new RenderGronkle(new ModelGronkle(), 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityNightFury.class,
				new RenderNightFury(new ModelNightFury(), 2));
		// RenderingRegistry.registerEntityRenderingHandler(EntityNightmare.class,
		// new RenderNightmare(new ModelNightmare(), 1));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkrill.class, new RenderSkrill(new ModelSkrill(), 2));
		RenderingRegistry.registerEntityRenderingHandler(EntityTerribleTerror.class,
				new RenderTerribleTerror(new ModelTerribleTerror(), 1));
		// RenderingRegistry.registerEntityRenderingHandler(EntityZippleback.class,
		// new RenderZippleback(new ModelZippleback(), 1));
		// MinecraftForgeClient.registerItemRenderer(ItemRegistry.zippleGasContainer,
		// new RenderItemContainer());
	}
}
