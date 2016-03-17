package com.httymd.api;

import com.httymd.registry.BlockRegistry;
import com.httymd.registry.ItemRegistry;
import com.httymd.util.ItemUtils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * A registry consistent interface
 * 
 * @author George Albany
 *
 */
public interface IRegisterable<T> {

	/**
	 * Retrieves Registry Name for the object (commonly using
	 * {@link ItemUtils#findRegistryName(String)}
	 */
	public String getRegistryName();

	/**
	 * Registers the object ({@link ItemRegistry#registerItem(Item, String)} for
	 * items, {@link BlockRegistry#registerBlock(Block, String)} for blocks)
	 * 
	 * @Warn External use may not be trustworthy
	 */
	public T register();

}