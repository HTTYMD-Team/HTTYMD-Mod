package com.httymd.registry;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Multimap;
import com.httymd.api.item.FoodType;
import com.httymd.api.item.WeaponType;
import com.httymd.item.ItemArmorExtension;
import com.httymd.item.ItemExtension;
import com.httymd.item.ItemGlideArmor;
import com.httymd.item.ItemShield;
import com.httymd.item.ItemSpawnEgg;
import com.httymd.item.ItemToolExtension;
import com.httymd.item.ItemWeaponCrossbow;
import com.httymd.item.util.EnumToolType;
import com.httymd.util.ItemUtils;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ItemRegistry {

	public static final HashMap<String, ItemSpawnEgg> spawnEggIDMapping = new HashMap<String, ItemSpawnEgg>();
	public static final HashMap<String, Item> itemRegistry = new HashMap<String, Item>();

	public static final Map<ToolMaterial, Map<WeaponType, Item>> weaponMap = new HashMap<ToolMaterial, Map<WeaponType, Item>>();
	
	public static Item shieldWood;
	public static Item shieldStone;
	public static Item shieldIron;
	public static Item shieldGold;
	public static Item shieldDiam;
	public static Item shieldGron;

	public static Item swordGron;
	public static Item shovelGron;
	public static Item axeGron;
	public static Item pickaxeGron;
	public static Item hoeGron;

	public static Item crossbow;
	public static Item[] glideSuit;
	public static Multimap<FoodType, Item> foods;
	public static Item gronkleIronIngot;
	public static Item wing;
	public static Item flameSword;

	//public static ItemContainer zippleGasContainer;
	//public static ItemContainer nightmareSalivaContainer;

	public static void init() {
		registerAllWeapons(ToolMaterial.WOOD, ToolMaterial.STONE, ToolMaterial.IRON, ToolMaterial.GOLD, ToolMaterial.EMERALD, MaterialRegistry.toolGronkle);
		
		swordGron = registerWeapon(MaterialRegistry.toolGronkle, WeaponType.SWORD);
		shovelGron = new ItemToolExtension(MaterialRegistry.toolGronkle, EnumToolType.SHOVEL).register();
		pickaxeGron = new ItemToolExtension(MaterialRegistry.toolGronkle, EnumToolType.PICKAXE).register();
		axeGron = new ItemToolExtension(MaterialRegistry.toolGronkle, EnumToolType.AXE).register();
		hoeGron = new ItemToolExtension(MaterialRegistry.toolGronkle, EnumToolType.HOE).register();

		crossbow = new ItemWeaponCrossbow("crossbow", 2).register();

		glideSuit = registerArmorSet(ItemGlideArmor.class, "gsuit", ArmorMaterial.IRON);

		gronkleIronIngot = registerItem("giron_ingot");
		wing = registerItem("wing_item");
		flameSword = registerWeapon(ToolMaterial.IRON, WeaponType.FSWORD);

		shieldWood = registerShield(ToolMaterial.WOOD);
		shieldStone = registerShield(ToolMaterial.STONE);
		shieldIron = registerShield(ToolMaterial.IRON);
		shieldGold = registerShield(ToolMaterial.GOLD);
		shieldDiam = registerShield(ToolMaterial.EMERALD);
		shieldGron = registerShield(MaterialRegistry.toolGronkle);

		// zippleGasContainer = new ItemContainer("zipple_gas_cont", 10.0F,
		// EntityZippleback.class);
		// nightmareSalivaContainer = new ItemContainer("night_saliva_cont",
		// 20.0F, EntityNightmare.class);
	}
	
	/**
	 * Gets called at the legitimate initialization phase (for compatibility
	 */
	public static void trueInit() {
		foods = FoodType.generateFood();

		ItemUtils.addFish(new ItemStack(foods.get(FoodType.CRAB).iterator().next(), 1), 50);
	}

	/**
	 * Registers item using a string name (for consistency with 1.8), silently ignores regName recurrences
	 * @param item Item to register
	 * @param regName Name to register item (mustn't have a colon)
	 */
	public static void registerItem(Item item, String regName) {
		if(itemRegistry.get(regName) != null) return;
		GameRegistry.registerItem(item, regName);
		itemRegistry.put(regName, item);
	}
	
	public static Item registerItem(String name) {
		return new ItemExtension(name).register();
	}
	
	public static Item registerShield(ToolMaterial material) {
		return new ItemShield(material).register();
	}
	
	public static Item[] registerArmorSet(Class<? extends ItemArmorExtension> clazz, String baseName, ArmorMaterial mat) {
		return ItemUtils.generateArmor(clazz, baseName, mat);
	}
	
	public static Item registerWeapon(ToolMaterial material, WeaponType type) {
		return type.getFactory().createWeapon(material, type);
	}
	
	public static Map<WeaponType, Item> registerWeapons(ToolMaterial material) {
		return ItemUtils.generateWeaponList(material, WeaponType.DAGGER, WeaponType.CLUB, WeaponType.MACE, WeaponType.HAMMER, WeaponType.WARAXE);
	}
	
	private static void registerAllWeapons(ToolMaterial ...materials) {
		for(ToolMaterial m : materials) {
			weaponMap.put(m, registerWeapons(m));
		}
	}
}
