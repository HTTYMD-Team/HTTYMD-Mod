package com.httymd.item;

import java.util.List;

import com.httymd.HTTYMDMod;
import com.httymd.api.entity.DragonProductType;
import com.httymd.api.item.IContainer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Container Item for most dragon byproducts
 * 
 * @author George Albany
 */
public class ItemContainer extends ItemExtension implements IContainer {
	
	public static final String NBT_CONTENT_AMOUNT = HTTYMDMod.ID+".ContentAmount";
	
	protected int maxContents;

	public ItemContainer(String name, int maxContents) {
		super(name);
		this.maxContents = maxContents;
	}

	@Override
	public int getMax() {
		return this.maxContents;
	}

	@Override
	public int getContained(ItemStack stack) {		
		return stack.hasTagCompound() ? stack.getTagCompound().getInteger(NBT_CONTENT_AMOUNT) : 0;
	}

	@Override
	public void setContained(ItemStack stack, int contents) {
		if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setInteger(NBT_CONTENT_AMOUNT, contents);
	}

	@Override
	public void setContainedType(ItemStack stack, DragonProductType type) {
		if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		type.writeToNBT(stack.getTagCompound());
	}

	@Override
	public DragonProductType getContainedType(ItemStack stack) {
		return DragonProductType.readFromNBT(stack.getTagCompound());
	}

	@Override
	public void resetContained(ItemStack stack) {
		this.setContained(stack, 0);
		this.setContainedType(stack, null);
	}

	@Override
	public ItemStack createEmptyStack() {
		ItemStack stack = new ItemStack(this);
		this.resetContained(stack);
		return stack;
	}
	
	@SuppressWarnings("rawtypes")
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean p_77624_4_) {
		
	}
}
