package com.httymd.client.render;

import org.lwjgl.opengl.GL11;

import com.httymd.HTTYMDMod;
import com.httymd.client.model.ModelDragonEEgg;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDragonEEgg extends RenderPlayer {

	public static final ResourceLocation eeggTex = new ResourceLocation(
			HTTYMDMod.ID + ":textures/entities/DragonEEgg.png");

	//protected final ModelDragonEEgg modelMainEgg;

	public RenderDragonEEgg() {
		this(Minecraft.getMinecraft().getRenderManager());
	}

	public RenderDragonEEgg(RenderManager rm) {
		super(rm);
		//this.modelBipedMain = new ModelDragonEEgg();
		//this.modelMainEgg = (ModelDragonEEgg) this.modelBipedMain;
	}

	protected ResourceLocation getEntityTexture(AbstractClientPlayer p_110775_1_) {
		return eeggTex;
	}

	public void renderFirstPersonArm(EntityPlayer p_82441_1_) {
		float f = 1.0F;
		GL11.glColor3f(f, f, f);
		// this.mainModel.onGround = 0.0F;
		this.mainModel.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, p_82441_1_);
		//this.modelMainEgg.RightArm_1.render(0.0625F);
	}

}
