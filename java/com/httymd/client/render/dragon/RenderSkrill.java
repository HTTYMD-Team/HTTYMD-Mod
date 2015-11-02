package com.httymd.client.render.dragon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.httymd.HTTYMDMod;
import com.httymd.client.render.RenderDragon;
import com.httymd.entity.dragon.EntitySkrill;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSkrill extends RenderDragon {
	private static final ResourceLocation entityTextures = new ResourceLocation(
			HTTYMDMod.ID + ":textures/entities/Skrill.png");

	public RenderSkrill(ModelBase p_i1253_1_, float p_i1253_2_) {
		super(p_i1253_1_, p_i1253_2_);
	}

	protected ResourceLocation getEntityTexture(EntitySkrill p_110775_1_) {
		return entityTextures;
	}

	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return this.getEntityTexture((EntitySkrill) p_110775_1_);
	}
}