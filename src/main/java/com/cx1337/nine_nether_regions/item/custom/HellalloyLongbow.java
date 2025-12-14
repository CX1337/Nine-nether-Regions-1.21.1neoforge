package com.cx1337.nine_nether_regions.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HellalloyLongbow extends BowItem {
    public HellalloyLongbow() {
        super(new Properties().rarity(Rarity.RARE).durability(6446).fireResistant());
    }
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_longbow"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    protected void shootProjectile(@NotNull LivingEntity shooter, @NotNull Projectile projectile,
                                   int index, float velocity, float inaccuracy, float angle,
                                   @Nullable LivingEntity target) {
        //箭矢初速度3倍
        float modifiedVelocity = velocity * 3.0F;
        super.shootProjectile(shooter, projectile, index, modifiedVelocity, inaccuracy, angle, target);
        if (projectile instanceof AbstractArrow arrow) {
            arrow.setBaseDamage(4.0F);
        }
    }
    @Override
    public int getDefaultProjectileRange() {
        return 64;
    }
    @Override
    public int getEnchantmentValue() {
        return 24;
    }
}
