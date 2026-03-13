package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.mobeffect.ShockMobEffect;
import net.meatwo310.mildb.config.ServerConfig;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ShockMobEffect.class)
public class ShockMobEffectMixin {
    @ModifyArgs(
            method = "onEffectAdded",
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
    private static void modifyPlaySoundArgs(Args args) {
        if (!ServerConfig.SAFE_SOUND_EFFECT.get()) {
            return;
        }

        args.set(2, SoundEvents.PLAYER_BREATH);
        args.set(5, 1.5f);
    }

    @ModifyArgs(
            method = "onEffectAdded",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playLocalSound(" +
                            "DDD" +
                            "Lnet/minecraft/sounds/SoundEvent;" +
                            "Lnet/minecraft/sounds/SoundSource;" +
                            "FFZ)V"
            )
    )
    private static void modifyPlayLocalSoundArgs(Args args) {
        if (!ServerConfig.SAFE_SOUND_EFFECT.get()) {
            return;
        }

        args.set(3, SoundEvents.PLAYER_BREATH);
        args.set(6, 1.5f);
    }
}
