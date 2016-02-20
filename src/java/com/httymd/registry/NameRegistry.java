package com.httymd.registry;

import java.util.ArrayList;

import com.httymd.HTTYMDMod;
import com.httymd.api.ISpecialName;
import com.httymd.stats.StatListMod;
import com.httymd.util.StatUtils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.StatList;
import net.minecraft.util.StatCollector;

public class NameRegistry {

	static {
		init();
	}
	
	private static final ArrayList<String> randomNames = new ArrayList<String>();
	private static final ArrayList<ISpecialName> specialNames = new ArrayList<ISpecialName>();

	private static void init() {
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

				String plyUuid = ((EntityPlayer) entity).getGameProfile().getId().toString();

				if ("b2848781-aafe-454b-a87d-89ceffad585f".equals(plyUuid))
					return "s322";

				if ("5c884585-0245-4452-bcac-5005c73d3196".equals(plyUuid))
					return "cmmr";

				return null;
			}
		});
		registerSpecialName(new ISpecialName() {
			public String get(EntityLivingBase entity, String currentName) {
				if (!(entity instanceof EntityPlayerMP))
					return null;

				EntityPlayerMP ply = (EntityPlayerMP) entity;

				if (StatUtils.hasPlayerGained(ply, StatList.damageDealtStat, 200000)) {
					return "ataryn";
				}

				if (StatUtils.hasPlayerGained(ply, StatListMod.distanceByDragon, 3000))
					return "rider";

				if (StatUtils.hasPlayerGained(ply, StatList.playerKillsStat, 100)
						|| StatUtils.hasPlayerGained(ply, StatList.damageTakenStat, 9000000))
					return "relentless";
				else if (StatUtils.hasPlayerGained(ply, StatList.deathsStat, 100))
					return "slayed";
				else if (StatUtils.hasPlayerGained(ply, StatList.jumpStat, 5000))
					return "excited";
				else if (StatUtils.hasPlayerGained(ply, StatList.mobKillsStat, 400))
					return "champion";
				else if (StatUtils.hasPlayerGained(ply, StatList.distanceByBoatStat, 2000))
					return "sailor";

				return null;
			}
		});
	}

	public static String getDisplayName(EntityLivingBase entity, String originalName) {
		String translateStr;
		String newName;

		for (ISpecialName name : specialNames) {
			newName = name.get(entity, originalName);
			if (newName != null) {
				translateStr = HTTYMDMod.ID + ":" + "name.special.add." + newName;
				if (StatCollector.canTranslate(translateStr))
					return StatCollector.translateToLocalFormatted(translateStr, originalName);
				return originalName + " the " + newName;
			}
		}

		newName = randomNames.get(entity.getRNG().nextInt(randomNames.size()));
		return StatCollector.translateToLocalFormatted(HTTYMDMod.ID + ":" + "name.random." + newName, originalName);
	}

	public static void registerRandomName(String name) {
		randomNames.add(name);
	}

	public static void registerSpecialName(ISpecialName sName) {
		specialNames.add(sName);
	}

}
