package com.httymd.entity;

public interface IFlyable {

	/**
	 * Retrieves the current speed of this object flying
	 */
	double getFlySpeed();

	/**
	 * Retrieves whether this currently has the ability to fly
	 */
	boolean isFlyable();

	/**
	 * Retrieves whether this object is flying
	 */
	boolean isFlying();

	/**
	 * Throws on takeoff for flight of this object
	 */
	void onTakeoff();

	/**
	 * Sets whether this object is flying
	 */
	void setFlying(boolean flying);
}
