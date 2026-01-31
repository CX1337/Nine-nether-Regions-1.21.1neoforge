package com.cx1337.nine_nether_regions.potion;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, NineNetherRegions.MODID);

    public static final Holder<Potion> DECLINE_POTION =
            POTIONS.register("decline_potion", () ->
                    new Potion(new MobEffectInstance(ModEffects.DECLINE, 1200, 0)));
    public static final Holder<Potion> S_DECLINE_POTION =
            POTIONS.register("s_decline_potion", () ->
                    new Potion(new MobEffectInstance(ModEffects.DECLINE, 1200, 2)));
    public static final Holder<Potion> BB_CURSE_POTION =
            POTIONS.register("bb_curse_potion", () ->
                    new Potion(new MobEffectInstance(ModEffects.BLOODBLADE_CURSE, 5680, 0)));
    public static final Holder<Potion> S_BB_CURSE_POTION =
            POTIONS.register("s_bb_curse_potion", () ->
                    new Potion(new MobEffectInstance(ModEffects.BLOODBLADE_CURSE, 5680, 2)));
    public static final Holder<Potion> MAG_CONFINE_POTION =
            POTIONS.register("mag_confine_potion", () ->
                    new Potion(new MobEffectInstance(ModEffects.MAG_CONFINE, 5680, 0)));
    public static final Holder<Potion> FROST_POTION =
            POTIONS.register("frost_potion", () ->
                    new Potion(new MobEffectInstance(ModEffects.FROST, 1200, 0)));
    public static final Holder<Potion> S_FROST_POTION =
            POTIONS.register("s_frost_potion", () ->
                    new Potion(new MobEffectInstance(ModEffects.FROST, 1200, 2)));
    public static final Holder<Potion> STRIKE_POTION =
            POTIONS.register("strike_potion", () ->
                    new Potion(new MobEffectInstance(ModEffects.STRIKE, 1200, 0)));
    public static final Holder<Potion> S_STRIKE_POTION =
            POTIONS.register("s_strike_potion", () ->
                    new Potion(new MobEffectInstance(ModEffects.STRIKE, 1200, 2)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
