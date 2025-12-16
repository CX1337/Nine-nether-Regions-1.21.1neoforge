package com.cx1337.nine_nether_regions.item;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.awt.desktop.OpenURIEvent;
import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NineNetherRegions.MODID);

    public static final Supplier<CreativeModeTab> NineNetherRegions_Tab =
            CREATIVE_MODE_TABS.register("nine_nether_regions_materials_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.STYX_INGOT.get()))
                    .title(Component.translatable("itemGroup.nine_nether_regions_materials_tab"))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "textures/gui/tab_materials_tab.png"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.AMETHYST_DAGGER);
                        output.accept(ModItems.ALLOY_HILT);

                        output.accept(ModItems.NETHERITE_ROD);
                        output.accept(ModItems.HELLALLOY_ROD);
                        output.accept(ModItems.DIAMOND_BOWSTRING);
                        output.accept(ModItems.UNDERWORLD_BRICK);
                        output.accept(ModItems.UNDERWORLD_CRYSTAL);
                        output.accept(ModItems.BLOODBLADE_ESSENCE);
                        output.accept(ModItems.GHOSTLIUM);
                        output.accept(ModItems.STYX_TEAR);
                        output.accept(ModItems.AMETHYST_BEETROOT);
                        output.accept(ModItems.GHOSTLIUM_APPLE);
                        output.accept(ModItems.ENCHANTED_GHOSTLIUM_APPLE);
                        output.accept(ModItems.WEB_BALL);
                        output.accept(ModItems.WEB_FRUIT);
                        output.accept(ModItems.EMPTY_FABRIC);
                        output.accept(ModItems.MAGIC_FABRIC);
                        output.accept(ModItems.STYX_FABRIC);

                        output.accept(ModItems.WOOD_HELMET);
                        output.accept(ModItems.WOOD_CHESTPLATE);
                        output.accept(ModItems.WOOD_LEGGINGS);
                        output.accept(ModItems.WOOD_BOOTS);
                        output.accept(ModItems.CHERRY_STICK);
                        output.accept(ModItems.CHERRY_HELMET);
                        output.accept(ModItems.CHERRY_CHESTPLATE);
                        output.accept(ModItems.CHERRY_LEGGINGS);
                        output.accept(ModItems.CHERRY_BOOTS);

                        output.accept(ModItems.COPPER_NUGGET);
                        output.accept(ModItems.COPPER_AXE);
                        output.accept(ModItems.COPPER_HOE);
                        output.accept(ModItems.COPPER_PICKAXE);
                        output.accept(ModItems.COPPER_SHOVEL);
                        output.accept(ModItems.COPPER_SWORD);
                        output.accept(ModItems.COPPER_HELMET);
                        output.accept(ModItems.COPPER_CHESTPLATE);
                        output.accept(ModItems.COPPER_LEGGINGS);
                        output.accept(ModItems.COPPER_BOOTS);
                        output.accept(ModItems.COPPER_HORSE_ARMOR);

                        output.accept(ModItems.STEEL_BASE);
                        output.accept(ModItems.STEEL_INGOT);
                        output.accept(ModItems.STEEL_NUGGET);
                        output.accept(ModItems.STEEL_AXE);
                        output.accept(ModItems.STEEL_HOE);
                        output.accept(ModItems.STEEL_PICKAXE);
                        output.accept(ModItems.STEEL_SHOVEL);
                        output.accept(ModItems.STEEL_SWORD);
                        output.accept(ModItems.STEEL_HELMET);
                        output.accept(ModItems.STEEL_CHESTPLATE);
                        output.accept(ModItems.STEEL_LEGGINGS);
                        output.accept(ModItems.STEEL_BOOTS);
                        output.accept(ModItems.STEEL_HORSE_ARMOR);

                        output.accept(ModItems.ENDER_STAFF);
                        output.accept(ModItems.FIRE_CORE);
                        output.accept(ModItems.FIRE_STAFF);
                        output.accept(ModItems.WITHER_CORE);
                        output.accept(ModItems.WITHER_STAFF);
                        output.accept(ModItems.VOID_CORE);
                        output.accept(ModItems.VOID_STAFF);

                        output.accept(ModItems.RUBY);
                        output.accept(ModItems.RAINBOWGEM);
                        output.accept(ModItems.RAINBOWGEM_AXE);
                        output.accept(ModItems.RAINBOWGEM_HOE);
                        output.accept(ModItems.RAINBOWGEM_PICKAXE);
                        output.accept(ModItems.RAINBOWGEM_SHOVEL);
                        output.accept(ModItems.RAINBOWGEM_HELMET);
                        output.accept(ModItems.RAINBOWGEM_CHESTPLATE);
                        output.accept(ModItems.RAINBOWGEM_LEGGINGS);
                        output.accept(ModItems.RAINBOWGEM_BOOTS);
                        output.accept(ModItems.RAINBOWGEM_SWORD);
                        output.accept(ModItems.RUBY_SWORD);

                        output.accept(ModItems.HELLALLOY_INGOT);
                        output.accept(ModItems.HELLALLOY_AXE);
                        output.accept(ModItems.HELLALLOY_HOE);
                        output.accept(ModItems.HELLALLOY_PICKAXE);
                        output.accept(ModItems.HELLALLOY_SHOVEL);
                        output.accept(ModItems.HELLALLOY_HELMET);
                        output.accept(ModItems.HELLALLOY_CHESTPLATE);
                        output.accept(ModItems.HELLALLOY_LEGGINGS);
                        output.accept(ModItems.HELLALLOY_BOOTS);
                        output.accept(ModItems.HELLALLOY_SWORD);
                        output.accept(ModItems.HELLALLOY_LONGBOW);

                        output.accept(ModItems.STYX_INGOT);
                        output.accept(ModItems.STYX_SWORD);
                        output.accept(ModItems.STYX_PICKAXE);
                        output.accept(ModItems.STYX_HELMET);
                        output.accept(ModItems.STYX_CHESTPLATE);
                        output.accept(ModItems.STYX_LEGGINGS);
                        output.accept(ModItems.STYX_BOOTS);

                        output.accept(ModItems.BLOODBLADE_PEAK_MUSIC_DISC);
                        output.accept(ModItems.CAVES_MUSIC_DISC);
                        output.accept(ModItems.FLUORESCENCE_FOREST_MUSIC_DISC);
                        output.accept(ModItems.MANJUSAKA_PLAIN_MUSIC_DISC);
                        output.accept(ModItems.THE_STYX_MUSIC_DISC);
                        output.accept(ModItems.UNDERWORLD_ABYSS_MUSIC_DISC);
                        output.accept(ModItems.STYX_FERRYMAN_MUSIC_DISC);
                    }).build());

    public static final Supplier<CreativeModeTab> NineNetherRegions_Blocks_Tab =
            CREATIVE_MODE_TABS.register("nine_nether_regions_blocks_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.STYX_LAMP.get()))
                    .title(Component.translatable("itemGroup.nine_nether_regions_blocks_tab"))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "textures/gui/tab_blocks_tab.png"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.HELLIGHT);
                        output.accept(ModBlocks.HELL_NUCLEUS);
                        output.accept(ModBlocks.HELL_LAMP);
                        output.accept(ModBlocks.STYX_LAMP);
                        output.accept(ModBlocks.CARVED_WINDOW);
                        output.accept(ModBlocks.UW_CARVED_WINDOW);
                        output.accept(ModBlocks.MANJUSAKA);
                        output.accept(ModBlocks.PINESAP);
                        output.accept(ModBlocks.BLOODBLADE_ORE);
                        output.accept(ModBlocks.BLOODBLADE_ROCK);
                        output.accept(ModBlocks.CRACKED_BLOODBLADE_ROCK);
                        output.accept(ModBlocks.HARDENED_BLOODBLADE_ROCK);
                        output.accept(ModBlocks.UNDERWORLD_SPIRIT_STONE);
                        output.accept(ModBlocks.UNDERWORLD_CRYSTAL_ORE);
                        output.accept(ModBlocks.BLOODY_SAND);
                        output.accept(ModBlocks.COMPACT_OBSIDIAN);
                        output.accept(ModBlocks.REINFORCED_OBSIDIAN);
                        output.accept(ModBlocks.FLUOROSCOPY_BLOCK);

                        output.accept(ModBlocks.HELLALLOY_BLOCK);
                        output.accept(ModBlocks.STEEL_BLOCK);
                        output.accept(ModBlocks.RUBY_BLOCK);
                        output.accept(ModBlocks.RAINBOWGEM_BLOCK);
                        output.accept(ModBlocks.STYX_BLOCK);

                        output.accept(ModBlocks.GLOWING_UNDERWORLD_BRICKS);
                        output.accept(ModBlocks.GLOWING_UNDERWORLD_BRICK_SLAB);
                        output.accept(ModBlocks.GLOWING_UNDERWORLD_BRICK_STAIRS);

                        output.accept(ModBlocks.UNDERWORLDRACK);
                        output.accept(ModBlocks.UNDERWORLD_BRICKS);
                        output.accept(ModBlocks.UNDERWORLD_BRICK_BUTTON);
                        output.accept(ModBlocks.UNDERWORLD_BRICK_FENCE);
                        output.accept(ModBlocks.UNDERWORLD_BRICK_FENCE_GATE);
                        output.accept(ModBlocks.UNDERWORLD_BRICK_SLAB);
                        output.accept(ModBlocks.UNDERWORLD_BRICK_STAIRS);
                        output.accept(ModBlocks.UNDERWORLD_BRICK_WALL);

                        output.accept(ModBlocks.HELLWOOD_LOG);
                        output.accept(ModBlocks.HELLWOOD_WOOD);
                        output.accept(ModBlocks.STRIPPED_HELLWOOD_LOG);
                        output.accept(ModBlocks.STRIPPED_HELLWOOD_WOOD);
                        output.accept(ModBlocks.HELLWOOD_PLANKS);
                        output.accept(ModBlocks.HELLWOOD_LEAVES);
                        output.accept(ModBlocks.HELLWOOD_SAPLING);
                        output.accept(ModBlocks.HELLWOOD_BUTTON);
                        output.accept(ModBlocks.HELLWOOD_FENCE);
                        output.accept(ModBlocks.HELLWOOD_FENCE_GATE);
                        output.accept(ModBlocks.HELLWOOD_DOOR);
                        output.accept(ModBlocks.HELLWOOD_TRAPDOOR);
                        output.accept(ModBlocks.HELLWOOD_PRESSURE_PLATE);
                        output.accept(ModBlocks.HELLWOOD_STAIRS);
                        output.accept(ModBlocks.HELLWOOD_SLAB);

                        output.accept(ModBlocks.NULL_BLOCK);
                        output.accept(ModBlocks.NULL_GRASSBLOCK);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
