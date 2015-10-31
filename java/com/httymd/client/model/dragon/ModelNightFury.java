package com.httymd.client.model.dragon;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.model.ModelRenderer;

import com.httymd.client.animation.Animation;
import com.httymd.client.model.ModelDragonNew;
import com.httymd.client.model.ModelDragonNew.WingRenderer;

public class ModelNightFury extends ModelDragonNew {

	public final ModelRenderer NightFury;
	public final ModelRenderer body;
	public final ModelRenderer upperbody;
	public final ModelRenderer bodymiddle;
	public final ModelRenderer bodyback;
	public final ModelRenderer tail;
	public final ModelRenderer tail0;
	public final ModelRenderer tailwing;
	public final ModelRenderer tPart1;
	public final ModelRenderer tail1;
	public final ModelRenderer tPart2;
	public final ModelRenderer tail2;
	public final ModelRenderer tPart3;
	public final ModelRenderer tail3;
	public final ModelRenderer tPart4;
	public final ModelRenderer tail4;
	public final ModelRenderer tPart5;
	public final ModelRenderer part5;
	public final ModelRenderer tailfin;
	public final ModelRenderer legs;
	public final ModelRenderer leg2;
	public final ModelRenderer leg2upper;
	public final ModelRenderer leg2lower;
	public final ModelRenderer leg1;
	public final ModelRenderer leg1upper;
	public final ModelRenderer leg1lower;
	public final ModelRenderer leg3;
	public final ModelRenderer leg3upper;
	public final ModelRenderer leg3lower;
	public final ModelRenderer leg4;
	public final ModelRenderer leg4upper;
	public final ModelRenderer leg4lower;
	public final ModelRenderer wing;
	public final ModelRenderer part0;
	public final ModelRenderer rightbicep;
	public final ModelRenderer rightwing0;
	public final ModelRenderer part1;
	public final ModelRenderer wingfin11;
	public final ModelRenderer righttricep;
	public final ModelRenderer rightwing1;
	public final ModelRenderer part2;
	public final ModelRenderer wingfin12;
	public final ModelRenderer rightwing2;
	public final ModelRenderer wingfin8;
	public final ModelRenderer wingfin6;
	public final ModelRenderer wingfin4a;
	public final ModelRenderer wingfin2L;
	public final ModelRenderer part3;
	public final ModelRenderer rightwing3;
	public final ModelRenderer wingfin13;
	public final ModelRenderer wingfin14;
	public final ModelRenderer wingfin15;
	public final ModelRenderer part4;
	public final ModelRenderer wingfin3L;
	public final ModelRenderer wingfin4b;
	public final ModelRenderer rightwing4;
	public final ModelRenderer neckFolder;
	public final ModelRenderer neck;
	public final ModelRenderer head;
	public final ModelRenderer mainfin1;
	public final ModelRenderer mainfin2;
	public final ModelRenderer secondfin1;
	public final ModelRenderer secondfin2;
	public final ModelRenderer thirdfin1;
	public final ModelRenderer thirdfin2;
	public final ModelRenderer fourthfin1;
	public final ModelRenderer fourthfin2;
	public final ModelRenderer headRotation;
	public final ModelRenderer mainhead;

	public final Animation flying;
	public final Animation idle;
	public final Animation angry;
	public final Animation idle2;

	public ModelNightFury() {
		textureWidth = 512;
		textureHeight = 512;

		NightFury = new ModelRenderer(model);
		NightFury.setRotationPoint(0.0F, 0.0F, 0.0F);
		{
			body = new ModelRenderer(model);
			body.setRotationPoint(0.0F, 0.5F, 24.5F);
			{
				upperbody = new ModelRenderer(model, 60, 143);
				upperbody.addBox(0.0F, 0.0F, 0.0F, 18, 12, 16);
				upperbody.setRotationPoint(-9.0F, -8.5F, -38.5F);
				upperbody.setTextureSize(textureWidth, textureHeight);
				upperbody.mirror = true;
				setRotation(upperbody, -0.08726646324990228F, 0.0F, 0.0F);
				body.addChild(upperbody);

				bodymiddle = new ModelRenderer(model, 51, 111);
				bodymiddle.addBox(0.0F, 0.0F, 0.0F, 20, 14, 18);
				bodymiddle.setRotationPoint(-10.0F, -7.5F, -24.5F);
				bodymiddle.setTextureSize(textureWidth, textureHeight);
				bodymiddle.mirror = true;
				setRotation(bodymiddle, 0.0F, 0.0F, 0.0F);
				body.addChild(bodymiddle);

				bodyback = new ModelRenderer(model, 128, 142);
				bodyback.addBox(0.0F, 0.0F, 0.0F, 18, 13, 16);
				bodyback.setRotationPoint(-9.0F, -6.5F, -7.5F);
				bodyback.setTextureSize(textureWidth, textureHeight);
				bodyback.mirror = true;
				setRotation(bodyback, 0.0F, 0.0F, 0.0F);
				body.addChild(bodyback);

				tail = new ModelRenderer(model);
				tail.setRotationPoint(0.0F, 0.5F, 7.5F);
				{
					tail0 = new ModelRenderer(model, 136, 111);
					tail0.addBox(-6.0F, -6.0F, 0.0F, 12, 12, 18);
					tail0.setRotationPoint(0.0F, 0.0F, 0.0F);
					tail0.setTextureSize(textureWidth, textureHeight);
					tail0.mirror = true;
					setRotation(tail0, 0.0F, 0.0F, 0.0F);
					tail.addChild(tail0);

					tailwing = new ModelRenderer(model, 352, 221);
					tailwing.addBox(-29.0F, 0.0F, 0.0F, 58, 0, 28);
					tailwing.setRotationPoint(0.0F, -4.0F, 1.0F);
					tailwing.setTextureSize(textureWidth, textureHeight);
					tailwing.mirror = true;
					setRotation(tailwing, -0.03490658588512815F, 0.0F, 0.0F);
					tail.addChild(tailwing);

					tPart1 = new ModelRenderer(model);
					tPart1.setRotationPoint(0.0F, 0.0F, 17.0F);
					{
						tail1 = new ModelRenderer(model, 196, 143);
						tail1.addBox(-5.0F, -5.0F, 0.0F, 10, 10, 18);
						tail1.setRotationPoint(0.0F, 0.0F, 0.0F);
						tail1.setTextureSize(textureWidth, textureHeight);
						tail1.mirror = true;
						setRotation(tail1, 0.0F, 0.0F, 0.0F);
						tPart1.addChild(tail1);

						tPart2 = new ModelRenderer(model);
						tPart2.setRotationPoint(0.0F, 0.0F, 17.0F);
						{
							tail2 = new ModelRenderer(model, 199, 117);
							tail2.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 18);
							tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
							tail2.setTextureSize(textureWidth, textureHeight);
							tail2.mirror = true;
							setRotation(tail2, 0.0F, 0.0F, 0.0F);
							tPart2.addChild(tail2);

							tPart3 = new ModelRenderer(model);
							tPart3.setRotationPoint(0.0F, 0.0F, 17.0F);
							{
								tail3 = new ModelRenderer(model, 200, 175);
								tail3.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 18);
								tail3.setRotationPoint(0.0F, 0.0F, 0.0F);
								tail3.setTextureSize(textureWidth, textureHeight);
								tail3.mirror = true;
								setRotation(tail3, 0.0F, 0.0F, 0.0F);
								tPart3.addChild(tail3);

								tPart4 = new ModelRenderer(model);
								tPart4.setRotationPoint(0.0F, 0.0F, 17.0F);
								{
									tail4 = new ModelRenderer(model, 200, 199);
									tail4.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 18);
									tail4.setRotationPoint(0.0F, 0.0F, 0.0F);
									tail4.setTextureSize(textureWidth, textureHeight);
									tail4.mirror = true;
									setRotation(tail4, 0.0F, 0.0F, 0.0F);
									tPart4.addChild(tail4);

									tPart5 = new ModelRenderer(model);
									tPart5.setRotationPoint(0.0F, 0.0F, 17.0F);
									{
										part5 = new ModelRenderer(model, 162, 230);
										part5.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 24);
										part5.setRotationPoint(0.0F, 0.0F, 0.0F);
										part5.setTextureSize(textureWidth, textureHeight);
										part5.mirror = true;
										setRotation(part5, 0.0F, 0.0F, 0.0F);
										tPart5.addChild(part5);

										tailfin = new ModelRenderer(model, 4, 223);
										tailfin.addBox(-21.0F, 0.0F, 0.0F, 42, 0, 33);
										tailfin.setRotationPoint(0.0F, 0.0F, 0.0F);
										tailfin.setTextureSize(textureWidth, textureHeight);
										tailfin.mirror = true;
										setRotation(tailfin, 0.0F, 0.0F, 0.0F);
										tPart5.addChild(tailfin);
									}
									tPart4.addChild(tPart5);
								}
								tPart3.addChild(tPart4);
							}
							tPart2.addChild(tPart3);
						}
						tPart1.addChild(tPart2);
					}
					tail.addChild(tPart1);
				}
				body.addChild(tail);

				legs = new ModelRenderer(model);
				legs.setRotationPoint(0.0F, -0.5F, -24.5F);
				{
					leg2 = new ModelRenderer(model);
					leg2.setRotationPoint(10.5F, 0.5F, 24.5F);
					{
						leg2upper = new ModelRenderer(model, 418, 0);
						leg2upper.addBox(-3.5F, -3.5F, -3.5F, 7, 14, 7);
						leg2upper.setRotationPoint(-0.0F, 0.0F, 0.0F);
						leg2upper.setTextureSize(textureWidth, textureHeight);
						leg2upper.mirror = true;
						setRotation(leg2upper, -0.0523598802906103F, 0.0F, -0.0523598802906103F);
						leg2.addChild(leg2upper);

						leg2lower = new ModelRenderer(model, 446, 0);
						leg2lower.addBox(-4.0F, 0.0F, -4.0F, 8, 14, 8);
						leg2lower.setRotationPoint(0.5F, 9.5F, -0.5F);
						leg2lower.setTextureSize(textureWidth, textureHeight);
						leg2lower.mirror = true;
						setRotation(leg2lower, 0.0F, 0.0F, 0.0F);
						leg2.addChild(leg2lower);
					}
					legs.addChild(leg2);

					leg1 = new ModelRenderer(model);
					leg1.setRotationPoint(-10.5F, 0.5F, 24.5F);
					{
						leg1upper = new ModelRenderer(model, 418, 0);
						leg1upper.addBox(-3.5F, -3.5F, -3.5F, 7, 14, 7);
						leg1upper.setRotationPoint(0.0F, 0.0F, 0.0F);
						leg1upper.setTextureSize(textureWidth, textureHeight);
						leg1upper.mirror = true;
						setRotation(leg1upper, -0.0523598802906103F, 0.0F, 0.0523598802906103F);
						leg1.addChild(leg1upper);

						leg1lower = new ModelRenderer(model, 446, 0);
						leg1lower.addBox(-4.0F, 0.0F, -4.0F, 8, 14, 8);
						leg1lower.setRotationPoint(-0.5F, 9.5F, -0.5F);
						leg1lower.setTextureSize(textureWidth, textureHeight);
						leg1lower.mirror = true;
						setRotation(leg1lower, 0.0F, 0.0F, 0.0F);
						leg1.addChild(leg1lower);
					}
					legs.addChild(leg1);

					leg3 = new ModelRenderer(model);
					leg3.setRotationPoint(-10.5F, -0.5F, -4.5F);
					{
						leg3upper = new ModelRenderer(model, 390, 0);
						leg3upper.addBox(-3.5F, -3.5F, -3.5F, 7, 15, 7);
						leg3upper.setRotationPoint(0.0F, 0.0F, 0.0F);
						leg3upper.setTextureSize(textureWidth, textureHeight);
						leg3upper.mirror = true;
						setRotation(leg3upper, 0.08726646324990228F, 0.0F, 0.0523598802906103F);
						leg3.addChild(leg3upper);

						leg3lower = new ModelRenderer(model, 478, 0);
						leg3lower.addBox(-4.0F, 0.0F, -5.0F, 8, 14, 9);
						leg3lower.setRotationPoint(-0.5F, 10.5F, 1.0F);
						leg3lower.setTextureSize(textureWidth, textureHeight);
						leg3lower.mirror = true;
						setRotation(leg3lower, 0.0F, 0.0F, 0.0F);
						leg3.addChild(leg3lower);
					}
					legs.addChild(leg3);

					leg4 = new ModelRenderer(model);
					leg4.setRotationPoint(10.5F, -0.5F, -4.5F);
					{
						leg4upper = new ModelRenderer(model, 390, 0);
						leg4upper.addBox(-3.5F, -3.5F, -3.5F, 7, 15, 7);
						leg4upper.setRotationPoint(0.0F, 0.0F, 0.0F);
						leg4upper.setTextureSize(textureWidth, textureHeight);
						leg4upper.mirror = true;
						setRotation(leg4upper, 0.08726646324990228F, 0.0F, -0.0523598802906103F);
						leg4.addChild(leg4upper);

						leg4lower = new ModelRenderer(model, 478, 0);
						leg4lower.addBox(-4.0F, 0.0F, -5.0F, 8, 14, 9);
						leg4lower.setRotationPoint(0.5F, 10.5F, 1.0F);
						leg4lower.setTextureSize(textureWidth, textureHeight);
						leg4lower.mirror = true;
						setRotation(leg4lower, 0.0F, 0.0F, 0.0F);
						leg4.addChild(leg4lower);
					}
					legs.addChild(leg4);
				}
				body.addChild(legs);

				wing = new WingRenderer(model);
				wing.setRotationPoint(0.0F, -0.5F, -24.5F);
				{
					part0 = new ModelRenderer(model);
					part0.setRotationPoint(-7.0F, -6.0F, -13.0F);
					{
						rightbicep = new ModelRenderer(model, 292, 244);
						rightbicep.addBox(-22.0F, 0.0F, 0.0F, 22, 6, 6);
						rightbicep.setRotationPoint(-2.0F, -3.0F, 1.0F);
						rightbicep.setTextureSize(textureWidth, textureHeight);
						rightbicep.mirror = true;
						setRotation(rightbicep, 0.0F, 0.26179939560137916F, 0.0F);
						part0.addChild(rightbicep);

						rightwing0 = new ModelRenderer(model, -50, 256);
						rightwing0.addBox(0.0F, 0.0F, -50.0F, 22, 0, 50);
						rightwing0.setRotationPoint(0.0F, 0.0F, 0.0F);
						rightwing0.setTextureSize(textureWidth, textureHeight);
						rightwing0.mirror = true;
						setRotation(rightwing0, 0.0F, 3.141592653589793F, 0.0F);
						part0.addChild(rightwing0);

						part1 = new ModelRenderer(model);
						part1.setRotationPoint(-22.0F, 0.0F, 0.0F);
						{
							wingfin11 = new ModelRenderer(model, 0, 0);
							wingfin11.addBox(0.0F, 0.0F, -2.0F, 55, 2, 2);
							wingfin11.setRotationPoint(-30.0F, -1.0F, 2.0F);
							wingfin11.setTextureSize(textureWidth, textureHeight);
							wingfin11.mirror = true;
							setRotation(wingfin11, 0.0F, -1.5707963267948966F, 0.0F);
							part1.addChild(wingfin11);

							righttricep = new ModelRenderer(model, 292, 235);
							righttricep.addBox(-29.0F, 0.0F, -4.0F, 29, 4, 4);
							righttricep.setRotationPoint(0.0F, -2.0F, 12.0F);
							righttricep.setTextureSize(textureWidth, textureHeight);
							righttricep.mirror = true;
							setRotation(righttricep, 0.0F, -0.26179939560137916F, 0.0F);
							part1.addChild(righttricep);

							rightwing1 = new ModelRenderer(model, -6, 256);
							rightwing1.addBox(0.0F, 0.0F, -50.0F, 28, 0, 50);
							rightwing1.setRotationPoint(0.0F, 0.0F, 0.0F);
							rightwing1.setTextureSize(textureWidth, textureHeight);
							rightwing1.mirror = true;
							setRotation(rightwing1, 0.0F, 3.141592653589793F, 0.0F);
							part1.addChild(rightwing1);

							part2 = new ModelRenderer(model);
							part2.setRotationPoint(-29.0F, 0.0F, 0.0F);
							{
								wingfin12 = new ModelRenderer(model, 0, 0);
								wingfin12.addBox(0.0F, 0.0F, 0.0F, 70, 2, 2);
								wingfin12.setRotationPoint(2.0F, -1.0F, 2.0F);
								wingfin12.setTextureSize(textureWidth, textureHeight);
								wingfin12.mirror = true;
								setRotation(wingfin12, 0.0F, -1.9198621563878164F, 0.0F);
								part2.addChild(wingfin12);

								rightwing2 = new ModelRenderer(model, 20, 256);
								rightwing2.addBox(0.0F, 0.0F, -80.0F, 47, 0, 80);
								rightwing2.setRotationPoint(-1.0F, 0.0F, 0.0F);
								rightwing2.setTextureSize(textureWidth, textureHeight);
								rightwing2.mirror = true;
								setRotation(rightwing2, 0.0F, 3.141592653589793F, 0.0F);
								part2.addChild(rightwing2);

								wingfin8 = new ModelRenderer(model, 0, 0);
								wingfin8.addBox(-85.0F, 0.0F, 0.0F, 85, 2, 2);
								wingfin8.setRotationPoint(2.0F, -1.0F, 2.0F);
								wingfin8.setTextureSize(textureWidth, textureHeight);
								wingfin8.mirror = true;
								setRotation(wingfin8, 0.0F, 0.9075712505683488F, 0.0F);
								part2.addChild(wingfin8);

								wingfin6 = new ModelRenderer(model, 0, 0);
								wingfin6.addBox(-63.0F, 0.0F, 0.0F, 63, 2, 2);
								wingfin6.setRotationPoint(2.0F, -1.0F, 2.0F);
								wingfin6.setTextureSize(textureWidth, textureHeight);
								wingfin6.mirror = true;
								setRotation(wingfin6, 0.0F, 0.6108652486009883F, 0.0F);
								part2.addChild(wingfin6);

								wingfin4a = new ModelRenderer(model, 0, 0);
								wingfin4a.addBox(-54.0F, 0.0F, 0.0F, 54, 2, 2);
								wingfin4a.setRotationPoint(2.0F, -1.0F, 1.0F);
								wingfin4a.setTextureSize(textureWidth, textureHeight);
								wingfin4a.mirror = true;
								setRotation(wingfin4a, 0.0F, 0.3490658529996091F, 0.0F);
								part2.addChild(wingfin4a);

								wingfin2L = new ModelRenderer(model, 0, 0);
								wingfin2L.addBox(-50.0F, 0.0F, 0.0F, 50, 2, 2);
								wingfin2L.setRotationPoint(2.0F, -1.0F, 0.0F);
								wingfin2L.setTextureSize(textureWidth, textureHeight);
								wingfin2L.mirror = true;
								setRotation(wingfin2L, 0.0F, 0.0F, 0.0F);
								part2.addChild(wingfin2L);

								part3 = new ModelRenderer(model);
								part3.setRotationPoint(-48.0F, 0.0F, 0.0F);
								{
									rightwing3 = new ModelRenderer(model, 114, 256);
									rightwing3.addBox(0.0F, 0.0F, -80.0F, 38, 0, 80);
									rightwing3.setRotationPoint(0.0F, 0.0F, 0.0F);
									rightwing3.setTextureSize(textureWidth, textureHeight);
									rightwing3.mirror = true;
									setRotation(rightwing3, 0.0F, 3.141592653589793F, 0.0F);
									part3.addChild(rightwing3);

									wingfin13 = new ModelRenderer(model, 0, 0);
									wingfin13.addBox(-49.0F, 0.0F, 0.0F, 49, 2, 2);
									wingfin13.setRotationPoint(0.0F, -1.0F, 37.0F);
									wingfin13.setTextureSize(textureWidth, textureHeight);
									wingfin13.mirror = true;
									setRotation(wingfin13, 0.0F, 0.6108652486009883F, 0.0F);
									part3.addChild(wingfin13);

									wingfin14 = new ModelRenderer(model, 0, 0);
									wingfin14.addBox(-41.0F, 0.0F, 0.0F, 41, 2, 2);
									wingfin14.setRotationPoint(0.0F, -1.0F, 19.0F);
									wingfin14.setTextureSize(textureWidth, textureHeight);
									wingfin14.mirror = true;
									setRotation(wingfin14, 0.0F, 0.3490658529996091F, 0.0F);
									part3.addChild(wingfin14);

									wingfin15 = new ModelRenderer(model, 0, 0);
									wingfin15.addBox(-38.0F, 0.0F, 0.0F, 38, 2, 2);
									wingfin15.setRotationPoint(0.0F, -1.0F, 0.0F);
									wingfin15.setTextureSize(textureWidth, textureHeight);
									wingfin15.mirror = true;
									setRotation(wingfin15, 0.0F, 0.0F, 0.0F);
									part3.addChild(wingfin15);

									part4 = new ModelRenderer(model);
									part4.setRotationPoint(-38.0F, 0.0F, 0.0F);
									{
										wingfin3L = new ModelRenderer(model, 0, 0);
										wingfin3L.addBox(-38.0F, -1.0F, 0.0F, 38, 2, 2);
										wingfin3L.setRotationPoint(0.0F, 0.0F, 0.0F);
										wingfin3L.setTextureSize(textureWidth, textureHeight);
										wingfin3L.mirror = true;
										setRotation(wingfin3L, 0.0F, 0.0F, 0.0F);
										part4.addChild(wingfin3L);

										wingfin4b = new ModelRenderer(model, 0, 0);
										wingfin4b.addBox(-37.0F, 0.0F, 0.0F, 37, 2, 2);
										wingfin4b.setRotationPoint(0.0F, -1.0F, 33.0F);
										wingfin4b.setTextureSize(textureWidth, textureHeight);
										wingfin4b.mirror = true;
										setRotation(wingfin4b, 0.0F, 0.3490658529996091F, 0.0F);
										part4.addChild(wingfin4b);

										rightwing4 = new ModelRenderer(model, 190, 256);
										rightwing4.addBox(0.0F, 0.0F, -80.0F, 38, 0, 80);
										rightwing4.setRotationPoint(0.0F, 0.0F, 0.0F);
										rightwing4.setTextureSize(textureWidth, textureHeight);
										rightwing4.mirror = true;
										setRotation(rightwing4, 0.0F, 3.141592653589793F, 0.0F);
										part4.addChild(rightwing4);
									}
									part3.addChild(part4);
								}
								part2.addChild(part3);
							}
							part1.addChild(part2);
						}
						part0.addChild(part1);
					}
					wing.addChild(part0);
				}
				body.addChild(wing);

				neckFolder = new ModelRenderer(model);
				neckFolder.setRotationPoint(0.0F, 0.0F, 0.0F);
				{
					neck = new ModelRenderer(model, 0, 124);
					neck.addBox(-6.0F, -10.0F, -7.0F, 14, 15, 9);
					neck.setRotationPoint(-1.0F, -8.5F, -39.5F);
					neck.setTextureSize(textureWidth, textureHeight);
					neck.mirror = true;
					setRotation(neck, 1.0471975824055166F, 0.0F, 0.0F);
					neckFolder.addChild(neck);

					head = new ModelRenderer(model);
					head.setRotationPoint(0.0F, -12.5F, -46.5F);
					{
						mainfin1 = new ModelRenderer(model, 214, 239);
						mainfin1.addBox(-4.0F, 0.0F, 0.0F, 5, 3, 14);
						mainfin1.setRotationPoint(-6.0F, -3.0F, -5.0F);
						mainfin1.setTextureSize(textureWidth, textureHeight);
						mainfin1.mirror = true;
						setRotation(mainfin1, 0.3490658529996091F, -0.0698131717702563F, -0.08726646324990228F);
						head.addChild(mainfin1);

						mainfin2 = new ModelRenderer(model, 214, 239);
						mainfin2.addBox(0.0F, 0.0F, 0.0F, 5, 3, 14);
						mainfin2.setRotationPoint(5.0F, -3.0F, -5.0F);
						mainfin2.setTextureSize(textureWidth, textureHeight);
						mainfin2.mirror = true;
						setRotation(mainfin2, 0.3490658529996091F, 0.0698131717702563F, 0.08726646324990228F);
						head.addChild(mainfin2);

						secondfin1 = new ModelRenderer(model, 252, 249);
						secondfin1.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 5);
						secondfin1.setRotationPoint(-1.0F, -5.0F, 1.0F);
						secondfin1.setTextureSize(textureWidth, textureHeight);
						secondfin1.mirror = true;
						setRotation(secondfin1, 0.2443461041217332F, -0.08726646324990228F, -0.08726646324990228F);
						head.addChild(secondfin1);

						secondfin2 = new ModelRenderer(model, 252, 249);
						secondfin2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 5);
						secondfin2.setRotationPoint(1.0F, -5.0F, 1.0F);
						secondfin2.setTextureSize(textureWidth, textureHeight);
						secondfin2.mirror = true;
						setRotation(secondfin2, 0.2443461041217332F, 0.1047197605812206F, 0.08726646324990228F);
						head.addChild(secondfin2);

						thirdfin1 = new ModelRenderer(model, 268, 247);
						thirdfin1.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 6);
						thirdfin1.setRotationPoint(-9.0F, -1.0F, -4.0F);
						thirdfin1.setTextureSize(textureWidth, textureHeight);
						thirdfin1.mirror = true;
						setRotation(thirdfin1, 0.0F, -0.3490658529996091F, 0.0F);
						head.addChild(thirdfin1);

						thirdfin2 = new ModelRenderer(model, 268, 247);
						thirdfin2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 6);
						thirdfin2.setRotationPoint(9.0F, -1.0F, -4.0F);
						thirdfin2.setTextureSize(textureWidth, textureHeight);
						thirdfin2.mirror = true;
						setRotation(thirdfin2, 0.0F, 0.3490658529996091F, 0.0F);
						head.addChild(thirdfin2);

						fourthfin1 = new ModelRenderer(model, 282, 250);
						fourthfin1.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 4);
						fourthfin1.setRotationPoint(-9.0F, 2.0F, -4.0F);
						fourthfin1.setTextureSize(textureWidth, textureHeight);
						fourthfin1.mirror = true;
						setRotation(fourthfin1, -0.03490658588512815F, -0.26179939560137916F, -0.1396263435405126F);
						head.addChild(fourthfin1);

						fourthfin2 = new ModelRenderer(model, 282, 250);
						fourthfin2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 4);
						fourthfin2.setRotationPoint(9.0F, 2.0F, -4.0F);
						fourthfin2.setTextureSize(textureWidth, textureHeight);
						fourthfin2.mirror = true;
						setRotation(fourthfin2, -0.03490658588512815F, 0.26179939560137916F, 0.1396263435405126F);
						head.addChild(fourthfin2);

						headRotation = new ModelRenderer(model);
						headRotation.setRotationPoint(0.0F, 0.0F, 0.0F);
						{
							mainhead = new ModelRenderer(model, 0, 148);
							mainhead.addBox(0.0F, 0.0F, 0.0F, 15, 8, 15);
							mainhead.setRotationPoint(0.0F, -3.5F, -16.0F);
							mainhead.setTextureSize(textureWidth, textureHeight);
							mainhead.mirror = true;
							setRotation(mainhead, 0.0F, -0.7853981633974483F, 0.0F);
							headRotation.addChild(mainhead);
						}
						head.addChild(headRotation);
					}
					neckFolder.addChild(head);
				}
				body.addChild(neckFolder);
			}
			NightFury.addChild(body);
		}
		{
			ModelRenderer[] components = { part0, part2, part1, part3, part4, leg4, leg4lower, leg2, leg2lower, leg1, leg1lower, leg3, leg3lower, };
			int duration = 1000;

			float[][][] data = {
					{ { -7.0f, -7.0f, -7.0f, -7.0f, -7.0f, -7.0f, -7.0f, -7.0f, -7.0f, }, { -6.0f, -6.0f, -6.0f, -6.0f, -6.0f, -6.0f, -6.0f, -6.0f, -6.0f, }, { -13.0f, -13.0f, -13.0f, -13.0f, -13.0f, -13.0f, -13.0f, -13.0f, -13.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 20.0f, -10.0f, -40.0f, -50.0f, -40.0f, 0.0f, 40.0f, 50.0f, 40.0f, }, },
					{ { -29.0f, -29.0f, -29.0f, -29.0f, -29.0f, -29.0f, -29.0f, -29.0f, -29.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 10.0f, 15.0f, 10.0f, 10.0f, -80.0f, -100.0f, -90.0f, -60.0f, -30.0f, }, },
					{ { -22.0f, -22.0f, -22.0f, -22.0f, -22.0f, -22.0f, -22.0f, -22.0f, -22.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 10.0f, 15.0f, 10.0f, -10.0f, 60.0f, 60.0f, 40.0f, 30.0f, 15.0f, }, },
					{ { -48.0f, -48.0f, -48.0f, -48.0f, -48.0f, -48.0f, -48.0f, -48.0f, -48.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 10.0f, 15.0f, 30.0f, 10.0f, -10.0f, -15.0f, -20.0f, -20.0f, -10.0f, }, },
					{ { -38.0f, -38.0f, -38.0f, -38.0f, -38.0f, -38.0f, -38.0f, -38.0f, -38.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 10.0f, 15.0f, 30.0f, 10.0f, -10.0f, -15.0f, -20.0f, -20.0f, -10.0f, }, },
					{ { 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, }, { -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, }, { -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, }, { -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, }, { 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, }, { 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, }, { 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, }, { 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, }, { 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, }, { -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, }, { 9.5f, 9.5f, 9.5f, 9.5f, 9.5f, 9.5f, 9.5f, 9.5f, 9.5f, }, { -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, }, { 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, }, { 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, }, { 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, }, { -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, }, { 9.5f, 9.5f, 9.5f, 9.5f, 9.5f, 9.5f, 9.5f, 9.5f, 9.5f, }, { -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, }, { 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, }, { -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, }, { -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, }, { -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, -60.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, }, { 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, }, { 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, }, { 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, 120.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, },
							{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, }, };

			flying = new Animation(components, data, duration);
		}
		{
			ModelRenderer[] components = { part0, part1, part2, part3, part4, };
			int duration = 10;

			float[][][] data = { { { -7.0f, }, { -6.0f, }, { -13.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, }, { { -22.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, }, { { -29.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, }, { { -48.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, }, { { -38.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, { 0.0f, }, }, };

			idle = new Animation(components, data, duration);
		}
		{
			ModelRenderer[] components = { body, leg2, leg1, leg4, leg4lower, leg3, leg3lower, };
			int duration = 1500;

			float[][][] data = { { { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, }, { 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, }, { 0.0f, 5.0f, -25.0f, -50.0f, -50.0f, 5.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, }, { 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, }, { 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, }, { 0.0f, -5.0f, 25.0f, 50.0f, 50.0f, -5.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, }, { 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, }, { 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, 24.5f, }, { 0.0f, -5.0f, 25.0f, 50.0f, 50.0f, -5.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, }, { -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, }, { -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, }, { 0.0f, 15.0f, 15.0f, 15.0f, 0.0f, 15.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, }, { 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, }, { 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, }, { 0.0f, -35.0f, -35.0f, -35.0f, 0.0f, -35.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, -10.5f, }, { -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, }, { -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, -4.5f, }, { 0.0f, 15.0f, 15.0f, 15.0f, 0.0f, 15.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, }, { 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, 10.5f, }, { 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, }, { 0.0f, -35.0f, -35.0f, -35.0f, 0.0f, -35.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, }, }, };

			angry = new Animation(components, data, duration);
		}
		{
			ModelRenderer[] components = { body, leg2, leg1, legs, upperbody, bodymiddle, bodyback, tail, neck, head, wing, tPart1, tPart2, tPart3, tPart4, tPart5, neckFolder, part1, part0, part2, part3, part4, leg3, leg3lower, leg4, leg4lower, leg2lower, leg1lower, };
			int duration = 2000;

			float[][][] data = { { { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.5f, 0.5f, 0.5f, 0.5f, }, { 24.5f, 24.5f, 24.5f, 24.5f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 10.5f, 10.5f, 10.5f, 10.5f, }, { 0.5f, 0.5f, 0.5f, 0.5f, }, { 24.5f, 24.5f, 24.5f, 24.5f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, }, { { -10.5f, -10.5f, -10.5f, -10.5f, }, { 0.5f, 0.5f, 0.5f, 0.5f, }, { 24.5f, 24.5f, 24.5f, 24.5f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 0.0f, 0.0f, 0.0f, 0.0f, }, { -0.5f, -0.5f, -0.5f, -0.5f, }, { -24.5f, -24.5f, -24.5f, -24.5f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -9.0f, -9.0f, -9.0f, -9.0f, }, { -8.5f, -9.0f, -8.5f, -8.0f, }, { -38.5f, -38.5f, -38.5f, -38.5f, }, { -5.0f, -5.0f, -5.0f, -5.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -10.0f, -10.0f, -10.0f, -10.0f, }, { -7.0f, -7.5f, -8.0f, -7.5f, }, { -24.5f, -24.5f, -24.5f, -24.5f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -9.0f, -9.0f, -9.0f, -9.0f, }, { -6.5f, -6.0f, -6.5f, -7.0f, }, { -7.5f, -7.5f, -7.5f, -7.5f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, }, { { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.5f, 1.0f, 0.5f, }, { 7.5f, 7.5f, 7.5f, 7.5f, }, { -5.0f, -4.0f, -5.0f, -6.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -1.0f, -1.0f, -1.0f, -1.0f, }, { -8.5f, -9.0f, -8.5f, -8.0f, }, { -39.5f, -39.5f, -39.5f, -39.5f, }, { 60.0f, 60.0f, 60.0f, 60.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 0.0f, 0.0f, 0.0f, 0.0f, }, { -12.5f, -13.0f, -12.5f, -12.0f, }, { -46.5f, -46.5f, -46.5f, -46.5f, }, { 0.0f, 1.0f, 0.0f, -1.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 0.0f, 0.0f, 0.0f, 0.0f, }, { -0.5f, -1.0f, -0.5f, 0.0f, }, { -24.5f, -24.5f, -24.5f, -24.5f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, }, { { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 17.0f, 17.0f, 17.0f, 17.0f, }, { -6.0f, -5.0f, -4.0f, -5.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 17.0f, 17.0f, 17.0f, 17.0f, }, { -5.0f, -6.0f, -5.0f, -4.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, }, { { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 17.0f, 17.0f, 17.0f, 17.0f, }, { 0.0f, -1.0f, 0.0f, 1.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 17.0f, 17.0f, 17.0f, 17.0f, }, { 5.0f, 4.0f, 5.0f, 6.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, }, { { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 17.0f, 17.0f, 17.0f, 17.0f, }, { 10.0f, 9.0f, 10.0f, 11.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 0.0f, 0.0f, 0.0f, 0.0f, }, { -0.5f, 0.0f, 0.5f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, }, { { -22.0f, -22.0f, -22.0f, -22.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -7.0f, -7.0f, -7.0f, -7.0f, }, { -6.0f, -6.0f, -6.0f, -6.0f, }, { -13.0f, -13.0f, -13.0f, -13.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -29.0f, -29.0f, -29.0f, -29.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, }, { { -48.0f, -48.0f, -48.0f, -48.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { -1.0f, 0.0f, 1.0f, 0.0f, }, },
					{ { -38.0f, -38.0f, -38.0f, -38.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { -1.0f, 0.0f, 1.0f, 0.0f, }, },
					{ { -10.5f, -10.5f, -10.5f, -10.5f, }, { -0.5f, -0.5f, -0.5f, -0.5f, }, { -4.5f, -4.5f, -4.5f, -4.5f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -0.5f, -0.5f, -0.5f, -0.5f, }, { 10.5f, 10.5f, 10.5f, 10.5f, }, { 1.0f, 1.0f, 1.0f, 1.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, }, { { 10.5f, 10.5f, 10.5f, 10.5f, }, { -0.5f, -0.5f, -0.5f, -0.5f, }, { -4.5f, -4.5f, -4.5f, -4.5f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { 0.5f, 0.5f, 0.5f, 0.5f, }, { 10.5f, 10.5f, 10.5f, 10.5f, }, { 1.0f, 1.0f, 1.0f, 1.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, }, { { 0.5f, 0.5f, 0.5f, 0.5f, }, { 9.5f, 9.5f, 9.5f, 9.5f, }, { -0.5f, -0.5f, -0.5f, -0.5f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, },
					{ { -0.5f, -0.5f, -0.5f, -0.5f, }, { 9.5f, 9.5f, 9.5f, 9.5f, }, { -0.5f, -0.5f, -0.5f, -0.5f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, { 0.0f, 0.0f, 0.0f, 0.0f, }, }, };

			idle2 = new Animation(components, data, duration);
		}
	}

	@Override
	public ModelRenderer getRoot() {
		return NightFury;
	}

	@Override
	public ModelRenderer getHead() {
		return head;
	}

	@Override
	public List<ModelRenderer> getLegs() {
		List<ModelRenderer> legs = new ArrayList<ModelRenderer>();
		legs.add(leg2);
		legs.add(leg1);
		legs.add(leg3);
		legs.add(leg4);
		return legs;
	}

	@Override
	public ModelRenderer getWing() {
		return wing;
	}

	@Override
	public Animation getIdle() {
		return idle2;
	}

	@Override
	public Animation getFlying() {
		return flying;
	}
}
