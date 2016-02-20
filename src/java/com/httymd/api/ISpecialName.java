package com.httymd.api;

import net.minecraft.entity.EntityLivingBase;

public interface ISpecialName {

	/**
	 * Retrieves the unlocalized name from entity and current name
	 * 
	 * @param entity
	 *            The entity whose name is changing
	 * @param currentName
	 *            The current name of the entity
	 */
	public String get(EntityLivingBase entity, String currentName);

}
