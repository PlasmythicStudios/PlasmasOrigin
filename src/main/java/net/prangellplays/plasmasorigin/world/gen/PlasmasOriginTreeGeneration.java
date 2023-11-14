package net.prangellplays.plasmasorigin.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.prangellplays.plasmasorigin.world.PlasmasOriginPlacedFeatures;

public class PlasmasOriginTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(),
                GenerationStep.Feature.VEGETAL_DECORATION, PlasmasOriginPlacedFeatures.PLASMYTHIC_PLACED_KEY);
    }
}
