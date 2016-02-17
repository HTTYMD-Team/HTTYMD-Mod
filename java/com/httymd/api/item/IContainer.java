package com.httymd.api.item;

import com.httymd.api.entity.DragonProductType;

import net.minecraft.item.ItemStack;

public interface IContainer {

	public int getMax();
	
	public int getContained(ItemStack stack);
	
	public void setContained(ItemStack stack, int contents);
	
	public void setContainedType(ItemStack stack, DragonProductType type);
	
	public DragonProductType getContainedType(ItemStack stack);
	
	public void resetContained(ItemStack stack);
	
	public ItemStack createEmptyStack();	
}
