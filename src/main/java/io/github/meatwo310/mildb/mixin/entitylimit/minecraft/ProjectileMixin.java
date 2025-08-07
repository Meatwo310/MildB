package io.github.meatwo310.mildb.mixin.entitylimit.minecraft;

import io.github.meatwo310.mildb.config.ServerConfig;
import net.minecraft.world.entity.projectile.Projectile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Projectile.class)
public class ProjectileMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    private void tickInjected(CallbackInfo ci) {
        Projectile projectile = (Projectile) (Object) this;
        if (projectile.tickCount > ServerConfig.PROJECTILE_MAX_TICKS.get()) {
            projectile.discard();
        }
    }
}
