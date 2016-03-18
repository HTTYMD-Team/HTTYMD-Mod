package com.httymd.api.item;

import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;

import com.httymd.item.recipe.RecipeHolder;

/**
 * A class designated to register weapon types for easier registry management
 *
 * @author George Albany
 *
 */
public class WeaponType {

	public static final WeaponType DAGGER = new WeaponType("dagger", 2, 0, new IWeaponFactory.DaggerFactory(),
			new Object[]{"#","|", '|', Items.stick});

	public static final WeaponType CLUB = new WeaponType("club", 4.5F, 50,
			new Object[]{"#|#", " | ", " | ", '|', Items.stick});

	public static final WeaponType MACE = new WeaponType("mace", 5,
			new Object[]{" # ", "#|#", " | ", '|', Items.stick});

	public static final WeaponType HAMMER = new WeaponType("hammer", 6.5F, 0, new IWeaponFactory.HammerFactory(),
			new Object[]{"###", "#|#", " | ", '|', Items.stick});

	public static final WeaponType WARAXE = new WeaponType("waraxe", 5.5F,
			new Object[]{"#|#", "#|#", " | ", '|', Items.stick});

	public static final WeaponType SWORD = new WeaponType("sword", 4.0F);
	public static final WeaponType FSWORD = new WeaponType("flame_sword", 4.0F, 0, new IWeaponFactory.FlameSwordFactory());

	private final float damage;
	private int fuelTime = 0;
	private final String name;
	private IWeaponFactory factory = new IWeaponFactory.WeaponFactory();
	private RecipeHolder recipe;

	public WeaponType(String name, float damage) {
		this.damage = damage;
		this.name = name.toLowerCase();
	}

	public WeaponType(String name, float damage, Object ...params) {
		this(name, damage);
		this.createRecipe(params);
	}

	public WeaponType(String name, float damage, int fuelTime) {
		this(name, damage);
		this.fuelTime = fuelTime;
	}

	public WeaponType(String name, float damage, int fuelTime, Object ...params) {
		this(name, damage, fuelTime);
		this.createRecipe(params);
	}

	public WeaponType(String name, float damage, int fuelTime, IWeaponFactory factory) {
		this(name, damage, fuelTime);
		this.factory = factory;
	}

	public WeaponType(String name, float damage, int fuelTime, IWeaponFactory factory, Object ...params) {
		this(name, damage, fuelTime, params);
		this.factory = factory;
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

	/**
	 * Retrieves the weapon factory for the weapon type
	 */
	public IWeaponFactory getFactory() {
		return this.factory;
	}

	/**
	 * Creates and stores a RecipeHolder based on the parameters
	 */
	private WeaponType createRecipe(Object ...params) {
		this.recipe = new RecipeHolder(params);
		return this;
	}

	/**
	 * Adds a tool material to the list of recipe holder materials
	 */
	public WeaponType addMaterial(ToolMaterial material) {
		this.recipe.put(material, this);
		return this;
	}

	/**
	 * Registers the recipe from the RecipeHolder
	 */
	public void registerRecipe() {
		this.recipe.addRecipe();
	}
}