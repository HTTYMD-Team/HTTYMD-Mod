package com.httymd.client.util;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class WingRenderer extends ModelRenderer {

	public WingRenderer(ModelBase p_i1174_1_, int p_i1174_2_, int p_i1174_3_) {
		super(p_i1174_1_, p_i1174_2_, p_i1174_3_);
	}

	@Override
	public void render(float p_78785_1_) {
		GL11.glEnable(GL11.GL_CULL_FACE);
		super.render(p_78785_1_);
		GL11.glScalef(-1, 1, 1);
		GL11.glCullFace(GL11.GL_FRONT);
		super.render(p_78785_1_);
		GL11.glScalef(-1, 1, 1);
		GL11.glCullFace(GL11.GL_BACK);
		GL11.glDisable(GL11.GL_CULL_FACE);
	}
}
