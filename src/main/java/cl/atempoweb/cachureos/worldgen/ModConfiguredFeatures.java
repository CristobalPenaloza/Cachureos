package cl.atempoweb.cachureos.worldgen;

import cl.atempoweb.cachureos.Cachureos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

// ----> REFERENCIAS: OreFeatures

public class ModConfiguredFeatures {
    /*public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ_ORE = registerKey("quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ_ORE_BURIED = registerKey("quartz_ore_buried");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_DEBRIS_SMALL = registerKey("ancient_debris_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_DEBRIS_LARGE = registerKey("ancient_debris_large");*/


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        /*RuleTest baseStoneOverworld = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);
        RuleTest stoneReplacables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> quartzOres = List.of(
                OreConfiguration.target(stoneReplacables, ModBlocks.QUARTZ_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacables, ModBlocks.DEEPSLATE_QUARTZ_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> ancientDebris = List.of(
                OreConfiguration.target(baseStoneOverworld, Blocks.ANCIENT_DEBRIS.defaultBlockState())
        );

        register(context, QUARTZ_ORE, Feature.ORE, new OreConfiguration(quartzOres, 14));
        register(context, QUARTZ_ORE_BURIED, Feature.ORE, new OreConfiguration(quartzOres, 14, 0.5F));
        register(context, ANCIENT_DEBRIS_SMALL, Feature.SCATTERED_ORE, new OreConfiguration(ancientDebris, 2, 1.0F));
        register(context, ANCIENT_DEBRIS_LARGE, Feature.SCATTERED_ORE, new OreConfiguration(ancientDebris, 3, 1.0F));*/
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Cachureos.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
