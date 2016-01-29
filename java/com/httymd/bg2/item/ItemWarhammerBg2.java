package com.httymd.bg2.item;

import com.google.common.collect.Multimap;
import com.httymd.api.item.WeaponType;
import com.httymd.item.ItemWeapon;
import com.httymd.util.Utils;

import cpw.mods.fml.common.Optional.Interface;
import cpw.mods.fml.common.Optional.InterfaceList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * A Battlegear 2 manipulator extension of {@link ItemWeapon} for Warhammers
 * 
 * @author George Albany
 *
 */
@InterfaceList(value = {
		@Interface(iface = "mods.battlegear2.api.weapons.IHitTimeModifier", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.weapons.IPenetrateWeapon", modid = Utils.bg2Id, striprefs = true)
})
public class ItemWarhammerBg2 extends ItemWeapon
		implements mods.battlegear2.api.weapons.IHitTimeModifier, mods.battlegear2.api.weapons.IPenetrateWeapon {

	protected final float hitTime = 4F;
	protected final int ignoreDam = 4;

	public ItemWarhammerBg2(ToolMaterial toolMaterial, String weaponName, float weaponDamage) {
		super(toolMaterial, weaponName, weaponDamage);
	}

	public ItemWarhammerBg2(ToolMaterial mat) {
		super(mat, WeaponType.HAMMER);
	}

	public EnumAction getItemUseAction(ItemStack stack) {
		return Utils.shouldForceBg2ForWarhammer() ? EnumAction.none : super.getItemUseAction(stack);
	}

	public boolean allowOffhand(ItemStack mainhand, ItemStack offhand) {
		return Utils.shouldForceBg2ForWarhammer() ? mainhand == null : true;
	}

	public boolean isOffhandHandDual(ItemStack off) {
		return false;
	}

	public boolean sheatheOnBack(ItemStack item) {
		return true;
	}

	@Override
	public int getHitTime(ItemStack stack, EntityLivingBase arg1) {
		return (int) getModifiedAmount(stack,
				Utils.shouldForceBg2ForWarhammer() ? attackSpeed.getAttributeUnlocalizedName() : "");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Multimap getAttributeModifiers(ItemStack stack) {
		Multimap map = super.getAttributeModifiers(stack);
		if (Utils.shouldForceBg2ForWarhammer()) {
			map.put(attackSpeed.getAttributeUnlocalizedName(),
					new AttributeModifier(attackSpeedUUID, "Speed Modifier", this.hitTime, 1));
			map.put(armourPenetrate.getAttributeUnlocalizedName(),
					new AttributeModifier(penetrateArmourUUID, "Attack Modifier", this.ignoreDam, 0));
		}
		return map;
	}

	public int getPenetratingPower(ItemStack stack) {
		return (int) getModifiedAmount(stack,
				Utils.shouldForceBg2ForWarhammer() ? armourPenetrate.getAttributeUnlocalizedName() : "");
	}

	public void onUpdate(ItemStack stack, World world, Entity user, int p_77663_4_, boolean inHand) {
		if (inHand && !Utils.shouldForceBg2ForWarhammer() && user instanceof EntityLivingBase) {
			EntityLivingBase live = (EntityLivingBase) user;
			PotionEffect effect = new PotionEffect(Potion.digSlowdown.getId(), 1, 10, true);
			live.addPotionEffect(effect);
		}
	}
}
