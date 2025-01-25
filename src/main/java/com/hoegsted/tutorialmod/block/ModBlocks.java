package com.hoegsted.tutorialmod.block;

import com.hoegsted.tutorialmod.TutorialMod;
import com.hoegsted.tutorialmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("tutorialmod:alexandrite_block")))
            ));

    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("tutorialmod:raw_alexandrite_block")))
            ));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name,
                ()-> new BlockItem(block.get(), new Item.Properties().useItemDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("tutorialmod:" + name)))));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
