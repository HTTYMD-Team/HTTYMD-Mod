package com.httymd.item.util;

/**
 * An enum designated to hold types of weapons for easier registry management
 *
 * @author George Albany
 *
 */
public enum EnumWeaponType {

	DAGGER(2),
	CLUB(4.5F, 250),
	MACE(5),
	HAMMER(6.5F),
	WARAXE(5.5F);
	
	private float damage;
	private int fuelTime = 200;
	private String name;
	
	private EnumWeaponType(float damage) {
		this.damage = damage;
		this.name = this.toString().toLowerCase();
	}
	
	private EnumWeaponType(float damage, Integer fuelTime) {
		this(damage);
		this.fuelTime = fuelTime;
	}
	
	/**
	 * Retrieves the lowercase name of the weapon type
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Retrieves the base damage for the weapon type
	 */
	public float getDamage() {
		return this.damage;
	}
	
	/**
	 * Retrieves a fuel type for this weapon type
	 * 
	 * <p>Shall be ignored for fuel registry if value is less then 1</p>
	 */
	public int getFuelTime() {
		return this.fuelTime;
	}
}
