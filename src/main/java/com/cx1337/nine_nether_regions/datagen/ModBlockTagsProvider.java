package com.cx1337.nine_nether_regions.datagen;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.block.ModBlocks;
import com.cx1337.nine_nether_regions.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NineNetherRegions.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        //信标基座方块
        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.RAINBOWGEM_BLOCK.get())
                .add(ModBlocks.HELLALLOY_BLOCK.get())
                .add(ModBlocks.STYX_BLOCK.get());

        //栅栏相关
        tag(BlockTags.FENCES)
                .add(ModBlocks.UNDERWORLD_BRICK_FENCE.get())
                .add(ModBlocks.HELLWOOD_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.UNDERWORLD_BRICK_FENCE_GATE.get())
                .add(ModBlocks.HELLWOOD_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.UNDERWORLD_BRICK_WALL.get());

        //植物相关
        tag(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.PINESAP.get());
        tag(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_PINESAP.get())
                .add(ModBlocks.POTTED_HELLWOOD_SAPLING.get());
        tag(BlockTags.SAPLINGS)
                .add(ModBlocks.HELLWOOD_SAPLING.get());

        // 工具不匹配标签 - 按照挖掘等级顺序排列
        //顺序：木质<石质=铜质<铁质<精钢质<钻石质<虹玉质≈下界合金质<幽冥合金质<冥河质。
// 木工具不正确
        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(ModBlocks.HELLALLOY_BLOCK.get())
                .add(ModBlocks.STYX_BLOCK.get());
// 金工具不正确
        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .add(ModBlocks.HELLALLOY_BLOCK.get())
                .add(ModBlocks.STYX_BLOCK.get());
// 石工具不正确
        tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .add(ModBlocks.HELLALLOY_BLOCK.get())
                .add(ModBlocks.STYX_BLOCK.get());
// 铁工具不正确
        tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .add(ModBlocks.HELLALLOY_BLOCK.get())
                .add(ModBlocks.STYX_BLOCK.get());
// 钻石工具不正确
        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(ModBlocks.HELLALLOY_BLOCK.get())
                .add(ModBlocks.STYX_BLOCK.get());
// 下界合金工具不正确
        tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .add(ModBlocks.STYX_BLOCK.get());
// 自定义挖掘等级标签
// 铜工具
        tag(ModTags.Blocks.NEEDS_COPPER_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.HELLALLOY_BLOCK.get())
                .add(ModBlocks.STYX_BLOCK.get());
// 紫水晶工具
        tag(ModTags.Blocks.NEEDS_AMETHYST_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_AMETHYST_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.HELLALLOY_BLOCK.get())
                .add(ModBlocks.STYX_BLOCK.get());
// 精钢工具
        tag(ModTags.Blocks.NEEDS_STEEL_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.HELLALLOY_BLOCK.get())
                .add(ModBlocks.STYX_BLOCK.get());
// 红宝石工具
        tag(ModTags.Blocks.NEEDS_RUBY_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.HELLALLOY_BLOCK.get())
                .add(ModBlocks.STYX_BLOCK.get());
// 虹玉工具
        tag(ModTags.Blocks.NEEDS_RAINBOWGEM_TOOL)
                .add(ModBlocks.HELLALLOY_BLOCK.get());
        tag(ModTags.Blocks.INCORRECT_FOR_RAINBOWGEM_TOOL)
                .add(ModBlocks.STYX_BLOCK.get());
// 虚空合金工具
        tag(ModTags.Blocks.NEEDS_VOIDRITE_TOOL)
                .add(ModBlocks.HELLALLOY_BLOCK.get());
        tag(ModTags.Blocks.INCORRECT_FOR_VOIDRITE_TOOL)
                .add(ModBlocks.STYX_BLOCK.get());
// 幽冥合金工具
        tag(ModTags.Blocks.NEEDS_HELLALLOY_TOOL)
                .add(ModBlocks.STYX_BLOCK.get());
        tag(ModTags.Blocks.INCORRECT_FOR_HELLALLOY_TOOL);

// 冥河工具需求
        tag(ModTags.Blocks.NEEDS_STYX_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_STYX_TOOL);
// 原版挖掘等级标签补充
// 石工具需求
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.GLOWING_UNDERWORLD_BRICKS.get())
                .add(ModBlocks.GLOWING_UNDERWORLD_BRICK_SLAB.get())
                .add(ModBlocks.GLOWING_UNDERWORLD_BRICK_STAIRS.get())
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.UNDERWORLDRACK.get())
                .add(ModBlocks.UNDERWORLD_BRICKS.get())
                .add(ModBlocks.UNDERWORLD_BRICK_BUTTON.get())
                .add(ModBlocks.UNDERWORLD_BRICK_FENCE.get())
                .add(ModBlocks.UNDERWORLD_BRICK_FENCE_GATE.get())
                .add(ModBlocks.UNDERWORLD_BRICK_SLAB.get())
                .add(ModBlocks.UNDERWORLD_BRICK_STAIRS.get())
                .add(ModBlocks.UNDERWORLD_BRICK_WALL.get());
// 铁工具需求
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.UNDERWORLD_CRYSTAL_ORE.get())
                .add(ModBlocks.STEEL_BLOCK.get());
// 钻石工具需求
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.COMPACT_OBSIDIAN.get())
                .add(ModBlocks.RAINBOWGEM_BLOCK.get())
                .add(ModBlocks.REINFORCED_OBSIDIAN.get())
                .add(ModBlocks.UNDERWORLD_CRYSTAL_ORE.get())
                .add(ModBlocks.COMPACT_OBSIDIAN.get())
                .add(ModBlocks.REINFORCED_OBSIDIAN.get())
                .add(ModBlocks.UNDERWORLD_SPIRIT_STONE.get())
                .add(ModBlocks.VOID_NEBULA.get())
                .add(ModBlocks.VOIDRITE_BLOCK.get());

        //可挖掘标签
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.BLOODY_SAND.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLOODBLADE_ORE.get())
                .add(ModBlocks.CRACKED_BLOODBLADE_ROCK.get())
                .add(ModBlocks.BLOODBLADE_ROCK.get())
                .add(ModBlocks.COMPACT_OBSIDIAN.get())
                .add(ModBlocks.FLUOROSCOPY_BLOCK.get())
                .add(ModBlocks.GLOWING_UNDERWORLD_BRICKS.get())
                .add(ModBlocks.GLOWING_UNDERWORLD_BRICK_SLAB.get())
                .add(ModBlocks.GLOWING_UNDERWORLD_BRICK_STAIRS.get())
                .add(ModBlocks.HELLALLOY_BLOCK.get())
                .add(ModBlocks.HELLIGHT.get())
                .add(ModBlocks.HELL_NUCLEUS.get())
                .add(ModBlocks.REINFORCED_OBSIDIAN.get())
                .add(ModBlocks.STYX_BLOCK.get())
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.RAINBOWGEM_BLOCK.get())
                .add(ModBlocks.UNDERWORLDRACK.get())
                .add(ModBlocks.UNDERWORLD_BRICKS.get())
                .add(ModBlocks.UNDERWORLD_BRICK_BUTTON.get())
                .add(ModBlocks.UNDERWORLD_BRICK_FENCE.get())
                .add(ModBlocks.UNDERWORLD_BRICK_FENCE_GATE.get())
                .add(ModBlocks.UNDERWORLD_BRICK_SLAB.get())
                .add(ModBlocks.UNDERWORLD_BRICK_STAIRS.get())
                .add(ModBlocks.UNDERWORLD_BRICK_WALL.get())
                .add(ModBlocks.UNDERWORLD_SPIRIT_STONE.get())
                .add(ModBlocks.UNDERWORLD_CRYSTAL_ORE.get())
                .add(ModBlocks.VOID_NEBULA.get())
                .add(ModBlocks.VOIDRITE_BLOCK.get());

        //免疫凋灵。
        tag(BlockTags.WITHER_IMMUNE)
                .add(ModBlocks.GLOWING_UNDERWORLD_BRICKS.get())
                .add(ModBlocks.GLOWING_UNDERWORLD_BRICK_SLAB.get())
                .add(ModBlocks.GLOWING_UNDERWORLD_BRICK_STAIRS.get())
                .add(ModBlocks.REINFORCED_OBSIDIAN.get())
                .add(ModBlocks.NULL_BLOCK.get())
                .add(ModBlocks.NULL_GRASSBLOCK.get())
                .add(ModBlocks.HELLALLOY_BLOCK.get())
                .add(ModBlocks.HELLIGHT.get())
                .add(ModBlocks.HELL_NUCLEUS.get())
                .add(ModBlocks.STYX_BLOCK.get())
                .add(ModBlocks.UNDERWORLD_CRYSTAL_ORE.get())
                .add(ModBlocks.HELL_LAMP.get())
                .add(ModBlocks.STYX_LAMP.get())
                .add(ModBlocks.UW_CARVED_WINDOW.get());

        //木材
        tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.HELLWOOD_LOG.get())
                .add(ModBlocks.HELLWOOD_WOOD.get())
                .add(ModBlocks.STRIPPED_HELLWOOD_LOG.get())
                .add(ModBlocks.STRIPPED_HELLWOOD_WOOD.get());
    }
}


