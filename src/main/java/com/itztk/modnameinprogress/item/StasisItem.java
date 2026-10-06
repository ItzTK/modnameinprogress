package com.itztk.modnameinprogress.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
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


        BlockPos frontOfPlayer = user.blockPosition().relative(user.getDirection(), 10);

        // Spawn the lightning bolt.
        LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
        lightningBolt.setPos(frontOfPlayer.getCenter());
        world.addFreshEntity(lightningBolt);


        return InteractionResultHolder.success(user.getItemInHand(hand));
    }
}
