package dev.naturecodevoid.skinhider;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.util.Identifier;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class SkinHider implements ModInitializer {
    public static final String MOD_ID = "skinhider";
    // https://github.com/ReplayMod/ReplayMod/blob/develop/src/main/java/com/replaymod/replay/camera/CameraEntity.java#L108
    public static final UUID ReplayModCameraUUID = UUID.nameUUIDFromBytes("ReplayModCamera".getBytes(StandardCharsets.UTF_8));
    public static SkinHiderConfig config;
    public static Identifier playerSkin = DefaultSkinHelper.getTexture();
    public static Identifier playerCape = null;
    public static String playerModel = "default";

    @Override
    public void onInitialize() {
        AutoConfig.register(SkinHiderConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(SkinHiderConfig.class).getConfig();
    }
}
