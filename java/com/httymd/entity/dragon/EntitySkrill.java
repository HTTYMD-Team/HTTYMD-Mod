package com.httymd.entity.dragon;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

import com.httymd.entity.EntityDragon;

public class EntitySkrill extends EntityDragon {
    
    public EntitySkrill(World world) {
        super(world);
        this.setSize(2,2);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5F);
    }
}
