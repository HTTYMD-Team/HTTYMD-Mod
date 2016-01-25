package com.httymd.item;

import com.httymd.HTTYMDMod;
import com.httymd.item.registry.IRegisterable;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.item.util.ItemUtils;
import com.httymd.item.util.ItemUtils.EnumArmorType;
import com.httymd.util.CreativeTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Am {@link IRegisterable} of {@link ItemArmor}, with some ease of use methods
 * 
 * @author George Albany
 * 
 */
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

	/**
	 * Retrieves armor texture based on name 
	 * 
	 * <p>Directory in &lt;modid&gt;:textures/armor/&lt;name&gt;_<1 or 2>.png</p>
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return HTTYMDMod.ID + ":textures/armor/"
				+ this.getRegistryName().substring(0, this.getRegistryName().lastIndexOf("_")) + "_"
				+ (slot == EnumArmorType.LEGGINGS.ordinalReverse() ? "2" : "1") + ".png";
	}

	public String getRegistryName() {
		return ItemUtils.findRegistryName(this.getUnlocalizedName());
	}

	public ItemArmor registerItem() {
		ItemRegistry.registerItem(this, this.getRegistryName());
		return this;
	}
}
