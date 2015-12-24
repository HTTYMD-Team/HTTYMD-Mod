package com.httymd.util;

import java.util.ArrayList;

import com.httymd.HTTYMDMod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.StatList;
import net.minecraft.util.StatCollector;

public class NameManager {

	private static final NameManager INSTANCE = new NameManager();

	private final ArrayList<String> randomNames = new ArrayList<String>();
	private final ArrayList<ISpecialName> specialNames = new ArrayList<ISpecialName>();

	public interface ISpecialName {
		public String get(EntityLivingBase entity, String currentName);
	}

	private NameManager() {
		registerRandomName("smelly");
		registerRandomName("angry");
		registerRandomName("fat");
		registerRandomName("big");
		registerRandomName("wimp");
		registerRandomName("dragonslayer");
		registerRandomName("meatslapper");
		registerRandomName("murderer");
		registerRandomName("nut");
		registerRandomName("jerk");
		registerRandomName("melon");
		registerRandomName("jackolatern");
		registerRandomName("blind");
		registerRandomName("crazy");
		registerRandomName("freak");
		registerRandomName("broken");
		registerRandomName("stupid");
		registerSpecialName(new ISpecialName() {
			public String get(EntityLivingBase entity, String currentName) {
				if (!(entity instanceof EntityPlayer))
					return null;

				String id = ((EntityPlayer) entity).getGameProfile().getId().toString();

				if (id.equals("b2848781-aafe-454b-a87d-89ceffad585f")) {
					return "s322";
				}

				if (id.equals("5c884585-0245-4452-bcac-5005c73d3196")) {
					return "cmmr";
				}

				return null;
			}
		});
		registerSpecialName(new ISpecialName() {
			public String get(EntityLivingBase entity, String currentName) {
				if (!(entity instanceof EntityPlayerMP))
					return null;

				EntityPlayerMP ply = (EntityPlayerMP) entity;

				if (Utils.hasPlayerGained(ply, StatListMod.distanceByDragon, 3000)) {
					return "rider";
				} /*
					 * else if (Utils.hasPlayerGained(ply,
					 * StatListMod.dragonsRidden.get("nightfury"), //for some
					 * reason fails 1)) { return "tamer"; }
					 */

				if (Utils.hasPlayerGained(ply, StatList.playerKillsStat, 100)) {
					return "relentless";
				} else if (Utils.hasPlayerGained(ply, StatList.deathsStat, 100)) {
					return "slayed";
				} else if (Utils.hasPlayerGained(ply, StatList.damageTakenStat, 5000)) {
					return "relentless";
				} else if (Utils.hasPlayerGained(ply, StatList.jumpStat, 5000)) {
					return "excited";
				} else if (Utils.hasPlayerGained(ply, StatList.mobKillsStat, 400)) {
					return "champion";
				} else if (Utils.hasPlayerGained(ply, StatList.distanceByBoatStat, 2000)) {
					return "sailor";
				}

				return null;
			}
		});
	}

	public void registerRandomName(String name) {
		randomNames.add(name);
	}

	public void registerSpecialName(ISpecialName sName) {
		specialNames.add(sName);
	}

	public String getDisplayName(EntityLivingBase entity, String originalName) {
		String translateStr;
		String newName;

		for (ISpecialName name : specialNames) {
			newName = name.get(entity, originalName);
			if (newName != null) {
				translateStr = HTTYMDMod.ID + ":" + ".name.special.add." + newName;
				if (StatCollector.canTranslate(translateStr))
					return StatCollector.translateToLocalFormatted(translateStr, originalName);
				return originalName + " the " + newName;
			}
		}

		newName = randomNames.get(entity.getRNG().nextInt(randomNames.size()));
		return StatCollector.translateToLocalFormatted(HTTYMDMod.ID + ":" + "name.random." + newName, originalName);
	}

	public static NameManager getInstance() {
		return INSTANCE;
	}

}
