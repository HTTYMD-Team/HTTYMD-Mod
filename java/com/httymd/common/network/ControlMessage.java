package com.httymd.common.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import java.util.BitSet;

public class ControlMessage implements IMessage {

    private final BitSet bits;
    private int previous;

    public ControlMessage() {
        bits = new BitSet(Byte.SIZE);
    }

    public BitSet getFlags() {
        return bits;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        fromInteger(buf.readUnsignedByte());
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeByte(toInteger());
    }

    public void fromInteger(int value) {
        int index = 0;
        while (value != 0) {
            if (value % 2 != 0) {
                bits.set(index);
            }
            index++;
            value >>>= 1;
        }
    }

    public int toInteger() {
        int value = 0;
        for (int i = 0; i < bits.length(); i++) {
            value += bits.get(i) ? (1 << i) : 0;
        }
        return value;
    }

    public boolean hasChanged() {
        int current = toInteger();
        boolean changed = previous != current;
        previous = current;
        return changed;
    }

}
