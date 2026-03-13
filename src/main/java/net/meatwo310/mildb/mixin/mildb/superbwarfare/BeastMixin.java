package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.item.Beast;
import net.meatwo310.mildb.config.ServerConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = Beast.class, remap = false)
public class BeastMixin {
    @Inject(method = "beastKill", at = @At("HEAD"), cancellable = true)
    private static void beastKill(@Nullable Entity attacker, @NotNull Entity target, CallbackInfo ci) {
        if (!ServerConfig.SUPPRESS_BEAST_KILL.get()) {
            return;
        }

        ci.cancel();
    }

    @Inject(
            method = "appendHoverText",
            at = @At("TAIL"),
            remap = true
    )
    private void appendHoverText(
            ItemStack pStack,
            @Nullable Level pLevel,
            List<Component> pTooltipComponents,
            TooltipFlag pIsAdvanced,
            CallbackInfo ci
    ) {
        if (!ServerConfig.SUPPRESS_BEAST_KILL.get()) {
            return;
        }

        if (!pTooltipComponents.isEmpty()){
            int lastIndex = pTooltipComponents.size() - 1;
            Component lastComponent = pTooltipComponents.get(lastIndex);
            pTooltipComponents.set(lastIndex, lastComponent.copy()
                    .withStyle(Style.EMPTY
                        .withStrikethrough(true)
                        .withColor(ChatFormatting.GRAY)
                    )
            );
        }

        pTooltipComponents.add(Component
                .translatable("des.mildb.beast")
                .withStyle(Style.EMPTY
                        .withItalic(true)
                        .withColor(ChatFormatting.DARK_RED)
                )
        );
    }
}
