package io.github.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.entity.projectile.ProjectileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = ProjectileEntity.class, remap = false)
public class ProjectileEntityMixin {
    /**
     * @author Meatwo310
     * @reason Disable beast() method for safety.
     */
    @Overwrite
    public ProjectileEntity beast() {
        return (ProjectileEntity) (Object) this;
    }
}
