package com.httymd.entity;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;

public interface ITrustable {

	/**
	 * Retrieves the level of trust from this entity for specific entities, some
	 * actions are able to increase this while others decrease it, determines
	 * how it reacts to you
	 * 
	 * @param entityLiving
	 *            The entity to trust
	 */
	public int getTrustLevelFor(EntityLivingBase entityLiving);

	public List<EntityLivingBase> getEnemyEntities();

	public int getEnemyThreshold();

}
