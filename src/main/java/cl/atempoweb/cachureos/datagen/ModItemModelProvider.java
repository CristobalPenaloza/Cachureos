package cl.atempoweb.cachureos.datagen;

import cl.atempoweb.cachureos.Cachureos;
import cl.atempoweb.cachureos.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Cachureos.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.NOVICE_BLUEPRINT);
        simpleItem(ModItems.ADVANCED_BLUEPRINT);
        simpleItem(ModItems.EXPERT_BLUEPRINT);

        simpleItem(ModItems.WHIRLPOOL_VEIL);
    }

    private ItemModelBuilder simpleItem(DeferredItem<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Cachureos.MODID, "item/" + item.getId().getPath()));
    }
}
