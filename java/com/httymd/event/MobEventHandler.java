package com.httymd.event;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;

import com.httymd.item.IShield;
import com.httymd.util.EventRegistry;
import com.httymd.util.NameManager;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MobEventHandler {

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEvent(LivingDropsEvent event) {
		for (ItemStack stack : EventRegistry.handleDropStacks(event.entityLiving, event.source, event.lootingLevel,
				event.recentlyHit, event.specialDropValue)) {
			event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY,
					event.entity.posZ, stack));
		}
	}

	@SubscribeEvent
	public void onEvent(LivingHurtEvent event) {
		IShield s = EventRegistry.getActiveShieldFor(event.entityLiving);
		ItemStack stack = event.entityLiving.getHeldItem();
		if (s != null && stack != null) {
			float newDamage = s.getShieldRatio(stack, event.source) * event.ammount;
			s.onStruck(event.entityLiving, stack, event.ammount, newDamage, event.source);
			event.ammount = newDamage;
		}
	}

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEvent(NameFormat event) {
		event.displayname = NameManager.getInstance().getDisplayName(event.entityLiving, event.username);
	}
}
