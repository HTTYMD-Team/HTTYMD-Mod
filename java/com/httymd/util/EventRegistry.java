package com.httymd.util;

import java.util.ArrayList;
import java.util.Collections;

import com.httymd.api.item.IDrop;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class EventRegistry {
	private static ArrayList<IDrop> drops = new ArrayList<IDrop>();

	public static ArrayList<IDrop> getDropsFor(EntityLivingBase entity) {
		ArrayList<IDrop> dropList = new ArrayList<IDrop>();
		for (IDrop d : drops)
			if (d.isForEntity(entity))
				dropList.add(d);
		return dropList;
	}

	public static ArrayList<ItemStack> handleDropStacks(EntityLivingBase entity, DamageSource source, int lootLevel,
			boolean recentHit, int value) {
		ArrayList<ItemStack> stacks = new ArrayList<ItemStack>();

		for (IDrop d : getDropsFor(entity))
			stacks.add(d.getDrop(entity, source, lootLevel, recentHit, value));

		stacks.removeAll(Collections.singleton(null));

		return stacks;
	}

	public static void registerDrop(IDrop drop) {
		drops.add(drop);
	}

}
