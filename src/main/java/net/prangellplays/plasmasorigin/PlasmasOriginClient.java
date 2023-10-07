package net.prangellplays.plasmasorigin;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.prangellplays.plasmasorigin.registry.PlasmasOriginBlocks;

public class PlasmasOriginClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(PlasmasOriginBlocks.PLASMYTHIC_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PlasmasOriginBlocks.PLASMYTHIC_SAPLING, RenderLayer.getCutout());
    }

    private static float blockingPredicate(ItemStack stack, World level, LivingEntity user, int i) {
        return user != null && user.getActiveItem() == stack ? 1.0f : 0.0f;
    }
}