package com.httymd.api.item;

import com.httymd.util.Utils;

import cpw.mods.fml.common.Optional.Interface;
import cpw.mods.fml.common.Optional.InterfaceList;

/**
 * A shorthand BG2-based helper interface for easier management of BG2, may contain special render methods later
 * 
 * @author George Albany
 *
 */

@InterfaceList(value = {
		@Interface(iface = "mods.battlegear2.api.shield.IShield", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.shield.IArrowCatcher", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.shield.IArrowDisplay", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.IEnchantable", modid = Utils.bg2Id, striprefs = true),
		@Interface(iface = "mods.battlegear2.api.ISheathed", modid = Utils.bg2Id, striprefs = true) 
})
public interface IShield extends mods.battlegear2.api.shield.IShield, mods.battlegear2.api.shield.IArrowCatcher,
		mods.battlegear2.api.shield.IArrowDisplay, mods.battlegear2.api.IEnchantable, mods.battlegear2.api.ISheathed {

	static final String NBT_ARROW_COUNT = "ArrowCount";
	
}
