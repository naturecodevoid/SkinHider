package dev.naturecodevoid.skinhider;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class SkinHider implements ModInitializer {
    public static final String MOD_ID = "skinhider";
    public static SkinHiderConfig config;

    @Override
    public void onInitialize() {
        AutoConfig.register(SkinHiderConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(SkinHiderConfig.class).getConfig();
    }
}
