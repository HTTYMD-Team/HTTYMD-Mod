package com.httymd.entity.dragon;

import com.httymd.entity.EntityDragon;
import com.httymd.entity.EntityVikingBase;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
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
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 0.8D, false));
		this.tasks.addTask(4, new EntityAIFollowOwner(this, 1.1D, 5F, 20F));
		this.tasks.addTask(5, new EntityAITempt(this, 0.6D, Items.fish, true));
		this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityVikingBase.class, 8.0F));
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntitySheep.class, 50, false));
		this.setSize(0.7F, 0.7F);
		this.setTamed(false);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7F);
		this.getEntityAttribute(flyingSpeed).setBaseValue(0.4D);
	}

	@Override
	public boolean isTameable(EntityLivingBase e) {
		return !this.isAngry();
	}

	@Override
	public boolean isTameItem(ItemStack s) {
		return s.getItem() == Items.fish;
	}
}
