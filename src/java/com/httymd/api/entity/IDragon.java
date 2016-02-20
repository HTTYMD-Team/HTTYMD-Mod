package com.httymd.api.entity;

/**
 * An Interface to assist and extend dragons
 * 
 * @author George Albany
 *
 */
public interface IDragon extends IFlyable, IRideable {

	/**
	 * Retrieves the dragon ability of the dragon
	 */
	public IDragonAbility getDragonAbility();

}
