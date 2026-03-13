package net.meatwo310.mildb;

import net.meatwo310.mildb.config.ServerConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MildB.MODID)
public class MildB {
    public static final String MODID = "mildb";

    public MildB(FMLJavaModLoadingContext ctx) {
        ctx.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);
    }
}
