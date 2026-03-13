package net.meatwo310.mildb.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue SAFE_SOUND_EFFECT = BUILDER
            .comment("If true, the sound effect of the \"beast\" will be replaced with a safer one.")
            .define("safeSoundEffect", true);

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
