package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.block.JumpPadBlock;
import net.meatwo310.mildb.config.ServerConfig;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = JumpPadBlock.class)
public class JumpPadBlockMixin {
    @ModifyArgs(
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
    private void modifyPlaySoundArgs(Args args) {
        if (!ServerConfig.SAFE_SOUND_EFFECT.get()) {
            return;
        }

        args.set(2, SoundEvents.PISTON_EXTEND);
        args.set(5, 1.1f);
    }

    @ModifyArgs(
            method = "entityInside",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playLocalSound(" +
                            "DDDLnet/minecraft/sounds/SoundEvent;" +
                            "Lnet/minecraft/sounds/SoundSource;" +
                            "FFZ)V"
            )
    )
    private void modifyPlayLocalSoundArgs(Args args) {
        if (!ServerConfig.SAFE_SOUND_EFFECT.get()) {
            return;
        }

        args.set(3, SoundEvents.PISTON_EXTEND);
        args.set(6, 1.1f);
    }
}
