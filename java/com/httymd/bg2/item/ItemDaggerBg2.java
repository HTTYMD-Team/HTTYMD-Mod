package com.httymd.bg2.item;

import com.google.common.collect.Multimap;
import com.httymd.HTTYMDMod;
import com.httymd.item.ItemWeapon;
import com.httymd.item.util.EnumWeaponType;
import com.httymd.util.Utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;

/**
 * A Battlegear 2 manipulator extension of {@link ItemWeapon} for daggers
 * 
 * @author George Albany
 *
 */
@InterfaceList(value={
		@Interface(iface = "mods.battlegear2.api.weapons.IBattlegearWeapon", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.weapons.IBackStabbable", modid = Utils.bg2Id, striprefs = true)
})
public class ItemDaggerBg2 extends ItemWeapon 
		implements mods.battlegear2.api.weapons.IBattlegearWeapon, mods.battlegear2.api.weapons.IBackStabbable {
	
	protected final float hitTime = 0.5F;
	protected final float reach = -2;
	
	public ItemDaggerBg2(ToolMaterial weaponMat, String name, float weaponDam, CreativeTabs tab) {
		super(weaponMat, name, weaponDam, tab);
	}
	
	public ItemDaggerBg2(ToolMaterial weaponMat, String name, float weaponDam) {
		this(weaponMat, name, weaponDam, HTTYMDMod.getCreativeTab());
	}
	
	public ItemDaggerBg2(ToolMaterial mat) {
		this(mat, EnumWeaponType.DAGGER.getName(), EnumWeaponType.DAGGER.getDamage());
	}
	
	public boolean onBackStab(EntityLivingBase entityHit, EntityLivingBase entityHitting) {
		if(!Utils.shouldForceBg2Daggers()) return false;
		return entityHit.attackEntityFrom(new EntityDamageSource(mods.battlegear2.Battlegear.CUSTOM_DAMAGE_SOURCE+".backstab", entityHitting), this.attackDamage);
	}
	
	public Multimap<String, AttributeModifier> getAttributeModifiers(ItemStack stack) {
		Multimap<String, AttributeModifier> map = super.getAttributeModifiers(stack);
		if(Utils.shouldForceBg2Daggers()) {
			map.put(extendedReach.getAttributeUnlocalizedName(), 
					new AttributeModifier(extendReachUUID, 
					"Reach Modifier", this.reach, 0));
			map.put(attackSpeed.getAttributeUnlocalizedName(), 
					new AttributeModifier(attackSpeedUUID,
					"Speed Modifier", this.hitTime, 1));
		}
		return map;
	}

	public boolean sheatheOnBack(ItemStack arg0) {
		return false;
	}

	public boolean isOffhandWieldable(ItemStack arg0, EntityPlayer arg1) {
		return true;
	}

	@Override
	public boolean allowOffhand(ItemStack arg0, ItemStack arg1, EntityPlayer arg2) {
		return true;
	}
}
