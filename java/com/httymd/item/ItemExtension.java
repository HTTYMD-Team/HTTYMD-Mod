package com.httymd.item;

import com.httymd.api.IRegisterable;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.item.util.ItemUtils;
import com.httymd.util.CreativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * An {@link IRegisterable} of {@link Item}
 * 
 * @author George Albany
 *
 */
public class ItemExtension extends Item implements IRegisterable<Item> {

	public ItemExtension(String name) {
		this(name, CreativeTab.DRAGON_TAB);
	}

	public ItemExtension(String name, CreativeTabs tab) {
		this.setCreativeTab(tab);
		this.setUnlocalizedName(ItemUtils.findUnlocName(name));
		this.setTextureName(ItemUtils.findTextureName(this.getUnlocalizedName()));
	}

	public String getRegistryName() {
		return ItemUtils.findRegistryName(this.getUnlocalizedName());
	}

	@Override
	public Item register() {
		ItemRegistry.registerItem(this, this.getRegistryName());
		return this;
	}
}
