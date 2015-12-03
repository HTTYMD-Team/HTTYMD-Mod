package com.httymd.entity.dragon;

import com.httymd.entity.EntityDragon;
import com.httymd.entity.EntityVikingBase;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.World;

public class EntityNadder extends EntityDragon {

	public EntityNadder(World world) {
		super(world);
		((PathNavigateGround) this.getNavigator()).setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 0.9D, false));
		this.tasks.addTask(3, new EntityAIFollowOwner(this, 1.5D, 20F, 50F));
		this.tasks.addTask(4, new EntityAITempt(this, 0.7, Items.fish, true));
		this.tasks.addTask(4, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityVikingBase.class, 8.0F));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.setSize(1, 1);
		this.setTamed(false);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2F);
		this.getEntityAttribute(flyingSpeed).setBaseValue(1.7D);
	}
}
