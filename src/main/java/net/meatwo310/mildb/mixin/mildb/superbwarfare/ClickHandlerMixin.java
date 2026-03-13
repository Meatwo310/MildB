package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.client.ClickHandler;
import net.meatwo310.mildb.MildB;
import net.meatwo310.mildb.config.ServerConfig;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = ClickHandler.class)
public class ClickHandlerMixin {
    @ModifyArg(
            method = "handleDoubleJump",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_LOCAL_SOUND),
            index = 3
    )
    private static SoundEvent modifyPlayLocalSoundEvent(SoundEvent original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? SoundEvents.PISTON_EXTEND : original;
    }

    @ModifyArg(
            method = "handleDoubleJump",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_LOCAL_SOUND),
            index = 6
    )
    private static float modifyPlayLocalSoundPitch(float original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? 1.2f : original;
    }
}
