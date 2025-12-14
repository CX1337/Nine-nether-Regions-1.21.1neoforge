package com.cx1337.nine_nether_regions.item.custom;

import com.cx1337.nine_nether_regions.item.ModToolTiers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DamageTest extends SwordItem {
    public DamageTest() {
        super(ModToolTiers.STYX, new Properties()
                .attributes(SwordItem.createAttributes(ModToolTiers.STYX, 4426.0F, 0.0F))
                .rarity(Rarity.EPIC).fireResistant());
    }
    @Override
    public boolean onLeftClickEntity(@NotNull ItemStack stack, Player player, @NotNull Entity target) {
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
    public boolean isDamageable(@NotNull ItemStack stack) {
        return false;
    }
    @Override
    public void setDamage(@NotNull ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }
}
