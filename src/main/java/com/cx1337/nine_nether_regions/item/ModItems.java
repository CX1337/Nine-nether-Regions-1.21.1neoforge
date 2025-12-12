package com.cx1337.nine_nether_regions.item;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.effect.ModEffects;
import com.cx1337.nine_nether_regions.sound.ModSounds;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static net.minecraft.world.level.block.Block.popResource;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(NineNetherRegions.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    //紫水晶短剑
    public static final DeferredItem<SwordItem> AMETHYST_DAGGER =
           ITEMS.register("amethyst_dagger", () -> new SwordItem(ModToolTiers.AMETHYST, new Item.Properties()
                   .attributes(SwordItem.createAttributes(ModToolTiers.AMETHYST, 3, -0.6F)).rarity(Rarity.COMMON)){
               //每次攻击24%概率回1血量，非强制回血。
               @Override
               public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
                   if (player.level().random.nextFloat() < 0.24f && player.getHealth() < player.getMaxHealth()) {
                       player.heal(1.0f);
                   }
                   return false;
               }
               //所有类似的tooltip均为对物品的描述。
               @Override
               public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                   tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.amethyst_dagger"));
                   super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
               }
           });

    //材料和杂项。
    public static final DeferredItem<Item> EMPTY_FABRIC =
            ITEMS.register("empty_fabric", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> MAGIC_FABRIC =
            ITEMS.register("magic_fabric", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> STYX_FABRIC =
            ITEMS.register("styx_fabric", () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_fabric"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> STYX_TEAR =
            ITEMS.register("styx_tear", () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_tear"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }

                @Override
                public boolean isFoil(ItemStack stack) {
                    return true;
                }
            });

    public static final DeferredItem<Item> CHERRY_STICK =
            ITEMS.register("cherry_stick", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    public static final DeferredItem<Item> STEEL_BASE =
            ITEMS.register("steel_base", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.steel_base"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> STEEL_INGOT =
            ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
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
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.rainbowgem"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    //红宝石剑
    public static final DeferredItem<SwordItem> RUBY_SWORD =
            ITEMS.register("ruby_sword", () -> new SwordItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RUBY, 4.0F, -2.4F)).rarity(Rarity.UNCOMMON)) {
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.RUBY.getEnchantmentValue();
                }
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.ruby_sword"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> HELLALLOY_INGOT =
            ITEMS.register("hellalloy_ingot", () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_ingot"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> STYX_INGOT =
            ITEMS.register("styx_ingot", () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_ingot"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> BLOODBLADE_ESSENCE =
            ITEMS.register("bloodblade_essence", () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.bloodblade_essence"));
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
    public static final DeferredItem<Item> HELLALLOY_ROD =
            ITEMS.register("hellalloy_rod", () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> GHOSTLIUM =
            ITEMS.register("ghostlium", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> WEB_BALL =
            ITEMS.register("web_ball", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    public static final DeferredItem<Item> AMETHYST_BEETROOT =
            ITEMS.register("amethyst_beetroot", () -> new Item(new Item.Properties().food(ModFoodProperties.AMETHYST_BEETROOT)
                    .rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> GHOSTLIUM_APPLE =
            ITEMS.register("ghostlium_apple", () -> new Item(new Item.Properties().food(ModFoodProperties.GHOSTLIUM_APPLE)
                    .rarity(Rarity.UNCOMMON)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.ghostlium_apple"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> ENCHANTED_GHOSTLIUM_APPLE =
            ITEMS.register("enchanted_ghostlium_apple", () -> new Item(new Item.Properties().food(ModFoodProperties.ENCHANTED_GHOSTLIUM_APPLE)
                    .rarity(Rarity.EPIC)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.enchanted_ghostlium_apple"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }

                @Override
                public boolean isFoil(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<Item> WEB_FRUIT =
            ITEMS.register("web_fruit", () -> new Item(new Item.Properties().food(ModFoodProperties.WEB_FRUIT)
                    .rarity(Rarity.COMMON)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.web_fruit"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    //食物注册后需在ModFoodProperties中补全信息。
    //类似可用作燃料的方块/物品注册后需在ModDataMapProvider补全信息。

    //弓。
    public static final DeferredItem<Item> HELLALLOY_LONGBOW =
            ITEMS.register("hellalloy_longbow", () -> new BowItem(new Item.Properties().fireResistant()
                    .rarity(Rarity.RARE).durability(6446)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_longbow"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }

                @Override
                protected void shootProjectile(LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle,
                                               @Nullable LivingEntity target) {
                    //箭矢初速度3倍
                    float modifiedVelocity = velocity * 3.0F;

                    super.shootProjectile(shooter, projectile, index, modifiedVelocity, inaccuracy, angle, target);

                    if (projectile instanceof AbstractArrow arrow) {
                        arrow.setBaseDamage(4.0F);
                    }
                }

                @Override
                public int getDefaultProjectileRange() {
                    return 64;
                }

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return 24;
                }
            });

    //盔甲。
    //木盔甲。
    public static final DeferredItem<ArmorItem> WOOD_HELMET =
            ITEMS.register("wood_helmet", () ->new ArmorItem(ModArmorMaterials.WOOD_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties() .durability(ArmorItem.Type.HELMET.getDurability(3)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> WOOD_CHESTPLATE =
            ITEMS.register("wood_chestplate", () ->new ArmorItem(ModArmorMaterials.WOOD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties() .durability(ArmorItem.Type.CHESTPLATE.getDurability(3)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> WOOD_LEGGINGS =
            ITEMS.register("wood_leggings", () ->new ArmorItem(ModArmorMaterials.WOOD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties() .durability(ArmorItem.Type.LEGGINGS.getDurability(3)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> WOOD_BOOTS =
            ITEMS.register("wood_boots", () ->new ArmorItem(ModArmorMaterials.WOOD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties() .durability(ArmorItem.Type.BOOTS.getDurability(3)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
            });

    //樱花盔甲。
    public static final DeferredItem<ArmorItem> CHERRY_HELMET =
            ITEMS.register("cherry_helmet", () ->new ArmorItem(ModArmorMaterials.CHERRY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties() .durability(66).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public boolean isDamageable(ItemStack stack) {
                    return false;
                }
                @Override
                public void setDamage(ItemStack stack, int damage) {
                    super.setDamage(stack, 0);
                }
                @Override
                public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> CHERRY_CHESTPLATE =
            ITEMS.register("cherry_chestplate", () ->new ArmorItem(ModArmorMaterials.CHERRY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties() .durability(99).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public boolean isDamageable(ItemStack stack) {
                    return false;
                }
                @Override
                public void setDamage(ItemStack stack, int damage) {
                    super.setDamage(stack, 0);
                }
                @Override
                public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> CHERRY_LEGGINGS =
            ITEMS.register("cherry_leggings", () ->new ArmorItem(ModArmorMaterials.CHERRY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties() .durability(88).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public boolean isDamageable(ItemStack stack) {
                    return false;
                }
                @Override
                public void setDamage(ItemStack stack, int damage) {
                    super.setDamage(stack, 0);
                }
                @Override
                public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> CHERRY_BOOTS =
            ITEMS.register("cherry_boots", () ->new ArmorItem(ModArmorMaterials.CHERRY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties() .durability(66).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public boolean isDamageable(ItemStack stack) {
                    return false;
                }
                @Override
                public void setDamage(ItemStack stack, int damage) {
                    super.setDamage(stack, 0);
                }
                @Override
                public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    return true;
                }
            });
    //铜盔甲。
    public static final DeferredItem<ArmorItem> COPPER_HELMET =
            ITEMS.register("copper_helmet", () ->new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties() .durability(ArmorItem.Type.HELMET.getDurability(11)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> COPPER_CHESTPLATE =
            ITEMS.register("copper_chestplate", () ->new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties() .durability(ArmorItem.Type.CHESTPLATE.getDurability(11)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> COPPER_LEGGINGS =
            ITEMS.register("copper_leggings", () ->new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties() .durability(ArmorItem.Type.LEGGINGS.getDurability(11)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> COPPER_BOOTS =
            ITEMS.register("copper_boots", () ->new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties() .durability(ArmorItem.Type.BOOTS.getDurability(11)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<Item> COPPER_HORSE_ARMOR =
            ITEMS.register("copper_horse_armor", () -> new AnimalArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));
    //精钢盔甲。
    public static final DeferredItem<ArmorItem> STEEL_HELMET =
            ITEMS.register("steel_helmet", () ->new ArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties() .durability(ArmorItem.Type.HELMET.getDurability(33)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> STEEL_CHESTPLATE =
            ITEMS.register("steel_chestplate", () ->new ArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties() .durability(ArmorItem.Type.CHESTPLATE.getDurability(30)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> STEEL_LEGGINGS =
            ITEMS.register("steel_leggings", () ->new ArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties() .durability(ArmorItem.Type.LEGGINGS.getDurability(31)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<ArmorItem> STEEL_BOOTS =
            ITEMS.register("steel_boots", () ->new ArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties() .durability(ArmorItem.Type.BOOTS.getDurability(32)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
            });
    public static final DeferredItem<Item> STEEL_HORSE_ARMOR =
            ITEMS.register("steel_horse_armor", () -> new AnimalArmorItem(ModArmorMaterials.STEEL_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
            false, new Item.Properties().stacksTo(1)));

    //虹玉盔甲。
    public static final DeferredItem<ArmorItem> RAINBOWGEM_HELMET =
            ITEMS.register("rainbowgem_helmet", () ->new ArmorItem(ModArmorMaterials.RAINBOWGEM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties() .durability(ArmorItem.Type.HELMET.getDurability(38)).rarity(Rarity.UNCOMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.RAINBOWGEM.getEnchantmentValue();
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.rainbowgem_armors"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> RAINBOWGEM_CHESTPLATE =
            ITEMS.register("rainbowgem_chestplate", () ->new ArmorItem(ModArmorMaterials.RAINBOWGEM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties() .durability(ArmorItem.Type.CHESTPLATE.getDurability(38)).rarity(Rarity.UNCOMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.RAINBOWGEM.getEnchantmentValue();
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.rainbowgem_armors"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> RAINBOWGEM_LEGGINGS =
            ITEMS.register("rainbowgem_leggings", () ->new ArmorItem(ModArmorMaterials.RAINBOWGEM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties() .durability(ArmorItem.Type.LEGGINGS.getDurability(38)).rarity(Rarity.UNCOMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.RAINBOWGEM.getEnchantmentValue();
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.rainbowgem_armors"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> RAINBOWGEM_BOOTS =
            ITEMS.register("rainbowgem_boots", () ->new ArmorItem(ModArmorMaterials.RAINBOWGEM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties() .durability(ArmorItem.Type.BOOTS.getDurability(38)).rarity(Rarity.UNCOMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.RAINBOWGEM.getEnchantmentValue();
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.rainbowgem_armors"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    //幽冥合金盔甲。
    public static final DeferredItem<ArmorItem> HELLALLOY_HELMET =
            ITEMS.register("hellalloy_helmet", () ->new ArmorItem(ModArmorMaterials.HELLALLOY_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties() .durability(ArmorItem.Type.HELMET.getDurability(99)).rarity(Rarity.EPIC).fireResistant()){

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.HELLALLOY.getEnchantmentValue();
                }

                @Override
                public void inventoryTick(ItemStack stack, Level level, Entity entity,
                                          int slot, boolean selected) {
                   //耐久自恢复。
                    if (!level.isClientSide
                            && entity instanceof LivingEntity living
                            && living.tickCount % 40 == 0
                            && stack.getDamageValue() > 0) {
                        stack.setDamageValue(Math.max(0, stack.getDamageValue() - 4));
                    }

                    if (level.isClientSide) return;
                    if (!(entity instanceof Player player)) return;

                    if (player.getItemBySlot(EquipmentSlot.HEAD) != stack) return;

                    //单件效果。
                    player.addEffect(new MobEffectInstance(
                            MobEffects.NIGHT_VISION,310,0,true,false,false
                    ));

                    if (player.hasEffect(MobEffects.BLINDNESS)) {
                        player.removeEffect(MobEffects.BLINDNESS);
                    }

                    if (player.hasEffect(MobEffects.DARKNESS)) {
                        player.removeEffect(MobEffects.DARKNESS);
                    }
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasAltDown()){
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_helmet_alt"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_helmet"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> HELLALLOY_CHESTPLATE =
            ITEMS.register("hellalloy_chestplate", () ->new ArmorItem(ModArmorMaterials.HELLALLOY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties() .durability(ArmorItem.Type.CHESTPLATE.getDurability(99)).rarity(Rarity.EPIC).fireResistant()){

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.HELLALLOY.getEnchantmentValue();
                }

                @Override
                public void inventoryTick(ItemStack stack, Level level, Entity entity,
                                          int slot, boolean selected) {
                    if (!level.isClientSide
                            && entity instanceof LivingEntity living
                            && living.tickCount % 40 == 0
                            && stack.getDamageValue() > 0) {
                        stack.setDamageValue(Math.max(0, stack.getDamageValue() - 4));
                    }

                    if (level.isClientSide) return;
                    if (!(entity instanceof Player player)) return;

                    if (player.getItemBySlot(EquipmentSlot.CHEST) != stack) return;

                    player.addEffect(new MobEffectInstance(
                            MobEffects.FIRE_RESISTANCE,310,0,true,false,false
                    ));

                    if (player.isOnFire() || player.isInLava()){
                        player.clearFire();
                    }
                    if (player.getRemainingFireTicks() > 0){
                        player.setRemainingFireTicks(0);
                    }

                    if (player.hasEffect(MobEffects.WITHER)) {
                        player.removeEffect(MobEffects.WITHER);
                    }
                    if (player.hasEffect(MobEffects.POISON)) {
                        player.removeEffect(MobEffects.POISON);
                    }
                    if (player.hasEffect(MobEffects.DIG_SLOWDOWN)) {
                        player.removeEffect(MobEffects.DIG_SLOWDOWN);
                    }
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasAltDown()){
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_chestplate_alt"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_chestplate"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> HELLALLOY_LEGGINGS =
            ITEMS.register("hellalloy_leggings", () ->new ArmorItem(ModArmorMaterials.HELLALLOY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties() .durability(ArmorItem.Type.LEGGINGS.getDurability(99)).rarity(Rarity.EPIC).fireResistant()){

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.HELLALLOY.getEnchantmentValue();
                }

                @Override
                public void inventoryTick(ItemStack stack, Level level, Entity entity,
                                          int slot, boolean selected) {
                    if (!level.isClientSide
                            && entity instanceof LivingEntity living
                            && living.tickCount % 40 == 0
                            && stack.getDamageValue() > 0) {
                        stack.setDamageValue(Math.max(0, stack.getDamageValue() - 4));
                    }

                    if (level.isClientSide) return;
                    if (!(entity instanceof Player player)) return;

                    if (player.getItemBySlot(EquipmentSlot.LEGS) != stack) return;

                    player.addEffect(new MobEffectInstance(
                            MobEffects.JUMP,310,0,true,false,false
                    ));

                    if (player.hasEffect(MobEffects.CONFUSION)) {
                        player.removeEffect(MobEffects.CONFUSION);
                    }
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasAltDown()){
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_leggings_alt"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_leggings"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> HELLALLOY_BOOTS =
            ITEMS.register("hellalloy_boots", () ->new ArmorItem(ModArmorMaterials.HELLALLOY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties() .durability(ArmorItem.Type.BOOTS.getDurability(99)).rarity(Rarity.EPIC).fireResistant()){

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.HELLALLOY.getEnchantmentValue();
                }

                @Override
                public void inventoryTick(ItemStack stack, Level level, Entity entity,
                                          int slot, boolean selected) {
                    if (!level.isClientSide
                            && entity instanceof LivingEntity living
                            && living.tickCount % 40 == 0
                            && stack.getDamageValue() > 0) {
                        stack.setDamageValue(Math.max(0, stack.getDamageValue() - 4));
                    }

                    if (level.isClientSide) return;
                    if (!(entity instanceof Player player)) return;

                    if (player.getItemBySlot(EquipmentSlot.FEET) != stack) return;

                    player.addEffect(new MobEffectInstance(
                            MobEffects.MOVEMENT_SPEED,310,1,true,false,false
                    ));

                    if (player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                        player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                    }
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasAltDown()){
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_boots_alt"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_boots"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    //冥河盔甲。
    public static final DeferredItem<ArmorItem> STYX_HELMET =
            ITEMS.register("styx_helmet", () ->new ArmorItem(ModArmorMaterials.STYX_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties() .durability(47774).rarity(Rarity.EPIC).fireResistant()){

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }

                //无法破坏。
                @Override
                public boolean isDamageable(ItemStack stack) {
                    return false;
                }
                @Override
                public void setDamage(ItemStack stack, int damage) {
                    super.setDamage(stack, 0);
                }
                @Override
                public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    return true;
                }

                @Override
                public void inventoryTick(ItemStack stack, Level level, Entity entity,
                                          int slot, boolean selected) {
                    //耐久自恢复(如果遇到意外情况)。
                    if (!level.isClientSide
                            && entity instanceof LivingEntity living
                            && living.tickCount % 4 == 0
                            && stack.getDamageValue() > 0) {
                        stack.setDamageValue(Math.max(0, stack.getDamageValue() - 42));
                    }

                    if (level.isClientSide) return;
                    if (!(entity instanceof Player player)) return;

                    if (player.getItemBySlot(EquipmentSlot.HEAD) != stack) return;

                    //效果。
                    player.addEffect(new MobEffectInstance(
                            MobEffects.NIGHT_VISION,310,1,true,false,false
                    ));
                    player.addEffect(new MobEffectInstance(
                            MobEffects.WATER_BREATHING,310,1,true,false,false
                    ));
                    player.addEffect(new MobEffectInstance(
                            MobEffects.SATURATION,310,1,true,false,false
                    ));

                    if (player.hasEffect(MobEffects.BLINDNESS)) {
                        player.removeEffect(MobEffects.BLINDNESS);
                    }
                    if (player.hasEffect(MobEffects.DARKNESS)) {
                        player.removeEffect(MobEffects.DARKNESS);
                    }
                    if (player.hasEffect(MobEffects.HUNGER)) {
                        player.removeEffect(MobEffects.HUNGER);
                    }
                    if (player.hasEffect(ModEffects.BLOODBLADE_CURSE)) {
                        player.removeEffect(ModEffects.BLOODBLADE_CURSE);
                    }
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasAltDown()){
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_helmet_alt"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_helmet"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> STYX_CHESTPLATE =
            ITEMS.register("styx_chestplate", () ->new ArmorItem(ModArmorMaterials.STYX_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties() .durability(69996).rarity(Rarity.EPIC).fireResistant()){

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }

                @Override
                public boolean isDamageable(ItemStack stack) {
                    return false;
                }
                @Override
                public void setDamage(ItemStack stack, int damage) {
                    super.setDamage(stack, 0);
                }
                @Override
                public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    return true;
                }

                @Override
                public void inventoryTick(ItemStack stack, Level level, Entity entity,
                                          int slot, boolean selected) {
                    if (!level.isClientSide
                            && entity instanceof LivingEntity living
                            && living.tickCount % 4 == 0
                            && stack.getDamageValue() > 0) {
                        stack.setDamageValue(Math.max(0, stack.getDamageValue() - 42));
                    }

                    if (level.isClientSide) return;
                    if (!(entity instanceof Player player)) return;

                    if (player.getItemBySlot(EquipmentSlot.CHEST) != stack) return;

                    player.addEffect(new MobEffectInstance(
                            MobEffects.FIRE_RESISTANCE,310,1,true,false,false
                    ));
                    player.addEffect(new MobEffectInstance(
                            MobEffects.DIG_SPEED,310,1,true,false,false
                    ));
                    player.addEffect(new MobEffectInstance(
                            MobEffects.DAMAGE_BOOST,310,2,true,false,false
                    ));

                    if (player.isOnFire() || player.isInLava()){
                        player.clearFire();
                    }
                    if (player.getRemainingFireTicks() > 0){
                        player.setRemainingFireTicks(0);
                    }

                    if (player.hasEffect(MobEffects.WITHER)) {
                        player.removeEffect(MobEffects.WITHER);
                    }
                    if (player.hasEffect(MobEffects.POISON)) {
                        player.removeEffect(MobEffects.POISON);
                    }
                    if (player.hasEffect(MobEffects.DIG_SLOWDOWN)) {
                        player.removeEffect(MobEffects.DIG_SLOWDOWN);
                    }
                    if (player.hasEffect(MobEffects.WEAKNESS)) {
                        player.removeEffect(MobEffects.WEAKNESS);
                    }
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasAltDown()){
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_chestplate_alt"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_chestplate"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> STYX_LEGGINGS =
            ITEMS.register("styx_leggings", () ->new ArmorItem(ModArmorMaterials.STYX_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties() .durability(58885).rarity(Rarity.EPIC).fireResistant()){

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }

                @Override
                public boolean isDamageable(ItemStack stack) {
                    return false;
                }
                @Override
                public void setDamage(ItemStack stack, int damage) {
                    super.setDamage(stack, 0);
                }
                @Override
                public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    return true;
                }

                @Override
                public void inventoryTick(ItemStack stack, Level level, Entity entity,
                                          int slot, boolean selected) {
                    if (!level.isClientSide
                            && entity instanceof LivingEntity living
                            && living.tickCount % 4 == 0
                            && stack.getDamageValue() > 0) {
                        stack.setDamageValue(Math.max(0, stack.getDamageValue() - 42));
                    }

                    if (level.isClientSide) return;
                    if (!(entity instanceof Player player)) return;

                    if (player.getItemBySlot(EquipmentSlot.LEGS) != stack) return;

                    player.addEffect(new MobEffectInstance(
                            MobEffects.JUMP,310,1,true,false,false
                    ));
                    player.addEffect(new MobEffectInstance(
                            MobEffects.LUCK,310,2,true,false,false
                    ));

                    if (player.hasEffect(MobEffects.CONFUSION)) {
                        player.removeEffect(MobEffects.CONFUSION);
                    }
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasAltDown()){
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_leggings_alt"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_leggings"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> STYX_BOOTS =
            ITEMS.register("styx_boots", () ->new ArmorItem(ModArmorMaterials.STYX_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties() .durability(47774).rarity(Rarity.EPIC).fireResistant()){

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }

                @Override
                public boolean isDamageable(ItemStack stack) {
                    return false;
                }
                @Override
                public void setDamage(ItemStack stack, int damage) {
                    super.setDamage(stack, 0);
                }
                @Override
                public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    return true;
                }

                @Override
                public void inventoryTick(ItemStack stack, Level level, Entity entity,
                                          int slot, boolean selected) {
                    if (!level.isClientSide
                            && entity instanceof LivingEntity living
                            && living.tickCount % 4 == 0
                            && stack.getDamageValue() > 0) {
                        stack.setDamageValue(Math.max(0, stack.getDamageValue() - 42));
                    }

                    if (level.isClientSide) return;
                    if (!(entity instanceof Player player)) return;

                    if (player.getItemBySlot(EquipmentSlot.FEET) != stack) return;

                    player.addEffect(new MobEffectInstance(
                            MobEffects.MOVEMENT_SPEED,310,2,true,false,false
                    ));

                    if (player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                        player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                    }
                    if (player.hasEffect(MobEffects.LEVITATION)) {
                        player.removeEffect(MobEffects.LEVITATION);
                    }
                    if (player.hasEffect(MobEffects.INFESTED)) {
                        player.removeEffect(MobEffects.INFESTED);
                    }
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasAltDown()){
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_boots_alt"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_boots"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    //冥河战刃。
    public static final DeferredItem<SwordItem> STYX_SWORD =
            ITEMS.register("styx_sword", () -> new SwordItem(ModToolTiers.STYX, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.STYX,
                            6.0F, -2.0F)).rarity(Rarity.EPIC).fireResistant()) {

                @Override
                public boolean onLeftClickEntity(ItemStack stack, Player player, Entity target) {
                    if (player.getAttackStrengthScale(0.5F) >= 1.0F) {
                        //蓄满力强制百分比恢复生命。
                        if (player.level() instanceof ServerLevel sl) {
                            sl.playSound(null,
                                    player.getX(), player.getY(), player.getZ(),
                                    SoundEvents.PLAYER_ATTACK_SWEEP,
                                    SoundSource.PLAYERS, 1.0F, 1.0F);
                            double radius = 1.5;
                            int particleCount = 8;
                            double playerHeight = player.getEyeHeight();
                            for (int i = 0; i < particleCount; i ++) {
                                double angle = 2 * Math.PI * i / particleCount;
                                double offsetX = radius * Math.cos(angle);
                                double offsetZ = radius * Math.sin(angle);
                                sl.sendParticles(ParticleTypes.SWEEP_ATTACK,
                                        player.getX() + offsetX,
                                        player.getY() + playerHeight,
                                        player.getZ() + offsetZ, 1,
                                        0.0, 0.0, 0.0,
                                        0.0);
                            }

                            float newHealth = player.getHealth() + (player.getMaxHealth() * 0.08F);
                            player.setHealth(Math.min(newHealth, player.getMaxHealth()));

                            //蓄满力半径3m内所有非友方实体AOE伤害。
                            AABB box = player.getBoundingBox().inflate(4.0D);
                            float baseDamage = (float) player.getAttributeValue(Attributes.ATTACK_DAMAGE);

                            for (LivingEntity le : sl.getEntitiesOfClass(LivingEntity.class, box,
                                    e -> e != player && !player.isAlliedTo(e))) {
                                float bonusDamage = le.getMaxHealth() * 0.05F;
                                float totalDamage = baseDamage + bonusDamage;

                                le.hurt(player.damageSources().playerAttack(player), totalDamage);
                                le.knockback(0.2F,
                                        player.getX() - le.getX(),
                                        player.getZ() - le.getZ());
                            }
                        }
                    }
                    return super.onLeftClickEntity(stack, player, target);
                }

                @Override
                public boolean isDamageable(ItemStack stack) {
                    return false;
                }
                @Override
                public void setDamage(ItemStack stack, int damage) {
                    super.setDamage(stack, 0);
                }

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.STYX.getEnchantmentValue();
                }

                @Override
                public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
                    return true;
                }

                @Override
                public void inventoryTick(ItemStack stack, Level level, Entity holder,
                                          int slot, boolean selected) {
                    if (level.isClientSide) return;
                    if (!(holder instanceof Player player)) return;

                    if (stack.getDamageValue() > 0 && holder.tickCount % 4 == 0) {
                        stack.setDamageValue(stack.getDamageValue() - 42);
                    }
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasAltDown()){
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_sword_alt"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_sword"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<SwordItem> DAMAGE_TEST =
            ITEMS.register("damage_test", () -> new SwordItem(ModToolTiers.STYX, new Item.Properties()
                            .attributes(SwordItem.createAttributes(ModToolTiers.STYX,
                                    4426.0F, 0.0F)).rarity(Rarity.EPIC).fireResistant()){
                @Override
                public boolean onLeftClickEntity(ItemStack stack, Player player, Entity target) {
                    if (player.getAttackStrengthScale(0.5F) >= 1.0F) {
                        if (player.level() instanceof ServerLevel serverLevel) {
                            serverLevel.playSound(null,
                                    player.getX(), player.getY(), player.getZ(),
                                    SoundEvents.ARROW_HIT_PLAYER,
                                    SoundSource.PLAYERS, 1.0F, 1.0F);
                            AABB areaOfEffect = player.getBoundingBox().inflate(4.0D);
                            List<LivingEntity> entitiesInRange = serverLevel.getEntitiesOfClass(
                                    LivingEntity.class, areaOfEffect,
                                    entity -> entity != player
                            );
                            for (LivingEntity entity : entitiesInRange) {
                                float newHealth = entity.getHealth() - 4444.0F;
                                if (newHealth <= 0.0F) {
                                    entity.setHealth(0.0F);
                                    entity.die(player.damageSources().playerAttack(player));
                                } else {
                                    entity.setHealth(newHealth);
                                }
                            }
                        }
                    }
                    return super.onLeftClickEntity(stack, player, target);
                }

                @Override
                public boolean isDamageable(ItemStack stack) {
                    return false;
                }
                @Override
                public void setDamage(ItemStack stack, int damage) {
                    super.setDamage(stack, 0);
                }
            });

    //工具。
    //冥河镐。
    public static final DeferredItem<PickaxeItem> STYX_PICKAXE =
            ITEMS.register("styx_pickaxe", () -> new PickaxeItem(ModToolTiers.STYX, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STYX, 1.0F, -2.6F)).rarity(Rarity.EPIC).fireResistant()){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.STYX.getEnchantmentValue();
                }

                //加速破坏速度（貌似无效）。
                @Override
                public float getDestroySpeed(ItemStack stack, BlockState state) {
                   float originalSpeed = super.getDestroySpeed(stack, state);
                   return originalSpeed > 1.0F ? originalSpeed * 2.5F : originalSpeed;
                }

                //挖掘24%掉落钻石，12%掉落下界合金碎片。
                @Override
                public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miner) {
                    if (!level.isClientSide && miner instanceof Player player) {
                        RandomSource random = level.random;
                        if (random.nextFloat() < 0.24F) {
                            popResource(level, pos, new ItemStack(Items.DIAMOND));
                        }
                        if (random.nextFloat() < 0.12F) {
                            popResource(level, pos, new ItemStack(Items.NETHERITE_SCRAP));
                        }
                    }
                    return super.mineBlock(stack, level, state, pos, miner);
                }

                @Override
                public void inventoryTick(ItemStack stack, Level level, Entity holder,
                                          int slot, boolean selected) {
                    if (level.isClientSide) return;
                    if (!(holder instanceof Player player)) return;

                    if (stack.getDamageValue() > 0 && holder.tickCount % 4 == 0) {
                        stack.setDamageValue(stack.getDamageValue() - 24);
                    }
                }

                @Override
                public boolean isDamageable(ItemStack stack) {
                    return false;
                }
                @Override
                public void setDamage(ItemStack stack, int damage) {
                    super.setDamage(stack, 0);
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasAltDown()){
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_pickaxe_alt"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_pickaxe"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    //铜工具。
    public static final DeferredItem<PickaxeItem> COPPER_PICKAXE =
            ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 0.0F, -2.6F)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.COPPER.getEnchantmentValue();
                }
            });
    public static final DeferredItem<ShovelItem> COPPER_SHOVEL =
            ITEMS.register("copper_shovel", () -> new ShovelItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.COPPER, 0.5F, -2.8F)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.COPPER.getEnchantmentValue();
                }
            });
    public static final DeferredItem<AxeItem> COPPER_AXE =
            ITEMS.register("copper_axe", () -> new AxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 6.0F, -3.0F)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.COPPER.getEnchantmentValue();
                }
            });
    public static final DeferredItem<HoeItem> COPPER_HOE =
            ITEMS.register("copper_hoe", () -> new HoeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.COPPER, -2.0F, -1.0F)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.COPPER.getEnchantmentValue();
                }
            });
    public static final DeferredItem<SwordItem> COPPER_SWORD =
            ITEMS.register("copper_sword", () -> new SwordItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.COPPER, 2.0F, -2.4F)).rarity(Rarity.COMMON)) {
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.STEEL.getEnchantmentValue();
                }
            });

    //精钢工具。
    public static final DeferredItem<PickaxeItem> STEEL_PICKAXE =
            ITEMS.register("steel_pickaxe", () -> new PickaxeItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STEEL, 1.0F, -2.6F)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.STEEL.getEnchantmentValue();
                }
            });
    public static final DeferredItem<ShovelItem> STEEL_SHOVEL =
            ITEMS.register("steel_shovel", () -> new ShovelItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.STEEL, 1.5F, -2.8F)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.STEEL.getEnchantmentValue();
                }
            });
    public static final DeferredItem<AxeItem> STEEL_AXE =
            ITEMS.register("steel_axe", () -> new AxeItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.STEEL, 4.0F, -3.0F)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.STEEL.getEnchantmentValue();
                }
            });
    public static final DeferredItem<HoeItem> STEEL_HOE =
            ITEMS.register("steel_hoe", () -> new HoeItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.STEEL, 0.5F, -1.0F)).rarity(Rarity.COMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.STEEL.getEnchantmentValue();
                }
            });
    public static final DeferredItem<SwordItem> STEEL_SWORD =
            ITEMS.register("steel_sword", () -> new SwordItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.STEEL, 4.0F, -2.4F)).rarity(Rarity.COMMON)) {
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.STEEL.getEnchantmentValue();
                }
            });

    //虹玉工具。
    public static final DeferredItem<PickaxeItem> RAINBOWGEM_PICKAXE =
            ITEMS.register("rainbowgem_pickaxe", () -> new PickaxeItem(ModToolTiers.RAINBOWGEM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.RAINBOWGEM, 1.0F, -2.6F)).rarity(Rarity.UNCOMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.RAINBOWGEM.getEnchantmentValue();
                }
            });
    public static final DeferredItem<ShovelItem> RAINBOWGEM_SHOVEL =
            ITEMS.register("rainbowgem_shovel", () -> new ShovelItem(ModToolTiers.RAINBOWGEM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.RAINBOWGEM, 1.5F, -2.8F)).rarity(Rarity.UNCOMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.RAINBOWGEM.getEnchantmentValue();
                }
            });
    public static final DeferredItem<AxeItem> RAINBOWGEM_AXE =
            ITEMS.register("rainbowgem_axe", () -> new AxeItem(ModToolTiers.RAINBOWGEM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.RAINBOWGEM, 4.0F, -3.0F)).rarity(Rarity.UNCOMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.RAINBOWGEM.getEnchantmentValue();
                }
            });
    public static final DeferredItem<HoeItem> RAINBOWGEM_HOE =
            ITEMS.register("rainbowgem_hoe", () -> new HoeItem(ModToolTiers.RAINBOWGEM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.RAINBOWGEM, 0.5F, -1.0F)).rarity(Rarity.UNCOMMON)){
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.RAINBOWGEM.getEnchantmentValue();
                }
            });
    public static final DeferredItem<SwordItem> RAINBOWGEM_SWORD =
            ITEMS.register("rainbowgem_sword", () -> new SwordItem(ModToolTiers.RAINBOWGEM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RAINBOWGEM, 4.0F, -2.4F)).rarity(Rarity.UNCOMMON)) {
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.RAINBOWGEM.getEnchantmentValue();
                }
            });

    //幽冥合金工具。
    public static final DeferredItem<PickaxeItem> HELLALLOY_PICKAXE =
                        ITEMS.register("hellalloy_pickaxe", () -> new PickaxeItem(ModToolTiers.HELLALLOY, new Item.Properties()
                                .attributes(PickaxeItem.createAttributes(ModToolTiers.HELLALLOY, 1.0F, -2.6F)).rarity(Rarity.RARE).fireResistant()){
                            @Override
                            public boolean isEnchantable(ItemStack stack) {
                                return true;
                            }
                            @Override
                            public int getEnchantmentValue() {
                                return ModToolTiers.HELLALLOY.getEnchantmentValue();
                            }

                            @Override
                            public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_pickaxe"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                            }
                        });
    public static final DeferredItem<ShovelItem> HELLALLOY_SHOVEL =
                        ITEMS.register("hellalloy_shovel", () -> new ShovelItem(ModToolTiers.HELLALLOY, new Item.Properties()
                                .attributes(ShovelItem.createAttributes(ModToolTiers.HELLALLOY, 1.5F, -2.8F)).rarity(Rarity.RARE).fireResistant()){
                            @Override
                            public boolean isEnchantable(ItemStack stack) {
                                return true;
                            }
                            @Override
                            public int getEnchantmentValue() {
                                return ModToolTiers.HELLALLOY.getEnchantmentValue();
                            }

                            @Override
                            public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_shovel"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                            }
                        });
    public static final DeferredItem<AxeItem> HELLALLOY_AXE =
                        ITEMS.register("hellalloy_axe", () -> new AxeItem(ModToolTiers.HELLALLOY, new Item.Properties()
                                .attributes(AxeItem.createAttributes(ModToolTiers.HELLALLOY, 6.0F, -2.8F)).rarity(Rarity.RARE).fireResistant()){
                            @Override
                            public boolean isEnchantable(ItemStack stack) {
                                return true;
                            }
                            @Override
                            public int getEnchantmentValue() {
                                return ModToolTiers.HELLALLOY.getEnchantmentValue();
                            }

                            @Override
                            public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_axe"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                            }
                        });
    public static final DeferredItem<HoeItem> HELLALLOY_HOE =
                        ITEMS.register("hellalloy_hoe", () -> new HoeItem(ModToolTiers.HELLALLOY, new Item.Properties()
                                .attributes(HoeItem.createAttributes(ModToolTiers.HELLALLOY, 0.5F, -1.0F)).rarity(Rarity.RARE).fireResistant()){
                            @Override
                            public boolean isEnchantable(ItemStack stack) {
                                return true;
                            }
                            @Override
                            public int getEnchantmentValue() {
                                return ModToolTiers.HELLALLOY.getEnchantmentValue();
                            }

                            @Override
                            public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                                tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_hoe"));
                                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                            }
                        });

    //特殊。
    public static final DeferredItem<SwordItem> ALLOY_HILT =
            ITEMS.register("alloy_hilt", () -> new SwordItem(ModToolTiers.HELLALLOY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.HELLALLOY, -6.0F, -1.0F)).rarity(Rarity.EPIC).fireResistant()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.alloy_hilt"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }
                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.HELLALLOY.getEnchantmentValue();
                }
            });

    //幽冥合金剑。
    public static final DeferredItem<SwordItem> HELLALLOY_SWORD =
            ITEMS.register("hellalloy_sword", () -> new SwordItem(ModToolTiers.HELLALLOY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.HELLALLOY, 4.0F, -2.0F)).rarity(Rarity.EPIC).fireResistant()) {
                @Override
                //蓄满力固定值范围伤害。
                public boolean onLeftClickEntity(ItemStack stack, Player player, Entity target) {
                    if (player.getAttackStrengthScale(0.5F) >= 1.0F) {
                        if (player.level() instanceof ServerLevel sl) {
                            AABB box = target.getBoundingBox().inflate(2.0D);
                            for (LivingEntity le : sl.getEntitiesOfClass(LivingEntity.class, box,
                                    e -> e != target && e != player && !player.isAlliedTo(e))) {
                                le.hurt(player.damageSources().playerAttack(player), 16.0F);
                                le.knockback(0.2F,
                                        player.getX() - le.getX(),
                                        player.getZ() - le.getZ());
                            }
                        }
                    }
                    return super.onLeftClickEntity(stack, player, target);
                }

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }

                @Override
                public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
                    return true;
                }

                @Override
                public int getEnchantmentValue() {
                    return ModToolTiers.HELLALLOY.getEnchantmentValue();
                }

                @Override
                public void inventoryTick(ItemStack stack, Level level, Entity holder,
                                          int slot, boolean selected) {
                    if (level.isClientSide) return;
                    if (!(holder instanceof Player player)) return;

                    if (stack.getDamageValue() > 0 && holder.tickCount % 50 == 0) {
                        stack.setDamageValue(stack.getDamageValue() - 1);
                    }
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                   if (Screen.hasAltDown()){
                       tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_sword_alt"));
                   } else {
                       tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_sword"));
                   }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    //法杖及配件
    public static final DeferredItem<Item> FIRE_CORE =
            ITEMS.register("fire_core", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> FIRE_STAFF =
            ITEMS.register("fire_staff", () -> new Item(new Item.Properties()
                    .durability(101).rarity(Rarity.UNCOMMON)){
                @Override
                public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
                    ItemStack itemStack = player.getItemInHand(hand);
                    player.startUsingItem(hand);

                    if (!level.isClientSide) {
                        Vec3 lookVec = player.getLookAngle();
                        SmallFireball smallFireball = new SmallFireball(level, player,
                                lookVec.scale(1.5));
                        smallFireball.setPos(player.getX(), player.getEyeY(), player.getZ());
                        smallFireball.setOwner(player);
                        level.addFreshEntity(smallFireball);
                        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);

                        EquipmentSlot slot = hand == InteractionHand.MAIN_HAND ?
                                EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                        itemStack.hurtAndBreak(1, player, slot);

                        player.getCooldowns().addCooldown(this, 20);
                    }
                    return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
                }

                @Override
                public UseAnim getUseAnimation(ItemStack stack) {
                    return UseAnim.BLOCK;
                }
                @Override
                public int getUseDuration(ItemStack stack, LivingEntity entity) {
                    return 8;
                }

                @Override
                public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
                    return repairCandidate.is(Items.BLAZE_POWDER);
                }

                @Override
                public int getEnchantmentValue(ItemStack stack) {
                    return 0;
                }
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return false;
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.fire_staff"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> WITHER_CORE =
            ITEMS.register("wither_core", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final DeferredItem<Item> WITHER_STAFF =
            ITEMS.register("wither_staff", () -> new Item(new Item.Properties()
                    .durability(404).rarity(Rarity.RARE).fireResistant()){
                @Override
                public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
                    ItemStack itemStack = player.getItemInHand(hand);
                    player.startUsingItem(hand);

                    if (!level.isClientSide) {
                        Vec3 lookVec = player.getLookAngle();
                        WitherSkull witherSkull = new WitherSkull(level, player,
                                lookVec.scale(1.5));
                        witherSkull.setPos(player.getX(), player.getEyeY(), player.getZ());
                        witherSkull.setOwner(player);
                        level.addFreshEntity(witherSkull);
                        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                SoundEvents.WITHER_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);

                        EquipmentSlot slot = hand == InteractionHand.MAIN_HAND ?
                                EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                        itemStack.hurtAndBreak(1, player, slot);

                        player.getCooldowns().addCooldown(this, 50);
                    }
                    return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
                }

                @Override
                public UseAnim getUseAnimation(ItemStack stack) {
                    return UseAnim.BLOCK;
                }
                @Override
                public int getUseDuration(ItemStack stack, LivingEntity entity) {
                    return 8;
                }

                @Override
                public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
                    return repairCandidate.is(Items.SOUL_SAND);
                }

                @Override
                public int getEnchantmentValue(ItemStack stack) {
                    return 0;
                }
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return false;
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.wither_staff"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> VOID_CORE =
            ITEMS.register("void_core", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final DeferredItem<Item> VOID_STAFF =
            ITEMS.register("void_staff", () -> new Item(new Item.Properties()
                    .durability(404).rarity(Rarity.EPIC).fireResistant()){
                @Override
                public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
                    ItemStack itemStack = player.getItemInHand(hand);
                    player.startUsingItem(hand);

                    if (!level.isClientSide) {
                        Vec3 lookVec = player.getLookAngle();
                        DragonFireball dragonFireball = new DragonFireball(level, player,
                                lookVec.scale(1.5));
                        dragonFireball.setPos(player.getX(), player.getEyeY(), player.getZ());
                        dragonFireball.setOwner(player);
                        level.addFreshEntity(dragonFireball);
                        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                SoundEvents.ENDER_DRAGON_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);

                        EquipmentSlot slot = hand == InteractionHand.MAIN_HAND ?
                                EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                        itemStack.hurtAndBreak(1, player, slot);

                        player.getCooldowns().addCooldown(this, 160);
                    }
                    return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
                }

                @Override
                public UseAnim getUseAnimation(ItemStack stack) {
                    return UseAnim.BLOCK;
                }
                @Override
                public int getUseDuration(ItemStack stack, LivingEntity entity) {
                    return 8;
                }

                @Override
                public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
                    return repairCandidate.is(Items.DRAGON_BREATH);
                }

                @Override
                public int getEnchantmentValue(ItemStack stack) {
                    return 0;
                }
                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return false;
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.void_staff"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> ENDER_STAFF =
            ITEMS.register("ender_staff", () -> new Item(new Item.Properties()
                            .durability(202).rarity(Rarity.RARE).fireResistant()){
                @Override
                public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
                    ItemStack itemStack = player.getItemInHand(hand);
                    player.startUsingItem(hand);

                    if (!level.isClientSide) {
                        final double maxDistance = 64.0;
                        Vec3 start = player.getEyePosition();
                        Vec3 look = player.getLookAngle();
                        Vec3 end = start.add(look.x*maxDistance, look.y*maxDistance, look.z*maxDistance);
                        HitResult hitResult = level.clip(new ClipContext(
                                start, end, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player
                        ));
                        Vec3 targetPos;
                        if (hitResult.getType() != HitResult.Type.MISS) {
                            targetPos = hitResult.getLocation().subtract(look.x*0.2, look.y*0.2, look.z*0.2);
                        } else {
                            targetPos = end;
                        }

                        BlockPos targetBlockPos = new BlockPos((int) targetPos.x, (int) targetPos.y, (int) targetPos.z);
                        Level world = player.level();
                        if (world.isEmptyBlock(targetBlockPos)) {
                            for (int i = 1; i <= 5; i++) {
                                BlockPos below = targetBlockPos.below(i);
                                if (!world.isEmptyBlock(below)) {
                                    targetBlockPos = below.above();
                                    targetPos = new Vec3(targetPos.x, targetBlockPos.getY() + 0.5, targetPos.z);
                                    break;
                                }
                            }
                        } else {
                            for (int i = 1; i <= 5; i++) {
                                BlockPos above = targetBlockPos.above(i);
                                if (!world.isEmptyBlock(above)) {
                                    targetBlockPos = above;
                                    targetPos = new Vec3(targetPos.x, targetBlockPos.getY() + 0.5, targetPos.z);
                                    break;
                                }
                            }
                        }

                        player.teleportTo(targetPos.x, targetPos.y, targetPos.z);
                        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                SoundEvents.PLAYER_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
                        player.addEffect(
                                new MobEffectInstance(MobEffects.ABSORPTION, 80, 0));

                        EquipmentSlot slot = hand == InteractionHand.MAIN_HAND ?
                                EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                        itemStack.hurtAndBreak(1, player, slot);
                        player.getCooldowns().addCooldown(this, 30);
                    }
                    return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
                }

                @Override
                public UseAnim getUseAnimation(ItemStack stack) {
                    return UseAnim.BLOCK;
                }
                @Override
                public int getUseDuration(ItemStack stack, LivingEntity entity) {
                    return 8;
                }

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return false;
                }

                @Override
                public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
                    return repairCandidate.is(Items.ENDER_PEARL);
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.ender_staff"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

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