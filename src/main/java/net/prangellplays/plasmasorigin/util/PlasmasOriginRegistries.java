package net.prangellplays.plasmasorigin.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.prangellplays.plasmasorigin.registry.PlasmasOriginBlocks;

public class PlasmasOriginRegistries {
    public static void registerModStuffs() {
        registerStrippableBlocks();
    }

    private static void registerStrippableBlocks() {
        StrippableBlockRegistry.register(PlasmasOriginBlocks.PLASMYTHIC_LOG, PlasmasOriginBlocks.STRIPPED_PLASMYTHIC_LOG);
        StrippableBlockRegistry.register(PlasmasOriginBlocks.PLASMYTHIC_WOOD, PlasmasOriginBlocks.STRIPPED_PLASMYTHIC_WOOD);
    }
}
