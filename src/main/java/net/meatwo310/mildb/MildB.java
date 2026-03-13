package net.meatwo310.mildb;

import net.meatwo310.mildb.config.ServerConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MildB.MODID)
public class MildB {
    public static final String MODID = "mildb";

    /** Mixin target: {@code Level#playSound(Player, BlockPos, SoundEvent, SoundSource, float, float)} */
    public static final String TARGET_LEVEL_PLAY_SOUND =
            "Lnet/minecraft/world/level/Level;playSound(" +
            "Lnet/minecraft/world/entity/player/Player;" +
            "Lnet/minecraft/core/BlockPos;" +
            "Lnet/minecraft/sounds/SoundEvent;" +
            "Lnet/minecraft/sounds/SoundSource;" +
            "FF)V";

    /** Mixin target: {@code Level#playLocalSound(double, double, double, SoundEvent, SoundSource, float, float, boolean)} */
    public static final String TARGET_LEVEL_PLAY_LOCAL_SOUND =
            "Lnet/minecraft/world/level/Level;playLocalSound(" +
            "DDDLnet/minecraft/sounds/SoundEvent;" +
            "Lnet/minecraft/sounds/SoundSource;" +
            "FFZ)V";

    public MildB(FMLJavaModLoadingContext ctx) {
        ctx.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);
    }
}
