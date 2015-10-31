package com.httymd.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.world.World;

public class EntityTameableAlternate extends EntityAnimal implements ITameable {
	
	///////////////////////////////////////////////////////////////////////////
	//						NBT Names
	private static final String NBT_ISTAMED = "Tamed";
	///////////////////////////////////////////////////////////////////////////
	//						Datawatcher IDs
	public static final int BOOL_WATCHER = 16;
	///////////////////////////////////////////////////////////////////////////
	
	public EntityTameableAlternate(World world) {
		super(world);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(BOOL_WATCHER, Byte.valueOf((byte) 0));
	}

	@Override
	public EntityAgeable createChild(EntityAgeable mate) {
		try {
			return this.getClass().getConstructor(World.class)
					.newInstance(this.worldObj);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean isTameable(EntityLivingBase tamer) {
		return false;
	}

	@Override
	public boolean isTamed() {
		return (this.dataWatcher.getWatchableObjectByte(BOOL_WATCHER) & 4) != 0;
	}

	@Override
	public boolean isTameItem(ItemStack item) {
		return false;
	}

	@Override
	public void setTamed(boolean tame) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(BOOL_WATCHER);

		if (tame) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | 4)));
		} else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -5)));
		}
	}
	
	/**
	 * Actions taken with an empty hand, halts interaction this tick if true
	 */
	protected boolean interactEmpty(EntityPlayer player) {
		return false;
	}
	
	@Override
	public boolean interact(EntityPlayer player) {
		ItemStack heldItem = player.getCurrentEquippedItem();

		if (heldItem == null) {
			if (this.interactEmpty(player)) return true;
		} else if (this.isTameItem(heldItem) && this.isTameable(player)) {
			if (!player.capabilities.isCreativeMode && --heldItem.stackSize <= 0) {
				player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
			}

			if (!this.worldObj.isRemote) {
				if (this.rand.nextInt(3) == 0) {
					this.setTamed(true);
					this.setPathToEntity((PathEntity) null);
					this.setAttackTarget((EntityLivingBase) null);
					this.setHealth(20.0F);
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
	
	protected void playTameEffect(boolean p_70908_1_) {
		String s = "heart";

		if (!p_70908_1_) {
			s = "smoke";
		}

		for (int i = 0; i < 7; ++i) {
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle(
							s,
							this.posX + this.rand.nextFloat() * this.width * 2.0F - this.width, this.posY + 0.5D + this.rand.nextFloat() * this.height,
							this.posZ + this.rand.nextFloat() * this.width * 2.0F - this.width, d0, d1, d2);
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setBoolean(NBT_ISTAMED, isTamed());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		setTamed(tag.getBoolean(NBT_ISTAMED));
	}
}
