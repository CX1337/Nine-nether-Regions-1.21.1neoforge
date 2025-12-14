package com.cx1337.nine_nether_regions.item.custom;

import com.cx1337.nine_nether_regions.effect.ModEffects;
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

public class StyxHelmet extends ArmorItem {
    public StyxHelmet() {
        super(ModArmorMaterials.STYX_ARMOR_MATERIAL, Type.HELMET, new Properties()
                .rarity(Rarity.EPIC).durability(46664).fireResistant());
    }
    //无法破坏。
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
        //耐久自恢复(如果遇到意外情况)。
        if (!level.isClientSide
                && entity instanceof LivingEntity living
                && living.tickCount % 4 == 0
                && stack.getDamageValue() > 0) {
            stack.setDamageValue(Math.max(0, stack.getDamageValue() - 42));
        }

        if (level.isClientSide) return;
        if (!(entity instanceof Player player)) return;

        if (player.getItemBySlot(EquipmentSlot.HEAD) != stack) return;

        //效果。
        player.addEffect(new MobEffectInstance(
                MobEffects.NIGHT_VISION,310,1,true,false,false
        ));
        player.addEffect(new MobEffectInstance(
                MobEffects.WATER_BREATHING,310,1,true,false,false
        ));
        player.addEffect(new MobEffectInstance(
                MobEffects.SATURATION,310,1,true,false,false
        ));

        if (player.hasEffect(MobEffects.BLINDNESS)) {
            player.removeEffect(MobEffects.BLINDNESS);
        }
        if (player.hasEffect(MobEffects.DARKNESS)) {
            player.removeEffect(MobEffects.DARKNESS);
        }
        if (player.hasEffect(MobEffects.HUNGER)) {
            player.removeEffect(MobEffects.HUNGER);
        }
        if (player.hasEffect(ModEffects.BLOODBLADE_CURSE)) {
            player.removeEffect(ModEffects.BLOODBLADE_CURSE);
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (Screen.hasAltDown()){
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_helmet_alt"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_helmet"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
