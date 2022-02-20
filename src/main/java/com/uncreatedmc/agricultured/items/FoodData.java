package com.uncreatedmc.agricultured.items;
import net.minecraft.world.food.FoodProperties;

public class FoodData
{
    public static final FoodProperties TINY_VEGETABLE = new FoodProperties.Builder().nutrition(1).saturationMod(0.4F).build();
    public static final FoodProperties SMALL_VEGETABLE = new FoodProperties.Builder().nutrition(2).saturationMod(0.4F).build();
    public static final FoodProperties MEDIUM_VEGETABLE = new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).build();
}
