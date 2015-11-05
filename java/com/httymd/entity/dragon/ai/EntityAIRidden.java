package com.httymd.entity.dragon.ai;

import com.httymd.entity.EntityDragon;
import com.httymd.item.registry.ItemRegistry;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIRidden extends EntityAIBase {

	protected final EntityLivingBase riddenEntity;

	protected EntityLivingBase rider = null;

	public EntityAIRidden(EntityLivingBase ridden) {
		this.riddenEntity = ridden;
		this.setMutexBits(3);
	}
	
	@Override
	public boolean isInterruptible() {
		return false;
	}

	@Override
	public boolean shouldExecute() {
		if (this.riddenEntity.riddenByEntity != null && this.riddenEntity.riddenByEntity instanceof EntityLivingBase) {
			if (this.riddenEntity instanceof EntityDragon
					&& !((EntityDragon) this.riddenEntity).isRideableBy(this.riddenEntity.riddenByEntity)) {
				return false;
			}
			this.rider = (EntityLivingBase) this.riddenEntity.riddenByEntity;
		}
		return this.rider != null;
	}

	@Override
	public boolean continueExecuting() {
		if (this.riddenEntity instanceof EntityDragon)
			return ((EntityDragon) this.riddenEntity).isRideableBy(this.rider)
					&& this.riddenEntity.riddenByEntity == this.rider;
		return this.riddenEntity.riddenByEntity == this.rider;
	}

	@Override
	public void updateTask() {
		this.applyRotation(this.riddenEntity.prevRotationYaw = this.rider.rotationYaw, this.rider.rotationPitch * 0.5F);
		this.riddenEntity.rotationYawHead = this.riddenEntity.renderYawOffset = this.riddenEntity.rotationYaw;
		float strafe = this.rider.moveStrafing * 0.5F;
		float forward = this.rider.moveForward;
		forward = forward < 0 ? forward * 0.25F : forward;

		if (this.riddenEntity instanceof EntityDragon) {
			EntityDragon draco = (EntityDragon) this.riddenEntity;
			if (!draco.isFlying()) {
				if (this.rider.getHeldItem() != null && this.rider.getHeldItem().getItem() == ItemRegistry.wing && this.riddenEntity.onGround)
					draco.onTakeoff();
			}
		}
		if(!this.rider.worldObj.isRemote)
			this.riddenEntity.moveEntityWithHeading(strafe, forward);
	}

	@Override
	public void resetTask() {
		this.rider = null;
	}

	protected final void applyRotation(float yaw, float pitch) {
		if (this.riddenEntity instanceof EntityDragon) {
			EntityDragon d = (EntityDragon) this.riddenEntity;
			yaw = (float) Math.min(yaw, d.getFlyYaw());
			pitch = (float) Math.min(pitch, d.getFlyPitch());
		}
		this.riddenEntity.rotationYaw = yaw % 360;
		this.riddenEntity.rotationPitch = pitch % 360;
	}

}
