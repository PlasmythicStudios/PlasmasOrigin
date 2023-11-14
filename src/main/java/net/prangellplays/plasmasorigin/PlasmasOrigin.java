package net.prangellplays.plasmasorigin;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.prangellplays.plasmasorigin.callbacks.PlasmasOriginCallbacks;
import net.prangellplays.plasmasorigin.registry.PlasmasOriginBlocks;
import net.prangellplays.plasmasorigin.registry.PlasmasOriginItems;
import net.prangellplays.plasmasorigin.util.PlasmasOriginRegistries;
import net.prangellplays.plasmasorigin.world.gen.PlasmasOriginWorldGeneration;
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
		PlasmasOriginWorldGeneration.generateModWorldGen();
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}