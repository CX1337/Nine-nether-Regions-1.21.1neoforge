package com.cx1337.nine_nether_regions.item.custom;

import com.cx1337.nine_nether_regions.item.ModToolTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AmethystDagger extends SwordItem {
    public AmethystDagger() {
        super(ModToolTiers.AMETHYST, new Properties()
                .attributes(SwordItem.createAttributes(ModToolTiers.AMETHYST, 3.0F, -0.6F))
                .rarity(Rarity.COMMON));
    }
    @Override
    public boolean onLeftClickEntity(@NotNull ItemStack stack, Player player, @NotNull Entity entity) {
        if (player.level().random.nextFloat() < 0.24f && player.getHealth() < player.getMaxHealth()) {
            player.heal(1.0f);
        }
        return false;
    }
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, List<Component> tooltipComponents,
                                @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.amethyst_dagger"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
