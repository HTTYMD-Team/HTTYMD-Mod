package com.httymd.util;

import com.httymd.HTTYMDMod;

import net.minecraft.util.StatCollector;

public final class StringUtils {

	/**
	 * Retrieves a localized string (using HTTYMDMod.ID) from an unlocalized
	 * string
	 */
	public static String getLocalString(String unlocalized) {
		return StatCollector.translateToLocal(StringUtils.getModString(unlocalized));
	}

	public static String getModString(String string) {
		return HTTYMDMod.ID + ":" + string;
	}

}
