package com.httymd.api.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * An interface for Dragon Abilities
 * 
 * @author George Albany
 *
 */
public interface IDragonAbility {

	/**
	 * Performs an ability start
	 * 
	 * @param world
	 *            World the ability starts in
	 * @param pos
	 *            Position the ability starts
	 * @param rot
	 *            Rotation the ability faces
	 * @param user
	 *            The Ability user
	 */
	public void onStartUse(World world, Vec3 pos, Vec3 rot, Entity user);

	/**
	 * Runs when an ability is ending
	 * 
	 * @param world
	 *            World the ability ended in
	 * @param pos
	 *            Position the ability ended at
	 */
	public void onEndUseDuration(World world, Vec3 pos);

	/**
	 * Retrieves the duration of the ability
	 */
	public int getDuration();

}