package io.github.meatwo310.mildb.mixin.superbwarfare;

import com.atsuishio.superbwarfare.init.ModVillagers;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ModVillagers.class, remap = false)
public class ModVillagersMixin {
    @Inject(method = "addCustomTrades", at = @At("HEAD"), cancellable = true)
    private static void addCustomTrades(VillagerTradesEvent event, CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "addWandererTrade", at = @At("HEAD"), cancellable = true)
    private static void addWandererTrade(WandererTradesEvent event, CallbackInfo ci) {
        ci.cancel();
    }
}
