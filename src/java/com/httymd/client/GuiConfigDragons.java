package com.httymd.client;

import java.util.List;

import com.httymd.Config;
import com.httymd.HTTYMDMod;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

@SuppressWarnings("rawtypes")
public class GuiConfigDragons extends GuiConfig {
	
	@SuppressWarnings("unchecked")
	private static List<IConfigElement> elements = new ConfigElement(HTTYMDMod.getConfig().getConfig().getCategory(Configuration.CATEGORY_GENERAL)).getChildElements();
	
	static {
		ConfigElement elem;
		for(String cat : Config.CATEGORYS) {
			elem = new ConfigElement(HTTYMDMod.getConfig().getConfig().getCategory(cat));
			elements.add(elem);
		}
	}
	
	public GuiConfigDragons(GuiScreen parentScreen) {
		super(parentScreen, elements, HTTYMDMod.ID, true, false, "The HTTYMD Config");
		this.titleLine2 = "cause the Ender Dragon wasn't fun enough";
	}
}
