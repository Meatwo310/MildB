package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.block.JumpPadBlock;
import net.meatwo310.mildb.MildB;
import net.meatwo310.mildb.config.ServerConfig;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = JumpPadBlock.class)
public class JumpPadBlockMixin {
    @ModifyArg(
            method = "entityInside",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_SOUND),
            index = 2
    )
    private SoundEvent modifyPlaySoundEvent(SoundEvent original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? SoundEvents.PISTON_EXTEND : original;
    }

    @ModifyArg(
            method = "entityInside",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_SOUND),
            index = 5
    )
    private float modifyPlaySoundPitch(float original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? 1.1f : original;
    }

    @ModifyArg(
            method = "entityInside",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_LOCAL_SOUND),
            index = 3
    )
    private SoundEvent modifyPlayLocalSoundEvent(SoundEvent original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? SoundEvents.PISTON_EXTEND : original;
    }

    @ModifyArg(
            method = "entityInside",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_LOCAL_SOUND),
            index = 6
    )
    private float modifyPlayLocalSoundPitch(float original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? 1.1f : original;
    }
}
