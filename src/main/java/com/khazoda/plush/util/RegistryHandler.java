package com.khazoda.plush.util;

import com.khazoda.plush.common.ModBlocks;
import com.khazoda.plush.common.ModItems;
import com.khazoda.plush.common.block.Block_PenguinBaby;
import com.khazoda.plush.common.block.Block_RedPanda;
import com.khazoda.plush.common.block.Block_Tacocat;
import com.khazoda.plush.common.block.Block_Tacosaur;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        final Block[] blocks = {
                new Block_PenguinBaby(),
                new Block_RedPanda(),
                new Block_Tacocat(),
                new Block_Tacosaur()
        };

        for (Block block : blocks) { //Sets Creative Tab for all blocks
            block.setCreativeTab(ModItems.tabPlushables);
        };

        final IForgeRegistry<Block> registry = event.getRegistry();
        registry.registerAll(blocks);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        final Item[] items = {
                new ItemBlock(ModBlocks.penguin_baby).setRegistryName(ModBlocks.penguin_baby.getRegistryName()),
                new ItemBlock(ModBlocks.red_panda).setRegistryName(ModBlocks.red_panda.getRegistryName()),
                new ItemBlock(ModBlocks.tacocat).setRegistryName(ModBlocks.tacocat.getRegistryName()),
                new ItemBlock(ModBlocks.tacosaur).setRegistryName(ModBlocks.tacosaur.getRegistryName())

        };

        for (Item item : items) { //Sets Creative Tab for all items
            item.setCreativeTab(ModItems.tabPlushables);
        };

        final IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(items);
    }
}
