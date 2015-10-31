package com.httymd.item;

import com.httymd.util.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;

public class ItemContainer extends ItemExtension {

	public final Class<? extends Entity> produceHolder;
	protected float maxHoldable;

	public ItemContainer(String name, float maxHoldable, Class<? extends Entity> produceHolder) {
		super(name);
		this.produceHolder = produceHolder;
		this.maxHoldable = maxHoldable;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (entity.getClass() == produceHolder) {
			float currentHeld = getProduceHeld(stack);
			if (currentHeld < maxHoldable) {
				currentHeld += player.getRNG().nextFloat();
				currentHeld = MathHelper.clamp_float(currentHeld, 0.0F, maxHoldable);
				setProduceHeld(stack, currentHeld);
				return true;
			}
		}

		return super.onLeftClickEntity(stack, player, entity);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List textList, boolean p_77624_4_) {
		String text = EnumChatFormatting.DARK_PURPLE + "" + EnumChatFormatting.ITALIC
				+ Utils.getLocalString(getRegistryName() + ".produceType") + ": ";
		if (hasProduce(stack)) {
			text += getProduceHeld(stack) + " " + Utils.getLocalString("itemNBT.milliliter");
		} else {
			text += Utils.getLocalString("itemNBT.empty");
		}

		textList.add(text);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 1; i++) {
			ItemStack is = new ItemStack(item, 1);
			resetProduce(is);
			list.add(is);
		}
	}

	public static float getMaxHoldable(ItemStack stack) {
		Item item = stack.getItem();
		if (item instanceof ItemContainer) {
			ItemContainer cont = (ItemContainer) item;
			return cont.maxHoldable;
		}
		return -1.0F;
	}

	public static boolean hasProduce(ItemStack stack) {
		return getProduceHeld(stack) > 0.0F;
	}

	public static void setProduceHeld(ItemStack stack, float amount) {
		if (stack.hasTagCompound()) {
			stack.getTagCompound().setFloat("ProduceHeld", amount);
		} else {
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setFloat("ProduceHeld", amount);
			stack.setTagCompound(nbt);
		}
	}

	public static float getProduceHeld(ItemStack stack) {
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("ProduceHeld")) {
			return stack.getTagCompound().getFloat("ProduceHeld");
		}
		return 0.0F;
	}

	public static void resetProduce(ItemStack stack) {
		setProduceHeld(stack, 0.0F);
	}

	public ItemStack getEmptyContainer() {
		ItemStack stack = new ItemStack(this);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setFloat("ProduceHeld", 0.0F);
		stack.setTagCompound(tag);
		return stack;
	}

}
