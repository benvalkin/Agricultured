package com.uncreatedmc.agricultured.networking;

import com.uncreatedmc.agricultured.Agricultured;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class Networker {
    private static final Logger LOG = LogManager.getLogger();
    private static final String PROTOCOL_VERSION = "1";

    // make a static SimpleChannel class member and initialize it like this. For more info on what each part does, consult the Official Forge docs.
    private static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(Agricultured.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    // here is where you tell your mod to start listening for your custom packet. Make sure you call INSTANCE.registerMessage at some point when your mod starts up
    public static void RegisterMessages()
    {
        INSTANCE.registerMessage(
                420, // unique ID number. Can be anything, but make sure it's unique to your other Messages or there will probably be issues.
                TestServerPacket.class,
                TestServerPacket::Encode,
                TestServerPacket::new,
                TestServerPacket::Process
        );

        INSTANCE.registerMessage(
                421, // a different ID number
                TestClientPacket.class,
                TestClientPacket::Encode,
                TestClientPacket::new,
                TestClientPacket::Process
        );

    }
    // send your custom server packet to the server
    public static void SendToServer(TestServerPacket test)
    {
        INSTANCE.sendToServer(test);
    }

    // send your custom client packet to the server
    public static void SendToClientAnnoyingWay(ServerPlayer player, TestClientPacket packet) // annoying because it requires you to have an instance of ServerPlayer i think
    {
        INSTANCE.sendTo(packet, player.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
    }

    // some better methods that are more convenient
    public static void SendToClient(Supplier<ServerPlayer> player, TestClientPacket packet)
    {
        // Send to one player
        INSTANCE.send(PacketDistributor.PLAYER.with(player), packet);
    }
    public static void SendToAllClientsWithChunkLoaded(Supplier<LevelChunk> chunk, TestClientPacket packet)
    {
        // Send to all players tracking this level chunk
        INSTANCE.send(PacketDistributor.TRACKING_CHUNK.with(chunk), packet);
    }
    public static void SendToAllClients(TestClientPacket packet)
    {
        // Send to all clients connected to the server
        INSTANCE.send(PacketDistributor.ALL.noArg(), packet);
    }
}
