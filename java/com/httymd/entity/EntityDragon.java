package com.httymd.entity;

import com.httymd.util.DragonDamageSource;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDragon extends EntityTameableFlying {

	private static final int BOOL_IS_ANGRY = 2;

	private static final String NBT_IS_STARTLED = "IsStartled";

	protected boolean isStartled = false;

	public EntityDragon(World world) {
		super(world);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
	}

	@Override
	protected boolean isAIEnabled() {
		return true;
	}

	public boolean isTameable(EntityLivingBase tamer) {
		return !this.isAngry();
	}

	public boolean isStartled() {
		return this.isStartled;
	}

	public boolean isRideableBy(Entity rider) {
		return this.riddenByEntity == null || rider == this.riddenByEntity;
	}

	public void setStartled(boolean startled) {
		this.isStartled = startled;
	}

	public void setAttackTarget(EntityLivingBase p_70624_1_) {
		super.setAttackTarget(p_70624_1_);

		if (p_70624_1_ == null) {
			this.setAngry(false);
		} else if (!this.isTamed()) {
			this.setAngry(true);
		}
	}

	public boolean isAngry() {
		return (this.dataWatcher.getWatchableObjectByte(BOOL_WATCHER) & BOOL_IS_ANGRY) != 0;
	}

	/**
	 * Sets whether this dragon is angry or not.
	 */
	public void setAngry(boolean p_70916_1_) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(BOOL_WATCHER);

		if (p_70916_1_) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | BOOL_IS_ANGRY)));
		} else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -(BOOL_IS_ANGRY + 1))));
		}
	}

	private void onMount(Entity mounter) {
		mounter.rotationYaw = this.rotationYaw;
		mounter.rotationPitch = this.rotationPitch;

		if (!this.worldObj.isRemote) {
			mounter.mountEntity(this);
		}
	}

	public boolean interact(EntityPlayer ply) {
		if (this.isOwner(ply) && this.isRideableBy(ply)) {
			this.onMount(ply);
			return true;
		}
		return super.interact(ply);
	}

	@Override
	public boolean attackEntityAsMob(Entity target) {
		double damage = 2.0D;

		int knockback = 0;

		if (target instanceof EntityLivingBase) {
			damage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) target);
			knockback += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) target);
		}

		if (target.attackEntityFrom(DragonDamageSource.getDirectDamage(this), (float) damage)) {
			if (knockback > 0) {
				target.addVelocity(
						(double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * (float) knockback
								* 0.5F),
						0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (float) knockback
								* 0.5F));
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}

			int fire = EnchantmentHelper.getFireAspectModifier(this);

			if (fire > 0) {
				target.setFire(fire * 4);
			}

			if (target instanceof EntityLivingBase) {
				EnchantmentHelper.func_151384_a((EntityLivingBase) target, this);
			}

			EnchantmentHelper.func_151385_b(this, target);

			return true;
		}
		return false;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setBoolean(NBT_IS_STARTLED, this.isStartled());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		this.setStartled(tag.getBoolean(NBT_IS_STARTLED));
	}
}
