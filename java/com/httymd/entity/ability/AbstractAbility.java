package com.httymd.entity.ability;

import net.minecraft.util.Vec3;

public abstract class AbstractAbility implements IAbility {

	protected Vec3 position;
	protected Vec3 rotation;
	
	public AbstractAbility(Vec3 position, Vec3 rotation) {
		this.position = position;
		this.rotation = rotation;
	}
	
	@Override
	public Vec3 getPosition() {
		return position;
	}

	@Override
	public Vec3 getRotation() {
		return rotation;
	}
}
