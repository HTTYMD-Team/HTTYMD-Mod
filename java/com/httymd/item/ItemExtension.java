package com.httymd.item;

import com.httymd.item.registry.IRegisterable;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.item.util.ItemUtils;
import com.httymd.util.CreativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemExtension extends Item implements IRegisterable {

	public ItemExtension(String name, CreativeTabs tab) {
		this.setCreativeTab(tab);
		this.setUnlocalizedName(ItemUtils.findUnlocName(name));
		this.setTextureName(ItemUtils.findTextureName(this.getUnlocalizedName()));
	}

	public ItemExtension(String name) {
		this(name, CreativeTab.DRAGON_TAB);
	}

	public String getRegistryName() {
		return ItemUtils.findRegistryName(this.getUnlocalizedName());
	}

	public Item registerItem() {
		ItemRegistry.registerItem(this, this.getRegistryName());
		return this;
	}
}
