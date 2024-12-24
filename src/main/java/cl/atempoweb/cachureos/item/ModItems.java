package cl.atempoweb.cachureos.item;

import cl.atempoweb.cachureos.Cachureos;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cachureos.MODID);

    public static final DeferredItem<Item> NOVICE_BLUEPRINT = ITEMS.register("novice_blueprint", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ADVANCED_BLUEPRINT = ITEMS.register("advanced_blueprint", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> EXPERT_BLUEPRINT = ITEMS.register("expert_blueprint", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WHIRLPOOL_VEIL = ITEMS.register("whirlpool_veil",
            () -> new BaseUpgradeItem(new Item.Properties(), Enchantments.AQUA_AFFINITY));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
