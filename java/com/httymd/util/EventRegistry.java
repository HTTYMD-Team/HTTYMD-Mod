package com.httymd.util;

import java.util.ArrayList;
import java.util.Collections;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

import com.httymd.item.IDrop;
import com.httymd.item.IShield;

public class EventRegistry {
	private static ArrayList<IDrop> drops = new ArrayList<IDrop>();

	public static IShield getActiveShieldFor(EntityLivingBase entity) {
		ItemStack is = entity.getHeldItem();
		if (is != null && is.getItem() instanceof IShield && ((IShield) is.getItem()).isBeingUsed(entity, is)) {
			return (IShield) is.getItem();
		}

		return null;
	}

	public static void registerDrop(IDrop drop) {
		drops.add(drop);
	}

	public static ArrayList<IDrop> getDropsFor(EntityLivingBase entity) {
		ArrayList<IDrop> dropList = new ArrayList<IDrop>();

		for (IDrop d : drops) {
			if (d.isForEntity(entity))
				dropList.add(d);
		}

		return dropList;
	}

	public static ArrayList<ItemStack> handleDropStacks(EntityLivingBase entity, DamageSource source, int lootLevel,
			boolean recentHit, int value) {
		ArrayList<ItemStack> stacks = new ArrayList<ItemStack>();

		for (IDrop d : getDropsFor(entity)) {
			stacks.add(d.getDrop(entity, source, lootLevel, recentHit, value));
		}

		stacks.removeAll(Collections.singleton(null));

		return stacks;
	}

}
