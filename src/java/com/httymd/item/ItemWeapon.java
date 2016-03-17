package com.httymd.item;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.httymd.api.item.IItemWeapon;
import com.httymd.api.item.WeaponType;
import com.httymd.creativetab.CreativeTab;
import com.httymd.registry.ItemRegistry;
import com.httymd.util.AddonUtils.Battlegear2;
import com.httymd.util.ItemUtils;

import cpw.mods.fml.common.Optional.Method;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

/**
 * A generic ItemWeapon class for ease of weapon creation, and handles fuel for fuel items
 *
 * @author George Albany
 *
 */
public class ItemWeapon extends ItemSword implements IItemWeapon {

	private static final Map<ToolMaterial, HashMap<WeaponType, IItemWeapon>> weaponMap = new HashMap<ToolMaterial, HashMap<WeaponType, IItemWeapon>>();

	protected float attackDamage;
	protected ToolMaterial material;
	protected WeaponType type;
	protected int fuelTime = 0;

	public ItemWeapon(ToolMaterial mat, WeaponType wepType) {
		this(mat, wepType.getName(), wepType.getDamage());
		this.type = wepType;
		this.fuelTime = (this.type != null ? this.type.getFuelTime() : 0) + (mat == ToolMaterial.WOOD ? 100 : 0);
		if(this.fuelTime > 0) GameRegistry.registerFuelHandler(this);
		registerWeapon(this);
	}

	public ItemWeapon(ToolMaterial toolMaterial, String weaponName, float weaponDamage) {
		this(toolMaterial, weaponName, weaponDamage, CreativeTab.DRAGON_TAB);
	}

	public ItemWeapon(ToolMaterial toolMaterial, String weaponName, float weaponDam, CreativeTabs tab) {
		this(weaponName + "_" + toolMaterial.toString(), toolMaterial, weaponDam, tab);
	}

	public ItemWeapon(String name, ToolMaterial weaponMat, float weaponDam, CreativeTabs tab) {
		super(weaponMat);
		this.material = weaponMat;
		this.setCreativeTab(tab);
		this.attackDamage = weaponDam + weaponMat.getDamageVsEntity();
		this.setUnlocalizedName(ItemUtils.findUnlocName(name));
		this.setTextureName(ItemUtils.findTextureName(this.getUnlocalizedName()));
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(ItemStack stack) {
		Multimap<String, AttributeModifier> multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(),
				new AttributeModifier(field_111210_e, "Weapon Modifier", this.attackDamage, 0));
		//1.8: field_111210_e to itemModifierUUID
		return multimap;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack item) {
		return 72000;
	}

	@Override
	public String getRegistryName() {
		return ItemUtils.findRegistryName(this.getUnlocalizedName());
	}

	/**
	 * Retrieves the weapon's material's base entity attack damage (for 1.8 consistency)
	 */
	public float MaterialAttackDamage() {
		return this.func_150931_i(); //getDamageVsEntity in 1.8
	}

	/**
	 * Retrieves the mining speed for the weapon (for 1.8 consistency)
	 */
	public float MineSpeed(ItemStack item, Block block) {
		return this.func_150893_a(item, block); //getStrVsBlock in 1.8
	}

	@Override
	public Item register() {
		ItemRegistry.registerItem(this, this.getRegistryName());
		return this;
	}

	/**
	 * Whether item is effective against block
	 */
	@Override
	public boolean func_150897_b(Block block) {
		return this.type == WeaponType.WARAXE && block.getMaterial() == Material.wood;
	}

	/**
	 * Retrieves the total modifier amount on an item stack using a modifier name
	 *
	 * <p>See Battlegear 2's ItemWeapon class for original implementation</p>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public float getModifiedAmount(ItemStack stack, String modifierName) {
		if(modifierName.isEmpty()) return 0;
		Iterator itr = stack.getAttributeModifiers().get(modifierName).iterator();
		float f = 0;
		while (itr.hasNext()) {
			f += ((AttributeModifier) itr.next()).getAmount();
		}
		return f;
	}

	/**
	 * Retrieves the amount of time able to spend on burning an item
	 */
	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel != null && fuel.getItem() == this) {
			return this.fuelTime;
		}
		return 0;
	}

	public static HashMap<WeaponType, IItemWeapon> getWeaponMap(ToolMaterial mat) {
		return weaponMap.get(mat);
	}

	public static IItemWeapon getWeaponFor(ToolMaterial mat, WeaponType type) {
		return getWeaponMap(mat).get(type);
	}

	public static void registerWeapon(IItemWeapon item) {
		if(!(item instanceof Item)) return;
		if(item.getMaterial() != null && item.getWeaponType() != null) {
			if(!weaponMap.containsKey(item.getMaterial())) {
				weaponMap.put(item.getMaterial(), new HashMap<WeaponType, IItemWeapon>());
			}
			weaponMap.get(item.getMaterial()).put(item.getWeaponType(), item);
		}
	}

	@Override
	public WeaponType getWeaponType() {
		return this.type;
	}

	@Override
	public ToolMaterial getMaterial() {
		return this.material;
	}

	@Override
	public boolean sheatheOnBack(ItemStack sheath) {
		return false;
	}

	@Override
	public boolean isOffhandHandDual(ItemStack offhand) {
		return true;
	}

	@Override
	@Method(modid = Battlegear2.modId)
	public boolean offhandAttackEntity(mods.battlegear2.api.PlayerEventChild.OffhandAttackEvent event, ItemStack main, ItemStack offhand) {
		return true;
	}

	@Override
	public boolean offhandClickAir(PlayerInteractEvent event, ItemStack main, ItemStack offhand) {
		return true;
	}

	@Override
	public boolean offhandClickBlock(PlayerInteractEvent event, ItemStack main, ItemStack offhand) {
		return true;
	}

	@Override
	public void performPassiveEffects(Side side, ItemStack main, ItemStack offhand) {
	}

	@Override
	public boolean allowOffhand(ItemStack main, ItemStack offhand) {
		return true;
	}
}
