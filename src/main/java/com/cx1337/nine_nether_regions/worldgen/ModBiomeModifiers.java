package com.cx1337.nine_nether_regions.worldgen;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_UNDERWORLD_SPIRIT_STONE =
            registerKey("add_underworld_spirit_stone");
    public static final ResourceKey<BiomeModifier> ADD_UNDERWORLD_CRYSTAL_ORE =
            registerKey("add_underworld_crystal_ore");
    public static final ResourceKey<BiomeModifier> ADD_VOID_NEBULA =
            registerKey("add_void_nebula");

    public static final ResourceKey<BiomeModifier> ADD_TREE_HELLWOOD =
            registerKey("add_tree_hellwood");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_UNDERWORLD_SPIRIT_STONE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.UNDERWORLD_SPIRIT_STONE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_UNDERWORLD_CRYSTAL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.UNDERWORLD_CRYSTAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_VOID_NEBULA, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.VOID_NEBULA_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_TREE_HELLWOOD, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SNOWY_PLAINS)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.HELLWOOD_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS,
                ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, name));
    }
}
