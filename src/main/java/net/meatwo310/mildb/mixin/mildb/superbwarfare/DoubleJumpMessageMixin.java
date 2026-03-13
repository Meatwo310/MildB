package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.network.message.send.DoubleJumpMessage;
import net.meatwo310.mildb.config.ServerConfig;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = DoubleJumpMessage.class, remap = false)
public class DoubleJumpMessageMixin {
    @ModifyArgs(
            method = "lambda$handler$0",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playSound(" +
                            "Lnet/minecraft/world/entity/player/Player;" +
                            "Lnet/minecraft/core/BlockPos;" +
                            "Lnet/minecraft/sounds/SoundEvent;" +
                            "Lnet/minecraft/sounds/SoundSource;" +
                            "FF)V",
                    remap = true
            )
    )
    private static void modifyPlaySoundArgs(Args args) {
        if (!ServerConfig.SAFE_SOUND_EFFECT.get()) {
            return;
        }

        args.set(2, SoundEvents.PISTON_EXTEND);
        args.set(5, 1.2f);
    }
}
