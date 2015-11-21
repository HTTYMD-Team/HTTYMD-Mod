package com.httymd.client.event;

import com.httymd.client.render.RenderGlide;
import com.httymd.item.ItemGlideArmor;
import com.httymd.util.Utils;

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

	@SubscribeEvent
	public void beforeBodyRender(RenderLivingEvent.Pre event) {
		if (!(event.entity instanceof EntityPlayer) || event.renderer == this.glideRender || event.entity != this.ent)
			return;
		ItemStack stack = Utils.getArmor(event.entity, 2);
		if (stack == null)
			return;
		ItemGlideArmor armor = stack.getItem() instanceof ItemGlideArmor ? (ItemGlideArmor) stack.getItem() : null;
		if (armor != null)
			if (armor.isGliding(stack)) {
				this.glideRender.doRender(event.entity, event.x, event.y + event.entity.yOffset, event.z, 0.0F,
						this.playerTicks);
				event.setCanceled(true);
			}
	}

	@SubscribeEvent
	public void beforePlayerBodyRender(RenderPlayerEvent.Pre event) {
		this.renderLoad();

		this.playerTicks = event.partialRenderTick;
		this.ent = event.entityLiving;
	}

	public void renderLoad() {
		if (this.glideRender == null) {
			this.glideRender = new RenderGlide();
			this.glideRender.setRenderManager(RenderManager.instance);
		}
	}

}
