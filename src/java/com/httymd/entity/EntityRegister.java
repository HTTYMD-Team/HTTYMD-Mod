package com.httymd.entity;

import com.httymd.HTTYMDMod;
import com.httymd.item.ItemSpawnEgg;
import com.httymd.item.registry.ItemRegistry;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;

public class EntityRegister {

	private static int nextID;
	private static CreativeTabs currentTab = HTTYMDMod.getCreativeTab();

	public static void createEntity(Class<? extends Entity> entityClass, String entityName, int solidColor,
			int spotColor) {
		/*if (nextID < 1) {
			nextID = -1;
			if (nextID == -1)
				nextID = EntityRegistry.findGlobalUniqueEntityId();
		} else
			nextID += 1;*/
		EntityRegistry.registerModEntity(entityClass, entityName, nextID++, HTTYMDMod.INSTANCE, 50, 2, true);
		HTTYMDMod.registerDragonName(entityName);
		ItemSpawnEgg egg = (ItemSpawnEgg) new ItemSpawnEgg(entityName, solidColor, spotColor).register().setCreativeTab(currentTab);
		ItemRegistry.spawnEggIDMapping.put(entityName, egg);
	}

	public static void setCurrentTab(CreativeTabs tab) {
		currentTab = tab;
	}
}
