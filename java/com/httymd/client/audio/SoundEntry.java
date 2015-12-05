package com.httymd.client.audio;

import net.minecraft.client.audio.ISound;

/**
 * Suppose to be entry for sound
 * 
 * @author Georhe Albany
 *
 * @deprecated Not usable
 */
public class SoundEntry {

	public final ISound entry;
	public final boolean playNow;

	public SoundEntry(ISound sound, boolean eventStart) {
		this.entry = sound;
		this.playNow = eventStart;
	}

}
