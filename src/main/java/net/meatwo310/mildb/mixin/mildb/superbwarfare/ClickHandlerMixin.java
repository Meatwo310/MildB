package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.client.ClickHandler;
import net.meatwo310.mildb.config.ServerConfig;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = ClickHandler.class)
public class ClickHandlerMixin {
    @ModifyArgs(
            method = "handleDoubleJump",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playLocalSound(" +
                            "DDDLnet/minecraft/sounds/SoundEvent;" +
                            "Lnet/minecraft/sounds/SoundSource;" +
                            "FFZ)V"
            )
    )
    private static void modifyPlayLocalSoundArgs(Args args) {
        if (!ServerConfig.SAFE_SOUND_EFFECT.get()) {
            return;
        }

        args.set(3, SoundEvents.PISTON_EXTEND);
        args.set(6, 1.2f);
    }
}
