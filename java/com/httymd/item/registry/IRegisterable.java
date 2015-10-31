package com.httymd.item.registry;

import net.minecraft.item.Item;

public interface IRegisterable {

	public String getRegistryName();

	public Item registerItem();

}
