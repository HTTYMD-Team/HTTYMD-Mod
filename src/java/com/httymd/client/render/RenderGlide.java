package com.httymd.client.render;

import java.util.Arrays;

import org.lwjgl.opengl.GL11;

import com.httymd.client.model.ModelGlideSuit;
import com.httymd.item.ItemGlideArmor;
import com.httymd.item.util.ItemUtils.EnumArmorType;
import com.httymd.util.Utils;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderGlide extends RenderPlayer {
	
	public static class ModelGlide extends ModelBiped {

		public ModelGlide(float scale) {
			super(scale, 0, 64, 32);
			this.heldItemLeft = 0;
			this.heldItemRight = 0;
			this.isSneak = false;
			this.aimedBow = false;
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			final float headAngleAligner = -75.0f;
			super.render(entity, f, f1, f2, f3, f4 + headAngleAligner, f5);
		}

		@Override
		public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_,
				float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
			this.isSneak = false;
			// Prevents all alternate arm angles
			super.setRotationAngles(0.0F, 0.0F, 0.0F, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
			final float armBendAngle = (float) (Math.PI / 180 * 45);

			bipedRightArm.rotateAngleZ = armBendAngle;
			bipedLeftArm.rotateAngleZ = -armBendAngle;
			// Prevents any other leg movement
			bipedRightLeg.rotateAngleX = 0;
			bipedLeftLeg.rotateAngleX = 0;

			if (((AbstractClientPlayer) p_78087_7_).moveForward < 0) {
				final float legBendAngle = (float) (Math.PI / 180 * 30);
				bipedRightLeg.rotateAngleZ = legBendAngle;
				bipedLeftLeg.rotateAngleZ = -legBendAngle;
			} else {
				bipedRightLeg.rotateAngleZ = 0;
				bipedLeftLeg.rotateAngleZ = 0;
			}
		}
	}

	public RenderGlide() {
		super();
		if (mainModel instanceof ModelBiped) {
			mainModel = new ModelGlide(0);
			modelArmor = new ModelGlideSuit(0.5F);
			modelArmorChestplate = new ModelGlideSuit(1);
			modelArmor.bipedRightArm.mirror = true;
			modelArmor.bipedRightLeg.mirror = true;
			modelArmorChestplate.bipedRightArm.mirror = true;
			modelArmorChestplate.bipedRightLeg.mirror = true;
		}
	}

	// TODO what does this method even do? is it exactly the same as
	// super.shouldRenderPass()?
	/*@Override
	protected int shouldRenderPass(AbstractClientPlayer ply, int slot, float p_77032_3_) {
		int result = super.shouldRenderPass(ply, slot, p_77032_3_);
		ItemStack s = ply.getCurrentArmor(3 - slot);

		if (s != null && s.getItem() instanceof ItemGlideArmor && this.modelArmor instanceof ModelGlideSuit) {
			this.bindTexture(RenderBiped.getArmorResource(ply, s, 5, null));
			ModelGlideSuit modelArmor = slot == 2 ? (ModelGlideSuit) this.modelArmor
					: (ModelGlideSuit) this.modelArmorChestplate;
			modelArmor.bipedHead.showModel = slot == 0;
			modelArmor.bipedHeadwear.showModel = slot == 0;
			modelArmor.bipedBody.showModel = slot == 1 || slot == 2;
			modelArmor.bipedRightArm.showModel = slot == 1;
			modelArmor.bipedLeftArm.showModel = slot == 1;
			modelArmor.bipedRightLeg.showModel = slot == 2 || slot == 3;
			modelArmor.bipedLeftLeg.showModel = slot == 2 || slot == 3;
			modelArmor.LeftWing.showModel = slot == 1;
			modelArmor.RightWing.showModel = slot == 1;
			modelArmor = (ModelGlideSuit) ForgeHooksClient.getArmorModel(ply, s, slot, modelArmor);
			modelArmor.onGround = this.mainModel.onGround;
			modelArmor.isRiding = this.mainModel.isRiding;
			modelArmor.isChild = this.mainModel.isChild;

			// Move outside if to allow for more then just CLOTH
			int j = ((ItemArmor) s.getItem()).getColor(s);
			if (j != -1) {
				float f1 = (float) (j >> 16 & 255) / 255.0F;
				float f2 = (float) (j >> 8 & 255) / 255.0F;
				float f3 = (float) (j & 255) / 255.0F;
				GL11.glColor3f(f1, f2, f3);

				if (s.isItemEnchanted()) {
					return 31;
				}

				return 16;
			}

			GL11.glColor3f(1.0F, 1.0F, 1.0F);

			if (s.isItemEnchanted()) {
				return 15;
			}

			return 1;
		}
		return result;
	}*/

	@Override
	public void doRender(AbstractClientPlayer player, double p_76986_2, double p_76986_4, double p_76986_6,
			float p_76986_8, float p_76986_9_) {
		float pitchTiltAngle = -90;
		if (player.moveForward < 0)
			pitchTiltAngle = -80;
		if (player.moveForward > 0)
			pitchTiltAngle = -100;

		double playerYawSin = Math.sin(player.rotationYaw / 180 * Math.PI);
		double playerYawCos = Math.cos(player.rotationYaw / 180 * Math.PI);

		GL11.glPushMatrix();
		GL11.glRotated(pitchTiltAngle, -playerYawCos, 0, -playerYawSin);
		if(Utils.experimental())
			this.renderWings(player, 0.0625F);
		
		super.doRender(player, p_76986_2, p_76986_4, p_76986_6, p_76986_8, p_76986_9_);
		GL11.glPopMatrix();
	}

	private boolean checkForWingRender(ItemStack stack, int slot) {
		return stack != null && stack.getItem() instanceof ItemGlideArmor
				&& Arrays.asList(((ItemGlideArmor)stack.getItem()).getRequiredSlotsForFlight()).contains(EnumArmorType.values()[slot]);
	}

	public void renderWings(Entity e, float f5) {
		if (this.modelArmorChestplate instanceof ModelGlideSuit) {
			ResourceLocation textureResource = null;
			ItemStack stack = null;
			if (e instanceof EntityLivingBase) {
				for (int i = 0; i < EnumArmorType.values().length; i++) {
					stack = ((EntityLivingBase) e).getEquipmentInSlot(i + 1);
					if (this.checkForWingRender(stack, i)) {
						break;
					}
					else
						stack = null;
				}
				if (stack != null)
					textureResource = RenderBiped.getArmorResource(e, stack, 0, "fins");
			}
			if (textureResource != null) {
				this.bindTexture(textureResource);
				((ModelGlideSuit) this.modelArmorChestplate).renderWings(e, f5);
			}
		}
	}
}
