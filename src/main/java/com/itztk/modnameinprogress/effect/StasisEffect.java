package com.itztk.modnameinprogress.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class StasisEffect extends MobEffect {
    protected StasisEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xef9bf23);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier){
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player) {
            ((Player) entity).giveExperiencePoints(1 << amplifier);
        }
        return super.applyEffectTick(entity, amplifier);
    }
}
