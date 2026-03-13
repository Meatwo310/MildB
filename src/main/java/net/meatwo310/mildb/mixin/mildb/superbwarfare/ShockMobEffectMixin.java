package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.mobeffect.ShockMobEffect;
import net.meatwo310.mildb.MildB;
import net.meatwo310.mildb.config.ServerConfig;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ShockMobEffect.class)
public class ShockMobEffectMixin {
    @ModifyArg(
            method = "onEffectAdded",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_SOUND),
            index = 2
    )
    private static SoundEvent modifyPlaySoundEvent(SoundEvent original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? SoundEvents.PLAYER_BREATH : original;
    }

    @ModifyArg(
            method = "onEffectAdded",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_SOUND),
            index = 5
    )
    private static float modifyPlaySoundPitch(float original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? 1.5f : original;
    }

    @ModifyArg(
            method = "onEffectAdded",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_LOCAL_SOUND),
            index = 3
    )
    private static SoundEvent modifyPlayLocalSoundEvent(SoundEvent original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? SoundEvents.PLAYER_BREATH : original;
    }

    @ModifyArg(
            method = "onEffectAdded",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_LOCAL_SOUND),
            index = 6
    )
    private static float modifyPlayLocalSoundPitch(float original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? 1.5f : original;
    }
}
