package com.httymd.item;

import net.minecraft.item.ItemStack;

public interface IToggleable {

	void onToggle(ItemStack stack, boolean toggle);

	boolean isToggled(ItemStack stack);

}
