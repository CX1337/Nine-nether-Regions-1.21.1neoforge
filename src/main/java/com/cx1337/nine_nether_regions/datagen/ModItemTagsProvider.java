package com.cx1337.nine_nether_regions.datagen;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.block.ModBlocks;
import com.cx1337.nine_nether_regions.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, NineNetherRegions.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //喂养相关
        tag(ItemTags.GOAT_FOOD)
                .add(ModItems.AMETHYST_BEETROOT.get());
        tag(ItemTags.HORSE_FOOD)
                .add(ModItems.GHOSTLIUM_APPLE.get())
                .add(ModItems.ENCHANTED_GHOSTLIUM_APPLE.get());
        tag(ItemTags.HOGLIN_FOOD)
                .add(ModItems.GHOSTLIUM.get());

        //物品相关
        tag(ItemTags.AXES)
                .add(ModItems.STEEL_AXE.get())
                .add(ModItems.COPPER_AXE.get())
                .add(ModItems.HELLALLOY_AXE.get())
                .add(ModItems.RAINBOWGEM_AXE.get())
                .add(ModItems.VOIDRITE_AXE.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.STYX_PICKAXE.get())
                .add(ModItems.HELLALLOY_PICKAXE.get())
                .add(ModItems.STEEL_PICKAXE.get())
                .add(ModItems.COPPER_PICKAXE.get())
                .add(ModItems.RAINBOWGEM_PICKAXE.get())
                .add(ModItems.VOIDRITE_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.HELLALLOY_SHOVEL.get())
                .add(ModItems.STEEL_SHOVEL.get())
                .add(ModItems.COPPER_SHOVEL.get())
                .add(ModItems.RAINBOWGEM_SHOVEL.get())
                .add(ModItems.VOIDRITE_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.HELLALLOY_HOE.get())
                .add(ModItems.STEEL_HOE.get())
                .add(ModItems.COPPER_HOE.get())
                .add(ModItems.RAINBOWGEM_HOE.get())
                .add(ModItems.VOIDRITE_HOE.get());
        tag(ItemTags.SWORDS)
                .add(ModItems.AMETHYST_DAGGER.get())
                .add(ModItems.STEEL_SWORD.get())
                .add(ModItems.COPPER_SWORD.get())
                .add(ModItems.RAINBOWGEM_SWORD.get())
                .add(ModItems.RUBY_SWORD.get())
                .add(ModItems.HELLALLOY_SWORD.get())
                .add(ModItems.STYX_SWORD.get())
                .add(ModItems.VOIDRITE_SWORD.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.WOOD_HELMET.get())
                .add(ModItems.CHERRY_HELMET.get())
                .add(ModItems.COPPER_HELMET.get())
                .add(ModItems.STEEL_HELMET.get())
                .add(ModItems.RAINBOWGEM_HELMET.get())
                .add(ModItems.VOIDRITE_HELMET.get())
                .add(ModItems.HELLALLOY_HELMET.get())
                .add(ModItems.STYX_HELMET.get());
        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.WOOD_CHESTPLATE.get())
                .add(ModItems.CHERRY_CHESTPLATE.get())
                .add(ModItems.COPPER_CHESTPLATE.get())
                .add(ModItems.STEEL_CHESTPLATE.get())
                .add(ModItems.RAINBOWGEM_CHESTPLATE.get())
                .add(ModItems.VOIDRITE_CHESTPLATE.get())
                .add(ModItems.HELLALLOY_CHESTPLATE.get())
                .add(ModItems.STYX_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.WOOD_LEGGINGS.get())
                .add(ModItems.CHERRY_LEGGINGS.get())
                .add(ModItems.COPPER_LEGGINGS.get())
                .add(ModItems.STEEL_LEGGINGS.get())
                .add(ModItems.RAINBOWGEM_LEGGINGS.get())
                .add(ModItems.VOIDRITE_LEGGINGS.get())
                .add(ModItems.HELLALLOY_LEGGINGS.get())
                .add(ModItems.STYX_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.WOOD_BOOTS.get())
                .add(ModItems.CHERRY_BOOTS.get())
                .add(ModItems.COPPER_BOOTS.get())
                .add(ModItems.STEEL_BOOTS.get())
                .add(ModItems.RAINBOWGEM_BOOTS.get())
                .add(ModItems.VOIDRITE_BOOTS.get())
                .add(ModItems.HELLALLOY_BOOTS.get())
                .add(ModItems.STYX_BOOTS.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.WOOD_HELMET.get())
                .add(ModItems.WOOD_CHESTPLATE.get())
                .add(ModItems.WOOD_LEGGINGS.get())
                .add(ModItems.WOOD_BOOTS.get())
                .add(ModItems.STEEL_HELMET.get())
                .add(ModItems.STEEL_CHESTPLATE.get())
                .add(ModItems.STEEL_LEGGINGS.get())
                .add(ModItems.STEEL_BOOTS.get())
                .add(ModItems.COPPER_HELMET.get())
                .add(ModItems.COPPER_CHESTPLATE.get())
                .add(ModItems.COPPER_LEGGINGS.get())
                .add(ModItems.COPPER_BOOTS.get())
                .add(ModItems.RAINBOWGEM_HELMET.get())
                .add(ModItems.RAINBOWGEM_CHESTPLATE.get())
                .add(ModItems.RAINBOWGEM_LEGGINGS.get())
                .add(ModItems.RAINBOWGEM_BOOTS.get())
                .add(ModItems.VOIDRITE_HELMET.get())
                .add(ModItems.VOIDRITE_CHESTPLATE.get())
                .add(ModItems.VOIDRITE_LEGGINGS.get())
                .add(ModItems.VOIDRITE_BOOTS.get());

        tag(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.HELLALLOY_LONGBOW.get());
        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.HELLALLOY_LONGBOW.get())
                .add(ModItems.ENDER_STAFF.get())
                .add(ModItems.FIRE_STAFF.get())
                .add(ModItems.VOID_STAFF.get())
                .add(ModItems.WITHER_STAFF.get());

        //木材
        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.HELLWOOD_LOG.get().asItem())
                .add(ModBlocks.HELLWOOD_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_HELLWOOD_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_HELLWOOD_WOOD.get().asItem());
        tag(ItemTags.PLANKS)
                .add(ModBlocks.HELLWOOD_PLANKS.asItem());
    }
}
