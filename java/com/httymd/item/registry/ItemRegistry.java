package com.httymd.item.registry;

import java.util.HashMap;

import com.google.common.collect.Multimap;
import com.httymd.api.item.FoodType;
import com.httymd.api.item.WeaponType;
import com.httymd.bg2.item.ItemDaggerBg2;
import com.httymd.bg2.item.ItemWarhammerBg2;
import com.httymd.item.ItemExtension;
import com.httymd.item.ItemFlameSword;
import com.httymd.item.ItemGlideArmor;
import com.httymd.item.ItemShield;
import com.httymd.item.ItemSpawnEgg;
import com.httymd.item.ItemToolExtension;
import com.httymd.item.ItemWeapon;
import com.httymd.item.ItemWeaponCrossbow;
import com.httymd.item.util.EnumToolType;
import com.httymd.item.util.ItemUtils;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class ItemRegistry {

	private final static String swordN = "sword";

	private final static float swordD = 4f;

	public static final HashMap<String, ItemSpawnEgg> spawnEggIDMapping = new HashMap<String, ItemSpawnEgg>();
	public static final HashMap<String, Item> itemRegistry = new HashMap<String, Item>();

	public static Item daggerWood;
	public static Item clubWood;
	public static Item maceWood;
	public static Item hammerWood;
	public static Item waraxeWood;
	public static Item shieldWood;

	public static Item daggerStone;
	public static Item clubStone;
	public static Item maceStone;
	public static Item hammerStone;
	public static Item waraxeStone;
	public static Item shieldStone;

	public static Item daggerIron;
	public static Item clubIron;
	public static Item maceIron;
	public static Item hammerIron;
	public static Item waraxeIron;
	public static Item shieldIron;

	public static Item daggerGold;
	public static Item clubGold;
	public static Item maceGold;
	public static Item hammerGold;
	public static Item waraxeGold;
	public static Item shieldGold;

	public static Item daggerDiam;
	public static Item clubDiam;
	public static Item maceDiam;
	public static Item hammerDiam;
	public static Item waraxeDiam;
	public static Item shieldDiam;

	public static Item daggerGron;
	public static Item clubGron;
	public static Item maceGron;
	public static Item hammerGron;
	public static Item waraxeGron;
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

		daggerWood = new ItemDaggerBg2(ToolMaterial.WOOD).registerItem();
		clubWood = new ItemWeapon(ToolMaterial.WOOD, WeaponType.CLUB).registerItem();
		maceWood = new ItemWeapon(ToolMaterial.WOOD, WeaponType.MACE).registerItem();
		hammerWood = new ItemWarhammerBg2(ToolMaterial.WOOD).registerItem();
		waraxeWood = new ItemWeapon(ToolMaterial.WOOD, WeaponType.WARAXE).registerItem();

		daggerStone = new ItemDaggerBg2(ToolMaterial.STONE).registerItem();
		clubStone = new ItemWeapon(ToolMaterial.STONE, WeaponType.CLUB).registerItem();
		maceStone = new ItemWeapon(ToolMaterial.STONE, WeaponType.MACE).registerItem();
		hammerStone = new ItemWarhammerBg2(ToolMaterial.STONE).registerItem();
		waraxeStone = new ItemWeapon(ToolMaterial.STONE, WeaponType.WARAXE).registerItem();

		daggerIron = new ItemDaggerBg2(ToolMaterial.IRON).registerItem();
		clubIron = new ItemWeapon(ToolMaterial.IRON, WeaponType.CLUB).registerItem();
		maceIron = new ItemWeapon(ToolMaterial.IRON, WeaponType.MACE).registerItem();
		hammerIron = new ItemWarhammerBg2(ToolMaterial.IRON).registerItem();
		waraxeIron = new ItemWeapon(ToolMaterial.IRON, WeaponType.WARAXE).registerItem();

		daggerGold = new ItemDaggerBg2(ToolMaterial.GOLD).registerItem();
		clubGold = new ItemWeapon(ToolMaterial.GOLD, WeaponType.CLUB).registerItem();
		maceGold = new ItemWeapon(ToolMaterial.GOLD, WeaponType.MACE).registerItem();
		hammerGold = new ItemWarhammerBg2(ToolMaterial.GOLD).registerItem();
		waraxeGold = new ItemWeapon(ToolMaterial.GOLD, WeaponType.WARAXE).registerItem();

		daggerDiam = new ItemDaggerBg2(ToolMaterial.EMERALD).registerItem();
		clubDiam = new ItemWeapon(ToolMaterial.EMERALD, WeaponType.CLUB).registerItem();
		maceDiam = new ItemWeapon(ToolMaterial.EMERALD, WeaponType.MACE).registerItem();
		hammerDiam = new ItemWarhammerBg2(ToolMaterial.EMERALD).registerItem();
		waraxeDiam = new ItemWeapon(ToolMaterial.EMERALD, WeaponType.WARAXE).registerItem();

		daggerGron = new ItemDaggerBg2(MaterialRegistry.toolGronkle).registerItem();
		clubGron = new ItemWeapon(MaterialRegistry.toolGronkle, WeaponType.CLUB).registerItem();
		maceGron = new ItemWeapon(MaterialRegistry.toolGronkle, WeaponType.MACE).registerItem();
		hammerGron = new ItemWarhammerBg2(MaterialRegistry.toolGronkle).registerItem();
		waraxeGron = new ItemWeapon(MaterialRegistry.toolGronkle, WeaponType.WARAXE).registerItem();

		swordGron = new ItemWeapon(MaterialRegistry.toolGronkle, swordN, swordD).registerItem();
		shovelGron = new ItemToolExtension(MaterialRegistry.toolGronkle, EnumToolType.SHOVEL).registerItem();
		pickaxeGron = new ItemToolExtension(MaterialRegistry.toolGronkle, EnumToolType.PICKAXE).registerItem();
		axeGron = new ItemToolExtension(MaterialRegistry.toolGronkle, EnumToolType.AXE).registerItem();
		hoeGron = new ItemToolExtension(MaterialRegistry.toolGronkle, EnumToolType.HOE).registerItem();

		crossbow = new ItemWeaponCrossbow("crossbow", 2).registerItem();

		glideSuit = ItemUtils.generateArmor(ItemGlideArmor.class, "gsuit", ArmorMaterial.IRON);

		gronkleIronIngot = new ItemExtension("giron_ingot").registerItem();
		wing = new ItemExtension("wing_item").registerItem();
		flameSword = new ItemFlameSword(ToolMaterial.IRON, "flame_sword", swordD).registerItem();

		shieldWood = new ItemShield(ToolMaterial.WOOD).registerItem();
		shieldStone = new ItemShield(ToolMaterial.STONE).registerItem();
		shieldIron = new ItemShield(ToolMaterial.IRON).registerItem();
		shieldGold = new ItemShield(ToolMaterial.GOLD).registerItem();
		shieldDiam = new ItemShield(ToolMaterial.EMERALD).registerItem();
		shieldGron = new ItemShield(MaterialRegistry.toolGronkle).registerItem();

		// zippleGasContainer = new ItemContainer("zipple_gas_cont", 10.0F,
		// EntityZippleback.class);
		// nightmareSalivaContainer = new ItemContainer("night_saliva_cont",
		// 20.0F, EntityNightmare.class);

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
}
