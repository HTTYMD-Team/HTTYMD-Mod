package com.httymd.api.item;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.httymd.item.ItemFoodDrop;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;

/**
 * A class designated to register food types for easier registry management
 *
 * @author George Albany
 *
 */
public class FoodType {
	public static final FoodType MUTTON = new FoodType("mutton", true, 8, 0.8F, true, EntitySheep.class);
	
	public static final FoodType CRAB = new FoodType("crab", false, 6, 0.6F, false);
	public static final FoodType HCOMB = new FoodType("hcomb", false, 3, 0.3F, false);
	public static final FoodType FWEED = new FoodType("fweed", false, 5, 0.5F, false); 
	public static final FoodType SFLOWER = new FoodType("sflower", false, 1, 0.1F, false); 
	public static final FoodType DNIP = new FoodType("dnip", false, 2, 0.5F, false);

	private static final List<FoodType> foodTypes = new ArrayList<FoodType>();
	
	/**
	 * Generates and returns a registered MultiMap for current food
	 */
	public static Multimap<FoodType, Item> generateFood() {
		Multimap<FoodType, Item> foods = ArrayListMultimap.create();
		Item drop = null;
		
		for (FoodType food : FoodType.values()) {			
			if (food.isMeat())
				drop = new ItemFoodDrop(food.getName() + "_raw", food.getHeal() / 2, food.getSaturation() / 2,
						food.getForWolfs(), food.getDropFor()).registerItem();
			
			if(drop != null) foods.put(food, drop);
			drop = new ItemFoodDrop(food.getName(), food.getHeal(), food.getSaturation(), food.getForWolfs(),
					food.getDropFor(), food.isMeat()) {

				public boolean isForEntity(EntityLivingBase entity) {
					return super.isForEntity(entity) && entity.isBurning();
				}

			}.registerItem();
			
			foods.put(food, drop);
			drop = null;
		}
		return foods;
	}

	private static List<FoodType> values() {
		return foodTypes;
	}

	private final boolean isMeat;
	private final int heal;
	private final float satu;
	private final boolean wolfMeat;
	private final String name;

	private final Class<? extends EntityLivingBase> dropsFor;

	private FoodType(String name, boolean isMeat, int heal, float satu, boolean wolf) {
		this(name, isMeat, heal, satu, wolf, null);
	}

	private FoodType(String name, boolean isMeat, int heal, float satu, boolean wolf,
			Class<? extends EntityLivingBase> dropsFor) {
		this.isMeat = isMeat;
		this.heal = heal;
		this.satu = satu;
		this.wolfMeat = wolf;
		this.dropsFor = dropsFor;
		this.name = name;
		foodTypes.add(this);
	}
	
	/**
	 * Retrieves the Entity class this food type will drop for (or null for none)
	 */
	public Class<? extends EntityLivingBase> getDropFor() {
		return this.dropsFor;
	}

	/**
	 * Whether a wolf can use this food type for healing
	 */
	public boolean getForWolfs() {
		return this.wolfMeat;
	}

	/**
	 * The amount of hunger restored by this food type (or amount healed for wolves)
	 * 
	 * <p>(its called heal in minecraft, keeping consistent)</p>
	 */
	public int getHeal() {
		return this.heal;
	}
	
	/**
	 * The saturation level for food type
	 */
	public float getSaturation() {
		return this.satu;
	}

	/**
	 * Determines whether food is considered cookable or not
	 */
	public boolean isMeat() {
		return this.isMeat;
	}
	
	public String getName() {
		return this.name;
	}
}
