package com.httymd.client.model;

import com.httymd.client.render.RenderGlide;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGlideSuit extends RenderGlide.ModelGlide {

	public ModelRenderer LeftWing;
	public ModelRenderer RightWing;
	public ModelRenderer BackFin;

	public ModelGlideSuit(float scale) {
		super(scale);
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.LeftWing = new ModelRenderer(this, 0, 32);
		this.LeftWing.mirror = true;
		this.LeftWing.setRotationPoint(3.0F, 2.0F, 0.0F);
		this.LeftWing.addBox(0.0F, 0.0F, 0.0F, 9, 15, 0, 0.0F);
		this.RightWing = new ModelRenderer(this, 9, 32);
		this.RightWing.setRotationPoint(-2.0F, 2.0F, 0.0F);
		this.RightWing.addBox(-11.0F, 0.0F, 0.0F, 9, 15, 0, 0.0F);
		/*
		BackFin = new ModelRenderer(this, 42, 48); BackFin.addBox(0F, 0F, 0F,0, 9, 7);
		BackFin.setRotationPoint(0F, 1F, 2F);
		BackFin.setTextureSize(128, 64); BackFin.mirror = true;
		setRotation(BackFin, -0.4537856F, 0F, 0F);
		 */
	}

	public void renderWings(Entity entity, float f5) {
		LeftWing.render(f5);
		RightWing.render(f5);
		// BackFin.render(f5);
	}

	@Override
	public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_,
			float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
		super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
		this.RightWing.rotateAngleX = 0;
		this.LeftWing.rotateAngleX = 0;
		this.RightWing.rotateAngleZ = 0;
		this.LeftWing.rotateAngleZ = 0;
	}
}
