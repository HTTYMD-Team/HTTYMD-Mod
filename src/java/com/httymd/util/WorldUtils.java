package com.httymd.util;

import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class WorldUtils {

	/**
	 * Determines whether it is possible to draw a straight line from rayStart
	 * to rayEnd in world
	 */
	public static boolean isTraceOpen(World world, Vec3 rayStart, Vec3 rayEnd) {
		return world.rayTraceBlocks(rayStart, rayEnd, true) == null;
	}

}
