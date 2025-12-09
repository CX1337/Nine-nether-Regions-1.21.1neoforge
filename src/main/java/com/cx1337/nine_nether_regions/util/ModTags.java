package com.cx1337.nine_nether_regions.util;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import net.minecraft.ResourceLocationException;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_COPPER_TOOL =
                createTag("needs_copper_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL =
                createTag("incorrect_for_copper_tool");
        public static final TagKey<Block> NEEDS_STEEL_TOOL =
                createTag("needs_steel_tool");
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL =
                createTag("incorrect_for_steel_tool");
        public static final TagKey<Block> NEEDS_RAINBOWGEM_TOOL =
                createTag("needs_rainbowgem_tool");
        public static final TagKey<Block> INCORRECT_FOR_RAINBOWGEM_TOOL =
                createTag("incorrect_for_rainbowgem_tool");
        public static final TagKey<Block> NEEDS_RUBY_TOOL =
                createTag("needs_rainbowgem_tool");
        public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL =
                createTag("incorrect_for_rainbowgem_tool");
        public static final TagKey<Block> NEEDS_HELLALLOY_TOOL =
                createTag("needs_hellalloy_tool");
        public static final TagKey<Block> INCORRECT_FOR_HELLALLOY_TOOL =
                createTag("incorrect_for_hellalloy_tool");
        public static final TagKey<Block> NEEDS_STYX_TOOL =
                createTag("needs_styx_tool");
        public static final TagKey<Block> INCORRECT_FOR_STYX_TOOL =
                createTag("incorrect_for_styx_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, name));
        }

    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, name));
        }
    }
}
