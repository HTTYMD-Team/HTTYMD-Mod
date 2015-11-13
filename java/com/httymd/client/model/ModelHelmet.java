package com.httymd.client.model;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

public class ModelHelmet extends ModelBiped {

	private String renderData;

	List<ModelRenderer> renderers;

	public void SetRenderData(String renderData) {
		this.renderData = renderData;
	}

	protected void initRenderData() {
		// TODO: Parse renderData for this format to ModelRenderer
		// HelmetRenderPart: xOffset yOffset
		// addBox originX originY originZ width height depth scaleFator
		// (optional) setRotationPoint yaw pitch roll
		// HelmetRenderPart: ...
		//
		// Must be able to run like bipedHead to keep helmet on player
		// Also find a way to extend image size without breaking textures
	}

}
