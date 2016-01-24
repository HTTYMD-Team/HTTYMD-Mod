package com.httymd.item;

import com.httymd.HTTYMDMod;
import com.httymd.client.model.ModelGlideSuit;
import com.httymd.item.util.ItemUtils.EnumArmorType;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;

/**
 * The Item class for Hiccup's Glide Suit in HTTYD
 * 
 * @author George Albany,<br>Stephan Spengler
 *
 */
public class ItemGlideArmor extends ItemArmorExtension {

	public static final String NBT_GLIDING = "IsGliding";
	public static final String NBT_PREVENT_FALLDAM = "PreventFallDamage";

	public ItemGlideArmor(String name, ArmorMaterial mat, int type) {
		super(name, mat, type);
		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * Returns the required slot sections for flight
	 */
	public EnumArmorType[] getRequiredSlotsForFlight() {
		return new EnumArmorType[] { EnumArmorType.CHESTPLATE, EnumArmorType.LEGGINGS };
	}

	private boolean isInLiquid(EntityLivingBase entity) {
		return entity.worldObj.getBlock(MathHelper.floor_double(entity.posX), MathHelper.floor_double(entity.posY),
				MathHelper.floor_double(entity.posZ)).getMaterial().isLiquid();
	}

	/**
	 * Determines if the glide suit enables the ability to glide on an entity
	 * @param entity The entity to check
	 */
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

	/**
	 * Whether an entity's item can glide, for anything not covered in {@link #isFlyable(EntityLivingBase)}
	 * @param entity The entity to check
	 * @param stack The itemstack to check
	 */
	public boolean canGlide(EntityLivingBase entity, ItemStack stack) {
		boolean canGlide = this.isFlyable(entity) && (this.isGliding(stack)
				|| (entity.motionY < -1.0 && entity.moveForward >= 0.1 && entity.isSneaking()));
		this.setGliding(stack, canGlide);
		if (canGlide) {
			for (int i = 1; i <= 4; i++) {
				ItemStack armor = entity.getEquipmentInSlot(i);
				this.setGliding(armor, true);
			}
		}
		return canGlide;
	}

	/**
	 * Determines whether an itemstack has the {@link #NBT_GLIDING} boolean enabled
	 * @param stack The itemstack to check
	 */
	public boolean isGliding(ItemStack stack) {
		if (stack == null || !(stack.getItem() instanceof ItemGlideArmor) || !stack.hasTagCompound())
			return false;
		return stack.getTagCompound().getBoolean(NBT_GLIDING);
	}

	/**
	 * Sets the the {@link #NBT_GLIDING} boolean
	 * @param stack The stack to set on
	 * @param gliding The boolean to set {@link #NBT_GLIDING} as
	 */
	public void setGliding(ItemStack stack, boolean gliding) {
		if (stack == null || !(stack.getItem() instanceof ItemGlideArmor))
			return;
		if (!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setBoolean(NBT_GLIDING, gliding);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		this.onArmorTick(world, (EntityLivingBase) player, stack);
	}

	/**
	 * For manipulation outside of just player ticks, for anything to be covered by {@link #onArmorTick(World, EntityPlayer, ItemStack)}
	 * @param world The world this event takes place in
	 * @param entity The entity wearing the armor
	 * @param stack The itemstack of armor
	 */
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
		this.setGliding(stack, false);
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
	
	/**
	 * An event management method for disabling fall damage in certain cases
	 */
	@SubscribeEvent
	public void onFall(LivingFallEvent event) {
		ItemStack boots = event.entityLiving.getEquipmentInSlot(EnumArmorType.BOOTS.ordinal()+1);
		if(boots != null && boots.getItem() instanceof ItemGlideArmor) {
			event.setCanceled(true);
		}
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