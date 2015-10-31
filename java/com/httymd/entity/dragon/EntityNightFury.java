package com.httymd.entity.dragon;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.httymd.entity.EntityDragon;
import com.httymd.entity.dragon.ai.EntityDragonAIWander;
import com.httymd.entity.dragon.ai.EntityAIWeaponWeary;

public class EntityNightFury extends EntityDragon {

    public EntityNightFury(World world) {
        super(world);
        setSize(2, 2.25F);
        this.stepHeight = 1;
        this.getNavigator().setAvoidsWater(true);
        //Since ground and flight AI can't possibly run concurrently (and they shouldn't), why separate the tasks
        //Also for flight to work, it should probably run first, though it should be fine as long as you cancel if isFlying is false
        //Flight
        this.tasks.addTask(4, new EntityDragonAIWander(this));
        //Ground
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(2, new EntityAIWeaponWeary(this, 10, 20));
        this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySheep.class, 75, false));
        this.ignoreFrustumCheck = true;
        this.setTamed(false);
    }
    
    @Override
    public double getMountedYOffset() {
        return super.getMountedYOffset()*1.25;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6D);
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
    }
    
}
