package com.httymd.entity.dragon;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

import com.httymd.entity.EntityDragon;

public class EntityTerribleTerror extends EntityDragon {

	public EntityTerribleTerror(World world) {
		super(world);
		setSize(1, 1);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2F);
	}
}
