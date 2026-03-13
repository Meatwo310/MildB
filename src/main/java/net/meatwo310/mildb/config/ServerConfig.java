package net.meatwo310.mildb.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue SAFE_SOUND_EFFECT = BUILDER
            .comment("If true, the sound effect of the \"beast\" will be replaced with a safer one.")
            .define("safeSoundEffect", true);

    public static final ForgeConfigSpec.BooleanValue SUPPRESS_BEAST_KILL = BUILDER
            .comment("If true, the beast() method that kills the entity instantly will be disabled.")
            .define("suppressBeastKill", true);

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
