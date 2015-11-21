package com.httymd.client.model.dragon;

import com.httymd.client.model.ModelDragon;

import net.minecraft.client.model.ModelRenderer;

public class ModelNightFuryOld extends ModelDragon {

	public ModelNightFuryOld() {
		this.textureWidth = 512;
		this.textureHeight = 256;

		this.head = new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer head = new ModelRenderer(ModelNightFuryOld.this.model);
				head.setRotationPoint(0F, -12F, -22F);

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer head = new ModelRenderer(ModelNightFuryOld.this.model, 0, 148);
						head.addBox(0F, 0F, 0F, 15, 8, 15);
						head.setRotationPoint(0F, -1F, -16F);
						head.setTextureSize(ModelNightFuryOld.this.textureWidth, ModelNightFuryOld.this.textureHeight);
						head.mirror = true;
						ModelNightFuryOld.this.setRotation(head, 0.17453292519943295F, -0.7853981633974483F,
								-0.17453292519943295F);
						return head;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer mainfin1 = new ModelRenderer(ModelNightFuryOld.this.model, 214, 239);
						mainfin1.addBox(-4F, 0F, 0F, 5, 3, 14);
						mainfin1.setRotationPoint(-6F, -3F, -5F);
						mainfin1.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						mainfin1.mirror = true;
						ModelNightFuryOld.this.setRotation(mainfin1, 0.3490658503988659F, -0.06981317007977318F,
								-0.08726646259971647F);
						return mainfin1;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer mainfin2 = new ModelRenderer(ModelNightFuryOld.this.model, 214, 239);
						mainfin2.addBox(0F, 0F, 0F, 5, 3, 14);
						mainfin2.setRotationPoint(5F, -3F, -5F);
						mainfin2.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						mainfin2.mirror = true;
						ModelNightFuryOld.this.setRotation(mainfin2, 0.3490658503988659F, 0.06981317007977318F,
								0.08726646259971647F);
						return mainfin2;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer secondfin1 = new ModelRenderer(ModelNightFuryOld.this.model, 252, 249);
						secondfin1.addBox(-3F, 0F, 0F, 3, 2, 5);
						secondfin1.setRotationPoint(-1F, -5F, 1F);
						secondfin1.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						secondfin1.mirror = true;
						ModelNightFuryOld.this.setRotation(secondfin1, 0.24434609527920614F, -0.08726646259971647F,
								-0.08726646259971647F);
						return secondfin1;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer secondfin2 = new ModelRenderer(ModelNightFuryOld.this.model, 252, 249);
						secondfin2.addBox(0F, 0F, 0F, 3, 2, 5);
						secondfin2.setRotationPoint(1F, -5F, 1F);
						secondfin2.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						secondfin2.mirror = true;
						ModelNightFuryOld.this.setRotation(secondfin2, 0.24434609527920614F, 0.10471975511965977F,
								0.08726646259971647F);
						return secondfin2;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer thirdfin1 = new ModelRenderer(ModelNightFuryOld.this.model, 268, 247);
						thirdfin1.addBox(-1F, 0F, 0F, 1, 3, 6);
						thirdfin1.setRotationPoint(-9F, -1F, -4F);
						thirdfin1.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						thirdfin1.mirror = true;
						ModelNightFuryOld.this.setRotation(thirdfin1, 0F, -0.3490658503988659F, 0F);
						return thirdfin1;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer thirdfin2 = new ModelRenderer(ModelNightFuryOld.this.model, 268, 247);
						thirdfin2.addBox(0F, 0F, 0F, 1, 3, 6);
						thirdfin2.setRotationPoint(9F, -1F, -4F);
						thirdfin2.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						thirdfin2.mirror = true;
						ModelNightFuryOld.this.setRotation(thirdfin2, 0F, 0.3490658503988659F, 0F);
						return thirdfin2;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer fourthfin1 = new ModelRenderer(ModelNightFuryOld.this.model, 282, 250);
						fourthfin1.addBox(-1F, 0F, 0F, 1, 2, 4);
						fourthfin1.setRotationPoint(-9F, 2F, -4F);
						fourthfin1.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						fourthfin1.mirror = true;
						ModelNightFuryOld.this.setRotation(fourthfin1, -0.03490658503988659F, -0.2617993877991494F,
								-0.13962634015954636F);
						return fourthfin1;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer fourthfin2 = new ModelRenderer(ModelNightFuryOld.this.model, 282, 250);
						fourthfin2.addBox(0F, 0F, 0F, 1, 2, 4);
						fourthfin2.setRotationPoint(9F, 2F, -4F);
						fourthfin2.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						fourthfin2.mirror = true;
						ModelNightFuryOld.this.setRotation(fourthfin2, -0.03490658503988659F, 0.2617993877991494F,
								0.13962634015954636F);
						return fourthfin2;
					}
				}.get());

				return head;
			}
		}.get();
		this.body = new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer body = new ModelRenderer(ModelNightFuryOld.this.model);
				body.setRotationPoint(0F, 0F, 0F);

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tailwing2 = new ModelRenderer(ModelNightFuryOld.this.model, 392, 221);
						tailwing2.addBox(-25F, 0F, 0F, 25, 0, 35);
						tailwing2.setRotationPoint(-4F, -4F, 25F);
						tailwing2.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						tailwing2.mirror = true;
						ModelNightFuryOld.this.setRotation(tailwing2, -0.12217304763960307F, 0F, 0F);
						return tailwing2;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tailwing1 = new ModelRenderer(ModelNightFuryOld.this.model, 392, 221);
						tailwing1.addBox(-25F, 0F, 0F, 25, 0, 35);
						tailwing1.setRotationPoint(4F, -4F, 25F);
						tailwing1.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						tailwing1.mirror = true;
						ModelNightFuryOld.this.setRotation(tailwing1, 0.12217304763960307F, 0F, 3.141592653589793F);
						return tailwing1;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tailfin = new ModelRenderer(ModelNightFuryOld.this.model, 0, 222);
						tailfin.addBox(-23F, 0F, 0F, 46, 0, 35);
						tailfin.setRotationPoint(0F, 16.5F, 115F);
						tailfin.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						tailfin.mirror = true;
						ModelNightFuryOld.this.setRotation(tailfin, 0F, 0F, 0F);
						return tailfin;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail6 = new ModelRenderer(ModelNightFuryOld.this.model, 162, 230);
						tail6.addBox(0F, 0F, 0F, 2, 2, 24);
						tail6.setRotationPoint(-1F, 15F, 114F);
						tail6.setTextureSize(ModelNightFuryOld.this.textureWidth, ModelNightFuryOld.this.textureHeight);
						tail6.mirror = true;
						ModelNightFuryOld.this.setRotation(tail6, 0F, 0F, 0F);
						return tail6;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail5 = new ModelRenderer(ModelNightFuryOld.this.model, 200, 199);
						tail5.addBox(0F, 0F, 0F, 4, 4, 18);
						tail5.setRotationPoint(-2F, 11F, 98F);
						tail5.setTextureSize(ModelNightFuryOld.this.textureWidth, ModelNightFuryOld.this.textureHeight);
						tail5.mirror = true;
						ModelNightFuryOld.this.setRotation(tail5, -0.17453292519943295F, 0F, 0F);
						return tail5;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail4 = new ModelRenderer(ModelNightFuryOld.this.model, 200, 175);
						tail4.addBox(0F, 0F, 0F, 6, 6, 18);
						tail4.setRotationPoint(-3F, 6F, 82F);
						tail4.setTextureSize(ModelNightFuryOld.this.textureWidth, ModelNightFuryOld.this.textureHeight);
						tail4.mirror = true;
						ModelNightFuryOld.this.setRotation(tail4, -0.2617993877991494F, 0F, 0F);
						return tail4;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail3 = new ModelRenderer(ModelNightFuryOld.this.model, 199, 117);
						tail3.addBox(0F, 0F, 0F, 8, 8, 18);
						tail3.setRotationPoint(-4F, 1F, 66F);
						tail3.setTextureSize(ModelNightFuryOld.this.textureWidth, ModelNightFuryOld.this.textureHeight);
						tail3.mirror = true;
						ModelNightFuryOld.this.setRotation(tail3, -0.2617993877991494F, 0F, 0F);
						return tail3;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail2 = new ModelRenderer(ModelNightFuryOld.this.model, 196, 143);
						tail2.addBox(0F, 0F, 0F, 10, 10, 18);
						tail2.setRotationPoint(-5F, -3F, 49F);
						tail2.setTextureSize(ModelNightFuryOld.this.textureWidth, ModelNightFuryOld.this.textureHeight);
						tail2.mirror = true;
						ModelNightFuryOld.this.setRotation(tail2, -0.17453292519943295F, 0F, 0F);
						return tail2;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail1 = new ModelRenderer(ModelNightFuryOld.this.model, 136, 111);
						tail1.addBox(0F, 0F, 0F, 12, 12, 18);
						tail1.setRotationPoint(-6F, -5F, 32F);
						tail1.setTextureSize(ModelNightFuryOld.this.textureWidth, ModelNightFuryOld.this.textureHeight);
						tail1.mirror = true;
						ModelNightFuryOld.this.setRotation(tail1, -0.08726646259971647F, 0F, 0F);
						return tail1;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer bodyback = new ModelRenderer(ModelNightFuryOld.this.model, 128, 142);
						bodyback.addBox(0F, 0F, 0F, 18, 13, 16);
						bodyback.setRotationPoint(-9F, -6F, 17F);
						bodyback.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						bodyback.mirror = true;
						ModelNightFuryOld.this.setRotation(bodyback, 0F, 0F, 0F);
						return bodyback;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer bodymiddle = new ModelRenderer(ModelNightFuryOld.this.model, 51, 111);
						bodymiddle.addBox(0F, 0F, 0F, 20, 14, 18);
						bodymiddle.setRotationPoint(-10F, -7F, 0F);
						bodymiddle.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						bodymiddle.mirror = true;
						ModelNightFuryOld.this.setRotation(bodymiddle, 0F, 0F, 0F);
						return bodymiddle;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer upperbody = new ModelRenderer(ModelNightFuryOld.this.model, 60, 143);
						upperbody.addBox(0F, 0F, 0F, 18, 12, 16);
						upperbody.setRotationPoint(-9F, -8F, -14F);
						upperbody.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						upperbody.mirror = true;
						ModelNightFuryOld.this.setRotation(upperbody, -0.08726646259971647F, 0F, 0F);
						return upperbody;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer neck = new ModelRenderer(ModelNightFuryOld.this.model, 0, 124);
						neck.addBox(-6F, -10F, -7F, 14, 15, 9);
						neck.setRotationPoint(-1F, -8F, -15F);
						neck.setTextureSize(ModelNightFuryOld.this.textureWidth, ModelNightFuryOld.this.textureHeight);
						neck.mirror = true;
						ModelNightFuryOld.this.setRotation(neck, 1.0471975511965976F, 0F, 0F);
						return neck;
					}
				}.get());

				return body;
			}
		}.get();
		this.legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg2 = new ModelRenderer(ModelNightFuryOld.this.model);
				leg2.setRotationPoint(7F, -3F, 21F);

				leg2.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg2upper = new ModelRenderer(ModelNightFuryOld.this.model, 418, 0);
						leg2upper.addBox(0F, 0F, 0F, 7, 14, 7);
						leg2upper.setRotationPoint(0F, 0F, 0F);
						leg2upper.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						leg2upper.mirror = true;
						ModelNightFuryOld.this.setRotation(leg2upper, -0.03490658503988659F, 0F, -0.03490658503988659F);
						return leg2upper;
					}
				}.get());

				leg2.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg2 = new ModelRenderer(ModelNightFuryOld.this.model, 446, 0);
						leg2.addBox(-7F, 0F, -1F, 8, 14, 8);
						leg2.setRotationPoint(7F, 13F, 0F);
						leg2.setTextureSize(ModelNightFuryOld.this.textureWidth, ModelNightFuryOld.this.textureHeight);
						leg2.mirror = true;
						ModelNightFuryOld.this.setRotation(leg2, 0F, 0F, 0F);
						return leg2;
					}
				}.get());

				return leg2;
			}
		}.get());
		this.legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg1 = new ModelRenderer(ModelNightFuryOld.this.model);
				leg1.setRotationPoint(-5F, -3F, 21F);

				leg1.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg1upper = new ModelRenderer(ModelNightFuryOld.this.model, 418, 0);
						leg1upper.addBox(-9F, 0F, 0F, 7, 14, 7);
						leg1upper.setRotationPoint(0F, 0F, 0F);
						leg1upper.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						leg1upper.mirror = true;
						ModelNightFuryOld.this.setRotation(leg1upper, -0.03490658503988659F, 0F, 0.03490658503988659F);
						return leg1upper;
					}
				}.get());

				leg1.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg1 = new ModelRenderer(ModelNightFuryOld.this.model, 446, 0);
						leg1.addBox(-3F, 0F, -2F, 8, 14, 8);
						leg1.setRotationPoint(-7F, 13F, 1F);
						leg1.setTextureSize(ModelNightFuryOld.this.textureWidth, ModelNightFuryOld.this.textureHeight);
						leg1.mirror = true;
						ModelNightFuryOld.this.setRotation(leg1, 0F, 0F, 0F);
						return leg1;
					}
				}.get());

				return leg1;
			}
		}.get());
		this.legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg3 = new ModelRenderer(ModelNightFuryOld.this.model);
				leg3.setRotationPoint(-7F, -4F, -8F);

				leg3.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg3upper = new ModelRenderer(ModelNightFuryOld.this.model, 390, 0);
						leg3upper.addBox(-7F, 0F, 0F, 7, 15, 7);
						leg3upper.setRotationPoint(0F, 0F, 0F);
						leg3upper.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						leg3upper.mirror = true;
						ModelNightFuryOld.this.setRotation(leg3upper, 0.08726646259971647F, 0F, 0.03490658503988659F);
						return leg3upper;
					}
				}.get());

				leg3.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg3 = new ModelRenderer(ModelNightFuryOld.this.model, 478, 0);
						leg3.addBox(-8F, 0F, 0F, 8, 14, 9);
						leg3.setRotationPoint(0F, 14F, 0F);
						leg3.setTextureSize(ModelNightFuryOld.this.textureWidth, ModelNightFuryOld.this.textureHeight);
						leg3.mirror = true;
						ModelNightFuryOld.this.setRotation(leg3, 0F, 0F, 0F);
						return leg3;
					}
				}.get());

				return leg3;
			}
		}.get());
		this.legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg4 = new ModelRenderer(ModelNightFuryOld.this.model);
				leg4.setRotationPoint(7F, -4F, -8F);

				leg4.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg4upper = new ModelRenderer(ModelNightFuryOld.this.model, 390, 0);
						leg4upper.addBox(0F, 0F, 0F, 7, 15, 7);
						leg4upper.setRotationPoint(0F, 0F, 0F);
						leg4upper.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						leg4upper.mirror = true;
						ModelNightFuryOld.this.setRotation(leg4upper, 0.08726646259971647F, 0F, -0.03490658503988659F);
						return leg4upper;
					}
				}.get());

				leg4.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg4 = new ModelRenderer(ModelNightFuryOld.this.model, 478, 0);
						leg4.addBox(-1F, 0F, -3F, 8, 14, 9);
						leg4.setRotationPoint(1F, 14F, 3F);
						leg4.setTextureSize(ModelNightFuryOld.this.textureWidth, ModelNightFuryOld.this.textureHeight);
						leg4.mirror = true;
						ModelNightFuryOld.this.setRotation(leg4, 0F, 0F, 0F);
						return leg4;
					}
				}.get());

				return leg4;
			}
		}.get());
		this.wing = new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer rightWing = new ModelRenderer(ModelNightFuryOld.this.model);
				rightWing.setRotationPoint(-9F, -9F, -12F);

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer rightbicep = new ModelRenderer(ModelNightFuryOld.this.model, 292, 244);
						rightbicep.addBox(-22F, 0F, 0F, 22, 6, 6);
						rightbicep.setRotationPoint(0F, 0F, 0F);
						rightbicep.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						rightbicep.mirror = true;
						ModelNightFuryOld.this.setRotation(rightbicep, 0F, 0.2617993877991494F, 0F);
						return rightbicep;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer righttricep = new ModelRenderer(ModelNightFuryOld.this.model, 292, 235);
						righttricep.addBox(-29F, 0F, -4F, 29, 4, 4);
						righttricep.setRotationPoint(-20F, 1F, 11F);
						righttricep.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						righttricep.mirror = true;
						ModelNightFuryOld.this.setRotation(righttricep, 0F, -0.2617993877991494F, 0F);
						return righttricep;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer wingfin11 = new ModelRenderer(ModelNightFuryOld.this.model, 0, 0);
						wingfin11.addBox(0F, 0F, -2F, 55, 2, 2);
						wingfin11.setRotationPoint(-50F, 2F, 1F);
						wingfin11.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						wingfin11.mirror = true;
						ModelNightFuryOld.this.setRotation(wingfin11, 0F, -1.5707963267948966F, 0F);
						return wingfin11;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer wingfin8 = new ModelRenderer(ModelNightFuryOld.this.model, 0, 0);
						wingfin8.addBox(-85F, 0F, 0F, 85, 2, 2);
						wingfin8.setRotationPoint(-47F, 2F, 1F);
						wingfin8.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						wingfin8.mirror = true;
						ModelNightFuryOld.this.setRotation(wingfin8, 0F, 0.9075712110370513F, 0F);
						return wingfin8;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer wingfin6 = new ModelRenderer(ModelNightFuryOld.this.model, 0, 0);
						wingfin6.addBox(-110F, 0F, 0F, 110, 2, 2);
						wingfin6.setRotationPoint(-47F, 2F, 1F);
						wingfin6.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						wingfin6.mirror = true;
						ModelNightFuryOld.this.setRotation(wingfin6, 0F, 0.6108652381980153F, 0F);
						return wingfin6;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer wingfin4 = new ModelRenderer(ModelNightFuryOld.this.model, 0, 0);
						wingfin4.addBox(-130F, 0F, 0F, 130, 2, 2);
						wingfin4.setRotationPoint(-47F, 2F, 0F);
						wingfin4.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						wingfin4.mirror = true;
						ModelNightFuryOld.this.setRotation(wingfin4, 0F, 0.3490658503988659F, 0F);
						return wingfin4;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer wingfin2 = new ModelRenderer(ModelNightFuryOld.this.model, 0, 0);
						wingfin2.addBox(-128F, 0F, 0F, 127, 2, 2);
						wingfin2.setRotationPoint(-46F, 2F, -1F);
						wingfin2.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						wingfin2.mirror = true;
						ModelNightFuryOld.this.setRotation(wingfin2, 0F, 0F, 0F);
						return wingfin2;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer rightwing1 = new ModelRenderer(ModelNightFuryOld.this.model, 0, 171);
						rightwing1.addBox(-50F, 0F, 0F, 50, 0, 50);
						rightwing1.setRotationPoint(2F, 3F, -1F);
						rightwing1.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						rightwing1.mirror = true;
						ModelNightFuryOld.this.setRotation(rightwing1, 0F, 0F, 0F);
						return rightwing1;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer rightwing2 = new ModelRenderer(ModelNightFuryOld.this.model, 0, 30);
						rightwing2.addBox(-125F, 0F, 0F, 125, 0, 80);
						rightwing2.setRotationPoint(-48F, 3F, -1F);
						rightwing2.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						rightwing2.mirror = true;
						ModelNightFuryOld.this.setRotation(rightwing2, 0F, 0F, 0F);
						return rightwing2;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer wingfin12 = new ModelRenderer(ModelNightFuryOld.this.model, 0, 0);
						wingfin12.addBox(0F, 0F, 0F, 70, 2, 2);
						wingfin12.setRotationPoint(-47F, 2F, 1F);
						wingfin12.setTextureSize(ModelNightFuryOld.this.textureWidth,
								ModelNightFuryOld.this.textureHeight);
						wingfin12.mirror = true;
						ModelNightFuryOld.this.setRotation(wingfin12, 0F, -1.9198621771937625F, 0F);
						return wingfin12;
					}
				}.get());

				return rightWing;
			}
		}.get();
	}
}
