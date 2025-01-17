package com.seacroak.plushables;

import com.seacroak.plushables.config.ConfigPacketHandler;
import com.seacroak.plushables.networking.*;
import com.seacroak.plushables.registry.EntityRendererRegistry;
import com.seacroak.plushables.registry.MainRegistry;
import com.seacroak.plushables.registry.ScreenRegistry;
import com.seacroak.plushables.registry.TileRegistryClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;

public final class PlushablesModClient implements ClientModInitializer {
  public static boolean onServer = false;

  @Override
  @Environment(EnvType.CLIENT)
  public void onInitializeClient() {
    ScreenRegistry.initClient();
    TileRegistryClient.initClient();
    EntityRendererRegistry.initClient();

    /* Functional Transparency*/
    /* Blocks */
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.BASKET_BLOCK, RenderLayer.getCutout());

    /* Simple Plushables */
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.PIG_PLUSHABLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.TRUFFLES_PLUSHABLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.WHELPLING_PLUSHABLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.RAPTOR_PLUSHABLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.BIG_TATER_PLUSHABLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.BIG_IRRITATER_PLUSHABLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.OTTER_PLUSHABLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.SHRUMP_PLUSHABLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.WHALE_PLUSHABLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.GOLDFISH_PLUSHABLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.TRATER_PLUSHABLE, RenderLayer.getCutout());

    /* Complex Plushables */
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.RUPERT_BLOCK, RenderLayer.getCutout());

    /* Config Sync Networking Packet Client Receipt */
    ClientPlayNetworking.registerGlobalReceiver(ConfigPacketHandler.PACKET_ID, ((client, handler, buf, responseSender) -> {
      var packet = ConfigPacketHandler.ConfigPacket.read(buf);
      client.execute(() -> {
        PlushablesNetworking.priorityConfig(packet.enable_basket, packet.allow_all_block_items_in_baskets);
      });
    }));

    /* Sound Event Networking Packet Client Receipt */
    ClientPlayNetworking.registerGlobalReceiver(SoundPacketHandler.PACKET_ID_PLAYER, ((client, handler, buf, responseSender) -> {
      var packet = SoundPacketHandler.PlayerSoundPacket.read(buf);
      SoundEvent decodedSoundEvent = PacketDecoder.decodeSoundEvent(packet.soundIdentifier);
      if (packet.player == client.player.getUuid())
        return;
      client.execute(() -> {
        if (client.world == null)
          return;
        PlushablesNetworking.playSoundOnClient(decodedSoundEvent, client.world, BlockPos.ofFloored(packet.pos), 1f, packet.pitch);

      });
    }));

    /* Sound Event Networking Packet Client Receipt */
    ClientPlayNetworking.registerGlobalReceiver(SoundPacketHandler.PACKET_ID_NO_PLAYER, ((client, handler, buf, responseSender) -> {
      var packet = SoundPacketHandler.NoPlayerSoundPacket.read(buf);
      SoundEvent decodedSoundEvent = PacketDecoder.decodeSoundEvent(packet.soundIdentifier);
      client.execute(() -> {
        if (client.world == null)
          return;
        PlushablesNetworking.playSoundOnClient(decodedSoundEvent, client.world, BlockPos.ofFloored(packet.pos), 1f, packet.pitch);

      });
    }));

    /* Particle Networking Packet Client Receipt */
    ClientPlayNetworking.registerGlobalReceiver(ParticlePacketHandler.PACKET_ID, ((client, handler, buf, responseSender) -> {
      var packet = ParticlePacketHandler.ParticlePacket.read(buf);
      ParticleEffect decodedParticles = PacketDecoder.decodeParticle(packet.particleIdentifier);
      if (packet.player == client.player.getUuid())
        return;
      client.execute(() -> {
        if (client.world == null)
          return;
        PlushablesNetworking.spawnParticlesOnClient(decodedParticles, client.world, BlockPos.ofFloored(packet.pos), packet.particleCount, packet.offset, packet.spread);

      });
    }));

    /* Animation Event Networking Packet Client Receipt */
    ClientPlayNetworking.registerGlobalReceiver(AnimationPacketHandler.PACKET_ID, ((client, handler, buf, responseSender) -> {
      var packet = AnimationPacketHandler.AnimationPacket.read(buf);

      if (packet.player == client.player.getUuid())
        return;
      client.execute(() -> {
        if (client.world == null)
          return;
        PlushablesNetworking.playAnimationOnClient(packet.shouldAnimate, client.world, BlockPos.ofFloored(packet.pos), packet.animationName);

      });
    }));
  }
}
