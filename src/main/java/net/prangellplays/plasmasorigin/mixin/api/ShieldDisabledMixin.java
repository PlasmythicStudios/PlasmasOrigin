package net.prangellplays.plasmasorigin.mixin.api;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.prangellplays.plasmasorigin.PlasmasOrigin;
import net.prangellplays.plasmasorigin.events.PlasmasOriginEvents;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class ShieldDisabledMixin {

    private void shieldDisabledEvent(LivingEntity attacker, CallbackInfo ci) {
        PlasmasOrigin.LOGGER.info("Shield disabled!");
        PlasmasOriginEvents.SHIELD_DISABLED.invoker().shieldDisabled(PlayerEntity.class.cast(this), attacker);
    }
}
