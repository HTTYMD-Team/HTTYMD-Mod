package com.httymd.client;

import java.util.Set;

import cpw.mods.fml.client.IModGuiFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class GuiFactoryDragons implements IModGuiFactory {

	@Override
	public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
		return null;
	}

	@Override
	public void initialize(Minecraft minecraftInstance) {

	}

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass() {
		return GuiConfigDragons.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}

}
