package com.cx1337.nine_nether_regions.mixin;

import com.cx1337.nine_nether_regions.util.ModArmorUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Inject(method = "setRemainingFireTicks", at = @At("HEAD"), cancellable = true)
    private void onSetRemainingFireTicks(int ticks, CallbackInfo ci){
        Entity self = (Entity)(Object)this;
        if (self instanceof Player player && ModArmorUtils.hasFullStyxArmor(player)){
            ci.cancel();
        }
    }
}
