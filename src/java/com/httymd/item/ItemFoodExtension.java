package com.httymd.item;

import com.httymd.HTTYMDMod;
import com.httymd.api.IRegisterable;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.item.util.ItemUtils;
import com.httymd.util.CreativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

/**
 * An {@link IRegisterable} of {@link ItemFood}
 * 
 * @author George Albany
 *
 */
public class ItemFoodExtension extends ItemFood implements IRegisterable<ItemFood> {

	public ItemFoodExtension(String name, int heal, float satu, boolean wolf) {
		this(name, heal, satu, wolf, CreativeTab.DRAGON_TAB);
	}

	public ItemFoodExtension(String name, int heal, float satu, boolean wolf, CreativeTabs tab) {
		super(heal, satu, wolf);
		this.setUnlocalizedName(HTTYMDMod.ID + ":" + name.toLowerCase());
		this.setTextureName(ItemUtils.findTextureName(this.getUnlocalizedName()));
		this.setCreativeTab(tab);
	}

	public String getRegistryName() {
		return ItemUtils.findRegistryName(this.getUnlocalizedName());
	}

	public ItemFood register() {
		ItemRegistry.registerItem(this, this.getRegistryName());
		return this;
	}
}
