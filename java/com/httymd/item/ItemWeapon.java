package com.httymd.item;

import java.util.Iterator;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.httymd.item.registry.IRegisterable;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.item.util.EnumWeaponType;
import com.httymd.item.util.ItemUtils;
import com.httymd.util.CreativeTab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemWeapon extends ItemSword implements IRegisterable {
	
	protected float attackDamage;
	protected EnumWeaponType type;

	public ItemWeapon(Item.ToolMaterial mat, EnumWeaponType wepType) {
		this(mat, wepType.getName(), wepType.getDamage());
		this.type = wepType;
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

	public float MaterialAttackDamage() {
		return this.func_150931_i(); //getDamageVsEntity in 1.8
	}

	public float MineSpeed(ItemStack item, Block block) {
		return this.func_150893_a(item, block); //getStrVsBlock in 1.8
	}

	public ItemSword registerItem() {
		ItemRegistry.registerItem(this, this.getRegistryName());
		return this;
	}
	
	public boolean func_150897_b(Block block) {
		return this.type == EnumWeaponType.WARAXE && block.getMaterial() == Material.wood;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public float getModifiedAmount(ItemStack stack, String modifierName) {
		if(modifierName.equals("")) return 0; 
		Iterator itr = stack.getAttributeModifiers().get(modifierName).iterator();
		float f = 0;
		while (itr.hasNext()) {
			f += ((AttributeModifier) itr.next()).getAmount();
		}
		return f;
	}
}
