package com.httymd.item.registry;

import java.util.Random;

import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.common.ChestGenHooks;

public class WorldItemRegistry {

	public static void init() {
		// Village Blacksmith Chests
		ChestGenHooks vilBS = ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH);
		addGeneratedItem(vilBS, ItemRegistry.gronkleIronIngot, 0, 1, 3, 7);
		addGeneratedItem(vilBS, ItemRegistry.glideSuit[2], 0, 1, 1, 3);
		addGeneratedItem(vilBS, ItemRegistry.shieldStone, 0, 1, 1, 10);
		
		// Dungeon Chests
		ChestGenHooks dunChests = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
		addGeneratedItem(dunChests, ItemRegistry.gronkleIronIngot, 0, 1, 5, 8);
		
		// Mineshaft Chests
		ChestGenHooks mineChests = ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR);
		addGeneratedItem(mineChests, ItemRegistry.pickaxeGron, 0, 1, 1, 7);
		
		VillagerRegistry vreg = VillagerRegistry.instance();
		final int blacksmithId = 3;
		vreg.registerVillageTradeHandler(blacksmithId, new IVillageTradeHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
				if(random.nextBoolean()) return;
				recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, random.nextInt(10)+5), ItemRegistry.crossbow));
				recipeList.add(new MerchantRecipe(new ItemStack(ItemRegistry.crossbow), new ItemStack(Items.emerald, random.nextInt(5)+1)));
			}			
		});
	}
	
	public static void addGeneratedItem(ChestGenHooks hook, Item i, int damage, int minSize, int maxSize, int weight) {
		hook.addItem(new WeightedRandomChestContent(i, damage, minSize, maxSize, weight));
	}
	
}
