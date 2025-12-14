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

public class HellalloyHelmet extends ArmorItem {
    public HellalloyHelmet() {
        super(ModArmorMaterials.HELLALLOY_ARMOR_MATERIAL, Type.HELMET, new Properties()
                .durability(4664).fireResistant().rarity(Rarity.EPIC));
    }
    @Override
    public void inventoryTick(@NotNull ItemStack stack, Level level, @NotNull Entity entity,
                              int slot, boolean selected) {
        //耐久自恢复。
        if (!level.isClientSide
                && entity instanceof LivingEntity living
                && living.tickCount % 40 == 0
                && stack.getDamageValue() > 0) {
            stack.setDamageValue(Math.max(0, stack.getDamageValue() - 4));
        }

        if (level.isClientSide) return;
        if (!(entity instanceof Player player)) return;
        if (player.getItemBySlot(EquipmentSlot.HEAD) != stack) return;

        //单件效果。
        player.addEffect(new MobEffectInstance(
                MobEffects.NIGHT_VISION,310,0,true,false,false
        ));

        if (player.hasEffect(MobEffects.BLINDNESS)) {
            player.removeEffect(MobEffects.BLINDNESS);
        }
        if (player.hasEffect(MobEffects.DARKNESS)) {
            player.removeEffect(MobEffects.DARKNESS);
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (Screen.hasAltDown()){
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_helmet_alt"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_helmet"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
