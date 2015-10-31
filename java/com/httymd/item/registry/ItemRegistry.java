package com.httymd.item.registry;

import java.util.HashMap;

import com.google.common.collect.Multimap;
import com.httymd.item.ItemContainer;
import com.httymd.item.ItemExtension;
import com.httymd.item.ItemFlameSword;
import com.httymd.item.ItemGlideArmor;
import com.httymd.item.ItemSpawnEgg;
import com.httymd.item.ItemToolExtension;
import com.httymd.item.ItemWeapon;
import com.httymd.item.ItemWeaponCrossbow;
import com.httymd.item.util.EnumFoodType;
import com.httymd.item.util.EnumToolType;
import com.httymd.item.util.ItemUtils;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class ItemRegistry {

	private final static String daggerN = "dagger";
	private final static String clubN = "club";
	private final static String maceN = "mace";
	private final static String hammerN = "hammer";
	private final static String waraxeN = "waraxe";
	private final static String swordN = "sword";

	private final static float daggerD = 2f;
	private final static float clubD = 4.5f;
	private final static float maceD = 5f;
	private final static float hammerD = 6.5f;
	private final static float waraxeD = 5.5f;
	private final static float swordD = 4f;

	public static final HashMap<Integer, ItemSpawnEgg> spawnEggIDMapping = new HashMap<Integer, ItemSpawnEgg>();

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

	public static ItemContainer zippleGasContainer;
	public static ItemContainer nightmareSalivaContainer;

	public static void init() {

		daggerWood = new ItemWeapon(ToolMaterial.WOOD, daggerN, daggerD).registerItem();
		clubWood = new ItemWeapon(ToolMaterial.WOOD, clubN, clubD).registerItem();
		maceWood = new ItemWeapon(ToolMaterial.WOOD, maceN, maceD).registerItem();
		hammerWood = new ItemWeapon(ToolMaterial.WOOD, hammerN, hammerD).registerItem();
		waraxeWood = new ItemWeapon(ToolMaterial.WOOD, waraxeN, waraxeD).registerItem();

		daggerStone = new ItemWeapon(ToolMaterial.STONE, daggerN, daggerD).registerItem();
		clubStone = new ItemWeapon(ToolMaterial.STONE, clubN, clubD).registerItem();
		maceStone = new ItemWeapon(ToolMaterial.STONE, maceN, maceD).registerItem();
		hammerStone = new ItemWeapon(ToolMaterial.STONE, hammerN, hammerD).registerItem();
		waraxeStone = new ItemWeapon(ToolMaterial.STONE, waraxeN, waraxeD).registerItem();

		daggerIron = new ItemWeapon(ToolMaterial.IRON, daggerN, daggerD).registerItem();
		clubIron = new ItemWeapon(ToolMaterial.IRON, clubN, clubD).registerItem();
		maceIron = new ItemWeapon(ToolMaterial.IRON, maceN, maceD).registerItem();
		hammerIron = new ItemWeapon(ToolMaterial.IRON, hammerN, hammerD).registerItem();
		waraxeIron = new ItemWeapon(ToolMaterial.IRON, waraxeN, waraxeD).registerItem();

		daggerGold = new ItemWeapon(ToolMaterial.GOLD, daggerN, daggerD).registerItem();
		clubGold = new ItemWeapon(ToolMaterial.GOLD, clubN, clubD).registerItem();
		maceGold = new ItemWeapon(ToolMaterial.GOLD, maceN, maceD).registerItem();
		hammerGold = new ItemWeapon(ToolMaterial.GOLD, hammerN, hammerD).registerItem();
		waraxeGold = new ItemWeapon(ToolMaterial.GOLD, waraxeN, waraxeD).registerItem();

		daggerDiam = new ItemWeapon(ToolMaterial.EMERALD, daggerN, daggerD).registerItem();
		clubDiam = new ItemWeapon(ToolMaterial.EMERALD, clubN, clubD).registerItem();
		maceDiam = new ItemWeapon(ToolMaterial.EMERALD, maceN, maceD).registerItem();
		hammerDiam = new ItemWeapon(ToolMaterial.EMERALD, hammerN, hammerD).registerItem();
		waraxeDiam = new ItemWeapon(ToolMaterial.EMERALD, waraxeN, waraxeD).registerItem();

		daggerGron = new ItemWeapon(MaterialRegistry.toolGronkle, daggerN, daggerD).registerItem();
		clubGron = new ItemWeapon(MaterialRegistry.toolGronkle, clubN, clubD).registerItem();
		maceGron = new ItemWeapon(MaterialRegistry.toolGronkle, maceN, maceD).registerItem();
		hammerGron = new ItemWeapon(MaterialRegistry.toolGronkle, hammerN, hammerD).registerItem();
		waraxeGron = new ItemWeapon(MaterialRegistry.toolGronkle, waraxeN, waraxeD).registerItem();

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

		shieldWood = new ItemExtension("shield_wood").registerItem();
		shieldStone = new ItemExtension("shield_stone").registerItem();
		shieldIron = new ItemExtension("shield_iron").registerItem();
		shieldGold = new ItemExtension("shield_gold").registerItem();
		shieldDiam = new ItemExtension("shield_emerald").registerItem();
		shieldGron = new ItemExtension("shield_gronkle").registerItem();

		// zippleGasContainer = new ItemContainer("zipple_gas_cont", 10.0F,
		// EntityZippleback.class);
		// nightmareSalivaContainer = new ItemContainer("night_saliva_cont",
		// 20.0F, EntityNightmare.class);

		foods = EnumFoodType.generateFood();
		
		ItemUtils.addFish(new ItemStack(foods.get(EnumFoodType.CRAB).iterator().next(), 1), 50);
	}	
	
	/**
     * Only use is for items that don't use meta, or don't do special texture/model junk
     */
    public static void registerItem(Item item, String regName){
    	GameRegistry.registerItem(item, regName);
    }
}
