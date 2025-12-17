package com.cx1337.nine_nether_regions.worldgen;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> UNDERWORLD_SPIRIT_STONE_PLACED_KEY =
            registerKey("underworld_spirit_stone_placed");
    public static final ResourceKey<PlacedFeature> UNDERWORLD_CRYSTAL_ORE_PLACED_KEY =
            registerKey("underworld_crystal_ore_placed");
    public static final ResourceKey<PlacedFeature> VOID_NEBULA_PLACED_KEY =
            registerKey("void_nebula_placed");

    public static final ResourceKey<PlacedFeature> HELLWOOD_PLACED_KEY =
            registerKey("hellwood_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, UNDERWORLD_SPIRIT_STONE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.UNDERWORLD_SPIRIT_STONE_OVERWORLD_KEY),
                ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
                        VerticalAnchor.absolute(-40))));
        register(context, UNDERWORLD_CRYSTAL_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.UNDERWORLD_CRYSTAL_ORE_NETHER_KEY),
                ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(4),
                        VerticalAnchor.absolute(44))));
        register(context, VOID_NEBULA_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.VOID_NEBULA_END_KEY),
                ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(0),
                        VerticalAnchor.absolute(66))));

        register(context, HELLWOOD_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.HELLWOOD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1),
                        ModBlocks.HELLWOOD_SAPLING.get()));
    }

     private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, name));
    }
    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
