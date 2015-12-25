package com.httymd.block.registry;

import com.httymd.item.util.ItemUtils;

import net.minecraft.block.Block;

public interface IRegisterable {

	/**
	 * Retrieves Registry Name for Block (commonly using {@link ItemUtils#findRegistryName(String)}
	 */
	public String getRegistryName();

	/**
	 * Registers the block (commonly using {@link BlockRegistry#registerBlock(Block, String)}
	 */
	public Block registerBlock();
	
}
