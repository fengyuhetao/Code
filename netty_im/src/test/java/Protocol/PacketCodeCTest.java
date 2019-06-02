package Protocol;

import Protocol.packet.LoginRequestPacket;
import Protocol.packet.Packet;
import Protocol.packet.PacketCodeC;
import Protocol.serializer.Serializer;
import Protocol.serializer.impl.JSONSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Assert;
import org.junit.Test;

public class PacketCodeCTest {

    @Test
    public void encode() {
        Serializer serializer = new JSONSerializer();
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setVersion((byte) 1);
        loginRequestPacket.setUserId(1);
        loginRequestPacket.setUsername("ht");
        loginRequestPacket.setPassword("htt");

        PacketCodeC packetCodeC = new PacketCodeC();
    }
}
