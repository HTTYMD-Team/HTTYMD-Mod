package com.httymd.util;

import java.util.ArrayList;
import java.util.Collections;

public class DragonUtils {
	private static ArrayList<String> dragonNameList = new ArrayList<String>();

	/**
	 * Retrieves a unmodifiableList of dragonNameList
	 * 
	 * @see Collections#unmodifiableList(java.util.List)
	 */
	public static ArrayList<String> getDragonList() {
		return (ArrayList<String>) Collections.unmodifiableList(dragonNameList);
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
