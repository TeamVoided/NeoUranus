package org.teamvoided.neodonium.mixin;

import com.github.alexmodguy.alexscaves.server.item.HazmatArmorItem;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.teamvoided.neodonium.data.NeodoniumTags;


@Mixin(HazmatArmorItem.class)
public class HazmatArmorItemMixin {

    @ModifyExpressionValue(method = "onArmorTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    boolean spawnParticles(boolean original, ItemStack stack) {
        return stack.getItem() instanceof ArmorItem armor && armor.getType() == ArmorItem.Type.HELMET;
    }

    @Redirect(method = "getWornAmount", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private static boolean tagCheck(ItemStack instance, Item pItem) {
        return instance.is(NeodoniumTags.HAZMAT_PROTECTION);
    }
}
