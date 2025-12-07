package com.cx1337.nine_nether_regions.enchantment;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.enchantment.custom.SoulRipEnchantmentEffect;
import com.cx1337.nine_nether_regions.enchantment.custom.StormAngerEnchantmentEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, NineNetherRegions.MODID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> STORM_ANGER =
            ENTITY_ENCHANTMENT_EFFECTS.register("storm_anger", () -> StormAngerEnchantmentEffect.CODEC);
    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> SOUL_RIP =
            ENTITY_ENCHANTMENT_EFFECTS.register("soul_rip", () -> SoulRipEnchantmentEffect.CODEC);

    public static void register(IEventBus eventBus) {
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
    }
}
