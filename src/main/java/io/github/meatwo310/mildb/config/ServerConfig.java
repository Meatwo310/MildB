package io.github.meatwo310.mildb.config;

import io.github.meatwo310.mildb.MildB;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MildB.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ServerConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.IntValue ENTITY_MAX_HEIGHT = BUILDER
            .comment("Maximum height of entities in the world. Entities exceeding this height will be killed.")
            .defineInRange("entityMaxHeight", 210, Integer.MIN_VALUE, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.IntValue PROJECTILE_MAX_TICKS = BUILDER
            .comment("Maximum ticks a projectile can exist in the world. Projectiles exceeding this limit will be removed.")
            .defineInRange("projectileMaxTicks", 5*20, 0, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.BooleanValue NO_SHOCK_DAMAGE = BUILDER
            .comment("Whether to disable damage from SBW's Shock effect.")
            .define("noShockDamage", true);

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
