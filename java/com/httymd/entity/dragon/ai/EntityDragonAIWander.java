package com.httymd.entity.dragon.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

import com.httymd.entity.EntityDragon;
import com.httymd.util.Utils;

public class EntityDragonAIWander extends EntityAIBase {

	protected final EntityDragon dragon;
	protected Vec3 target;
	
	public EntityDragonAIWander(EntityDragon creature) {
		this.dragon = (EntityDragon)creature;
		this.setMutexBits(3);
	}
	
	public boolean shouldExecute() {
		if (this.dragon.getAge() >= 100 || this.dragon.getRNG().nextInt(120) != 0 || !this.dragon.isFlying())
        {
            return false;
        }
        else
        {
            Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.dragon, 15, 10);
            
            if (vec3 == null)
            {
                return false;
            }
            else
            {
                target = vec3;
                return Utils.isTraceOpen(this.dragon.worldObj, this.dragon.getPosition(1), target);
            }
        }
	}
	
	public void startExecuting() {
        this.dragon.getLookHelper().setLookPosition(target.xCoord, target.yCoord, target.zCoord, 
        		(float)this.dragon.getFlyYaw(), (float)this.dragon.getFlyPitch());
    }
	
	public boolean continueExecuting()
    {
		final float minTargetDist = 15f;
        this.dragon.moveEntityWithHeading(1, 0.25F);
        return target != null && Utils.isTraceOpen(this.dragon.worldObj, this.dragon.getPosition(1), target) 
        		&& this.dragon.getPosition(1).squareDistanceTo(target) > minTargetDist*minTargetDist;
    }
	
	public void resetTask()
	{
		target = null;
	}

}
