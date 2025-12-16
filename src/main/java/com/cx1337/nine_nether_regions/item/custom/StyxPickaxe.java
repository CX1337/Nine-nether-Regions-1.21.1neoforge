package com.cx1337.nine_nether_regions.item.custom;

import com.cx1337.nine_nether_regions.item.ModToolTiers;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static net.minecraft.world.level.block.Block.popResource;

public class StyxPickaxe extends PickaxeItem implements RangeWeapon{
    public StyxPickaxe() {
        super(ModToolTiers.STYX, new Properties()
                .attributes(createAttributes())
                .rarity(Rarity.EPIC).fireResistant());
    }
    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 12.0D,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.0D,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, 3.0F,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND)
                .add(Attributes.BLOCK_INTERACTION_RANGE,
                        new AttributeModifier(BASE_BLOCK_INTERACTION_RANGE_ID, 3.0F,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND)
                .build();
    }

    //加速破坏速度（貌似无效）。
    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        float originalSpeed = super.getDestroySpeed(stack, state);
        return originalSpeed > 1.0F ? originalSpeed * 2.5F : originalSpeed;
    }

    //挖掘24%掉落钻石，12%掉落下界合金碎片。
    @Override
    public boolean mineBlock(@NotNull ItemStack stack, Level level,
                             @NotNull BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity miner) {
        if (!level.isClientSide && miner instanceof Player player) {
            RandomSource random = level.random;
            if (random.nextFloat() < 0.24F) {
                popResource(level, pos, new ItemStack(Items.DIAMOND));
            }
            if (random.nextFloat() < 0.12F) {
                popResource(level, pos, new ItemStack(Items.NETHERITE_SCRAP));
            }
        }
        return super.mineBlock(stack, level, state, pos, miner);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, Level level, @NotNull Entity holder,
                              int slot, boolean selected) {
        if (level.isClientSide) return;
        if (!(holder instanceof Player player)) return;

        if (stack.getDamageValue() > 0 && holder.tickCount % 4 == 0) {
            stack.setDamageValue(stack.getDamageValue() - 24);
        }
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
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (Screen.hasAltDown()){
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_pickaxe_alt"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.styx_pickaxe"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
