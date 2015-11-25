package com.httymd.util;

import java.util.ArrayList;

import com.httymd.HTTYMDMod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.StatList;
import net.minecraft.util.StatCollector;

public class NameManager {

	public interface ISpecialName {
		public String get(EntityLivingBase entity, String currentName);
	}

	private static final NameManager INSTANCE = new NameManager();

	public static NameManager getInstance() {
		return INSTANCE;
	}

	private final ArrayList<String> randomNames = new ArrayList<String>();

	private final ArrayList<ISpecialName> specialNames = new ArrayList<ISpecialName>();

	private NameManager() {
		this.registerRandomName("smelly");
		this.registerRandomName("angry");
		this.registerRandomName("fat");
		this.registerRandomName("big");
		this.registerRandomName("wimp");
		this.registerRandomName("dragonslayer");
		this.registerRandomName("meatslapper");
		this.registerRandomName("murderer");
		this.registerRandomName("nut");
		this.registerRandomName("jerk");
		this.registerRandomName("melon");
		this.registerRandomName("jackolatern");
		this.registerRandomName("blind");
		this.registerRandomName("crazy");
		this.registerRandomName("freak");
		this.registerRandomName("broken");
		this.registerRandomName("stupid");
		this.registerSpecialName(new ISpecialName() {
			public String get(EntityLivingBase entity, String currentName) {
				if (!(entity instanceof EntityPlayer))
					return null;

				String id = ((EntityPlayer) entity).getGameProfile().getId().toString();

				if (id == "b2848781-aafe-454b-a87d-89ceffad585f")
					return "s322";

				if (id == "5c884585-0245-4452-bcac-5005c73d3196")
					return "cmmr";

				return null;
			}
		});
		this.registerSpecialName(new ISpecialName() {
			public String get(EntityLivingBase entity, String currentName) {
				if (!(entity instanceof EntityPlayerMP))
					return null;

				EntityPlayerMP ply = (EntityPlayerMP) entity;

				if (Utils.hasPlayerGained(ply, StatListMod.distanceByDragon, 3000))
					return "rider";

				if (Utils.hasPlayerGained(ply, StatList.playerKillsStat, 100) 
						|| Utils.hasPlayerGained(ply, StatList.damageTakenStat, 9000000))
					return "relentless";
				else if (Utils.hasPlayerGained(ply, StatList.deathsStat, 100))
					return "slayed";
				else if (Utils.hasPlayerGained(ply, StatList.jumpStat, 5000))
					return "excited";
				else if (Utils.hasPlayerGained(ply, StatList.mobKillsStat, 400))
					return "champion";
				else if (Utils.hasPlayerGained(ply, StatList.distanceByBoatStat, 2000))
					return "sailor";

				return null;
			}
		});
	}

	public String getDisplayName(EntityLivingBase entity, String originalName) {
		String translateStr;
		String newName;

		for (ISpecialName name : this.specialNames) {
			newName = name.get(entity, originalName);
			if (newName != null) {
				translateStr = HTTYMDMod.ID + ":" + ".name.special.add." + newName;
				if (StatCollector.canTranslate(translateStr))
					return StatCollector.translateToLocalFormatted(translateStr, originalName);
				return originalName + " the " + newName;
			}
		}

		newName = this.randomNames.get(entity.getRNG().nextInt(this.randomNames.size()));
		return StatCollector.translateToLocalFormatted(HTTYMDMod.ID + ":" + "name.random." + newName, originalName);
	}

	public void registerRandomName(String name) {
		this.randomNames.add(name);
	}

	public void registerSpecialName(ISpecialName sName) {
		this.specialNames.add(sName);
	}

}
