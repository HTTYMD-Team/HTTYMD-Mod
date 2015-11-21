package com.httymd.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class RenderGlide extends RenderPlayer {

	public static class ModelGlide extends ModelBiped {

		public ModelGlide(ModelBiped model) {
			super(0, 0, 64, 64);
			this.heldItemLeft = 0;
			this.heldItemRight = 0;
			this.isSneak = false;
			this.aimedBow = false;
		}

		@Override
		public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_,
				float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
			super.setRotationAngles(0.0F, 0.0F, 0.0F, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
			float bendAngle = 70;

			this.bipedRightArm.rotateAngleZ = bendAngle;
			this.bipedLeftArm.rotateAngleZ = -bendAngle;
			this.bipedRightLeg.rotateAngleX = 0;
			this.bipedLeftLeg.rotateAngleX = 0;
		}
	}

	public RenderGlide() {
		super();
		if (this.mainModel instanceof ModelBiped) {
			this.mainModel = new ModelGlide((ModelBiped) this.mainModel);
			this.modelArmor = new ModelGlide(this.modelArmor);
			this.modelArmorChestplate = new ModelGlide(this.modelArmorChestplate);
			this.modelArmor.bipedRightArm.mirror = true;
			this.modelArmor.bipedRightLeg.mirror = true;
			this.modelArmorChestplate.bipedRightArm.mirror = true;
			this.modelArmorChestplate.bipedRightLeg.mirror = true;
		}
	}

	@Override
	public void doRender(AbstractClientPlayer player, double p_76986_2, double p_76986_4, double p_76986_6,
			float p_76986_8, float p_76986_9_) {
		float angle = -100;
		double sin = Math.sin(player.rotationYaw / 180 * Math.PI);
		double cos = Math.cos(player.rotationYaw / 180 * Math.PI);

		GL11.glPushMatrix();
		GL11.glRotated(angle, -cos, 0, -sin);
		super.doRender(player, p_76986_2, 0.0F, p_76986_6, p_76986_8, p_76986_9_);
		GL11.glPopMatrix();
	}

	@Override
	protected void renderModel(EntityLivingBase p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_,
			float p_77036_5_, float p_77036_6_, float p_77036_7_) {
		super.renderModel(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_ - 75.0F, p_77036_7_);
	}

}
