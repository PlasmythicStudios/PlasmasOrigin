package net.prangellplays.plasmasorigin;

import net.fabricmc.api.ModInitializer;

import net.prangellplays.plasmasorigin.callbacks.PlasmasOriginCallbacks;
import net.prangellplays.plasmasorigin.registry.PlasmasOriginBlocks;
import net.prangellplays.plasmasorigin.registry.PlasmasOriginItems;
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

	}
}