package com.httymd.item.util;

import java.util.Collections;
import java.util.Set;

import com.google.common.collect.Sets;
import com.httymd.HTTYMDMod;
import com.httymd.item.ItemArmorExtension;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraftforge.common.util.EnumHelper;

public class ItemUtils {
	
	private static boolean supportsFishHooking = true;

	/**
	 * Adds a fishable itemstack through reflection to guarantee compatibility with previous versions of Forge that don't support 
	 * {@link net.minecraftforge.common.FishingHooks FishingHooks}
	 * 
	 * @return whether adding fishing hooks is possible in current version
	 */
	public static boolean addFish(ItemStack stack, int occurence) {
		if(!supportsFishHooking) return false;
		try {
			Class.forName("net.minecraftforge.common.FishingHooks").getMethod("addFish", WeightedRandomFishable.class).invoke(null, new WeightedRandomFishable(stack, occurence));
			return true;
		} catch (Exception e) {
			HTTYMDMod.getLogger().warn("Probable Unsupported Forge Version, please update for all features\n\nExeception:\n" + e);
			supportsFishHooking = false;
			return false;
		}
	}
	
	/**
	 * Creates unlocalized name for standardization
	 */
	public static String findUnlocName(String name) {
		return HTTYMDMod.ID + ":" + name.toLowerCase();
	}
	
	/**
	 * Retrieves texture name from unlocalized name
	 */
	public static String findTextureName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf('.') + 1);
	}
	
	/**
	 * Retrieves registry name from unlocalized name
	 */
	public static String findRegistryName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.lastIndexOf(':') + 1);
	}
	
	/**
	 * Retrieves effective blocks for each EnumToolType, hard-coded based off of individual classes
	 */
	public static Set<Block> getEffectiveForToolType(EnumToolType type) {
		Set<Block> result; 
		switch(type) {
		case PICKAXE:
			result = Sets.newHashSet(new Block[] {
					Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, 
					Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, 
					Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, 
					Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, 
					Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, 
					Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});
			break;
		case AXE:
			result = Sets.newHashSet(new Block[] {
					Blocks.planks, Blocks.bookshelf, Blocks.log, 
					Blocks.log2, Blocks.chest, Blocks.pumpkin, 
					Blocks.lit_pumpkin});
			break;
		case SHOVEL:
			result = Sets.newHashSet(new Block[] {
					Blocks.grass, Blocks.dirt, Blocks.sand, 
					Blocks.gravel, Blocks.snow_layer, Blocks.snow, 
					Blocks.clay, Blocks.farmland, Blocks.soul_sand, 
					Blocks.mycelium});
			break;
		default:
			result = Collections.singleton(null);
			break;
		}
		
		return result;
	}
	
	/**
	 * Creates an array of armor from a class extending from ItemArmorExtension, uses reflection.
	 * (Reflection maybe be disgusting and slow, but this provides efficiency, and is only ever called once on startup, and is easier to manage)
	 * @param baseName The standardized prefix name to apply to the whole object
	 * @param mat The {@link ArmorMaterial} of the new armor
	 */
	public static Item[] generateArmor(Class<? extends ItemArmorExtension> clazz, String baseName, ArmorMaterial mat) {
		final String[] ARMORNAMES = { "helmet", "chestplate", "leggings", "boots" };
		ItemArmorExtension[] armor = new ItemArmorExtension[ARMORNAMES.length];
		for (int i = 0; i < ARMORNAMES.length; i++) {
			try {
				armor[i] = clazz.getConstructor(String.class, ArmorMaterial.class, int.class).newInstance(baseName + "_" + ARMORNAMES[i], mat, i);
				armor[i] = (ItemArmorExtension) armor[i].registerItem();
			} catch (Exception ex) {
				HTTYMDMod.getLogger().fatal(ex);
			}
		}
		return armor;
	}
	
	/**
	 * Creates and retrieves a new {@link Item.ToolMaterial}
	 * @param craftingMaterial The material that can be used to repair tools that use this enum
	 */
	public static Item.ToolMaterial addToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Item craftingMaterial) {
		Item.ToolMaterial mat = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability);
		mat.customCraftingMaterial = craftingMaterial;
		return mat;
	}
	
	/**
	 * Creates and retrieves a new {@link ItemArmor.ArmorMaterial}
	 * @param craftingMaterial The material that can be used to repair armors that use this enum
	 */
	public static ItemArmor.ArmorMaterial addArmorMaterial(String name, int durability, int[] reductionAmounts, int enchantability, Item craftingMaterial) {
		ItemArmor.ArmorMaterial mat = EnumHelper.addArmorMaterial(name, durability, reductionAmounts, enchantability);
		mat.customCraftingMaterial = craftingMaterial;
		return mat;
	}
}
