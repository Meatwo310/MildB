package io.github.meatwo310.mildb;

import com.mojang.logging.LogUtils;
import io.github.meatwo310.mildb.config.ServerConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

import java.util.Objects;

@Mod(Mildb.MODID)
public class Mildb {
    public static final String MODID = "mildb";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Mildb() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);
    }
}
