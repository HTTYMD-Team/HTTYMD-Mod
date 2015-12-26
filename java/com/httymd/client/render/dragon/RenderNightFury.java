package com.httymd.client.render.dragon;

import com.httymd.HTTYMDMod;
import com.httymd.client.render.RenderDragon;
import com.httymd.entity.dragon.EntityNightFury;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderNightFury extends RenderDragon {
	private static final ResourceLocation entityTextures = new ResourceLocation(HTTYMDMod.ID + ":textures/entities/NightFury" + ".png");

	public RenderNightFury(ModelBase p_i1253_1_, float p_i1253_2_) {
		super(p_i1253_1_, p_i1253_2_);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return this.getEntityTexture((EntityNightFury) p_110775_1_);
	}

	protected ResourceLocation getEntityTexture(EntityNightFury p_110775_1_) {
		return entityTextures;
	}
}