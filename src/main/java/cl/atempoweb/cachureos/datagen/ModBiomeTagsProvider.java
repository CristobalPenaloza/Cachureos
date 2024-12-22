package cl.atempoweb.cachureos.datagen;

import cl.atempoweb.cachureos.Cachureos;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagsProvider extends BiomeTagsProvider {
    public ModBiomeTagsProvider(PackOutput p_255800_, CompletableFuture<HolderLookup.Provider> p_256205_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255800_, p_256205_, Cachureos.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        /*this.tag(ModTags.Biomes.ALLOWS_EXTRA_SLIME_SPAWNS).add(
                Biomes.MEADOW,
                Biomes.CHERRY_GROVE,

                Biomes.FOREST,
                Biomes.FLOWER_FOREST,
                Biomes.TAIGA,
                Biomes.OLD_GROWTH_PINE_TAIGA,
                Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.BIRCH_FOREST,
                Biomes.OLD_GROWTH_BIRCH_FOREST,
                Biomes.DARK_FOREST,

                Biomes.SPARSE_JUNGLE,
                Biomes.STONY_SHORE,
                Biomes.PLAINS,
                Biomes.SUNFLOWER_PLAINS,

                Biomes.SAVANNA,
                Biomes.SAVANNA_PLATEAU
        );
        this.tag(ModTags.Biomes.ALLOWS_EXTRA_MAGMA_CUBE_SPAWNS).add(
                Biomes.BADLANDS,
                Biomes.WOODED_BADLANDS,
                Biomes.ERODED_BADLANDS
        );*/
    }
}
