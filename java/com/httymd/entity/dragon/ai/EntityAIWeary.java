package com.httymd.entity.dragon.ai;

import com.httymd.entity.EntityDragon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIWatchClosest2;

public class EntityAIWeary extends EntityAIWatchClosest2 {

	protected final EntityDragon dragon;
	protected final float reactDist;
	protected final int minStartleTime;

	protected int startledTime;

	public EntityAIWeary(EntityDragon watcher, Class<? extends EntityLivingBase> classToWatch, float maxDist,
			float chance, float reactDist, int minStartleTime) {
		super(watcher, classToWatch, maxDist, chance);
		this.dragon = watcher;
		this.reactDist = reactDist;
		this.minStartleTime = minStartleTime;
	}

	public EntityAIWeary(EntityDragon watcher, Class<? extends EntityLivingBase> classToWatch, float maxDist,
			float chance, float reactDist) {
		this(watcher, classToWatch, maxDist, chance, reactDist, 100);
	}

	@Override
	public boolean shouldExecute() {
		if (this.dragon.isStartled() && --this.startledTime > 0) {
			return false;
		}

		this.dragon.setStartled(false);
		return !this.dragon.isTamed() && this.closestEntity != null
				&& this.dragon.getEntitySenses().canSee(this.closestEntity) && super.shouldExecute();
	}

	@Override
	public void updateTask() {
		this.dragon.getLookHelper().setLookPosition(this.closestEntity.posX,
				this.closestEntity.posY + (double) this.closestEntity.getEyeHeight(), this.closestEntity.posZ, 20.0F,
				(float) this.dragon.getVerticalFaceSpeed());
		this.dragon.setAIMoveSpeed(this.dragon.getAIMoveSpeed() * 0.5F);

		if (this.dragon.getDistanceSqToEntity(this.closestEntity) < this.reactDist * this.reactDist) {
			this.dragon.setStartled(true);
			this.startledTime = this.minStartleTime + this.dragon.getRNG().nextInt(this.minStartleTime + 1);
		}
	}

}
