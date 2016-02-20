package com.httymd.util;

import java.io.File;

import org.apache.logging.log4j.Logger;

import com.httymd.Config;
import com.httymd.HTTYMDMod;

public class ModUtils {

	/**
	 * Shorthand for {@link Config#isDebugMode() HTTYMDMod.getConfig().isDebugMode()}
	 */
	public static boolean isDebug() {
		return HTTYMDMod.getConfig().isDebugMode();
	}

	/**
	 * Shorthand for {@link Config#isExperimental() HTTYMDMod.getConfig().isExperimental()}
	 */
	public static boolean isExperimental() {
		return HTTYMDMod.getConfig().isExperimental();
	}

	/**
	 * Guarantees proper retrieval of config directory
	 * @see HTTYMDMod#getConfigDirectory()
	 */
	public static File getConfigDirectory() {
		return HTTYMDMod.getConfigDirectory();
	}

	/**
	 * Shorthand for {@link HTTYMDMod#getLogger()}
	 */
	public static Logger getLogger() {
		return HTTYMDMod.getLogger();
	}

}
