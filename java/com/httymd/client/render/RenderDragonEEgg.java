package com.httymd.client.render;

import org.lwjgl.opengl.GL11;

import com.httymd.HTTYMDMod;
import com.httymd.client.model.ModelDragonEEgg;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class RenderDragonEEgg extends RenderPlayer {

	public static final ResourceLocation eeggTex = new ResourceLocation(
			HTTYMDMod.ID + ":textures/entities/DragonEEgg.png");

	protected final ModelDragonEEgg modelMainEgg;

	public RenderDragonEEgg() {
		super();
		this.modelBipedMain = new ModelDragonEEgg();
		this.modelMainEgg = (ModelDragonEEgg) modelBipedMain;
	}

	public void renderFirstPersonArm(EntityPlayer p_82441_1_) {
		float f = 1.0F;
		GL11.glColor3f(f, f, f);
		this.modelBipedMain.onGround = 0.0F;
		this.modelBipedMain.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, p_82441_1_);
		this.modelMainEgg.RightArm_1.render(0.0625F);
	}

	protected ResourceLocation getEntityTexture(AbstractClientPlayer p_110775_1_) {
		return eeggTex;
	}

}
