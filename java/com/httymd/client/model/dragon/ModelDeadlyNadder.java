package com.httymd.client.model.dragon;

import com.httymd.client.model.ModelDragon;

import net.minecraft.client.model.ModelRenderer;

public class ModelDeadlyNadder extends ModelDragon {

	public ModelDeadlyNadder() {
		textureWidth = 512;
		textureHeight = 256;

		head = 		new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer head = new ModelRenderer(model);
				head.setRotationPoint(-0.5F, -31F, -35F);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer cresthorn11 = new ModelRenderer(model, 0, 144);
				cresthorn11.addBox(0F, 0F, 0F, 1, 1, 4);
				cresthorn11.setRotationPoint(5.5F, 0F, 0F);
				cresthorn11.setTextureSize(textureWidth, textureHeight);
				cresthorn11.mirror = true;
				setRotation(cresthorn11, -0.22689280275926282F, 0.6981317007977318F, 0F);
				return cresthorn11;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer cresthorn10 = new ModelRenderer(model, 0, 144);
				cresthorn10.addBox(0F, 0F, 0F, 1, 1, 4);
				cresthorn10.setRotationPoint(-6.5F, 0F, 0F);
				cresthorn10.setTextureSize(textureWidth, textureHeight);
				cresthorn10.mirror = true;
				setRotation(cresthorn10, -0.22689280275926282F, -0.6981317007977318F, 0F);
				return cresthorn10;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer cresthorn8 = new ModelRenderer(model, 0, 149);
				cresthorn8.addBox(0F, 0F, 0F, 1, 1, 8);
				cresthorn8.setRotationPoint(-6.5F, -2F, -1F);
				cresthorn8.setTextureSize(textureWidth, textureHeight);
				cresthorn8.mirror = true;
				setRotation(cresthorn8, -0.08726646259971647F, -0.6108652381980153F, 0F);
				return cresthorn8;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer jaw = new ModelRenderer(model, 62, 227);
				jaw.addBox(-7F, 0F, -19F, 14, 10, 19);
				jaw.setRotationPoint(0F, 0F, 0F);
				jaw.setTextureSize(textureWidth, textureHeight);
				jaw.mirror = true;
				setRotation(jaw, 0F, 0F, 0F);
				return jaw;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer horn2 = new ModelRenderer(model, 0, 124);
				horn2.addBox(0F, -4F, -3F, 3, 5, 3);
				horn2.setRotationPoint(-1.5F, -8F, -14F);
				horn2.setTextureSize(textureWidth, textureHeight);
				horn2.mirror = true;
				setRotation(horn2, -0.6108652381980153F, 0F, 0F);
				return horn2;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer cresthorn3 = new ModelRenderer(model, 0, 188);
				cresthorn3.addBox(-2F, 0F, 0F, 2, 2, 18);
				cresthorn3.setRotationPoint(4.5F, -7F, -2F);
				cresthorn3.setTextureSize(textureWidth, textureHeight);
				cresthorn3.mirror = true;
				setRotation(cresthorn3, 0.4363323129985824F, 0.08726646259971647F, 0F);
				return cresthorn3;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer cresthorn4 = new ModelRenderer(model, 0, 172);
				cresthorn4.addBox(-2F, 0F, 0F, 2, 2, 14);
				cresthorn4.setRotationPoint(5.5F, -7F, -2F);
				cresthorn4.setTextureSize(textureWidth, textureHeight);
				cresthorn4.mirror = true;
				setRotation(cresthorn4, 0.08726646259971647F, 0.3490658503988659F, 0F);
				return cresthorn4;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer cresthorn2 = new ModelRenderer(model, 0, 188);
				cresthorn2.addBox(0F, 0F, 0F, 2, 2, 18);
				cresthorn2.setRotationPoint(-4.5F, -7F, -2F);
				cresthorn2.setTextureSize(textureWidth, textureHeight);
				cresthorn2.mirror = true;
				setRotation(cresthorn2, 0.4363323129985824F, -0.08726646259971647F, 0F);
				return cresthorn2;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer cresthorn1 = new ModelRenderer(model, 0, 208);
				cresthorn1.addBox(0F, 0F, 0F, 2, 2, 20);
				cresthorn1.setRotationPoint(-1F, -7F, -2F);
				cresthorn1.setTextureSize(textureWidth, textureHeight);
				cresthorn1.mirror = true;
				setRotation(cresthorn1, 0.5235987755982988F, 0F, 0F);
				return cresthorn1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer cresthorn7 = new ModelRenderer(model, 0, 159);
				cresthorn7.addBox(-1F, 0F, 0F, 1, 1, 12);
				cresthorn7.setRotationPoint(6.5F, -4F, -1F);
				cresthorn7.setTextureSize(textureWidth, textureHeight);
				cresthorn7.mirror = true;
				setRotation(cresthorn7, 0F, 0.3490658503988659F, 0F);
				return cresthorn7;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer cresthorn5 = new ModelRenderer(model, 0, 172);
				cresthorn5.addBox(0F, 0F, 0F, 2, 2, 14);
				cresthorn5.setRotationPoint(-5.5F, -7F, -2F);
				cresthorn5.setTextureSize(textureWidth, textureHeight);
				cresthorn5.mirror = true;
				setRotation(cresthorn5, 0.08726646259971647F, -0.3490658503988659F, 0F);
				return cresthorn5;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer head = new ModelRenderer(model, 0, 230);
				head.addBox(-6.5F, -8F, -18F, 13, 8, 18);
				head.setRotationPoint(0F, 0F, 0F);
				head.setTextureSize(textureWidth, textureHeight);
				head.mirror = true;
				setRotation(head, 0.08726646259971647F, 0F, 0F);
				return head;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer cresthorn9 = new ModelRenderer(model, 0, 150);
				cresthorn9.addBox(-1F, 0F, 0F, 1, 1, 8);
				cresthorn9.setRotationPoint(6.5F, -2F, -1F);
				cresthorn9.setTextureSize(textureWidth, textureHeight);
				cresthorn9.mirror = true;
				setRotation(cresthorn9, -0.08726646259971647F, 0.6108652381980153F, 0F);
				return cresthorn9;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer horn4 = new ModelRenderer(model, 0, 112);
				horn4.addBox(0F, 0F, 0F, 1, 4, 1);
				horn4.setRotationPoint(-0.5F, -17F, -7F);
				horn4.setTextureSize(textureWidth, textureHeight);
				horn4.mirror = true;
				setRotation(horn4, -1.0471975511965976F, 0F, 0F);
				return horn4;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer cresthorn6 = new ModelRenderer(model, 0, 159);
				cresthorn6.addBox(0F, 0F, 0F, 1, 1, 12);
				cresthorn6.setRotationPoint(-6.5F, -4F, -1F);
				cresthorn6.setTextureSize(textureWidth, textureHeight);
				cresthorn6.mirror = true;
				setRotation(cresthorn6, 0F, -0.4363323129985824F, 0F);
				return cresthorn6;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer horn1 = new ModelRenderer(model, 0, 132);
				horn1.addBox(0F, -3F, 0F, 4, 3, 9);
				horn1.setRotationPoint(-2F, -6F, -18F);
				horn1.setTextureSize(textureWidth, textureHeight);
				horn1.mirror = true;
				setRotation(horn1, -0.2617993877991494F, 0F, 0F);
				return horn1;
			}
		}.get()
);

		head.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer horn3 = new ModelRenderer(model, 0, 117);
				horn3.addBox(0F, 0F, 0F, 2, 5, 2);
				horn3.setRotationPoint(-1F, -16F, -10F);
				horn3.setTextureSize(textureWidth, textureHeight);
				horn3.mirror = true;
				setRotation(horn3, -0.8726646259971648F, 0F, 0F);
				return horn3;
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
				ModelRenderer stomach = new ModelRenderer(model, 434, 33);
				stomach.addBox(0F, 0F, 0F, 19, 20, 20);
				stomach.setRotationPoint(-10F, -24F, -12F);
				stomach.setTextureSize(textureWidth, textureHeight);
				stomach.mirror = true;
				setRotation(stomach, -0.17453292519943295F, 0F, 0F);
				return stomach;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer upperbody = new ModelRenderer(model, 463, 73);
				upperbody.addBox(0F, 0F, 0F, 15, 13, 10);
				upperbody.setRotationPoint(-8F, -26F, -18F);
				upperbody.setTextureSize(textureWidth, textureHeight);
				upperbody.mirror = true;
				setRotation(upperbody, -0.4363323129985824F, 0F, 0F);
				return upperbody;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer tail1 = new ModelRenderer(model, 442, 222);
				tail1.addBox(0F, 0F, 0F, 15, 14, 20);
				tail1.setRotationPoint(-8F, -18F, 7F);
				tail1.setTextureSize(textureWidth, textureHeight);
				tail1.mirror = true;
				setRotation(tail1, -0.3490658503988659F, 0F, 0F);
				return tail1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer tail2 = new ModelRenderer(model, 380, 226);
				tail2.addBox(0F, 0F, 0F, 11, 10, 20);
				tail2.setRotationPoint(-6F, -10F, 23F);
				tail2.setTextureSize(textureWidth, textureHeight);
				tail2.mirror = true;
				setRotation(tail2, -0.2617993877991494F, 0F, 0F);
				return tail2;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer tail3 = new ModelRenderer(model, 326, 229);
				tail3.addBox(0F, 0F, 0F, 7, 7, 20);
				tail3.setRotationPoint(-4F, -4F, 40F);
				tail3.setTextureSize(textureWidth, textureHeight);
				tail3.mirror = true;
				setRotation(tail3, -0.17453292519943295F, 0F, 0F);
				return tail3;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer tail4 = new ModelRenderer(model, 276, 231);
				tail4.addBox(0F, 0F, 0F, 5, 5, 20);
				tail4.setRotationPoint(-3F, 0F, 58F);
				tail4.setTextureSize(textureWidth, textureHeight);
				tail4.mirror = true;
				setRotation(tail4, -0.08726646259971647F, 0F, 0F);
				return tail4;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer tail5 = new ModelRenderer(model, 230, 233);
				tail5.addBox(0F, 0F, 0F, 3, 3, 20);
				tail5.setRotationPoint(-2F, 3F, 77F);
				tail5.setTextureSize(textureWidth, textureHeight);
				tail5.mirror = true;
				setRotation(tail5, 0F, 0F, 0F);
				return tail5;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer tail6 = new ModelRenderer(model, 188, 235);
				tail6.addBox(0F, 0F, 0F, 1, 1, 20);
				tail6.setRotationPoint(-1F, 4F, 96F);
				tail6.setTextureSize(textureWidth, textureHeight);
				tail6.mirror = true;
				setRotation(tail6, 0F, 0F, 0F);
				return tail6;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer neck1 = new ModelRenderer(model, 473, 96);
				neck1.addBox(0F, 0F, 0F, 11, 9, 9);
				neck1.setRotationPoint(-6F, -35F, -36F);
				neck1.setTextureSize(textureWidth, textureHeight);
				neck1.mirror = true;
				setRotation(neck1, -0.5235987755982988F, 0F, 0F);
				return neck1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer neck2 = new ModelRenderer(model, 479, 131);
				neck2.addBox(0F, 0F, 0F, 11, 10, 6);
				neck2.setRotationPoint(-6F, -27F, -23F);
				neck2.setTextureSize(textureWidth, textureHeight);
				neck2.mirror = true;
				setRotation(neck2, -0.5235987755982988F, 0F, 0F);
				return neck2;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer neck3 = new ModelRenderer(model, 477, 114);
				neck3.addBox(0F, 0F, 0F, 9, 8, 9);
				neck3.setRotationPoint(-5F, -31F, -30F);
				neck3.setTextureSize(textureWidth, textureHeight);
				neck3.mirror = true;
				setRotation(neck3, -0.6108652381980153F, 0F, 0F);
				return neck3;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer spike1 = new ModelRenderer(model, 0, 65);
				spike1.addBox(0F, 0F, 0F, 1, 6, 1);
				spike1.setRotationPoint(-1F, -31F, -20F);
				spike1.setTextureSize(textureWidth, textureHeight);
				spike1.mirror = true;
				setRotation(spike1, -0.2617993877991494F, 0F, 0F);
				return spike1;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer spike2 = new ModelRenderer(model, 4, 64);
				spike2.addBox(0F, 0F, 0F, 1, 7, 1);
				spike2.setRotationPoint(-1F, -31F, -13F);
				spike2.setTextureSize(textureWidth, textureHeight);
				spike2.mirror = true;
				setRotation(spike2, -0.2617993877991494F, 0F, 0F);
				return spike2;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer spike3 = new ModelRenderer(model, 8, 63);
				spike3.addBox(0F, 0F, 0F, 1, 8, 1);
				spike3.setRotationPoint(-1F, -31F, -6F);
				spike3.setTextureSize(textureWidth, textureHeight);
				spike3.mirror = true;
				setRotation(spike3, -0.17453292519943295F, 0F, 0F);
				return spike3;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer spike4 = new ModelRenderer(model, 12, 64);
				spike4.addBox(0F, 0F, 0F, 1, 7, 1);
				spike4.setRotationPoint(-1F, -28F, 2F);
				spike4.setTextureSize(textureWidth, textureHeight);
				spike4.mirror = true;
				setRotation(spike4, -0.17453292519943295F, 0F, 0F);
				return spike4;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer spike5 = new ModelRenderer(model, 16, 65);
				spike5.addBox(0F, 0F, 0F, 1, 6, 1);
				spike5.setRotationPoint(-1F, -23F, 10F);
				spike5.setTextureSize(textureWidth, textureHeight);
				spike5.mirror = true;
				setRotation(spike5, -0.2617993877991494F, 0F, 0F);
				return spike5;
			}
		}.get()
);

		body.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer spike6 = new ModelRenderer(model, 20, 67);
				spike6.addBox(0F, 0F, 0F, 1, 4, 1);
				spike6.setRotationPoint(-1F, -18F, 17F);
				spike6.setTextureSize(textureWidth, textureHeight);
				spike6.mirror = true;
				setRotation(spike6, -0.2617993877991494F, 0F, 0F);
				return spike6;
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
				ModelRenderer RightLeg = new ModelRenderer(model);
				RightLeg.setRotationPoint(-5F, 1F, -7F);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer rightleg1 = new ModelRenderer(model, 442, 0);
				rightleg1.addBox(-12F, 0F, 0F, 10, 23, 10);
				rightleg1.setRotationPoint(0F, 0F, 0F);
				rightleg1.setTextureSize(textureWidth, textureHeight);
				rightleg1.mirror = true;
				setRotation(rightleg1, 0F, 0F, 0F);
				return rightleg1;
			}
		}.get()
);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer rightleg2 = new ModelRenderer(model, 482, 0);
				rightleg2.addBox(-8F, 0F, 0F, 8, 22, 7);
				rightleg2.setRotationPoint(-1F, -15F, -4F);
				rightleg2.setTextureSize(textureWidth, textureHeight);
				rightleg2.mirror = true;
				setRotation(rightleg2, -0.08726646259971647F, 0F, 0.08726646259971647F);
				return rightleg2;
			}
		}.get()
);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer rightclaw1 = new ModelRenderer(model, 0, 79);
				rightclaw1.addBox(0F, 0F, 0F, 1, 2, 7);
				rightclaw1.setRotationPoint(-14F, 21F, -6F);
				rightclaw1.setTextureSize(textureWidth, textureHeight);
				rightclaw1.mirror = true;
				setRotation(rightclaw1, 0F, 0.3490658503988659F, 0F);
				return rightclaw1;
			}
		}.get()
);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer rightclaw2 = new ModelRenderer(model, 0, 79);
				rightclaw2.addBox(0F, 0F, 0F, 1, 2, 7);
				rightclaw2.setRotationPoint(-1F, 21F, -6F);
				rightclaw2.setTextureSize(textureWidth, textureHeight);
				rightclaw2.mirror = true;
				setRotation(rightclaw2, 0F, -0.3490658503988659F, 0F);
				return rightclaw2;
			}
		}.get()
);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer rightclaw3 = new ModelRenderer(model, 0, 88);
				rightclaw3.addBox(0F, 0F, 0F, 1, 3, 9);
				rightclaw3.setRotationPoint(-10F, 20F, -8F);
				rightclaw3.setTextureSize(textureWidth, textureHeight);
				rightclaw3.mirror = true;
				setRotation(rightclaw3, 0F, 0.08726646259971647F, 0F);
				return rightclaw3;
			}
		}.get()
);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer rightclaw4 = new ModelRenderer(model, 0, 88);
				rightclaw4.addBox(0F, 0F, 0F, 1, 3, 9);
				rightclaw4.setRotationPoint(-5F, 20F, -8F);
				rightclaw4.setTextureSize(textureWidth, textureHeight);
				rightclaw4.mirror = true;
				setRotation(rightclaw4, 0F, -0.08726646259971647F, 0F);
				return rightclaw4;
			}
		}.get()
);

		RightLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer rightclaw5 = new ModelRenderer(model, 0, 72);
				rightclaw5.addBox(0F, 0F, 0F, 2, 2, 5);
				rightclaw5.setRotationPoint(-8F, 15F, 10F);
				rightclaw5.setTextureSize(textureWidth, textureHeight);
				rightclaw5.mirror = true;
				setRotation(rightclaw5, -0.4363323129985824F, 0F, 0F);
				return rightclaw5;
			}
		}.get()
);
			
				return RightLeg;
			}
		}.get()
);
		legs.add(		new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer LeftLeg = new ModelRenderer(model);
				LeftLeg.setRotationPoint(15F, -14F, -11F);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leftleg2 = new ModelRenderer(model, 482, 0);
				leftleg2.addBox(-8F, 0F, 0F, 8, 22, 7);
				leftleg2.setRotationPoint(0F, 0F, 0F);
				leftleg2.setTextureSize(textureWidth, textureHeight);
				leftleg2.mirror = true;
				setRotation(leftleg2, -0.08726646259971647F, 0F, -0.08726646259971647F);
				return leftleg2;
			}
		}.get()
);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leftleg1 = new ModelRenderer(model, 442, 0);
				leftleg1.addBox(0F, 0F, 0F, 10, 23, 10);
				leftleg1.setRotationPoint(-7F, 15F, 4F);
				leftleg1.setTextureSize(textureWidth, textureHeight);
				leftleg1.mirror = true;
				setRotation(leftleg1, 0F, 0F, 0F);
				return leftleg1;
			}
		}.get()
);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leftclaw2 = new ModelRenderer(model, 0, 79);
				leftclaw2.addBox(0F, 0F, 0F, 1, 2, 7);
				leftclaw2.setRotationPoint(4F, 36F, -2F);
				leftclaw2.setTextureSize(textureWidth, textureHeight);
				leftclaw2.mirror = true;
				setRotation(leftclaw2, 0F, -0.3490658503988659F, 0F);
				return leftclaw2;
			}
		}.get()
);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leftclaw3 = new ModelRenderer(model, 0, 88);
				leftclaw3.addBox(0F, 0F, 0F, 1, 3, 9);
				leftclaw3.setRotationPoint(-5F, 35F, -4F);
				leftclaw3.setTextureSize(textureWidth, textureHeight);
				leftclaw3.mirror = true;
				setRotation(leftclaw3, 0F, 0.08726646259971647F, 0F);
				return leftclaw3;
			}
		}.get()
);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leftclaw1 = new ModelRenderer(model, 0, 79);
				leftclaw1.addBox(0F, 0F, 0F, 1, 2, 7);
				leftclaw1.setRotationPoint(-9F, 36F, -2F);
				leftclaw1.setTextureSize(textureWidth, textureHeight);
				leftclaw1.mirror = true;
				setRotation(leftclaw1, 0F, 0.3490658503988659F, 0F);
				return leftclaw1;
			}
		}.get()
);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leftclaw4 = new ModelRenderer(model, 0, 88);
				leftclaw4.addBox(0F, 0F, 0F, 1, 3, 9);
				leftclaw4.setRotationPoint(0F, 35F, -4F);
				leftclaw4.setTextureSize(textureWidth, textureHeight);
				leftclaw4.mirror = true;
				setRotation(leftclaw4, 0F, -0.08726646259971647F, 0F);
				return leftclaw4;
			}
		}.get()
);

		LeftLeg.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leftclaw5 = new ModelRenderer(model, 0, 72);
				leftclaw5.addBox(0F, 0F, 0F, 2, 2, 5);
				leftclaw5.setRotationPoint(-3F, 30F, 14F);
				leftclaw5.setTextureSize(textureWidth, textureHeight);
				leftclaw5.mirror = true;
				setRotation(leftclaw5, -0.4363323129985824F, 0F, 0F);
				return leftclaw5;
			}
		}.get()
);
			
				return LeftLeg;
			}
		}.get()
);
		wing = 		new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer LeftWing = new ModelRenderer(model);
				LeftWing.setRotationPoint(7F, -23F, -17F);

		LeftWing.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer liftbicep = new ModelRenderer(model, 0, 106);
				liftbicep.addBox(0F, 0F, 0F, 22, 3, 3);
				liftbicep.setRotationPoint(0F, 0F, 0F);
				liftbicep.setTextureSize(textureWidth, textureHeight);
				liftbicep.mirror = true;
				setRotation(liftbicep, 0F, -0.5235987755982988F, 0F);
				return liftbicep;
			}
		}.get()
);

		LeftWing.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leftwing = new ModelRenderer(model, 0, 0);
				leftwing.addBox(0F, 0F, -60F, 110, 0, 60);
				leftwing.setRotationPoint(-1F, 1F, 60F);
				leftwing.setTextureSize(textureWidth, textureHeight);
				leftwing.mirror = true;
				setRotation(leftwing, 0F, 0F, 0F);
				return leftwing;
			}
		}.get()
);

		LeftWing.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer leftforearm = new ModelRenderer(model, 0, 102);
				leftforearm.addBox(0F, 0F, -2F, 24, 2, 2);
				leftforearm.setRotationPoint(18F, 0F, 13F);
				leftforearm.setTextureSize(textureWidth, textureHeight);
				leftforearm.mirror = true;
				setRotation(leftforearm, 0F, 0.6981317007977318F, 0F);
				return leftforearm;
			}
		}.get()
);

		LeftWing.addChild(new ModelRendererFactory() {
			@Override
			public ModelRenderer get() {
				ModelRenderer lefthook = new ModelRenderer(model, 0, 100);
				lefthook.addBox(0F, 0F, 0F, 5, 1, 1);
				lefthook.setRotationPoint(35F, 0.5F, -3.5F);
				lefthook.setTextureSize(textureWidth, textureHeight);
				lefthook.mirror = true;
				setRotation(lefthook, 0F, 0F, 0F);
				return lefthook;
			}
		}.get()
);
			
				return LeftWing;
			}
		}.get()
;
	}
}