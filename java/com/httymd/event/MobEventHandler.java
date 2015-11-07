package com.httymd.event;

import com.httymd.entity.EntityDragon;
import com.httymd.item.IShield;
import com.httymd.util.EventRegistry;
import com.httymd.util.NameManager;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;

public class MobEventHandler {

	/**
	 * Handles and manipulates registered drops according to current system
	 */
	@SubscribeEvent
	public void onEvent(LivingDropsEvent event) {
		for (ItemStack stack : EventRegistry.handleDropStacks(event.entityLiving, event.source, event.lootingLevel,
				event.recentlyHit, event.specialDropValue)) {
			event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY,
					event.entity.posZ, stack));
		}
	}

	/**
	 * Currently enables dragons to jump if the rider tries to jump
	 */
	@SubscribeEvent
	public void onEvent(LivingEvent.LivingJumpEvent event) {
		if (event.entityLiving.ridingEntity instanceof EntityDragon) {
			EntityDragon dragon = (EntityDragon) event.entityLiving.ridingEntity;
			if (dragon.isRideableBy(event.entityLiving))
				dragon.getJumpHelper().doJump();
		}
	}

	/**
	 * Handles shield system (not currently in use)
	 */
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

	/**
	 * Reformats a player's name based on our current naming system
	 */
	@SubscribeEvent
	public void onEvent(NameFormat event) {
		event.displayname = NameManager.getInstance().getDisplayName(event.entityLiving, event.username);
	}
}
