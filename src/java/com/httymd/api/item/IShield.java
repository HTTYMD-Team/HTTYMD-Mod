package com.httymd.api.item;

import com.httymd.util.AddonUtils.Battlegear2;

import cpw.mods.fml.common.Optional.Interface;
import cpw.mods.fml.common.Optional.InterfaceList;

/**
 * A shorthand BG2-based helper interface for easier management of BG2, may contain special render methods later
 * 
 * @author George Albany
 *
 */

@InterfaceList(value = {
		@Interface(iface = "mods.battlegear2.api.shield.IShield", modid = Battlegear2.modId, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.shield.IArrowCatcher", modid = Battlegear2.modId, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.shield.IArrowDisplay", modid = Battlegear2.modId, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.IEnchantable", modid = Battlegear2.modId, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.ISheathed", modid = Battlegear2.modId, striprefs = true) 
})
public interface IShield extends mods.battlegear2.api.shield.IShield, mods.battlegear2.api.shield.IArrowCatcher,
		mods.battlegear2.api.shield.IArrowDisplay, mods.battlegear2.api.IEnchantable, mods.battlegear2.api.ISheathed {

	static final String NBT_ARROW_COUNT = "ArrowCount";
	
}
