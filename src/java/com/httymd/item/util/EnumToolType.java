package com.httymd.item.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

/**
 * An enum designated to hold types of vanilla tools for easier registry
 * management
 *
 * @author George Albany
 *
 */
public enum EnumToolType {

	PICKAXE(2.0F), AXE(3.0F), SHOVEL(1.0F), HOE(0.0F);

	/**
	 * Retrieves all blocks a collection of {@link EnumToolType EnumToolTypes}
	 * is effective against
	 */
	public static Set<Block> getAllEffectiveBlocksOf(Collection<EnumToolType> types) {
		Set<Block> result = new HashSet<Block>();
		for (EnumToolType t : types)
			result.addAll(t.getEffectiveBlocks());
		return result;
	}

	/**
	 * Retrieves all names of a collection of {@link EnumToolType EnumToolTypes}
	 * into a set
	 */
	public static Set<String> getAllNames(Collection<EnumToolType> types) {
		Set<String> result = new HashSet<String>();
		for (EnumToolType t : types)
			result.add(t.getName());
		return result;
	}

	/**
	 * Retrieves the max possible damage a collection of {@link EnumToolType
	 * EnumToolTypes} can cause to entities
	 */
	public static float getResultDamageOf(Collection<EnumToolType> types) {
		float result = 0;
		for (EnumToolType t : types)
			result = Math.max(result, t.getAttackDamage());
		return result;
	}

	/**
	 * Retrieves an average of fuel time for a collection of {@link EnumToolType
	 * EnumToolTypes}
	 */
	public static int getAverageFuelTime(Collection<EnumToolType> types) {
		int sum = 0;
		for (EnumToolType t : types)
			sum += t.getFuelTime();
		return sum / types.size();
	}

	private String toolName;
	private float naturalDamage;
	private Set<Block> effectiveBlocks;
	private int fuelTime = 150;

	private EnumToolType(float damage) {
		this.toolName = this.toString().toLowerCase();
		this.naturalDamage = damage;
		this.effectiveBlocks = null;
	}

	private EnumToolType(float damage, int fuelTime) {
		this(damage);
		this.fuelTime = fuelTime;
	}

	private EnumToolType(String name, float damage, int fuelTime, Set<Block> effectiveBlocks) {
		this.toolName = name.toLowerCase();
		this.naturalDamage = damage;
		this.fuelTime = fuelTime;
		this.effectiveBlocks = effectiveBlocks;
	}

	/**
	 * Gets a tool type's base damage
	 */
	public float getAttackDamage() {
		return this.naturalDamage;
	}

	/**
	 * Retrieves a fuel time for this tool type
	 * 
	 * <p>
	 * Shall be ignored for fuel registry if value is less then 1
	 * </p>
	 */
	public int getFuelTime() {
		return this.fuelTime;
	}

	/**
	 * Retrieves all effective blocks for a tool
	 * 
	 * <p>
	 * Normal tool types use
	 * {@link ItemUtils#getEffectiveForToolType(EnumToolType)}
	 * </p>
	 */
	public Set<Block> getEffectiveBlocks() {
		if (this.effectiveBlocks == null)
			this.effectiveBlocks = getEffectiveFor(this);
		return this.effectiveBlocks;
	}

	/**
	 * Retrieves the lowercased name for the tool
	 * 
	 * <p>
	 * For use with
	 * {@link net.minecraft.item.ItemTool#getToolClasses(net.minecraft.item.ItemStack)
	 * ItemTool.getToolClasses(ItemStack)}
	 * </p>
	 */
	public String getName() {
		return this.toolName;
	}

	/**
	 * Retrieves effective blocks for each EnumToolType, hard-coded based off of
	 * individual classes
	 */
	public static Set<Block> getEffectiveFor(EnumToolType type) {
		switch (type) {
		case PICKAXE:
			return Sets.newHashSet(new Block[] { Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab,
					Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block,
					Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block,
					Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore,
					Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail,
					Blocks.activator_rail });
		case AXE:
			return Sets.newHashSet(new Block[] { Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest,
					Blocks.pumpkin, Blocks.lit_pumpkin });
		case SHOVEL:
			return Sets.newHashSet(new Block[] { Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel,
					Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium });
		default:
			return Collections.singleton(null);
		}
	}
}
