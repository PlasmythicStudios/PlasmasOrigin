package net.prangellplays.plasmasorigin;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.world.World;
import net.prangellplays.plasmasorigin.registry.PlasmasOriginItems;

public class PlasmasOriginClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
    }

    public int getColorOr(ItemStack stack, int base) {
        NbtCompound nbtCompound = stack.getSubNbt(DyeableItem.DISPLAY_KEY);
        if (nbtCompound != null && nbtCompound.contains(DyeableItem.COLOR_KEY, NbtElement.NUMBER_TYPE)) {
            return nbtCompound.getInt(DyeableItem.COLOR_KEY);
        }
        return base;
    }


    private static float blockingPredicate(ItemStack stack, World level, LivingEntity user, int i) {
        return user != null && user.getActiveItem() == stack ? 1.0f : 0.0f;
    }}