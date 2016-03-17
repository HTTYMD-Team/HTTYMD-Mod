package com.httymd.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraftforge.common.util.EnumHelper;

import com.httymd.HTTYMDMod;
import com.httymd.api.item.WeaponType;
import com.httymd.item.ItemArmorExtension;
import com.httymd.item.ItemWeapon;

public final class ItemUtils {

	/**
	 * A utility enum for determining a difference between armor types (for easy
	 * of access)
	 */
	public static enum EnumArmorType {
		/**
		 * Represents boots
		 */
		BOOTS,
		/**
		 * Represents leggings (pants)
		 */
		LEGGINGS,
		/**
		 * Represents a chestplate
		 */
		CHESTPLATE,
		/**
		 * Represents a helmet
		 */
		HELMET;

		/**
		 * Retrieves the reverse of the ordinal, cause Minecraft screws up armor
		 * location horribly
		 *
		 * <p>
		 * Eg: 0 = Helmet, 1 = Chestplate, 2 = Leggings, 3 = Boots
		 * </p>
		 */
		public int ordinalReverse() {
			return values().length - this.ordinal() - 1;
		}
	}

	/**
	 * Retrieves whether a specific item exists in a entity's inventory
	 * (provides consistency for entities, currently only for players).
	 */
	public static boolean hasItem(EntityLivingBase entity, Item item) {
		if (entity instanceof EntityPlayer)
			return ((EntityPlayer) entity).inventory.hasItem(item);

		return false;
	}

	/**
	 * Inserts an ItemStack into an entity's inventory (provides consistency for
	 * entities, currently only for players)
	 */
	public static void insertItem(EntityLivingBase entity, ItemStack stack) {
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.addItemStackToInventory(stack);
	}

	/**
	 * Creates and retrieves a new {@link ItemArmor.ArmorMaterial}
	 *
	 * @param craftingMaterial
	 *            The material that can be used to repair armors that use this
	 *            enum
	 */
	public static ItemArmor.ArmorMaterial addArmorMaterial(String name,
			int durability, int[] reductionAmounts, int enchantability,
			Item craftingMaterial) {
		ItemArmor.ArmorMaterial mat = EnumHelper.addArmorMaterial(name,
				durability, reductionAmounts, enchantability);
		mat.customCraftingMaterial = craftingMaterial;
		return mat;
	}

	/**
	 * Adds a fishable itemstack through reflection to guarantee compatibility
	 * with previous versions of Forge that don't support
	 * {@link net.minecraftforge.common.FishingHooks FishingHooks}, prevents
	 * multiple instances of reflection in hook is missing
	 *
	 * @return whether adding fishing hooks is possible in current version
	 */
	public static boolean addFish(ItemStack stack, int occurence) {
		if (!ItemUtils.supportsFishHooking)
			return false;
		try {
			Class.forName("net.minecraftforge.common.FishingHooks")
					.getMethod("addFish", WeightedRandomFishable.class)
					.invoke(null, new WeightedRandomFishable(stack, occurence));
			return true;
		} catch (Exception e) {
			HTTYMDMod
					.getLogger()
					.warn("Probable Unsupported Forge Version, please update for all features\n\nExeception:\n"
							+ e);
			ItemUtils.supportsFishHooking = false;
			return false;
		}
	}

	private static boolean supportsFishHooking = true;

	/**
	 * Creates and retrieves a new {@link Item.ToolMaterial}
	 *
	 * @param craftingMaterial
	 *            The material that can be used to repair tools that use this
	 *            enum
	 */
	public static Item.ToolMaterial addToolMaterial(String name,
			int harvestLevel, int maxUses, float efficiency, float damage,
			int enchantability, Item craftingMaterial) {
		Item.ToolMaterial mat = EnumHelper.addToolMaterial(name, harvestLevel,
				maxUses, efficiency, damage, enchantability);
		mat.customCraftingMaterial = craftingMaterial;
		return mat;
	}

	/**
	 * Retrieves registry name from unlocalized name
	 *
	 * <p>
	 * Terminates modid section
	 * </p>
	 */
	public static String findRegistryName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.lastIndexOf(':') + 1);
	}

	/**
	 * Retrieves texture name from unlocalized name
	 *
	 * <p>
	 * Will get rid of unlocazied prefix (for items, its 'item.') and retrieves
	 * texture name
	 * </p>
	 */
	public static String findTextureName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf('.') + 1);
	}

	/**
	 * Creates unlocalized name for standardization
	 *
	 * <p>
	 * Syntax: "modid:&lt;lowercase name&gt;"
	 * </p>
	 */
	public static String findUnlocName(String name) {
		String modid = HTTYMDMod.ID;
		int colonIndex = name.indexOf(':');
		if (colonIndex != -1) {
			modid = name.substring(0, colonIndex - 1);
			name = name.substring(colonIndex);
		}
		return modid + ":" + name.toLowerCase();
	}

	/**
	 * Creates an array of armor from a class extending from ItemArmorExtension,
	 * uses reflection. (Reflection maybe be disgusting and slow, but this
	 * provides efficiency, and is only ever called once on startup, and is
	 * easier to manage)
	 *
	 * @param baseName
	 *            The standardized prefix name to apply to the whole object
	 * @param mat
	 *            The {@link ArmorMaterial} of the new armor
	 */
	public static Item[] generateArmor(
			Class<? extends ItemArmorExtension> clazz, String baseName,
			ArmorMaterial mat) {
		ItemUtils.EnumArmorType[] armors = ItemUtils.EnumArmorType.values();
		ItemArmorExtension[] armor = new ItemArmorExtension[armors.length];
		for (int i = 0; i < armors.length; i++)
			try {
				armor[i] = clazz.getConstructor(String.class,
						ArmorMaterial.class, int.class).newInstance(
						baseName
								+ "_"
								+ armors[i].toString().toLowerCase(
										Locale.ENGLISH), mat,
						armors[i].ordinalReverse());
				armor[i] = (ItemArmorExtension) armor[i].register();
			} catch (Exception ex) {
				HTTYMDMod.getLogger().fatal(ex);
			}
		return armor;
	}

	/**
	 * Generates a weapon map based on a material and a groupd of types
	 * 
	 * @param material
	 *            Material to generate for
	 * @param types
	 *            Types to generate for
	 */
	public static Map<WeaponType, Item> generateWeaponList(
			ToolMaterial material, WeaponType... types) {
		Map<WeaponType, Item> result = new HashMap<WeaponType, Item>();

		for (WeaponType t : types) {
			if (t.getFactory() != null) {
				result.put(t, t.getFactory().createWeapon(material, t));
			} else
				result.put(t, new ItemWeapon(material, t).register());
		}

		return result;
	}

	/**
	 * Determines whether item is food
	 * 
	 * @param item
	 *            The stack to test
	 */
	public static boolean isFood(ItemStack item) {
		if (item == null)
			return false;
		return item.getItem() instanceof ItemFood;
	}

	/**
	 * Removes (consumes) an Item inside an entity's inventory (provides
	 * consistency for entities, currently only for players).
	 *
	 * @return whether removal was possible
	 */
	public static boolean consumeItem(EntityLivingBase entity, Item item) {
		if (entity instanceof EntityPlayer)
			return ((EntityPlayer) entity).inventory.consumeInventoryItem(item);

		return false;
	}

}
