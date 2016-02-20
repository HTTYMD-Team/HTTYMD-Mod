package com.httymd.client.model.dragon;

import com.httymd.client.model.ModelDragon;

import net.minecraft.client.model.ModelRenderer;

public class ModelNightmare extends ModelDragon {

	public ModelNightmare() {
		textureWidth = 259;
		textureHeight = 257;

		head = 		new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer head = new ModelRenderer(model);
				head.setRotationPoint(0F, 0F, 0F);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 24, 0);
				Shape1.addBox(1.5F, -5.5F, -4F, 4, 4, 8);
				Shape1.setRotationPoint(0F, 0.5F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, 0.08726646259971647F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 10, 24);
				Shape1.addBox(-6F, -1.5F, -1F, 3, 1, 2);
				Shape1.setRotationPoint(0F, -0.5F, -14F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, 0.47123889803846897F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 48, 14);
				Shape1.addBox(0F, -2F, -4F, 14, 3, 8);
				Shape1.setRotationPoint(0F, 1F, -2.5F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, 0F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 2, 16);
				Shape1.addBox(-3F, -1.5F, -2.5F, 5, 3, 5);
				Shape1.setRotationPoint(0F, -0.5F, -14F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, 0.47123889803846897F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 96, 0);
				Shape1.addBox(-4F, -1.5F, -1.5F, 5, 3, 3);
				Shape1.setRotationPoint(-3F, -3F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.1344640137963142F, 0.4363323129985824F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 96, 0);
				Shape1.addBox(-4F, -1.5F, -1.5F, 5, 3, 3);
				Shape1.setRotationPoint(-3F, -2F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.1344640137963142F, -0.2617993877991494F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 96, 6);
				Shape1.addBox(-8F, -1F, 0F, 5, 2, 2);
				Shape1.setRotationPoint(3F, -3F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.7453292519943295F, 0.4363323129985824F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 96, 0);
				Shape1.addBox(-4F, -1.5F, -1.5F, 5, 3, 3);
				Shape1.setRotationPoint(3F, -2F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 2.007128639793479F, -0.2617993877991494F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 96, 6);
				Shape1.addBox(-8F, -1F, -2F, 5, 2, 2);
				Shape1.setRotationPoint(-3F, -2F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.3962634015954636F, -0.2617993877991494F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 96, 6);
				Shape1.addBox(-8F, -1F, 0F, 5, 2, 2);
				Shape1.setRotationPoint(3F, -2F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.7453292519943295F, -0.2617993877991494F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 96, 10);
				Shape1.addBox(-13F, -0.5F, -1F, 5, 1, 1);
				Shape1.setRotationPoint(-3F, -3F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.3613568165555772F, 0.4363323129985824F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 96, 10);
				Shape1.addBox(-13F, -0.5F, -1.5F, 5, 1, 1);
				Shape1.setRotationPoint(-3F, -2F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.3613568165555772F, -0.2617993877991494F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 0, 0);
				Shape1.addBox(0F, -4F, -4F, 4, 8, 8);
				Shape1.setRotationPoint(0F, 0F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, 0F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 96, 10);
				Shape1.addBox(-13F, -0.5F, -0.5F, 5, 1, 1);
				Shape1.setRotationPoint(3F, -2F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.902408884673819F, -0.2617993877991494F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 96, 10);
				Shape1.addBox(-13F, -0.5F, -0.5F, 5, 1, 1);
				Shape1.setRotationPoint(3F, -3F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.902408884673819F, 0.4363323129985824F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 96, 6);
				Shape1.addBox(-8F, -1F, -2F, 5, 2, 2);
				Shape1.setRotationPoint(-3F, -3F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.3962634015954636F, 0.4363323129985824F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 96, 0);
				Shape1.addBox(-4F, -1.5F, -1.5F, 5, 3, 3);
				Shape1.setRotationPoint(3F, -3F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 2.007128639793479F, 0.4363323129985824F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 22, 12);
				Shape1.addBox(-3F, -1.5F, -3.5F, 6, 3, 7);
				Shape1.setRotationPoint(0F, 0F, -7.5F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, 0.17453292519943295F);
				return Shape1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 48, 0);
				Shape1.addBox(0F, -2F, -4.5F, 15, 5, 9);
				Shape1.setRotationPoint(0F, 3F, -2F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, 0F);
				return Shape1;
			}
		}.get()
);
			
				return head;
			}
		}.get()
;
		body = 		new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer body = new ModelRenderer(model);
				body.setRotationPoint(0F, 0F, 0F);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 0, 27);
				Shape1.addBox(0F, -3.5F, -3F, 7, 7, 6);
				Shape1.setRotationPoint(0F, 5F, 15F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.08726646259971647F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 0, 40);
				Shape1.addBox(0F, -4F, -4.5F, 10, 9, 9);
				Shape1.setRotationPoint(0F, 3F, 24F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, 0.13962634015954636F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 0, 58);
				Shape1.addBox(-8F, -6F, -6F, 16, 12, 12);
				Shape1.setRotationPoint(0F, 4.5F, 30F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.13962634015954636F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 26, 27);
				Shape1.addBox(0F, -1.5F, -2.5F, 11, 5, 5);
				Shape1.setRotationPoint(0F, 3.5F, 9F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.2617993877991494F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 56, 58);
				Shape1.addBox(-8F, -5F, -5F, 8, 10, 10);
				Shape1.setRotationPoint(0F, 5F, 35F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.33161255787892263F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 56, 41);
				Shape1.addBox(-10F, -4F, -4F, 10, 8, 8);
				Shape1.setRotationPoint(0F, 7F, 41F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.5235987755982988F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 59, 28);
				Shape1.addBox(-13F, -3F, -3F, 13, 6, 6);
				Shape1.setRotationPoint(0F, 11F, 48F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.5410520681182421F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 97, 28);
				Shape1.addBox(-15F, -2F, -2F, 15, 4, 4);
				Shape1.setRotationPoint(0F, 17.5F, 58F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.3839724354387525F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 97, 37);
				Shape1.addBox(-15F, -1.5F, -1.5F, 15, 3, 3);
				Shape1.setRotationPoint(0F, 23F, 71F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.08726646259971647F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 97, 44);
				Shape1.addBox(-15F, -1.5F, -1F, 15, 2, 2);
				Shape1.setRotationPoint(0F, 24.5F, 84F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.08726646259971647F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 183, 0);
				Shape1.addBox(0F, -7.5F, 0F, 2, 5, 0);
				Shape1.setRotationPoint(0F, 5F, 15F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.08726646259971647F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 183, 0);
				Shape1.addBox(3F, -7F, 0F, 2, 5, 0);
				Shape1.setRotationPoint(0F, 5F, 15F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, 0F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 183, 0);
				Shape1.addBox(7F, -6.5F, 0F, 2, 5, 0);
				Shape1.setRotationPoint(0F, 5F, 15F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, 0.08726646259971647F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 187, 0);
				Shape1.addBox(4F, -9F, -0.5F, 3, 7, 0);
				Shape1.setRotationPoint(0F, 3F, 24F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0.017453292519943295F, 1.5707963267948966F, 0.13962634015954636F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 187, 0);
				Shape1.addBox(1F, -10F, -1.5F, 3, 7, 0);
				Shape1.setRotationPoint(0F, 3F, 24F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0.03490658503988659F, 1.5707963267948966F, 0F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 193, 0);
				Shape1.addBox(3F, -14F, -2F, 4, 10, 0);
				Shape1.setRotationPoint(0F, 4.5F, 30F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0.05235987755982988F, 1.5707963267948966F, -0.13962634015954636F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 187, 0);
				Shape1.addBox(4F, -9F, 0.5F, 3, 7, 0);
				Shape1.setRotationPoint(0F, 3F, 24F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, -0.017453292519943295F, 1.5707963267948966F, 0.13962634015954636F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 187, 0);
				Shape1.addBox(1F, -10F, 1.5F, 3, 7, 0);
				Shape1.setRotationPoint(0F, 3F, 24F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, -0.03490658503988659F, 1.5707963267948966F, 0F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 193, 0);
				Shape1.addBox(3F, -14F, 2F, 4, 10, 0);
				Shape1.setRotationPoint(0F, 4.5F, 30F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, -0.05235987755982988F, 1.5707963267948966F, -0.13962634015954636F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 193, 0);
				Shape1.addBox(-2F, -16F, -2.5F, 4, 10, 0);
				Shape1.setRotationPoint(0F, 4.5F, 30F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0.08726646259971647F, 1.5707963267948966F, -0.2617993877991494F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 193, 0);
				Shape1.addBox(-2F, -16F, 2.5F, 4, 10, 0);
				Shape1.setRotationPoint(0F, 4.5F, 30F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, -0.08726646259971647F, 1.5707963267948966F, -0.2617993877991494F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 193, 0);
				Shape1.addBox(-8F, -14F, 2F, 4, 10, 0);
				Shape1.setRotationPoint(0F, 4.5F, 30F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, -0.05235987755982988F, 1.5707963267948966F, -0.3141592653589793F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 193, 0);
				Shape1.addBox(-8F, -14F, -2F, 4, 10, 0);
				Shape1.setRotationPoint(0F, 4.5F, 30F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0.05235987755982988F, 1.5707963267948966F, -0.3141592653589793F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 201, 0);
				Shape1.addBox(-8F, -10F, -1.5F, 3, 5, 0);
				Shape1.setRotationPoint(0F, 5F, 34F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, -0.03490658503988659F, 1.5707963267948966F, -0.4363323129985824F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 201, 0);
				Shape1.addBox(-8F, -10F, 1.5F, 3, 5, 0);
				Shape1.setRotationPoint(0F, 5F, 34F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, -0.03490658503988659F, 1.5707963267948966F, -0.4363323129985824F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 207, 0);
				Shape1.addBox(-5F, -7F, -1F, 2, 4, 0);
				Shape1.setRotationPoint(0F, 7F, 41F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.5235987755982988F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 207, 0);
				Shape1.addBox(-5F, -7F, 1F, 2, 4, 0);
				Shape1.setRotationPoint(0F, 7F, 41F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.5235987755982988F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 207, 0);
				Shape1.addBox(-8F, -7F, -0.5F, 2, 4, 0);
				Shape1.setRotationPoint(0F, 7F, 41F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.6108652381980153F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 207, 0);
				Shape1.addBox(-8F, -7F, 0.5F, 2, 4, 0);
				Shape1.setRotationPoint(0F, 7F, 41F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.6108652381980153F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 211, 0);
				Shape1.addBox(-12.5F, -4.5F, 0F, 11, 2, 0);
				Shape1.setRotationPoint(0F, 11F, 48F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.6108652381980153F);
				return Shape1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 183, 10);
				Shape1.addBox(-29F, -13.5F, 0F, 35, 12, 0);
				Shape1.setRotationPoint(0F, 23F, 70F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.5707963267948966F, -0.17453292519943295F);
				return Shape1;
			}
		}.get()
);
			
				return body;
			}
		}.get()
;
		legs.add(		new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer LeftLeg = new ModelRenderer(model);
				LeftLeg.setRotationPoint(5F, 6.5F, 30F);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 112, 0);
				Shape1.addBox(-3.5F, -4.5F, 0F, 7, 12, 6);
				Shape1.setRotationPoint(0F, 0F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.3089969389957472F, -0.3490658503988659F);
				return Shape1;
			}
		}.get()
);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 138, 0);
				Shape1.addBox(-3.5F, -0.5F, -3.5F, 7, 12, 7);
				Shape1.setRotationPoint(3F, 6F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 0F, 0F);
				return Shape1;
			}
		}.get()
);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 166, 0);
				Shape1.addBox(-1F, 9.5F, -9.5F, 1, 2, 7);
				Shape1.setRotationPoint(4.300000000000001F, 6F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, -0.08726646259971647F, 0F);
				return Shape1;
			}
		}.get()
);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 166, 0);
				Shape1.addBox(0F, 9.5F, -8.5F, 1, 2, 7);
				Shape1.setRotationPoint(4.300000000000001F, 6F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, -0.3490658503988659F, 0F);
				return Shape1;
			}
		}.get()
);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 166, 0);
				Shape1.addBox(-3F, 9.5F, -9.5F, 1, 2, 7);
				Shape1.setRotationPoint(4.300000000000001F, 6F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 0.08726646259971647F, 0F);
				return Shape1;
			}
		}.get()
);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 166, 0);
				Shape1.addBox(-4F, 9.5F, -8.5F, 1, 2, 7);
				Shape1.setRotationPoint(4.300000000000001F, 6F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 0.3490658503988659F, 0F);
				return Shape1;
			}
		}.get()
);
			
				return LeftLeg;
			}
		}.get()
);
		legs.add(		new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer RightLeg = new ModelRenderer(model);
				RightLeg.setRotationPoint(-5F, 6.5F, 30F);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 112, 0);
				Shape1.addBox(-3.5F, -4.5F, 0F, 7, 12, 6);
				Shape1.setRotationPoint(0F, 0F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, -1.3089969389957472F, 0.3490658503988659F);
				return Shape1;
			}
		}.get()
);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 138, 0);
				Shape1.addBox(-3.5F, -0.5F, -3.5F, 7, 12, 7);
				Shape1.setRotationPoint(-4F, 6F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 0F, 0F);
				return Shape1;
			}
		}.get()
);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 166, 0);
				Shape1.addBox(-2.5F, 9.5F, -8.5F, 1, 2, 7);
				Shape1.setRotationPoint(-3.6999999999999993F, 6F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 0.3490658503988659F, 0F);
				return Shape1;
			}
		}.get()
);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 166, 0);
				Shape1.addBox(-1.5F, 9.5F, -9.5F, 1, 2, 7);
				Shape1.setRotationPoint(-3.6999999999999993F, 6F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 0.08726646259971647F, 0F);
				return Shape1;
			}
		}.get()
);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 166, 0);
				Shape1.addBox(0.5F, 9.5F, -9.5F, 1, 2, 7);
				Shape1.setRotationPoint(-3.6999999999999993F, 6F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, -0.08726646259971647F, 0F);
				return Shape1;
			}
		}.get()
);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 166, 0);
				Shape1.addBox(1F, 9.5F, -8.5F, 1, 2, 7);
				Shape1.setRotationPoint(-3.6999999999999993F, 6F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, -0.3490658503988659F, 0F);
				return Shape1;
			}
		}.get()
);
			
				return RightLeg;
			}
		}.get()
);
		wing = 		new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer LeftWing = new ModelRenderer(model);
				LeftWing.setRotationPoint(3F, 3F, 17.4F);

		LeftWing.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 0, 82);
				Shape1.addBox(-2F, -2F, 0.5F, 4, 4, 10);
				Shape1.setRotationPoint(0F, 0F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.48352986419518F, 0F);
				return Shape1;
			}
		}.get()
);

		LeftWing.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 0, 96);
				Shape1.addBox(-1.5F, -1.5F, 10.5F, 3, 3, 15);
				Shape1.setRotationPoint(0F, 0F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.4660765716752369F, 0F);
				return Shape1;
			}
		}.get()
);

		LeftWing.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 0, 115);
				Shape1.addBox(-1F, -1F, 0F, 2, 2, 25);
				Shape1.setRotationPoint(25F, 0F, 2.6000000000000014F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.7453292519943295F, 0F);
				return Shape1;
			}
		}.get()
);

		LeftWing.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 0, 115);
				Shape1.addBox(0F, -1F, 0F, 4, 2, 1);
				Shape1.setRotationPoint(25F, 0F, 2.6000000000000014F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.7453292519943295F, 0F);
				return Shape1;
			}
		}.get()
);

		LeftWing.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 0, 115);
				Shape1.addBox(0F, -1F, 0F, 4, 2, 1);
				Shape1.setRotationPoint(25F, 0F, 2.6000000000000014F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.2217304763960306F, 0F);
				return Shape1;
			}
		}.get()
);

		LeftWing.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 65, 96);
				Shape1.addBox(-20.5F, 0F, 0.5F, 20, 0, 25);
				Shape1.setRotationPoint(0F, 0F, 0F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.4660765716752369F, 0F);
				return Shape1;
			}
		}.get()
);

		LeftWing.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer Shape1 = new ModelRenderer(model, 65, 121);
				Shape1.addBox(-25F, 0F, -5F, 25, 0, 45);
				Shape1.setRotationPoint(25F, 0F, 2.6000000000000014F);
				Shape1.setTextureSize(textureWidth, textureHeight);
				Shape1.mirror = true;
				setRotation(Shape1, 0F, 1.7453292519943295F, 0F);
				return Shape1;
			}
		}.get()
);
			
				return LeftWing;
			}
		}.get()
;
	}
}