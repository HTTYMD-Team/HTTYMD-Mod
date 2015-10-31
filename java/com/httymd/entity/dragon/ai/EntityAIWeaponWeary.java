package com.httymd.entity.dragon.ai;

import java.util.List;

import com.httymd.entity.EntityDragon;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;

public class EntityAIWeaponWeary extends EntityAIBase {

	protected final EntityDragon dragon;
	protected final AxisAlignedBB rangeBB;
	protected final double minAttackRange;
	protected EntityLivingBase closetTarget;
	
	private AxisAlignedBB cachedBB = null;
	
	public EntityAIWeaponWeary(EntityDragon d, double minMaulRange, AxisAlignedBB rangeBounds) {
		this.dragon = d;
		this.rangeBB = rangeBounds;
		this.minAttackRange = minMaulRange;
	}
	
	public EntityAIWeaponWeary(EntityDragon d, int r, double minRange) {
		this(d, minRange, AxisAlignedBB.getBoundingBox(r,r,r,r,r,r));
	}
	
	@Override
	public boolean shouldExecute() {
		@SuppressWarnings("rawtypes")
		List entList = this.dragon.worldObj.getEntitiesWithinAABBExcludingEntity(this.dragon, this.getRangeAABB(),
				new IEntitySelector()//I suspect this is faster then checking it after the list generates, and the result ends up more manageable
			    {
					private double distance = Double.MAX_VALUE;
			
			        public boolean isEntityApplicable(Entity e)
			        {
			        	double distTemp = dragon.getDistanceSqToEntity(e);
			        	if(distTemp < distance) {
			        		distance = distTemp;
			        		return e.isEntityAlive() && isDangerousWeaponHeld(e) && dragon.getEntitySenses().canSee(e);
			        	}
			        	return false;
			        }
			    });
		if(entList.isEmpty()) return false;
		this.closetTarget = (EntityLivingBase) entList.get(entList.size()-1);
		return true;
	}
	
	@Override
	public boolean continueExecuting() {
		return isDangerousWeaponHeld(this.closetTarget) && this.getRangeAABB().intersectsWith(this.closetTarget.getBoundingBox()) 
				&& this.dragon.getAttackTarget() == null && this.closetTarget.isEntityAlive() && dragon.getEntitySenses().canSee(this.closetTarget);
	}
	
	@Override
	public void updateTask() {
		if(this.closetTarget.getDistanceSqToEntity(this.dragon) < this.minAttackRange*this.minAttackRange) {
			this.dragon.setAttackTarget(this.closetTarget);
		} else {
			this.dragon.getLookHelper().setLookPositionWithEntity(this.closetTarget, 30.0F, 30.0F);
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	protected boolean isDangerousWeaponHeld(Entity e) { //If anyone has a faster way to do this, just replace it
		if(e instanceof EntityLivingBase) {
			ItemStack stack = ((EntityLivingBase) e).getHeldItem();
			if(stack != null) {
				return !stack.getAttributeModifiers().get((SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName())).isEmpty();
			}
		}
		return false;
	}
	
	protected AxisAlignedBB getRangeAABB() {
		if(this.cachedBB == null){
			this.cachedBB = this.dragon.boundingBox.copy();
			this.cachedBB.maxX += this.rangeBB.maxX;
			this.cachedBB.maxY += this.rangeBB.maxY;
			this.cachedBB.maxZ += this.rangeBB.maxZ;
			this.cachedBB.minX += this.rangeBB.minX;
			this.cachedBB.minY += this.rangeBB.minY;
			this.cachedBB.minZ += this.rangeBB.minZ;
		}
		return this.cachedBB;
	}

}
