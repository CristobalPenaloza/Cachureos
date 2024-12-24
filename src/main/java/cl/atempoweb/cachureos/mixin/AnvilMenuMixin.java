package cl.atempoweb.cachureos.mixin;

import cl.atempoweb.cachureos.item.BaseUpgradeItem;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Debug(export = true)
@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin extends ItemCombinerMenu {

    public AnvilMenuMixin(@Nullable MenuType<?> pType, int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super(pType, pContainerId, pPlayerInventory, pAccess);
    }

    @WrapOperation(
            method = "createResult()V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;getItem()Lnet/minecraft/world/item/Item;",
            ordinal = 0)
    )
    private Item addUpgradeItemCompatibility(ItemStack instance, Operation<Item> original){
        if(instance.getItem() instanceof BaseUpgradeItem) return Items.ENCHANTED_BOOK;
        else return original.call(instance);
    }

    // TODO: AÑADIR METODOS NECESARIOS A EnchantmentHelper...
    //  La idea es que, en lo que sea que conste a vanilla, usar los upgrades igual a los libros

    /*@ModifyVariable(method = "createResult()V", at = @At("STORE"), ordinal = 0)
    private boolean addUpgradeItemCompatibility(boolean flag, @Local(name = "itemstack2")ItemStack itemstack2){
        return (itemstack2.getItem() instanceof BaseUpgradeItem)
                && !EnchantedBookItem.getEnchantments(itemstack2).isEmpty();
    }*/
}
