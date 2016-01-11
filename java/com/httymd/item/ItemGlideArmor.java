package com.httymd.item;

import com.httymd.HTTYMDMod;
import com.httymd.client.model.ModelGlideSuit;
import com.httymd.item.util.ItemUtils.EnumArmorType;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class ItemGlideArmor extends ItemArmorExtension implements ISpecialArmor {

	public static final String NBT_GLIDING = "IsGliding";

	public ItemGlideArmor(String name, ArmorMaterial mat, int type) {
		super(name, mat, type);
	}

	public EnumArmorType[] getRequiredSlotsForFlight() {
		return new EnumArmorType[] { EnumArmorType.CHESTPLATE, EnumArmorType.LEGGINGS };
	}

	private boolean isInLiquid(EntityLivingBase entity) {
		return entity.worldObj.getBlock(MathHelper.floor_double(entity.posX), MathHelper.floor_double(entity.posY),
				MathHelper.floor_double(entity.posZ)).getMaterial().isLiquid();
	}

	public boolean isFlyable(EntityLivingBase entity) {
		boolean flag = entity != null && (!entity.onGround && !this.isInLiquid(entity));

		if (entity instanceof EntityPlayer)
			flag = flag && !((EntityPlayer) entity).capabilities.isFlying;
		flag = flag && !entity.isRiding() && entity.riddenByEntity == null;

		for (EnumArmorType slot : this.getRequiredSlotsForFlight()) {
			ItemStack armor = entity.getEquipmentInSlot(slot.ordinal() + 1);
			flag = flag && (armor != null && armor.getItem() instanceof ItemGlideArmor);
		}
		return flag;
	}

	public boolean canGlide(EntityLivingBase entity, ItemStack stack) {
		boolean canGlide = this.isFlyable(entity) && (this.isGliding(stack)
				|| (entity.motionY < -1.0 && entity.moveForward >= 0.1 && entity.isSneaking()));
		this.setGliding(stack, canGlide);
		if (canGlide) {
			for (int i = 1; i <= 4; i++) {
				ItemStack armor = entity.getEquipmentInSlot(i);
				if (armor != null && armor.getItem() instanceof ItemGlideArmor)
					((ItemGlideArmor) armor.getItem()).setGliding(armor, true);
			}
		}
		return canGlide;
	}

	public boolean isGliding(ItemStack stack) {
		if (stack == null)
			return false;
		if (!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
			return this.isGliding(stack);
		} else
			return stack.getTagCompound().getBoolean(NBT_GLIDING);
	}

	public void setGliding(ItemStack stack, boolean gliding) {
		if (!(stack.getItem() instanceof ItemGlideArmor))
			return;
		if (!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setBoolean(NBT_GLIDING, gliding);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		this.onArmorTick(world, (EntityLivingBase) player, stack);
	}

	public void onArmorTick(World world, EntityLivingBase entity, ItemStack stack) {
		boolean canGlide = this.canGlide(entity, stack);
		if (canGlide) {
			entity.motionX = -(Math.sin(Math.toRadians(entity.getRotationYawHead())) * ((2 + entity.moveForward) / 3));
			entity.motionZ = (Math.cos(Math.toRadians(entity.getRotationYawHead())) * ((2 + entity.moveForward) / 3));
			if (entity.motionY < -0.2) {
				entity.motionY /= 2;
			}
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).stopUsingItem();
		} else {
			if (entity instanceof EntityPlayer)
				super.onArmorTick(world, (EntityPlayer) entity, stack);
		}
	}

	public boolean onDroppedByPlayer(ItemStack stack, EntityPlayer player) {
		setGliding(stack, false);
		return super.onDroppedByPlayer(stack, player);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		if (this.isGliding(itemStack)) {
			if (armorSlot == EnumArmorType.LEGGINGS.ordinalReverse()) { // For some reason, armorSlot is the opposite of PlayerInventory.armorInventory
				return new ModelGlideSuit(0.5F);
			} else {
				return new ModelGlideSuit(1.0F);
			}
		}
		return super.getArmorModel(entityLiving, itemStack, armorSlot);
	}
	
	@Override
	public ArmorProperties getProperties(EntityLivingBase entity, ItemStack armor, DamageSource source, double damage,
			int slot) {
		if (source.equals(DamageSource.fall) && slot == EnumArmorType.BOOTS.ordinal())
			return new ArmorProperties(0, 1, Integer.MAX_VALUE);
		
		return new ArmorProperties(0, this.damageReduceAmount / 25D, armor.getMaxDamage() + 1 - armor.getItemDamage());
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return this.damageReduceAmount;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack armor, DamageSource source, int damage, int slot) {
		if (source.equals(DamageSource.fall))
			return;
		armor.damageItem(damage, entity);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (this.isGliding(stack) && "fins".equals(type)) {
			return HTTYMDMod.ID + ":textures/armor/"
					+ this.getRegistryName().substring(0, getRegistryName().lastIndexOf("_")) + "_fins.png";
		}
		return super.getArmorTexture(stack, entity, slot, type);
	}
}