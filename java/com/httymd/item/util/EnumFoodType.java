package com.httymd.item.util;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.httymd.item.ItemFoodDrop;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;

public enum EnumFoodType {
	MUTTON(true, 8, 0.8F, true, EntitySheep.class),

	CRAB(false, 6, 0.6F, false), HCOMB(false, 3, 0.3F, false), FWEED(false, 5, 0.5F, false), SFLOWER(false, 1, 0.1F,
			false), DNIP(false, 2, 0.5F, false);

	/**
	 * Generates and returns a registered MultiMap for current food
	 */
	public static Multimap<EnumFoodType, Item> generateFood() {
		Multimap<EnumFoodType, Item> foods = ArrayListMultimap.create();
		for (EnumFoodType food : EnumFoodType.values()) {

			if (food.isMeat())
				foods.put(food, new ItemFoodDrop(food.toString() + "_raw", food.getHeal() / 2, food.getSatuartion() / 2,
						food.getForWolfs(), food.getDropFor()).registerItem());

			foods.put(food, new ItemFoodDrop(food.toString(), food.getHeal(), food.getSatuartion(), food.getForWolfs(),
					food.getDropFor(), food.isMeat()) {

				public boolean isForEntity(EntityLivingBase entity) {
					return super.isForEntity(entity) && entity.isBurning();
				}

			}.registerItem());
		}
		return foods;
	}

	private final boolean isMeat;
	private final int heal;
	private final float satu;
	private final boolean wolfMeat;

	private final Class<? extends EntityLivingBase> dropsFor;

	private EnumFoodType(boolean isMeat, int heal, float satu, boolean wolf) {
		this(isMeat, heal, satu, wolf, null);
	}

	private EnumFoodType(boolean isMeat, int heal, float satu, boolean wolf,
			Class<? extends EntityLivingBase> dropsFor) {
		this.isMeat = isMeat;
		this.heal = heal;
		this.satu = satu;
		this.wolfMeat = wolf;
		this.dropsFor = dropsFor;
	}

	public Class<? extends EntityLivingBase> getDropFor() {
		return this.dropsFor;
	}

	public boolean getForWolfs() {
		return this.wolfMeat;
	}

	public int getHeal() {
		return this.heal;
	}

	public float getSatuartion() {
		return this.satu;
	}

	public boolean isMeat() {
		return this.isMeat;
	}
}
