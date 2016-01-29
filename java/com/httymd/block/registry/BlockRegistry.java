package com.httymd.block.registry;

import java.util.HashMap;

import com.httymd.block.BlockCompressedExtension;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;

public class BlockRegistry {

	public static final HashMap<String, Block> blockRegistry = new HashMap<String, Block>();
	
	public static Block gronkleIronBlock;
	
	public static void init() {
		gronkleIronBlock = new BlockCompressedExtension("giron_block", MapColor.silverColor).register();
	}
	
	/**
	 * Registers block using a string name (for consistency with 1.8)
	 * @param block Block to register
	 * @param regName Name to register block (mustn't have a colon)
	 */
	public static void registerBlock(Block block, String regName) {
		GameRegistry.registerBlock(block, regName);
		blockRegistry.put(regName, block);
	}
}
