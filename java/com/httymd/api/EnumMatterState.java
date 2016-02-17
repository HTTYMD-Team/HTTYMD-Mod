package com.httymd.api;

public enum EnumMatterState {

	SOLID(0.5f),
	LIQUID(1),
	GAS(2);
	
	private final float densityMultiplier;
	
	private EnumMatterState(float densityMultiplier) {
		this.densityMultiplier = densityMultiplier;
	}
	
	public boolean isSolid() {
		return this == SOLID;
	}
	
	public boolean isLiquid() {
		return this == LIQUID;
	}
	
	public boolean isGas() {
		return this == GAS;
	}
	
	public boolean behavesLiquid() {
		return this != SOLID;
	}	
	
	public float getDensityMultipler() {
		return this.densityMultiplier;
	}
}
