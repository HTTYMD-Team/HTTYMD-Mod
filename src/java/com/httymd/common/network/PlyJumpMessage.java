package com.httymd.common.network;

import com.httymd.entity.EntityDragon;
import com.httymd.entity.EntityTameableFlying;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;

public class PlyJumpMessage implements IMessage {

	private boolean jumpKeyPressed;
	
	public PlyJumpMessage() {}
	
	public PlyJumpMessage(boolean jump) {
		this.jumpKeyPressed = jump;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.jumpKeyPressed = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(this.jumpKeyPressed);
	}
	
	public static class PlyJumpMsgHandler implements IMessageHandler<PlyJumpMessage, IMessage> {

		@Override
		public IMessage onMessage(PlyJumpMessage message, MessageContext ctx) {
			if(message.jumpKeyPressed) {
				Entity riding = ctx.getServerHandler().playerEntity.ridingEntity;
				if(riding != null && riding instanceof EntityDragon && !((EntityTameableFlying) riding).isFlying()) {
					EntityDragon dragon = (EntityDragon) riding;
					if(!dragon.isAirBelow(1)) dragon.doJump();
					else dragon.onTakeoff();
				}
			}
			return null;
		}

		
	}

}
