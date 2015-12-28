package com.httymd.item;

import com.httymd.item.util.ItemUtils;
import com.httymd.util.Utils;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Optional.Interface;
import cpw.mods.fml.common.Optional.InterfaceList;
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
@InterfaceList(value = {
		@Interface(iface = "mods.battlegear2.api.shield.IShield", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.shield.IArrowCatcher", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.shield.IArrowDisplay", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.IEnchantable", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.ISheathed", modid = Utils.bg2Id, striprefs = true) 
})
public class ItemShield extends ItemExtension
		implements IFuelHandler, mods.battlegear2.api.shield.IShield, mods.battlegear2.api.shield.IArrowCatcher,
		mods.battlegear2.api.shield.IArrowDisplay, mods.battlegear2.api.IEnchantable, mods.battlegear2.api.ISheathed {

	private static final String NBT_ARROW_COUNT = "ArrowCount";

	private IIcon backIcon;
	private IIcon trimIcon;

	protected final float damDecay;
	protected final float natDecay;

	private Item.ToolMaterial material = null;

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

	public void blockAnimation(EntityPlayer player, float dmg) {
		player.worldObj.playSoundAtEntity(player, "battlegear2:shield", 1, 1);
	}

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

	public int getBashTimer(ItemStack arg0) {
		return Utils.shouldUseBg2() ? 15 : 0;
	}

	public float getBlockAngle(ItemStack arg0) {
		return 60;
	}

	public float getDamageDecayRate(ItemStack shield, float amt) {
		return damDecay * amt;
	}

	public float getDamageReduction(ItemStack arg0, DamageSource arg1) {
		return 0;
	}

	public float getDecayRate(ItemStack shield) {
		int use = 0;
		if (Utils.shouldUseBg2()) {
			use = mods.battlegear2.api.EnchantmentHelper
				.getEnchantmentLevel(mods.battlegear2.enchantments.BaseEnchantment.shieldUsage, shield);
			return this.natDecay * (1 - use * 0.1F);
		}
		return use;
	}

	public float getRecoveryRate(ItemStack shield) {
		int recover = 0;
		if (Utils.shouldUseBg2()) {
			recover = mods.battlegear2.api.EnchantmentHelper
				.getEnchantmentLevel(mods.battlegear2.enchantments.BaseEnchantment.shieldRecover, shield);
			return 0.01F * (1 + recover * 0.2F);// should take 5 seconds to fully  recover without enchantment
		}
		return recover;
	}

	public int getArrowCount(ItemStack stack) {
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey(NBT_ARROW_COUNT))
			return stack.getTagCompound().getShort(NBT_ARROW_COUNT);
		return 0;
	}

	public void setArrowCount(ItemStack stack, int count) {
		if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		// Should never happen, you would need A LOT of arrows for this to happen
		if (count > Short.MAX_VALUE) count = Short.MAX_VALUE;
		stack.getTagCompound().setShort(NBT_ARROW_COUNT, (short) count);
	}

	public boolean catchArrow(ItemStack shield, EntityPlayer player, IProjectile arrow) {
		if (arrow instanceof EntityArrow) {
			setArrowCount(shield, getArrowCount(shield) + 1);
			player.setArrowCountInEntity(player.getArrowCountInEntity() - 1);
			((EntityArrow) arrow).setDead();
			return true;
		}
		return false;
	}

	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == this) {
			return this.material.equals(ToolMaterial.WOOD) ? 300 : 200;
		}
		return 0;
	}

	public boolean sheatheOnBack(ItemStack shield) {
		return true;
	}

	public boolean isEnchantable(Enchantment ench, ItemStack shield) {
		return ench.type == EnumEnchantmentType.all;
	}

	public int getItemEnchantability(ItemStack shield) {
		return this.hasMaterial() ? this.getMaterial().getEnchantability() : 1;
	}

	public boolean getIsRepairable(ItemStack itemStack, ItemStack repair) {
		return this.material.customCraftingMaterial == repair.getItem();
	}
}
