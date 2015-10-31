package com.httymd.item;

import com.httymd.HTTYMDMod;
import com.httymd.item.registry.IRegisterable;
import com.httymd.item.util.ItemUtils;
import com.httymd.util.CreativeTab;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorExtension extends ItemArmor implements IRegisterable {

	public ItemArmorExtension(String name, ArmorMaterial mat, int type) {
		this(name, mat, type, CreativeTab.DRAGON_TAB);
	}

	public ItemArmorExtension(String name, ArmorMaterial mat, int type, CreativeTabs tab) {
		super(mat, 2, type);
		this.setUnlocalizedName(ItemUtils.findUnlocName(name));
		this.setTextureName(ItemUtils.findTextureName(this.getUnlocalizedName()));
		this.setCreativeTab(tab);
	}

	public String getRegistryName() {
		return ItemUtils.findRegistryName(this.getUnlocalizedName());
	}

	public ItemArmor registerItem() {
		GameRegistry.registerItem(this, this.getRegistryName());
		return this;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return HTTYMDMod.ID + ":textures/armor/" + getRegistryName().substring(0, getRegistryName().lastIndexOf("_"))
				+ "_" + (slot == 2 ? "2" : "1") + ".png";
	}
}
