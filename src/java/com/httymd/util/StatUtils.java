package com.httymd.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.StatBase;

public class StatUtils {

	/**
	 * Adds a value to a statistic field
	 *
	 * @return whether execution succeeded
	 */
	public static boolean addStat(Entity entity, StatBase stat, int value) {
		if (!(entity instanceof EntityPlayerMP))
			return false;
		((EntityPlayerMP) entity).addStat(stat, value);
		return true;
	}

	/**
	 * Retrieves the statistic value for a StatBase field
	 */
	public static int getPlayerStat(EntityPlayerMP player, StatBase stat) {
		if (player == null || stat == null)
			return 0;
		return player.func_147099_x().writeStat(stat);
	}

	/**
	 * Determines whether the player has retrieved a certain value or more in
	 * specific StatBase field
	 */
	public static boolean hasPlayerGained(EntityPlayerMP player, StatBase stat, int amount) {
		return getPlayerStat(player, stat) >= amount;
	}
	
}
