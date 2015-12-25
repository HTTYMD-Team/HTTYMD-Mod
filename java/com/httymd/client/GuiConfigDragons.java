package com.httymd.client;

import java.util.List;

import com.httymd.Config;
import com.httymd.HTTYMDMod;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

@SuppressWarnings("rawtypes")
public class GuiConfigDragons extends GuiConfig {
	
	@SuppressWarnings("unchecked")
	private static List<IConfigElement> elements = new ConfigElement(HTTYMDMod.getConfig().getConfig().getCategory(Configuration.CATEGORY_GENERAL)).getChildElements();
	
	static {
		for(String cat : Config.CATEGORYS) {
			elements.add(new ConfigElement(HTTYMDMod.getConfig().getConfig().getCategory(cat)));
		}
	}
	
	public GuiConfigDragons(GuiScreen parentScreen) {
		super(parentScreen, elements, HTTYMDMod.ID, true, false, "The HTTYMD Config");
		this.titleLine2 = "cause the Ender Dragon wasn't fun enough";
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		// You can process any additional buttons you may have added here
		super.actionPerformed(button);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		// You can do things like create animations, draw additional elements,
		// etc. here
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public void initGui() {
		// You can add buttons and initialize fields here
		super.initGui();
	}

}
