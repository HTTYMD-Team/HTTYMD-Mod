package com.httymd.api.item;

import com.httymd.bg2.item.ItemDaggerBg2;
import com.httymd.bg2.item.ItemWarhammerBg2;
import com.httymd.item.ItemFlameSword;
import com.httymd.item.ItemWeapon;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public interface IWeaponFactory {

	public Item createWeapon(ToolMaterial material, WeaponType type);
	
	public static class HammerFactory implements IWeaponFactory {
		@Override
		public Item createWeapon(ToolMaterial material, WeaponType type) {
			return new ItemWarhammerBg2(material).register();
		}
	}
	
	public static class DaggerFactory implements IWeaponFactory {
		@Override
		public Item createWeapon(ToolMaterial material, WeaponType type) {
			return new ItemDaggerBg2(material).register();
		}
	}
	
	public static class WeaponFactory implements IWeaponFactory {
		@Override
		public Item createWeapon(ToolMaterial material, WeaponType type) {
			return new ItemWeapon(material, type).register();
		}
	}
	
	public static class FlameSwordFactory implements IWeaponFactory {
		@Override
		public Item createWeapon(ToolMaterial material, WeaponType type) {
			return new ItemFlameSword(material, type).register();
		}
	}
	
}