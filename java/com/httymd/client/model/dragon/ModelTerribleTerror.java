package com.httymd.client.model.dragon;

import com.httymd.client.model.ModelDragon;

import net.minecraft.client.model.ModelRenderer;

public class ModelTerribleTerror extends ModelDragon {

	public ModelTerribleTerror() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer head = new ModelRenderer(model);
				head.setRotationPoint(-0.5F, 13F, -9F);

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer head = new ModelRenderer(model, 70, 56);
						head.addBox(-2F, 0F, -5F, 4, 3, 5);
						head.setRotationPoint(0F, -2F, -0.5F);
						head.setTextureSize(textureWidth, textureHeight);
						head.mirror = true;
						setRotation(head, 0F, 0F, 0F);
						return head;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer jaw = new ModelRenderer(model, 88, 55);
						jaw.addBox(-2.5F, 0F, -6F, 5, 3, 6);
						jaw.setRotationPoint(0F, 0F, 0F);
						jaw.setTextureSize(textureWidth, textureHeight);
						jaw.mirror = true;
						setRotation(jaw, 0F, 0F, 0F);
						return jaw;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer horn1 = new ModelRenderer(model, 10, 8);
						horn1.addBox(0F, -5F, 0F, 1, 5, 1);
						horn1.setRotationPoint(0.5F, -1F, -1F);
						horn1.setTextureSize(textureWidth, textureHeight);
						horn1.mirror = true;
						setRotation(horn1, -0.8726646259971648F, 0.20943951023931953F, 0.20943951023931953F);
						return horn1;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer horn2 = new ModelRenderer(model, 10, 8);
						horn2.addBox(-1F, -5F, 0F, 1, 5, 1);
						horn2.setRotationPoint(-0.5F, -1F, -1F);
						horn2.setTextureSize(textureWidth, textureHeight);
						horn2.mirror = true;
						setRotation(horn2, -0.8726646259971648F, -0.20943951023931953F, -0.20943951023931953F);
						return horn2;
					}
				}.get());

				return head;
			}
		}.get();
		body = new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer body = new ModelRenderer(model);
				body.setRotationPoint(0F, 0F, 0F);

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer upperbody = new ModelRenderer(model, 0, 32);
						upperbody.addBox(-1.5F, -1.5F, 0F, 3, 3, 5);
						upperbody.setRotationPoint(-0.5F, 16.5F, -5.5F);
						upperbody.setTextureSize(textureWidth, textureHeight);
						upperbody.mirror = true;
						setRotation(upperbody, 0.08726646259971647F, 0F, 0F);
						return upperbody;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer middlebody = new ModelRenderer(model, 16, 35);
						middlebody.addBox(-2F, -2F, 0F, 4, 4, 7);
						middlebody.setRotationPoint(-0.5F, 16F, -1F);
						middlebody.setTextureSize(textureWidth, textureHeight);
						middlebody.mirror = true;
						setRotation(middlebody, -0.08726646259971647F, 0F, 0F);
						return middlebody;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer bottombody = new ModelRenderer(model, 0, 25);
						bottombody.addBox(-1.5F, -1.5F, 0F, 3, 3, 4);
						bottombody.setRotationPoint(-0.5F, 16.5F, 5F);
						bottombody.setTextureSize(textureWidth, textureHeight);
						bottombody.mirror = true;
						setRotation(bottombody, -0.2617993877991494F, 0F, 0F);
						return bottombody;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail1 = new ModelRenderer(model, 0, 19);
						tail1.addBox(-1F, -1F, 0F, 2, 2, 4);
						tail1.setRotationPoint(-0.5F, 17F, 8F);
						tail1.setTextureSize(textureWidth, textureHeight);
						tail1.mirror = true;
						setRotation(tail1, -0.3490658503988659F, 0F, 0F);
						return tail1;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail2 = new ModelRenderer(model, 0, 14);
						tail2.addBox(-1F, 0F, 0F, 1, 1, 4);
						tail2.setRotationPoint(0F, 17.5F, 11F);
						tail2.setTextureSize(textureWidth, textureHeight);
						tail2.mirror = true;
						setRotation(tail2, -0.3490658503988659F, 0F, 0F);
						return tail2;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail3 = new ModelRenderer(model, 0, 9);
						tail3.addBox(0F, 0F, 0F, 1, 1, 4);
						tail3.setRotationPoint(-1F, 18.8F, 14.5F);
						tail3.setTextureSize(textureWidth, textureHeight);
						tail3.mirror = true;
						setRotation(tail3, -0.2617993877991494F, 0F, 0F);
						return tail3;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail4 = new ModelRenderer(model, 0, 4);
						tail4.addBox(0F, 0F, 0F, 1, 1, 4);
						tail4.setRotationPoint(-1F, 19.8F, 18F);
						tail4.setTextureSize(textureWidth, textureHeight);
						tail4.mirror = true;
						setRotation(tail4, -0.17453292519943295F, 0F, 0F);
						return tail4;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail5 = new ModelRenderer(model, 10, 14);
						tail5.addBox(0F, 0F, 0F, 1, 1, 4);
						tail5.setRotationPoint(-1F, 20.5F, 21.5F);
						tail5.setTextureSize(textureWidth, textureHeight);
						tail5.mirror = true;
						setRotation(tail5, 0F, 0F, 0F);
						return tail5;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer neck1 = new ModelRenderer(model, 42, 48);
						neck1.addBox(-1F, -1F, -3F, 2, 2, 3);
						neck1.setRotationPoint(-0.5F, 16.6F, -5F);
						neck1.setTextureSize(textureWidth, textureHeight);
						neck1.mirror = true;
						setRotation(neck1, -0.2617993877991494F, 0F, 0F);
						return neck1;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer neck2 = new ModelRenderer(model, 32, 48);
						neck2.addBox(-1F, -1F, -3F, 2, 2, 3);
						neck2.setRotationPoint(-0.5F, 16F, -7.5F);
						neck2.setTextureSize(textureWidth, textureHeight);
						neck2.mirror = true;
						setRotation(neck2, -0.5235987755982988F, 0F, 0F);
						return neck2;
					}
				}.get());

				return body;
			}
		}.get();
		legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg1 = new ModelRenderer(model);
				leg1.setRotationPoint(0F, 15.5F, -5F);

				leg1.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg1 = new ModelRenderer(model, 0, 46);
						leg1.addBox(-1F, 0F, -1F, 2, 5, 2);
						leg1.setRotationPoint(2.5F, 3.5F, 0F);
						leg1.setTextureSize(textureWidth, textureHeight);
						leg1.mirror = true;
						setRotation(leg1, -0.17453292519943295F, 0.08726646259971647F, 0F);
						return leg1;
					}
				}.get());

				leg1.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg1upper = new ModelRenderer(model, 0, 40);
						leg1upper.addBox(0F, 0F, 0F, 1, 5, 1);
						leg1upper.setRotationPoint(0F, 0F, 0F);
						leg1upper.setTextureSize(textureWidth, textureHeight);
						leg1upper.mirror = true;
						setRotation(leg1upper, 0F, 0.08726646259971647F, -0.5235987755982988F);
						return leg1upper;
					}
				}.get());

				return leg1;
			}
		}.get());
		legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg2 = new ModelRenderer(model);
				leg2.setRotationPoint(-1F, 15.5F, -5F);

				leg2.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg2 = new ModelRenderer(model, 8, 46);
						leg2.addBox(-1F, 0F, -1F, 2, 5, 2);
						leg2.setRotationPoint(-2.5F, 3.5F, 0F);
						leg2.setTextureSize(textureWidth, textureHeight);
						leg2.mirror = true;
						setRotation(leg2, -0.17453292519943295F, -0.08726646259971647F, 0F);
						return leg2;
					}
				}.get());

				leg2.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg2upper = new ModelRenderer(model, 4, 40);
						leg2upper.addBox(-1F, 0F, 0F, 1, 5, 1);
						leg2upper.setRotationPoint(0F, 0F, 0F);
						leg2upper.setTextureSize(textureWidth, textureHeight);
						leg2upper.mirror = true;
						setRotation(leg2upper, 0F, -0.08726646259971647F, 0.5235987755982988F);
						return leg2upper;
					}
				}.get());

				return leg2;
			}
		}.get());
		legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg4 = new ModelRenderer(model);
				leg4.setRotationPoint(-3F, 15F, 4F);

				leg4.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg4 = new ModelRenderer(model, 24, 46);
						leg4.addBox(-1F, 0F, -1F, 2, 5, 2);
						leg4.setRotationPoint(-0.5F, 4F, 0F);
						leg4.setTextureSize(textureWidth, textureHeight);
						leg4.mirror = true;
						setRotation(leg4, 0.08726646259971647F, 0.17453292519943295F, 0F);
						return leg4;
					}
				}.get());

				leg4.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg4upper = new ModelRenderer(model, 12, 40);
						leg4upper.addBox(0F, 0F, 0F, 1, 5, 1);
						leg4upper.setRotationPoint(0F, 0F, 0F);
						leg4upper.setTextureSize(textureWidth, textureHeight);
						leg4upper.mirror = true;
						setRotation(leg4upper, -0.08726646259971647F, 0F, 0.2617993877991494F);
						return leg4upper;
					}
				}.get());

				return leg4;
			}
		}.get());
		legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg3 = new ModelRenderer(model);
				leg3.setRotationPoint(1F, 15F, 4F);

				leg3.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg3 = new ModelRenderer(model, 16, 46);
						leg3.addBox(-1F, 0F, -1F, 2, 5, 2);
						leg3.setRotationPoint(1.5F, 4F, 0F);
						leg3.setTextureSize(textureWidth, textureHeight);
						leg3.mirror = true;
						setRotation(leg3, 0.08726646259971647F, -0.17453292519943295F, 0F);
						return leg3;
					}
				}.get());

				leg3.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg3upper = new ModelRenderer(model, 8, 40);
						leg3upper.addBox(0F, 0F, 0F, 1, 5, 1);
						leg3upper.setRotationPoint(0F, 0F, 0F);
						leg3upper.setTextureSize(textureWidth, textureHeight);
						leg3upper.mirror = true;
						setRotation(leg3upper, -0.08726646259971647F, 0F, -0.2617993877991494F);
						return leg3upper;
					}
				}.get());

				return leg3;
			}
		}.get());
		wing = new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer wing1 = new ModelRenderer(model, 0, 53);
				wing1.addBox(0F, 0F, 0F, 24, 0, 11);
				wing1.setRotationPoint(0F, 15F, -5F);
				wing1.setTextureSize(textureWidth, textureHeight);
				wing1.mirror = true;
				setRotation(wing1, 0F, 0F, 0F);
				return wing1;
			}
		}.get();
	}
}