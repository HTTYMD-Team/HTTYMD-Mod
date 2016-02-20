package com.httymd.item;

import com.httymd.HTTYMDMod;
import com.httymd.api.IRegisterable;
import com.httymd.creativetab.CreativeTab;
import com.httymd.registry.ItemRegistry;
import com.httymd.util.ItemUtils;

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

	@Override
	public String getRegistryName() {
		return ItemUtils.findRegistryName(this.getUnlocalizedName());
	}

	@Override
	public ItemFood register() {
		ItemRegistry.registerItem(this, this.getRegistryName());
		return this;
	}
}
