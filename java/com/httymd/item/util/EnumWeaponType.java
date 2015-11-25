package com.httymd.item.util;

public enum EnumWeaponType {

	DAGGER(2),
	CLUB(4.5F, 250),
	MACE(5),
	HAMMER(6.5F),
	WARAXE(5.5F);
	
	private float damage;
	private int fuelTime = 200;
	
	private EnumWeaponType(float damage) {
		this.damage = damage;
	}
	
	private EnumWeaponType(float damage, Integer fuelTime) {
		this(damage);
		this.fuelTime = fuelTime;
	}
	
	public String getName() {
		return this.toString().toLowerCase();
	}
	
	public float getDamage() {
		return this.damage;
	}
	
	public int getFuelTime() {
		return this.fuelTime;
	}
}
