package com.cx1337.nine_nether_regions.item.custom;

import com.cx1337.nine_nether_regions.item.ModFoodProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EnchantedGhostliumApple extends Item {
    public EnchantedGhostliumApple() {
        super(new Properties().food(ModFoodProperties.ENCHANTED_GHOSTLIUM_APPLE).rarity(Rarity.EPIC));
    }
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.enchanted_ghostlium_apple"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return true;
    }
}
