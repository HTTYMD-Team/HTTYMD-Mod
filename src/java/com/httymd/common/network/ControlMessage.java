package com.httymd.common.network;

import java.util.BitSet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class ControlMessage implements IMessage {

	private final BitSet bits;
	private int previous;

	public ControlMessage() {
		this.bits = new BitSet(Byte.SIZE);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.fromInteger(buf.readUnsignedByte());
	}

	public void fromInteger(int value) {
		int index = 0;
		while (value != 0) {
			if (value % 2 != 0)
				this.bits.set(index);
			index++;
			value >>>= 1;
		}
	}

	public BitSet getFlags() {
		return this.bits;
	}

	public boolean hasChanged() {
		int current = this.toInteger();
		boolean changed = this.previous != current;
		this.previous = current;
		return changed;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeByte(this.toInteger());
	}

	public int toInteger() {
		int value = 0;
		for (int i = 0; i < this.bits.length(); i++)
			value += this.bits.get(i) ? 1 << i : 0;
		return value;
	}

}
