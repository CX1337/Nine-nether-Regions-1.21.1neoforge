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

public class HellalloyBoots extends ArmorItem {
    public HellalloyBoots() {
        super(ModArmorMaterials.HELLALLOY_ARMOR_MATERIAL, Type.BOOTS, new Properties()
                .rarity(Rarity.EPIC).durability(5775).fireResistant());
    }
    @Override
    public void inventoryTick(@NotNull ItemStack stack, Level level, @NotNull Entity entity,
                              int slot, boolean selected) {
        if (!level.isClientSide
                && entity instanceof LivingEntity living
                && living.tickCount % 40 == 0
                && stack.getDamageValue() > 0) {
            stack.setDamageValue(Math.max(0, stack.getDamageValue() - 4));
        }

        if (level.isClientSide) return;
        if (!(entity instanceof Player player)) return;
        if (player.getItemBySlot(EquipmentSlot.FEET) != stack) return;

        player.addEffect(new MobEffectInstance(
                MobEffects.MOVEMENT_SPEED,310,1,true,false,false
        ));

        if (player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
            player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (Screen.hasAltDown()){
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_boots_alt"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_boots"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
