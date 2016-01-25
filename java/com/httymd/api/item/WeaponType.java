package com.httymd.api.item;

/**
 * A class designated to register weapon types for easier registry management
 *
 * @author George Albany
 *
 */
public class WeaponType {

	public static final WeaponType DAGGER = new WeaponType("dagger", 2);
	public static final WeaponType CLUB = new WeaponType("club", 4.5F, 250);
	public static final WeaponType MACE = new WeaponType("mace", 5);
	public static final WeaponType HAMMER = new WeaponType("hammer", 6.5F);
	public static final WeaponType WARAXE = new WeaponType("waraxe", 5.5F);
	
	private float damage;
	private int fuelTime = 200;
	private String name;
	
	public WeaponType(String name, float damage) {
		this.damage = damage;
		this.name = name.toLowerCase();
	}
	
	public WeaponType(String name, float damage, Integer fuelTime) {
		this(name, damage);
		this.fuelTime = fuelTime;
	}
	
	/**
	 * Retrieves the name of the weapon type
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
