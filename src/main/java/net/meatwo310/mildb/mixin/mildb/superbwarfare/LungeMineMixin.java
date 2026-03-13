package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.item.LungeMine;
import net.meatwo310.mildb.MildB;
import net.meatwo310.mildb.config.ServerConfig;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = LungeMine.class)
public class LungeMineMixin {
    @ModifyArg(
            method = "use",
            at = @At(value = "INVOKE", target = MildB.TARGET_LEVEL_PLAY_SOUND),
            index = 2
    )
    private SoundEvent modifySoundEvent(SoundEvent original) {
        return ServerConfig.SAFE_SOUND_EFFECT.get() ? SoundEvents.TRIDENT_RIPTIDE_1 : original;
    }
}
