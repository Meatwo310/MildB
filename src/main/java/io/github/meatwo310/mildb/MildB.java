package io.github.meatwo310.mildb;

import io.github.meatwo310.mildb.config.ServerConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(MildB.MODID)
public class MildB {
    public static final String MODID = "mildb";
    public MildB() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);
    }
}
