package com.cx1337.nine_nether_regions.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.DragonFireball;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class VoidStaff extends Item {
    public VoidStaff() {
        super(new Properties().durability(404).rarity(Rarity.EPIC).fireResistant());
    }
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level,
                                                           Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        player.startUsingItem(hand);

        if (!level.isClientSide) {
            Vec3 lookVec = player.getLookAngle();
            DragonFireball dragonFireball = new DragonFireball(level, player,
                    lookVec.scale(1.5));
            dragonFireball.setPos(player.getX(), player.getEyeY(), player.getZ());
            dragonFireball.setOwner(player);
            level.addFreshEntity(dragonFireball);
            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ENDER_DRAGON_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);

            EquipmentSlot slot = hand == InteractionHand.MAIN_HAND ?
                    EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            itemStack.hurtAndBreak(1, player, slot);

            player.getCooldowns().addCooldown(this, 160);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BLOCK;
    }
    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return 8;
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack stack, ItemStack repairCandidate) {
        return repairCandidate.is(Items.DRAGON_BREATH);
    }

    @Override
    public int getEnchantmentValue(@NotNull ItemStack stack) {
        return 0;
    }
    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.void_staff"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
