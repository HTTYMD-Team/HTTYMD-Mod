package com.httymd.util;

import java.util.UUID;

import com.httymd.HTTYMDMod;
import com.httymd.item.ItemSpawnEgg;
import com.httymd.registry.ItemRegistry;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public final class EntityUtils {
	
	public static CreativeTabs currentTab = HTTYMDMod.getCreativeTab();
	public static int nextID;

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

	public static void setSpawnEggTab(CreativeTabs tab) {
		EntityUtils.currentTab = tab;
	}

	public static void createEntity(Class<? extends Entity> entityClass, String entityName, int solidColor,
			int spotColor) {
		EntityRegistry.registerModEntity(entityClass, entityName, nextID++, HTTYMDMod.INSTANCE, 50, 2, true);
		DragonUtils.registerDragonName(entityName);
		ItemSpawnEgg egg = (ItemSpawnEgg) new ItemSpawnEgg(entityName, solidColor, spotColor).register().setCreativeTab(currentTab);
		ItemRegistry.spawnEggIDMapping.put(entityName, egg);
	}
}
