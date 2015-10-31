package com.httymd.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public interface IShield {

	public boolean isBeingUsed(EntityLivingBase entity, ItemStack stack);

	public float getShieldRatio(ItemStack stack, DamageSource source);

	public void onStruck(EntityLivingBase entity, ItemStack stack, float fullDamage, float reducedDamage,
			DamageSource source);

}
