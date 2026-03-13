package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.entity.projectile.ProjectileEntity;
import net.meatwo310.mildb.config.ServerConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ProjectileEntity.class, remap = false)
public class ProjectileEntityMixin {
    @Inject(method = "beast", at = @At("HEAD"), cancellable = true)
    public void beast(CallbackInfoReturnable<ProjectileEntity> cir) {
        if (!ServerConfig.SUPPRESS_BEAST_KILL.get()) {
            return;
        }

        cir.setReturnValue((ProjectileEntity) (Object) this);
    }
}
