package com.httymd.entity;

import com.httymd.HTTYMDMod;
import com.httymd.item.ItemSpawnEgg;
import com.httymd.item.registry.ItemRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityRegister {

	private static int nextID = EntityRegistry.findGlobalUniqueEntityId();
	private static CreativeTabs currentTab = HTTYMDMod.getCreativeTab();

	public static void createEntity(Class<? extends Entity> entityClass, String entityName, int solidColor,
			int spotColor) {
		EntityRegistry.registerModEntity(entityClass, entityName, nextID, HTTYMDMod.INSTANCE, 50, 2, true);
		HTTYMDMod.registerDragonName(entityName);
		ItemSpawnEgg egg = (ItemSpawnEgg) new ItemSpawnEgg(entityName, solidColor, spotColor)
				.setCreativeTab(currentTab);
		egg.registerItem();
		ItemRegistry.spawnEggIDMapping.put(nextID, egg);
		nextID++;
	}

	public static void setCurrentTab(CreativeTabs tab) {
		currentTab = tab;
	}
}
