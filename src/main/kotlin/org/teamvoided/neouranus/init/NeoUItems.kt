package org.teamvoided.neouranus.init

import org.teamvoided.neouranus.NeoUranus
import org.teamvoided.neouranus.item.GalenaRifle
import org.teamvoided.neouranus.item.HammerItem
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject


object NeoUItems {

    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, NeoUranus.ID)

    val creativeTabItems = mutableListOf<ObjectHolderDelegate<Item>>()

    val BASIC_HAMMER = regItem("basic_hammer") { HammerItem() }
    val GALENA_RIFLE = regItem("galena_rifle") { GalenaRifle() }

    init {
        ITEMS.register(MOD_BUS)
    }

    fun regItem(id: String, creativeTab: Boolean = true, supplier: () -> Item): ObjectHolderDelegate<Item> {
        val item = ITEMS.registerObject(id, supplier)
        if (creativeTab) creativeTabItems.add(item)
        return item
    }
}
