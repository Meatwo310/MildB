package io.github.meatwo310.mildb.mixin.superbwarfare;

import com.atsuishio.superbwarfare.mobeffect.ShockMobEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShockMobEffect.class)
public class ShockMobEffectMixin {
    @Redirect(
            method = "onEffectAdded",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playSound(" +
                            "Lnet/minecraft/world/entity/player/Player;" +
                            "Lnet/minecraft/core/BlockPos;" +
                            "Lnet/minecraft/sounds/SoundEvent;" +
                            "Lnet/minecraft/sounds/SoundSource;" +
                            "FF" +
                            ")V"
            )
    )
    private static void playSound(
            Level level,
            Player player,
            BlockPos pos,
            SoundEvent soundEvent,
            SoundSource soundSource,
            float volume,
            float pitch
    ) {
        level.playSound(
                player,
                pos,
                SoundEvents.PLAYER_BREATH,
                soundSource,
                volume,
                1.5f
        );
    }

    @Redirect(
            method = "onEffectAdded",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playLocalSound(" +
                            "DDD" +
                            "Lnet/minecraft/sounds/SoundEvent;" +
                            "Lnet/minecraft/sounds/SoundSource;" +
                            "FFZ" +
                            ")V"
            )
    )
    private static void playLocalSound(
            Level level,
            double x,
            double y,
            double z,
            SoundEvent soundEvent,
            SoundSource soundSource,
            float volume,
            float pitch,
            boolean distanceDelay
    ) {
        level.playLocalSound(
                x, y, z,
                SoundEvents.PLAYER_BREATH,
                soundSource,
                volume,
                1.5f,
                distanceDelay
        );
    }
}
