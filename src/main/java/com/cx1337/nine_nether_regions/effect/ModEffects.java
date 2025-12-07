package com.cx1337.nine_nether_regions.effect;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.effect.effects.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, NineNetherRegions.MODID);

    public static final DeferredHolder<MobEffect, DeclineEffect> DECLINE =
            MOB_EFFECTS.register("decline", () -> new DeclineEffect(MobEffectCategory.HARMFUL, 0x013220));
    public static final DeferredHolder<MobEffect, SpiderClimbEffect> SPIDER_CLIMB =
            MOB_EFFECTS.register("spider_climb", () -> new SpiderClimbEffect(MobEffectCategory.BENEFICIAL, 0x566363));
    public static final DeferredHolder<MobEffect, BloodbladeCurseEffect> BLOODBLADE_CURSE =
            MOB_EFFECTS.register("bloodblade_curse", () -> new BloodbladeCurseEffect(MobEffectCategory.HARMFUL, 0x2C0303));
    public static final DeferredHolder<MobEffect, FrostEffect> FROST =
            MOB_EFFECTS.register("frost", () -> new FrostEffect(MobEffectCategory.HARMFUL, 0x87CEEB));
    public static final DeferredHolder<MobEffect, WrappedEffect> WRAPPED =
            MOB_EFFECTS.register("wrapped", () -> new WrappedEffect(MobEffectCategory.HARMFUL, 0x797979));
    public static final DeferredHolder<MobEffect, HellBlastEffect> HELL_BLAST =
            MOB_EFFECTS.register("hell_blast", () -> new HellBlastEffect(MobEffectCategory.HARMFUL, 0x000f0a));


    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
