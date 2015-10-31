package com.httymd.client.model;

import com.httymd.client.render.RenderGlide;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGlideSuit extends RenderGlide.ModelGlide {

    ModelRenderer LeftWing;
    ModelRenderer RightWing;
    ModelRenderer BackFin;
    
    public ModelGlideSuit(ModelBiped baseModel) {
        super(baseModel);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LeftWing = new ModelRenderer(this, 0, 32);
        this.LeftWing.setRotationPoint(3.0F, 2.0F, 0.0F);
        this.LeftWing.addBox(0.0F, 0.0F, 0.0F, 9, 15, 0, 0.0F);
        this.RightWing = new ModelRenderer(this, 0, 32);
        this.RightWing.mirror = true;
        this.RightWing.setRotationPoint(-2.0F, 2.0F, 0.0F);
        this.RightWing.addBox(-11.0F, 0.0F, 0.0F, 9, 15, 0, 0.0F);
        /*BackFin = new ModelRenderer(this, 42, 48);
        BackFin.addBox(0F, 0F, 0F, 0, 9, 7);
        BackFin.setRotationPoint(0F, 1F, 2F);
        BackFin.setTextureSize(128, 64);
        BackFin.mirror = true;
        setRotation(BackFin, -0.4537856F, 0F, 0F);*/
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        
        LeftWing.render(f5);
        RightWing.render(f5);
        //BackFin.render(f5);
    }

    @SuppressWarnings("unused")
	private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}
