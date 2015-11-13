package com.httymd.item.util;

import java.io.File;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.httymd.client.model.ModelHelmet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class HelmetImporter {

	// TODO: Implement helmet customization/extension system

	private static File modsFolder;
	private static File httymdFolder;
	private static File helmsFolder;

	@SideOnly(Side.CLIENT)
	public static void init() {
		modsFolder = new File(Minecraft.getMinecraft().mcDataDir, "mods");
		httymdFolder = new File(modsFolder, "httymd");
		helmsFolder = new File(httymdFolder, "vhelmets");

		httymdFolder.mkdir();
		helmsFolder.mkdir();

		File defaultHelms = new File(helmsFolder, "default_helmets.json");
		if (!defaultHelms.exists()) {
			Gson defGson = new GsonBuilder().setPrettyPrinting().create();
			String jOutput = defGson.toJson(new HelmetEntry());
		}
	}

	public static class HelmetEntry {
		public ResourceLocation icon;
		public ResourceLocation wearedTexture;
		public ModelHelmet helmetModel = null;
	}

}
