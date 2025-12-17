package com.cx1337.nine_nether_regions.datagen;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.block.ModBlocks;
import com.cx1337.nine_nether_regions.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, Items.ENCHANTED_GOLDEN_APPLE, 1)
                .pattern("#R#")
                .pattern("#$#")
                .pattern("###")
                .define('#', Blocks.GOLD_BLOCK)
                .define('$', Items.GOLDEN_APPLE)
                .define('R', Items.ENCHANTED_BOOK)
                .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"enc_gold_apple");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.DRAGON_EGG, 2)
                .pattern("###")
                .pattern("R$R")
                .pattern("###")
                .define('#', ModItems.GHOSTLIUM)
                .define('$', Blocks.DRAGON_EGG)
                .define('R', ModItems.RUBY)
                .unlockedBy(getHasName(Blocks.DRAGON_EGG), has(Blocks.DRAGON_EGG))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"dragon_egg_new");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPACT_OBSIDIAN, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Blocks.OBSIDIAN)
                .unlockedBy(getHasName(Blocks.OBSIDIAN), has(Blocks.OBSIDIAN))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_OBSIDIAN, 1)
                .pattern("#$#")
                .pattern("$R$")
                .pattern("#$#")
                .define('$', Blocks.CRYING_OBSIDIAN)
                .define('#', ModBlocks.COMPACT_OBSIDIAN)
                .define('R', ModBlocks.HELLALLOY_BLOCK)
                .unlockedBy(getHasName(ModBlocks.COMPACT_OBSIDIAN), has(ModBlocks.COMPACT_OBSIDIAN))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HELL_NUCLEUS, 1)
                .pattern("#C#")
                .pattern("#$#")
                .pattern("#R#")
                .define('#', ModItems.UNDERWORLD_CRYSTAL)
                .define('$', Blocks.DRAGON_EGG)
                .define('R', Items.LAVA_BUCKET)
                .define('C', Blocks.CONDUIT)
                .unlockedBy(getHasName(Blocks.DRAGON_EGG), has(Blocks.DRAGON_EGG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.AMETHYST_BEETROOT, 1)
                .pattern("$#")
                .pattern("##")
                .define('#', Items.AMETHYST_SHARD)
                .define('$', Items.BEETROOT)
                .unlockedBy(getHasName(Items.BEETROOT), has(Items.BEETROOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.GHOSTLIUM_APPLE, 1)
                .pattern(" # ")
                .pattern("#$#")
                .pattern(" # ")
                .define('#', ModItems.GHOSTLIUM)
                .define('$', Items.GOLDEN_APPLE)
                .unlockedBy(getHasName(Items.GOLDEN_APPLE), has(Items.GOLDEN_APPLE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.ENCHANTED_GHOSTLIUM_APPLE, 1)
                .pattern("###")
                .pattern("#$#")
                .pattern("###")
                .define('#', ModItems.GHOSTLIUM)
                .define('$', Items.ENCHANTED_GOLDEN_APPLE)
                .unlockedBy(getHasName(Items.ENCHANTED_GOLDEN_APPLE), has(Items.ENCHANTED_GOLDEN_APPLE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.WEB_FRUIT, 1)
                .pattern(" # ")
                .pattern("#$#")
                .pattern(" # ")
                .define('#', ModItems.WEB_BALL)
                .define('$', Items.CHORUS_FRUIT)
                .unlockedBy(getHasName(Items.CHORUS_FRUIT), has(Items.CHORUS_FRUIT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AMETHYST_DAGGER, 1)
                .pattern("#")
                .pattern("$")
                .define('#', Items.AMETHYST_SHARD)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_UNDERWORLD_BRICKS, 5)
                .pattern("#$#")
                .pattern("$#$")
                .pattern("#$#")
                .define('#', ModBlocks.UNDERWORLD_BRICKS)
                .define('$', ModBlocks.HELLIGHT)
                .unlockedBy(getHasName(ModBlocks.HELLIGHT), has(ModBlocks.HELLIGHT))
                .unlockedBy(getHasName(ModBlocks.UNDERWORLD_BRICKS), has(ModBlocks.UNDERWORLD_BRICKS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HELL_LAMP, 1)
                .pattern("#C#")
                .pattern("$R$")
                .pattern("###")
                .define('#', ModBlocks.HELLWOOD_SLAB)
                .define('$', Items.PAPER)
                .define('R', ModItems.UNDERWORLD_CRYSTAL)
                .define('C', ModBlocks.HELLWOOD_PLANKS)
                .unlockedBy(getHasName(ModItems.UNDERWORLD_CRYSTAL), has(ModItems.UNDERWORLD_CRYSTAL))
                .unlockedBy(getHasName(ModBlocks.HELLWOOD_PLANKS), has(ModBlocks.HELLWOOD_PLANKS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STYX_LAMP, 1)
                .pattern("###")
                .pattern("#C#")
                .pattern("$R$")
                .define('#', ModBlocks.CARVED_WINDOW)
                .define('$', ModBlocks.BLOODY_SAND)
                .define('R', ModItems.RUBY)
                .define('C', Blocks.REDSTONE_BLOCK)
                .unlockedBy(getHasName(ModBlocks.BLOODY_SAND), has(ModBlocks.BLOODY_SAND))
                .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARVED_WINDOW, 4)
                .pattern("#$#")
                .pattern("$#$")
                .pattern("#$#")
                .define('#', Items.GLASS_PANE)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(Items.GLASS_PANE), has(Items.GLASS_PANE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.UW_CARVED_WINDOW, 8)
                .pattern("###")
                .pattern("#$#")
                .pattern("###")
                .define('#', ModBlocks.CARVED_WINDOW)
                .define('$', ModItems.UNDERWORLD_CRYSTAL)
                .unlockedBy(getHasName(ModBlocks.CARVED_WINDOW), has(ModBlocks.CARVED_WINDOW))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_BOWSTRING, 1)
                .pattern("# ")
                .pattern(" #")
                .pattern("# ")
                .define('#', Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FIRE_CORE, 1)
                .pattern(" $ ")
                .pattern("$#$")
                .pattern(" $ ")
                .define('#', Items.FIRE_CHARGE)
                .define('$', Items.BLAZE_ROD)
                .unlockedBy(getHasName(Items.BLAZE_ROD), has(Items.BLAZE_ROD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FIRE_STAFF, 1)
                .pattern(" # ")
                .pattern(" R ")
                .pattern(" R ")
                .define('#', ModItems.FIRE_CORE)
                .define('R', Items.CHAIN)
                .unlockedBy(getHasName(ModItems.FIRE_CORE), has(ModItems.FIRE_CORE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ENDER_STAFF, 1)
                .pattern("$#$")
                .pattern(" R ")
                .pattern(" R ")
                .define('#', Items.NETHER_STAR)
                .define('$', Items.ENDER_PEARL)
                .define('R', Items.DIAMOND)
                .unlockedBy(getHasName(Items.ENDER_PEARL), has(Items.ENDER_PEARL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WITHER_CORE, 1)
                .pattern("#$#")
                .pattern("$R$")
                .pattern("#$#")
                .define('#', Items.SOUL_SAND)
                .define('$', Items.WITHER_SKELETON_SKULL)
                .define('R', Items.NETHER_STAR)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WITHER_STAFF, 1)
                .pattern("$#$")
                .pattern(" R ")
                .pattern(" R ")
                .define('#', ModItems.WITHER_CORE)
                .define('$', Items.WITHER_SKELETON_SKULL)
                .define('R', ModItems.NETHERITE_ROD)
                .unlockedBy(getHasName(ModItems.WITHER_CORE), has(ModItems.WITHER_CORE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VOID_CORE, 1)
                .pattern("R$R")
                .pattern("$#$")
                .pattern("R$R")
                .define('#', Items.DRAGON_EGG)
                .define('$', Items.END_CRYSTAL)
                .define('R', Items.ENDER_EYE)
                .unlockedBy(getHasName(Items.DRAGON_EGG), has(Items.DRAGON_EGG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VOID_STAFF, 1)
                .pattern("$#$")
                .pattern(" R ")
                .pattern(" R ")
                .define('#', ModItems.VOID_CORE)
                .define('R', ModItems.VOIDRITE_ROD)
                .define('$', Items.END_CRYSTAL)
                .unlockedBy(getHasName(ModItems.VOID_CORE), has(ModItems.VOID_CORE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMPTY_FABRIC, 3)
                .pattern("###")
                .pattern("$$$")
                .pattern("###")
                .define('#', Items.STRING)
                .define('$', Items.WHITE_WOOL)
                .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HELLALLOY_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.HELLALLOY_INGOT)
                .unlockedBy(getHasName(ModItems.HELLALLOY_INGOT), has(ModItems.HELLALLOY_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HELLALLOY_LONGBOW, 1)
                .pattern("*##")
                .pattern("# $")
                .pattern("#$ ")
                .define('#', ModItems.HELLALLOY_ROD)
                .define('*', Items.AMETHYST_SHARD)
                .define('$', ModItems.DIAMOND_BOWSTRING)
                .unlockedBy(getHasName(ModItems.HELLALLOY_ROD), has(ModItems.HELLALLOY_ROD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STEEL_BASE, 1)
                .pattern("###")
                .pattern(" $ ")
                .pattern("###")
                .define('#', Items.IRON_INGOT)
                .define('$', Items.COAL)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STEEL_INGOT, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.STEEL_NUGGET)
                .unlockedBy(getHasName(ModItems.STEEL_NUGGET), has(ModItems.STEEL_NUGGET))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.STEEL_INGOT)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT), has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STEEL_AXE, 1)
                .pattern("## ")
                .pattern("#$ ")
                .pattern(" $ ")
                .define('#', ModItems.STEEL_INGOT)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT), has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STEEL_HOE, 1)
                .pattern("## ")
                .pattern(" $ ")
                .pattern(" $ ")
                .define('#', ModItems.STEEL_INGOT)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT), has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STEEL_PICKAXE, 1)
                .pattern("###")
                .pattern(" $ ")
                .pattern(" $ ")
                .define('#', ModItems.STEEL_INGOT)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT), has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STEEL_SHOVEL, 1)
                .pattern(" # ")
                .pattern(" $ ")
                .pattern(" $ ")
                .define('#', ModItems.STEEL_INGOT)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT), has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEEL_SWORD, 1)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" $ ")
                .define('#', ModItems.STEEL_INGOT)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT), has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEEL_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .define('#', ModItems.STEEL_INGOT)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT), has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEEL_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.STEEL_INGOT)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT), has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEEL_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.STEEL_INGOT)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT), has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEEL_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.STEEL_INGOT)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT), has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEEL_HORSE_ARMOR, 1)
                .pattern("  #")
                .pattern("###")
                .pattern("# #")
                .define('#', ModItems.STEEL_INGOT)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT), has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COPPER_INGOT, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.COPPER_NUGGET)
                .unlockedBy(getHasName(ModItems.COPPER_NUGGET), has(ModItems.COPPER_NUGGET))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"copper_ingot_no2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_AXE, 1)
                .pattern("## ")
                .pattern("#$ ")
                .pattern(" $ ")
                .define('#', Items.COPPER_INGOT)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_HOE, 1)
                .pattern("## ")
                .pattern(" $ ")
                .pattern(" $ ")
                .define('#', Items.COPPER_INGOT)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE, 1)
                .pattern("###")
                .pattern(" $ ")
                .pattern(" $ ")
                .define('#', Items.COPPER_INGOT)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL, 1)
                .pattern(" # ")
                .pattern(" $ ")
                .pattern(" $ ")
                .define('#', Items.COPPER_INGOT)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_SWORD, 1)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" $ ")
                .define('#', Items.COPPER_INGOT)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .define('#', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .define('#', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_HORSE_ARMOR, 1)
                .pattern("  #")
                .pattern("###")
                .pattern("# #")
                .define('#', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOOD_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOOD_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOOD_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOOD_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHERRY_STICK, 6)
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .define('#', Items.CHERRY_PLANKS)
                .unlockedBy(getHasName(Items.CHERRY_PLANKS), has(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CHERRY_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .define('#', ModItems.CHERRY_STICK)
                .unlockedBy(getHasName(ModItems.CHERRY_STICK), has(ModItems.CHERRY_STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CHERRY_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.CHERRY_STICK)
                .unlockedBy(getHasName(ModItems.CHERRY_STICK), has(ModItems.CHERRY_STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CHERRY_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.CHERRY_STICK)
                .unlockedBy(getHasName(ModItems.CHERRY_STICK), has(ModItems.CHERRY_STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CHERRY_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.CHERRY_STICK)
                .unlockedBy(getHasName(ModItems.CHERRY_STICK), has(ModItems.CHERRY_STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET, 1)
                .pattern("#R#")
                .pattern("R R")
                .define('#', Items.IRON_NUGGET)
                .define('R', Items.CHAIN)
                .unlockedBy(getHasName(Items.CHAIN), has(Items.CHAIN))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"ch_helmet");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE, 1)
                .pattern("R R")
                .pattern("R#R")
                .pattern("#R#")
                .define('#', Items.IRON_NUGGET)
                .define('R', Items.CHAIN)
                .unlockedBy(getHasName(Items.CHAIN), has(Items.CHAIN))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"ch_chestplate");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS, 1)
                .pattern("R#R")
                .pattern("R R")
                .pattern("# #")
                .define('#', Items.IRON_NUGGET)
                .define('R', Items.CHAIN)
                .unlockedBy(getHasName(Items.CHAIN), has(Items.CHAIN))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"ch_leggings");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS, 1)
                .pattern("R R")
                .pattern("# #")
                .define('#', Items.IRON_NUGGET)
                .define('R', Items.CHAIN)
                .unlockedBy(getHasName(Items.CHAIN), has(Items.CHAIN))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"ch_boots");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY, 1)
                .pattern(" # ")
                .pattern("#$#")
                .pattern(" # ")
                .define('#', Items.REDSTONE)
                .define('$', ModItems.UNDERWORLD_CRYSTAL)
                .unlockedBy(getHasName(ModItems.UNDERWORLD_CRYSTAL), has(ModItems.UNDERWORLD_CRYSTAL))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAINBOWGEM, 1)
                .pattern(" # ")
                .pattern("$%&")
                .pattern(" R ")
                .define('#', Items.EMERALD)
                .define('$', ModItems.RUBY)
                .define('%', Items.DIAMOND)
                .define('&', Blocks.AMETHYST_CLUSTER)
                .define('R', Items.LAPIS_LAZULI)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAINBOWGEM_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RAINBOWGEM)
                .unlockedBy(getHasName(ModItems.RAINBOWGEM), has(ModItems.RAINBOWGEM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RAINBOWGEM_HELMET, 1)
                .pattern("###")
                .pattern("$ $")
                .define('#', ModItems.RAINBOWGEM)
                .define('$', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.RAINBOWGEM), has(ModItems.RAINBOWGEM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RAINBOWGEM_CHESTPLATE, 1)
                .pattern("$ $")
                .pattern("$$$")
                .pattern("#R#")
                .define('#', ModItems.RUBY)
                .define('$', ModItems.RAINBOWGEM)
                .define('R', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.RAINBOWGEM), has(ModItems.RAINBOWGEM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RAINBOWGEM_LEGGINGS, 1)
                .pattern("$$$")
                .pattern("$ $")
                .pattern("R R")
                .define('$', ModItems.RAINBOWGEM)
                .define('R', Items.EMERALD)
                .unlockedBy(getHasName(ModItems.RAINBOWGEM), has(ModItems.RAINBOWGEM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RAINBOWGEM_BOOTS, 1)
                .pattern("R R")
                .pattern("$ $")
                .define('$', Items.EMERALD)
                .define('R', ModItems.RAINBOWGEM)
                .unlockedBy(getHasName(ModItems.RAINBOWGEM), has(ModItems.RAINBOWGEM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RAINBOWGEM_AXE, 1)
                .pattern("R# ")
                .pattern("#$ ")
                .pattern(" $ ")
                .define('#', Items.EMERALD)
                .define('R', ModItems.RAINBOWGEM)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.RAINBOWGEM), has(ModItems.RAINBOWGEM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RAINBOWGEM_HOE, 1)
                .pattern("#R ")
                .pattern(" $ ")
                .pattern(" $ ")
                .define('#', Items.EMERALD)
                .define('R', ModItems.RAINBOWGEM)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.RAINBOWGEM), has(ModItems.RAINBOWGEM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RAINBOWGEM_PICKAXE, 1)
                .pattern("#R#")
                .pattern(" $ ")
                .pattern(" $ ")
                .define('#', Items.EMERALD)
                .define('R', ModItems.RAINBOWGEM)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.RAINBOWGEM), has(ModItems.RAINBOWGEM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RAINBOWGEM_SHOVEL, 1)
                .pattern(" # ")
                .pattern(" $ ")
                .pattern(" $ ")
                .define('#', ModItems.RAINBOWGEM)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.RAINBOWGEM), has(ModItems.RAINBOWGEM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RAINBOWGEM_SWORD, 1)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" $ ")
                .define('#', ModItems.RAINBOWGEM)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.RAINBOWGEM), has(ModItems.RAINBOWGEM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_SWORD, 1)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" $ ")
                .define('#', ModItems.RUBY)
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STYX_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.STYX_INGOT)
                .unlockedBy(getHasName(ModItems.STYX_INGOT), has(ModItems.STYX_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNDERWORLD_BRICK_FENCE, 8)
                .pattern("#$#")
                .pattern("#$#")
                .define('#', ModBlocks.UNDERWORLD_BRICKS)
                .define('$', ModItems.UNDERWORLD_BRICK)
                .unlockedBy(getHasName(ModItems.UNDERWORLD_BRICK), has(ModItems.UNDERWORLD_BRICK))
                .unlockedBy(getHasName(ModBlocks.UNDERWORLD_BRICKS),has(ModBlocks.UNDERWORLD_BRICKS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNDERWORLD_BRICK_FENCE_GATE, 2)
                .pattern("#$#")
                .pattern("#$#")
                .define('#', ModItems.UNDERWORLD_BRICK)
                .define('$', ModBlocks.UNDERWORLD_BRICKS)
                .unlockedBy(getHasName(ModItems.UNDERWORLD_BRICK), has(ModItems.UNDERWORLD_BRICK))
                .unlockedBy(getHasName(ModBlocks.UNDERWORLD_BRICKS),has(ModBlocks.UNDERWORLD_BRICKS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNDERWORLD_BRICKS, 1)
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.UNDERWORLD_BRICK)
                .unlockedBy(getHasName(ModItems.UNDERWORLD_BRICK), has(ModItems.UNDERWORLD_BRICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARDENED_BLOODBLADE_ROCK, 1)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.BLOODBLADE_ROCK)
                .unlockedBy(getHasName(ModBlocks.BLOODBLADE_ROCK), has(ModBlocks.BLOODBLADE_ROCK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK, 1)
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.RUBY)
                .unlockedBy(getHasName(ModItems.RUBY), has(ModItems.RUBY))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WEB_BALL, 1)
                .pattern("##")
                .pattern("##")
                .define('#', Blocks.COBWEB)
                .unlockedBy(getHasName(Blocks.COBWEB), has(Blocks.COBWEB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HELLALLOY_ROD, 4)
                .pattern("#")
                .pattern("#")
                .define('#', ModItems.HELLALLOY_INGOT)
                .unlockedBy(getHasName(ModItems.HELLALLOY_INGOT), has(ModItems.HELLALLOY_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VOIDRITE_ROD, 4)
                .pattern("#")
                .pattern("#")
                .define('#', ModItems.VOIDRITE_INGOT)
                .unlockedBy(getHasName(ModItems.VOIDRITE_INGOT), has(ModItems.VOIDRITE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NETHERITE_ROD, 4)
                .pattern("#")
                .pattern("#")
                .define('#', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ALLOY_HILT, 1)
                .pattern("$T$")
                .pattern("#%#")
                .pattern(" R ")
                .define('#', ModItems.HELLALLOY_ROD)
                .define('R', ModItems.HELLALLOY_INGOT)
                .define('%', Items.NETHERITE_SWORD)
                .define('$', ModItems.UNDERWORLD_BRICK)
                .define('T', ModBlocks.HELL_NUCLEUS)
                .unlockedBy(getHasName(Items.NETHERITE_SWORD), has(Items.NETHERITE_SWORD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HELLALLOY_SWORD, 1)
                .pattern(" QR")
                .pattern("TRQ")
                .pattern("#T ")
                .define('#', ModItems.ALLOY_HILT)
                .define('R', ModItems.HELLALLOY_INGOT)
                .define('Q', ModItems.HELLALLOY_ROD)
                .define('T', ModItems.NETHERITE_ROD)
                .unlockedBy(getHasName(ModItems.ALLOY_HILT), has(ModItems.ALLOY_HILT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HELLALLOY_HELMET, 1)
                .pattern("#$#")
                .pattern("# #")
                .define('#', ModItems.HELLALLOY_INGOT)
                .define('$', Items.AMETHYST_CLUSTER)
                .unlockedBy(getHasName(ModItems.HELLALLOY_INGOT), has(ModItems.HELLALLOY_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HELLALLOY_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("#$#")
                .pattern("###")
                .define('#', ModItems.HELLALLOY_INGOT)
                .define('$', ModBlocks.HELL_NUCLEUS)
                .unlockedBy(getHasName(ModItems.HELLALLOY_INGOT), has(ModItems.HELLALLOY_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HELLALLOY_LEGGINGS, 1)
                .pattern("###")
                .pattern("$ $")
                .pattern("# #")
                .define('#', ModItems.HELLALLOY_INGOT)
                .define('$', Items.AMETHYST_CLUSTER)
                .unlockedBy(getHasName(ModItems.HELLALLOY_INGOT), has(ModItems.HELLALLOY_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HELLALLOY_BOOTS, 1)
                .pattern("R R")
                .pattern("$ $")
                .pattern("# #")
                .define('#', ModItems.HELLALLOY_INGOT)
                .define('$', Items.AMETHYST_CLUSTER)
                .define('R', ModItems.HELLALLOY_ROD)
                .unlockedBy(getHasName(ModItems.HELLALLOY_INGOT), has(ModItems.HELLALLOY_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HELLALLOY_AXE, 1)
                .pattern("%R ")
                .pattern("%# ")
                .pattern(" # ")
                .define('#', ModItems.NETHERITE_ROD)
                .define('%', ModItems.HELLALLOY_INGOT)
                .define('R', Items.NETHERITE_SCRAP)
                .unlockedBy(getHasName(ModItems.HELLALLOY_INGOT), has(ModItems.HELLALLOY_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HELLALLOY_HOE, 1)
                .pattern("%R ")
                .pattern(" # ")
                .pattern(" # ")
                .define('#', ModItems.NETHERITE_ROD)
                .define('%', ModItems.HELLALLOY_INGOT)
                .define('R', Items.NETHERITE_SCRAP)
                .unlockedBy(getHasName(ModItems.HELLALLOY_INGOT), has(ModItems.HELLALLOY_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HELLALLOY_PICKAXE, 1)
                .pattern("%R%")
                .pattern(" # ")
                .pattern(" # ")
                .define('#', ModItems.NETHERITE_ROD)
                .define('%', ModItems.HELLALLOY_INGOT)
                .define('R', Items.NETHERITE_SCRAP)
                .unlockedBy(getHasName(ModItems.HELLALLOY_INGOT), has(ModItems.HELLALLOY_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HELLALLOY_SHOVEL, 1)
                .pattern(" % ")
                .pattern(" R ")
                .pattern(" # ")
                .define('#', ModItems.NETHERITE_ROD)
                .define('%', ModItems.HELLALLOY_INGOT)
                .define('R', Items.NETHERITE_SCRAP)
                .unlockedBy(getHasName(ModItems.HELLALLOY_INGOT), has(ModItems.HELLALLOY_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUOROSCOPY_BLOCK, 6)
                .pattern("#$#")
                .pattern("$#$")
                .pattern("#$#")
                .define('#', Items.GLASS)
                .define('$', Items.ICE)
                .unlockedBy(getHasName(Items.GLASS), has(Items.GLASS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VOIDRITE_INGOT, 1)
                .pattern("###")
                .pattern("$R$")
                .pattern("###")
                .define('#', ModItems.VOID_SHARD)
                .define('$', Items.ENDER_PEARL)
                .define('R', Items.ENDER_EYE)
                .unlockedBy(getHasName(ModItems.VOID_SHARD), has(ModItems.VOID_SHARD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VOIDRITE_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.VOIDRITE_INGOT)
                .unlockedBy(getHasName(ModItems.VOIDRITE_INGOT), has(ModItems.VOIDRITE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VOIDRITE_UPGRADE_SMITHING_TEMPLATE, 1)
                .pattern("$#$")
                .pattern("$R$")
                .pattern("#$#")
                .define('#', ModItems.VOID_SHARD)
                .define('$', Items.ENDER_EYE)
                .define('R', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .unlockedBy(getHasName(ModItems.VOID_SHARD), has(ModItems.VOID_SHARD))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNDERWORLD_BRICK_BUTTON, 4)
                .requires(ModBlocks.UNDERWORLD_BRICKS)
                .unlockedBy(getHasName(ModBlocks.UNDERWORLD_BRICKS), has(ModBlocks.UNDERWORLD_BRICKS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HELLALLOY_INGOT, 9)
                .requires(ModBlocks.HELLALLOY_BLOCK)
                .unlockedBy(getHasName(ModBlocks.HELLALLOY_BLOCK), has(ModBlocks.HELLALLOY_BLOCK))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_NUGGET, 9)
                .requires(Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"copper_nugget_no1");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_NUGGET, 9)
                .requires(ModItems.STEEL_INGOT)
                .unlockedBy(getHasName(ModItems.STEEL_INGOT), has(ModItems.STEEL_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT, 9)
                .requires(ModBlocks.STEEL_BLOCK)
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK), has(ModBlocks.STEEL_BLOCK))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"steel_ingot_no2");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.VOIDRITE_INGOT, 9)
                .requires(ModBlocks.VOIDRITE_BLOCK)
                .unlockedBy(getHasName(ModBlocks.VOIDRITE_BLOCK), has(ModBlocks.VOIDRITE_BLOCK))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"voidrite_ingot_no2");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STYX_INGOT, 9)
                .requires(ModBlocks.STYX_BLOCK)
                .unlockedBy(getHasName(ModBlocks.STYX_BLOCK), has(ModBlocks.STYX_BLOCK))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY, 4)
                .requires(ModBlocks.RUBY_BLOCK)
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK), has(ModBlocks.RUBY_BLOCK))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"ruby_no2");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAINBOWGEM, 9)
                .requires(ModBlocks.RAINBOWGEM_BLOCK)
                .unlockedBy(getHasName(ModBlocks.RAINBOWGEM_BLOCK), has(ModBlocks.RAINBOWGEM_BLOCK))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"rainbowgem_no2");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.VOIDRITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.RAINBOWGEM_AXE.get()),
                        Ingredient.of(ModItems.VOIDRITE_INGOT.get()),
                        RecipeCategory.TOOLS, ModItems.VOIDRITE_AXE.get())
                .unlocks("has_voidrite_ingot", has(ModItems.VOIDRITE_INGOT.get()))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"voidrite_axe_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.VOIDRITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.RAINBOWGEM_HOE.get()),
                        Ingredient.of(ModItems.VOIDRITE_INGOT.get()),
                        RecipeCategory.TOOLS, ModItems.VOIDRITE_HOE.get())
                .unlocks("has_voidrite_ingot", has(ModItems.VOIDRITE_INGOT.get()))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"voidrite_hoe_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.VOIDRITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.RAINBOWGEM_PICKAXE.get()),
                        Ingredient.of(ModItems.VOIDRITE_INGOT.get()),
                        RecipeCategory.TOOLS, ModItems.VOIDRITE_PICKAXE.get())
                .unlocks("has_voidrite_ingot", has(ModItems.VOIDRITE_INGOT.get()))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"voidrite_pickaxe_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.VOIDRITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.RAINBOWGEM_SHOVEL.get()),
                        Ingredient.of(ModItems.VOIDRITE_INGOT.get()),
                        RecipeCategory.TOOLS, ModItems.VOIDRITE_SHOVEL.get())
                .unlocks("has_voidrite_ingot", has(ModItems.VOIDRITE_INGOT.get()))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"voidrite_shovel_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.VOIDRITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.RAINBOWGEM_SWORD.get()),
                        Ingredient.of(ModItems.VOIDRITE_INGOT.get()),
                        RecipeCategory.COMBAT, ModItems.VOIDRITE_SWORD.get())
                .unlocks("has_voidrite_ingot", has(ModItems.VOIDRITE_INGOT.get()))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"voidrite_sword_smithing");

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ModItems.VOIDRITE_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(ModItems.RAINBOWGEM_HELMET.get()),
                Ingredient.of(ModItems.VOIDRITE_INGOT.get()),
                RecipeCategory.COMBAT, ModItems.VOIDRITE_HELMET.get())
                .unlocks("has_voidrite_ingot", has(ModItems.VOIDRITE_INGOT.get()))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"voidrite_helmet_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.VOIDRITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.RAINBOWGEM_CHESTPLATE.get()),
                        Ingredient.of(ModItems.VOIDRITE_INGOT.get()),
                        RecipeCategory.COMBAT, ModItems.VOIDRITE_CHESTPLATE.get())
                .unlocks("has_voidrite_ingot", has(ModItems.VOIDRITE_INGOT.get()))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"voidrite_chestplate_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.VOIDRITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.RAINBOWGEM_LEGGINGS.get()),
                        Ingredient.of(ModItems.VOIDRITE_INGOT.get()),
                        RecipeCategory.COMBAT, ModItems.VOIDRITE_LEGGINGS.get())
                .unlocks("has_voidrite_ingot", has(ModItems.VOIDRITE_INGOT.get()))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"voidrite_leggings_smithing");
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.VOIDRITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.RAINBOWGEM_BOOTS.get()),
                        Ingredient.of(ModItems.VOIDRITE_INGOT.get()),
                        RecipeCategory.COMBAT, ModItems.VOIDRITE_BOOTS.get())
                .unlocks("has_voidrite_ingot", has(ModItems.VOIDRITE_INGOT.get()))
                .save(recipeOutput, NineNetherRegions.MODID + ":" +"voidrite_boots_smithing");

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNDERWORLD_BRICK_WALL.get(),
                ModBlocks.UNDERWORLD_BRICKS.get(), 1);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNDERWORLD_BRICK_SLAB.get(),
                ModBlocks.UNDERWORLD_BRICKS.get(), 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNDERWORLD_BRICK_STAIRS.get(),
                ModBlocks.UNDERWORLD_BRICKS.get(), 1);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNDERWORLD_BRICK_FENCE.get(),
                ModBlocks.UNDERWORLD_BRICKS.get(), 1);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNDERWORLD_BRICK_FENCE_GATE.get(),
                ModBlocks.UNDERWORLD_BRICKS.get(), 1);

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNDERWORLD_BRICK_WALL.get(), ModBlocks.UNDERWORLD_BRICKS.get());

        stairBuilder(ModBlocks.GLOWING_UNDERWORLD_BRICK_STAIRS.get(),
                Ingredient.of(ModBlocks.GLOWING_UNDERWORLD_BRICKS)).group("glowing_underworld_bricks")
                .unlockedBy("has_glowing_underworld_bricks", has(ModBlocks.GLOWING_UNDERWORLD_BRICKS)).save(recipeOutput);
        stairBuilder(ModBlocks.HELLWOOD_STAIRS.get(),
                Ingredient.of(ModBlocks.HELLWOOD_PLANKS)).group("hellwood_planks")
                .unlockedBy("has_hellwood_planks", has(ModBlocks.HELLWOOD_PLANKS)).save(recipeOutput);
        stairBuilder(ModBlocks.UNDERWORLD_BRICK_STAIRS.get(),
                Ingredient.of(ModBlocks.UNDERWORLD_BRICKS)).group("underworld_bricks")
                .unlockedBy("has_underworld_bricks", has(ModBlocks.UNDERWORLD_BRICKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.GLOWING_UNDERWORLD_BRICK_SLAB.get(), ModBlocks.GLOWING_UNDERWORLD_BRICKS.get());
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.HELLWOOD_SLAB.get(), ModBlocks.HELLWOOD_PLANKS.get());
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.UNDERWORLD_BRICK_SLAB.get(), ModBlocks.UNDERWORLD_BRICKS.get());
        buttonBuilder(ModBlocks.HELLWOOD_BUTTON.get(),
                Ingredient.of(ModBlocks.HELLWOOD_PLANKS)).group("hellwood_planks")
                .unlockedBy("has_hellwood_planks", has(ModBlocks.HELLWOOD_PLANKS)).save(recipeOutput);
        pressurePlate(recipeOutput,
                ModBlocks.HELLWOOD_PRESSURE_PLATE.get(), ModBlocks.HELLWOOD_PLANKS.get());
        fenceBuilder(ModBlocks.HELLWOOD_FENCE.get(),
                Ingredient.of(ModBlocks.HELLWOOD_PLANKS)).group("hellwood_planks")
                .unlockedBy("has_hellwood_planks", has(ModBlocks.HELLWOOD_PLANKS)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.HELLWOOD_FENCE_GATE.get(),
                Ingredient.of(ModBlocks.HELLWOOD_PLANKS)).group("hellwood_planks")
                .unlockedBy("has_hellwood_planks", has(ModBlocks.HELLWOOD_PLANKS)).save(recipeOutput);
        doorBuilder(ModBlocks.HELLWOOD_DOOR.get(),
                Ingredient.of(ModBlocks.HELLWOOD_PLANKS)).group("hellwood_planks")
                .unlockedBy("has_hellwood_planks", has(ModBlocks.HELLWOOD_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.HELLWOOD_TRAPDOOR.get(),
                Ingredient.of(ModBlocks.HELLWOOD_PLANKS)).group("hellwood_planks")
                .unlockedBy("has_hellwood_planks", has(ModBlocks.HELLWOOD_PLANKS)).save(recipeOutput);



        //需要熔炼的物品请先到下方注册。Smelt熔炉，Blast高炉。
        oreBlasting(recipeOutput, BLOODBLADE_ESSENCE, RecipeCategory.MISC, ModItems.BLOODBLADE_ESSENCE, 1.40f, 244, "bloodblade_essence");
        oreSmelting(recipeOutput, CRACKED_BLOODBLADE_ROCK, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BLOODBLADE_ROCK, 0.10f, 200, "cracked_bloodblade_rock");
        oreSmelting(recipeOutput, RED_GLASS, RecipeCategory.BUILDING_BLOCKS, Blocks.RED_STAINED_GLASS, 0.10f, 150, "red_glass");
        oreSmelting(recipeOutput, UNDERWORLD_BRICK, RecipeCategory.MISC, ModItems.UNDERWORLD_BRICK, 0.10f, 150, "underworld_bricks");
        oreBlasting(recipeOutput, UNDERWORLD_BRICK, RecipeCategory.MISC, ModItems.UNDERWORLD_BRICK, 0.44f, 300, "underworld_bricks");
        oreBlasting(recipeOutput, GHOSTLIUM, RecipeCategory.MISC, ModItems.GHOSTLIUM, 1.00f, 200, "ghostlium");
        oreBlasting(recipeOutput, STEEL_INGOT, RecipeCategory.MISC, ModItems.STEEL_INGOT, 0.10f, 200, "steel_ingot");
        oreSmelting(recipeOutput, STEEL_NUGGET, RecipeCategory.MISC, ModItems.STEEL_NUGGET, 0.10f, 200, "steel_nugget");
        oreBlasting(recipeOutput, STEEL_NUGGET, RecipeCategory.MISC, ModItems.STEEL_NUGGET, 0.10f, 100, "steel_nugget");
        oreSmelting(recipeOutput, COPPER_NUGGET, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.10f, 200, "copper_nugget");
        oreBlasting(recipeOutput, COPPER_NUGGET, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.10f, 100, "copper_nugget");
        oreBlasting(recipeOutput, VOID_SHARD, RecipeCategory.MISC, ModItems.VOID_SHARD, 1.00f, 200, "void_shard");
    }
    //熔炼原料注册点。
    public static final List<ItemLike> BLOODBLADE_ESSENCE = List.of(ModBlocks.BLOODBLADE_ORE);
    public static final List<ItemLike> CRACKED_BLOODBLADE_ROCK = List.of(ModBlocks.BLOODBLADE_ROCK);
    public static final List<ItemLike> UNDERWORLD_BRICK = List.of(ModBlocks.UNDERWORLDRACK);
    public static final List<ItemLike> GHOSTLIUM = List.of(ModBlocks.UNDERWORLD_SPIRIT_STONE);
    public static final List<ItemLike> STEEL_INGOT = List.of(ModItems.STEEL_BASE);
    public static final List<ItemLike> STEEL_NUGGET = List.of(ModItems.STEEL_HELMET, ModItems.STEEL_CHESTPLATE,
            ModItems.STEEL_LEGGINGS, ModItems.STEEL_BOOTS, ModItems.STEEL_AXE, ModItems.STEEL_HOE, ModItems.STEEL_PICKAXE,
            ModItems.STEEL_SHOVEL, ModItems.STEEL_SWORD, ModItems.STEEL_HORSE_ARMOR);
    public static final List<ItemLike> COPPER_NUGGET = List.of(ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE,
            ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS, ModItems.COPPER_AXE, ModItems.COPPER_HOE, ModItems.COPPER_PICKAXE,
            ModItems.COPPER_SHOVEL, ModItems.COPPER_SWORD, ModItems.COPPER_HORSE_ARMOR);
    public static final List<ItemLike> RED_GLASS = List.of(ModBlocks.BLOODY_SAND);
    public static final List<ItemLike> VOID_SHARD = List.of(ModBlocks.VOID_NEBULA);

    protected static void oreSmelting(
            RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_smelting"
        );
    }

    protected static void oreBlasting(
            RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_blasting"
        );
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput recipeOutput,
            RecipeSerializer<T> serializer,
            AbstractCookingRecipe.Factory<T> recipeFactory,
            List<ItemLike> ingredients,
            RecipeCategory category,
            ItemLike result,
            float experience,
            int cookingTime,
            String group,
            String suffix
    ) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, serializer, recipeFactory)
                    .group(group)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, NineNetherRegions.MODID + ":" + getItemName(result) + suffix + "_" + getItemName(itemlike));
        }
    }
}
