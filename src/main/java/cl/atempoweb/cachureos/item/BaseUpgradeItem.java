package cl.atempoweb.cachureos.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TODO:
//  Cada upgrade debería nacer de este, pues este da la oportunidad de tener encantamientos registrados...
//  ¿Pero cómo lo hacemos para las distintas variedades y potencias de cada encantamientos?
//  Para eso es necesario que exista una INSTANCIA de cada encantamiento...
//  Entonces, necesitamos una lista de POSIBLES encantamientos, y también una lista con los encantamientos reales.
//  Eso nos permite tener un creador de instancias que permita generar cada posible variante...
//  Usamos eso para añadirlas al CreativeTab y para los Loot Tables

// TODO:
//  El item es la única instancia existente por cada item
//  Ej. WhirpoolVeil es un Item
//  Después está el stack, que es el contiene el upgrade real
//  Este es el que tiene el NBT, no el Item


public class BaseUpgradeItem extends Item {
    private final Set<Enchantment> compatibleEnchantments;

    public BaseUpgradeItem(Properties pProperties, Enchantment compatibleEnchantment){
        super(pProperties);
        Set<Enchantment> compatibleEnchantments = new HashSet<>();
        compatibleEnchantments.add(compatibleEnchantment);
        this.compatibleEnchantments = compatibleEnchantments;
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }

    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }


    // USAMOS EL MISMO SISTEMA QUE USA ENCHANTEDBOOKITEM PARA GUARDAR SUS ENCANTAMIENTOS
    // A final de cuentas, nosotros queremos hacer eso mismo...

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        //pTooltip.add(Component.literal("Descripción... WOOOO!!!"));
        ItemStack.appendEnchantmentNames(pTooltip, EnchantedBookItem.getEnchantments(pStack));
    }

    public static BaseUpgradeItem from(ItemLike itemLike){
        Item item = itemLike.asItem();
        return item instanceof BaseUpgradeItem ? (BaseUpgradeItem) item : null;
    }

    public static ItemStack createWithMaxLevel(ItemLike itemLike) {
        BaseUpgradeItem upgradeItem = from(itemLike);
        if(upgradeItem == null) return ItemStack.EMPTY;

        ItemStack stack = new ItemStack(upgradeItem);
        for(Enchantment enchantment : upgradeItem.compatibleEnchantments){
            EnchantedBookItem.addEnchantment(stack, new EnchantmentInstance(enchantment, enchantment.getMaxLevel()));
        }
        return stack;
    }
}
