package com.httymd.client.model.dragon;

import com.httymd.client.model.ModelDragon;

import net.minecraft.client.model.ModelRenderer;

public class ModelSkrill extends ModelDragon {
	public ModelSkrill() {
		textureWidth = 512;
		textureHeight = 256;

		/*
		 * LEGS
		 */

		// Left Leg

		ModelRenderer LeftLeg1 = new ModelRenderer(this, 0, 136);
		LeftLeg1.addBox(0F, 0F, -4F, 7, 15, 8);
		LeftLeg1.setRotationPoint(0, 0, 0);
		LeftLeg1.setTextureSize(512, 256);
		LeftLeg1.mirror = true;
		setRotation(LeftLeg1, -0.3141593F, 0F, -0.1745329F);

		ModelRenderer LeftLeg2 = new ModelRenderer(this, 0, 110);
		LeftLeg2.addBox(-4F, 0F, 0F, 8, 17, 9);
		LeftLeg2.setRotationPoint(6F, 11F, -9F);
		LeftLeg2.setTextureSize(512, 256);
		LeftLeg2.mirror = true;
		setRotation(LeftLeg2, 0F, 0F, 0F);

		ModelRenderer LeftClaw1 = new ModelRenderer(this, 300, 0);
		LeftClaw1.addBox(-1F, -2F, -8F, 2, 2, 8);
		LeftClaw1.setRotationPoint(9F, 28F, -9F);
		LeftClaw1.setTextureSize(512, 256);
		LeftClaw1.mirror = true;
		setRotation(LeftClaw1, 0F, -0.2617994F, 0F);

		ModelRenderer LeftClaw2 = new ModelRenderer(this, 300, 22);
		LeftClaw2.addBox(-1F, -2F, -5F, 2, 2, 5);
		LeftClaw2.setRotationPoint(6F, 28F, -9F);
		LeftClaw2.setTextureSize(512, 256);
		LeftClaw2.mirror = true;
		setRotation(LeftClaw2, -0.2617994F, 0F, 0F);

		ModelRenderer LeftClaw3 = new ModelRenderer(this, 300, 0);
		LeftClaw3.addBox(-1F, -2F, -8F, 2, 2, 8);
		LeftClaw3.setRotationPoint(3F, 28F, -9F);
		LeftClaw3.setTextureSize(512, 256);
		LeftClaw3.mirror = true;
		setRotation(LeftClaw3, 0F, 0.2617994F, 0F);
		LeftClaw3.mirror = false;

		ModelRenderer LeftClaw4 = new ModelRenderer(this, 320, 0);
		LeftClaw4.addBox(-1F, 0F, -5F, 2, 2, 5);
		LeftClaw4.setRotationPoint(6F, 24.8F, -13.3F);
		LeftClaw4.setTextureSize(512, 256);
		LeftClaw4.mirror = true;
		setRotation(LeftClaw4, 0.2617994F, 0F, 0F);

		ModelRenderer leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(8F, -4F, 41F);
		leftLeg.addChild(LeftLeg1);
		leftLeg.addChild(LeftLeg2);
		leftLeg.addChild(LeftClaw1);
		leftLeg.addChild(LeftClaw2);
		leftLeg.addChild(LeftClaw3);
		leftLeg.addChild(LeftClaw4);
		legs.add(leftLeg);

		// Right Leg
		ModelRenderer RightLeg1 = new ModelRenderer(this, 0, 136);
		RightLeg1.addBox(-7F, 0F, -4F, 7, 16, 8);
		RightLeg1.setRotationPoint(0, 0, 0);
		RightLeg1.setTextureSize(512, 256);
		RightLeg1.mirror = true;
		setRotation(RightLeg1, -0.3141593F, 0F, 0.1745329F);
		RightLeg1.mirror = false;

		ModelRenderer RightLeg2 = new ModelRenderer(this, 0, 110);
		RightLeg2.addBox(-4F, 0F, 0F, 8, 17, 9);
		RightLeg2.setRotationPoint(-6F, 11F, -9F);
		RightLeg2.setTextureSize(512, 256);
		RightLeg2.mirror = true;
		setRotation(RightLeg2, 0F, 0F, 0F);
		RightLeg2.mirror = false;

		ModelRenderer RightClaw1 = new ModelRenderer(this, 300, 11);
		RightClaw1.addBox(-1F, -2F, -7F, 2, 2, 8);
		RightClaw1.setRotationPoint(-9F, 28F, -9F);
		RightClaw1.setTextureSize(512, 256);
		RightClaw1.mirror = true;
		setRotation(RightClaw1, 0F, 0.2617994F, 0F);

		ModelRenderer RightClaw2 = new ModelRenderer(this, 300, 22);
		RightClaw2.addBox(-1F, -2F, -5F, 2, 2, 5);
		RightClaw2.setRotationPoint(-6F, 28F, -9F);
		RightClaw2.setTextureSize(512, 256);
		RightClaw2.mirror = true;
		setRotation(RightClaw2, -0.2617994F, 0F, 0F);

		ModelRenderer RightClaw3 = new ModelRenderer(this, 300, 11);
		RightClaw3.addBox(-1F, -2F, -8F, 2, 2, 8);
		RightClaw3.setRotationPoint(-3F, 28F, -9F);
		RightClaw3.setTextureSize(512, 256);
		RightClaw3.mirror = true;
		setRotation(RightClaw3, 0F, -0.2617994F, 0F);
		RightClaw3.mirror = false;

		ModelRenderer RightClaw4 = new ModelRenderer(this, 320, 11);
		RightClaw4.addBox(-1F, 0F, -5F, 2, 2, 5);
		RightClaw4.setRotationPoint(-6F, 24.8F, -13.3F);
		RightClaw4.setTextureSize(512, 256);
		RightClaw4.mirror = true;
		setRotation(RightClaw4, 0.2617994F, 0F, 0F);

		ModelRenderer rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-8F, -4F, 41F);
		rightLeg.addChild(RightLeg1);
		rightLeg.addChild(RightLeg2);
		rightLeg.addChild(RightClaw1);
		rightLeg.addChild(RightClaw2);
		rightLeg.addChild(RightClaw3);
		rightLeg.addChild(RightClaw4);
		legs.add(rightLeg);

		/*
		 * HEAD
		 */

		// END

		ModelRenderer UpperHead = new ModelRenderer(this, 0, 230);
		UpperHead.addBox(0F, 0F, -18F, 18, 8, 18);
		UpperHead.setRotationPoint(0F, -9F, 0F);
		UpperHead.setTextureSize(512, 256);
		UpperHead.mirror = true;
		setRotation(UpperHead, 0.1745329F, 0.7766715F, 0.1745329F);

		ModelRenderer Jaw = new ModelRenderer(this, 76, 209);
		Jaw.addBox(0F, 0F, -16F, 16, 4, 16);
		Jaw.setRotationPoint(0, 0, 0);
		Jaw.setTextureSize(512, 256);
		Jaw.mirror = true;
		setRotation(Jaw, 0.0698132F, 0.7906342F, 0.0523599F);

		ModelRenderer ChinSpike1 = new ModelRenderer(this, 250, 0);
		ChinSpike1.addBox(-0.5F, 0F, 0F, 1, 5, 1);
		ChinSpike1.setRotationPoint(0F, 5F, -20F);
		ChinSpike1.setTextureSize(512, 256);
		ChinSpike1.mirror = true;
		setRotation(ChinSpike1, -0.4363323F, 0F, 0F);

		ModelRenderer ChinSpike2 = new ModelRenderer(this, 255, 0);
		ChinSpike2.addBox(-0.5F, 0F, -1F, 1, 4, 1);
		ChinSpike2.setRotationPoint(0F, 5F, -17.2F);
		ChinSpike2.setTextureSize(512, 256);
		ChinSpike2.mirror = true;
		setRotation(ChinSpike2, -0.4363323F, 0F, 0F);

		ModelRenderer NoseHorn = new ModelRenderer(this, 22, 220);
		NoseHorn.addBox(0F, -4F, 0F, 1, 4, 1);
		NoseHorn.setRotationPoint(0F, -3F, -24F);
		NoseHorn.setTextureSize(512, 256);
		NoseHorn.mirror = true;
		setRotation(NoseHorn, -0.2617994F, -0.7853982F, 0.2617994F);

		ModelRenderer CrestHorn1 = new ModelRenderer(this, 31, 219);
		CrestHorn1.addBox(-0.5F, 0F, 0F, 1, 1, 10);
		CrestHorn1.setRotationPoint(0F, -8F, -1F);
		CrestHorn1.setTextureSize(512, 256);
		CrestHorn1.mirror = true;
		setRotation(CrestHorn1, 0.7853982F, 0F, 0F);

		ModelRenderer CrestHorn2 = new ModelRenderer(this, 0, 205);
		CrestHorn2.addBox(-0.5F, 0F, 0F, 1, 1, 14);
		CrestHorn2.setRotationPoint(-2F, -7F, -3F);
		CrestHorn2.setTextureSize(512, 256);
		CrestHorn2.mirror = true;
		setRotation(CrestHorn2, 0.6981317F, -0.2443461F, 0F);

		ModelRenderer CrestHorn3 = new ModelRenderer(this, 0, 205);
		CrestHorn3.addBox(-0.5F, 0F, 0F, 1, 1, 14);
		CrestHorn3.setRotationPoint(2F, -7F, -3F);
		CrestHorn3.setTextureSize(512, 256);
		CrestHorn3.mirror = true;
		setRotation(CrestHorn3, 0.6981317F, 0.2443461F, 0F);

		ModelRenderer CrestHorn4 = new ModelRenderer(this, 0, 190);
		CrestHorn4.addBox(-0.5F, 0F, 0F, 1, 1, 14);
		CrestHorn4.setRotationPoint(-4F, -6F, -5F);
		CrestHorn4.setTextureSize(512, 256);
		CrestHorn4.mirror = true;
		setRotation(CrestHorn4, 0.6981317F, -0.3490659F, 0F);

		ModelRenderer CrestHorn5 = new ModelRenderer(this, 0, 190);
		CrestHorn5.addBox(-0.5F, 0F, 0F, 1, 1, 14);
		CrestHorn5.setRotationPoint(4F, -6F, -5F);
		CrestHorn5.setTextureSize(512, 256);
		CrestHorn5.mirror = true;
		setRotation(CrestHorn5, 0.6981317F, 0.3490659F, 0F);

		ModelRenderer CrestHorn6 = new ModelRenderer(this, 0, 175);
		CrestHorn6.addBox(-0.5F, 0F, 0F, 1, 1, 14);
		CrestHorn6.setRotationPoint(-6F, -5F, -7F);
		CrestHorn6.setTextureSize(512, 256);
		CrestHorn6.mirror = true;
		setRotation(CrestHorn6, 0.6981317F, -0.5235988F, 0F);

		ModelRenderer CrestHorn7 = new ModelRenderer(this, 0, 175);
		CrestHorn7.addBox(-0.5F, 0F, 0F, 1, 1, 14);
		CrestHorn7.setRotationPoint(6F, -5F, -7F);
		CrestHorn7.setTextureSize(512, 256);
		CrestHorn7.mirror = true;
		setRotation(CrestHorn7, 0.6981317F, 0.5235988F, 0F);

		ModelRenderer CrestHorn8 = new ModelRenderer(this, 0, 160);
		CrestHorn8.addBox(-0.5F, 0F, 0F, 1, 1, 14);
		CrestHorn8.setRotationPoint(-6.5F, -3F, -9F);
		CrestHorn8.setTextureSize(512, 256);
		CrestHorn8.mirror = true;
		setRotation(CrestHorn8, 0.6981317F, -0.6981317F, 0F);

		ModelRenderer CrestHorn9 = new ModelRenderer(this, 0, 160);
		CrestHorn9.addBox(-0.5F, 0F, 0F, 1, 1, 14);
		CrestHorn9.setRotationPoint(6.5F, -3F, -9F);
		CrestHorn9.setTextureSize(512, 256);
		CrestHorn9.mirror = true;
		setRotation(CrestHorn9, 0.6981317F, 0.6981317F, 0F);

		ModelRenderer CrestHorn10 = new ModelRenderer(this, 30, 184);
		CrestHorn10.addBox(-0.5F, 0F, 0F, 1, 1, 14);
		CrestHorn10.setRotationPoint(-6F, -1F, -11F);
		CrestHorn10.setTextureSize(512, 256);
		CrestHorn10.mirror = true;
		setRotation(CrestHorn10, 0.6283185F, -0.7853982F, -0.1047198F);

		ModelRenderer CrestHorn11 = new ModelRenderer(this, 30, 184);
		CrestHorn11.addBox(-0.5F, 0F, 0F, 1, 1, 14);
		CrestHorn11.setRotationPoint(6F, -1F, -11F);
		CrestHorn11.setTextureSize(512, 256);
		CrestHorn11.mirror = true;
		setRotation(CrestHorn11, 0.6283185F, 0.7853982F, 0.1047198F);

		ModelRenderer CrestHorn12 = new ModelRenderer(this, 30, 161);
		CrestHorn12.addBox(-0.5F, 0F, 0F, 1, 1, 13);
		CrestHorn12.setRotationPoint(-8F, -1F, -10F);
		CrestHorn12.setTextureSize(512, 256);
		CrestHorn12.mirror = true;
		setRotation(CrestHorn12, 0.6283185F, -0.9948377F, -0.2617994F);

		ModelRenderer CrestHorn13 = new ModelRenderer(this, 30, 161);
		CrestHorn13.addBox(-0.5F, 0F, 0F, 1, 1, 13);
		CrestHorn13.setRotationPoint(8F, -1F, -10F);
		CrestHorn13.setTextureSize(512, 256);
		CrestHorn13.mirror = true;
		setRotation(CrestHorn13, 0.6283185F, 0.9948377F, 0.2617994F);

		ModelRenderer CrestHorn14 = new ModelRenderer(this, 30, 175);
		CrestHorn14.addBox(-0.5F, 0F, 0F, 1, 1, 8);
		CrestHorn14.setRotationPoint(-9F, -1F, -9F);
		CrestHorn14.setTextureSize(512, 256);
		CrestHorn14.mirror = true;
		setRotation(CrestHorn14, 0.3490659F, -1.570796F, 0F);

		ModelRenderer CrestHorn15 = new ModelRenderer(this, 30, 175);
		CrestHorn15.addBox(-0.5F, 0F, 0F, 1, 1, 8);
		CrestHorn15.setRotationPoint(9F, -1F, -9F);
		CrestHorn15.setTextureSize(512, 256);
		CrestHorn15.mirror = true;
		setRotation(CrestHorn15, 0.3490659F, 1.570796F, 0F);

		ModelRenderer CrestHorn16 = new ModelRenderer(this, 0, 220);
		CrestHorn16.addBox(-0.5F, 0F, 0F, 1, 1, 5);
		CrestHorn16.setRotationPoint(10F, 0F, -9F);
		CrestHorn16.setTextureSize(512, 256);
		CrestHorn16.mirror = true;
		setRotation(CrestHorn16, 0F, 1.570796F, 0F);

		ModelRenderer CrestHorn17 = new ModelRenderer(this, 0, 220);
		CrestHorn17.addBox(-0.5F, 0F, -5F, 1, 1, 5);
		CrestHorn17.setRotationPoint(-10F, 0F, -9F);
		CrestHorn17.setTextureSize(512, 256);
		CrestHorn17.mirror = true;
		setRotation(CrestHorn17, 0F, 1.570796F, 0F);

		ModelRenderer CrestHorn18 = new ModelRenderer(this, 0, 228);
		CrestHorn18.addBox(0F, 0F, -0.5F, 5, 1, 1);
		CrestHorn18.setRotationPoint(8F, 2F, -9F);
		CrestHorn18.setTextureSize(512, 256);
		CrestHorn18.mirror = true;
		setRotation(CrestHorn18, 0F, -0.0872665F, 0.1047198F);

		ModelRenderer CrestHorn19 = new ModelRenderer(this, 0, 228);
		CrestHorn19.addBox(0F, 0F, 0F, 5, 1, 1);
		CrestHorn19.setRotationPoint(-8F, 2F, -9F);
		CrestHorn19.setTextureSize(512, 256);
		CrestHorn19.mirror = true;
		setRotation(CrestHorn19, 0F, -2.879793F, 0.1047198F);

		ModelRenderer CrestHorn20 = new ModelRenderer(this, 12, 220);
		CrestHorn20.addBox(-0.5F, 0F, 0F, 1, 1, 4);
		CrestHorn20.setRotationPoint(8F, 3.5F, -9F);
		CrestHorn20.setTextureSize(512, 256);
		CrestHorn20.mirror = true;
		setRotation(CrestHorn20, -0.5235988F, 1.22173F, 0F);

		ModelRenderer CrestHorn21 = new ModelRenderer(this, 12, 220);
		CrestHorn21.addBox(-0.5F, 0F, 0F, 1, 1, 4);
		CrestHorn21.setRotationPoint(-8F, 3.5F, -9F);
		CrestHorn21.setTextureSize(512, 256);
		CrestHorn21.mirror = true;
		setRotation(CrestHorn21, -0.5235988F, -1.22173F, 0F);

		ModelRenderer CrestHorn22 = new ModelRenderer(this, 30, 206);
		CrestHorn22.addBox(-0.5F, 0F, 0F, 1, 1, 4);
		CrestHorn22.setRotationPoint(6F, 4F, -8F);
		CrestHorn22.setTextureSize(512, 256);
		CrestHorn22.mirror = true;
		setRotation(CrestHorn22, -1.047198F, 0F, -0.3490659F);

		ModelRenderer CrestHorn23 = new ModelRenderer(this, 30, 206);
		CrestHorn23.addBox(-0.5F, 0F, 0F, 1, 1, 4);
		CrestHorn23.setRotationPoint(-6F, 4F, -8F);
		CrestHorn23.setTextureSize(512, 256);
		CrestHorn23.mirror = true;
		setRotation(CrestHorn23, -1.047198F, 0F, 0.3490659F);

		ModelRenderer CrestHorn24 = new ModelRenderer(this, 30, 199);
		CrestHorn24.addBox(-0.5F, 0F, 0F, 1, 1, 3);
		CrestHorn24.setRotationPoint(3.5F, 4F, -7.5F);
		CrestHorn24.setTextureSize(512, 256);
		CrestHorn24.mirror = true;
		setRotation(CrestHorn24, -1.047198F, 0F, 0F);

		ModelRenderer CrestHorn25 = new ModelRenderer(this, 30, 199);
		CrestHorn25.addBox(-0.5F, 0F, 0F, 1, 1, 3);
		CrestHorn25.setRotationPoint(-3.5F, 4F, -7.5F);
		CrestHorn25.setTextureSize(512, 256);
		CrestHorn25.mirror = true;
		setRotation(CrestHorn25, -1.047198F, 0F, 0F);

		ModelRenderer CrestHorn26 = new ModelRenderer(this, 30, 203);
		CrestHorn26.addBox(-0.5F, 0F, 0F, 1, 1, 2);
		CrestHorn26.setRotationPoint(0F, 4F, -7F);
		CrestHorn26.setTextureSize(512, 256);
		CrestHorn26.mirror = true;
		setRotation(CrestHorn26, -0.8726646F, 0F, 0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0F, -7F, -10F);
		head.addChild(UpperHead);
		head.addChild(Jaw);
		head.addChild(ChinSpike1);
		head.addChild(ChinSpike2);
		head.addChild(NoseHorn);
		head.addChild(CrestHorn1);
		head.addChild(CrestHorn2);
		head.addChild(CrestHorn3);
		head.addChild(CrestHorn4);
		head.addChild(CrestHorn5);
		head.addChild(CrestHorn6);
		head.addChild(CrestHorn7);
		head.addChild(CrestHorn8);
		head.addChild(CrestHorn9);
		head.addChild(CrestHorn10);
		head.addChild(CrestHorn11);
		head.addChild(CrestHorn12);
		head.addChild(CrestHorn13);
		head.addChild(CrestHorn14);
		head.addChild(CrestHorn15);
		head.addChild(CrestHorn16);
		head.addChild(CrestHorn17);
		head.addChild(CrestHorn18);
		head.addChild(CrestHorn19);
		head.addChild(CrestHorn20);
		head.addChild(CrestHorn21);
		head.addChild(CrestHorn22);
		head.addChild(CrestHorn23);
		head.addChild(CrestHorn24);
		head.addChild(CrestHorn25);
		head.addChild(CrestHorn26);

		/*
		 * BODY
		 */

		ModelRenderer Neck = new ModelRenderer(this, 72, 229);
		Neck.addBox(-8F, 0F, 0F, 16, 9, 18);
		Neck.setRotationPoint(0F, -13F, -19F);
		Neck.setTextureSize(512, 256);
		Neck.mirror = true;
		setRotation(Neck, -0.3839724F, 0F, 0F);

		ModelRenderer BodyFront = new ModelRenderer(this, 140, 221);
		BodyFront.addBox(-9F, 0F, 0F, 18, 14, 21);
		BodyFront.setRotationPoint(0F, -9.5F, -7F);
		BodyFront.setTextureSize(512, 256);
		BodyFront.mirror = true;
		setRotation(BodyFront, 0.0872665F, 0F, 0F);

		ModelRenderer BodyMiddle = new ModelRenderer(this, 218, 218);
		BodyMiddle.addBox(-10.5F, 0F, 0F, 21, 16, 22);
		BodyMiddle.setRotationPoint(0F, -11.5F, 12F);
		BodyMiddle.setTextureSize(512, 256);
		BodyMiddle.mirror = true;
		setRotation(BodyMiddle, 0F, 0F, 0F);

		ModelRenderer BodyBack = new ModelRenderer(this, 304, 222);
		BodyBack.addBox(-9F, 0F, 0F, 18, 14, 20);
		BodyBack.setRotationPoint(0F, -11F, 33F);
		BodyBack.setTextureSize(512, 256);
		BodyBack.mirror = true;
		setRotation(BodyBack, -0.0872665F, 0F, 0F);

		ModelRenderer Tail1 = new ModelRenderer(this, 452, 0);
		Tail1.addBox(-7F, 0F, 0F, 14, 12, 16);
		Tail1.setRotationPoint(0F, -9F, 52F);
		Tail1.setTextureSize(512, 256);
		Tail1.mirror = true;
		setRotation(Tail1, -0.1745329F, 0F, 0F);

		ModelRenderer Tail2 = new ModelRenderer(this, 458, 28);
		Tail2.addBox(-5.5F, 0F, 0F, 11, 10, 16);
		Tail2.setRotationPoint(0F, -6F, 66F);
		Tail2.setTextureSize(512, 256);
		Tail2.mirror = true;
		setRotation(Tail2, -0.2268928F, 0F, 0F);

		ModelRenderer Tail3 = new ModelRenderer(this, 460, 54);
		Tail3.addBox(-5F, 0F, 0F, 10, 9, 16);
		Tail3.setRotationPoint(0F, -2F, 81F);
		Tail3.setTextureSize(512, 256);
		Tail3.mirror = true;
		setRotation(Tail3, -0.3490659F, 0F, 0F);

		ModelRenderer Tail4 = new ModelRenderer(this, 462, 79);
		Tail4.addBox(-4.5F, 0F, 0F, 9, 8, 16);
		Tail4.setRotationPoint(0F, 3F, 94F);
		Tail4.setTextureSize(512, 256);
		Tail4.mirror = true;
		setRotation(Tail4, -0.3141593F, 0F, 0F);

		ModelRenderer Tail5 = new ModelRenderer(this, 464, 103);
		Tail5.addBox(-4F, 0F, 0F, 8, 7, 16);
		Tail5.setRotationPoint(0F, 8F, 107F);
		Tail5.setTextureSize(512, 256);
		Tail5.mirror = true;
		setRotation(Tail5, -0.2268928F, 0F, 0F);

		ModelRenderer Tail6 = new ModelRenderer(this, 466, 126);
		Tail6.addBox(-3.5F, 0F, 0F, 7, 6, 16);
		Tail6.setRotationPoint(0F, 12F, 121F);
		Tail6.setTextureSize(512, 256);
		Tail6.mirror = true;
		setRotation(Tail6, -0.1570796F, 0F, 0F);

		ModelRenderer Tail7 = new ModelRenderer(this, 468, 148);
		Tail7.addBox(-3F, 0F, 0F, 6, 5, 16);
		Tail7.setRotationPoint(0F, 15F, 135F);
		Tail7.setTextureSize(512, 256);
		Tail7.mirror = true;
		setRotation(Tail7, -0.1047198F, 0F, 0F);

		ModelRenderer Tail8 = new ModelRenderer(this, 470, 169);
		Tail8.addBox(-2.5F, 0F, 0F, 5, 4, 16);
		Tail8.setRotationPoint(0F, 17F, 149F);
		Tail8.setTextureSize(512, 256);
		Tail8.mirror = true;
		setRotation(Tail8, -0.0349066F, 0F, 0F);

		ModelRenderer Tail9 = new ModelRenderer(this, 472, 189);
		Tail9.addBox(-2F, 0F, 0F, 4, 3, 16);
		Tail9.setRotationPoint(0F, 18F, 163F);
		Tail9.setTextureSize(512, 256);
		Tail9.mirror = true;
		setRotation(Tail9, 0F, 0F, 0F);

		ModelRenderer Tail10 = new ModelRenderer(this, 466, 208);
		Tail10.addBox(-1.5F, 0F, 0F, 3, 2, 20);
		Tail10.setRotationPoint(0F, 18.5F, 178F);
		Tail10.setTextureSize(512, 256);
		Tail10.mirror = true;
		setRotation(Tail10, 0F, 0F, 0F);

		ModelRenderer Spike1 = new ModelRenderer(this, 89, 0);
		Spike1.addBox(-0.5F, -5F, 0F, 1, 5, 2);
		Spike1.setRotationPoint(0F, -10F, 0F);
		Spike1.setTextureSize(512, 256);
		Spike1.mirror = true;
		setRotation(Spike1, -0.4363323F, 0F, 0F);

		ModelRenderer Spike2 = new ModelRenderer(this, 96, 0);
		Spike2.addBox(-0.5F, -6F, 0F, 1, 6, 2);
		Spike2.setRotationPoint(0F, -10F, 7F);
		Spike2.setTextureSize(512, 256);
		Spike2.mirror = true;
		setRotation(Spike2, -0.3490659F, 0F, 0F);

		ModelRenderer Spike3 = new ModelRenderer(this, 103, 0);
		Spike3.addBox(-0.5F, -7F, 0F, 1, 7, 2);
		Spike3.setRotationPoint(0F, -11F, 14F);
		Spike3.setTextureSize(512, 256);
		Spike3.mirror = true;
		setRotation(Spike3, -0.3490659F, 0F, 0F);

		ModelRenderer Spike4 = new ModelRenderer(this, 110, 0);
		Spike4.addBox(-0.5F, -8F, 0F, 1, 8, 2);
		Spike4.setRotationPoint(0F, -11F, 21F);
		Spike4.setTextureSize(512, 256);
		Spike4.mirror = true;
		setRotation(Spike4, -0.4363323F, 0F, 0F);

		ModelRenderer Spike5 = new ModelRenderer(this, 117, 0);
		Spike5.addBox(-0.5F, -9F, 0F, 1, 9, 2);
		Spike5.setRotationPoint(0F, -11F, 28F);
		Spike5.setTextureSize(512, 256);
		Spike5.mirror = true;
		setRotation(Spike5, -0.5235988F, 0F, 0F);

		ModelRenderer Spike6 = new ModelRenderer(this, 124, 0);
		Spike6.addBox(-0.5F, -10F, 0F, 1, 10, 2);
		Spike6.setRotationPoint(0F, -10F, 35F);
		Spike6.setTextureSize(512, 256);
		Spike6.mirror = true;
		setRotation(Spike6, -0.5235988F, 0F, 0F);

		ModelRenderer Spike7 = new ModelRenderer(this, 131, 0);
		Spike7.addBox(-0.5F, -11F, 0F, 1, 11, 2);
		Spike7.setRotationPoint(0F, -10F, 42F);
		Spike7.setTextureSize(512, 256);
		Spike7.mirror = true;
		setRotation(Spike7, -0.5585054F, 0F, 0F);

		ModelRenderer Spike8 = new ModelRenderer(this, 138, 0);
		Spike8.addBox(-0.5F, -12F, 0F, 1, 12, 2);
		Spike8.setRotationPoint(0F, -9F, 49F);
		Spike8.setTextureSize(512, 256);
		Spike8.mirror = true;
		setRotation(Spike8, -0.6108652F, 0F, 0F);

		ModelRenderer Spike9 = new ModelRenderer(this, 145, 0);
		Spike9.addBox(-0.5F, -13F, 0F, 1, 13, 2);
		Spike9.setRotationPoint(0F, -8F, 56F);
		Spike9.setTextureSize(512, 256);
		Spike9.mirror = true;
		setRotation(Spike9, -0.6981317F, 0F, 0F);

		ModelRenderer Spike10 = new ModelRenderer(this, 152, 0);
		Spike10.addBox(-0.5F, -14F, 0F, 1, 14, 2);
		Spike10.setRotationPoint(0F, -7F, 63F);
		Spike10.setTextureSize(512, 256);
		Spike10.mirror = true;
		setRotation(Spike10, -0.7853982F, 0F, 0F);

		ModelRenderer Spike11 = new ModelRenderer(this, 159, 0);
		Spike11.addBox(-0.5F, -14F, 0F, 1, 14, 2);
		Spike11.setRotationPoint(0F, -4F, 70F);
		Spike11.setTextureSize(512, 256);
		Spike11.mirror = true;
		setRotation(Spike11, -0.8726646F, 0F, 0F);

		ModelRenderer Spike12 = new ModelRenderer(this, 166, 0);
		Spike12.addBox(-0.5F, -14F, 0F, 1, 14, 2);
		Spike12.setRotationPoint(0F, -2F, 77F);
		Spike12.setTextureSize(512, 256);
		Spike12.mirror = true;
		setRotation(Spike12, -0.9599311F, 0F, 0F);

		ModelRenderer Spike13 = new ModelRenderer(this, 173, 0);
		Spike13.addBox(-0.5F, -13F, 0F, 1, 13, 2);
		Spike13.setRotationPoint(0F, 0F, 85F);
		Spike13.setTextureSize(512, 256);
		Spike13.mirror = true;
		setRotation(Spike13, -1.047198F, 0F, 0F);

		ModelRenderer Spike14 = new ModelRenderer(this, 180, 0);
		Spike14.addBox(-0.5F, -12F, 0F, 1, 12, 2);
		Spike14.setRotationPoint(0F, 3F, 93F);
		Spike14.setTextureSize(512, 256);
		Spike14.mirror = true;
		setRotation(Spike14, -1.047198F, 0F, 0F);

		ModelRenderer Spike15 = new ModelRenderer(this, 187, 0);
		Spike15.addBox(-0.5F, -12F, 0F, 1, 12, 2);
		Spike15.setRotationPoint(0F, 6F, 102F);
		Spike15.setTextureSize(512, 256);
		Spike15.mirror = true;
		setRotation(Spike15, -1.047198F, 0F, 0F);

		ModelRenderer Spike16 = new ModelRenderer(this, 194, 0);
		Spike16.addBox(-0.5F, -11F, 0F, 1, 11, 2);
		Spike16.setRotationPoint(0F, 9F, 111F);
		Spike16.setTextureSize(512, 256);
		Spike16.mirror = true;
		setRotation(Spike16, -0.9599311F, 0F, 0F);

		ModelRenderer Spike17 = new ModelRenderer(this, 201, 0);
		Spike17.addBox(-0.5F, -10F, 0F, 1, 10, 2);
		Spike17.setRotationPoint(0F, 11F, 119F);
		Spike17.setTextureSize(512, 256);
		Spike17.mirror = true;
		setRotation(Spike17, -0.9075712F, 0F, 0F);

		ModelRenderer Spike18 = new ModelRenderer(this, 208, 0);
		Spike18.addBox(-0.5F, -10F, 0F, 1, 10, 2);
		Spike18.setRotationPoint(0F, 13F, 126F);
		Spike18.setTextureSize(512, 256);
		Spike18.mirror = true;
		setRotation(Spike18, -0.9075712F, 0F, 0F);

		ModelRenderer Spike19 = new ModelRenderer(this, 215, 0);
		Spike19.addBox(-0.5F, -9F, 0F, 1, 9, 2);
		Spike19.setRotationPoint(0F, 15F, 134F);
		Spike19.setTextureSize(512, 256);
		Spike19.mirror = true;
		setRotation(Spike19, -0.7679449F, 0F, 0F);

		ModelRenderer Spike20 = new ModelRenderer(this, 222, 0);
		Spike20.addBox(-0.5F, -9F, 0F, 1, 9, 2);
		Spike20.setRotationPoint(0F, 16F, 142F);
		Spike20.setTextureSize(512, 256);
		Spike20.mirror = true;
		setRotation(Spike20, -0.7853982F, 0F, 0F);

		ModelRenderer Spike21 = new ModelRenderer(this, 229, 0);
		Spike21.addBox(-0.5F, -8F, 0F, 1, 8, 2);
		Spike21.setRotationPoint(0F, 17F, 151F);
		Spike21.setTextureSize(512, 256);
		Spike21.mirror = true;
		setRotation(Spike21, -0.6981317F, 0F, 0F);

		ModelRenderer Spike22 = new ModelRenderer(this, 236, 0);
		Spike22.addBox(-0.5F, -8F, 0F, 1, 8, 2);
		Spike22.setRotationPoint(0F, 18F, 159F);
		Spike22.setTextureSize(512, 256);
		Spike22.mirror = true;
		setRotation(Spike22, -0.6981317F, 0F, 0F);

		ModelRenderer Spike23 = new ModelRenderer(this, 243, 0);
		Spike23.addBox(-0.5F, -8F, 0F, 1, 8, 2);
		Spike23.setRotationPoint(0F, 18F, 168F);
		Spike23.setTextureSize(512, 256);
		Spike23.mirror = true;
		setRotation(Spike23, -0.7853982F, 0F, 0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0F, 0, 0);
		body.addChild(Neck);
		body.addChild(BodyFront);
		body.addChild(BodyMiddle);
		body.addChild(BodyBack);
		body.addChild(Tail1);
		body.addChild(Tail2);
		body.addChild(Tail3);
		body.addChild(Tail4);
		body.addChild(Tail5);
		body.addChild(Tail6);
		body.addChild(Tail7);
		body.addChild(Tail8);
		body.addChild(Tail9);
		body.addChild(Tail10);
		body.addChild(Spike1);
		body.addChild(Spike2);
		body.addChild(Spike3);
		body.addChild(Spike4);
		body.addChild(Spike5);
		body.addChild(Spike6);
		body.addChild(Spike7);
		body.addChild(Spike8);
		body.addChild(Spike9);
		body.addChild(Spike10);
		body.addChild(Spike11);
		body.addChild(Spike12);
		body.addChild(Spike13);
		body.addChild(Spike14);
		body.addChild(Spike15);
		body.addChild(Spike16);
		body.addChild(Spike17);
		body.addChild(Spike18);
		body.addChild(Spike19);
		body.addChild(Spike20);
		body.addChild(Spike21);
		body.addChild(Spike22);
		body.addChild(Spike23);

		/*
		 * WING
		 */

		ModelRenderer LeftArm1 = new ModelRenderer(this, 0, 100);
		LeftArm1.addBox(0F, 0F, 0F, 16, 5, 5);
		LeftArm1.setRotationPoint(0, 0, 0);
		LeftArm1.setTextureSize(512, 256);
		LeftArm1.mirror = true;
		setRotation(LeftArm1, 0F, 0.1745329F, 0F);
		LeftArm1.mirror = false;

		ModelRenderer LeftArm2 = new ModelRenderer(this, 0, 92);
		LeftArm2.addBox(0F, 0F, 0F, 30, 4, 4);
		LeftArm2.setRotationPoint(13F, 0.5F, -1F);
		LeftArm2.setTextureSize(512, 256);
		LeftArm2.mirror = true;
		setRotation(LeftArm2, 0F, 0.5235988F, 0F);

		ModelRenderer LeftArm3 = new ModelRenderer(this, 0, 25);
		LeftArm3.addBox(0F, 0F, 0F, 70, 2, 2);
		LeftArm3.setRotationPoint(39F, 1.5F, -15F);
		LeftArm3.setTextureSize(512, 256);
		LeftArm3.mirror = true;
		setRotation(LeftArm3, 0F, -0.0872665F, 0F);

		ModelRenderer LeftArm4 = new ModelRenderer(this, 0, 21);
		LeftArm4.addBox(0F, 0F, 0F, 50, 2, 2);
		LeftArm4.setRotationPoint(108.5F, 1.5F, -9F);
		LeftArm4.setTextureSize(512, 256);
		LeftArm4.mirror = true;
		setRotation(LeftArm4, 0F, -0.3490659F, 0F);

		ModelRenderer LeftWing1 = new ModelRenderer(this, 430, 232);
		LeftWing1.addBox(0F, 0F, 0F, 17, 0, 28);
		LeftWing1.setRotationPoint(0F, 2.5F, 1F);
		LeftWing1.setTextureSize(512, 256);
		LeftWing1.mirror = true;
		setRotation(LeftWing1, 0F, 0F, 0F);

		ModelRenderer LeftWing2 = new ModelRenderer(this, 0, 29);
		LeftWing2.addBox(0F, 0F, 0F, 135, 0, 63);
		LeftWing2.setRotationPoint(17F, 2.5F, -14F);
		LeftWing2.setTextureSize(512, 256);
		LeftWing2.mirror = true;
		setRotation(LeftWing2, 0F, 0F, 0F);

		ModelRenderer LeftSpine1 = new ModelRenderer(this, 69, 93);
		LeftSpine1.addBox(0F, 0F, 0F, 120, 1, 1);
		LeftSpine1.setRotationPoint(40F, 2F, -14F);
		LeftSpine1.setTextureSize(512, 256);
		LeftSpine1.mirror = true;
		setRotation(LeftSpine1, 0F, -0.5585054F, 0F);

		ModelRenderer LeftSpine2 = new ModelRenderer(this, 69, 96);
		LeftSpine2.addBox(0F, 0F, 0F, 85, 1, 1);
		LeftSpine2.setRotationPoint(40F, 2F, -14F);
		LeftSpine2.setTextureSize(512, 256);
		LeftSpine2.mirror = true;
		setRotation(LeftSpine2, 0F, -0.9250245F, 0F);

		ModelRenderer LeftSpine3 = new ModelRenderer(this, 69, 99);
		LeftSpine3.addBox(0F, 0F, 0F, 60, 1, 1);
		LeftSpine3.setRotationPoint(40F, 2F, -14F);
		LeftSpine3.setTextureSize(512, 256);
		LeftSpine3.mirror = true;
		setRotation(LeftSpine3, 0F, -1.343904F, 0F);

		ModelRenderer LeftSpine4 = new ModelRenderer(this, 69, 102);
		LeftSpine4.addBox(0F, 0F, 0F, 50, 1, 1);
		LeftSpine4.setRotationPoint(40F, 2F, -14F);
		LeftSpine4.setTextureSize(512, 256);
		LeftSpine4.mirror = true;
		setRotation(LeftSpine4, 0F, -1.745329F, 0F);

		ModelRenderer LeftWingClaw1 = new ModelRenderer(this, 0, 0);
		LeftWingClaw1.addBox(0F, 0F, -12F, 8, 3, 12);
		LeftWingClaw1.setRotationPoint(35F, 1F, -13F);
		LeftWingClaw1.setTextureSize(512, 256);
		LeftWingClaw1.mirror = true;
		setRotation(LeftWingClaw1, 0F, 0F, 0F);

		ModelRenderer LeftWingClaw2 = new ModelRenderer(this, 40, 0);
		LeftWingClaw2.addBox(0F, 0F, -8F, 6, 2, 8);
		LeftWingClaw2.setRotationPoint(36F, 1.5F, -25F);
		LeftWingClaw2.setTextureSize(512, 256);
		LeftWingClaw2.mirror = true;
		setRotation(LeftWingClaw2, 0F, -0.2617994F, 0F);

		ModelRenderer LeftWingClaw3 = new ModelRenderer(this, 68, 0);
		LeftWingClaw3.addBox(0F, 0F, -6F, 4, 1, 6);
		LeftWingClaw3.setRotationPoint(38F, 2F, -32F);
		LeftWingClaw3.setTextureSize(512, 256);
		LeftWingClaw3.mirror = true;
		setRotation(LeftWingClaw3, 0F, -0.5759587F, 0F);

		wing = new ModelRenderer(this);
		wing.setRotationPoint(8F, -8F, 3F);
		wing.addChild(LeftArm1);
		wing.addChild(LeftArm2);
		wing.addChild(LeftArm3);
		wing.addChild(LeftArm4);
		wing.addChild(LeftWing1);
		wing.addChild(LeftWing2);
		wing.addChild(LeftSpine1);
		wing.addChild(LeftSpine2);
		wing.addChild(LeftSpine3);
		wing.addChild(LeftSpine4);
		wing.addChild(LeftWingClaw1);
		wing.addChild(LeftWingClaw2);
		wing.addChild(LeftWingClaw3);

		// RightArm1 = new ModelRenderer(this, 0, 100);
		// RightArm1.addBox(-16F, 0F, 0F, 16, 5, 5);
		// RightArm1.setRotationPoint(-8F, -8F, 3F);
		// RightArm1.setTextureSize(512, 256);
		// RightArm1.mirror = true;
		// setRotation(RightArm1, 0F, -0.1745329F, 0F);
		// RightArm2 = new ModelRenderer(this, 0, 92);
		// RightArm2.addBox(-30F, 0F, 0F, 30, 4, 4);
		// RightArm2.setRotationPoint(-21F, -7.5F, 2F);
		// RightArm2.setTextureSize(512, 256);
		// RightArm2.mirror = true;
		// setRotation(RightArm2, 0F, -0.5235988F, 0F);
		// RightArm3 = new ModelRenderer(this, 0, 25);
		// RightArm3.addBox(-70F, 0F, 0F, 70, 2, 2);
		// RightArm3.setRotationPoint(-47F, -6.5F, -12F);
		// RightArm3.setTextureSize(512, 256);
		// RightArm3.mirror = true;
		// setRotation(RightArm3, 0F, 0.0872665F, 0F);
		// RightArm3.mirror = false;
		// RightArm4 = new ModelRenderer(this, 0, 21);
		// RightArm4.addBox(-50F, 0F, 0F, 50, 2, 2);
		// RightArm4.setRotationPoint(-116.5F, -6.5F, -6F);
		// RightArm4.setTextureSize(512, 256);
		// RightArm4.mirror = true;
		// setRotation(RightArm4, 0F, 0.3490659F, 0F);
		// RightWing1 = new ModelRenderer(this, 430, 232);
		// RightWing1.addBox(-17F, 0F, 0F, 17, 0, 28);
		// RightWing1.setRotationPoint(-8F, -5.5F, 4F);
		// RightWing1.setTextureSize(512, 256);
		// RightWing1.mirror = true;
		// setRotation(RightWing1, 0F, 0F, 0F);
		// RightWing2 = new ModelRenderer(this, 0, 29);
		// RightWing2.addBox(-135F, 0F, 0F, 135, 0, 63);
		// RightWing2.setRotationPoint(-25F, -5.5F, -11F);
		// RightWing2.setTextureSize(512, 256);
		// RightWing2.mirror = true;
		// setRotation(RightWing2, 0F, 0F, 0F);
		// RightWing2.mirror = false;
		// RightSpine1 = new ModelRenderer(this, 69, 93);
		// RightSpine1.addBox(-120F, 0F, 0F, 120, 1, 1);
		// RightSpine1.setRotationPoint(-48F, -6F, -11F);
		// RightSpine1.setTextureSize(512, 256);
		// RightSpine1.mirror = true;
		// setRotation(RightSpine1, 0F, 0.5759587F, 0F);
		// RightSpine1.mirror = false;
		// RightSpine2 = new ModelRenderer(this, 69, 96);
		// RightSpine2.addBox(-85F, 0F, 0F, 85, 1, 1);
		// RightSpine2.setRotationPoint(-48F, -6F, -11F);
		// RightSpine2.setTextureSize(512, 256);
		// RightSpine2.mirror = true;
		// setRotation(RightSpine2, 0F, 0.9250245F, 0F);
		// RightSpine2.mirror = false;
		// RightSpine3 = new ModelRenderer(this, 69, 99);
		// RightSpine3.addBox(-60F, 0F, 0F, 60, 1, 1);
		// RightSpine3.setRotationPoint(-48F, -6F, -11F);
		// RightSpine3.setTextureSize(512, 256);
		// RightSpine3.mirror = true;
		// setRotation(RightSpine3, 0F, 1.343904F, 0F);
		// RightSpine3.mirror = false;
		// RightSpine4 = new ModelRenderer(this, 69, 102);
		// RightSpine4.addBox(-50F, 0F, 0F, 50, 1, 1);
		// RightSpine4.setRotationPoint(-48F, -6F, -11F);
		// RightSpine4.setTextureSize(512, 256);
		// RightSpine4.mirror = true;
		// setRotation(RightSpine4, 0F, 1.745329F, 0F);
		// RightSpine4.mirror = false;
		//
		// RightWingClaw1 = new ModelRenderer(this, 0, 0);
		// RightWingClaw1.addBox(-7F, 0F, -12F, 8, 3, 12);
		// RightWingClaw1.setRotationPoint(-44F, -7F, -10F);
		// RightWingClaw1.setTextureSize(512, 256);
		// RightWingClaw1.mirror = true;
		// setRotation(RightWingClaw1, 0F, 0F, 0F);
		// RightWingClaw2 = new ModelRenderer(this, 40, 0);
		// RightWingClaw2.addBox(-6F, 0F, -8F, 6, 2, 8);
		// RightWingClaw2.setRotationPoint(-44F, -6.5F, -22F);
		// RightWingClaw2.setTextureSize(512, 256);
		// RightWingClaw2.mirror = true;
		// setRotation(RightWingClaw2, 0F, 0.2617994F, 0F);
		// RightWingClaw3 = new ModelRenderer(this, 68, 0);
		// RightWingClaw3.addBox(-4F, 0F, -6F, 4, 1, 6);
		// RightWingClaw3.setRotationPoint(-46F, -6F, -29F);
		// RightWingClaw3.setTextureSize(512, 256);
		// RightWingClaw3.mirror = true;
		// setRotation(RightWingClaw3, 0F, 0.5759587F, 0F);

	}
}
