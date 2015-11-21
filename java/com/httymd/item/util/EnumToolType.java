package com.httymd.item.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;

/**
 * An enum designated to hold types of tools for easier registry management
 *
 * @author George Albany
 *
 */
public enum EnumToolType {

	PICKAXE(2.0F), AXE(3.0F), SHOVEL(1.0F), HOE(0.0F);

	public static Set<Block> getAllEffectiveBlocksOf(Collection<EnumToolType> types) {
		Set<Block> result = new HashSet<Block>();
		for (EnumToolType t : types)
			result.addAll(t.getEffectiveBlocks());
		return result;
	}

	public static Set<String> getAllNames(Collection<EnumToolType> types) {
		Set<String> result = new HashSet<String>();
		for (EnumToolType t : types)
			result.add(t.getName());
		return result;
	}

	public static float getResultDamageOf(Collection<EnumToolType> types) {
		float result = 0;
		for (EnumToolType t : types)
			result = Math.max(result, t.getAttackDamage());
		return result;
	}

	private String toolName;
	private float naturalDamage;
	private Set<Block> effectiveBlocks;

	private EnumToolType(float damage) {
		this.toolName = this.toString().toLowerCase();
		this.naturalDamage = damage;
		this.effectiveBlocks = null;
	}

	private EnumToolType(String name, float damage, Set<Block> effectiveBlocks) {
		this.toolName = name.toLowerCase();
		this.naturalDamage = damage;
		this.effectiveBlocks = effectiveBlocks;
	}

	public float getAttackDamage() {
		return this.naturalDamage;
	}

	public Set<Block> getEffectiveBlocks() {
		if (this.effectiveBlocks == null)
			this.effectiveBlocks = ItemUtils.getEffectiveForToolType(this);
		return this.effectiveBlocks;
	}

	public String getName() {
		return this.toolName;
	}
}
