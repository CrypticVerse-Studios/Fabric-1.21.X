package net.crypticverse.tutorial;

import net.crypticverse.tutorial.block.ModBlocks;
import net.crypticverse.tutorial.item.ModItemGroup;
import net.crypticverse.tutorial.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tutorial implements ModInitializer {
	public static final String MOD_ID = "tutorial";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.register();
        ModBlocks.register();
        ModItemGroup.register();
		LOGGER.info("Hello from tutorial mod!");
	}
}