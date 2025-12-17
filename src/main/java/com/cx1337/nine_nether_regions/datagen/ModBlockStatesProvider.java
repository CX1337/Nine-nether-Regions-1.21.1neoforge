package com.cx1337.nine_nether_regions.datagen;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStatesProvider extends BlockStateProvider {
    public ModBlockStatesProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NineNetherRegions.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLOODY_SAND);
        blockWithItem(ModBlocks.BLOODBLADE_ROCK);
        blockWithItem(ModBlocks.CRACKED_BLOODBLADE_ROCK);
        blockWithItem(ModBlocks.HARDENED_BLOODBLADE_ROCK);
        blockWithItem(ModBlocks.BLOODBLADE_ORE);
        blockWithItem(ModBlocks.COMPACT_OBSIDIAN);
        blockWithItem(ModBlocks.REINFORCED_OBSIDIAN);
        blockWithItem(ModBlocks.GLOWING_UNDERWORLD_BRICKS);
        blockWithItem(ModBlocks.HELLALLOY_BLOCK);
        blockWithItem(ModBlocks.HELLIGHT);
        blockWithItem(ModBlocks.NULL_BLOCK);
        blockWithItem(ModBlocks.NULL_GRASSBLOCK);
        blockWithItem(ModBlocks.STYX_BLOCK);
        blockWithItem(ModBlocks.STEEL_BLOCK);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.RAINBOWGEM_BLOCK);
        blockWithItem(ModBlocks.UNDERWORLDRACK);
        blockWithItem(ModBlocks.UNDERWORLD_BRICKS);
        blockWithItem(ModBlocks.UNDERWORLD_SPIRIT_STONE);
        blockWithItem(ModBlocks.UNDERWORLD_CRYSTAL_ORE);
        blockWithItem(ModBlocks.VOID_NEBULA);
        blockWithItem(ModBlocks.VOIDRITE_BLOCK);

        buttonBlock(ModBlocks.UNDERWORLD_BRICK_BUTTON.get(), blockTexture(ModBlocks.UNDERWORLD_BRICKS.get()));
        //压力板同按钮。

        //门:doorBlockWithRenderType(ModBlocks.???_DOOR.get(), modLoc("block/???_door_bottom"), modLoc("block/???_door_top), "cutout");
        //活板门:trapdoorBlockWithRenderType(ModBlocks.???_TRAPDOOR.get(), modLoc("block/???_trapdoor"), true, "cutout")

        fenceBlock(ModBlocks.UNDERWORLD_BRICK_FENCE.get(), blockTexture(ModBlocks.UNDERWORLD_BRICKS.get()));
        fenceGateBlock(ModBlocks.UNDERWORLD_BRICK_FENCE_GATE.get(), blockTexture(ModBlocks.UNDERWORLD_BRICKS.get()));
        wallBlock(ModBlocks.UNDERWORLD_BRICK_WALL.get(), blockTexture(ModBlocks.UNDERWORLD_BRICKS.get()));

        stairsBlock(ModBlocks.GLOWING_UNDERWORLD_BRICK_STAIRS.get(), blockTexture(ModBlocks.GLOWING_UNDERWORLD_BRICKS.get()));
        stairsBlock(ModBlocks.UNDERWORLD_BRICK_STAIRS.get(), blockTexture(ModBlocks.UNDERWORLD_BRICKS.get()));
        slabBlock(ModBlocks.GLOWING_UNDERWORLD_BRICK_SLAB.get(),blockTexture(ModBlocks.GLOWING_UNDERWORLD_BRICKS.get()),
                blockTexture(ModBlocks.GLOWING_UNDERWORLD_BRICKS.get()));
        slabBlock(ModBlocks.UNDERWORLD_BRICK_SLAB.get(),blockTexture(ModBlocks.UNDERWORLD_BRICKS.get()),
                blockTexture(ModBlocks.UNDERWORLD_BRICKS.get()));

        blockItem(ModBlocks.GLOWING_UNDERWORLD_BRICK_SLAB);
        blockItem(ModBlocks.GLOWING_UNDERWORLD_BRICK_STAIRS);
        blockItem(ModBlocks.UNDERWORLD_BRICK_FENCE_GATE);
        blockItem(ModBlocks.UNDERWORLD_BRICK_SLAB);
        blockItem(ModBlocks.UNDERWORLD_BRICK_STAIRS);
        //blockItem(ModBlocks.???_TRAPDOOR, "_bottom");

        tallFlower(ModBlocks.MANJUSAKA);

        //树木
        logBlock(((RotatedPillarBlock) ModBlocks.HELLWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.HELLWOOD_WOOD.get()), blockTexture(ModBlocks.HELLWOOD_LOG.get()),
                blockTexture(ModBlocks.HELLWOOD_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_HELLWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_HELLWOOD_WOOD.get()), blockTexture(ModBlocks.STRIPPED_HELLWOOD_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_HELLWOOD_LOG.get()));

        blockItem(ModBlocks.HELLWOOD_LOG);
        blockItem(ModBlocks.HELLWOOD_WOOD);
        blockItem(ModBlocks.STRIPPED_HELLWOOD_LOG);
        blockItem(ModBlocks.STRIPPED_HELLWOOD_WOOD);

        blockWithItem(ModBlocks.HELLWOOD_PLANKS);

        leavesBlock(ModBlocks.HELLWOOD_LEAVES);
        saplingBlock(ModBlocks.HELLWOOD_SAPLING);

        stairsBlock(ModBlocks.HELLWOOD_STAIRS.get(), blockTexture(ModBlocks.HELLWOOD_PLANKS.get()));
        slabBlock(ModBlocks.HELLWOOD_SLAB.get(),blockTexture(ModBlocks.HELLWOOD_PLANKS.get()),
                blockTexture(ModBlocks.HELLWOOD_PLANKS.get()));
        buttonBlock(ModBlocks.HELLWOOD_BUTTON.get(), blockTexture(ModBlocks.HELLWOOD_PLANKS.get()));
        pressurePlateBlock(ModBlocks.HELLWOOD_PRESSURE_PLATE.get(), blockTexture(ModBlocks.HELLWOOD_PLANKS.get()));

        fenceBlock(ModBlocks.HELLWOOD_FENCE.get(), blockTexture(ModBlocks.HELLWOOD_PLANKS.get()));
        fenceGateBlock(ModBlocks.HELLWOOD_FENCE_GATE.get(), blockTexture(ModBlocks.HELLWOOD_PLANKS.get()));

        doorBlockWithRenderType(ModBlocks.HELLWOOD_DOOR.get(),
                modLoc("block/hellwood_door_bottom"), modLoc("block/hellwood_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.HELLWOOD_TRAPDOOR.get(),
                modLoc("block/hellwood_trapdoor"), true, "cutout");

        blockItem(ModBlocks.HELLWOOD_STAIRS);
        blockItem(ModBlocks.HELLWOOD_SLAB);
        blockItem(ModBlocks.HELLWOOD_PRESSURE_PLATE);
        blockItem(ModBlocks.HELLWOOD_FENCE_GATE);
        blockItem(ModBlocks.HELLWOOD_TRAPDOOR, "_bottom");
    }
    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(),
                        ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void tallFlower(DeferredBlock<?> flowerBlock) {
        String path = flowerBlock.getId().getPath();

        ModelFile bottomModel = models().cross(path + "_bottom", modLoc("block/" + path + "_bottom")).renderType("cutout");
        ModelFile topModel = models().cross(path + "_top", modLoc("block/" + path + "_top")).renderType("cutout");

        getVariantBuilder(flowerBlock.get())
                .partialState().with(TallFlowerBlock.HALF, DoubleBlockHalf.LOWER)
                .modelForState().modelFile(bottomModel).addModel()
                .partialState().with(TallFlowerBlock.HALF, DoubleBlockHalf.UPPER)
                .modelForState().modelFile(topModel).addModel();

        itemModels().withExistingParent(path, modLoc("block/" + path + "_top"));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("nine_nether_regions:block/" +
                deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("nine_nether_regions:block/" +
                deferredBlock.getId().getPath() + appendix));
    }
}
