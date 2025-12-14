package com.cx1337.nine_nether_regions.item.custom;

import com.cx1337.nine_nether_regions.item.ModToolTiers;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HellalloySword extends SwordItem {
    public HellalloySword() {
        super(ModToolTiers.HELLALLOY, new Properties()
                .attributes(SwordItem.createAttributes(ModToolTiers.HELLALLOY, 4.0F, -2.0F))
                .rarity(Rarity.EPIC).fireResistant());
    }
    @Override
    //蓄满力固定值范围伤害。
    public boolean onLeftClickEntity(@NotNull ItemStack stack, Player player, @NotNull Entity target) {
        if (player.getAttackStrengthScale(0.5F) >= 1.0F) {
            if (player.level() instanceof ServerLevel sl) {
                AABB box = target.getBoundingBox().inflate(2.0D);
                for (LivingEntity le : sl.getEntitiesOfClass(LivingEntity.class, box,
                        e -> e != target && e != player && !player.isAlliedTo(e))) {
                    le.hurt(player.damageSources().playerAttack(player), 16.0F);
                    le.knockback(0.2F,
                            player.getX() - le.getX(),
                            player.getZ() - le.getZ());
                }
            }
        }
        return super.onLeftClickEntity(stack, player, target);
    }
    @Override
    public void inventoryTick(@NotNull ItemStack stack, Level level, @NotNull Entity holder,
                              int slot, boolean selected) {
        if (level.isClientSide) return;
        if (!(holder instanceof Player player)) return;

        if (stack.getDamageValue() > 0 && holder.tickCount % 50 == 0) {
            stack.setDamageValue(stack.getDamageValue() - 1);
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (Screen.hasAltDown()){
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_sword_alt"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.hellalloy_sword"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
