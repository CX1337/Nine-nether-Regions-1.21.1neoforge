package com.cx1337.nine_nether_regions.effect.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class MagConfineEffect extends MobEffect {
    public MagConfineEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            removeEffects(entity);
        }
        return true;
    }

    private void removeEffects(LivingEntity entity) {
        if (entity.hasEffect(MobEffects.REGENERATION)) {
            entity.removeEffect(MobEffects.REGENERATION);
        }
        if (entity.hasEffect(MobEffects.ABSORPTION)) {
            entity.removeEffect(MobEffects.ABSORPTION);
        }
        if (entity.hasEffect(MobEffects.HEAL)) {
            entity.removeEffect(MobEffects.HEAL);
        }
        if (entity.hasEffect(MobEffects.FIRE_RESISTANCE)) {
            entity.removeEffect(MobEffects.FIRE_RESISTANCE);
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onEffectStarted(LivingEntity livingEntity, int amplifier) {
        super.onEffectStarted(livingEntity, amplifier);
        if (!livingEntity.level().isClientSide) {
            removeEffects(livingEntity);
        }
    }
}
