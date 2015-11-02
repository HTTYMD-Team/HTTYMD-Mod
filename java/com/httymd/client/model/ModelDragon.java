package com.httymd.client.model;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import com.httymd.entity.EntityDragon;
import com.httymd.entity.EntityTameableFlying;

public abstract class ModelDragon extends ModelBase {
	public ModelBase model = this;

	// Dragon Parts
	protected ModelRenderer head;
	protected ModelRenderer body;
	protected List<ModelRenderer> legs = new ArrayList<ModelRenderer>();
	protected ModelRenderer wing;

	public ModelDragon() {
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		boolean flag = ((EntityTameableFlying) entity).isFlying();

		float pitch = flag ? entity.rotationPitch : 0;
		GL11.glPushMatrix();
		GL11.glRotatef(pitch * 0.8F, 1, 0, 0);

		head.render(f5);
		body.render(f5);

		for (ModelRenderer leg : legs) {
			if (flag) {
				leg.rotateAngleY = 0;
			}
			leg.render(f5);
		}

		GL11.glEnable(GL11.GL_CULL_FACE);
		wing.render(f5);
		GL11.glScalef(-1, 1, 1);
		GL11.glCullFace(GL11.GL_FRONT);
		wing.render(f5);
		GL11.glScalef(-1, 1, 1);
		GL11.glCullFace(GL11.GL_BACK);
		GL11.glDisable(GL11.GL_CULL_FACE);

		GL11.glPopMatrix();
	}

	protected void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	/**
	 * @see net.minecraft.client.model.ModelBase#setRotationAngles(float, float,
	 *      float, float, float, float, net.minecraft.entity.Entity)
	 * @param f
	 *            step of moving
	 * @param f1
	 *            body part amplitude
	 * @param f2
	 *            ?
	 * @param f3
	 *            lookAt spherical angle Y
	 * @param f4
	 *            lookAt spherical angle X
	 * @param f5
	 *            some weird parameter scaling the rotation point * @param f
	 * @param entity
	 */
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		EntityDragon dragon = null;
		if (entity instanceof EntityDragon) {
			dragon = (EntityDragon) entity;
		}

		head.rotateAngleX = f4 / (180F / (float) Math.PI);
		head.rotateAngleY = f3 / (180F / (float) Math.PI);

		if (dragon != null) {
			if (dragon.isFlying()) {
				head.rotateAngleX *= 0.8;
				head.rotateAngleY *= 0.8;
				for (int i = 0; i < legs.size(); i++) {
					legs.get(i).rotateAngleX = (float) Math.toRadians(45);
				}
				wing.rotateAngleZ = MathHelper.cos((entity.ticksExisted % 120) * 0.6662F) * 1.4f * f1;
			} else {
				for (int i = 0; i < legs.size(); i++) {
					legs.get(i).rotateAngleX = (i % 2 == 0 ? 1 : -1) * MathHelper.cos(f * 0.6662F) * 1.4f * f1;
				}
				wing.rotateAngleZ = 0;
			}
		}
	}
	/*
	 * Warning: only call once, multiple calls will break this function
	 * 
	 * @param entity The entity this flap is being applied to
	 * 
	 * @param tick The current tick of flight
	 * 
	 * @param flapSeconds The seconds it takes to flap
	 * 
	 * @param maxFlapAngle the max angle from 0 (positive and negative) the wing
	 * can deviate from
	 * 
	 * protected void flapWings(EntityLiving entity, int tick, final int
	 * flapSeconds, int maxFlapAngle) { int flapTicks = flapSeconds*20; boolean
	 * moveWingsDown = tick%flapTicks==0 && tick%flapTicks>=flapTicks/2;
	 * 
	 * wing.rotateAngleZ +=
	 * (moveWingsDown?-1:1)*(Math.toRadians(maxFlapAngle)/flapTicks); }
	 */

	public interface ModelRendererFactory {

		ModelRenderer get();
	}
}
