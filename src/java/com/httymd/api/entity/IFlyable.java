package com.httymd.api.entity;

import com.httymd.util.StringUtils;

import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

/**
 * A Helper Interface for determining and controlling flight of an entity
 *
 * @author George Albany
 *
 */
public interface IFlyable {

	/**
	 * The NBT name of the flight boolean variable
	 */
	public static final String NBT_IS_FLYING = "Flying";

	/**
	 * The Flight speed
	 */
	public static final IAttribute flyingSpeed = new RangedAttribute(StringUtils.getModString("flyingSpeed"), 1D, 0.0D,
			Double.MAX_VALUE).setDescription("Flying Speed").setShouldWatch(true);

	/**
	 * The Flying Yaw delta speed
	 */
	public static final IAttribute flyingYaw = new RangedAttribute(StringUtils.getModString("flyingYaw"), 25D, 0.0D,
			Double.MAX_VALUE).setDescription("Flying Yaw Speed").setShouldWatch(true);

	/**
	 * The Flying Pitch delta speed
	 */
	public static final IAttribute flyingPitch = new RangedAttribute(StringUtils.getModString("flyingPitch"), 20D, 0.0D,
			Double.MAX_VALUE).setDescription("Flying Pitch Speed").setShouldWatch(true);

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