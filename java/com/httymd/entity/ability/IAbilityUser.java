package com.httymd.entity.ability;

import net.minecraft.util.Vec3;

public interface IAbilityUser {
	
	/**
	 * An ability used by an {@link IAbiltiyUser}
	 * @param start The starting position of the ability
	 * @param rotations The rotations (for the spawned entity)
	 * @return The ability to run
	 */
	public IAbility onAbilityUse(Vec3 start, Vec3 rotations);
	
}
