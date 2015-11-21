package com.httymd.item.recipe;

import com.httymd.item.registry.ItemRegistry;
import com.httymd.item.util.EnumFoodType;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeRegistry {

	public static void init() {
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.daggerWood), "#", "|", '|', Items.stick, '#', Blocks.planks);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.daggerStone), "#", "|", '|', Items.stick, '#',
				Blocks.cobblestone);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.daggerIron), "#", "|", '|', Items.stick, '#',
				Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.daggerGold), "#", "|", '|', Items.stick, '#',
				Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.daggerDiam), "#", "|", '|', Items.stick, '#', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.daggerGron), "#", "|", '|', Items.stick, '#',
				ItemRegistry.gronkleIronIngot);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.clubWood), "#|#", " | ", " | ", '|', Items.stick, '#',
				Blocks.planks);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.clubStone), "#|#", " | ", " | ", '|', Items.stick, '#',
				Blocks.cobblestone);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.clubIron), "#|#", " | ", " | ", '|', Items.stick, '#',
				Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.clubGold), "#|#", " | ", " | ", '|', Items.stick, '#',
				Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.clubDiam), "#|#", " | ", " | ", '|', Items.stick, '#',
				Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.clubGron), "#|#", " | ", " | ", '|', Items.stick, '#',
				ItemRegistry.gronkleIronIngot);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.maceWood), " # ", "#|#", " | ", '|', Items.stick, '#',
				Blocks.planks);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.maceStone), " # ", "#|#", " | ", '|', Items.stick, '#',
				Blocks.cobblestone);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.maceIron), " # ", "#|#", " | ", '|', Items.stick, '#',
				Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.maceGold), " # ", "#|#", " | ", '|', Items.stick, '#',
				Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.maceDiam), " # ", "#|#", " | ", '|', Items.stick, '#',
				Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.maceGron), " # ", "#|#", " | ", '|', Items.stick, '#',
				ItemRegistry.gronkleIronIngot);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.hammerWood), "###", "#|#", " | ", '|', Items.stick, '#',
				Blocks.planks);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.hammerStone), "###", "#|#", " | ", '|', Items.stick, '#',
				Blocks.cobblestone);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.hammerIron), "###", "#|#", " | ", '|', Items.stick, '#',
				Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.hammerGold), "###", "#|#", " | ", '|', Items.stick, '#',
				Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.hammerDiam), "###", "#|#", " | ", '|', Items.stick, '#',
				Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.hammerGron), "###", "#|#", " | ", '|', Items.stick, '#',
				ItemRegistry.gronkleIronIngot);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.waraxeWood), "#|#", "#|#", " | ", '|', Items.stick, '#',
				Blocks.planks);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.waraxeStone), "#|#", "#|#", " | ", '|', Items.stick, '#',
				Blocks.cobblestone);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.waraxeIron), "#|#", "#|#", " | ", '|', Items.stick, '#',
				Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.waraxeGold), "#|#", "#|#", " | ", '|', Items.stick, '#',
				Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.waraxeDiam), "#|#", "#|#", " | ", '|', Items.stick, '#',
				Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.waraxeGron), "#|#", "#|#", " | ", '|', Items.stick, '#',
				ItemRegistry.gronkleIronIngot);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shieldWood), "###", "$#$", "###", '#', Blocks.planks, '$',
				Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shieldStone), "###", "$#$", "###", '#', Blocks.cobblestone,
				'$', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shieldIron), "###", "$#$", "###", '#', Items.iron_ingot, '$',
				Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shieldGold), "###", "$#$", "###", '#', Items.gold_ingot, '$',
				Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shieldDiam), "###", "$#$", "###", '#', Items.diamond, '$',
				Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shieldGron), "###", "$#$", "###", '#',
				ItemRegistry.gronkleIronIngot, '$', Items.stick);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.swordGron), "#", "#", "|", '#', ItemRegistry.gronkleIronIngot,
				'|', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.axeGron), "##", "#|", " |", '#',
				ItemRegistry.gronkleIronIngot, '|', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.pickaxeGron), "###", " | ", " | ", '#',
				ItemRegistry.gronkleIronIngot, '|', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.shovelGron), "#", "|", "|", '#',
				ItemRegistry.gronkleIronIngot, '|', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.hoeGron), "##", " |", " |", '#',
				ItemRegistry.gronkleIronIngot, '|', Items.stick);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.crossbow), "S#S", "III", '#', Items.bow, 'S', Items.string,
				'I', Items.iron_ingot);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.glideSuit[0]), "IWI", "LIL", 'I', Items.iron_ingot, 'W',
				Blocks.wool, 'L', Items.leather);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.glideSuit[1]), "LWL", "#L#", "LLL", 'L', Items.leather, 'W',
				Blocks.wool, '#', ItemRegistry.wing);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.glideSuit[2]), "LLL", "I I", "L L", 'L', Items.leather, 'I',
				Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.glideSuit[3]), "I I", "L L", 'I', Items.iron_ingot, 'L',
				Items.leather);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.wing), "#I#", "I#I", "III", '#', Items.leather, 'I',
				Items.iron_ingot);

		GameRegistry.addRecipe(new ItemStack(ItemRegistry.flameSword), "S", "#", 'S', Items.iron_sword, '#',
				Items.coal);

		Item[] muttonArr = ItemRegistry.foods.get(EnumFoodType.MUTTON).toArray(new Item[10]);
		GameRegistry.addSmelting(muttonArr[0], new ItemStack(muttonArr[1]), 1.0F);

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

}
