package com.httymd.entity;

//import com.httymd.inventory.InventoryViking;
import java.util.ArrayList;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.INpc;
import net.minecraft.world.World;

public abstract class EntityVikingBase extends EntityAgeable implements INpc {

	protected ArrayList<EntityLivingBase> pets;
	protected EntityDragon mainDragon;
	// protected InventoryViking inventory;

	public EntityVikingBase(World p_i1578_1_, int slotsOfInventory) {
		super(p_i1578_1_);
		// this.inventory = new InventoryViking(this, slotsOfInventory);
	}

	/*
	 * public InventoryViking getInventory() { return this.inventory; }
	 */

	public void addPet(EntityLivingBase entity) {
		this.pets.add(entity);
	}

	public void removePet(EntityLivingBase entity) {
		this.pets.remove(entity);
	}

	public void removePet(int i) {
		this.pets.remove(i);
	}

	public void setDragon(EntityDragon dragon) {
		this.mainDragon = dragon;
	}

	public EntityDragon getDragon() {
		return this.mainDragon;
	}

	public EntityLivingBase getPet(int i) {
		return this.pets.get(i);
	}

	public boolean hasPet(EntityLivingBase ent) {
		return this.pets.contains(ent);
	}

	public int petIndexOf(EntityLivingBase ent) {
		return this.pets.indexOf(ent);
	}

}
