package com.httymd.client.util;

import com.httymd.common.network.ControlMessage;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

import java.util.BitSet;

public class KeyInputHandler {

    public static final String CAT = "key.categories.httymd";
    //public static final KeyBinding KEY_DRA_UP = new KeyBinding("key.dragon.fly.up", Keyboard.KEY_R, CAT);
    
    private final SimpleNetworkWrapper network;
    private final ControlMessage cm = new ControlMessage();

    public KeyInputHandler(SimpleNetworkWrapper n) {
        this.network = n;

        //ClientRegistry.registerKeyBinding(KEY_DRA_UP);
    }

    @SuppressWarnings("unused")
	@SubscribeEvent
    public void onTick(ClientTickEvent evt) {
        BitSet flags = cm.getFlags();
        //flags.set(0, KEY_DRA_UP.getIsKeyPressed());
        if (cm.hasChanged()) {
            network.sendToServer(cm);
        }
    }

}
