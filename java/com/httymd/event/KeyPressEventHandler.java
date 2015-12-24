package com.httymd.event;

import org.lwjgl.input.Keyboard;

import com.httymd.HTTYMDMod;
import com.httymd.common.network.PlyJumpMessage;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;

public class KeyPressEventHandler {

	@SubscribeEvent
	public void onKeyPress(InputEvent.KeyInputEvent event) {
		Minecraft mc = FMLClientHandler.instance().getClient();
		if (mc != null && mc.thePlayer != null && mc.theWorld != null) {
			if(Keyboard.getEventKey() == mc.gameSettings.keyBindJump.getKeyCode()) {
				HTTYMDMod.proxy.getNetwork().sendToServer(new PlyJumpMessage(true));
			}
		}
	}

}
