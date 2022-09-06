package dev.naturecodevoid.skinhider.mixin;

import dev.naturecodevoid.skinhider.SkinHider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerListEntry.class)
public class PlayerListEntryMixin {
    @Inject(method = "getSkinTexture", at = @At("RETURN"), cancellable = true)
    public void changePlayerSkin(CallbackInfoReturnable<Identifier> cir) {
        if (SkinHider.config.enabled && MinecraftClient.getInstance().player != null)
            cir.setReturnValue(DefaultSkinHelper.getTexture(MinecraftClient.getInstance().player.getUuid()));
    }

    @Inject(method = "getModel", at = @At("RETURN"), cancellable = true)
    public void changePlayerModel(CallbackInfoReturnable<String> cir) {
        if (SkinHider.config.enabled && MinecraftClient.getInstance().player != null)
            cir.setReturnValue(DefaultSkinHelper.getModel(MinecraftClient.getInstance().player.getUuid()));
    }
}
