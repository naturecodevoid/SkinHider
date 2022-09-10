package dev.naturecodevoid.skinhider.mixin;

import com.mojang.authlib.GameProfile;
import dev.naturecodevoid.skinhider.SkinHider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
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
            ClientPlayerEntity player = MinecraftClient.getInstance().player;

            if (player.getUuid().compareTo(SkinHider.ReplayModCameraUUID) == 0) {
                cir.setReturnValue(SkinHider.playerSkin);
            } else if (player.getGameProfile().getId().compareTo(profile.getId()) != 0 &&
                    SkinHider.ReplayModCameraUUID.compareTo(profile.getId()) != 0)
                cir.setReturnValue(player.getSkinTexture());
        }
    }

    @Inject(method = "getModel", at = @At("RETURN"), cancellable = true)
    public void changePlayerModel(CallbackInfoReturnable<String> cir) {
        if (SkinHider.config.hideSkins && MinecraftClient.getInstance().player != null) {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;

            if (player.getUuid().compareTo(SkinHider.ReplayModCameraUUID) == 0) {
                cir.setReturnValue(SkinHider.playerModel);
            } else if (player.getGameProfile().getId().compareTo(profile.getId()) != 0 &&
                    SkinHider.ReplayModCameraUUID.compareTo(profile.getId()) != 0)
                cir.setReturnValue(player.getModel());
        }
    }


    @Inject(method = "getCapeTexture", at = @At("RETURN"), cancellable = true)
    public void changePlayerCape(CallbackInfoReturnable<Identifier> cir) {
        if (SkinHider.config.hideCapes && MinecraftClient.getInstance().player != null) {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;

            if (player.getUuid().compareTo(SkinHider.ReplayModCameraUUID) == 0) {
                cir.setReturnValue(SkinHider.playerCape);
            } else if (player.getGameProfile().getId().compareTo(profile.getId()) != 0 &&
                    SkinHider.ReplayModCameraUUID.compareTo(profile.getId()) != 0)
                cir.setReturnValue(player.getCapeTexture());
        }
    }

    @Inject(method = "getElytraTexture", at = @At("RETURN"), cancellable = true)
    public void changePlayerElytra(CallbackInfoReturnable<Identifier> cir) {
        if (SkinHider.config.hideCapes && MinecraftClient.getInstance().player != null) {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;

            if (player.getUuid().compareTo(SkinHider.ReplayModCameraUUID) == 0) {
                cir.setReturnValue(SkinHider.playerCape);
            } else if (player.getGameProfile().getId().compareTo(profile.getId()) != 0 &&
                    SkinHider.ReplayModCameraUUID.compareTo(profile.getId()) != 0)
                cir.setReturnValue(player.getElytraTexture());
        }
    }
}
