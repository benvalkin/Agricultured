package com.uncreatedmc.agricultured;

import com.uncreatedmc.agricultured.items.FoodData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegister
{
    public static Item ChiliPepper;
    public static Item ChiliPepperSeeds;

    public static void RegisterAll(RegistryEvent.Register<Item> itemRegister)
    {
        // ground crops
        ChiliPepper = register("chilipepper", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.TINY_VEGETABLE)));

        // seeds
        ChiliPepperSeeds = register("chilipepper_seeds", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB)));
    }

    private static <T extends Item> T register(String name, T item) {
        ResourceLocation id = new ResourceLocation(Agricultured.MODID, name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }
}
