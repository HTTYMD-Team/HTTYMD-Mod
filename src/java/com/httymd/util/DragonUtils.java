package com.httymd.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DragonUtils {
	
	private static ArrayList<String> dragonNameList = new ArrayList<String>();

	/**
	 * Retrieves a unmodifiableList of dragonNameList
	 * 
	 * @see Collections#unmodifiableList(java.util.List)
	 */
	public static List<String> getDragonList() {
		return Collections.unmodifiableList(dragonNameList);
	}

	/**
	 * Registers Dragon names
	 * 
	 * @param name
	 *            Name to register
	 */
	public static void registerDragonName(String name) {
		dragonNameList.add(name);
	}

}
