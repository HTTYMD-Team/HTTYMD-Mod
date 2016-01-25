package com.httymd.bg2.item;

import com.google.common.collect.Multimap;
import com.httymd.HTTYMDMod;
import com.httymd.api.item.WeaponType;
import com.httymd.item.ItemWeapon;
import com.httymd.util.Utils;

import cpw.mods.fml.common.Optional.Interface;
import cpw.mods.fml.common.Optional.InterfaceList;
import cpw.mods.fml.common.Optional.Method;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

/**
 * A Battlegear 2 manipulator extension of {@link ItemWeapon} for daggers
 * 
 * @author George Albany
 *
 */
@InterfaceList(value={
		@Interface(iface = "mods.battlegear2.api.weapons.IBattlegearWeapon", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.weapons.IBackStabbable", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.weapons.IHitTimeModifier", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.weapons.IExtendedReachWeapon", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.weapons.Attributes", modid = Utils.bg2Id, striprefs = true)
})
public class ItemDaggerBg2 extends ItemWeapon 
		implements mods.battlegear2.api.weapons.IBattlegearWeapon, mods.battlegear2.api.weapons.IBackStabbable, 
		mods.battlegear2.api.weapons.IHitTimeModifier, mods.battlegear2.api.weapons.IExtendedReachWeapon,
		mods.battlegear2.api.weapons.Attributes {
	
	protected final float hitTime = 0.5F;
	protected final float reach = -2;
	
	public ItemDaggerBg2(ToolMaterial weaponMat, String name, float weaponDam, CreativeTabs tab) {
		super(weaponMat, name, weaponDam, tab);
	}
	
	public ItemDaggerBg2(ToolMaterial weaponMat, String name, float weaponDam) {
		this(weaponMat, name, weaponDam, HTTYMDMod.getCreativeTab());
	}
	
	public ItemDaggerBg2(ToolMaterial mat) {
		this(mat, WeaponType.DAGGER.getName(), WeaponType.DAGGER.getDamage());
	}
	
	public boolean onBackStab(EntityLivingBase entityHit, EntityLivingBase entityHitting) {
		if(!Utils.shouldForceBg2Daggers()) return false;
		return entityHit.attackEntityFrom(new EntityDamageSource(mods.battlegear2.Battlegear.CUSTOM_DAMAGE_SOURCE+".backstab", entityHitting), this.attackDamage);
	}

	public float getReachModifierInBlocks(ItemStack stack) {
		return getModifiedAmount(stack, Utils.shouldForceBg2Daggers() ? extendedReach.getAttributeUnlocalizedName() : "");
	}

	public int getHitTime(ItemStack stack, EntityLivingBase arg1) {
		return -(int)getModifiedAmount(stack, Utils.shouldForceBg2Daggers() ? attackSpeed.getAttributeUnlocalizedName() : "");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Multimap getAttributeModifiers(ItemStack stack) {
		Multimap map = super.getAttributeModifiers(stack);
		if(Utils.shouldForceBg2Daggers()) {
			map.put(extendedReach.getAttributeUnlocalizedName(), 
					new AttributeModifier(extendReachUUID, "Reach Modifier", this.reach, 0));
			map.put(attackSpeed.getAttributeUnlocalizedName(), 
					new AttributeModifier(attackSpeedUUID, "Speed Modifier", this.hitTime, 1));
		}
		return map;
	}

	public boolean sheatheOnBack(ItemStack arg0) {
		return false;
	}

	public boolean isOffhandHandDual(ItemStack arg0) {
		return true;
	}

	@Method(modid = Utils.bg2Id)
	public boolean offhandAttackEntity(mods.battlegear2.api.PlayerEventChild.OffhandAttackEvent arg0, ItemStack arg1, ItemStack arg2) {
		return true;
	}

	public boolean offhandClickAir(PlayerInteractEvent arg0, ItemStack arg1, ItemStack arg2) {
		return true;
	}

	public boolean offhandClickBlock(PlayerInteractEvent arg0, ItemStack arg1, ItemStack arg2) {
		return true;
	}

	public void performPassiveEffects(Side arg0, ItemStack arg1, ItemStack arg2) {		
	}

	public boolean allowOffhand(ItemStack arg0, ItemStack arg1) {
		return true;
	}
}
