package com.cx1337.nine_nether_regions.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MiniFractal extends SwordItem implements RangeWeapon{
    public MiniFractal() {
        super(Tiers.NETHERITE, new Properties()
                .attributes(createAttributes())
                .rarity(Rarity.UNCOMMON));
    }
    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 4.0D,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, -1.6D,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, -0.5F,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.BLOCK_INTERACTION_RANGE,
                        new AttributeModifier(BASE_BLOCK_INTERACTION_RANGE_ID, -0.5F,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    @Override
    public boolean onLeftClickEntity(@NotNull ItemStack stack, @NotNull Player player, @NotNull Entity entity) {
        if (!player.level().isClientSide && entity instanceof LivingEntity livingEntity) {
            double maxHealth = livingEntity.getMaxHealth();
            float extraDamage = (float) (maxHealth * 0.011);
            float baseDamage = (float) player.getAttributeValue(Attributes.ATTACK_DAMAGE);
            if (extraDamage > 0.0F) {
                DamageSource damageSource = player.level().damageSources().playerAttack(player);
                livingEntity.hurt(damageSource, extraDamage + baseDamage);
            }
        }
        return false;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.mini_fractal"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
