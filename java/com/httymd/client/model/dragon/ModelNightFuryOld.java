package com.httymd.client.model.dragon;

import com.httymd.client.model.ModelDragon;

import net.minecraft.client.model.ModelRenderer;

public class ModelNightFuryOld extends ModelDragon {

	public ModelNightFuryOld() {
		textureWidth = 512;
		textureHeight = 256;

		head = new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer head = new ModelRenderer(model);
				head.setRotationPoint(0F, -12F, -22F);

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer head = new ModelRenderer(model, 0, 148);
						head.addBox(0F, 0F, 0F, 15, 8, 15);
						head.setRotationPoint(0F, -1F, -16F);
						head.setTextureSize(textureWidth, textureHeight);
						head.mirror = true;
						setRotation(head, 0.17453292519943295F, -0.7853981633974483F, -0.17453292519943295F);
						return head;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer mainfin1 = new ModelRenderer(model, 214, 239);
						mainfin1.addBox(-4F, 0F, 0F, 5, 3, 14);
						mainfin1.setRotationPoint(-6F, -3F, -5F);
						mainfin1.setTextureSize(textureWidth, textureHeight);
						mainfin1.mirror = true;
						setRotation(mainfin1, 0.3490658503988659F, -0.06981317007977318F, -0.08726646259971647F);
						return mainfin1;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer mainfin2 = new ModelRenderer(model, 214, 239);
						mainfin2.addBox(0F, 0F, 0F, 5, 3, 14);
						mainfin2.setRotationPoint(5F, -3F, -5F);
						mainfin2.setTextureSize(textureWidth, textureHeight);
						mainfin2.mirror = true;
						setRotation(mainfin2, 0.3490658503988659F, 0.06981317007977318F, 0.08726646259971647F);
						return mainfin2;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer secondfin1 = new ModelRenderer(model, 252, 249);
						secondfin1.addBox(-3F, 0F, 0F, 3, 2, 5);
						secondfin1.setRotationPoint(-1F, -5F, 1F);
						secondfin1.setTextureSize(textureWidth, textureHeight);
						secondfin1.mirror = true;
						setRotation(secondfin1, 0.24434609527920614F, -0.08726646259971647F, -0.08726646259971647F);
						return secondfin1;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer secondfin2 = new ModelRenderer(model, 252, 249);
						secondfin2.addBox(0F, 0F, 0F, 3, 2, 5);
						secondfin2.setRotationPoint(1F, -5F, 1F);
						secondfin2.setTextureSize(textureWidth, textureHeight);
						secondfin2.mirror = true;
						setRotation(secondfin2, 0.24434609527920614F, 0.10471975511965977F, 0.08726646259971647F);
						return secondfin2;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer thirdfin1 = new ModelRenderer(model, 268, 247);
						thirdfin1.addBox(-1F, 0F, 0F, 1, 3, 6);
						thirdfin1.setRotationPoint(-9F, -1F, -4F);
						thirdfin1.setTextureSize(textureWidth, textureHeight);
						thirdfin1.mirror = true;
						setRotation(thirdfin1, 0F, -0.3490658503988659F, 0F);
						return thirdfin1;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer thirdfin2 = new ModelRenderer(model, 268, 247);
						thirdfin2.addBox(0F, 0F, 0F, 1, 3, 6);
						thirdfin2.setRotationPoint(9F, -1F, -4F);
						thirdfin2.setTextureSize(textureWidth, textureHeight);
						thirdfin2.mirror = true;
						setRotation(thirdfin2, 0F, 0.3490658503988659F, 0F);
						return thirdfin2;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer fourthfin1 = new ModelRenderer(model, 282, 250);
						fourthfin1.addBox(-1F, 0F, 0F, 1, 2, 4);
						fourthfin1.setRotationPoint(-9F, 2F, -4F);
						fourthfin1.setTextureSize(textureWidth, textureHeight);
						fourthfin1.mirror = true;
						setRotation(fourthfin1, -0.03490658503988659F, -0.2617993877991494F, -0.13962634015954636F);
						return fourthfin1;
					}
				}.get());

				head.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer fourthfin2 = new ModelRenderer(model, 282, 250);
						fourthfin2.addBox(0F, 0F, 0F, 1, 2, 4);
						fourthfin2.setRotationPoint(9F, 2F, -4F);
						fourthfin2.setTextureSize(textureWidth, textureHeight);
						fourthfin2.mirror = true;
						setRotation(fourthfin2, -0.03490658503988659F, 0.2617993877991494F, 0.13962634015954636F);
						return fourthfin2;
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
						ModelRenderer tailwing2 = new ModelRenderer(model, 392, 221);
						tailwing2.addBox(-25F, 0F, 0F, 25, 0, 35);
						tailwing2.setRotationPoint(-4F, -4F, 25F);
						tailwing2.setTextureSize(textureWidth, textureHeight);
						tailwing2.mirror = true;
						setRotation(tailwing2, -0.12217304763960307F, 0F, 0F);
						return tailwing2;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tailwing1 = new ModelRenderer(model, 392, 221);
						tailwing1.addBox(-25F, 0F, 0F, 25, 0, 35);
						tailwing1.setRotationPoint(4F, -4F, 25F);
						tailwing1.setTextureSize(textureWidth, textureHeight);
						tailwing1.mirror = true;
						setRotation(tailwing1, 0.12217304763960307F, 0F, 3.141592653589793F);
						return tailwing1;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tailfin = new ModelRenderer(model, 0, 222);
						tailfin.addBox(-23F, 0F, 0F, 46, 0, 35);
						tailfin.setRotationPoint(0F, 16.5F, 115F);
						tailfin.setTextureSize(textureWidth, textureHeight);
						tailfin.mirror = true;
						setRotation(tailfin, 0F, 0F, 0F);
						return tailfin;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail6 = new ModelRenderer(model, 162, 230);
						tail6.addBox(0F, 0F, 0F, 2, 2, 24);
						tail6.setRotationPoint(-1F, 15F, 114F);
						tail6.setTextureSize(textureWidth, textureHeight);
						tail6.mirror = true;
						setRotation(tail6, 0F, 0F, 0F);
						return tail6;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail5 = new ModelRenderer(model, 200, 199);
						tail5.addBox(0F, 0F, 0F, 4, 4, 18);
						tail5.setRotationPoint(-2F, 11F, 98F);
						tail5.setTextureSize(textureWidth, textureHeight);
						tail5.mirror = true;
						setRotation(tail5, -0.17453292519943295F, 0F, 0F);
						return tail5;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail4 = new ModelRenderer(model, 200, 175);
						tail4.addBox(0F, 0F, 0F, 6, 6, 18);
						tail4.setRotationPoint(-3F, 6F, 82F);
						tail4.setTextureSize(textureWidth, textureHeight);
						tail4.mirror = true;
						setRotation(tail4, -0.2617993877991494F, 0F, 0F);
						return tail4;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail3 = new ModelRenderer(model, 199, 117);
						tail3.addBox(0F, 0F, 0F, 8, 8, 18);
						tail3.setRotationPoint(-4F, 1F, 66F);
						tail3.setTextureSize(textureWidth, textureHeight);
						tail3.mirror = true;
						setRotation(tail3, -0.2617993877991494F, 0F, 0F);
						return tail3;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail2 = new ModelRenderer(model, 196, 143);
						tail2.addBox(0F, 0F, 0F, 10, 10, 18);
						tail2.setRotationPoint(-5F, -3F, 49F);
						tail2.setTextureSize(textureWidth, textureHeight);
						tail2.mirror = true;
						setRotation(tail2, -0.17453292519943295F, 0F, 0F);
						return tail2;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer tail1 = new ModelRenderer(model, 136, 111);
						tail1.addBox(0F, 0F, 0F, 12, 12, 18);
						tail1.setRotationPoint(-6F, -5F, 32F);
						tail1.setTextureSize(textureWidth, textureHeight);
						tail1.mirror = true;
						setRotation(tail1, -0.08726646259971647F, 0F, 0F);
						return tail1;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer bodyback = new ModelRenderer(model, 128, 142);
						bodyback.addBox(0F, 0F, 0F, 18, 13, 16);
						bodyback.setRotationPoint(-9F, -6F, 17F);
						bodyback.setTextureSize(textureWidth, textureHeight);
						bodyback.mirror = true;
						setRotation(bodyback, 0F, 0F, 0F);
						return bodyback;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer bodymiddle = new ModelRenderer(model, 51, 111);
						bodymiddle.addBox(0F, 0F, 0F, 20, 14, 18);
						bodymiddle.setRotationPoint(-10F, -7F, 0F);
						bodymiddle.setTextureSize(textureWidth, textureHeight);
						bodymiddle.mirror = true;
						setRotation(bodymiddle, 0F, 0F, 0F);
						return bodymiddle;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer upperbody = new ModelRenderer(model, 60, 143);
						upperbody.addBox(0F, 0F, 0F, 18, 12, 16);
						upperbody.setRotationPoint(-9F, -8F, -14F);
						upperbody.setTextureSize(textureWidth, textureHeight);
						upperbody.mirror = true;
						setRotation(upperbody, -0.08726646259971647F, 0F, 0F);
						return upperbody;
					}
				}.get());

				body.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer neck = new ModelRenderer(model, 0, 124);
						neck.addBox(-6F, -10F, -7F, 14, 15, 9);
						neck.setRotationPoint(-1F, -8F, -15F);
						neck.setTextureSize(textureWidth, textureHeight);
						neck.mirror = true;
						setRotation(neck, 1.0471975511965976F, 0F, 0F);
						return neck;
					}
				}.get());

				return body;
			}
		}.get();
		legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg2 = new ModelRenderer(model);
				leg2.setRotationPoint(7F, -3F, 21F);

				leg2.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg2upper = new ModelRenderer(model, 418, 0);
						leg2upper.addBox(0F, 0F, 0F, 7, 14, 7);
						leg2upper.setRotationPoint(0F, 0F, 0F);
						leg2upper.setTextureSize(textureWidth, textureHeight);
						leg2upper.mirror = true;
						setRotation(leg2upper, -0.03490658503988659F, 0F, -0.03490658503988659F);
						return leg2upper;
					}
				}.get());

				leg2.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg2 = new ModelRenderer(model, 446, 0);
						leg2.addBox(-7F, 0F, -1F, 8, 14, 8);
						leg2.setRotationPoint(7F, 13F, 0F);
						leg2.setTextureSize(textureWidth, textureHeight);
						leg2.mirror = true;
						setRotation(leg2, 0F, 0F, 0F);
						return leg2;
					}
				}.get());

				return leg2;
			}
		}.get());
		legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg1 = new ModelRenderer(model);
				leg1.setRotationPoint(-5F, -3F, 21F);

				leg1.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg1upper = new ModelRenderer(model, 418, 0);
						leg1upper.addBox(-9F, 0F, 0F, 7, 14, 7);
						leg1upper.setRotationPoint(0F, 0F, 0F);
						leg1upper.setTextureSize(textureWidth, textureHeight);
						leg1upper.mirror = true;
						setRotation(leg1upper, -0.03490658503988659F, 0F, 0.03490658503988659F);
						return leg1upper;
					}
				}.get());

				leg1.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg1 = new ModelRenderer(model, 446, 0);
						leg1.addBox(-3F, 0F, -2F, 8, 14, 8);
						leg1.setRotationPoint(-7F, 13F, 1F);
						leg1.setTextureSize(textureWidth, textureHeight);
						leg1.mirror = true;
						setRotation(leg1, 0F, 0F, 0F);
						return leg1;
					}
				}.get());

				return leg1;
			}
		}.get());
		legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg3 = new ModelRenderer(model);
				leg3.setRotationPoint(-7F, -4F, -8F);

				leg3.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg3upper = new ModelRenderer(model, 390, 0);
						leg3upper.addBox(-7F, 0F, 0F, 7, 15, 7);
						leg3upper.setRotationPoint(0F, 0F, 0F);
						leg3upper.setTextureSize(textureWidth, textureHeight);
						leg3upper.mirror = true;
						setRotation(leg3upper, 0.08726646259971647F, 0F, 0.03490658503988659F);
						return leg3upper;
					}
				}.get());

				leg3.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg3 = new ModelRenderer(model, 478, 0);
						leg3.addBox(-8F, 0F, 0F, 8, 14, 9);
						leg3.setRotationPoint(0F, 14F, 0F);
						leg3.setTextureSize(textureWidth, textureHeight);
						leg3.mirror = true;
						setRotation(leg3, 0F, 0F, 0F);
						return leg3;
					}
				}.get());

				return leg3;
			}
		}.get());
		legs.add(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leg4 = new ModelRenderer(model);
				leg4.setRotationPoint(7F, -4F, -8F);

				leg4.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg4upper = new ModelRenderer(model, 390, 0);
						leg4upper.addBox(0F, 0F, 0F, 7, 15, 7);
						leg4upper.setRotationPoint(0F, 0F, 0F);
						leg4upper.setTextureSize(textureWidth, textureHeight);
						leg4upper.mirror = true;
						setRotation(leg4upper, 0.08726646259971647F, 0F, -0.03490658503988659F);
						return leg4upper;
					}
				}.get());

				leg4.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer leg4 = new ModelRenderer(model, 478, 0);
						leg4.addBox(-1F, 0F, -3F, 8, 14, 9);
						leg4.setRotationPoint(1F, 14F, 3F);
						leg4.setTextureSize(textureWidth, textureHeight);
						leg4.mirror = true;
						setRotation(leg4, 0F, 0F, 0F);
						return leg4;
					}
				}.get());

				return leg4;
			}
		}.get());
		wing = new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer rightWing = new ModelRenderer(model);
				rightWing.setRotationPoint(-9F, -9F, -12F);

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer rightbicep = new ModelRenderer(model, 292, 244);
						rightbicep.addBox(-22F, 0F, 0F, 22, 6, 6);
						rightbicep.setRotationPoint(0F, 0F, 0F);
						rightbicep.setTextureSize(textureWidth, textureHeight);
						rightbicep.mirror = true;
						setRotation(rightbicep, 0F, 0.2617993877991494F, 0F);
						return rightbicep;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer righttricep = new ModelRenderer(model, 292, 235);
						righttricep.addBox(-29F, 0F, -4F, 29, 4, 4);
						righttricep.setRotationPoint(-20F, 1F, 11F);
						righttricep.setTextureSize(textureWidth, textureHeight);
						righttricep.mirror = true;
						setRotation(righttricep, 0F, -0.2617993877991494F, 0F);
						return righttricep;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer wingfin11 = new ModelRenderer(model, 0, 0);
						wingfin11.addBox(0F, 0F, -2F, 55, 2, 2);
						wingfin11.setRotationPoint(-50F, 2F, 1F);
						wingfin11.setTextureSize(textureWidth, textureHeight);
						wingfin11.mirror = true;
						setRotation(wingfin11, 0F, -1.5707963267948966F, 0F);
						return wingfin11;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer wingfin8 = new ModelRenderer(model, 0, 0);
						wingfin8.addBox(-85F, 0F, 0F, 85, 2, 2);
						wingfin8.setRotationPoint(-47F, 2F, 1F);
						wingfin8.setTextureSize(textureWidth, textureHeight);
						wingfin8.mirror = true;
						setRotation(wingfin8, 0F, 0.9075712110370513F, 0F);
						return wingfin8;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer wingfin6 = new ModelRenderer(model, 0, 0);
						wingfin6.addBox(-110F, 0F, 0F, 110, 2, 2);
						wingfin6.setRotationPoint(-47F, 2F, 1F);
						wingfin6.setTextureSize(textureWidth, textureHeight);
						wingfin6.mirror = true;
						setRotation(wingfin6, 0F, 0.6108652381980153F, 0F);
						return wingfin6;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer wingfin4 = new ModelRenderer(model, 0, 0);
						wingfin4.addBox(-130F, 0F, 0F, 130, 2, 2);
						wingfin4.setRotationPoint(-47F, 2F, 0F);
						wingfin4.setTextureSize(textureWidth, textureHeight);
						wingfin4.mirror = true;
						setRotation(wingfin4, 0F, 0.3490658503988659F, 0F);
						return wingfin4;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer wingfin2 = new ModelRenderer(model, 0, 0);
						wingfin2.addBox(-128F, 0F, 0F, 127, 2, 2);
						wingfin2.setRotationPoint(-46F, 2F, -1F);
						wingfin2.setTextureSize(textureWidth, textureHeight);
						wingfin2.mirror = true;
						setRotation(wingfin2, 0F, 0F, 0F);
						return wingfin2;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer rightwing1 = new ModelRenderer(model, 0, 171);
						rightwing1.addBox(-50F, 0F, 0F, 50, 0, 50);
						rightwing1.setRotationPoint(2F, 3F, -1F);
						rightwing1.setTextureSize(textureWidth, textureHeight);
						rightwing1.mirror = true;
						setRotation(rightwing1, 0F, 0F, 0F);
						return rightwing1;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer rightwing2 = new ModelRenderer(model, 0, 30);
						rightwing2.addBox(-125F, 0F, 0F, 125, 0, 80);
						rightwing2.setRotationPoint(-48F, 3F, -1F);
						rightwing2.setTextureSize(textureWidth, textureHeight);
						rightwing2.mirror = true;
						setRotation(rightwing2, 0F, 0F, 0F);
						return rightwing2;
					}
				}.get());

				rightWing.addChild(new ModelRendererFactory() {
					@Override
					public ModelRenderer get() {
						ModelRenderer wingfin12 = new ModelRenderer(model, 0, 0);
						wingfin12.addBox(0F, 0F, 0F, 70, 2, 2);
						wingfin12.setRotationPoint(-47F, 2F, 1F);
						wingfin12.setTextureSize(textureWidth, textureHeight);
						wingfin12.mirror = true;
						setRotation(wingfin12, 0F, -1.9198621771937625F, 0F);
						return wingfin12;
					}
				}.get());

				return rightWing;
			}
		}.get();
	}
}
