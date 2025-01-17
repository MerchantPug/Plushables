package com.seacroak.plushables.block.tile;

import com.seacroak.plushables.registry.TileRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class DragonTileEntity extends AnimatronicBlockEntity {
  public DragonTileEntity(BlockPos pos, BlockState state) {
    super(TileRegistry.DRAGON_TILE, pos, state);
  }
}
