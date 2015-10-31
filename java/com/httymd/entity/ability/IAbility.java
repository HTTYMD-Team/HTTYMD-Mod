package com.httymd.entity.ability;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;

public interface IAbility {
	
	/**
	 * Retrieves current position
	 */
	public Vec3 getPosition();
	
	/**
	 * Retrieves current rotation
	 */
	public Vec3 getRotation();
	
	/**
	 * A routine to run upon the ability's start
	 * @param user The user that started this ability
	 * @return An entity to spawn
	 */
	public Entity onStart(IAbilityUser user);
	
	/**
	 * A routine to run upon the ability's stop
	 * @param user The user that started this ability
	 */
	public void onEnd(IAbilityUser user);
	
}
