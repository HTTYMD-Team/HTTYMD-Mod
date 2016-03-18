package com.httymd.registry;

import java.util.Collection;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;

import com.httymd.api.item.FoodType;
import com.httymd.api.item.WeaponType;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeRegistry {

	public static void init() {
		addRecipesForType(WeaponType.DAGGER);
		addRecipesForType(WeaponType.CLUB);
		addRecipesForType(WeaponType.MACE);
		addRecipesForType(WeaponType.HAMMER);
		addRecipesForType(WeaponType.WARAXE);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shieldWood),
				"###", "$#$", "###", '#', Blocks.planks, '$', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shieldStone),
				"###", "$#$", "###", '#', Blocks.cobblestone, '$', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shieldIron),
				"###", "$#$", "###", '#', Items.iron_ingot, '$', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shieldGold),
				"###", "$#$", "###", '#', Items.gold_ingot, '$', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shieldDiam),
				"###", "$#$", "###", '#', Items.diamond, '$', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shieldGron),
				"###", "$#$", "###", '#', ItemRegistry.gronkleIronIngot, '$', Items.stick);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.swordGron),
				"#", "#", "|", '#', ItemRegistry.gronkleIronIngot, '|', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.axeGron),
				"##", "#|", " |", '#', ItemRegistry.gronkleIronIngot, '|', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.pickaxeGron),
				"###", " | ", " | ", '#', ItemRegistry.gronkleIronIngot, '|', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shovelGron),
				"#", "|", "|", '#', ItemRegistry.gronkleIronIngot, '|', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.hoeGron),
				"##", " |", " |", '#', ItemRegistry.gronkleIronIngot, '|', Items.stick);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.crossbow),
				"S#S", "III", '#', Items.bow, 'S', Items.string, 'I', Items.iron_ingot);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.glideSuit[0]),
				"IWI", "LIL", 'I', Items.iron_ingot, 'W', Blocks.wool, 'L', Items.leather);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.glideSuit[1]),
				"LWL", "#L#", "LLL", 'L', Items.leather, 'W', Blocks.wool, '#', ItemRegistry.wing);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.glideSuit[2]),
				"LLL", "I I", "L L", 'L', Items.leather, 'I', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.glideSuit[3]),
				"I I", "L L", 'I', Items.iron_ingot, 'L', Items.leather);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.wing),
				"#I#", "I#I", "III", '#', Items.leather, 'I', Items.iron_ingot);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.flameSword),
				"S", "#", 'S', Items.iron_sword, '#', Items.coal);

		GameRegistry.addRecipe(new ItemStack(BlockRegistry.gronkleIronBlock),
				"III", "III", "III", 'I', ItemRegistry.gronkleIronIngot);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.gronkleIronIngot, 9), BlockRegistry.gronkleIronBlock);

		final Item[] muttonArr = getFoodArrByEnum(FoodType.MUTTON);
		GameRegistry.addSmelting(muttonArr[0], new ItemStack(muttonArr[1]), 0.35F);

		/*
		 * ItemStack stack = new ItemStack(ItemRegistry.zippleGasContainer);
		 * ItemContainer.setProduceHeld(stack, 15.0F);
		 * GameRegistry.addRecipe(stack, "##", '#', Blocks.dirt);
		 */

		// GameRegistry.addRecipe(ItemRegistry.zippleGasContainer.getEmptyContainer(),
		// "I#I", "I#I", "I#I", 'I', Items.iron_ingot, '#',Blocks.glass_pane);
		// GameRegistry.addRecipe(ItemRegistry.nightmareSalivaContainer.getEmptyContainer(),
		// "I-I", "I I", "III", 'I', Items.iron_ingot, '-', Blocks.trapdoor);
	}

	/**
	 * Retrieves food array based on {@link FoodType}
	 */
	private static Item[] getFoodArrByEnum(FoodType type) {
		final Collection<Item> list = ItemRegistry.foods.get(type);
		return list.toArray(new Item[list.size()]);
	}

	private static void addRecipesForType(WeaponType type) {
		type
		.addMaterial(ToolMaterial.WOOD)
		.addMaterial(ToolMaterial.STONE)
		.addMaterial(ToolMaterial.IRON)
		.addMaterial(ToolMaterial.GOLD)
		.addMaterial(ToolMaterial.EMERALD)
		.addMaterial(MaterialRegistry.toolGronkle)
		.registerRecipe();
	}

}
