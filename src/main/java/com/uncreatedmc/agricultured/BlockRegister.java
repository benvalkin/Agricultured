package com.uncreatedmc.agricultured;

import com.uncreatedmc.agricultured.Agricultured;
import com.uncreatedmc.agricultured.ItemRegister;
import com.uncreatedmc.agricultured.items.AgriCropBlock;
import com.uncreatedmc.agricultured.items.AgriSeedItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

public class BlockRegister
{
    public static Block ChiliPepper_Crop;
    public static Block BellPepper_Crop;
    public static Block Tomato_Crop;

    public static ArrayList<Block> LeafyCrops = new ArrayList<>();

    public static void RegisterAll(RegistryEvent.Register<Block> itemRegister)
    {
        ChiliPepper_Crop = register("chilipepper_crop", new AgriCropBlock(getCropProperties()));
        BellPepper_Crop = register("bellpepper_crop", new AgriCropBlock(getCropProperties()));
        Tomato_Crop = register("tomato_crop", new AgriCropBlock(getCropProperties()));

        LeafyCrops.add(ChiliPepper_Crop);
        LeafyCrops.add(BellPepper_Crop);
        LeafyCrops.add(Tomato_Crop);
    }

    private static BlockBehaviour.Properties getCropProperties() {
        return BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP);
    }

    private static <T extends Block> T register(String name, T block) {
        ResourceLocation id = new ResourceLocation(Agricultured.MODID, name);
        block.setRegistryName(id);
        ForgeRegistries.BLOCKS.register(block);
        return block;
    }
}
