package com.httymd.api.entity;

import net.minecraft.entity.Entity;

/**
 * An Interface for selective rideable entities
 * 
 * @author George Albany
 *
 */
public interface IRideable extends ITameable {

	/**
	 * Whether this IRideable can be ridden by a rider entity
	 * 
	 * @param rider
	 *            The entity that is attempting to ride
	 */
	public boolean isRideable(Entity rider);

	/**
	 * Returns whether this IRideable is being riden
	 */
	public boolean isRidden();
}
