package com.httymd.common.network;

import com.httymd.entity.EntityTameableFlying;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.channel.ChannelHandler.Sharable;
import net.minecraft.entity.player.EntityPlayerMP;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Sharable
public class ControlMessageHandler implements IMessageHandler<ControlMessage, IMessage> {

    private static final Logger L = LogManager.getLogger();

    @SuppressWarnings("unused")
	@Override
    public IMessage onMessage(ControlMessage message, MessageContext ctx) {
// check if the server is messing with the protocol
        if (ctx.side == Side.CLIENT) {
            L.warn("Recieved unexpected control message from server!");
            return null;
        }
        EntityPlayerMP player = ctx.getServerHandler().playerEntity;
        if (player.ridingEntity instanceof EntityTameableFlying) {
        	EntityTameableFlying dragon = (EntityTameableFlying) player.ridingEntity;
            //dragon.setControlFlags(message.getFlags());
        }
// receive only
        return null;
    }
}
