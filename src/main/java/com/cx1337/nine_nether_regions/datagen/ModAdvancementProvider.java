package com.cx1337.nine_nether_regions.datagen;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.block.ModBlocks;
import com.cx1337.nine_nether_regions.item.ModItems;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries,
                                  ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new ModAdvancementGenerator()));
    }

    private static class ModAdvancementGenerator implements AdvancementGenerator {
        @Override
        public void generate(HolderLookup.@NotNull Provider provider, @NotNull Consumer<AdvancementHolder> saver,
                             @NotNull ExistingFileHelper existingFileHelper) {
            //根成就，九幽之引
            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(
                            ModBlocks.STYX_BLOCK.get(),
                            Component.translatable("advancement.nine_nether_regions.root.title"),
                            Component.translatable("advancement.nine_nether_regions.root.description"),
                            ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,
                                    "textures/gui/advancements/backgrounds/root.png"),
                            AdvancementType.TASK,
                            true, true, false
                    )
                    .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "root"),
                            existingFileHelper);
            //安全了？
            AdvancementHolder safe = Advancement.Builder.advancement()
                    .display(
                            ModItems.WOOD_CHESTPLATE.get(),
                            Component.translatable("advancement.nine_nether_regions.safe.title"),
                            Component.translatable("advancement.nine_nether_regions.safe.description"),
                            null,
                            AdvancementType.TASK,
                            true, true, false
                    )
                    .addCriterion("has_full_wood_set",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.WOOD_HELMET.get(),
                                    ModItems.WOOD_CHESTPLATE.get(),
                                    ModItems.WOOD_LEGGINGS.get(),
                                    ModItems.WOOD_BOOTS.get()
                            ))
                    .parent(root)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"safe"),
                            existingFileHelper);
            //不一样的套装。
            AdvancementHolder differentSet = Advancement.Builder.advancement()
                    .display(
                            ModItems.CHERRY_CHESTPLATE.get(),
                            Component.translatable("advancement.nine_nether_regions.different_set.title"),
                            Component.translatable("advancement.nine_nether_regions.different_set.description"),
                            null,
                            AdvancementType.GOAL,
                            true, true, true
                    )
                    .addCriterion("has_full_cherry_set",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.CHERRY_HELMET.get(),
                                    ModItems.CHERRY_CHESTPLATE.get(),
                                    ModItems.CHERRY_LEGGINGS.get(),
                                    ModItems.CHERRY_BOOTS.get()
                            ))
                    .parent(safe)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"different_set"),
                            existingFileHelper);
            //比铁更好。
            AdvancementHolder betterThanIron = Advancement.Builder.advancement()
                    .display(
                            ModItems.STEEL_INGOT.get(),
                            Component.translatable("advancement.nine_nether_regions.better_than_iron.title"),
                            Component.translatable("advancement.nine_nether_regions.better_than_iron.description"),
                            null,
                            AdvancementType.GOAL,
                            true, true, false
                    )
                    .addCriterion("has_steel_ingot",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.STEEL_INGOT.get()
                            ))
                    .parent(safe)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"better_than_iron"),
                            existingFileHelper);
            //更安心的防护。
            AdvancementHolder betterProtection = Advancement.Builder.advancement()
                    .display(
                            ModItems.STEEL_CHESTPLATE.get(),
                            Component.translatable("advancement.nine_nether_regions.better_protection.title"),
                            Component.translatable("advancement.nine_nether_regions.better_protection.description"),
                            null,
                            AdvancementType.GOAL,
                            true, true, false
                    )
                    .addCriterion("has_steel_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.STEEL_HELMET.get()
                            ))
                    .addCriterion("has_steel_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.STEEL_CHESTPLATE.get()
                            ))
                    .addCriterion("has_steel_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.STEEL_LEGGINGS.get()
                            ))
                    .addCriterion("has_steel_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.STEEL_BOOTS.get()
                            ))
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .parent(betterThanIron)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"better_protection"),
                            existingFileHelper);
            //跳动的能量。
            AdvancementHolder beatingEnergy = Advancement.Builder.advancement()
                    .display(
                            ModItems.UNDERWORLD_CRYSTAL.get(),
                            Component.translatable("advancement.nine_nether_regions.beating_energy.title"),
                            Component.translatable("advancement.nine_nether_regions.beating_energy.description"),
                            null,
                            AdvancementType.GOAL,
                            true, true, false
                    )
                    .addCriterion("has_underworld_crystal",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.UNDERWORLD_CRYSTAL.get()
                            ))
                    .parent(safe)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"beating_energy"),
                            existingFileHelper);
            //深暗之中。
            AdvancementHolder deepInTheDark = Advancement.Builder.advancement()
                    .display(
                            ModItems.GHOSTLIUM.get(),
                            Component.translatable("advancement.nine_nether_regions.deep_in_the_dark.title"),
                            Component.translatable("advancement.nine_nether_regions.deep_in_the_dark.description"),
                            null,
                            AdvancementType.GOAL,
                            true, true, false
                    )
                    .addCriterion("has_ghostlium",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.GHOSTLIUM.get()
                            ))
                    .parent(safe)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"deep_in_the_dark"),
                            existingFileHelper);
            //亮晶晶！
            AdvancementHolder shining = Advancement.Builder.advancement()
                    .display(
                            ModItems.RAINBOWGEM.get(),
                            Component.translatable("advancement.nine_nether_regions.shining.title"),
                            Component.translatable("advancement.nine_nether_regions.shining.description"),
                            null,
                            AdvancementType.GOAL,
                            true, true, false
                    )
                    .addCriterion("has_rainbowgem",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.RAINBOWGEM.get()
                            ))
                    .parent(beatingEnergy)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"shining"),
                            existingFileHelper);
            //光彩夺目
            AdvancementHolder dazzling = Advancement.Builder.advancement()
                    .display(
                            ModItems.RAINBOWGEM_CHESTPLATE.get(),
                            Component.translatable("advancement.nine_nether_regions.dazzling.title"),
                            Component.translatable("advancement.nine_nether_regions.dazzling.description"),
                            null,
                            AdvancementType.GOAL,
                            true, true, false
                    )
                    .addCriterion("has_steel_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.RAINBOWGEM_HELMET.get()
                            ))
                    .addCriterion("has_steel_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.RAINBOWGEM_CHESTPLATE.get()
                            ))
                    .addCriterion("has_steel_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.RAINBOWGEM_LEGGINGS.get()
                            ))
                    .addCriterion("has_steel_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.RAINBOWGEM_BOOTS.get()
                            ))
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .parent(shining)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"dazzling"),
                            existingFileHelper);
            //虚无锻造
            AdvancementHolder voidriteIngot = Advancement.Builder.advancement()
                    .display(
                            ModItems.VOIDRITE_INGOT.get(),
                            Component.translatable("advancement.nine_nether_regions.voidrite_ingot.title"),
                            Component.translatable("advancement.nine_nether_regions.voidrite_ingot.description"),
                            null,
                            AdvancementType.GOAL,
                            true, true, false
                    )
                    .addCriterion("has_voidrite_ingot",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.VOIDRITE_INGOT.get()
                            ))
                    .parent(beatingEnergy)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"voidrite_ingot"),
                            existingFileHelper);
            //空虚躯壳。
            AdvancementHolder voidriteArmor = Advancement.Builder.advancement()
                    .display(
                            ModItems.VOIDRITE_CHESTPLATE.get(),
                            Component.translatable("advancement.nine_nether_regions.voidrite_armor.title"),
                            Component.translatable("advancement.nine_nether_regions.voidrite_armor.description"),
                            null,
                            AdvancementType.GOAL,
                            true, true, false
                    )
                    .addCriterion("has_steel_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.VOIDRITE_HELMET.get()
                            ))
                    .addCriterion("has_steel_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.VOIDRITE_CHESTPLATE.get()
                            ))
                    .addCriterion("has_steel_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.VOIDRITE_LEGGINGS.get()
                            ))
                    .addCriterion("has_steel_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.VOIDRITE_BOOTS.get()
                            ))
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .parent(voidriteIngot)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"voidrite_armor"),
                            existingFileHelper);
            //脆弱的吸血鬼。
            AdvancementHolder vampire = Advancement.Builder.advancement()
                    .display(
                            ModItems.RUBY_SWORD.get(),
                            Component.translatable("advancement.nine_nether_regions.vampire.title"),
                            Component.translatable("advancement.nine_nether_regions.vampire.description"),
                            null,
                            AdvancementType.GOAL,
                            true, true, true
                    )
                    .addCriterion("has_ruby_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.RUBY_SWORD.get()
                            ))
                    .parent(safe)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"vampire"),
                            existingFileHelper);
            //幽冥档案。
            AdvancementHolder hellArchive = Advancement.Builder.advancement()
                    .display(
                            ModItems.HELLALLOY_INGOT.get(),
                            Component.translatable("advancement.nine_nether_regions.hell_archive.title"),
                            Component.translatable("advancement.nine_nether_regions.hell_archive.description"),
                            null,
                            AdvancementType.GOAL,
                            true, true, false
                    )
                    .addCriterion("has_hellalloy_ingot",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.HELLALLOY_INGOT.get()
                            ))
                    .parent(shining)
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"hell_archive"),
                            existingFileHelper);
            //幽冥护体
            AdvancementHolder hellalloySet = Advancement.Builder.advancement()
                    .display(
                            ModItems.HELLALLOY_CHESTPLATE.get(),
                            Component.translatable("advancement.nine_nether_regions.hellalloy_set.title"),
                            Component.translatable("advancement.nine_nether_regions.hellalloy_set.description"),
                            null,
                            AdvancementType.CHALLENGE,
                            true, true, false
                    )
                    .addCriterion("has_full_hellalloy_set",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.HELLALLOY_HELMET.get(),
                                    ModItems.HELLALLOY_CHESTPLATE.get(),
                                    ModItems.HELLALLOY_LEGGINGS.get(),
                                    ModItems.HELLALLOY_BOOTS.get()
                            ))
                    .parent(hellArchive)
                    .rewards(AdvancementRewards.Builder.experience(444))
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "hellalloy_set"),
                            existingFileHelper);
            //九幽之怨
            AdvancementHolder styxTear = Advancement.Builder.advancement()
                    .display(
                            ModItems.STYX_TEAR.get(),
                            Component.translatable("advancement.nine_nether_regions.styx_tear.title"),
                            Component.translatable("advancement.nine_nether_regions.styx_tear.description"),
                            null,
                            AdvancementType.CHALLENGE,
                            true, true, false
                    )
                    .addCriterion("has_styx_tear",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.STYX_TEAR.get()
                            ))
                    .parent(hellArchive)
                    .rewards(AdvancementRewards.Builder.experience(44))
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"styx_tear"),
                            existingFileHelper);
            //第十三次……
            AdvancementHolder styxIngot = Advancement.Builder.advancement()
                    .display(
                            ModItems.STYX_INGOT.get(),
                            Component.translatable("advancement.nine_nether_regions.styx_ingot.title"),
                            Component.translatable("advancement.nine_nether_regions.styx_ingot.description"),
                            null,
                            AdvancementType.CHALLENGE,
                            true, true, false
                    )
                    .addCriterion("has_styx_ingot",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.STYX_INGOT.get()
                            ))
                    .parent(styxTear)
                    .rewards(AdvancementRewards.Builder.experience(44))
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID,"styx_ingot"),
                            existingFileHelper);
            //冥河铸魂
            AdvancementHolder styxSet = Advancement.Builder.advancement()
                    .display(ModItems.STYX_CHESTPLATE.get(),
                            Component.translatable("advancement.nine_nether_regions.styx_set.title"),
                            Component.translatable("advancement.nine_nether_regions.styx_set.description"),
                            null,
                            AdvancementType.CHALLENGE,
                            true, true, true)
                    .addCriterion("has_full_styx_set",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.STYX_HELMET.get(),
                                    ModItems.STYX_CHESTPLATE.get(),
                                    ModItems.STYX_LEGGINGS.get(),
                                    ModItems.STYX_BOOTS.get()
                            ))
                    .parent(styxIngot)
                    .rewards(AdvancementRewards.Builder.experience(4444))
                    .save(saver, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "styx_set"),
                            existingFileHelper);
        }
    }
}
