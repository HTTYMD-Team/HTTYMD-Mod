package com.httymd.item;

import java.util.List;

import com.httymd.api.item.WeaponType;
import com.httymd.creativetab.CreativeTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Base Item class for Hiccup's Inferno
 *
 * @author George Albany
 *
 */
public class ItemFlameSword extends ItemWeapon {

	public static final String DISABLED_SUFFIX = "_disabled";
	private static final String NBT_ISON = "IsOn";

	protected float defaultDamage;

	@SideOnly(Side.CLIENT)
	private IIcon disabledIcon;
	@SideOnly(Side.CLIENT)
	private IIcon defaultIcon;

	public ItemFlameSword(ToolMaterial toolMaterial, WeaponType type) {
		super(type.getName(), toolMaterial, type.getDamage(), CreativeTab.DRAGON_TAB);
		this.defaultDamage = this.attackDamage;
	}

	/**
	 * Creates an explosion usable by this item
	 */
	private void explode(World world, Entity entity, float explosionSize) {
		world.createExplosion(entity, entity.posX, entity.posY, entity.posZ, explosionSize, false);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int pass) {
		if (this.isToggled(stack))
			return this.defaultIcon;
		else
			return this.disabledIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack stack) {
		if (this.isToggled(stack))
			return this.defaultIcon;
		else
			return this.disabledIcon;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		ItemStack is;
		for (int i = 0; i < 1; i++) {
			is = new ItemStack(item, 1);
			this.onToggle(is, false);
			list.add(is);
		}
	}

	/**
	 * Determines if ItemStack is toggled based on NBT
	 */
	public boolean isToggled(ItemStack stack) {
		if (stack.getItem() instanceof ItemFlameSword && stack.hasTagCompound())
			return stack.getTagCompound().getBoolean(NBT_ISON);
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player.isSneaking()) {
			if (!world.isRemote)
				this.explode(world, player, 2F);
		} else {
			world.playSoundAtEntity(player, "mob.sheep.shear", 2.0F, 1F);
			this.onToggle(stack, !this.isToggled(stack));
		}
		return super.onItemRightClick(stack, world, player);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (this.isToggled(stack)) entity.setFire(60);
		return super.onLeftClickEntity(stack, player, entity);
	}

	/**
	 * Sets toggle for ItemStack
	 */
	public void onToggle(ItemStack stack, boolean toggle) {
		if (!(stack.getItem() instanceof ItemFlameSword))
			return;
		if (!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setBoolean(NBT_ISON, toggle);
		this.attackDamage = toggle ? this.defaultDamage : 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister registry) {
		super.registerIcons(registry);
		this.defaultIcon = this.itemIcon;
		this.disabledIcon = registry.registerIcon(this.getIconString() + DISABLED_SUFFIX);
	}
}
