package com.cx1337.nine_nether_regions.item;

import com.cx1337.nine_nether_regions.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties AMETHYST_BEETROOT =
            new FoodProperties.Builder().nutrition(2).saturationModifier(0.8F)
                    .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 0),1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0),0.32F)
                    .alwaysEdible().fast().build();
    public static final FoodProperties HELL_BLUEBERRY =
            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8F).fast().build();
    public static final FoodProperties GHOSTLIUM_APPLE =
            new FoodProperties.Builder().nutrition(5).saturationModifier(1.2F)
                    .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 1),1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 1),1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 0),1.0F)
                    .alwaysEdible().build();
    public static final FoodProperties ENCHANTED_GHOSTLIUM_APPLE =
            new FoodProperties.Builder().nutrition(8).saturationModifier(1.2F)
                    .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 6200, 4),1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 3),1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6600, 0),1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6600, 1),1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6200, 1),1.0F)
                    .alwaysEdible().build();
    public static final FoodProperties WEB_FRUIT =
            new FoodProperties.Builder().nutrition(5).saturationModifier(0.9F)
                    .effect(() -> new MobEffectInstance(ModEffects.SPIDER_CLIMB, 1200, 0),1.0F)
                    .alwaysEdible().build();
}
