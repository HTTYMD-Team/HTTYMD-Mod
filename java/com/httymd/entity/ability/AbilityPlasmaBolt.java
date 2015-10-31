package com.httymd.entity.ability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class AbilityPlasmaBolt extends AbstractAbility {

	public AbilityPlasmaBolt(Vec3 position, Vec3 rotation) {
		super(position, rotation);
	}

	@Override
	public Entity onStart(IAbilityUser user) {
		Entity e = null;
		if(user instanceof Entity) e = (Entity) user;
		return new EntityPlasmaBolt(e.worldObj, e, 5.0F);
	}

	@Override
	public void onEnd(IAbilityUser user) {
	}
	
	public static class EntityPlasmaBolt extends Entity implements IProjectile {

	    protected Entity shooter;
	    protected float strength;
		
		public EntityPlasmaBolt(World world) {
			super(world);
	        this.renderDistanceWeight = 10.0D;
	        this.setSize(0.5F, 0.5F);
		}
		
		public EntityPlasmaBolt(World world, Entity user, float strength) {
			this(world);
			this.shooter = user;
			this.strength = strength;

	        this.setLocationAndAngles(user.posX, user.posY + (double)user.getEyeHeight(), user.posZ, user.rotationYaw, user.rotationPitch);
	        this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
	        this.posY -= 0.10000000149011612D;
	        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
	        this.setPosition(this.posX, this.posY, this.posZ);
	        this.yOffset = 0.0F;
	        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
	        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
	        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
	        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, strength * 1.5F, 1.0F);
		}

		@Override
		protected void entityInit() {
		}

		@Override
		protected void readEntityFromNBT(NBTTagCompound tag) {
			this.strength = tag.getFloat("FireStrength");
		}

		@Override
		protected void writeEntityToNBT(NBTTagCompound tag) {
			tag.setFloat("FireStrength", this.strength);
		}

		@Override
		public void setThrowableHeading(double p_70186_1_, double p_70186_3_, double p_70186_5_, float p_70186_7_,float p_70186_8_) {			
			float f2 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_3_ * p_70186_3_ + p_70186_5_ * p_70186_5_);
	        p_70186_1_ /= (double)f2;
	        p_70186_3_ /= (double)f2;
	        p_70186_5_ /= (double)f2;
	        p_70186_1_ += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)p_70186_8_;
	        p_70186_3_ += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)p_70186_8_;
	        p_70186_5_ += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)p_70186_8_;
	        p_70186_1_ *= (double)p_70186_7_;
	        p_70186_3_ *= (double)p_70186_7_;
	        p_70186_5_ *= (double)p_70186_7_;
	        this.motionX = p_70186_1_;
	        this.motionY = p_70186_3_;
	        this.motionZ = p_70186_5_;
	        float f3 = MathHelper.sqrt_double(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
	        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(p_70186_1_, p_70186_5_) * 180.0D / Math.PI);
	        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(p_70186_3_, (double)f3) * 180.0D / Math.PI);
		}
		
		@Override
		public void onUpdate() {
			super.onUpdate();
			
			if(this.isCollided) {
				this.worldObj.newExplosion(this.shooter, this.posX, this.posY, this.posZ, this.strength*2, false, true);
			}
			
			this.posX += this.motionX;
			this.posY += this.motionY;
			this.posZ += this.motionZ;
		}
		
	}

}
