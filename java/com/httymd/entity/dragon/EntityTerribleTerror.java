package com.httymd.entity.dragon;

import com.httymd.entity.EntityDragon;
import com.httymd.entity.EntityVikingBase;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityTerribleTerror extends EntityDragon {

	public EntityTerribleTerror(World world) {
		super(world);
		this.setSize(0.7F, 0.7F);
		this.ignoreFrustumCheck = false;
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 0.8D, false));
		this.tasks.addTask(4, new EntityAIFollowOwner(this, 1.1D, 5F, 20F));
		this.tasks.addTask(5, new EntityAITempt(this, 0.6D, Items.fish, true));
		this.tasks.addTask(6, new EntityAIMate(this, 0.7D));
		this.tasks.addTask(7, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityVikingBase.class, 8.0F));
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntitySheep.class, 50, false));
		this.setTamed(false);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(healthAtt).setBaseValue(10);
		this.getEntityAttribute(speedAtt).setBaseValue(0.3);
		this.getEntityAttribute(damageAtt).setBaseValue(0.5);
		this.getEntityAttribute(flyingSpeed).setBaseValue(0.2);
	}

	@Override
	public boolean canTame(EntityLivingBase tamer, ItemStack s) {
		return s.getItem() == Items.fish;
	}

	@Override
	public boolean isRideableBy(Entity e) {
		if(!super.isRideableBy(e)) return false;
		double deltaX = this.boundingBox.maxX - this.boundingBox.minX;
		double deltaY = this.boundingBox.maxY - this.boundingBox.minY;
		double deltaZ = this.boundingBox.maxZ - this.boundingBox.minZ;
		double eDeltaX = e.boundingBox.maxX - e.boundingBox.minX;
		double eDeltaY = e.boundingBox.maxY - e.boundingBox.minY;
		double eDeltaZ = e.boundingBox.maxZ - e.boundingBox.minZ;
		return eDeltaX < deltaX * 0.5 && eDeltaY < deltaY * 0.5 && eDeltaZ < deltaZ * 0.5;
		// Entity e must be less then half as small as the terror to ride
	}
}
