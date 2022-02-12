package com.uncreatedmc.agricultured.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class TestClientPacket // another custom packet class. It's identical to the previous packet class aside from the process() method.
{
    private static final Logger LOG = LogManager.getLogger();

    public String message;

    public TestClientPacket(String message)
    {
        this.message = message;
    }
    public TestClientPacket(FriendlyByteBuf buffer)
    {
        this.message = buffer.readUtf();
    }
    public void Encode(FriendlyByteBuf buffer)
    {
        buffer.writeUtf(this.message);
    }
    public void Process(Supplier<NetworkEvent.Context> ctx) // here is the difference
    {
        ctx.get().enqueueWork(()->
        {
            // this makes it so that ClientPacketHandler.Process() is only run when on the client
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientPacketHandler.Process(this, ctx));
        });
        ctx.get().setPacketHandled(true);
    }
}

// and lastly, our client-side packet handler class. Not sure why we need a custom class for this, but Forge says so
class ClientPacketHandler
{
    private static final Logger LOG = LogManager.getLogger();

    public static void Process(TestClientPacket packet, Supplier<NetworkEvent.Context> ctx) // controls how the packet is processed by the CLIENT.
    {
        LOG.info("PACKET RECEIVED ON CLIENT :D");
        //LOG.info("  From: " + ctx.get().getSender().getScoreboardName());
        LOG.info("  Message from the packet: " + packet.message);
    }
}

