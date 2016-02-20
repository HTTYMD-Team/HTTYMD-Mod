package com.httymd.entity;

import com.httymd.HTTYMDMod;
import com.httymd.api.entity.IDragon;
import com.httymd.api.entity.IDragonAbility;
import com.httymd.registry.ItemRegistry;
import com.httymd.util.DragonDamageSource;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDragon extends EntityTameableFlying implements IDragon {

	private static final int BOOL_IS_ANGRY = 2;

	private static final String NBT_IS_STARTLED = "IsStartled";

	protected boolean startled;

	public EntityDragon(World world) {
		super(world);
		this.isImmuneToFire = true;
		this.ignoreFrustumCheck = true;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(damageAtt);
	}

	@Override
	public boolean isRideable(Entity rider) {
		return rider != null && rider instanceof EntityLivingBase;
	}

	@Override
	public boolean isRidden() {
		return this.isRideable(this.riddenByEntity);
	}

	private void onMount(Entity mounter) {
		mounter.rotationYaw = this.rotationYaw;
		mounter.rotationPitch = this.rotationPitch;

		if (!this.worldObj.isRemote) {
			mounter.mountEntity(this);
		}
	}

	public void moveEntityWithHeading(float strafe, float forward) {
		if (this.isRidden()) {
			this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
			this.rotationPitch = this.riddenByEntity.rotationPitch * 0.8F;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
			if (this.riddenByEntity instanceof EntityLivingBase) {
				strafe = ((EntityLivingBase) this.riddenByEntity).moveStrafing * 0.5F;
				forward = ((EntityLivingBase) this.riddenByEntity).moveForward;
			}
			forward *= 0.5;
			strafe *= 0.5;
			if (this.isFlying() && forward > 0 && HTTYMDMod.getConfig().getVerticalDragonRiding()) {
				float sin = MathHelper.sin(this.rotationPitch * (float) Math.PI / 180.0F);
				this.motionY += (-sin * forward) * 1.5;
			}
			if (this.worldObj.isRemote)
				return;
		}
		super.moveEntityWithHeading(strafe, forward);
	}
	
	/**
	 * Behavior described when eating food
	 * @param feeder The feeding entity
	 * @param feed The food item
	 * @return Should the item stack will decrease
	 */
	public boolean onFeed(EntityLivingBase feeder, ItemStack feed) {
		if(HTTYMDMod.getConfig().canFeedHeal()) {
			this.setHealth(this.getHealth()+1);
			return true;
		}
		return false;
	}

	public boolean interact(EntityPlayer ply) {
		ItemStack hand = ply.getCurrentEquippedItem();
		if (hand != null) {
			if (HTTYMDMod.getConfig().isDebugMode() && hand.getItem() == ItemRegistry.wing) {
				this.onTakeoff();
				return true;
			} else if (com.httymd.util.ItemUtils.isFood(hand) && !this.canTame(ply, hand) && 
					this.onFeed(ply, hand) && !ply.capabilities.isCreativeMode && --hand.stackSize <= 0) 
						ply.inventory.setInventorySlotContents(ply.inventory.currentItem, (ItemStack) null);
		}

		if (this.isOwner(ply) && this.isRideable(ply)) {
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
				target.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * knockback * 0.5F,
						0.1D, MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * knockback * 0.5F);
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}

			int fire = EnchantmentHelper.getFireAspectModifier(this);

			if (fire > 0)
				target.setFire(fire * 4);

			if (target instanceof EntityLivingBase)
				EnchantmentHelper.func_151384_a((EntityLivingBase) target, this);

			EnchantmentHelper.func_151385_b(this, target);

			return true;
		}
		return false;
	}

	@Override
	protected boolean isAIEnabled() {
		return true;
	}

	public boolean isAngry() {
		return (this.dataWatcher.getWatchableObjectByte(BOOL_WATCHER) & BOOL_IS_ANGRY) != 0;
	}

	public boolean isStartled() {
		return this.startled;
	}

	public boolean isTameable(EntityLivingBase tamer) {
		return !this.isAngry();
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		this.setStartled(tag.getBoolean(NBT_IS_STARTLED));
	}

	/**
	 * Sets whether this dragon is angry or not.
	 */
	public void setAngry(boolean p_70916_1_) {
		byte boolByte = this.dataWatcher.getWatchableObjectByte(BOOL_WATCHER);

		if (p_70916_1_)
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (boolByte | BOOL_IS_ANGRY)));
		else
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (boolByte & -(BOOL_IS_ANGRY + 1))));
	}

	public void setAttackTarget(EntityLivingBase p_70624_1_) {
		super.setAttackTarget(p_70624_1_);

		if (p_70624_1_ == null)
			this.setAngry(false);
		else if (!this.isTamed())
			this.setAngry(true);
	}

	public void setStartled(boolean startled) {
		this.startled = startled;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setBoolean(NBT_IS_STARTLED, this.isStartled());
	}

	/**
	 * Sets isImmuneToFire to false, allows dragon burning
	 * 
	 * <p>
	 * For dragons that are not so fire proof
	 * </p>
	 */
	protected void setNotFireproof() {
		this.isImmuneToFire = false;
	}

	@Override
	public IDragonAbility getDragonAbility() {
		return null;
	}
}
