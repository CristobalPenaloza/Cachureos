package cl.atempoweb.cachureos.mixin;

import cl.atempoweb.cachureos.item.BaseUpgradeItem;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Debug(export = true)
@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {

    @WrapOperation(
            method = "getEnchantments",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z")
    )
    private static boolean getEnchantments(ItemStack instance, Item pItem, Operation<Boolean> original){
        if(instance.getItem() instanceof BaseUpgradeItem) return true;
        else return original.call(instance, pItem);
    }

    // TODO: AÑADIR LOS OTROS MÉTODOS QUE LLAMAN A LOS ENCHANTED BOOKS...
}
