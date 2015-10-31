package com.httymd.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public interface IDrop {

	public boolean isForEntity(EntityLivingBase entity);

	public ItemStack getDrop(EntityLivingBase entity, DamageSource source, int lootLevel, boolean recentHit, int value);
}
