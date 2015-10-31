package com.httymd.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

import com.httymd.util.EventRegistry;

public class ItemFoodDrop extends ItemFoodExtension implements IDrop {

	protected final Class<? extends EntityLivingBase> entityToDropFor;

	public ItemFoodDrop(String name, int heal, float satu, boolean wolf, Class<? extends EntityLivingBase> dropFrom) {
		super(name, heal, satu, wolf);
		this.entityToDropFor = dropFrom;
		if (this.entityToDropFor != null) {
			EventRegistry.registerDrop(this);
		}
	}
	
	public ItemStack getDrop(EntityLivingBase entity, DamageSource source, int lootLevel, boolean recentHit, int value) {
		return new ItemStack(this, (int) (entity.getRNG().nextFloat() * lootLevel * 3));
	}

	@Override
	public boolean isForEntity(EntityLivingBase entity) {
		return entity.getClass() == entityToDropFor;
	}

}
