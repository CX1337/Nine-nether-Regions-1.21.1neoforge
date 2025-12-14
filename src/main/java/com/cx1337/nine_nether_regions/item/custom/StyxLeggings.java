package com.cx1337.nine_nether_regions.item.custom;

import com.cx1337.nine_nether_regions.item.ModArmorMaterials;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StyxLeggings extends ArmorItem {
    public StyxLeggings() {
        super(ModArmorMaterials.STYX_ARMOR_MATERIAL, Type.LEGGINGS, new Properties()
                .rarity(Rarity.EPIC).durability(68886).fireResistant());
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
    public boolean hurtEnemy(@NotNull ItemStack stack,
                             @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        return true;
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, Level level, @NotNull Entity entity,
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
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (Screen.hasAltDown()){
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_leggings_alt"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_leggings"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
