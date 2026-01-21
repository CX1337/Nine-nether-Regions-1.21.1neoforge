package com.cx1337.nine_nether_regions.block;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.block.custom.*;
import com.cx1337.nine_nether_regions.item.ModItems;
import com.cx1337.nine_nether_regions.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(NineNetherRegions.MODID);

    public static final DeferredBlock<Block> BLOODY_SAND =
            registerBlocks("bloody_sand", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(2.5F,10F)
                    .sound(SoundType.SAND)));

    public static final DeferredBlock<Block> BLOODBLADE_ROCK =
            registerBlocks("bloodblade_rock", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(32.0F,444F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> CRACKED_BLOODBLADE_ROCK =
            registerBlocks("cracked_bloodblade_rock", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(32.0F,444F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> HARDENED_BLOODBLADE_ROCK =
            registerBlocks("hardened_bloodblade_rock", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(32.0F,444F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> BLOODBLADE_ORE =
            registerBlocks("bloodblade_ore", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(44.4F,4444F)
                    .requiresCorrectToolForDrops()
                    .lightLevel(p_50872_ -> 6)
                    .sound(SoundType.DEEPSLATE)), new Item.Properties().rarity(Rarity.UNCOMMON));

    public static final DeferredBlock<Block> VOID_NEBULA =
            registerBlocks("void_nebula", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(45.0F,1337F)
                    .requiresCorrectToolForDrops()
                    .lightLevel(p_50872_ -> 6)
                    .sound(SoundType.WOOL)), new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final DeferredBlock<Block> VOIDRITE_BLOCK =
            registerBlocks("voidrite_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(55.0F,4024F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)), new Item.Properties().rarity(Rarity.RARE));

    public static final DeferredBlock<Block> HELLWOOD_LOG =
            registerBlocks("hellwood_log", () -> new ModFlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STEM)));
    public static final DeferredBlock<Block> HELLWOOD_WOOD =
            registerBlocks("hellwood_wood", () -> new ModFlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_HYPHAE)));
    public static final DeferredBlock<Block> STRIPPED_HELLWOOD_LOG =
            registerBlocks("stripped_hellwood_log", () -> new ModFlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_STEM)));
    public static final DeferredBlock<Block> STRIPPED_HELLWOOD_WOOD =
            registerBlocks("stripped_hellwood_wood", () -> new ModFlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_HYPHAE)));

    public static final DeferredBlock<Block> HELLWOOD_PLANKS =
            registerBlocks("hellwood_planks", () -> new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)){
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level,
                                           @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level,
                                           @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 2;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level,
                                              @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 4;
                }
            });
    public static final DeferredBlock<Block> HELLWOOD_LEAVES =
            registerBlocks("hellwood_leaves", () -> new LeavesBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LEAVES)){
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level,
                                           @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level,
                                           @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 6;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level,
                                              @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 3;
                }
            });
    public static final DeferredBlock<Block> HELLWOOD_SAPLING =
            registerBlocks("hellwood_sapling", () -> new SaplingBlock(ModTreeGrowers.HELLWOOD,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FUNGUS)));

    public static final DeferredBlock<StairBlock> HELLWOOD_STAIRS =
            registerBlocks("hellwood_stairs", () -> new StairBlock(ModBlocks.HELLWOOD_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS)));
    public static final DeferredBlock<SlabBlock> HELLWOOD_SLAB =
            registerBlocks("hellwood_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB)));

    public static final DeferredBlock<PressurePlateBlock> HELLWOOD_PRESSURE_PLATE =
            registerBlocks("hellwood_pressure_plate", () -> new PressurePlateBlock(BlockSetType.WARPED,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PRESSURE_PLATE)));
    public static final DeferredBlock<ButtonBlock> HELLWOOD_BUTTON =
            registerBlocks("hellwood_button", () -> new ButtonBlock(BlockSetType.WARPED, 30,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_BUTTON).noCollission()));

    public static final DeferredBlock<FenceBlock> HELLWOOD_FENCE =
            registerBlocks("hellwood_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE)));
    public static final DeferredBlock<FenceGateBlock> HELLWOOD_FENCE_GATE =
            registerBlocks("hellwood_fence_gate", () -> new FenceGateBlock(WoodType.WARPED,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE_GATE)));

    public static final DeferredBlock<DoorBlock> HELLWOOD_DOOR =
            registerBlocks("hellwood_door", () -> new DoorBlock(BlockSetType.WARPED,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_DOOR).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> HELLWOOD_TRAPDOOR =
            registerBlocks("hellwood_trapdoor", () -> new TrapDoorBlock(BlockSetType.WARPED,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_TRAPDOOR).noOcclusion()));

    public static final DeferredBlock<Block> COMPACT_OBSIDIAN =
            registerBlocks("compact_obsidian", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .instrument(NoteBlockInstrument.HARP)
                    .strength(52F,2400F)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> REINFORCED_OBSIDIAN =
            registerBlocks("reinforced_obsidian", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .instrument(NoteBlockInstrument.HARP)
                    .strength(117F,24000F)
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()
                    .lightLevel(p_50872_ -> 13)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.reinforced_obsidian"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }, new Item.Properties().rarity(Rarity.RARE));

    public static final DeferredBlock<Block> UNDERWORLD_SPIRIT_STONE =
            registerBlocks("underworld_spirit_stone", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .instrument(NoteBlockInstrument.HARP)
                    .strength(3.5F,245.2F)
                    .sound(SoundType.DEEPSLATE)
                    .lightLevel(p_50872_ -> 8)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> UNDERWORLD_CRYSTAL_ORE =
            registerBlocks("underworld_crystal_ore", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.5F,24.0F)
                    .sound(SoundType.AMETHYST)
                    .requiresCorrectToolForDrops()
                    .lightLevel(p_50872_ -> 12)));

    public static final DeferredBlock<Block> MANJUSAKA =
            registerBlocks("manjusaka", () -> new TallFlowerBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> PINESAP =
            registerBlocks("pinesap", () -> new FlowerBlock(MobEffects.LUCK, 14.0F,
                    BlockBehaviour.Properties.of()
                            .lightLevel(p_50872_ -> 8)
                            .mapColor(MapColor.COLOR_LIGHT_GREEN)
                            .noCollission()
                            .sound(SoundType.GRASS)
                            .offsetType(BlockBehaviour.OffsetType.XZ)
                            .pushReaction(PushReaction.DESTROY)));

    /*
    警告：下方两个盆栽由于新函数无法正确调用的问题依然使用弃用函数，如果升级或降级版本请注意函数调用。
     */
    @SuppressWarnings("deprecation")
    public static final DeferredBlock<Block> POTTED_PINESAP =
            registerBlockOnly("potted_pinesap", () -> new FlowerPotBlock(
                    PINESAP.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)
                            .lightLevel(p_50872_ -> 8)
                            .noOcclusion()));
    @SuppressWarnings("deprecation")
    public static final DeferredBlock<Block> POTTED_HELLWOOD_SAPLING =
            registerBlockOnly("potted_hellwood_sapling", () -> new FlowerPotBlock(
                    HELLWOOD_SAPLING.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)
                            .noOcclusion()));

    public static final DeferredBlock<Block> GLOWING_UNDERWORLD_BRICKS =
            registerBlocks("glowing_underworld_bricks", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .requiresCorrectToolForDrops()
                    .strength(3.5F,444.0F)
                    .sound(SoundType.NETHER_BRICKS)
                    .lightLevel(p_50872_ -> 6)));
    public static final DeferredBlock<Block> HELLALLOY_BLOCK =
            registerBlocks("hellalloy_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(66.0F,6066.0F)
                    .sound(SoundType.NETHERITE_BLOCK)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_block"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }, new Item.Properties().rarity(Rarity.EPIC));

    public static final DeferredBlock<Block> STEEL_BLOCK =
            registerBlocks("steel_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(8.0F,12.0F)
                    .sound(SoundType.METAL)));
    public static final DeferredBlock<Block> RUBY_BLOCK =
            registerBlocks("ruby_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BIT)
                    .requiresCorrectToolForDrops()
                    .strength(6.0F,10.0F)
                    .lightLevel(p_50872_ -> 8)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RAINBOWGEM_BLOCK =
            registerBlocks("rainbowgem_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(22.0F,85.0F)
                    .lightLevel(p_50872_ -> 4)
                    .sound(SoundType.STONE)), new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final DeferredBlock<Block> HELLIGHT =
            registerBlocks("hellight", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_BLUE)
                    .instrument(NoteBlockInstrument.BANJO)
                    .strength(1.5F,6.0F)
                    .sound(SoundType.SCULK_CATALYST)
                    .lightLevel(p_50872_ -> 15)));
    //炼狱晶核
    public static final DeferredBlock<Block> HELL_NUCLEUS =
            registerBlocks("hell_nucleus", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.NETHER)
                    .instrument(NoteBlockInstrument.BANJO)
                    .strength(3.0F,200.0F)
                    .sound(SoundType.AMETHYST)
                    .lightLevel(p_50872_ -> 12)
            ){
                @Override
                public void stepOn(@NotNull Level level, @NotNull BlockPos pos,
                                   @NotNull BlockState state, @NotNull Entity entity) {
                    if (!entity.fireImmune()){
                        entity.setRemainingFireTicks(300);
                    }
                    super.stepOn(level, pos, state, entity);
                }
                @Override
                protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level,
                                                       @NotNull BlockPos pos, @NotNull CollisionContext context) {
                    return Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
                }

                @Override
                protected @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level,
                                                                @NotNull BlockPos pos, @NotNull CollisionContext context) {
                    return Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
                }

                @Override
                public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hell_nucleus"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }, new Item.Properties().rarity(Rarity.RARE));

    public static final DeferredBlock<Block> STYX_BLOCK =
            registerBlocks("styx_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(99.0F,44444.0F)
                    .sound(SoundType.NETHERITE_BLOCK)
                    .lightLevel(p_50872_ -> 4)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_block"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }, new Item.Properties().rarity(Rarity.EPIC));

    public static final DeferredBlock<Block> HELL_LAMP =
            registerBlocks("hell_lamp", () -> new HellLampBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .instrument(NoteBlockInstrument.BANJO)
                    .strength(2.5F, 44.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()
                    .lightLevel(state -> state.getValue(HellLampBlock.CLICKED) ? 15 : 0)){
                @Override
                protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level,
                                                       @NotNull BlockPos pos, @NotNull CollisionContext context) {
                    return Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
                }
                @Override
                protected @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level,
                                                                @NotNull BlockPos pos, @NotNull CollisionContext context) {
                    return Block.box(3.0D, 0.0D, 3.0D, 13.0D, 14.0D, 13.0D);
                }
                @Override
                protected boolean useShapeForLightOcclusion(@NotNull BlockState state) {
                    return true;
                }
            });

    public static final DeferredBlock<Block> STYX_LAMP =
            registerBlocks("styx_lamp", () -> new StyxLampBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BANJO)
                    .strength(5.0F, 444.0F)
                    .sound(SoundType.GLASS)
                    .noOcclusion()
                    .lightLevel(state -> state.getValue(StyxLampBlock.CLICKED) ? 15 : 2)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_lamp"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
                @Override
                protected boolean useShapeForLightOcclusion(@NotNull BlockState state) {
                    return true;
                }
            });

    public static final DeferredBlock<Block> CARVED_WINDOW =
            registerBlocks("carved_window", () -> new WindowBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_BLUE)
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(0.5F, 1.4F)
                    .sound(SoundType.GLASS)
                    .noOcclusion()
                    .isValidSpawn((state, level, pos, entity) -> false)
                    .isRedstoneConductor((state, level, pos) -> false)
                    .isSuffocating((state, level, pos) -> false)
                    .isViewBlocking((state, level, pos) -> false)));
    public static final DeferredBlock<Block> UW_CARVED_WINDOW =
            registerBlocks("uw_carved_window", () -> new WindowBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(0.8F, 44.4F)
                    .sound(SoundType.GLASS)
                    .noOcclusion()
                    .isValidSpawn((state, level, pos, entity) -> false)
                    .isRedstoneConductor((state, level, pos) -> false)
                    .isSuffocating((state, level, pos) -> false)
                    .isViewBlocking((state, level, pos) -> false)));

    public static final DeferredBlock<Block> UNDERWORLDRACK =
            registerBlocks("underworldrack", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F,16.0F)
                    .sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> UNDERWORLD_BRICKS =
            registerBlocks("underworld_bricks", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F,444.0F)
                    .sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<Block> NULL_BLOCK =
            registerBlocks("null_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .instrument(NoteBlockInstrument.HARP)
                    .requiresCorrectToolForDrops()
                    .strength(444.0F,44444.0F)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NULL_GRASSBLOCK =
            registerBlocks("null_grassblock", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT)
                    .instrument(NoteBlockInstrument.HARP)
                    .requiresCorrectToolForDrops()
                    .strength(444.0F,44444.0F)
                    .sound(SoundType.GRAVEL)));

    public static final DeferredBlock<ButtonBlock> UNDERWORLD_BRICK_BUTTON =
            registerBlocks("underworld_brick_button", () -> new ButtonBlock(BlockSetType.STONE,30,
                    BlockBehaviour.Properties.of()
                            .strength(3.0F,444.0F)
                            .requiresCorrectToolForDrops()
                            .noCollission()
                            .sound(SoundType.NETHER_BRICKS)));

    public static final DeferredBlock<SlabBlock> GLOWING_UNDERWORLD_BRICK_SLAB =
            registerBlocks("glowing_underworld_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(3.5F, 444.0F)
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .requiresCorrectToolForDrops()
                    .lightLevel(p_50872_ -> 6)
                    .sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<StairBlock> GLOWING_UNDERWORLD_BRICK_STAIRS =
            registerBlocks("glowing_underworld_brick_stairs", () -> new StairBlock(ModBlocks.GLOWING_UNDERWORLD_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                    .strength(3.5F, 444.0F)
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .requiresCorrectToolForDrops()
                    .lightLevel(p_50872_ -> 6)
                            .sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<SlabBlock> UNDERWORLD_BRICK_SLAB =
            registerBlocks("underworld_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(3.0F, 444.0F)
                    .mapColor(MapColor.COLOR_GREEN)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<StairBlock> UNDERWORLD_BRICK_STAIRS =
            registerBlocks("underworld_brick_stairs", () -> new StairBlock(ModBlocks.UNDERWORLD_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(3.0F, 444.0F)
                            .mapColor(MapColor.COLOR_GREEN)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.NETHER_BRICKS)));

    public static final DeferredBlock<FenceBlock> UNDERWORLD_BRICK_FENCE =
            registerBlocks("underworld_brick_fence", () -> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F, 444.0F)
                    .mapColor(MapColor.COLOR_GREEN)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<FenceGateBlock> UNDERWORLD_BRICK_FENCE_GATE =
            registerBlocks("underworld_brick_fence_gate", () -> new FenceGateBlock(WoodType.WARPED, BlockBehaviour.Properties.of()
                    .strength(4.0F, 444.0F)
                    .mapColor(MapColor.COLOR_GREEN)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<WallBlock> UNDERWORLD_BRICK_WALL =
            registerBlocks("underworld_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F, 444.0F)
                    .mapColor(MapColor.COLOR_GREEN)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_BRICKS)));

    public static final DeferredBlock<Block> FLUOROSCOPY_BLOCK =
            registerBlocks("fluoroscopy_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5F, 22F)
                    .sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.fluoroscopy_block"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    private static <T extends Block> DeferredBlock<T> registerBlockOnly(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block, Item.Properties properties) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }
    private static <T extends Block> DeferredBlock<T> registerBlocks(String name, Supplier<T> block, Item.Properties properties) {
        DeferredBlock<T> blocks = BLOCKS.register(name, block);
        registerBlockItems(name, blocks, properties);
        return blocks;
    }
    private static <T extends Block> DeferredBlock<T> registerBlocks(String name, Supplier<T> block) {
        return registerBlocks(name, block, new Item.Properties());
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
