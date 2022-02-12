package com.uncreatedmc.agricultured.events;

import com.uncreatedmc.agricultured.networking.Networker;
import com.uncreatedmc.agricultured.networking.TestClientPacket;
import com.uncreatedmc.agricultured.networking.TestServerPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = "agricultured", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class TestHandler {
    @SubscribeEvent
    public static void onPlayerConnectedServer(PlayerEvent.PlayerLoggedInEvent event) {
        System.out.println("Player logged in on server");
        Networker.SendToClient(new Supplier<ServerPlayer>() {
            @Override
            public ServerPlayer get() {
                return (ServerPlayer) event.getPlayer();
            }
        }, new TestClientPacket("HELLO :D :D from server"));
    }
}
