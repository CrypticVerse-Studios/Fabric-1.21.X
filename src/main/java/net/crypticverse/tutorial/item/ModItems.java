package net.crypticverse.tutorial.item;

import net.crypticverse.tutorial.Tutorial;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item LIMESTONE = registerItem("limestone", Item::new);

    private static Item registerItem(String name, Function<Item.Properties, Item> properties) {
        ResourceKey<Item> resourceKey = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Tutorial.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Tutorial.MOD_ID, name),
                properties.apply(new Item.Properties().setId(resourceKey)));
    }

    public static void register() {
        Tutorial.LOGGER.info("Items registered!");
    }
}
