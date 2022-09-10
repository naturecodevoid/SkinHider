package dev.naturecodevoid.skinhider.mixin;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import dev.naturecodevoid.skinhider.SkinHider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Inject(method = "init", at = @At("TAIL"))
    public void onInit(CallbackInfo ci) {
        MinecraftClient.getInstance().getSkinProvider().loadSkin(
                MinecraftClient.getInstance().getSession().getProfile(),
                (type, identifier, texture) -> {
                    if (type == MinecraftProfileTexture.Type.SKIN) {
                        SkinHider.playerSkin = identifier;
                        SkinHider.playerModel = texture.getMetadata("model");
                        if (SkinHider.playerModel == null) {
                            SkinHider.playerModel = "default";
                        }
                    } else if (type == MinecraftProfileTexture.Type.CAPE) {
                        SkinHider.playerCape = identifier;
                    }
                },
                true
        );
    }
}
