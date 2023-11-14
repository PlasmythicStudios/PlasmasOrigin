package net.prangellplays.plasmasorigin.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.prangellplays.plasmasorigin.PlasmasOrigin;
import net.prangellplays.plasmasorigin.registry.PlasmasOriginBlocks;

import java.util.List;

public class PlasmasOriginPlacedFeatures {

    public static final RegistryKey<PlacedFeature> PLASMYTHIC_PLACED_KEY = registerKey("plasmythic_placed");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, PLASMYTHIC_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(PlasmasOriginConfiguredFeatures.PLASMYTHIC_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        PlasmasOriginBlocks.PLASMYTHIC_SAPLING));

    }
        public static RegistryKey<PlacedFeature> registerKey(String name) {
            return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(PlasmasOrigin.MOD_ID, name));
        }
        private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                List<PlacementModifier> modifiers) {
            context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
        }
    }