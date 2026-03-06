package com.cx1337.nine_nether_regions.item.custom;

import com.cx1337.nine_nether_regions.effect.ModEffects;
import com.cx1337.nine_nether_regions.item.ModToolTiers;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StyxTwinnedSword extends SwordItem implements RangeWeapon{
    public StyxTwinnedSword() {
        super(ModToolTiers.STYX, new Properties()
                .attributes(createAttributes())
                .rarity(Rarity.EPIC).fireResistant());
    }
    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 31.0D,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.4D,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, 4.0F,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND)
                .add(Attributes.BLOCK_INTERACTION_RANGE,
                        new AttributeModifier(BASE_BLOCK_INTERACTION_RANGE_ID, 4.0F,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND)
                .build();
    }

    @Override
    public boolean onLeftClickEntity(@NotNull ItemStack stack, Player player, @NotNull Entity target) {
        if (player.getAttackStrengthScale(0.5F) >= 1.0F) {
            //蓄满力强制百分比恢复生命。
            if (player.level() instanceof ServerLevel sl) {
                sl.playSound(null,
                        player.getX(), player.getY(), player.getZ(),
                        SoundEvents.PLAYER_ATTACK_SWEEP,
                        SoundSource.PLAYERS, 1.0F, 1.0F);
                double radius = 2.4;
                int particleCount = 12;
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
                float newHealth = player.getHealth() + (player.getMaxHealth() * 0.16F);
                player.setHealth(Math.min(newHealth, player.getMaxHealth()));

                if (target instanceof LivingEntity targetLiving) {
                    forceApplyEffects(targetLiving);
                }

                //蓄满力半径6m内所有非友方实体AOE伤害。
                AABB box = player.getBoundingBox().inflate(6.0D);
                float baseDamage = (float) player.getAttributeValue(Attributes.ATTACK_DAMAGE);

                for (LivingEntity le : sl.getEntitiesOfClass(LivingEntity.class, box,
                        e -> e != player && !player.isAlliedTo(e))) {
                    float bonusDamage = le.getMaxHealth() * 0.12F;
                    float totalDamage = baseDamage + bonusDamage;

                    le.hurt(player.damageSources().playerAttack(player), totalDamage);
                    le.knockback(0.5F,
                            player.getX() - le.getX(),
                            player.getZ() - le.getZ());
                    forceApplyEffects(le);
                }
            }
        }
        return super.onLeftClickEntity(stack, player, target);
    }


    private void forceApplyEffects(LivingEntity entity) {
        MobEffectInstance decline = new MobEffectInstance(ModEffects.DECLINE, 240, 2);
        MobEffectInstance magConfine = new MobEffectInstance(ModEffects.MAG_CONFINE, 240, 0);
        MobEffectInstance weakness = new MobEffectInstance(MobEffects.WEAKNESS, 240, 3);
        MobEffectInstance slowness = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 240, 3);

        entity.forceAddEffect(decline, null);
        entity.forceAddEffect(magConfine, null);
        entity.forceAddEffect(weakness, null);
        entity.forceAddEffect(slowness, null);
    }

    @Override
    public boolean isDamageable(@NotNull ItemStack stack) {
        return false;
    }
    @Override
    public void setDamage(@NotNull ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }

    @Override
    public boolean canDisableShield(@NotNull ItemStack stack, @NotNull ItemStack shield,
                                    @NotNull LivingEntity entity, @NotNull LivingEntity attacker) {
        return true;
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, Level level, @NotNull Entity holder,
                              int slot, boolean selected) {
        if (level.isClientSide) return;
        if (!(holder instanceof Player player)) return;

        if (stack.getDamageValue() > 0 && holder.tickCount % 4 == 0) {
            stack.setDamageValue(stack.getDamageValue() - 42);
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (Screen.hasAltDown()){
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_twinned_sword_alt"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_twinned_sword"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
