package cl.atempoweb.cachureos.worldgen;

import cl.atempoweb.cachureos.Cachureos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

// ----> REFERENCIAS: BiomeModifiers

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_QUARTZ_ORE = registerKey("add_quartz_ore");
    public static final ResourceKey<BiomeModifier> ADD_ANCIENT_DEBRIS = registerKey("add_ancient_debris");

    public static final ResourceKey<BiomeModifier> ADD_EXTRA_MAGMA_CUBE_SPAWNS = registerKey("add_extra_magma_cube_spawns");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        // CF -> PF -> BM
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        /*context.register(ADD_QUARTZ_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(
                        placedFeatures.getOrThrow(ModPlacedFeatures.QUARTZ_ORE_UPPER),
                        placedFeatures.getOrThrow(ModPlacedFeatures.QUARTZ_ORE_LOWER)
                ),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_ANCIENT_DEBRIS, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(
                        placedFeatures.getOrThrow(ModPlacedFeatures.ANCIENT_DEBRIS_LARGE),
                        placedFeatures.getOrThrow(ModPlacedFeatures.ANCIENT_DEBRIS_SMALL)
                ),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));


        // El spawn de slimes se maneja en su mixin, para no quitar los slime chunks
        context.register(ADD_EXTRA_MAGMA_CUBE_SPAWNS, BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(
                biomes.getOrThrow(ModTags.Biomes.ALLOWS_EXTRA_MAGMA_CUBE_SPAWNS),
                new MobSpawnSettings.SpawnerData(
                        EntityType.MAGMA_CUBE,
                        25,
                        1,
                        10
                )
        ));*/
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Cachureos.MODID, name));
    }
}
