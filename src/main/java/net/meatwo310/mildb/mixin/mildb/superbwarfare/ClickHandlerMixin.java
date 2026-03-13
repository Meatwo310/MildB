package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.client.ClickHandler;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ClickHandler.class)
public class ClickHandlerMixin {
    @Redirect(
            method = "handleDoubleJump",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playLocalSound(" +
                    "DDDLnet/minecraft/sounds/SoundEvent;" +
                    "Lnet/minecraft/sounds/SoundSource;" +
                    "FFZ)V")
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
                x,
                y,
                z,
                SoundEvents.PISTON_EXTEND,
                soundSource,
                volume,
                1.2f,
                distanceDelay
        );
    }
}
