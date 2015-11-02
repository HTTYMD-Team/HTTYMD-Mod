package com.httymd.client.audio;

import net.minecraft.client.audio.ISound;

public class SoundEntry {

	public final ISound entry;
	public final boolean playNow;

	public SoundEntry(ISound sound, boolean eventStart) {
		entry = sound;
		playNow = eventStart;
	}

}
