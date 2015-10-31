package com.httymd.entity.dragon;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

import com.httymd.entity.EntityDragon;

public class EntityNightmare extends EntityDragon {

    public EntityNightmare(World world) {
        super(world);
        this.setSize(1,1);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1);
    }
}
