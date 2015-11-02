package com.httymd.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderItemContainer implements IItemRenderer {

	private static RenderItem renderItem = new RenderItem();

	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
		switch (type) {
		case ENTITY:
		case EQUIPPED:
		case EQUIPPED_FIRST_PERSON:
		case INVENTORY:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		switch (helper) {
		case ENTITY_BOBBING:
			return true;
		case ENTITY_ROTATION:
			return Minecraft.isFancyGraphicsEnabled();
		default:
			return false;
		}
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) {
		final float thickness = 0.0625F;

		if (type == ItemRenderType.INVENTORY) {
			drawInGUI(type, itemStack);
		} else {
			drawAs3D(type, itemStack, thickness);
		}

		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA(255, 255, 255, 100);
		tessellator.addVertex(7, 5, 0);
		tessellator.addVertex(7, 10, 0);
		tessellator.addVertex(9, 10, 0);
		tessellator.addVertex(9, 5, 0);
		tessellator.draw();
	}

	private void drawInGUI(ItemRenderType type, ItemStack stack) {
		Minecraft mc = Minecraft.getMinecraft();
		renderItem.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), stack, 0, 0);
	}

	private void drawAs3D(ItemRenderType type, ItemStack stack, float thickness) {
		IIcon iicon = stack.getIconIndex();
		float f = iicon.getMinU();
		float f1 = iicon.getMaxU();
		float f2 = iicon.getMinV();
		float f3 = iicon.getMaxV();
		ItemRenderer.renderItemIn2D(Tessellator.instance, f1, f2, f, f3, iicon.getIconWidth(), iicon.getIconHeight(),
				thickness);
	}

	@SuppressWarnings("unused")
	private void glMatrixForRenderInInventory() {
		GL11.glRotatef(-180F, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0.0F, -1.0F, 0.0F);
	}

	@SuppressWarnings("unused")
	private void glMatrixForRenderInEquipped() {
		GL11.glRotatef(-245F, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0.25F, -1.0F, 0.0F);
	}

	@SuppressWarnings("unused")
	private void glMatrixForRenderInEntity() {
		GL11.glRotatef(-180F, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0.0F, -1.5F, 0.0F);
	}
}
