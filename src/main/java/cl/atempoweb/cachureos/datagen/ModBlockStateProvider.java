package cl.atempoweb.cachureos.datagen;

import cl.atempoweb.cachureos.Cachureos;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Cachureos.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //registerBlockWithItem(ModBlocks.QUARTZ_ORE);
        //registerBlockWithItem(ModBlocks.DEEPSLATE_QUARTZ_ORE);
    }

    private void registerBlockWithItem(DeferredBlock<Block> block){
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
