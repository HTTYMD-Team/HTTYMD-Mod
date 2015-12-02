package com.httymd.block.registry;

import java.util.HashMap;

import com.httymd.block.BlockCompressedExtension;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

	public static final HashMap<String, Block> blockRegistry = new HashMap<String, Block>();
	
	public static Block gronkleIronBlock;
	
	public static void init() {
		gronkleIronBlock = new BlockCompressedExtension("giron_block", MapColor.silverColor).registerBlock();
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
