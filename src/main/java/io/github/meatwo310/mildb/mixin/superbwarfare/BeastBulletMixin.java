package io.github.meatwo310.mildb.mixin.superbwarfare;

import com.atsuishio.superbwarfare.entity.projectile.ProjectileEntity;
import com.atsuishio.superbwarfare.perk.ammo.BeastBullet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = BeastBullet.class, remap = false)
public class BeastBulletMixin {
    @Redirect(
            method = "modifyProjectile",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/atsuishio/superbwarfare/entity/projectile/ProjectileEntity;beast()" +
                            "Lcom/atsuishio/superbwarfare/entity/projectile/ProjectileEntity;"
            )
    )
    private ProjectileEntity beast(ProjectileEntity projectile) {
        return projectile;
    }
}
