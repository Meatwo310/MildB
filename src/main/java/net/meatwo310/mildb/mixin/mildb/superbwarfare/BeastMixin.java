package net.meatwo310.mildb.mixin.mildb.superbwarfare;

import com.atsuishio.superbwarfare.item.Beast;
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
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = Beast.class, remap = false)
public class BeastMixin {
    /**
     * @author Meatwo310
     * @reason No beastKill because it's too OP
     */
    @Overwrite
    public static void beastKill(@Nullable Entity attacker, @NotNull Entity target) {
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
