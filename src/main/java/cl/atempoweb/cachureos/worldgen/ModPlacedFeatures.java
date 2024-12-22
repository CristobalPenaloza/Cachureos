package cl.atempoweb.cachureos.worldgen;

import cl.atempoweb.cachureos.Cachureos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

// ----> REFERENCIAS: OrePlacements

public class ModPlacedFeatures {
    /*public static final ResourceKey<PlacedFeature> QUARTZ_ORE_UPPER = registerKey("quartz_ore_upper");
    public static final ResourceKey<PlacedFeature> QUARTZ_ORE_LOWER = registerKey("quartz_ore_lower");
    public static final ResourceKey<PlacedFeature> ANCIENT_DEBRIS_SMALL = registerKey("ancient_debris_small");
    public static final ResourceKey<PlacedFeature> ANCIENT_DEBRIS_LARGE = registerKey("ancient_debris_large");*/

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        /*register(context, QUARTZ_ORE_UPPER, configuredFeatures.getOrThrow(ModConfiguredFeatures.QUARTZ_ORE),
                commonOrePlacement(40, HeightRangePlacement.uniform(VerticalAnchor.absolute(112), VerticalAnchor.top())));
        register(context, QUARTZ_ORE_LOWER, configuredFeatures.getOrThrow(ModConfiguredFeatures.QUARTZ_ORE_BURIED),
                commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(-35), VerticalAnchor.absolute(163))));

        register(context, ANCIENT_DEBRIS_LARGE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ANCIENT_DEBRIS_LARGE),
                InSquarePlacement.spread(),
                HeightRangePlacement.triangle(VerticalAnchor.absolute(-56), VerticalAnchor.absolute(-40)),
                BiomeFilter.biome());
        register(context, ANCIENT_DEBRIS_SMALL, configuredFeatures.getOrThrow(ModConfiguredFeatures.ANCIENT_DEBRIS_SMALL),
                InSquarePlacement.spread(),
                // Esto para tratar de replicar que el ancient debris puede salir un solo cluster en cualquier parte
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-56), VerticalAnchor.absolute(0)),
                BiomeFilter.biome());*/
    }

    // -------------

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Cachureos.MODID, name));
    }

    private static void register(
            BootstapContext<PlacedFeature> context,
            ResourceKey<PlacedFeature> key,
            Holder<ConfiguredFeature<?, ?>> configuration,
            List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static void register(
            BootstapContext<PlacedFeature> pContext,
            ResourceKey<PlacedFeature> pKey,
            Holder<ConfiguredFeature<?, ?>> pConfiguredFeatures,
            PlacementModifier... pPlacements
    ) {
        register(pContext, pKey, pConfiguredFeatures, List.of(pPlacements));
    }

    // -------------

    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}
