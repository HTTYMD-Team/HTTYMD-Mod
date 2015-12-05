package com.httymd.client.audio;

import java.util.ArrayList;
import java.util.List;

import com.httymd.HTTYMDMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.ResourceLocation;

/**
 * Suppose to be registry for sound
 * 
 * @author George Albany
 *
 * @deprecated Not Usable
 */
public class AudioRegistry {

	private static final List<SoundEntry> music = new ArrayList<SoundEntry>();

	public static void addMusic(String soundNames, boolean whenStart) {
		music.add(new SoundEntry(
				PositionedSoundRecord.func_147673_a(new ResourceLocation(HTTYMDMod.ID + ":" + soundNames)), whenStart));
	}

	public static void update() {
		for (SoundEntry e : music)
			if (e.playNow)
				Minecraft.getMinecraft().getSoundHandler().playSound(e.entry);
	}

}
