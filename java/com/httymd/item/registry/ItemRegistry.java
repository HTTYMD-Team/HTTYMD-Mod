package com.httymd.item.registry;

import java.util.HashMap;

import com.google.common.collect.Multimap;
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
import com.httymd.item.util.EnumFoodType;
import com.httymd.item.util.EnumToolType;
import com.httymd.item.util.EnumWeaponType;
import com.httymd.item.util.ItemUtils;
import com.httymd.util.Utils;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class ItemRegistry {

	private final static String swordN = "sword";

	private final static float swordD = 4f;

	public static final HashMap<Integer, ItemSpawnEgg> spawnEggIDMapping = new HashMap<Integer, ItemSpawnEgg>();
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
	public static Multimap<EnumFoodType, Item> foods;
	public static Item gronkleIronIngot;
	public static Item wing;
	public static Item flameSword;

	//public static ItemContainer zippleGasContainer;
	//public static ItemContainer nightmareSalivaContainer;

	public static void init() {

		daggerWood = new ItemDaggerBg2(ToolMaterial.WOOD).registerItem();
		clubWood = new ItemWeapon(ToolMaterial.WOOD, EnumWeaponType.CLUB).registerItem();
		maceWood = new ItemWeapon(ToolMaterial.WOOD, EnumWeaponType.MACE).registerItem();
		hammerWood = new ItemWarhammerBg2(ToolMaterial.WOOD).registerItem();
		waraxeWood = new ItemWeapon(ToolMaterial.WOOD, EnumWeaponType.WARAXE).registerItem();

		daggerStone = new ItemDaggerBg2(ToolMaterial.STONE).registerItem();
		clubStone = new ItemWeapon(ToolMaterial.STONE, EnumWeaponType.CLUB).registerItem();
		maceStone = new ItemWeapon(ToolMaterial.STONE, EnumWeaponType.MACE).registerItem();
		hammerStone = new ItemWarhammerBg2(ToolMaterial.STONE).registerItem();
		waraxeStone = new ItemWeapon(ToolMaterial.STONE, EnumWeaponType.WARAXE).registerItem();

		daggerIron = Utils.shouldForceBg2Daggers() ? new ItemDaggerBg2(ToolMaterial.IRON).registerItem()
				: new ItemWeapon(ToolMaterial.IRON, EnumWeaponType.DAGGER).registerItem();
		clubIron = new ItemWeapon(ToolMaterial.IRON, EnumWeaponType.CLUB).registerItem();
		maceIron = new ItemWeapon(ToolMaterial.IRON, EnumWeaponType.MACE).registerItem();
		hammerIron = new ItemWarhammerBg2(ToolMaterial.IRON).registerItem();
		waraxeIron = new ItemWeapon(ToolMaterial.IRON, EnumWeaponType.WARAXE).registerItem();

		daggerGold = Utils.shouldForceBg2Daggers() ? new ItemDaggerBg2(ToolMaterial.GOLD).registerItem()
				: new ItemWeapon(ToolMaterial.GOLD, EnumWeaponType.DAGGER).registerItem();
		clubGold = new ItemWeapon(ToolMaterial.GOLD, EnumWeaponType.CLUB).registerItem();
		maceGold = new ItemWeapon(ToolMaterial.GOLD, EnumWeaponType.MACE).registerItem();
		hammerGold = new ItemWarhammerBg2(ToolMaterial.GOLD).registerItem();
		waraxeGold = new ItemWeapon(ToolMaterial.GOLD, EnumWeaponType.WARAXE).registerItem();

		daggerDiam = Utils.shouldForceBg2Daggers() ? new ItemDaggerBg2(ToolMaterial.EMERALD).registerItem()
				: new ItemWeapon(ToolMaterial.EMERALD, EnumWeaponType.DAGGER).registerItem();
		clubDiam = new ItemWeapon(ToolMaterial.EMERALD, EnumWeaponType.CLUB).registerItem();
		maceDiam = new ItemWeapon(ToolMaterial.EMERALD, EnumWeaponType.MACE).registerItem();
		hammerDiam = new ItemWarhammerBg2(ToolMaterial.EMERALD).registerItem();
		waraxeDiam = new ItemWeapon(ToolMaterial.EMERALD, EnumWeaponType.WARAXE).registerItem();

		daggerGron = new ItemDaggerBg2(MaterialRegistry.toolGronkle).registerItem();
		clubGron = new ItemWeapon(MaterialRegistry.toolGronkle, EnumWeaponType.CLUB).registerItem();
		maceGron = new ItemWeapon(MaterialRegistry.toolGronkle, EnumWeaponType.MACE).registerItem();
		hammerGron = new ItemWarhammerBg2(MaterialRegistry.toolGronkle).registerItem();
		waraxeGron = new ItemWeapon(MaterialRegistry.toolGronkle, EnumWeaponType.WARAXE).registerItem();

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

		foods = EnumFoodType.generateFood();

		ItemUtils.addFish(new ItemStack(foods.get(EnumFoodType.CRAB).iterator().next(), 1), 50);
	}

	/**
	 * Registers item using a string name (for consistency with 1.8)
	 * @param item Item to register
	 * @param regName Name to register item (mustn't have a colon)
	 */
	public static void registerItem(Item item, String regName) {
		GameRegistry.registerItem(item, regName);
		itemRegistry.put(regName, item);
	}
}
