package cl.atempoweb.cachureos.datagen;

import cl.atempoweb.cachureos.Cachureos;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Cachureos.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        /*this.tag(BlockTags.NEEDS_STONE_TOOL).add(
            ModBlocks.QUARTZ_ORE.get(),
            ModBlocks.DEEPSLATE_QUARTZ_ORE.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
            ModBlocks.QUARTZ_ORE.get(),
            ModBlocks.DEEPSLATE_QUARTZ_ORE.get()
        );*/
    }
}
