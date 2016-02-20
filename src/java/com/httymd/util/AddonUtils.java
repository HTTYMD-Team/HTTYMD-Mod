package com.httymd.util;

import com.httymd.Config;
import com.httymd.HTTYMDMod;

import cpw.mods.fml.common.Loader;

public class AddonUtils {

	/**
	 * Contains Battlegear2 Addon Utilities
	 */
	public static class Battlegear2 {

		static Boolean isLoaded;
		public static final String modId = "battlegear2";
		
		/**
		 * Retrieves Battlegear 2's id
		 */
		public static String getModId() {
			return Battlegear2.modId;
		}

		/**
		 * Retrieves whether Battlegear 2 is installed (saves result at runtime for efficiency)
		 */
		public static boolean isInstalled() {
			if(isLoaded == null) {
				isLoaded = Loader.isModLoaded(AddonUtils.Battlegear2.getModId());
			}
			return isLoaded.booleanValue();
		}

		/**
		 * Determines whether use of Battlegear 2 daggers is required
		 * 
		 * @see Battlegear2#shouldUse()
		 * @see Config#useBg2Daggers()
		 */
		public static boolean shouldForceDaggers() {
			return Battlegear2.shouldUse() && HTTYMDMod.getConfig().useBg2Daggers();
		}

		/**
		 * Determines whether use of Battlegear 2 for Warhammers is required
		 * 
		 * @see Battlegear2#shouldUse()
		 * @see Config#useBg2ForWarhammer()
		 */
		public static boolean shouldForceWarhammer() {
			return Battlegear2.shouldUse() && HTTYMDMod.getConfig().useBg2ForWarhammer();
		}

		/**
		 * Determines whether Battlegear 2 should be used based on {@link isBg2Installed} and {@link Config#canUseBg2()}
		 * 
		 * @see isBg2Installed
		 * @see Config#canUseBg2()
		 */
		public static boolean shouldUse() {
			return HTTYMDMod.getConfig().canUseBg2() && isInstalled();
		}
	}
}
