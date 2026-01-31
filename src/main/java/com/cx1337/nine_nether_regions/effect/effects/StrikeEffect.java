package com.cx1337.nine_nether_regions.effect.effects;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class StrikeEffect extends MobEffect {
    public static final ResourceKey<DamageType> MAGELECTRO_DAMAGE =
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "magelectro"));

    public StrikeEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        int damageInterval = Math.max(1, 40 >> amplifier);

        if (entity.tickCount % damageInterval == 0){
            DamageSource magelectroDamage = new DamageSource(
                    entity.level().registryAccess()
                            .registryOrThrow(Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(MAGELECTRO_DAMAGE)
            );
            entity.hurt(magelectroDamage, 1.0F);
            playSound(entity);
            return true;
        }
        return true;
    }

    private void playSound(LivingEntity entity) {
        entity.level().playSound(
                null, entity.getX(), entity.getY(), entity.getZ(),
                SoundEvents.LIGHTNING_BOLT_THUNDER,
                SoundSource.PLAYERS, 0.4F, 1.5F + entity.getRandom().nextFloat() * 0.4F
        );
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
