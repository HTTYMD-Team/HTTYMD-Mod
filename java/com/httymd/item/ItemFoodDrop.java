package com.httymd.item;

import com.httymd.util.EventRegistry;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;

/**
 * A dropable food class based on {@link ItemFoodExtension} and {@link IDrop}
 * 
 * @author George Albany
 *
 */
public class ItemFoodDrop extends ItemFoodExtension implements IDrop {

	protected final Class<? extends EntityLivingBase> entityToDropFor;
	protected final boolean isCooked;

	public ItemFoodDrop(String name, int heal, float satu, boolean wolf, Class<? extends EntityLivingBase> dropFrom) {
		this(name, heal, satu, wolf, dropFrom, false);
	}

	public ItemFoodDrop(String name, int heal, float satu, boolean wolf, Class<? extends EntityLivingBase> dropFrom,
			boolean isCooked) {
		super(name, heal, satu, wolf);
		this.entityToDropFor = dropFrom;
		this.isCooked = isCooked;
		if (this.entityToDropFor != null)
			EventRegistry.registerDrop(this);
	}

	public ItemStack getDrop(EntityLivingBase entity, DamageSource source, int lootLevel, boolean recentHit,
			int value) {
		if (this.isCooked && source == DamageSource.onFire || !this.isCooked && source != DamageSource.onFire)
			return new ItemStack(this,
					MathHelper.ceiling_float_int(entity.getRNG().nextFloat() + 0.2F * 3) + lootLevel);
		return null;
	}

	@Override
	public boolean isForEntity(EntityLivingBase entity) {
		return entity.getClass().equals(this.entityToDropFor);
	}

}
