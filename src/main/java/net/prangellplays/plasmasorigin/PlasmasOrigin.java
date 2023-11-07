package net.prangellplays.plasmasorigin;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.prangellplays.plasmasorigin.block.PlasmythicSaplingBlock;
import net.prangellplays.plasmasorigin.callbacks.PlasmasOriginCallbacks;
import net.prangellplays.plasmasorigin.mixin.PlasmasOriginMixin;
import net.prangellplays.plasmasorigin.registry.PlasmasOriginBlocks;
import net.prangellplays.plasmasorigin.registry.PlasmasOriginItems;
import net.prangellplays.plasmasorigin.util.PlasmasOriginRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlasmasOrigin implements ModInitializer {
	public static final String MOD_ID = "plasmasorigin";
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {

		PlasmasOriginItems.registerPlasmasOriginItems();
		PlasmasOriginBlocks.registerPlasmasOriginBlocks();
		PlasmasOriginCallbacks.init();
		PlasmasOriginRegistries.registerModStuffs();
	}


	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}