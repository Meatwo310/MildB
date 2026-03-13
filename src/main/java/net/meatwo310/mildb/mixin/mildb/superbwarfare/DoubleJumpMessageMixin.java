package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.network.message.send.DoubleJumpMessage;
import net.meatwo310.mildb.MildB;
import net.meatwo310.mildb.config.ServerConfig;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = DoubleJumpMessage.class, remap = false)
public class DoubleJumpMessageMixin {
    @ModifyArg(
            method = "lambda$handler$0",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_SOUND, remap = true),
            index = 2
    )
    private static SoundEvent modifyPlaySoundEvent(SoundEvent original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? SoundEvents.PISTON_EXTEND : original;
    }

    @ModifyArg(
            method = "lambda$handler$0",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_SOUND, remap = true),
            index = 5
    )
    private static float modifyPlaySoundPitch(float original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? 1.2f : original;
    }
}
