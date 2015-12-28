package com.httymd.entity;

import java.util.Iterator;

import com.httymd.HTTYMDMod;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.util.Utils;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityTameableFlying extends EntityTameable implements ITameable, IFlyable {

	///////////////////////////////////////////////////////////////////////////
	// NBT Names
	private static final String NBT_IS_FLYING = "Flying";
	///////////////////////////////////////////////////////////////////////////
	// Entity Attributes
	public static final IAttribute flyingSpeed = new RangedAttribute(Utils.getModString("flyingSpeed"), 1D, 0.0D,
			Double.MAX_VALUE).setDescription("Flying Speed").setShouldWatch(true);
	public static final IAttribute flyingYaw = new RangedAttribute(Utils.getModString("flyingYaw"), 25D, 0.0D,
			Double.MAX_VALUE).setDescription("Flying Yaw Speed").setShouldWatch(true);
	public static final IAttribute flyingPitch = new RangedAttribute(Utils.getModString("flyingPitch"), 20D, 0.0D,
			Double.MAX_VALUE).setDescription("Flying Pitch Speed").setShouldWatch(true);
	///////////////////////////////////////////////////////////////////////////
	// Datawatcher
	public static final int BOOL_WATCHER = 16;
	///////////////////////////////////////////////////////////////////////////

	protected static final IAttribute healthAtt = SharedMonsterAttributes.maxHealth;
	protected static final IAttribute speedAtt = SharedMonsterAttributes.movementSpeed;
	protected static final IAttribute damageAtt = SharedMonsterAttributes.attackDamage;
	
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
	
	public String getOwnerString() {
		return this.func_152113_b();
	}

	/**
	 * Detects if there are air blocks below the entities lowest bounding box
	 * position based on range, centered on entity's x/z axis
	 */
	public boolean isAirBelow(int range) {
		for (int curBlock = 1; curBlock <= range; curBlock++)
			if (!this.worldObj.isAirBlock(MathHelper.floor_double(this.posX),
					MathHelper.floor_double(this.boundingBox.minY) - curBlock, MathHelper.floor_double(this.posZ)))
				return false;
		return true;
	}

	/**
	 * Retrieves if this entity is inside a liquid material (provides a better
	 * cross-mod implementation then {@link Entity#isInsideOfMaterial(Material)}
	 * )
	 */
	private boolean isInLiquid() {
		return this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY),
				MathHelper.floor_double(this.posZ)).getMaterial().isLiquid();
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
	public boolean canTame(EntityLivingBase tamer, ItemStack item) {
		return item.getItem() == Items.fish && HTTYMDMod.getConfig().isTameable(this);
	}

	@Override
	public void moveEntityWithHeading(float strafe, float forward) {
		if (this.isFlying()) {
			if ((!this.isAirBelow(1) && this.motionY < -0.1) || this.isInLiquid()) {
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
		}// else
			//this.motionY += this.getFlySpeed() * 0.25;
		this.setFlying(true);
	}

	@Override
	public void setFlying(boolean flying) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(BOOL_WATCHER);

		if (flying && this.isFlyable())
			this.dataWatcher.updateObject(BOOL_WATCHER, Byte.valueOf((byte) (b0 | 32)));
		else
			this.dataWatcher.updateObject(BOOL_WATCHER, Byte.valueOf((byte) (b0 & -33)));
	}
	
	public EntityLivingBase getOwner() {
		EntityLivingBase result = this.owner != null ? this.owner : super.getOwner();
		if (result == null) {
			Iterator<?> it = this.worldObj.loadedEntityList.iterator();
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
		if (this.owner != null)
			this.setTamed(true);
		return result;
	}

	/**
	 * Determines whether our owner should be defended
	 */
	public boolean shouldDefendOwner(EntityLivingBase attacker, EntityLivingBase ourOwner) {
		return super.func_142018_a(attacker, ourOwner);
	}
	
	public void setOwnerString(String s) {
		this.func_152115_b(s);
	}

	@Override
	protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
		if (this.isFlying()) {
			this.fallDistance = 0;
		} else if (this.fallDistance > 3.2F) {
			this.setFlying(true);
			this.updateFallState(p_70064_1_, p_70064_3_);
		}
		super.updateFallState(p_70064_1_, p_70064_3_);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setBoolean(NBT_IS_FLYING, this.isFlying());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		this.setFlying(tag.getBoolean(NBT_IS_FLYING));
	}

	public boolean interact(EntityPlayer player) {
		ItemStack hand = player.getCurrentEquippedItem();

		if (hand == null) {
			if (this.interactEmpty(player))
				return true;
		} else if (HTTYMDMod.getConfig().isDebugMode() && hand.getItem() == ItemRegistry.wing) {
			this.onTakeoff();
			return true;
		} else if (!this.isTamed() && this.canTame(player, hand)) {
			if (!player.capabilities.isCreativeMode && --hand.stackSize <= 0) {
				player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
			}

			if (!this.worldObj.isRemote) {
				if (this.rand.nextInt(3) == 0) {
					this.setTamed(true);
					this.setPathToEntity((PathEntity) null);
					this.setAttackTarget((EntityLivingBase) null);
					this.setHealth(20.0F);
					this.setOwnerString(player.getUniqueID().toString());
					this.playTameEffect(true);
					this.worldObj.setEntityState(this, (byte) 7);
				} else {
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte) 6);
				}
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

	public boolean isBreedingItem(ItemStack p_70877_1_) {
		return false;
	}
	
	/**
	 * X Offset of mounted entity
	 * 
	 * <p>Useful for odd positioning of rider location (in comparison to regular mobs)</p>
	 * 
	 * @see #getMountedYOffset()
	 * @see #getMountedZOffset()
	 */
	public double getMountedXOffset() {
		return 0;
	}
	
	/**
	 * Z Offset of mounted entity
	 * 
	 * <p>Useful for odd positioning of rider location (in comparison to regular mobs)</p>
	 * 
	 * @see #getMountedYOffset()
	 * @see #getMountedXOffset()
	 */
	public double getMountedZOffset() {
		return 0;
	}
	
	public void updateRiderPosition() {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.posX + this.getMountedXOffset(), this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + this.getMountedZOffset());
        }
    }
	
	public void doJump() {
		if(!this.isAirBelow(1)) {
			this.jump();
		}
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable mate) {
		if (!this.getClass().equals(mate.getClass()))
			return null;
		try {
			return this.getClass().getConstructor(World.class).newInstance(this.worldObj);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_) {
		return this.shouldDefendOwner(p_142018_1_, p_142018_2_);
	}
}
