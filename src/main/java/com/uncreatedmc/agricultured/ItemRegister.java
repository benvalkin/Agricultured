package com.uncreatedmc.agricultured;

import com.uncreatedmc.agricultured.items.FoodData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegister
{
    public static Item ChiliPepper;
    public static Item GreenPepper;
    public static Item StrawBerry;
    public static Item Lettuce;
    public static Item ChiliPepperSeeds;
    public static Item GreenPepperSeeds;
    public static Item StrawBerrySeeds;
    public static Item LettuceSeeds;

    public static void RegisterAll(RegistryEvent.Register<Item> itemRegister)
    {
        // ground crops
        ChiliPepper = register("chilipepper", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.TINY_VEGETABLE)));
        GreenPepper = register("greenpepper", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.TINY_VEGETABLE)));
        StrawBerry = register("strawberry", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.TINY_VEGETABLE)));
        Lettuce =register("lettuce", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.TINY_VEGETABLE)));

        // seeds
        ChiliPepperSeeds = register("chilipepper_seeds", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB)));
        GreenPepperSeeds = register("greenpepper_seeds", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB)));
        StrawBerrySeeds = register("strawberry_seeds", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB)));
        LettuceSeeds = register("lettuce_seeds", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB)));

        //tree fruit

        //saplings


    }

    private static <T extends Item> T register(String name, T item) {
        ResourceLocation id = new ResourceLocation(Agricultured.MODID, name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }
}
