package com.httymd.client.event;

import com.httymd.client.render.RenderGlide;
import com.httymd.item.ItemGlideArmor;
import com.httymd.util.Utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerClientHandler {

	protected RenderGlide glideRender = null;

	protected float playerTicks = 0.0F;
	protected Entity ent = null;

	public void renderLoad() {
		if (glideRender == null) {
			glideRender = new RenderGlide();
		}
	}

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
				this.glideRender.doRender(event.entity, event.x, event.y + event.entity.getYOffset(), event.z, 0.0F,
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

}
