package net.prangellplays.plasmasorigin.world.feature.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.prangellplays.plasmasorigin.world.feature.PlasmasOriginConfiguredFeatures;

public class PlasmythicSaplingGenerator extends SaplingGenerator {
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return PlasmasOriginConfiguredFeatures.PLASMYTHIC_KEY;
    }
}
