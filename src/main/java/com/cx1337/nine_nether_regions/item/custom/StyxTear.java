package com.cx1337.nine_nether_regions.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StyxTear extends Item {
    public StyxTear() {
        super(new Properties().rarity(Rarity.EPIC).fireResistant());
    }
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_tear"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return true;
    }
}
