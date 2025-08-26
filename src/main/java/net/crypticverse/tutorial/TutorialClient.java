package net.crypticverse.tutorial;

import net.fabricmc.api.ClientModInitializer;

public class TutorialClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Tutorial.LOGGER.warn("Client loaded!");
    }
}
