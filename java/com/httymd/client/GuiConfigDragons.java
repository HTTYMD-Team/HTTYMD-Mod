package com.httymd.client;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import com.httymd.HTTYMDMod;

import cpw.mods.fml.client.config.GuiConfig;

public class GuiConfigDragons extends GuiConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GuiConfigDragons(GuiScreen parentScreen) {
		super(parentScreen, 
				new ConfigElement(HTTYMDMod.getConfig().getConfig().getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), 
				HTTYMDMod.ID, 
				true,
				false, 
				"The HTTYMD Config");
        titleLine2 = "cause the Ender Dragon wasn't fun enough";
	}

    @Override
    public void initGui()
    {
        // You can add buttons and initialize fields here
        super.initGui();
    }

    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        // You can do things like create animations, draw additional elements, etc. here
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button)
    {
        // You can process any additional buttons you may have added here
        super.actionPerformed(button);
    }
	
}
