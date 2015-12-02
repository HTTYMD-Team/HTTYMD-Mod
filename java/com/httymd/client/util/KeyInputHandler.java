package com.httymd.client.util;

import java.util.BitSet;

import com.httymd.common.network.ControlMessage;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class KeyInputHandler {

	public static final String CAT = "key.categories.httymd";
	// public static final KeyBinding KEY_DRA_UP = new
	// KeyBinding("key.dragon.fly.up", Keyboard.KEY_R, CAT);

	private final SimpleNetworkWrapper network;
	private final ControlMessage cm = new ControlMessage();

	public KeyInputHandler(SimpleNetworkWrapper n) {
		this.network = n;

		// ClientRegistry.registerKeyBinding(KEY_DRA_UP);
	}

	@SubscribeEvent
	public void onTick(ClientTickEvent evt) {
		this.cm.getFlags();
		// flags.set(0, KEY_DRA_UP.getIsKeyPressed());
		if (this.cm.hasChanged())
			this.network.sendToServer(this.cm);
	}

}
