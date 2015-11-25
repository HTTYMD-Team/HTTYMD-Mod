package com.httymd.item.util;

public enum EnumWeaponType {

	DAGGER(2),
	CLUB(4.5F),
	MACE(5),
	HAMMER(6.5F),
	WARAXE(5.5F);
	
	private float damage;
	
	private EnumWeaponType(float damage) {
		this.damage = damage;
	}
	
	public String getName() {
		return this.toString().toLowerCase();
	}
	
	public float getDamage() {
		return this.damage;
	}
}
