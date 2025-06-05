package io.github.meatwo310.mildb.mixin.superbwarfare;

import com.atsuishio.superbwarfare.block.JumpPadBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = JumpPadBlock.class, remap = false)
public class JumpPadBlockMixin {
    @Redirect(
            method = "entityInside",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playSound(" +
                            "Lnet/minecraft/world/entity/player/Player;" +
                            "Lnet/minecraft/core/BlockPos;" +
                            "Lnet/minecraft/sounds/SoundEvent;" +
                            "Lnet/minecraft/sounds/SoundSource;" +
                            "FF)V"
            )
    )
    private void playSound(
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
                SoundEvents.PISTON_EXTEND,
                soundSource,
                volume,
                1.1f
        );
    }

    @Redirect(
            method = "entityInside",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playLocalSound(" +
                            "DDDLnet/minecraft/sounds/SoundEvent;" +
                            "Lnet/minecraft/sounds/SoundSource;" +
                            "FFZ)V"
            )
    )
    private void playLocalSound(
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
                SoundEvents.PISTON_EXTEND,
                soundSource,
                volume,
                1.1f,
                distanceDelay
        );
    }
}
