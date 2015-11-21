package com.httymd.item;

import java.util.List;

import com.httymd.client.model.ModelGlideSuit;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class ItemGlideArmor extends ItemArmorExtension implements ISpecialArmor {

	public static final String NBT_FLYING = "IsGliding";

	public static void setGliding(ItemStack stack, boolean gliding) {
		if (!(stack.getItem() instanceof ItemGlideArmor))
			return;
		if (!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setBoolean(NBT_FLYING, gliding);
	}

	public ItemGlideArmor(String name, ArmorMaterial mat, int type) {
		super(name, mat, type);
	}

	public boolean canGlide(EntityLivingBase entity, ItemStack stack) {
		boolean flag = this.isFlyable(entity)
				&& (entity.motionY < -1.0 && entity.moveForward >= 0.1 && entity.isSneaking() || this.isGliding(stack));
		return flag;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack armor, DamageSource source, int damage, int slot) {
		if (source == DamageSource.fall && this.canGlide(entity, armor))
			return;
		armor.damageItem(damage, entity);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		if (this.isGliding(itemStack))
			if (armorSlot == 2)
				return new ModelGlideSuit(new ModelBiped(1.0F));
			else
				return new ModelGlideSuit(new ModelBiped(0.5F));
		return super.getArmorModel(entityLiving, itemStack, armorSlot);
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase entity, ItemStack armor, DamageSource source, double damage,
			int slot) {
		if (source == DamageSource.fall && this.canGlide(entity, armor))
			return new ArmorProperties(1, 1, 1);
		return new ArmorProperties(0, this.damageReduceAmount / 25D, this.getMaxDamage() + 1 - armor.getItemDamage());
	}

	protected int[] getRequiredSlotsForFlight() {
		return new int[] { 1, 2 };
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 1; i++) {
			ItemStack is = new ItemStack(item, 1);
			list.add(is);
		}
	}

	public boolean isFlyable(EntityLivingBase entity) {
		boolean flag = entity != null && !entity.onGround && !entity.isInWater()
				&& !entity.isInsideOfMaterial(Material.lava);

		if (entity instanceof EntityPlayer)
			flag = flag && !((EntityPlayer) entity).capabilities.isFlying;

		for (int slot : this.getRequiredSlotsForFlight()) {
			ItemStack armor = entity.getEquipmentInSlot(slot + 1);
			flag = flag && armor != null && armor.getItem() instanceof ItemGlideArmor;
		}
		return flag;
	}

	public boolean isGliding(ItemStack stack) {
		boolean flag;
		if (!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
			return false;
		} else
			flag = stack.getTagCompound().getBoolean(NBT_FLYING);
		return flag;
	}

	public void onArmorTick(World world, EntityLivingBase entity, ItemStack stack) {
		boolean canGlide = this.canGlide(entity, stack);
		setGliding(stack, canGlide);
		if (canGlide) {
			entity.motionX = -(Math.sin(Math.toRadians(entity.getRotationYawHead())) * ((2 + entity.moveForward) / 3));
			entity.motionZ = Math.cos(Math.toRadians(entity.getRotationYawHead())) * ((2 + entity.moveForward) / 3);
			if (entity.motionY < -0.2)
				entity.motionY /= 2;
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).stopUsingItem();
		} else if (entity instanceof EntityPlayer)
			super.onArmorTick(world, (EntityPlayer) entity, stack);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		this.onArmorTick(world, (EntityLivingBase) player, stack);
	}

	public boolean onDroppedByPlayer(ItemStack stack, EntityPlayer player) {
		setGliding(stack, false);
		return super.onDroppedByPlayer(stack, player);
	}

	public void onUpdate(ItemStack stack, World world, Entity holder, int p_77663_4_, boolean p_77663_5_) {
		if (!(holder instanceof EntityLivingBase) || !this.canGlide((EntityLivingBase) holder, stack))
			setGliding(stack, false);
		super.onUpdate(stack, world, holder, p_77663_4_, p_77663_5_);
	}
}
