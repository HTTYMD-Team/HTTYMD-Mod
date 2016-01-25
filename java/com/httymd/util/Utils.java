package com.httymd.util;

import java.util.UUID;

import org.apache.logging.log4j.Logger;

import com.httymd.Config;
import com.httymd.HTTYMDMod;

import cpw.mods.fml.common.Loader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Utils {
	public static final double GRAVITY_FORCE = 0.6d;
	private static Boolean isBG2Loaded;
	public static final String bg2Id = "battlegear2";
	
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
	 * Removes (consumes) an Item inside an entity's inventory (provides
	 * consistency for entities, currently only for players).
	 *
	 * @return whether removal was possible
	 */
	public static boolean consumeItem(EntityLivingBase entity, Item item) {
		if (entity instanceof EntityPlayer)
			return ((EntityPlayer) entity).inventory.consumeInventoryItem(item);

		return false;
	}

	/**
	 * Retrieves an entity by its UUID (fails if the entity was not loaded from
	 * file)
	 */
	public static Entity getEntityByUUID(UUID uniqueId, World world) {
		for (Object o : world.getLoadedEntityList()) {
			Entity e = o instanceof Entity ? (Entity) o : null;
			if (e != null && e.getPersistentID() == uniqueId)
				return e;
		}

		return null;
	}

	/**
	 * Retrieves a localized string (using HTTYMDMod.ID) from an unlocalized
	 * string
	 */
	public static String getLocalString(String unlocalized) {
		return StatCollector.translateToLocal(getModString(unlocalized));
	}

	public static String getModString(String string) {
		return HTTYMDMod.ID + ":" + string;
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
	 * Retrieves whether a specific item exists in a entity's inventory
	 * (provides consistency for entities, currently only for players).
	 */
	public static boolean hasItem(EntityLivingBase entity, Item item) {
		if (entity instanceof EntityPlayer)
			return ((EntityPlayer) entity).inventory.hasItem(item);

		return false;
	}

	/**
	 * Determines whether the player has retrieved a certain value or more in
	 * specific StatBase field
	 */
	public static boolean hasPlayerGained(EntityPlayerMP player, StatBase stat, int amount) {
		return getPlayerStat(player, stat) >= amount;
	}

	/**
	 * Inserts an ItemStack into an entity's inventory (provides consistency for
	 * entities, currently only for players)
	 */
	public static void insertItem(EntityLivingBase entity, ItemStack stack) {
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.addItemStackToInventory(stack);
	}

	/**
	 * Determines whether it is possible to draw a straight line from rayStart
	 * to rayEnd in world
	 */
	public static boolean isTraceOpen(World world, Vec3 rayStart, Vec3 rayEnd) {
		return world.rayTraceBlocks(rayStart, rayEnd, true) == null;
	}
	
	/**
	 * Retrieves Battlegear 2's id
	 */
	public static String getBg2Id() {
		return bg2Id;
	}
	/**
	 * Retrieves whether Battlegear 2 is installed (saves result at runtime for efficiency)
	 */
	public static boolean isBg2Installed() {
		if(isBG2Loaded == null) {
			isBG2Loaded = Loader.isModLoaded(getBg2Id());
		}
		return isBG2Loaded.booleanValue();
	}
	
	/**
	 * Determines whether Battlegear 2 should be used based on {@link #isBg2Installed()} and {@link Config#canUseBg2()}
	 * 
	 * @see #isBg2Installed()
	 * @see Config#canUseBg2()
	 */
	public static boolean shouldUseBg2() {
		return HTTYMDMod.getConfig().canUseBg2() && isBg2Installed();
	}
	
	/**
	 * Determines whether use of Battlegear 2 daggers is required
	 * 
	 * @see #shouldUseBg2()
	 * @see Config#useBg2Daggers()
	 */
	public static boolean shouldForceBg2Daggers() {
		return shouldUseBg2() && HTTYMDMod.getConfig().useBg2Daggers();
	}
	
	/**
	 * Determines whether use of Battlegear 2 for Warhammers is required
	 * 
	 * @see #shouldUseBg2()
	 * @see Config#useBg2ForWarhammer()
	 */
	public static boolean shouldForceBg2ForWarhammer() {
		return shouldUseBg2() && HTTYMDMod.getConfig().useBg2ForWarhammer();
	}
	
	/**
	 * Shorthand for {@link Config#isDebugMode() HTTYMDMod.getConfig().isDebugMode()}
	 */
	public static boolean debug() {
		return HTTYMDMod.getConfig().isDebugMode();
	}
	
	/**
	 * Shorthand for {@link Config#isExperimental() HTTYMDMod.getConfig().isExperimental()}
	 */
	public static boolean experimental() {
		return HTTYMDMod.getConfig().isExperimental();
	}
	
	public static Logger logger() {
		return HTTYMDMod.getLogger();
	}
}
