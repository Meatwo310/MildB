package io.github.meatwo310.mildb.mixin.entitylimit.minecraft;

import io.github.meatwo310.mildb.config.ServerConfig;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow public abstract double getY();
    @Shadow protected abstract void onBelowWorld();

    @Inject(method = "checkBelowWorld", at = @At("TAIL"))
    private void checkBelowWorldInjected(CallbackInfo ci) {
        if (getY() > ServerConfig.ENTITY_MAX_HEIGHT.get()) {
            onBelowWorld();
        }
    }
}
