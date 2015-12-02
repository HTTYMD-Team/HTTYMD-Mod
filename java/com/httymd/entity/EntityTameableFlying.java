package com.httymd.entity;

import java.util.Iterator;

import com.httymd.HTTYMDMod;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityTameableFlying extends EntityTameable implements ITameable, IFlyable {

	///////////////////////////////////////////////////////////////////////////
	// NBT Names
	private static final String NBT_IS_FLYING = "Flying";
	///////////////////////////////////////////////////////////////////////////
	// Entity Attributes
	public static final IAttribute flyingSpeed = new RangedAttribute(null, Utils.getModString("flyingSpeed"), 1D, 0.0D,
			Double.MAX_VALUE).setDescription("Flying Speed").setShouldWatch(true);
	public static final IAttribute flyingYaw = new RangedAttribute(null, Utils.getModString("flyingYaw"), 25D, 0.0D,
			Double.MAX_VALUE).setDescription("Flying Yaw Speed").setShouldWatch(true);
	public static final IAttribute flyingPitch = new RangedAttribute(null, Utils.getModString("flyingPitch"), 20D, 0.0D,
			Double.MAX_VALUE).setDescription("Flying Pitch Speed").setShouldWatch(true);
	///////////////////////////////////////////////////////////////////////////
	// Datawatcher
	public static final int BOOL_WATCHER = 16;
	///////////////////////////////////////////////////////////////////////////

	protected EntityLivingBase owner = null;

	public EntityTameableFlying(World w) {
		super(w);
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(flyingSpeed);
		this.getAttributeMap().registerAttribute(flyingYaw);
		this.getAttributeMap().registerAttribute(flyingPitch);
	}

	protected boolean canDespawn() {
		return !this.isTamed() && this.ticksExisted > 2400;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable mate) {
		try {
			return this.getClass().getConstructor(World.class).newInstance(this.worldObj);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_) {
		return this.unsureFunction(p_142018_1_, p_142018_2_);
	}

	/**
	 * Retrieves the Flight Pitch Delta Speed
	 */
	public double getFlyPitch() {
		return this.getEntityAttribute(flyingPitch).getAttributeValue();
	}

	public double getFlySpeed() {
		return this.getEntityAttribute(flyingSpeed).getAttributeValue();
	}

	/**
	 * Retrieves the Flight Yaw Delta Speed
	 */
	public double getFlyYaw() {
		return this.getEntityAttribute(flyingYaw).getAttributeValue();
	}

	public EntityLivingBase getOwner() {
		if (this.isTamed() == false)
			return null;
		EntityLivingBase result = super.getOwner() instanceof EntityLivingBase ? (EntityLivingBase) super.getOwner() : null;
		if (result == null)
			result = this.owner;
		if (result == null) {
			Iterator<?> it = this.worldObj.getLoadedEntityList().iterator();
			while (it.hasNext()) {
				Entity e = (Entity) it.next();
				if (e == null || !(e instanceof EntityLivingBase))
					continue;
				if (e.getUniqueID().toString().equals(this.getOwnerString())) {
					result = (EntityLivingBase) e;
					break;
				}
			}
		}
		this.owner = result;
		return result;
	}

	public String getOwnerString() {
		return this.func_152113_b();
	}

	public boolean interact(EntityPlayer player) {
		ItemStack hand = player.getCurrentEquippedItem();

		if (hand == null) {
			if (this.interactEmpty(player))
				return true;
		} else if (HTTYMDMod.getConfig().isDebugMode() && hand.getItem() == ItemRegistry.wing)
			this.onTakeoff();
		else if (!this.isTamed() && this.isTameItem(hand) && this.isTameable(player)) {
			if (!player.capabilities.isCreativeMode && --hand.stackSize <= 0)
				player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);

			if (!this.worldObj.isRemote)
				if (this.rand.nextInt(3) == 0) {
					this.setTamed(true);
					//this.setPathToEntity((PathEntity) null);
					this.setAttackTarget((EntityLivingBase) null);
					this.setHealth(20.0F);
					this.setOwnerString(player.getUniqueID().toString());
					this.playTameEffect(true);
					this.worldObj.setEntityState(this, (byte) 7);
					HTTYMDMod.getLogger().info("Entity: " + this + " has been tamed");
				} else {
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte) 6);
					HTTYMDMod.getLogger().info("Entity: " + this + " not been tamed");
				}

			return true;
		}

		return super.interact(player);
	}

	/**
	 * Actions taken with an empty hand, halts interaction this tick if true
	 */
	protected boolean interactEmpty(EntityPlayer player) {
		return false;
	}

	/**
	 * Detects if there are air blocks below the entities lowest bounding box
	 * position based on range, semi-accurate boolean
	 */
	protected boolean isAirBelow(int range) {
		for (int curBlock = 1; curBlock <= range; curBlock++)
			if (!this.worldObj.isAirBlock(new BlockPos(MathHelper.floor_double(this.posX),
					MathHelper.floor_double(this.getEntityBoundingBox().minY) - curBlock, MathHelper.floor_double(this.posZ))))
				return false;
		return true;
	}

	public boolean isBreedingItem(ItemStack p_70877_1_) {
		return false;
	}

	public boolean isFlyable() {
		return true;
	}

	@Override
	public boolean isFlying() {
		if (!this.isFlyable()) {
			this.setFlying(false);
			return false;
		}
		return (this.dataWatcher.getWatchableObjectByte(BOOL_WATCHER) & 32) != 0;
	}

	public boolean isOwner(EntityLivingBase e) {
		return this.func_152114_e(e);
	}

	@Override
	public boolean isTameable(EntityLivingBase tamer) {
		return false;
	}

	@Override
	public boolean isTameItem(ItemStack item) {
		return false;
	}

	@Override
	public void moveEntityWithHeading(float strafe, float forward) {
		if (this.isFlying()) {
			if (!this.isAirBelow(1) && this.motionY < 0 || this.isOffsetPositionInLiquid(1, 1, 1)) {
				// How could you fly in a liquid? :P
				this.setFlying(false);
				this.moveEntityWithHeading(strafe, forward);
				return;
			}
			if (this.motionY < 0)
				this.motionY *= 0.8;
			if (forward < 0)
				forward *= 0.15;

			final float timeSpeedMultipler = 0.91F;

			this.motionX *= timeSpeedMultipler;
			this.motionY *= timeSpeedMultipler;
			this.motionZ *= timeSpeedMultipler;

			this.moveFlying(strafe, forward, (float) this.getFlySpeed());
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
		} else
			super.moveEntityWithHeading(strafe, forward);
	}

	public void onTakeoff() {
		if (!this.isFlying() && this.onGround) {
			this.jump();
			this.motionY += this.getFlySpeed();
		} else
			this.motionY += this.getFlySpeed() * 0.25;
		this.setFlying(true);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		this.setFlying(tag.getBoolean(NBT_IS_FLYING));
	}

	@Override
	public void setFlying(boolean flying) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(BOOL_WATCHER);

		if (flying && this.isFlyable())
			this.dataWatcher.updateObject(BOOL_WATCHER, Byte.valueOf((byte) (b0 | 32)));
		else
			this.dataWatcher.updateObject(BOOL_WATCHER, Byte.valueOf((byte) (b0 & -33)));
	}

	public void setOwnerString(String s) {
		this.func_152115_b(s);
	}

	/**
	 * I have no idea what this function represents (if you know what it does,
	 * please rename)
	 */
	public boolean unsureFunction(EntityLivingBase target, EntityLivingBase targetOwner) {
		return super.func_142018_a(target, targetOwner);
	}

	@Override
	protected void func_180433_a(double fallDistSinceCall, boolean onGround, Block blockBelowBB,
			BlockPos posOfBlockBelowBB) {
		if (this.isFlying())
			this.fallDistance = 0;
		else {
			if (this.fallDistance > 3.2F) {
				this.setFlying(true);
				this.func_180433_a(fallDistSinceCall, onGround, blockBelowBB, posOfBlockBelowBB);
			} else
				super.func_180433_a(fallDistSinceCall, onGround, blockBelowBB, posOfBlockBelowBB);
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setBoolean(NBT_IS_FLYING, this.isFlying());
	}
}