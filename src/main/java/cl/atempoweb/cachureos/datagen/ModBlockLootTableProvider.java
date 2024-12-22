package cl.atempoweb.cachureos.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //this.add(ModBlocks.QUARTZ_ORE.get(), block -> createOreDrop(ModBlocks.QUARTZ_ORE.get(), Items.QUARTZ));
        //this.add(ModBlocks.DEEPSLATE_QUARTZ_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_QUARTZ_ORE.get(), Items.QUARTZ));
    }

    /*@Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(
            blockDeferredHolder -> (Block)blockDeferredHolder.get()
        )::iterator;
    }*/
}
