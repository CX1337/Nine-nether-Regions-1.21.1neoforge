package com.cx1337.nine_nether_regions.datagen;

import com.cx1337.nine_nether_regions.block.ModBlocks;
import com.cx1337.nine_nether_regions.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    public ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.@NotNull Provider provider) {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.EMPTY_FABRIC.getId(), new FurnaceFuel(400),false)
                .add(ModItems.WOOD_HELMET.getId(), new FurnaceFuel(800), false)
                .add(ModItems.WOOD_CHESTPLATE.getId(), new FurnaceFuel(800), false)
                .add(ModItems.WOOD_LEGGINGS.getId(), new FurnaceFuel(800), false)
                .add(ModItems.WOOD_BOOTS.getId(), new FurnaceFuel(800), false)
                .add(ModItems.CHERRY_STICK.getId(), new FurnaceFuel(200), false)
                .add(ModItems.UNDERWORLD_CRYSTAL.getId(), new FurnaceFuel(3200), false)
                .add(ModBlocks.UNDERWORLD_CRYSTAL_ORE.getId(), new FurnaceFuel(32000), false)
                .add(ModBlocks.HELL_NUCLEUS.getId(), new FurnaceFuel(4444000), false);
}
}
