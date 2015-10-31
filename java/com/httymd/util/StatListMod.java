package com.httymd.util;

import java.util.HashMap;
import java.util.Iterator;

import com.httymd.HTTYMDMod;

import net.minecraft.stats.StatBase;
import net.minecraft.util.ChatComponentTranslation;

public class StatListMod {

	protected static String startSection = HTTYMDMod.ID + ":stat.";
	protected static String[] endSection = {
			"dragonOneCm",
			"Ridden"
	};
	
	/** Records the dragons ridden by dragon names (the names are lower-case and have no spaces) */
	public static HashMap<String, StatBase> dragonsRidden;
	/** Records the distance traveled on tamed dragons */
	public static StatBase distanceByDragon = (new StatBase(startSection+endSection[0], new ChatComponentTranslation(startSection+endSection[0]))).initIndependentStat().registerStat();
	
	public static void registerStats() {
		registerDragonsRidden();
	}
	
	private static void registerDragonsRidden() {
		Iterator<String> dragonIt = HTTYMDMod.getDragonList().iterator();
		
		while(dragonIt.hasNext()) {
			String dragonName = dragonIt.next();
			String name = startSection+dragonName+endSection[endSection.length-1];
			
			dragonsRidden.put(dragonName.toLowerCase(), new StatBase(name, new ChatComponentTranslation(name)).initIndependentStat().registerStat());
		}
	}
}
