package net.crypticverse.tutorial.item;

import net.crypticverse.tutorial.Tutorial;
import net.crypticverse.tutorial.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

public class ModItemGroup {
    public static final CreativeModeTab MY_ITEM_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(Tutorial.MOD_ID, "tutorial"),
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).icon(() -> new ItemStack(ModBlocks.MAPLE_PLANKS))
                    .title(Component.translatable("itemgroup.tutorial"))
                    .displayItems((displayParams, entries) -> {
                        for (Field field : ModBlocks.class.getFields()) {
                            try {
                                Block block = (Block) field.get(null);

                                if (block == null) {
                                    throw new IllegalStateException(String.format("Field %s cannot be null", field.getName()));
                                }

                                entries.accept(new ItemStack(block));
                            } catch (IllegalAccessException ignore) {}
                        }
                        for (Field field : ModItems.class.getFields()) {
                            if (field.getType() != Item.class) continue;
                            try {
                                Item item = (Item) field.get(null);

                                if (item == null) {
                                    throw new IllegalStateException(String.format("Field %s cannot be null", field.getName()));
                                }

                                entries.accept(new ItemStack(item));
                            } catch (IllegalAccessException ignore) {}
                        }
                    }).build());

    public static void register() {
        Tutorial.LOGGER.info("Tab registered!");
    }
}
