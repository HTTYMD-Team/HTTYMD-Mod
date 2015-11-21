package com.httymd.client.model.dragon;

import com.httymd.client.model.ModelDragon;

import net.minecraft.client.model.ModelRenderer;

public class ModelTerribleTerror extends ModelDragon {

	public ModelTerribleTerror() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer head = new ModelRenderer(ModelTerribleTerror.this.model);
				head.setRotationPoint(-0.5F, 13F, -9F);

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer head = new ModelRenderer(ModelTerribleTerror.this.model, 70, 56);
						head.addBox(-2F, 0F, -5F, 4, 3, 5);
						head.setRotationPoint(0F, -2F, -0.5F);
						head.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						head.mirror = true;
						ModelTerribleTerror.this.setRotation(head, 0F, 0F, 0F);
						return head;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer jaw = new ModelRenderer(ModelTerribleTerror.this.model, 88, 55);
						jaw.addBox(-2.5F, 0F, -6F, 5, 3, 6);
						jaw.setRotationPoint(0F, 0F, 0F);
						jaw.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						jaw.mirror = true;
						ModelTerribleTerror.this.setRotation(jaw, 0F, 0F, 0F);
						return jaw;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer horn1 = new ModelRenderer(ModelTerribleTerror.this.model, 10, 8);
						horn1.addBox(0F, -5F, 0F, 1, 5, 1);
						horn1.setRotationPoint(0.5F, -1F, -1F);
						horn1.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						horn1.mirror = true;
						ModelTerribleTerror.this.setRotation(horn1, -0.8726646259971648F, 0.20943951023931953F,
								0.20943951023931953F);
						return horn1;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer horn2 = new ModelRenderer(ModelTerribleTerror.this.model, 10, 8);
						horn2.addBox(-1F, -5F, 0F, 1, 5, 1);
						horn2.setRotationPoint(-0.5F, -1F, -1F);
						horn2.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						horn2.mirror = true;
						ModelTerribleTerror.this.setRotation(horn2, -0.8726646259971648F, -0.20943951023931953F,
								-0.20943951023931953F);
						return horn2;
					}
				}.get());

				return head;
			}
		}.get();
		this.body = new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer body = new ModelRenderer(ModelTerribleTerror.this.model);
				body.setRotationPoint(0F, 0F, 0F);

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer upperbody = new ModelRenderer(ModelTerribleTerror.this.model, 0, 32);
						upperbody.addBox(-1.5F, -1.5F, 0F, 3, 3, 5);
						upperbody.setRotationPoint(-0.5F, 16.5F, -5.5F);
						upperbody.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						upperbody.mirror = true;
						ModelTerribleTerror.this.setRotation(upperbody, 0.08726646259971647F, 0F, 0F);
						return upperbody;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer middlebody = new ModelRenderer(ModelTerribleTerror.this.model, 16, 35);
						middlebody.addBox(-2F, -2F, 0F, 4, 4, 7);
						middlebody.setRotationPoint(-0.5F, 16F, -1F);
						middlebody.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						middlebody.mirror = true;
						ModelTerribleTerror.this.setRotation(middlebody, -0.08726646259971647F, 0F, 0F);
						return middlebody;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer bottombody = new ModelRenderer(ModelTerribleTerror.this.model, 0, 25);
						bottombody.addBox(-1.5F, -1.5F, 0F, 3, 3, 4);
						bottombody.setRotationPoint(-0.5F, 16.5F, 5F);
						bottombody.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						bottombody.mirror = true;
						ModelTerribleTerror.this.setRotation(bottombody, -0.2617993877991494F, 0F, 0F);
						return bottombody;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail1 = new ModelRenderer(ModelTerribleTerror.this.model, 0, 19);
						tail1.addBox(-1F, -1F, 0F, 2, 2, 4);
						tail1.setRotationPoint(-0.5F, 17F, 8F);
						tail1.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						tail1.mirror = true;
						ModelTerribleTerror.this.setRotation(tail1, -0.3490658503988659F, 0F, 0F);
						return tail1;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail2 = new ModelRenderer(ModelTerribleTerror.this.model, 0, 14);
						tail2.addBox(-1F, 0F, 0F, 1, 1, 4);
						tail2.setRotationPoint(0F, 17.5F, 11F);
						tail2.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						tail2.mirror = true;
						ModelTerribleTerror.this.setRotation(tail2, -0.3490658503988659F, 0F, 0F);
						return tail2;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail3 = new ModelRenderer(ModelTerribleTerror.this.model, 0, 9);
						tail3.addBox(0F, 0F, 0F, 1, 1, 4);
						tail3.setRotationPoint(-1F, 18.8F, 14.5F);
						tail3.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						tail3.mirror = true;
						ModelTerribleTerror.this.setRotation(tail3, -0.2617993877991494F, 0F, 0F);
						return tail3;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail4 = new ModelRenderer(ModelTerribleTerror.this.model, 0, 4);
						tail4.addBox(0F, 0F, 0F, 1, 1, 4);
						tail4.setRotationPoint(-1F, 19.8F, 18F);
						tail4.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						tail4.mirror = true;
						ModelTerribleTerror.this.setRotation(tail4, -0.17453292519943295F, 0F, 0F);
						return tail4;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail5 = new ModelRenderer(ModelTerribleTerror.this.model, 10, 14);
						tail5.addBox(0F, 0F, 0F, 1, 1, 4);
						tail5.setRotationPoint(-1F, 20.5F, 21.5F);
						tail5.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						tail5.mirror = true;
						ModelTerribleTerror.this.setRotation(tail5, 0F, 0F, 0F);
						return tail5;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer neck1 = new ModelRenderer(ModelTerribleTerror.this.model, 42, 48);
						neck1.addBox(-1F, -1F, -3F, 2, 2, 3);
						neck1.setRotationPoint(-0.5F, 16.6F, -5F);
						neck1.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						neck1.mirror = true;
						ModelTerribleTerror.this.setRotation(neck1, -0.2617993877991494F, 0F, 0F);
						return neck1;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer neck2 = new ModelRenderer(ModelTerribleTerror.this.model, 32, 48);
						neck2.addBox(-1F, -1F, -3F, 2, 2, 3);
						neck2.setRotationPoint(-0.5F, 16F, -7.5F);
						neck2.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						neck2.mirror = true;
						ModelTerribleTerror.this.setRotation(neck2, -0.5235987755982988F, 0F, 0F);
						return neck2;
					}
				}.get());

				return body;
			}
		}.get();
		this.legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg1 = new ModelRenderer(ModelTerribleTerror.this.model);
				leg1.setRotationPoint(0F, 15.5F, -5F);

				leg1.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg1 = new ModelRenderer(ModelTerribleTerror.this.model, 0, 46);
						leg1.addBox(-1F, 0F, -1F, 2, 5, 2);
						leg1.setRotationPoint(2.5F, 3.5F, 0F);
						leg1.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						leg1.mirror = true;
						ModelTerribleTerror.this.setRotation(leg1, -0.17453292519943295F, 0.08726646259971647F, 0F);
						return leg1;
					}
				}.get());

				leg1.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg1upper = new ModelRenderer(ModelTerribleTerror.this.model, 0, 40);
						leg1upper.addBox(0F, 0F, 0F, 1, 5, 1);
						leg1upper.setRotationPoint(0F, 0F, 0F);
						leg1upper.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						leg1upper.mirror = true;
						ModelTerribleTerror.this.setRotation(leg1upper, 0F, 0.08726646259971647F, -0.5235987755982988F);
						return leg1upper;
					}
				}.get());

				return leg1;
			}
		}.get());
		this.legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg2 = new ModelRenderer(ModelTerribleTerror.this.model);
				leg2.setRotationPoint(-1F, 15.5F, -5F);

				leg2.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg2 = new ModelRenderer(ModelTerribleTerror.this.model, 8, 46);
						leg2.addBox(-1F, 0F, -1F, 2, 5, 2);
						leg2.setRotationPoint(-2.5F, 3.5F, 0F);
						leg2.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						leg2.mirror = true;
						ModelTerribleTerror.this.setRotation(leg2, -0.17453292519943295F, -0.08726646259971647F, 0F);
						return leg2;
					}
				}.get());

				leg2.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg2upper = new ModelRenderer(ModelTerribleTerror.this.model, 4, 40);
						leg2upper.addBox(-1F, 0F, 0F, 1, 5, 1);
						leg2upper.setRotationPoint(0F, 0F, 0F);
						leg2upper.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						leg2upper.mirror = true;
						ModelTerribleTerror.this.setRotation(leg2upper, 0F, -0.08726646259971647F, 0.5235987755982988F);
						return leg2upper;
					}
				}.get());

				return leg2;
			}
		}.get());
		this.legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg4 = new ModelRenderer(ModelTerribleTerror.this.model);
				leg4.setRotationPoint(-3F, 15F, 4F);

				leg4.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg4 = new ModelRenderer(ModelTerribleTerror.this.model, 24, 46);
						leg4.addBox(-1F, 0F, -1F, 2, 5, 2);
						leg4.setRotationPoint(-0.5F, 4F, 0F);
						leg4.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						leg4.mirror = true;
						ModelTerribleTerror.this.setRotation(leg4, 0.08726646259971647F, 0.17453292519943295F, 0F);
						return leg4;
					}
				}.get());

				leg4.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg4upper = new ModelRenderer(ModelTerribleTerror.this.model, 12, 40);
						leg4upper.addBox(0F, 0F, 0F, 1, 5, 1);
						leg4upper.setRotationPoint(0F, 0F, 0F);
						leg4upper.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						leg4upper.mirror = true;
						ModelTerribleTerror.this.setRotation(leg4upper, -0.08726646259971647F, 0F, 0.2617993877991494F);
						return leg4upper;
					}
				}.get());

				return leg4;
			}
		}.get());
		this.legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg3 = new ModelRenderer(ModelTerribleTerror.this.model);
				leg3.setRotationPoint(1F, 15F, 4F);

				leg3.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg3 = new ModelRenderer(ModelTerribleTerror.this.model, 16, 46);
						leg3.addBox(-1F, 0F, -1F, 2, 5, 2);
						leg3.setRotationPoint(1.5F, 4F, 0F);
						leg3.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						leg3.mirror = true;
						ModelTerribleTerror.this.setRotation(leg3, 0.08726646259971647F, -0.17453292519943295F, 0F);
						return leg3;
					}
				}.get());

				leg3.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg3upper = new ModelRenderer(ModelTerribleTerror.this.model, 8, 40);
						leg3upper.addBox(0F, 0F, 0F, 1, 5, 1);
						leg3upper.setRotationPoint(0F, 0F, 0F);
						leg3upper.setTextureSize(ModelTerribleTerror.this.textureWidth,
								ModelTerribleTerror.this.textureHeight);
						leg3upper.mirror = true;
						ModelTerribleTerror.this.setRotation(leg3upper, -0.08726646259971647F, 0F,
								-0.2617993877991494F);
						return leg3upper;
					}
				}.get());

				return leg3;
			}
		}.get());
		this.wing = new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer wing1 = new ModelRenderer(ModelTerribleTerror.this.model, 0, 53);
				wing1.addBox(0F, 0F, 0F, 24, 0, 11);
				wing1.setRotationPoint(0F, 15F, -5F);
				wing1.setTextureSize(ModelTerribleTerror.this.textureWidth, ModelTerribleTerror.this.textureHeight);
				wing1.mirror = true;
				ModelTerribleTerror.this.setRotation(wing1, 0F, 0F, 0F);
				return wing1;
			}
		}.get();
	}
}