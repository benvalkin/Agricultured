package com.uncreatedmc.agricultured;

import com.uncreatedmc.agricultured.items.FoodData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegister
{
    public static Item ChiliPepper;
    public static Item BellPepper;
    public static Item Tomato;
    public static Item ChiliPepperSeeds;
    public static Item BellPepperSeeds;
    public static Item TomatoSeeds;
    public static Item Lettuce;

    public static void RegisterAll(RegistryEvent.Register<Item> itemRegister)
    {
        // ground crops
        ChiliPepper = register("chilipepper", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.TINY_VEGETABLE)));
        BellPepper = register("bellpepper", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.SMALL_VEGETABLE)));
        Tomato = register("tomato", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.SMALL_VEGETABLE)));
        Lettuce =register("lettuce", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.TINY_VEGETABLE)));

        // seeds
        ChiliPepperSeeds = register("chilipepper_seeds", new AgriSeedItem(BlockRegister.ChiliPepper_Crop, JUNGLE));
        BellPepperSeeds = register("bellpepper_seeds", new AgriSeedItem(BlockRegister.BellPepper_Crop, PLAINS));
        TomatoSeeds = register("tomato_seeds", new AgriSeedItem(BlockRegister.Tomato_Crop, PLAINS));
    }

    private static <T extends Item> T register(String name, T item) {
        ResourceLocation id = new ResourceLocation(Agricultured.MODID, name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }
}
