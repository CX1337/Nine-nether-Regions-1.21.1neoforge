package com.cx1337.nine_nether_regions.datagen;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.block.ModBlocks;
import com.cx1337.nine_nether_regions.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {
    public ModBlockLootTablesProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.BLOODY_SAND.get());
        dropSelf(ModBlocks.BLOODBLADE_ROCK.get());
        dropSelf(ModBlocks.CRACKED_BLOODBLADE_ROCK.get());
        dropSelf(ModBlocks.HARDENED_BLOODBLADE_ROCK.get());
        dropSelf(ModBlocks.BLOODBLADE_ORE.get());
        dropSelf(ModBlocks.COMPACT_OBSIDIAN.get());
        dropSelf(ModBlocks.REINFORCED_OBSIDIAN.get());
        dropSelf(ModBlocks.GLOWING_UNDERWORLD_BRICKS.get());
        add(ModBlocks.GLOWING_UNDERWORLD_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GLOWING_UNDERWORLD_BRICK_SLAB.get()));
        dropSelf(ModBlocks.FLUOROSCOPY_BLOCK.get());
        dropSelf(ModBlocks.GLOWING_UNDERWORLD_BRICK_STAIRS.get());
        dropSelf(ModBlocks.HELLALLOY_BLOCK.get());
        dropSelf(ModBlocks.HELLIGHT.get());
        dropSelf(ModBlocks.HELL_NUCLEUS.get());
        dropSelf(ModBlocks.HELL_LAMP.get());
        dropSelf(ModBlocks.STYX_LAMP.get());
        dropSelf(ModBlocks.CARVED_WINDOW.get());
        dropSelf(ModBlocks.UW_CARVED_WINDOW.get());
        dropSelf(ModBlocks.VOID_NEBULA.get());
        dropSelf(ModBlocks.VOIDRITE_BLOCK.get());

        dropSelf(ModBlocks.HELLWOOD_LOG.get());
        dropSelf(ModBlocks.HELLWOOD_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_HELLWOOD_LOG.get());
        dropSelf(ModBlocks.STRIPPED_HELLWOOD_WOOD.get());
        dropSelf(ModBlocks.HELLWOOD_PLANKS.get());
        dropSelf(ModBlocks.HELLWOOD_SAPLING.get());
        add(ModBlocks.HELLWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.HELLWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(ModBlocks.HELLWOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HELLWOOD_SLAB.get()));
        add(ModBlocks.HELLWOOD_DOOR.get(),
                             block -> createDoorTable(ModBlocks.HELLWOOD_DOOR.get()));
        dropSelf(ModBlocks.HELLWOOD_STAIRS.get());
        dropSelf(ModBlocks.HELLWOOD_BUTTON.get());
        dropSelf(ModBlocks.HELLWOOD_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.HELLWOOD_FENCE.get());
        dropSelf(ModBlocks.HELLWOOD_FENCE_GATE.get());
        dropSelf(ModBlocks.HELLWOOD_TRAPDOOR.get());

        dropSelf(ModBlocks.NULL_BLOCK.get());
        dropSelf(ModBlocks.NULL_GRASSBLOCK.get());
        dropSelf(ModBlocks.STYX_BLOCK.get());
        dropSelf(ModBlocks.STEEL_BLOCK.get());
        dropSelf(ModBlocks.RUBY_BLOCK.get());
        dropSelf(ModBlocks.RAINBOWGEM_BLOCK.get());
        dropSelf(ModBlocks.UNDERWORLDRACK.get());
        dropSelf(ModBlocks.UNDERWORLD_SPIRIT_STONE.get());
        dropSelf(ModBlocks.UNDERWORLD_BRICKS.get());
        dropSelf(ModBlocks.UNDERWORLD_BRICK_BUTTON.get());
        dropSelf(ModBlocks.UNDERWORLD_BRICK_FENCE.get());
        dropSelf(ModBlocks.UNDERWORLD_BRICK_FENCE_GATE.get());
        add(ModBlocks.UNDERWORLD_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.UNDERWORLD_BRICK_SLAB.get()));
        dropSelf(ModBlocks.UNDERWORLD_BRICK_STAIRS.get());
        dropSelf(ModBlocks.UNDERWORLD_BRICK_WALL.get());

        //非精准采集不掉落自身的矿石按下述方式写。
        add(ModBlocks.UNDERWORLD_CRYSTAL_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.UNDERWORLD_CRYSTAL_ORE.get(), ModItems.UNDERWORLD_CRYSTAL.get(), 1, 4));


        add(ModBlocks.MANJUSAKA.get(), block -> createTallFlowerDrops(block));
        dropSelf(ModBlocks.PINESAP.get());
        add(ModBlocks.POTTED_PINESAP.get(), createPotFlowerItemTable(ModBlocks.PINESAP));
        add(ModBlocks.POTTED_HELLWOOD_SAPLING.get(), createPotFlowerItemTable(ModBlocks.HELLWOOD_SAPLING));
    }

    protected LootTable.Builder createTallFlowerDrops(Block block) {
        return LootTable.lootTable()
                .withPool(applyExplosionCondition(block, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block)
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(TallFlowerBlock.HALF, DoubleBlockHalf.LOWER))))));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
