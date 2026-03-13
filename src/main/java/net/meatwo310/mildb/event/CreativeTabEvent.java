package net.meatwo310.mildb.event;

import com.atsuishio.superbwarfare.init.ModItems;
import net.meatwo310.mildb.MildB;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

@Mod.EventBusSubscriber(modid = MildB.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabEvent {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        var entries = event.getEntries();
        Set.of(
                ModItems.BEAST,
                ModItems.SENPAI_SPAWN_EGG
        ).forEach(regi ->
                entries.remove(regi.get().getDefaultInstance())
        );

        ResourceLocation bulletID = ResourceLocation.fromNamespaceAndPath(com.atsuishio.superbwarfare.Mod.MODID, "beast_bullet");
        Item beastBullet = ForgeRegistries.ITEMS.getValue(bulletID);
        if (beastBullet != null) {
            entries.remove(beastBullet.getDefaultInstance());
        }
    }
}
