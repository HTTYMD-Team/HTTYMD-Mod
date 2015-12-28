package com.httymd.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

/**
 * A entity drop system (implemented in the item, called through drop events) for consistency and ease of management
 * 
 * @author George Albany
 *
 */
public interface IDrop {

	/**
	 * The ItemStack of the item entity shall give off when killed
	 * @param entity The entity killed
	 * @param source The source of killing damage
	 * @param lootLevel The loot level enchantment on the killing tool (if applicable)
	 * @param recentHit Whether death was done by hit
	 * @param value A special drop value
	 */
	public ItemStack getDrop(EntityLivingBase entity, DamageSource source, int lootLevel, boolean recentHit, int value);

	/**
	 * Whether this drop can drop for a specific entity
	 */
	public boolean isForEntity(EntityLivingBase entity);
}
