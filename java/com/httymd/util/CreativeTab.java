package com.httymd.util;

import com.httymd.HTTYMDMod;
import com.httymd.item.ItemExtension;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs {

	public static Item tabIcon = new ItemExtension("tab_icon_item").registerItem().setCreativeTab(null);
	public static final CreativeTab DRAGON_TAB = new CreativeTab(HTTYMDMod.ID + ":mcdTab", tabIcon);

	private final Item icon;

	public CreativeTab(String name, Item icon) {
		super(name);
		this.icon = icon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return this.icon;
	}

}
