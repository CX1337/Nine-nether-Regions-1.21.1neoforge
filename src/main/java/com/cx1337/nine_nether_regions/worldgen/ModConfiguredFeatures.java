package com.cx1337.nine_nether_regions.worldgen;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERWORLD_SPIRIT_STONE_OVERWORLD_KEY =
            registerKey("underworld_spirit_stone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERWORLD_CRYSTAL_ORE_NETHER_KEY =
            registerKey("underworld_crystal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VOID_NEBULA_END_KEY =
            registerKey("void_nebula");

    public static final ResourceKey<ConfiguredFeature<?, ?>> HELLWOOD_KEY =
            registerKey("hellwood");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> underworldSpiritStoneOverworld = List.of(
              OreConfiguration.target(deepslateReplaceables, ModBlocks.UNDERWORLD_SPIRIT_STONE.get().defaultBlockState()));

        register(context, UNDERWORLD_SPIRIT_STONE_OVERWORLD_KEY, Feature.ORE,
                new OreConfiguration(underworldSpiritStoneOverworld, 3));
        register(context, UNDERWORLD_CRYSTAL_ORE_NETHER_KEY, Feature.ORE,
                new OreConfiguration(netherrackReplaceables, ModBlocks.UNDERWORLD_CRYSTAL_ORE.get().defaultBlockState(), 3));
        register(context, VOID_NEBULA_END_KEY, Feature.ORE,
                new OreConfiguration(endReplaceables, ModBlocks.VOID_NEBULA.get().defaultBlockState(), 3));

        register(context, HELLWOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.HELLWOOD_LOG.get()),
                new ForkingTrunkPlacer(7, 4, 3),

                BlockStateProvider.simple(ModBlocks.HELLWOOD_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 5),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key,
                                                                                          F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
