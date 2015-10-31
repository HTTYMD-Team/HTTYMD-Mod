package com.httymd.entity;

import com.httymd.HTTYMDMod;
import com.httymd.item.registry.ItemRegistry;
import com.httymd.util.Utils;

import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityTameableFlying extends EntityTameableAlternate implements IFlyable {

	///////////////////////////////////////////////////////////////////////////
	//						NBT Names
	private static final String NBT_IS_FLYING = "Flying";
	///////////////////////////////////////////////////////////////////////////
	//						Entity Attributes
	public static final IAttribute flyingSpeed = (new RangedAttribute(Utils.getModString("flyingSpeed"), 1D, 0.0D, Double.MAX_VALUE)).setDescription("Flying Speed").setShouldWatch(true);
	public static final IAttribute flyingYaw = (new RangedAttribute(Utils.getModString("flyingYaw"), 25D, 0.0D, Double.MAX_VALUE)).setDescription("Flying Yaw Speed").setShouldWatch(true);
	public static final IAttribute flyingPitch = (new RangedAttribute(Utils.getModString("flyingPitch"), 20D, 0.0D, Double.MAX_VALUE)).setDescription("Flying Pitch Speed").setShouldWatch(true);
	///////////////////////////////////////////////////////////////////////////
	
	public EntityTameableFlying(World w) {
		super(w);
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(flyingSpeed);
        this.getAttributeMap().registerAttribute(flyingYaw);
        this.getAttributeMap().registerAttribute(flyingPitch);        
    }
	
	@Override
	public boolean isFlying() {
		if (!isFlyable()) {
			setFlying(false);
			return false;
		}
		return (dataWatcher.getWatchableObjectByte(BOOL_WATCHER) & 32) != 0;
	}
	
	public boolean isFlyable() {
		return true;
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
	
	/**
	 * Retrieves the Flight Pitch Delta Speed
	 */
	public double getFlyPitch() {
		return this.getEntityAttribute(flyingPitch).getAttributeValue();
	}

	@Override
	public void setFlying(boolean flying) {
		byte b0 = dataWatcher.getWatchableObjectByte(BOOL_WATCHER);

		if (flying && isFlyable()) {
			dataWatcher.updateObject(BOOL_WATCHER, Byte.valueOf((byte) (b0 | 32)));
		} else {
			dataWatcher.updateObject(BOOL_WATCHER, Byte.valueOf((byte) (b0 & -33)));
		}
	}
	
	public void onTakeoff() {
		this.jump();
		this.setFlying(true);
		this.motionY += this.getFlySpeed();
	}

	/**
	 * Detects if there are air blocks below the entities lowest bounding box position based on range, semi-accurate boolean
	 */
	protected boolean isAirBelow(int range) {
		for (int curBlock = 1; curBlock <= range; curBlock++) {
			if (!this.worldObj.isAirBlock(
					MathHelper.floor_double(this.posX),
					MathHelper.floor_double(this.boundingBox.minY) - curBlock,
					MathHelper.floor_double(this.posZ)))
				return false;
		}
		return true;
	}

	@Override
	public void moveEntityWithHeading(float strafe, float forward) {
		if (this.isFlying()) {
			if ((!this.isAirBelow(1)) || this.isInsideOfMaterial(Material.water)
					|| this.isInsideOfMaterial(Material.lava)) { // How could you fly in water or lava? :P
				this.setFlying(false);
				this.moveEntityWithHeading(strafe, forward);
				return;
			}

			if (this.motionY < 0) {
				this.motionY *= 0.8;
			}
			
			if(forward < 0) {
				forward *= 0.15;
			}
			
			final float timeSpeedMultipler = 0.91F;

			this.motionX *= timeSpeedMultipler;
			this.motionY *= timeSpeedMultipler;
			this.motionZ *= timeSpeedMultipler;

			this.moveFlying(strafe, forward, (float) this.getFlySpeed());
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
		} else {
			super.moveEntityWithHeading(strafe, forward);
		}
	}

	@Override
	protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
		if (this.isFlying()) {
			if (this.fallDistance > 0)
				this.fallDistance = 0;
		} else {
			super.updateFallState(p_70064_1_, p_70064_3_);
		}
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);

		tag.setBoolean(NBT_IS_FLYING, isFlying());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);

		setFlying(tag.getBoolean(NBT_IS_FLYING));
	}
	
	public boolean interact(EntityPlayer player) {
		if(HTTYMDMod.getConfig().isDebugMode() &&  player.getCurrentEquippedItem().getItem() == ItemRegistry.wing) {
			this.onTakeoff();
		}
		
		return super.interact(player);
	}
}
