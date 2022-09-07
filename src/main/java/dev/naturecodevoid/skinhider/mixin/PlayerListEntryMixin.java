package dev.naturecodevoid.skinhider.mixin;

import com.mojang.authlib.GameProfile;
import dev.naturecodevoid.skinhider.SkinHider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerListEntry.class)
public class PlayerListEntryMixin {
    @Shadow
    @Final
    private GameProfile profile;

    @Inject(method = "getSkinTexture", at = @At("RETURN"), cancellable = true)
    public void changePlayerSkin(CallbackInfoReturnable<Identifier> cir) {
        if (SkinHider.config.hideSkins && MinecraftClient.getInstance().player != null) {
            PlayerListEntry entry = ((AbstractClientPlayerEntityAccessor) MinecraftClient.getInstance().player).invokeGetPlayerListEntry();
            if (entry != null)
                if (entry.getProfile().getId() != profile.getId())
                    cir.setReturnValue(entry.getSkinTexture());
        }
    }

    @Inject(method = "getModel", at = @At("RETURN"), cancellable = true)
    public void changePlayerModel(CallbackInfoReturnable<String> cir) {
        if (SkinHider.config.hideSkins && MinecraftClient.getInstance().player != null) {
            PlayerListEntry entry = ((AbstractClientPlayerEntityAccessor) MinecraftClient.getInstance().player).invokeGetPlayerListEntry();
            if (entry != null)
                if (entry.getProfile().getId() != profile.getId())
                    cir.setReturnValue(entry.getModel());
        }
    }

    @Inject(method = "getCapeTexture", at = @At("RETURN"), cancellable = true)
    public void changePlayerCape(CallbackInfoReturnable<Identifier> cir) {
        if (SkinHider.config.hideCapes && MinecraftClient.getInstance().player != null) {
            PlayerListEntry entry = ((AbstractClientPlayerEntityAccessor) MinecraftClient.getInstance().player).invokeGetPlayerListEntry();
            if (entry != null)
                if (entry.getProfile().getId() != profile.getId())
                    cir.setReturnValue(entry.getCapeTexture());
        }
    }
}
