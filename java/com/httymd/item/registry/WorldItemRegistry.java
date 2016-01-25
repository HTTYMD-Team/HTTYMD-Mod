package com.httymd.item.registry;

import java.util.HashMap;
import java.util.Random;

import com.httymd.api.item.WeaponType;
import com.httymd.item.ItemWeapon;

import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.common.ChestGenHooks;

public class WorldItemRegistry {

	public static void init() {
		// Village Blacksmith Chests
		ChestGenHooks hook = ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH);
		addGeneratedItem(hook, ItemRegistry.gronkleIronIngot, 0, 1, 3, 1);
		addGeneratedItem(hook, ItemRegistry.glideSuit[2], 0, 1, 1, 3);
		addGeneratedItem(hook, ItemRegistry.shieldStone, 0, 1, 1, 5);
		addGeneratedItem(hook, ItemRegistry.shieldGold, 0, 1, 1, 2);
		addGeneratedItem(hook, ItemRegistry.shieldDiam, 0, 1, 1, 1);
		addGeneratedItem(hook, ItemRegistry.shieldIron, 0, 1, 1, 2);
		addGeneratedItem(hook, ItemRegistry.shieldWood, 0, 1, 1, 6);
		addGeneratedWeapons(hook, ToolMaterial.WOOD, 2);
		addGeneratedWeapons(hook, ToolMaterial.STONE, 2);
		addGeneratedWeapons(hook, ToolMaterial.IRON, 1);
		
		// Dungeon Chests
		hook = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST); // Doesn't make sense to waste resources with more then one stored instance
		addGeneratedItem(hook, ItemRegistry.gronkleIronIngot, 0, 1, 5, 3);
		
		// Mineshaft Chests
		hook = ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR);
		addGeneratedItem(hook, ItemRegistry.pickaxeGron, 0, 1, 1, 1);
		addGeneratedItem(hook, ItemRegistry.waraxeStone, 0, 1, 1, 1);
		
		// Jungle Pyramid Chests
		hook = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		addGeneratedItem(hook, ItemRegistry.gronkleIronIngot, 0, 1, 1, 1);
		
		// Desert Pyramid Chests
		hook = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST);
		addGeneratedItem(hook, ItemRegistry.gronkleIronIngot, 0, 1, 1, 1);
		
		VillagerRegistry vreg = VillagerRegistry.instance();
		final int blacksmithId = 3;
		vreg.registerVillageTradeHandler(blacksmithId, new IVillageTradeHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
				recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, random.nextInt(10)+5), ItemRegistry.crossbow));
				recipeList.add(new MerchantRecipe(new ItemStack(ItemRegistry.crossbow), new ItemStack(Items.emerald, random.nextInt(5)+1)));
			}			
		});
	}
	
	/**
	 * Adds an itemstack to a specific loot generator
	 * @param hook The hook to add possible loot to
	 * @param i The item to insert
	 * @param damage The damage value of the item
	 * @param minSize The minimum possible size if ItemStack is generated
	 * @param maxSize The maximum posible size if ItemStack is generated
	 * @param weight The chance the item stack will be generated (higher = more likely)
	 */
	public static void addGeneratedItem(ChestGenHooks hook, Item i, int damage, int minSize, int maxSize, int weight) {
		hook.addItem(new WeightedRandomChestContent(i, damage, minSize, maxSize, weight));
	}
	
	private static void addGeneratedWeapons(ChestGenHooks hook, ToolMaterial material, int weight) {
		HashMap<WeaponType, ItemWeapon> map = ItemWeapon.getWeaponMap(material);
		for(ItemWeapon w : map.values()) {
			addGeneratedItem(hook, w, 0, 1, 1, weight);
		}
	}
}
