package com.httymd.api.item;

import cpw.mods.fml.common.IFuelHandler;

/**
 * 
 * @author 17galbany
 *
 */
public interface IItemWeapon extends IRegisterable, IFuelHandler {
	
	/**
	 * The type of this weapon
	 */
	public WeaponType getWeaponType();
	
}
