package com.httymd.client.render.dragon;

import com.httymd.HTTYMDMod;
import com.httymd.client.render.RenderDragon;
import com.httymd.entity.dragon.EntityTerribleTerror;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTerribleTerror extends RenderDragon {
	private static final ResourceLocation entityTextures = new ResourceLocation(
			HTTYMDMod.ID + ":textures/entities/TerribleTerror" + ".png");

	public RenderTerribleTerror(ModelBase p_i1253_1_, float p_i1253_2_) {
		this(Minecraft.getMinecraft().getRenderManager(), p_i1253_1_, p_i1253_2_);
	}

	public RenderTerribleTerror(RenderManager rm, ModelBase p_i1253_1_, float p_i1253_2_) {
		super(rm, p_i1253_1_, p_i1253_2_);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return this.getEntityTexture((EntityTerribleTerror) p_110775_1_);
	}

	protected ResourceLocation getEntityTexture(EntityTerribleTerror p_110775_1_) {
		return entityTextures;
	}
}