package com.httymd.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public interface ITameable {

	/**
	 * Determines whether an entity can be tamed
	 * @param tamer The entity attempting to tame
	 * @param item The item being used to tame 
	 */
	boolean canTame(EntityLivingBase tamer, ItemStack item);

	/**
	 * Determines whether this entity is tamed
	 */
	boolean isTamed();

	/**
	 * Sets whether an entity is tamed or not
	 */
	void setTamed(boolean tame);
}
