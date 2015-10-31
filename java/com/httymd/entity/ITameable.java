package com.httymd.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public interface ITameable {
	
	boolean isTameable(EntityLivingBase tamer);
	
	boolean isTamed();
	
	boolean isTameItem(ItemStack item);
	
	void setTamed(boolean tame);
}
