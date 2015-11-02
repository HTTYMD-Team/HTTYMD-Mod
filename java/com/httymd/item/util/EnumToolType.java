package com.httymd.item.util;

import java.util.Set;

import net.minecraft.block.Block;

/**
 * An enum designated to hold types of tools for easier registry managment
 * 
 * @author George Albany
 *
 */
public enum EnumToolType {

	PICKAXE(2.0F), AXE(3.0F), SHOVEL(1.0F), HOE(0.0F);

	private String toolName;
	private float naturalDamage;
	private Set<Block> effectiveBlocks;

	private EnumToolType(float damage) {
		this.toolName = this.toString().toLowerCase();
		this.naturalDamage = damage;
		this.effectiveBlocks = null;
	}

	private EnumToolType(String name, Set<Block> effectiveBlocks, float damage) {
		this.toolName = name.toLowerCase();
		this.naturalDamage = damage;
		this.effectiveBlocks = effectiveBlocks;
	}

	public String getName() {
		return toolName;
	}

	public float getAttackDamage() {
		return this.naturalDamage;
	}

	public Set<Block> getEffectiveBlocks() {
		if (this.effectiveBlocks == null)
			effectiveBlocks = ItemUtils.getEffectiveForToolType(this);
		return this.effectiveBlocks;
	}
}
