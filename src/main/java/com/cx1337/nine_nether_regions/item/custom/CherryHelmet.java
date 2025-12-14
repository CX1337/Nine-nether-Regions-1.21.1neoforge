package com.cx1337.nine_nether_regions.item.custom;

import com.cx1337.nine_nether_regions.item.ModArmorMaterials;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;

public class CherryHelmet extends ArmorItem {
    public CherryHelmet() {
        super(ModArmorMaterials.CHERRY_ARMOR_MATERIAL, Type.HELMET, new Properties()
                .durability(66).rarity(Rarity.COMMON));
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
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target,
                             @NotNull LivingEntity attacker) {
        return true;
    }
}
