package com.httymd.entity.dragon;

import java.util.UUID;

import com.httymd.entity.EntityDragon;
import com.httymd.entity.EntityVikingBase;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityNadder extends EntityDragon {

	public static final AttributeModifier chickenSpeedModifier = 
			new AttributeModifier(UUID.fromString("0A0E0DDB-5AAE-4153-9356-83A01BEF91A0"), "Chicken flight speed boost", 0.09, 1);
	
	public EntityNadder(World world) {
		super(world);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 0.9D, false));
		this.tasks.addTask(3, new EntityAIFollowOwner(this, 1.5D, 20F, 50F));
		this.tasks.addTask(4, new EntityAITempt(this, 0.7, Items.fish, true));
		this.tasks.addTask(4, new EntityAITempt(this, 0.7, Items.chicken, true));
		this.tasks.addTask(4, new EntityAITempt(this, 0.7, Items.cooked_chicken, true));
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
		this.getEntityAttribute(flyingSpeed).setBaseValue(0.1D);
	}
	
	@Override
	public boolean canTame(EntityLivingBase e, ItemStack item) {
		return item.getItem() == Items.fish || item.getItem() == Items.chicken || item.getItem() == Items.cooked_chicken;		
	}
	
	public boolean onFeed(EntityLivingBase feeder, ItemStack feed) {
		
		IAttributeInstance instance = this.getEntityAttribute(flyingSpeed);
		if(feed.getItem() == Items.chicken || feed.getItem() == Items.cooked_chicken) {
			instance.applyModifier(chickenSpeedModifier);
			this.setHealth(this.getHealth()+0.5F);
			return true;
		} else if(instance.getModifier(chickenSpeedModifier.getID()) != null) {
			instance.removeModifier(chickenSpeedModifier);
		} // If feed anything other then chicken, cancels speed effect, TODO make it timed
		
		return super.onFeed(feeder, feed);
	}
}
