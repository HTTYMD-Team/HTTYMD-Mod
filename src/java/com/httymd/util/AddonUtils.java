package com.httymd.util;

import java.util.HashMap;
import java.util.Map;

import com.httymd.Config;
import com.httymd.HTTYMDMod;

import cpw.mods.fml.common.Loader;

public final class AddonUtils {

	/**
	 * A extendible utility class for determining mod accessibility
	 * 
	 * @author George Albany
	 *
	 */
	public static abstract class ModUtil {
		
		private static Map<String, Boolean> isLoadedMap = new HashMap<String, Boolean>();
		
		/**
		 * Retrieves mod id
		 */
		public String getId() { return ""; }
		
		/**
		 * Returns whether mod is installed
		 */
		public final boolean isInstalled() {
			if(getId().isEmpty()) return false;
			if(isLoadedMap.get(getId()) == null) {
				isLoadedMap.put(getId(), Loader.isModLoaded(getId()));
			}
			return isLoadedMap.get(getId()) == Boolean.TRUE;
		}
	}
	
	/**
	 * Contains Battlegear2 Addon Utilities
	 */
	public static final class Battlegear2 extends ModUtil {
		
		public static final String modId = "battlegear2";
		public static final Battlegear2 INSTANCE = new Battlegear2();
		
		private Battlegear2() {}
		
		/**
		 * Retrieves Battlegear 2's id
		 */
		public static String getModId() {
			return INSTANCE.getId();
		}
		
		@Override
		public String getId() {
			return Battlegear2.modId;
		}

		/**
		 * Determines whether use of Battlegear 2 daggers is required
		 * 
		 * @see Battlegear2#shouldUse()
		 * @see Config#useBg2Daggers()
		 */
		public static boolean shouldForceDaggers() {
			return shouldUse() && HTTYMDMod.getConfig().useBg2Daggers();
		}

		/**
		 * Determines whether use of Battlegear 2 for Warhammers is required
		 * 
		 * @see Battlegear2#shouldUse()
		 * @see Config#useBg2ForWarhammer()
		 */
		public static boolean shouldForceWarhammer() {
			return shouldUse() && HTTYMDMod.getConfig().useBg2ForWarhammer();
		}

		/**
		 * Determines whether Battlegear 2 should be used based on {@link isBg2Installed} and {@link Config#canUseBg2()}
		 * 
		 * @see isBg2Installed
		 * @see Config#canUseBg2()
		 */
		public static boolean shouldUse() {
			return HTTYMDMod.getConfig().canUseBg2() && INSTANCE.isInstalled();
		}
	}
}
