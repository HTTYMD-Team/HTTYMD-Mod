package com.httymd.client.event;

import com.httymd.client.render.RenderGlide;
import com.httymd.item.ItemGlideArmor;
import com.httymd.item.util.ItemUtils.EnumArmorType;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;

public class PlayerClientHandler {

	protected RenderGlide glideRender = null;

	protected float playerTicks = 0.0F;
	protected Entity ent = null;

	public void renderLoad() {
		if (glideRender == null) {
			glideRender = new RenderGlide();
			glideRender.setRenderManager(RenderManager.instance);
		}
	}

	@SubscribeEvent
	public void beforePlayerBodyRender(RenderPlayerEvent.Pre event) {
		renderLoad();

		playerTicks = event.partialRenderTick;
		ent = event.entityLiving;
	}

	@SubscribeEvent
	public void beforeBodyRender(RenderLivingEvent.Pre event) {
		if (!(event.entity instanceof EntityPlayer) || event.renderer == glideRender || event.entity != ent) {
			return;
		}

		ItemStack stack = null;
		for (EnumArmorType type : EnumArmorType.values()) {
			stack = event.entity.getEquipmentInSlot(type.ordinal());
			if (stack != null && stack.getItem() instanceof ItemGlideArmor)
				break;
		}
		if (stack == null || !(stack.getItem() instanceof ItemGlideArmor))
			return;
		if (((ItemGlideArmor) stack.getItem()).isGliding(stack)) {
			glideRender.doRender(event.entity, event.x, event.y + event.entity.yOffset, event.z, 0.0F, playerTicks);
			event.setCanceled(true);
		}
	}

}
