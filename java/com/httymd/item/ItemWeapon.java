package com.httymd.item;

import java.util.HashMap;
import java.util.Iterator;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.httymd.item.registry.IRegisterable;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.item.util.EnumWeaponType;
import com.httymd.item.util.ItemUtils;
import com.httymd.util.CreativeTab;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

/**
 * A generic ItemWeapon class for ease of weapon creation, and handles fuel for fuel items
 * 
 * @author George Albany
 *
 */
public class ItemWeapon extends ItemSword implements IRegisterable, IFuelHandler {
	
	private static final HashMap<ToolMaterial, HashMap<EnumWeaponType, ItemWeapon>> weaponMap = new HashMap<ToolMaterial, HashMap<EnumWeaponType, ItemWeapon>>();
	
	protected float attackDamage;
	protected EnumWeaponType type = null;

	public ItemWeapon(Item.ToolMaterial mat, EnumWeaponType wepType) {
		this(mat, wepType.getName(), wepType.getDamage());
		this.type = wepType;
		if(this.type != null && this.type.getFuelTime() > 0) GameRegistry.registerFuelHandler(this);
		registerWeapon(mat, this.type, this);
	}
	
	public ItemWeapon(Item.ToolMaterial toolMaterial, String weaponName, float weaponDamage) {
		this(toolMaterial, weaponName, weaponDamage, CreativeTab.DRAGON_TAB);
	}

	public ItemWeapon(ToolMaterial toolMaterial, String weaponName, float weaponDam, CreativeTabs tab) {
		this(weaponName + "_" + toolMaterial.toString(), toolMaterial, weaponDam, tab);
	}

	public ItemWeapon(String name, ToolMaterial weaponMat, float weaponDam, CreativeTabs tab) {
		super(weaponMat);
		this.setCreativeTab(tab);
		this.attackDamage = weaponDam + weaponMat.getDamageVsEntity();
		this.setUnlocalizedName(ItemUtils.findUnlocName(name));
		this.setTextureName(ItemUtils.findTextureName(this.getUnlocalizedName()));
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(ItemStack stack) {
		Multimap<String, AttributeModifier> multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(),
				new AttributeModifier(field_111210_e, "Weapon Modifier", this.attackDamage, 0)); 
		//1.8: field_111210_e to itemModifierUUID
		return multimap;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack item) {
		return 72000;
	}

	public String getRegistryName() {
		return ItemUtils.findRegistryName(this.getUnlocalizedName());
	}

	/**
	 * Retrieves the weapon's material's base entity attack damage (for 1.8 consistency)
	 */
	public float MaterialAttackDamage() {
		return this.func_150931_i(); //getDamageVsEntity in 1.8
	}

	/**
	 * Retrieves the mining speed for the weapon (for 1.8 consistency)
	 */
	public float MineSpeed(ItemStack item, Block block) {
		return this.func_150893_a(item, block); //getStrVsBlock in 1.8
	}

	public ItemSword registerItem() {
		ItemRegistry.registerItem(this, this.getRegistryName());
		return this;
	}
	
	/**
	 * Whether item is effective against block
	 */
	public boolean func_150897_b(Block block) {
		return this.type == EnumWeaponType.WARAXE && block.getMaterial() == Material.wood;
	}
	
	/**
	 * Retrieves the total modifier amount on an item stack using a modifier name
	 * 
	 * <p>See Battlegear 2's ItemWeapon class for original implementation</p>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public float getModifiedAmount(ItemStack stack, String modifierName) {
		if(modifierName.isEmpty()) return 0; 
		Iterator itr = stack.getAttributeModifiers().get(modifierName).iterator();
		float f = 0;
		while (itr.hasNext()) {
			f += ((AttributeModifier) itr.next()).getAmount();
		}
		return f;
	}

	/**
	 * Retrieves the amount of time able to spend on burning an item
	 */
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == this) {
			return this.getToolMaterialName().equals(ToolMaterial.WOOD.toString()) ? 
					this.type.getFuelTime() + 100 : this.type.getFuelTime();
		}
		return 0;
	}
	
	public static HashMap<EnumWeaponType, ItemWeapon> getWeaponMap(ToolMaterial mat) {
		return weaponMap.get(mat);
	}
	
	public static ItemWeapon getWeaponFor(ToolMaterial mat, EnumWeaponType type) {
		return getWeaponMap(mat).get(type);
	}
	
	private static void registerWeapon(ToolMaterial mat, EnumWeaponType type, ItemWeapon wep) {
		if(mat != null && type != null) {
			if(!weaponMap.containsKey(mat)) {
				weaponMap.put(mat, new HashMap<EnumWeaponType, ItemWeapon>());
			}
			weaponMap.get(mat).put(type, wep);
		}
	}
}
