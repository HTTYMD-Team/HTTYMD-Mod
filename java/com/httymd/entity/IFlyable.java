package com.httymd.entity;

public interface IFlyable {
	
	/**
	 * Retrieves whether this object is flying
	 */
	boolean isFlying();
	
	/**
	 * Retrieves whether this currently has the ability to fly
	 */
	boolean isFlyable();
	
	/**
	 * Retrieves the current speed of this object flying
	 */
	double getFlySpeed();
	
	/**
	 * Sets whether this object is flying
	 */
	void setFlying(boolean flying);	
	
	/**
	 * Throws on takeoff for flight of this object
	 */
	void onTakeoff();
}
