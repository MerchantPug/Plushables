package com.seacroak.plushables.registry;

import com.seacroak.plushables.client.entityrenderers.HatRackEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;

public class EntityRendererRegistry {
  public static void initClient() {
    BlockEntityRendererRegistry.register(TileRegistry.HAT_RACK_TILE, HatRackEntityRenderer::new);
  }
}
