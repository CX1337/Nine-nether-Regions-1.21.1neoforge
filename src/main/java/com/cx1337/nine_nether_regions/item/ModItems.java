package com.cx1337.nine_nether_regions.item;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.item.custom.*;
import com.cx1337.nine_nether_regions.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(NineNetherRegions.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    //紫水晶短剑
    public static final DeferredItem<SwordItem> AMETHYST_DAGGER =
           ITEMS.register("amethyst_dagger", AmethystDagger::new);

    //材料和杂项。可用作燃料的方块/物品注册后需在ModDataMapProvider补全信息。
    public static final DeferredItem<Item> EMPTY_FABRIC =
            ITEMS.register("empty_fabric", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> MAGIC_FABRIC =
            ITEMS.register("magic_fabric", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> STYX_FABRIC =
            ITEMS.register("styx_fabric", () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_fabric"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> STYX_TEAR =
            ITEMS.register("styx_tear", StyxTear::new);
    public static final DeferredItem<Item> CHERRY_STICK =
            ITEMS.register("cherry_stick", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> STEEL_BASE =
            ITEMS.register("steel_base", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.steel_base"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> STEEL_INGOT =
            ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.steel_ingot"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> STEEL_NUGGET =
            ITEMS.register("steel_nugget", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> COPPER_NUGGET =
            ITEMS.register("copper_nugget", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> RUBY =
            ITEMS.register("ruby", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> RAINBOWGEM =
            ITEMS.register("rainbowgem", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.rainbowgem"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> HELLALLOY_INGOT =
            ITEMS.register("hellalloy_ingot", () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_ingot"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> STYX_INGOT =
            ITEMS.register("styx_ingot", () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_ingot"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> BLOODBLADE_ESSENCE =
            ITEMS.register("bloodblade_essence", () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.bloodblade_essence"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> VOID_SHARD =
            ITEMS.register("void_shard", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final DeferredItem<Item> VOIDRITE_INGOT =
            ITEMS.register("voidrite_ingot", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.voidrite_ingot"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> VOIDRITE_UPGRADE_SMITHING_TEMPLATE =
            ITEMS.register("voidrite_upgrade_smithing_template", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)
                    .fireResistant()){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.voidrite_upgrade_smithing_template"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> DIAMOND_BOWSTRING =
            ITEMS.register("diamond_bowstring", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> UNDERWORLD_BRICK =
            ITEMS.register("underworld_brick", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> UNDERWORLD_CRYSTAL =
            ITEMS.register("underworld_crystal", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> NETHERITE_ROD =
            ITEMS.register("netherite_rod", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final DeferredItem<Item> VOIDRITE_ROD =
            ITEMS.register("voidrite_rod", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final DeferredItem<Item> HELLALLOY_ROD =
            ITEMS.register("hellalloy_rod", () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> GHOSTLIUM =
            ITEMS.register("ghostlium", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> WEB_BALL =
            ITEMS.register("web_ball", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    //红宝石剑
    public static final DeferredItem<SwordItem> RUBY_SWORD =
            ITEMS.register("ruby_sword", () -> new SwordItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RUBY,
                            4.0F, -2.4F)).rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.ruby_sword"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    //食物。食物注册前需在ModFoodProperties中补全信息。
    public static final DeferredItem<Item> AMETHYST_BEETROOT =
            ITEMS.register("amethyst_beetroot", () -> new Item(new Item.Properties().food(ModFoodProperties.AMETHYST_BEETROOT)
                    .rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> GHOSTLIUM_APPLE =
            ITEMS.register("ghostlium_apple", () -> new Item(new Item.Properties().food(ModFoodProperties.GHOSTLIUM_APPLE)
                    .rarity(Rarity.UNCOMMON)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.ghostlium_apple"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> ENCHANTED_GHOSTLIUM_APPLE =
            ITEMS.register("enchanted_ghostlium_apple", EnchantedGhostliumApple::new);
    public static final DeferredItem<Item> WEB_FRUIT =
            ITEMS.register("web_fruit", () -> new Item(new Item.Properties().food(ModFoodProperties.WEB_FRUIT)
                    .rarity(Rarity.COMMON)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.web_fruit"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    //弓。
    public static final DeferredItem<Item> HELLALLOY_LONGBOW =
            ITEMS.register("hellalloy_longbow", HellalloyLongbow::new);

    //盔甲。
    //木盔甲。
    public static final DeferredItem<ArmorItem> WOOD_HELMET =
            ITEMS.register("wood_helmet", () ->new ArmorItem(ModArmorMaterials.WOOD_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties() .durability(ArmorItem.Type.HELMET.getDurability(3)).rarity(Rarity.COMMON)));
    public static final DeferredItem<ArmorItem> WOOD_CHESTPLATE =
            ITEMS.register("wood_chestplate", () ->new ArmorItem(ModArmorMaterials.WOOD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties() .durability(ArmorItem.Type.CHESTPLATE.getDurability(3)).rarity(Rarity.COMMON)));
    public static final DeferredItem<ArmorItem> WOOD_LEGGINGS =
            ITEMS.register("wood_leggings", () ->new ArmorItem(ModArmorMaterials.WOOD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties() .durability(ArmorItem.Type.LEGGINGS.getDurability(3)).rarity(Rarity.COMMON)));
    public static final DeferredItem<ArmorItem> WOOD_BOOTS =
            ITEMS.register("wood_boots", () ->new ArmorItem(ModArmorMaterials.WOOD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties() .durability(ArmorItem.Type.BOOTS.getDurability(3)).rarity(Rarity.COMMON)));
    //樱花盔甲。
    public static final DeferredItem<ArmorItem> CHERRY_HELMET =
            ITEMS.register("cherry_helmet", CherryHelmet::new);
    public static final DeferredItem<ArmorItem> CHERRY_CHESTPLATE =
            ITEMS.register("cherry_chestplate", CherryChestplate::new);
    public static final DeferredItem<ArmorItem> CHERRY_LEGGINGS =
            ITEMS.register("cherry_leggings", CherryLeggings::new);
    public static final DeferredItem<ArmorItem> CHERRY_BOOTS =
            ITEMS.register("cherry_boots", CherryBoots::new);
    //铜盔甲。
    public static final DeferredItem<ArmorItem> COPPER_HELMET =
            ITEMS.register("copper_helmet", () ->new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties() .durability(ArmorItem.Type.HELMET.getDurability(11)).rarity(Rarity.COMMON)));
    public static final DeferredItem<ArmorItem> COPPER_CHESTPLATE =
            ITEMS.register("copper_chestplate", () ->new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties() .durability(ArmorItem.Type.CHESTPLATE.getDurability(11)).rarity(Rarity.COMMON)));
    public static final DeferredItem<ArmorItem> COPPER_LEGGINGS =
            ITEMS.register("copper_leggings", () ->new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties() .durability(ArmorItem.Type.LEGGINGS.getDurability(11)).rarity(Rarity.COMMON)));
    public static final DeferredItem<ArmorItem> COPPER_BOOTS =
            ITEMS.register("copper_boots", () ->new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties() .durability(ArmorItem.Type.BOOTS.getDurability(11)).rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> COPPER_HORSE_ARMOR =
            ITEMS.register("copper_horse_armor", () -> new AnimalArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));
    //精钢盔甲。
    public static final DeferredItem<ArmorItem> STEEL_HELMET =
            ITEMS.register("steel_helmet", () ->new ArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties() .durability(ArmorItem.Type.HELMET.getDurability(33)).rarity(Rarity.COMMON)));
    public static final DeferredItem<ArmorItem> STEEL_CHESTPLATE =
            ITEMS.register("steel_chestplate", () ->new ArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties() .durability(ArmorItem.Type.CHESTPLATE.getDurability(30)).rarity(Rarity.COMMON)));
    public static final DeferredItem<ArmorItem> STEEL_LEGGINGS =
            ITEMS.register("steel_leggings", () ->new ArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties() .durability(ArmorItem.Type.LEGGINGS.getDurability(31)).rarity(Rarity.COMMON)));
    public static final DeferredItem<ArmorItem> STEEL_BOOTS =
            ITEMS.register("steel_boots", () ->new ArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties() .durability(ArmorItem.Type.BOOTS.getDurability(32)).rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> STEEL_HORSE_ARMOR =
            ITEMS.register("steel_horse_armor", () -> new AnimalArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
            false, new Item.Properties().stacksTo(1)));

    //虹玉盔甲。
    public static final DeferredItem<ArmorItem> RAINBOWGEM_HELMET =
            ITEMS.register("rainbowgem_helmet", () ->new ArmorItem(ModArmorMaterials.RAINBOWGEM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties() .durability(ArmorItem.Type.HELMET.getDurability(38)).rarity(Rarity.UNCOMMON)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.rainbowgem_armors"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> RAINBOWGEM_CHESTPLATE =
            ITEMS.register("rainbowgem_chestplate", () ->new ArmorItem(ModArmorMaterials.RAINBOWGEM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties() .durability(ArmorItem.Type.CHESTPLATE.getDurability(38)).rarity(Rarity.UNCOMMON)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.rainbowgem_armors"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> RAINBOWGEM_LEGGINGS =
            ITEMS.register("rainbowgem_leggings", () ->new ArmorItem(ModArmorMaterials.RAINBOWGEM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties() .durability(ArmorItem.Type.LEGGINGS.getDurability(38)).rarity(Rarity.UNCOMMON)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.rainbowgem_armors"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> RAINBOWGEM_BOOTS =
            ITEMS.register("rainbowgem_boots", () ->new ArmorItem(ModArmorMaterials.RAINBOWGEM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties() .durability(ArmorItem.Type.BOOTS.getDurability(38)).rarity(Rarity.UNCOMMON)){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.rainbowgem_armors"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    //虚空合金盔甲。
    public static final DeferredItem<ArmorItem> VOIDRITE_HELMET =
            ITEMS.register("voidrite_helmet", () ->new ArmorItem(ModArmorMaterials.VOIDRITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties() .durability(ArmorItem.Type.HELMET.getDurability(40)).rarity(Rarity.UNCOMMON).fireResistant()){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.voidrite_armors"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> VOIDRITE_CHESTPLATE =
            ITEMS.register("voidrite_chestplate", () ->new ArmorItem(ModArmorMaterials.VOIDRITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties() .durability(ArmorItem.Type.CHESTPLATE.getDurability(40)).rarity(Rarity.UNCOMMON).fireResistant()){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.voidrite_armors"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> VOIDRITE_LEGGINGS =
            ITEMS.register("voidrite_leggings", () ->new ArmorItem(ModArmorMaterials.VOIDRITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties() .durability(ArmorItem.Type.LEGGINGS.getDurability(40)).rarity(Rarity.UNCOMMON).fireResistant()){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.voidrite_armors"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> VOIDRITE_BOOTS =
            ITEMS.register("voidrite_boots", () ->new ArmorItem(ModArmorMaterials.VOIDRITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties() .durability(ArmorItem.Type.BOOTS.getDurability(40)).rarity(Rarity.UNCOMMON).fireResistant()){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.voidrite_armors"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    //幽冥合金盔甲。
    public static final DeferredItem<ArmorItem> HELLALLOY_HELMET =
            ITEMS.register("hellalloy_helmet", HellalloyHelmet::new);
    public static final DeferredItem<ArmorItem> HELLALLOY_CHESTPLATE =
            ITEMS.register("hellalloy_chestplate", HellalloyChestplate::new);
    public static final DeferredItem<ArmorItem> HELLALLOY_LEGGINGS =
            ITEMS.register("hellalloy_leggings", HellalloyLeggings::new);
    public static final DeferredItem<ArmorItem> HELLALLOY_BOOTS =
            ITEMS.register("hellalloy_boots", HellalloyBoots::new);
    //冥河盔甲。
    public static final DeferredItem<ArmorItem> STYX_HELMET =
            ITEMS.register("styx_helmet", StyxHelmet::new);
    public static final DeferredItem<ArmorItem> STYX_CHESTPLATE =
            ITEMS.register("styx_chestplate", StyxChestplate::new);
    public static final DeferredItem<ArmorItem> STYX_LEGGINGS =
            ITEMS.register("styx_leggings", StyxLeggings::new);
    public static final DeferredItem<ArmorItem> STYX_BOOTS =
            ITEMS.register("styx_boots", StyxBoots::new);

    //冥河战刃。
    public static final DeferredItem<SwordItem> STYX_SWORD =
            ITEMS.register("styx_sword", StyxSword::new);
    //伤害测试剑。
    public static final DeferredItem<SwordItem> DAMAGE_TEST =
            ITEMS.register("damage_test", DamageTest::new);

    //工具与一般武器。
    //冥河镐。
    public static final DeferredItem<PickaxeItem> STYX_PICKAXE =
            ITEMS.register("styx_pickaxe", StyxPickaxe::new);
    //铜工具。
    public static final DeferredItem<PickaxeItem> COPPER_PICKAXE =
            ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 0.0F, -2.6F)).rarity(Rarity.COMMON)));
    public static final DeferredItem<ShovelItem> COPPER_SHOVEL =
            ITEMS.register("copper_shovel", () -> new ShovelItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.COPPER, 0.5F, -2.8F)).rarity(Rarity.COMMON)));
    public static final DeferredItem<AxeItem> COPPER_AXE =
            ITEMS.register("copper_axe", () -> new AxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 6.0F, -3.0F)).rarity(Rarity.COMMON)));
    public static final DeferredItem<HoeItem> COPPER_HOE =
            ITEMS.register("copper_hoe", () -> new HoeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.COPPER, -2.0F, -1.0F)).rarity(Rarity.COMMON)));
    public static final DeferredItem<SwordItem> COPPER_SWORD =
            ITEMS.register("copper_sword", () -> new SwordItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.COPPER, 2.0F, -2.4F)).rarity(Rarity.COMMON)));
    //精钢工具。
    public static final DeferredItem<PickaxeItem> STEEL_PICKAXE =
            ITEMS.register("steel_pickaxe", () -> new PickaxeItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STEEL, 1.0F, -2.6F)).rarity(Rarity.COMMON)));
    public static final DeferredItem<ShovelItem> STEEL_SHOVEL =
            ITEMS.register("steel_shovel", () -> new ShovelItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.STEEL, 1.5F, -2.8F)).rarity(Rarity.COMMON)));
    public static final DeferredItem<AxeItem> STEEL_AXE =
            ITEMS.register("steel_axe", () -> new AxeItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.STEEL, 4.0F, -3.0F)).rarity(Rarity.COMMON)));
    public static final DeferredItem<HoeItem> STEEL_HOE =
            ITEMS.register("steel_hoe", () -> new HoeItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.STEEL, 0.5F, -1.0F)).rarity(Rarity.COMMON)));
    public static final DeferredItem<SwordItem> STEEL_SWORD =
            ITEMS.register("steel_sword", () -> new SwordItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.STEEL, 4.0F, -2.4F)).rarity(Rarity.COMMON)));
    //虹玉工具。
    public static final DeferredItem<PickaxeItem> RAINBOWGEM_PICKAXE =
            ITEMS.register("rainbowgem_pickaxe", () -> new PickaxeItem(ModToolTiers.RAINBOWGEM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.RAINBOWGEM, 1.0F, -2.6F)).rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<ShovelItem> RAINBOWGEM_SHOVEL =
            ITEMS.register("rainbowgem_shovel", () -> new ShovelItem(ModToolTiers.RAINBOWGEM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.RAINBOWGEM, 1.5F, -2.8F)).rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<AxeItem> RAINBOWGEM_AXE =
            ITEMS.register("rainbowgem_axe", () -> new AxeItem(ModToolTiers.RAINBOWGEM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.RAINBOWGEM, 4.0F, -3.0F)).rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<HoeItem> RAINBOWGEM_HOE =
            ITEMS.register("rainbowgem_hoe", () -> new HoeItem(ModToolTiers.RAINBOWGEM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.RAINBOWGEM, 0.5F, -1.0F)).rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<SwordItem> RAINBOWGEM_SWORD =
            ITEMS.register("rainbowgem_sword", () -> new SwordItem(ModToolTiers.RAINBOWGEM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RAINBOWGEM, 4.0F, -2.4F)).rarity(Rarity.UNCOMMON)));
    //虚空合金工具。
    public static final DeferredItem<PickaxeItem> VOIDRITE_PICKAXE =
            ITEMS.register("voidrite_pickaxe", () -> new PickaxeItem(ModToolTiers.VOIDRITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.VOIDRITE, 1.0F, -2.6F)).rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<ShovelItem> VOIDRITE_SHOVEL =
            ITEMS.register("voidrite_shovel", () -> new ShovelItem(ModToolTiers.VOIDRITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.VOIDRITE, 1.5F, -2.8F)).rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<AxeItem> VOIDRITE_AXE =
            ITEMS.register("voidrite_axe", () -> new AxeItem(ModToolTiers.VOIDRITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.VOIDRITE, 6.0F, -3.0F)).rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<HoeItem> VOIDRITE_HOE =
            ITEMS.register("voidrite_hoe", () -> new HoeItem(ModToolTiers.VOIDRITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.VOIDRITE, -0.5F, 0.0F)).rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<SwordItem> VOIDRITE_SWORD =
            ITEMS.register("voidrite_sword", () -> new SwordItem(ModToolTiers.VOIDRITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.VOIDRITE, 4.0F, -2.4F)).rarity(Rarity.UNCOMMON)));
    //幽冥合金工具。
    public static final DeferredItem<PickaxeItem> HELLALLOY_PICKAXE =
                        ITEMS.register("hellalloy_pickaxe", () -> new PickaxeItem(ModToolTiers.HELLALLOY, new Item.Properties()
                                .attributes(PickaxeItem.createAttributes(ModToolTiers.HELLALLOY, 1.0F, -2.6F)).rarity(Rarity.RARE).fireResistant()){
                            @Override
                            public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                                        @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_pickaxe"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                            }
                        });
    public static final DeferredItem<ShovelItem> HELLALLOY_SHOVEL =
                        ITEMS.register("hellalloy_shovel", () -> new ShovelItem(ModToolTiers.HELLALLOY, new Item.Properties()
                                .attributes(ShovelItem.createAttributes(ModToolTiers.HELLALLOY, 1.5F, -2.8F)).rarity(Rarity.RARE).fireResistant()){
                            @Override
                            public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                                        @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_shovel"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                            }
                        });
    public static final DeferredItem<AxeItem> HELLALLOY_AXE =
                        ITEMS.register("hellalloy_axe", () -> new AxeItem(ModToolTiers.HELLALLOY, new Item.Properties()
                                .attributes(AxeItem.createAttributes(ModToolTiers.HELLALLOY, 6.0F, -2.8F)).rarity(Rarity.RARE).fireResistant()){
                            @Override
                            public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                                        @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_axe"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                            }
                        });
    public static final DeferredItem<HoeItem> HELLALLOY_HOE =
                        ITEMS.register("hellalloy_hoe", () -> new HoeItem(ModToolTiers.HELLALLOY, new Item.Properties()
                                .attributes(HoeItem.createAttributes(ModToolTiers.HELLALLOY, 0.5F, -1.0F)).rarity(Rarity.RARE).fireResistant()){
                            @Override
                            public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                                        @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_hoe"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                            }
                        });
    //特殊。
    public static final DeferredItem<SwordItem> ALLOY_HILT =
            ITEMS.register("alloy_hilt", () -> new SwordItem(ModToolTiers.HELLALLOY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.HELLALLOY, -6.0F, -1.0F)).rarity(Rarity.EPIC).fireResistant()){
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.alloy_hilt"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    //幽冥合金剑。
    public static final DeferredItem<SwordItem> HELLALLOY_SWORD =
            ITEMS.register("hellalloy_sword", HellalloySword::new);

    //法杖及配件
    public static final DeferredItem<Item> FIRE_CORE =
            ITEMS.register("fire_core", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> FIRE_STAFF =
            ITEMS.register("fire_staff", FireStaff::new);
    public static final DeferredItem<Item> WITHER_CORE =
            ITEMS.register("wither_core", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final DeferredItem<Item> WITHER_STAFF =
            ITEMS.register("wither_staff", WitherStaff::new);
    public static final DeferredItem<Item> VOID_CORE =
            ITEMS.register("void_core", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final DeferredItem<Item> VOID_STAFF =
            ITEMS.register("void_staff", VoidStaff::new);
    public static final DeferredItem<Item> ENDER_STAFF =
            ITEMS.register("ender_staff", EnderStaff::new);

    //唱片。
    public static final DeferredItem<Item> STYX_FERRYMAN_MUSIC_DISC =
            ITEMS.register("styx_ferryman_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.DAWN_OF_THE_APOCALYPSE_KEY)
                    .stacksTo(1).rarity(Rarity.EPIC).fireResistant()));
    public static final DeferredItem<Item> BLOODBLADE_PEAK_MUSIC_DISC =
            ITEMS.register("bloodblade_peak_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.LONELY_MOUNTAIN_KEY)
                    .stacksTo(1).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> UNDERWORLD_ABYSS_MUSIC_DISC =
            ITEMS.register("underworld_abyss_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.MYSTERIOUS_LIGHTS_KEY)
                    .stacksTo(1).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> THE_STYX_MUSIC_DISC =
            ITEMS.register("the_styx_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.THINK_ABOUT_IT_KEY)
                    .stacksTo(1).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> FLUORESCENCE_FOREST_MUSIC_DISC =
            ITEMS.register("fluorescence_forest_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.NIGHT_VIGIL_KEY)
                    .stacksTo(1).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> MANJUSAKA_PLAIN_MUSIC_DISC =
            ITEMS.register("manjusaka_plain_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.GO_ON_WITHOUT_ME_KEY)
                    .stacksTo(1).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> CAVES_MUSIC_DISC =
            ITEMS.register("caves_music_disc", () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.SATIN_DANGER_KEY)
                    .stacksTo(1).rarity(Rarity.RARE).fireResistant()));
}