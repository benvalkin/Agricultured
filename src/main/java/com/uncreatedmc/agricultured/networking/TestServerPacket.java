package com.uncreatedmc.agricultured.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class TestServerPacket // this is your custom packet class. it will be sent from clients to the server.
{
    private static final Logger LOG = LogManager.getLogger();

    public String message; // the data we want to transfer, in this case a simple string

    public TestServerPacket(String message) // basic constructor
    {
        this.message = message;
    }
    public TestServerPacket(FriendlyByteBuf buffer) // this method controls how the packet is decoded upon arrival. (you might notice it's just a constructor that takes in a FriendlyByteBuf
    {
        this.message = buffer.readUtf();
    }
    public void Encode(FriendlyByteBuf buffer) // this method controls how the packet is encoded for sending.
    {
        buffer.writeUtf(this.message);
    }
    public void Process(Supplier<NetworkEvent.Context> ctx) // this method controls how the packet is processed by the SERVER.
    {
        ctx.get().enqueueWork(()->
        {
            LOG.info("PACKET RECEIVED BY SERVER :D");
            LOG.info("  From: " + ctx.get().getSender().getScoreboardName());
            LOG.info("  Message from the packet: " + this.message);
        });
        ctx.get().setPacketHandled(true);
    }
}
