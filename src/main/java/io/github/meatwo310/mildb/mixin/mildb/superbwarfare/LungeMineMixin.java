package io.github.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.item.LungeMine;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = LungeMine.class)
public class LungeMineMixin {
    @Redirect(
            method = "use",
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
    private void playSound(
            Level level,
            Player player,
            BlockPos pos,
            SoundEvent soundEvent,
            SoundSource soundSource,
            float volume,
            float pitch
    ) {
        level.playSound(
                player,
                pos,
                SoundEvents.TRIDENT_RIPTIDE_1,
                soundSource,
                volume,
                pitch
        );
    }
}
