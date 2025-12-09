package com.cx1337.nine_nether_regions.datagen;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.block.ModBlocks;
import com.cx1337.nine_nether_regions.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.LinkedHashMap;
import java.util.List;

public class ModItemModelsProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NineNetherRegions.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.AMETHYST_BEETROOT.get());
        basicItem(ModItems.CAVES_MUSIC_DISC.get());
        basicItem(ModItems.GHOSTLIUM_APPLE.get());
        basicItem(ModItems.ENCHANTED_GHOSTLIUM_APPLE.get());
        basicItem(ModItems.WEB_FRUIT.get());
        basicItem(ModItems.BLOODBLADE_ESSENCE.get());
        basicItem(ModItems.BLOODBLADE_PEAK_MUSIC_DISC.get());
        basicItem(ModItems.CHERRY_STICK.get());
        basicItem(ModItems.DIAMOND_BOWSTRING.get());
        basicItem(ModItems.EMPTY_FABRIC.get());
        basicItem(ModItems.FLUORESCENCE_FOREST_MUSIC_DISC.get());
        basicItem(ModItems.MAGIC_FABRIC.get());
        basicItem(ModItems.MANJUSAKA_PLAIN_MUSIC_DISC.get());
        basicItem(ModItems.STYX_FABRIC.get());
        basicItem(ModItems.STYX_TEAR.get());
        basicItem(ModItems.STYX_FERRYMAN_MUSIC_DISC.get());
        basicItem(ModItems.GHOSTLIUM.get());
        basicItem(ModItems.HELLALLOY_INGOT.get());
        basicItem(ModItems.STYX_INGOT.get());
        basicItem(ModItems.STEEL_BASE.get());
        basicItem(ModItems.STEEL_INGOT.get());
        basicItem(ModItems.STEEL_NUGGET.get());
        basicItem(ModItems.COPPER_NUGGET.get());
        basicItem(ModItems.RUBY.get());
        basicItem(ModItems.RAINBOWGEM.get());
        basicItem(ModItems.THE_STYX_MUSIC_DISC.get());
        basicItem(ModItems.UNDERWORLD_BRICK.get());
        basicItem(ModItems.UNDERWORLD_CRYSTAL.get());
        basicItem(ModItems.UNDERWORLD_ABYSS_MUSIC_DISC.get());
        basicItem(ModItems.FIRE_CORE.get());
        basicItem(ModItems.WITHER_CORE.get());
        basicItem(ModItems.VOID_CORE.get());
        basicItem(ModItems.WEB_BALL.get());
        basicItem(ModItems.WEB_FRUIT.get());
        basicItem(ModItems.HELLALLOY_ROD.get());
        basicItem(ModItems.NETHERITE_ROD.get());
        basicItem(ModBlocks.HELLWOOD_DOOR.asItem());

        //盔甲。
        for (var sup : List.of(ModItems.HELLALLOY_HELMET, ModItems.HELLALLOY_CHESTPLATE,ModItems.HELLALLOY_LEGGINGS,
                ModItems.HELLALLOY_BOOTS)){
            basicItem(sup.get());
        }
        for (var sup : List.of(ModItems.RAINBOWGEM_HELMET, ModItems.RAINBOWGEM_CHESTPLATE,ModItems.RAINBOWGEM_LEGGINGS,
                ModItems.RAINBOWGEM_BOOTS)){
            basicItem(sup.get());
        }
        for (var sup : List.of(ModItems.STYX_HELMET, ModItems.STYX_CHESTPLATE,ModItems.STYX_LEGGINGS, ModItems.STYX_BOOTS)){
            basicItem(sup.get());
        }
        for (var sup : List.of(ModItems.STEEL_HELMET, ModItems.STEEL_CHESTPLATE,ModItems.STEEL_LEGGINGS, ModItems.STEEL_BOOTS,
                ModItems.STEEL_HORSE_ARMOR)){
            basicItem(sup.get());
        }
        for (var sup : List.of(ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE,ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS,
                ModItems.COPPER_HORSE_ARMOR)){
            basicItem(sup.get());
        }
        for (var sup : List.of(ModItems.WOOD_HELMET, ModItems.WOOD_CHESTPLATE,ModItems.WOOD_LEGGINGS, ModItems.WOOD_BOOTS)){
            basicItem(sup.get());
        }
        for (var sup : List.of(ModItems.CHERRY_HELMET, ModItems.CHERRY_CHESTPLATE,ModItems.CHERRY_LEGGINGS, ModItems.CHERRY_BOOTS)){
            basicItem(sup.get());
        }

        //工具武器类的物品均放在handheldItem中。
        handheldItem(ModItems.DAMAGE_TEST.get());
        handheldItem(ModItems.ALLOY_HILT.get());
        handheldItem(ModItems.AMETHYST_DAGGER.get());
        handheldItem(ModItems.HELLALLOY_AXE.get());
        handheldItem(ModItems.HELLALLOY_HOE.get());
        handheldItem(ModItems.HELLALLOY_PICKAXE.get());
        handheldItem(ModItems.HELLALLOY_SHOVEL.get());
        handheldItem(ModItems.HELLALLOY_SWORD.get());
        handheldItem(ModItems.COPPER_AXE.get());
        handheldItem(ModItems.COPPER_HOE.get());
        handheldItem(ModItems.COPPER_PICKAXE.get());
        handheldItem(ModItems.COPPER_SHOVEL.get());
        handheldItem(ModItems.COPPER_SWORD.get());
        handheldItem(ModItems.STEEL_AXE.get());
        handheldItem(ModItems.STEEL_HOE.get());
        handheldItem(ModItems.STEEL_PICKAXE.get());
        handheldItem(ModItems.STEEL_SHOVEL.get());
        handheldItem(ModItems.STEEL_SWORD.get());
        handheldItem(ModItems.RAINBOWGEM_AXE.get());
        handheldItem(ModItems.RAINBOWGEM_HOE.get());
        handheldItem(ModItems.RAINBOWGEM_PICKAXE.get());
        handheldItem(ModItems.RAINBOWGEM_SHOVEL.get());
        handheldItem(ModItems.RAINBOWGEM_SWORD.get());
        handheldItem(ModItems.RUBY_SWORD.get());
        handheldItem(ModItems.STYX_PICKAXE.get());

        //basicItem(ModBlocks.???_DOOR.asItem),门和活板门有专用贴图需要绘制。

        buttonItem(ModBlocks.UNDERWORLD_BRICK_BUTTON,ModBlocks.UNDERWORLD_BRICKS);
        buttonItem(ModBlocks.HELLWOOD_BUTTON, ModBlocks.HELLWOOD_PLANKS);
        fenceItem(ModBlocks.UNDERWORLD_BRICK_FENCE, ModBlocks.UNDERWORLD_BRICKS);
        fenceItem(ModBlocks.HELLWOOD_FENCE, ModBlocks.HELLWOOD_PLANKS);
        wallItem(ModBlocks.UNDERWORLD_BRICK_WALL, ModBlocks.UNDERWORLD_BRICKS);

        //花
        withExistingParent("manjusaka", mcLoc("item/generated"))
                .texture("layer0", modLoc("block/manjusaka_top"));

        //树苗
        saplingItem(ModBlocks.HELLWOOD_SAPLING);
    }


    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "block/" + item.getId().getPath()));
    }
}

