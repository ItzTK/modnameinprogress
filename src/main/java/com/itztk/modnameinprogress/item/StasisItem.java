package com.itztk.modnameinprogress.item;

import com.itztk.modnameinprogress.ModNameInprogress;
import com.itztk.modnameinprogress.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StasisItem extends Item {
    public StasisItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        if (world.isClientSide) {
            return InteractionResultHolder.pass(user.getItemInHand(hand));
        }

        var instance = new MobEffectInstance(ModEffects.STASIS, 5 * 20,0, false, true, true);
        user.addEffect(instance);


        return InteractionResultHolder.success(user.getItemInHand(hand));
    }
}
