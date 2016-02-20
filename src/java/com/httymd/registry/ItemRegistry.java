package com.httymd.registry;

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
import com.httymd.util.ItemUtils;

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

		daggerWood = new ItemDaggerBg2(ToolMaterial.WOOD).register();
		clubWood = new ItemWeapon(ToolMaterial.WOOD, WeaponType.CLUB).register();
		maceWood = new ItemWeapon(ToolMaterial.WOOD, WeaponType.MACE).register();
		hammerWood = new ItemWarhammerBg2(ToolMaterial.WOOD).register();
		waraxeWood = new ItemWeapon(ToolMaterial.WOOD, WeaponType.WARAXE).register();

		daggerStone = new ItemDaggerBg2(ToolMaterial.STONE).register();
		clubStone = new ItemWeapon(ToolMaterial.STONE, WeaponType.CLUB).register();
		maceStone = new ItemWeapon(ToolMaterial.STONE, WeaponType.MACE).register();
		hammerStone = new ItemWarhammerBg2(ToolMaterial.STONE).register();
		waraxeStone = new ItemWeapon(ToolMaterial.STONE, WeaponType.WARAXE).register();

		daggerIron = new ItemDaggerBg2(ToolMaterial.IRON).register();
		clubIron = new ItemWeapon(ToolMaterial.IRON, WeaponType.CLUB).register();
		maceIron = new ItemWeapon(ToolMaterial.IRON, WeaponType.MACE).register();
		hammerIron = new ItemWarhammerBg2(ToolMaterial.IRON).register();
		waraxeIron = new ItemWeapon(ToolMaterial.IRON, WeaponType.WARAXE).register();

		daggerGold = new ItemDaggerBg2(ToolMaterial.GOLD).register();
		clubGold = new ItemWeapon(ToolMaterial.GOLD, WeaponType.CLUB).register();
		maceGold = new ItemWeapon(ToolMaterial.GOLD, WeaponType.MACE).register();
		hammerGold = new ItemWarhammerBg2(ToolMaterial.GOLD).register();
		waraxeGold = new ItemWeapon(ToolMaterial.GOLD, WeaponType.WARAXE).register();

		daggerDiam = new ItemDaggerBg2(ToolMaterial.EMERALD).register();
		clubDiam = new ItemWeapon(ToolMaterial.EMERALD, WeaponType.CLUB).register();
		maceDiam = new ItemWeapon(ToolMaterial.EMERALD, WeaponType.MACE).register();
		hammerDiam = new ItemWarhammerBg2(ToolMaterial.EMERALD).register();
		waraxeDiam = new ItemWeapon(ToolMaterial.EMERALD, WeaponType.WARAXE).register();

		daggerGron = new ItemDaggerBg2(MaterialRegistry.toolGronkle).register();
		clubGron = new ItemWeapon(MaterialRegistry.toolGronkle, WeaponType.CLUB).register();
		maceGron = new ItemWeapon(MaterialRegistry.toolGronkle, WeaponType.MACE).register();
		hammerGron = new ItemWarhammerBg2(MaterialRegistry.toolGronkle).register();
		waraxeGron = new ItemWeapon(MaterialRegistry.toolGronkle, WeaponType.WARAXE).register();

		swordGron = new ItemWeapon(MaterialRegistry.toolGronkle, swordN, swordD).register();
		shovelGron = new ItemToolExtension(MaterialRegistry.toolGronkle, EnumToolType.SHOVEL).register();
		pickaxeGron = new ItemToolExtension(MaterialRegistry.toolGronkle, EnumToolType.PICKAXE).register();
		axeGron = new ItemToolExtension(MaterialRegistry.toolGronkle, EnumToolType.AXE).register();
		hoeGron = new ItemToolExtension(MaterialRegistry.toolGronkle, EnumToolType.HOE).register();

		crossbow = new ItemWeaponCrossbow("crossbow", 2).register();

		glideSuit = ItemUtils.generateArmor(ItemGlideArmor.class, "gsuit", ArmorMaterial.IRON);

		gronkleIronIngot = new ItemExtension("giron_ingot").register();
		wing = new ItemExtension("wing_item").register();
		flameSword = new ItemFlameSword(ToolMaterial.IRON, "flame_sword", swordD).register();

		shieldWood = new ItemShield(ToolMaterial.WOOD).register();
		shieldStone = new ItemShield(ToolMaterial.STONE).register();
		shieldIron = new ItemShield(ToolMaterial.IRON).register();
		shieldGold = new ItemShield(ToolMaterial.GOLD).register();
		shieldDiam = new ItemShield(ToolMaterial.EMERALD).register();
		shieldGron = new ItemShield(MaterialRegistry.toolGronkle).register();

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
