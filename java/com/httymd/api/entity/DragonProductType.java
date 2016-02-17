package com.httymd.api.entity;

import java.util.HashMap;
import java.util.Map;

import com.httymd.HTTYMDMod;
import com.httymd.api.EnumMatterState;
import com.httymd.entity.EntityDragon;
import com.httymd.entity.dragon.EntityGronkle;
import com.httymd.entity.dragon.EntityNightmare;
import com.httymd.entity.dragon.EntityZippleback;

import net.minecraft.nbt.NBTTagCompound;

public class DragonProductType {

	public static final DragonProductType NIGHTMARE_SALIVA = new DragonProductType("nightmare_saliva", EntityNightmare.class);
	public static final DragonProductType GRONKLE_LAVA = new DragonProductType("gronkle_lava", EntityGronkle.class);
	public static final DragonProductType ZIPPLEBACK_GAS = new DragonProductType("zippleback_gas", EntityZippleback.class);
	
	public static final Map<String, DragonProductType> nameToType = new HashMap<String, DragonProductType>();
	
	private final String unlocalName;
	private final Class<? extends EntityDragon> dragonClass;
	private EnumMatterState matterState = EnumMatterState.LIQUID;
	
	public DragonProductType(String unlocalizedName, Class<? extends EntityDragon> dragonClazz, EnumMatterState state) {
		this(unlocalizedName, dragonClazz);
		this.matterState = state;
	}
	
	public DragonProductType(String unlocalizedName, Class<? extends EntityDragon> dragonClazz) {
		this.unlocalName = unlocalizedName;
		this.dragonClass = dragonClazz;
		nameToType.put(this.unlocalName, this);
	}
	
	public String getUnlocalizedName() {
		return HTTYMDMod.ID+":product."+this.unlocalName;
	}
	
	public Class<? extends EntityDragon> getDragonClass() {
		return this.dragonClass;
	}
	
	public EnumMatterState getMatterState() {
		return this.matterState;
	}
	
	public void writeToNBT(NBTTagCompound tag) {
		tag.setString(HTTYMDMod.ID+".DragonProductType", this.unlocalName);
	}
	
	public static DragonProductType readFromNBT(NBTTagCompound tag) {
		if(tag == null) return null;
		String name = tag.getString(HTTYMDMod.ID+".DragonProductType");
		if(name.isEmpty() || !nameToType.containsKey(name)) return null;
		return nameToType.get(name);
	}
}
