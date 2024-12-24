package cl.atempoweb.cachureos.item;

import cl.atempoweb.cachureos.Cachureos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cachureos.MODID);

    public static final Supplier<CreativeModeTab> CACHUREOS_TAB = CREATIVE_MODE_TAB.register("slicecraft_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.DIAMOND))
                    .title(Component.translatable("creativetab.cachureos.cachureos"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.NOVICE_BLUEPRINT);
                        output.accept(ModItems.ADVANCED_BLUEPRINT);
                        output.accept(ModItems.EXPERT_BLUEPRINT);

                        output.accept(BaseUpgradeItem.createWithMaxLevel(ModItems.WHIRLPOOL_VEIL));
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
