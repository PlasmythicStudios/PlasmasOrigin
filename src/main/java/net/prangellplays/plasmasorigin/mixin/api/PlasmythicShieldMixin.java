package net.prangellplays.plasmasorigin.mixin.api;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.util.Arm;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.prangellplays.plasmasorigin.registry.PlasmasOriginItems;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.logging.Level;

@Mixin(PlayerEntity.class)
public abstract class PlasmythicShieldMixin extends LivingEntity {

    public abstract ItemCooldownManager getCooldowns();

    protected PlasmythicShieldMixin(EntityType<? extends LivingEntity> entityType, World level) {
        super(entityType, level);
    }

    public abstract void awardStat(Stat<?> stat);

    @Shadow @Final private ItemCooldownManager itemCooldownManager;

    @Shadow public abstract ItemCooldownManager getItemCooldownManager();


    private boolean isUsingItem(Item CPV2) {
        return false;
    }

    @Inject(method = "disableShield", at = @At("HEAD"), cancellable = true)
    private void disablePlasmythicShield(boolean becauseOfAxe, CallbackInfo ci) {
        float efficiency = 0.25f + (float) EnchantmentHelper.getEfficiency(this) * 0.05f;
        if (becauseOfAxe) {
            efficiency += 0.75f;
        }
        if (this.random.nextFloat() < efficiency) {
            this.getItemCooldownManager().set(PlasmasOriginItems.PLASMYTHIC_SHIELD, 100);
            this.stopUsingItem();
        }
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return null;
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return null;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {

    }

    @Override
    public Arm getMainArm() {
        return null;
    }
}