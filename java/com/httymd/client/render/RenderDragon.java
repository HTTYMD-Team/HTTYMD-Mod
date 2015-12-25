package com.httymd.client.render;

import com.httymd.HTTYMDMod;
import com.httymd.entity.EntityDragon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public abstract class RenderDragon extends RenderLiving {
	private static final ResourceLocation entityTextures = new ResourceLocation(
			HTTYMDMod.ID + ":textures/entities/dragon" + ".png");

	public RenderDragon(ModelBase p_i1253_1_, float p_i1253_2_) {
		super(p_i1253_1_, p_i1253_2_);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return this.getEntityTexture((EntityDragon) p_110775_1_);
	}

	protected ResourceLocation getEntityTexture(EntityDragon p_110775_1_) {
		return entityTextures;
	}
}