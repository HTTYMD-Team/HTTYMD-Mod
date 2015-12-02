package com.httymd.bg2.item;

import com.google.common.collect.Multimap;
import com.httymd.item.ItemWeapon;
import com.httymd.item.util.EnumWeaponType;
import com.httymd.util.Utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;

/**
 * A Battlegear 2 manipulator extension of {@link ItemWeapon} for Warhammers
 * 
 * @author George Albany
 *
 */
@InterfaceList(value={
		@Interface(iface = "mods.battlegear2.api.weapons.IBattlegearWeapon", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.weapons.IHitTimeModifier", modid = Utils.bg2Id, striprefs = true)
})
public class ItemWarhammerBg2 extends ItemWeapon implements mods.battlegear2.api.weapons.IBattlegearWeapon {

	protected final float hitTime = 4F;
	protected final int ignoreDam = 4;
	
	public ItemWarhammerBg2(ToolMaterial toolMaterial, String weaponName, float weaponDamage) {
		super(toolMaterial, weaponName, weaponDamage);
	}
	
	public ItemWarhammerBg2(ToolMaterial mat) {
		this(mat, EnumWeaponType.HAMMER.getName(), EnumWeaponType.HAMMER.getDamage());
	}

	public EnumAction getItemUseAction(ItemStack stack) {
		return Utils.shouldForceBg2ForWarhammer() ? EnumAction.NONE : super.getItemUseAction(stack);
	}
	
	public boolean allowOffhand(ItemStack mainhand, ItemStack offhand, EntityPlayer player) {
		return Utils.shouldForceBg2ForWarhammer() ? offhand == null : true;
	}

	public boolean sheatheOnBack(ItemStack item) {
		return true;
	}
	
	public Multimap<String, AttributeModifier> getAttributeModifiers(ItemStack stack) {
		Multimap<String, AttributeModifier> map = super.getAttributeModifiers(stack);
		if(Utils.shouldForceBg2ForWarhammer()) {
			map.put(attackSpeed.getAttributeUnlocalizedName(), 
					new AttributeModifier(attackSpeedUUID, "Speed Modifier", this.hitTime, 1));
			 map.put(armourPenetrate.getAttributeUnlocalizedName(), 
					 new AttributeModifier(penetrateArmourUUID,  "Attack Modifier", this.ignoreDam, 0));
		}
		return map;
	}
	
	public void onUpdate(ItemStack stack, World world, Entity user, int p_77663_4_, boolean inHand) {
		if(inHand && !Utils.shouldForceBg2ForWarhammer() && user instanceof EntityLivingBase) {
			EntityLivingBase live = (EntityLivingBase) user;
			PotionEffect effect = new PotionEffect(Potion.digSlowdown.getId(), 1, 10, true, false);
			live.addPotionEffect(effect);
		}
	}

	@Override
	public boolean isOffhandWieldable(ItemStack arg0, EntityPlayer arg1) {
		return false;
	}
}
