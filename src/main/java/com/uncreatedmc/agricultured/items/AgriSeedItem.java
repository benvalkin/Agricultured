package com.uncreatedmc.agricultured.items;

import com.uncreatedmc.agricultured.Agricultured;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AgriSeedItem extends ItemNameBlockItem {

    private Biome.BiomeCategory category;

    public AgriSeedItem(Block block, Biome.BiomeCategory category) {

        super(block, (new Item.Properties()).tab(Agricultured.CREATIVE_TAB));
        ((AgriCropBlock) block).setSeed(this);
        this.category = category;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos hitPos = context.getClickedPos();
        Level world = context.getLevel();
        BlockState state = world.getBlockState(hitPos);
        if (state.getBlock() instanceof FarmBlock && context.getClickedFace() == Direction.UP) {
            return super.useOn(context);
        }
        return InteractionResult.FAIL;
    }

    public Biome.BiomeCategory getCategory() {
        return category;
    }
}
