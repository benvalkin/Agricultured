package com.uncreatedmc.agricultured;

import com.uncreatedmc.agricultured.items.AgriSeedItem;
import com.uncreatedmc.agricultured.items.FoodData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;
import static net.minecraft.world.level.biome.Biome.BiomeCategory.JUNGLE;
import static net.minecraft.world.level.biome.Biome.BiomeCategory.PLAINS;

public class ItemRegister
{
    public static Item ChiliPepper;
    public static Item BellPepper;
    public static Item Tomato;
    public static Item ChiliPepperSeeds;
    public static Item BellPepperSeeds;
    public static Item TomatoSeeds;
    public static Item Cucumber;
    public static Item CucumberSeeds;
    public static Item Radish;
    public static Item RadishSeeds;
    public static Item Onion;
    public static Item OnionSeeds;
    public static Item Eggplant;
    public static Item EggplantSeeds;



    public static void RegisterAll(RegistryEvent.Register<Item> itemRegister)
    {
        // ground crops
        ChiliPepper = register("chilipepper", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.TINY_VEGETABLE)));
        BellPepper = register("bellpepper", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.SMALL_VEGETABLE)));
        Tomato = register("tomato", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.SMALL_VEGETABLE)));
        Cucumber = register("cucumber", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.SMALL_VEGETABLE)));
        Radish =register("radish", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.TINY_VEGETABLE)));
        Onion = register("onion", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.SMALL_VEGETABLE)));
        Eggplant = register("eggplant", new Item((new Item.Properties()).tab(Agricultured.CREATIVE_TAB).food(FoodData.MEDIUM_VEGETABLE)));


        // seeds
        ChiliPepperSeeds = register("chilipepper_seeds", new AgriSeedItem(BlockRegister.ChiliPepper_Crop, JUNGLE));
        BellPepperSeeds = register("bellpepper_seeds", new AgriSeedItem(BlockRegister.BellPepper_Crop, PLAINS));
        TomatoSeeds = register("tomato_seeds", new AgriSeedItem(BlockRegister.Tomato_Crop, PLAINS));
        CucumberSeeds= register("cucumber_seeds", new AgriSeedItem(BlockRegister.Cucumber_Crop, PLAINS));
        RadishSeeds = register("radish_seeds", new AgriSeedItem(BlockRegister.Radish_Crop, PLAINS));
        OnionSeeds = register("onion_seeds", new AgriSeedItem(BlockRegister.Onion_Crop, PLAINS));
        EggplantSeeds = register("eggplant_seeds", new AgriSeedItem(BlockRegister.Eggplant_Crop, PLAINS));



    }

    private static <T extends Item> T register(String name, T item) {
        ResourceLocation id = new ResourceLocation(Agricultured.MODID, name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }
}
