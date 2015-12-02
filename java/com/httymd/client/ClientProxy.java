package com.httymd.client;

import java.util.Iterator;
import java.util.Map.Entry;

import com.httymd.HTTYMDMod;
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
import com.httymd.item.registry.ItemRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

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
		ItemModelMesher m = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		Iterator<Entry<String, Item>> it = ItemRegistry.itemRegistry.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Item> e = it.next();
			m.register(e.getValue(), 0, new ModelResourceLocation(HTTYMDMod.ID + ":" + e.getKey(), "inventory"));
		}

		// MinecraftForgeClient.registerItemRenderer(ItemRegistry.zippleGasContainer, new RenderItemContainer());
	}
}
