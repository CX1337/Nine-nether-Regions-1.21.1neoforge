package com.cx1337.nine_nether_regions.item;

import com.cx1337.nine_nether_regions.util.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier COPPER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
            190, 5.0F, 2.0F, 13, () -> Ingredient.of(Items.COPPER_INGOT));
    public static final Tier STEEL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL,
            648, 8.0F, 3.0F, 16, () -> Ingredient.of(ModItems.STEEL_INGOT));
    public static final Tier RAINBOWGEM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_RAINBOWGEM_TOOL,
            2077, 10.0F, 4.0F, 18, () -> Ingredient.of(ModItems.RAINBOWGEM));
    public static final Tier VOIDRITE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_VOIDRITE_TOOL,
            3025, 12.0F, 5.0F, 20, () -> Ingredient.of(ModItems.VOIDRITE_INGOT));
    public static final Tier RUBY = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL,
            24, 9.0F, 19.0F, 18, () -> Ingredient.of(ModItems.RUBY));
    public static final Tier AMETHYST = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_AMETHYST_TOOL,
            114, 5.0F, 1.0F, 10, () -> Ingredient.of(Items.AMETHYST_SHARD));
    public static final Tier HELLALLOY = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_HELLALLOY_TOOL,
           4444, 18.0F, 11.0F, 28, () -> Ingredient.of(ModItems.HELLALLOY_INGOT) );
    public static final Tier STYX = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_STYX_TOOL,
            46664, 24.0F, 17.0F, 44, () -> Ingredient.of(ModItems.STYX_INGOT) );
}
