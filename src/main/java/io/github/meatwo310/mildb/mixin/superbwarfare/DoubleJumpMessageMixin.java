package io.github.meatwo310.mildb.mixin.superbwarfare;

import com.atsuishio.superbwarfare.network.message.send.DoubleJumpMessage;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = DoubleJumpMessage.class, remap = false)
public class DoubleJumpMessageMixin {
    @Redirect(
            method = "lambda$handler$0",
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
                SoundEvents.PISTON_EXTEND,
                soundSource,
                volume,
                1.2f
        );
    }
}
