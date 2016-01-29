package com.httymd.api.item;

import com.httymd.api.IRegisterable;
import com.httymd.util.Utils;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Optional.Interface;
import cpw.mods.fml.common.Optional.InterfaceList;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

/**
 * 
 * An weapon interface type
 * 
 * @author George Albany
 *
 */
@InterfaceList(value = {
	@Interface(iface = "mods.battlegear2.api.weapons.IBattlegearWeapon", modid = Utils.bg2Id, striprefs = true),
	@Interface(iface = "mods.battlegear2.api.weapons.Attributes", modid = Utils.bg2Id, striprefs = true),
})
public interface IItemWeapon extends IRegisterable<Item>, IFuelHandler, mods.battlegear2.api.weapons.IBattlegearWeapon,
		mods.battlegear2.api.weapons.Attributes {

	/**
	 * The type of this weapon
	 */
	public WeaponType getWeaponType();

	/**
	 * The material of this weapon
	 */
	public ToolMaterial getMaterial();

}
