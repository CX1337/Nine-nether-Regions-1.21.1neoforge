package com.cx1337.nine_nether_regions.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EnderStaff extends Item {
    public EnderStaff() {
        super(new Properties().durability(202).rarity(Rarity.RARE).fireResistant());
    }
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level,
                                                           Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        player.startUsingItem(hand);

        if (!level.isClientSide) {
            final double maxDistance = 64.0;
            Vec3 start = player.getEyePosition();
            Vec3 look = player.getLookAngle();
            Vec3 end = start.add(look.x*maxDistance, look.y*maxDistance, look.z*maxDistance);
            HitResult hitResult = level.clip(new ClipContext(
                    start, end, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player
            ));
            Vec3 targetPos;
            if (hitResult.getType() != HitResult.Type.MISS) {
                targetPos = hitResult.getLocation().subtract(look.x*0.2, look.y*0.2, look.z*0.2);
            } else {
                targetPos = end;
            }

            BlockPos targetBlockPos = new BlockPos((int) targetPos.x, (int) targetPos.y, (int) targetPos.z);
            Level world = player.level();
            if (world.isEmptyBlock(targetBlockPos)) {
                for (int i = 1; i <= 5; i++) {
                    BlockPos below = targetBlockPos.below(i);
                    if (!world.isEmptyBlock(below)) {
                        targetBlockPos = below.above();
                        targetPos = new Vec3(targetPos.x, targetBlockPos.getY() + 0.5, targetPos.z);
                        break;
                    }
                }
            } else {
                for (int i = 1; i <= 5; i++) {
                    BlockPos above = targetBlockPos.above(i);
                    if (!world.isEmptyBlock(above)) {
                        targetBlockPos = above;
                        targetPos = new Vec3(targetPos.x, targetBlockPos.getY() + 0.5, targetPos.z);
                        break;
                    }
                }
            }

            player.teleportTo(targetPos.x, targetPos.y, targetPos.z);
            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.PLAYER_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
            player.addEffect(
                    new MobEffectInstance(MobEffects.ABSORPTION, 80, 0));

            EquipmentSlot slot = hand == InteractionHand.MAIN_HAND ?
                    EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            itemStack.hurtAndBreak(1, player, slot);
            player.getCooldowns().addCooldown(this, 30);
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
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return true;
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack stack, ItemStack repairCandidate) {
        return repairCandidate.is(Items.ENDER_PEARL);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
                                List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.nine_nether_regions.ender_staff"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
