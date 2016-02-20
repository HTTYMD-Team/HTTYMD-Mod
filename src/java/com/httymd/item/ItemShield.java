package com.httymd.item;

import com.httymd.api.item.IShield;
import com.httymd.util.AddonUtils.Battlegear2;
import com.httymd.util.ItemUtils;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;

/**
 * A Shield item class, that heavily manipulates Battlegear 2 (only class to be left in com.httymd.item
 * package that heavily manipulates Battlegear 2)
 *
 * @author George Albany
 *
 */
public class ItemShield extends ItemExtension implements IFuelHandler, IShield {

	private IIcon backIcon;
	private IIcon trimIcon;

	protected final float damDecay;
	protected final float natDecay;

	private Item.ToolMaterial material;

	public ItemShield(String name, float decay, float damDecay, int maxDam) {
		super("shield_" + name);
		this.setFull3D();
		this.setMaxDamage(maxDam);
		this.setMaxStackSize(1);
		this.setHasSubtypes(false);
		this.natDecay = decay;
		this.damDecay = damDecay;
		GameRegistry.registerFuelHandler(this);
	}

	public ItemShield(String suffix, Item.ToolMaterial material) {
		this(material.toString().toLowerCase() + suffix, 1F / (material.getDamageVsEntity() + 1F) / 20F,
				1F / (material.getDamageVsEntity() + 19), material.getMaxUses());
		this.material = material;
	}

	public ItemShield(Item.ToolMaterial material) {
		this("", material);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		super.registerIcons(par1IconRegister);
		backIcon = par1IconRegister.registerIcon(ItemUtils.findTextureName(this.getUnlocalizedName()) + "_back");
		trimIcon = par1IconRegister.registerIcon(ItemUtils.findTextureName(this.getUnlocalizedName()) + "_trim");
	}

	public IIcon getBackIcon() {
		return this.backIcon;
	}

	public IIcon getTrimIcon() {
		return this.trimIcon;
	}

	public Item.ToolMaterial getMaterial() {
		return this.material;
	}

	public boolean hasMaterial() {
		return this.material != null;
	}

	@Override
	public void blockAnimation(EntityPlayer player, float dmg) {
		player.worldObj.playSoundAtEntity(player, "battlegear2:shield", 1, 1);
	}

	@Override
	public boolean canBlock(ItemStack stack, DamageSource src) {
		float chance = 1F;
		if (src.isProjectile())
			chance *= 1.1F; // If projectile, add 10% to block chance
		if (src.isMagicDamage())
			chance *= 0.75; // If magic, decrease the block chance to 75%
		if (src.isFireDamage())
			chance *= 1.2; // If fire, add 20% to block chance
		return itemRand.nextFloat() <= chance && !src.isUnblockable();
	}

	@Override
	public int getBashTimer(ItemStack arg0) {
		return Battlegear2.shouldUse() ? 15 : 0;
	}

	@Override
	public float getBlockAngle(ItemStack arg0) {
		return 60;
	}

	@Override
	public float getDamageDecayRate(ItemStack shield, float amt) {
		return damDecay * amt;
	}

	@Override
	public float getDamageReduction(ItemStack arg0, DamageSource arg1) {
		return 0;
	}

	@Override
	public float getDecayRate(ItemStack shield) {
		int use = 0;
		if (Battlegear2.shouldUse()) {
			use = mods.battlegear2.api.EnchantmentHelper
					.getEnchantmentLevel(mods.battlegear2.enchantments.BaseEnchantment.shieldUsage, shield);
			return this.natDecay * (1 - use * 0.1F);
		}
		return use;
	}

	@Override
	public float getRecoveryRate(ItemStack shield) {
		int recover = 0;
		if (Battlegear2.shouldUse()) {
			recover = mods.battlegear2.api.EnchantmentHelper
					.getEnchantmentLevel(mods.battlegear2.enchantments.BaseEnchantment.shieldRecover, shield);
			return 0.01F * (1 + recover * 0.2F);// should take 5 seconds to fully  recover without enchantment
		}
		return recover;
	}

	@Override
	public int getArrowCount(ItemStack stack) {
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey(NBT_ARROW_COUNT))
			return stack.getTagCompound().getInteger(NBT_ARROW_COUNT);
		return 0;
	}

	@Override
	public void setArrowCount(ItemStack stack, int count) {
		if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		// Should never happen, you would need A LOT of arrows for this to happen
		if (count > Short.MAX_VALUE) count = Short.MAX_VALUE;
		stack.getTagCompound().setInteger(NBT_ARROW_COUNT, count);
	}

	@Override
	public boolean catchArrow(ItemStack shield, EntityPlayer player, IProjectile arrow) {
		if (arrow instanceof EntityArrow) {
			setArrowCount(shield, getArrowCount(shield) + 1);
			player.setArrowCountInEntity(player.getArrowCountInEntity() - 1);
			((EntityArrow) arrow).setDead();
			return true;
		}
		return false;
	}

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == this) {
			return this.material.equals(ToolMaterial.WOOD) ? 300 : 200;
		}
		return 0;
	}

	@Override
	public boolean sheatheOnBack(ItemStack shield) {
		return true;
	}

	@Override
	public boolean isEnchantable(Enchantment ench, ItemStack shield) {
		return ench.type == EnumEnchantmentType.all;
	}

	@Override
	public int getItemEnchantability(ItemStack shield) {
		return this.hasMaterial() ? this.getMaterial().getEnchantability() : 1;
	}

	@Override
	public boolean getIsRepairable(ItemStack itemStack, ItemStack repair) {
		return this.material.customCraftingMaterial == repair.getItem();
	}
}
