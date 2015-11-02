package com.httymd.entity.dragon.ai;

import java.util.List;

import com.httymd.entity.EntityDragon;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.Vec3;

public class EntityAIStartled extends EntityAIBase {

	protected final EntityDragon dragon;
	protected final Class<? extends EntityLivingBase> avoidClass;
	protected final float reactDist;
	protected final double startledSpeed;
	protected final float attackChance;

	protected boolean willRun;
	protected EntityLivingBase closestLiving;
	protected PathEntity entityPathEntity;

	public EntityAIStartled(EntityDragon entity, Class<? extends EntityLivingBase> avoid, float runDist,
			double nearSpeed, float attackChance) {
		this.dragon = entity;
		this.avoidClass = avoid;
		this.reactDist = runDist;
		this.startledSpeed = nearSpeed;
		this.attackChance = attackChance;
		this.setMutexBits(3);
	}

	@Override
	public void resetTask() {
		this.closestLiving = null;
	}

	@Override
	public boolean shouldExecute() {
		if (!this.dragon.isStartled() || this.dragon.isTamed())
			return false;

		if (this.avoidClass == EntityPlayer.class && (this.closestLiving = this.dragon.worldObj
				.getClosestPlayerToEntity(this.dragon, (double) this.reactDist)) == null)
			return false;
		else {
			List<?> list = this.dragon.worldObj.selectEntitiesWithinAABB(this.avoidClass, this.dragon.boundingBox
					.expand((double) this.reactDist, this.reactDist * 0.4, (double) this.reactDist),
					new IEntitySelector() {
						@Override
						public boolean isEntityApplicable(Entity e) {
							return e.isEntityAlive() && dragon.getEntitySenses().canSee(e);
						}
					});

			if (list.isEmpty()) {
				return false;
			}

			this.closestLiving = (EntityLivingBase) list.get(0);
		}

		if (!(this.willRun = this.dragon.getRNG().nextFloat() <= this.attackChance))
			return true;

		Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.dragon, 16, 7,
				this.closestLiving.getPosition(1));

		if (vec3 == null || this.closestLiving.getDistanceSq(vec3.xCoord, vec3.yCoord, vec3.zCoord) < this.closestLiving
				.getDistanceSqToEntity(this.dragon)) {
			return false;
		} else {
			this.entityPathEntity = this.dragon.getNavigator().getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord);
			return this.entityPathEntity == null ? false : this.entityPathEntity.isDestinationSame(vec3);
		}
	}

	@Override
	public boolean continueExecuting() {
		return this.dragon.isStartled() && !this.dragon.getNavigator().noPath();
	}

	@Override
	public void startExecuting() {
		if (this.willRun)
			this.dragon.getNavigator().setPath(this.entityPathEntity, this.startledSpeed);
	}

	@Override
	public void updateTask() {
		if (!this.willRun)
			this.dragon.setAttackTarget(this.closestLiving);
	}

}
