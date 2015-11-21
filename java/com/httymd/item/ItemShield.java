package com.httymd.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

public class ItemShield extends ItemExtension {

	private static final String NBT_DAMAGE_REDUCER = "DamageReduce";

	public static float getDamageReduction(ItemStack stack) {
		if (stack.getItem() instanceof ItemShield) {
			ItemShield shield = (ItemShield) stack.getItem();
			return shield.defDamageReduction
					+ (stack.getTagCompound() != null ? stack.getTagCompound().getFloat(NBT_DAMAGE_REDUCER) : 0);
		}

		return 0;
	}

	public static float reduceDamage(EntityLivingBase entity, ItemStack stack, DamageSource source, float amount) {
		if (!(stack.getItem() instanceof ItemShield))
			return amount;

		if (source instanceof EntityDamageSource && !source.isUnblockable()) {
			float reduce = getDamageReduction(stack);

			if (source.isProjectile()) {
				reduce -= 0.5;
				reduce = Math.max((float) 0.5, reduce);
			}

			if (source.isMagicDamage())
				reduce *= 0.25;

			if (source.isFireDamage())
				reduce *= 1.50;

			amount -= reduce;
		}

		amount = Math.max(amount, 0);

		stack.damageItem(1, entity);

		return amount;
	}

	public static void setExtraDamageReduction(ItemStack stack, float reduction) {
		if (stack.getItem() instanceof ItemShield) {
			NBTTagCompound tag = stack.getTagCompound() != null ? stack.getTagCompound() : new NBTTagCompound();
			tag.setFloat(NBT_DAMAGE_REDUCER, reduction);
			stack.setTagCompound(tag);
		}
	}

	protected final float defDamageReduction;

	private Item.ToolMaterial material = null;

	public ItemShield(String name, float damageReduction) {
		super("shield_" + name);
		this.setFull3D();
		this.setMaxStackSize(1);
		this.defDamageReduction = damageReduction;
	}

	public ItemShield(String name, Item.ToolMaterial material) {
		this(name, (float) ((material.getDamageVsEntity() + 4) * 0.75));
		this.material = material;
	}

	public Item.ToolMaterial getMaterial() {
		return this.material;
	}

	public boolean hasMaterial() {
		return this.material != null;
	}

}
