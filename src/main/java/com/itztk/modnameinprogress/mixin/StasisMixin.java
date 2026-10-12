package com.itztk.modnameinprogress.mixin;


import com.itztk.modnameinprogress.effect.ModEffects;
import net.minecraft.world.TickRateManager;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TickRateManager.class)
public class StasisMixin {
    public StasisMixin(){
    }

    @Shadow
    private boolean runsNormally() {
        return false;
    }

    @Inject(
            method = {"isEntityFrozen"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void modifyisEntityFrozen(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof Player player) {
            if (!player.isCreative() && !player.isSpectator()  && player.hasEffect(ModEffects.STASIS)) {
                boolean shouldSkip = player.countPlayerPassengers() <= 0;
                cir.setReturnValue(shouldSkip);
            }
        }
    }


}
