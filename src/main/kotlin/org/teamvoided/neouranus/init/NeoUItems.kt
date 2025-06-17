package org.teamvoided.neouranus.init

import com.github.alexmodguy.alexscaves.server.item.ACArmorMaterial
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.crafting.Ingredient
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import org.teamvoided.neouranus.NeoUranus
import org.teamvoided.neouranus.item.GalenaRifle
import org.teamvoided.neouranus.item.HammerItem
import org.teamvoided.neouranus.item.ReinforcedHazmatArmorItem
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject


object NeoUItems {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, NeoUranus.ID)

    val REINFORCED_HAZMAT_SUIT_ARMOR_MATERIAL =
        ACArmorMaterial("hazmat_suit", 37, intArrayOf(3, 6, 8, 3), 30, SoundEvents.ARMOR_EQUIP_IRON, 2.25f)


    val creativeTabItems = mutableListOf<ObjectHolderDelegate<Item>>()

    val BASIC_HAMMER = regItem("basic_hammer") { HammerItem() }
    val GALENA_RIFLE = regItem("galena_rifle") { GalenaRifle() }

    val REINFORCED_HAZMAT_MASK = regItem("reinforced_hazmat_mask") { ReinforcedHazmatArmorItem(ArmorItem.Type.HELMET) }
    val REINFORCED_HAZMAT_CHESTPLATE =
        regItem("reinforced_hazmat_chestplate") { ReinforcedHazmatArmorItem(ArmorItem.Type.CHESTPLATE) }
    val REINFORCED_HAZMAT_LEGGINGS =
        regItem("reinforced_hazmat_leggings") { ReinforcedHazmatArmorItem(ArmorItem.Type.LEGGINGS) }
    val REINFORCED_HAZMAT_BOOTS = regItem("reinforced_hazmat_boots") { ReinforcedHazmatArmorItem(ArmorItem.Type.BOOTS) }


    init {
        ITEMS.register(MOD_BUS)
    }

    fun setUp() {
        REINFORCED_HAZMAT_SUIT_ARMOR_MATERIAL.setRepairMaterial(Ingredient.of(ACItemRegistry.POLYMER_PLATE.get()))
    }

    fun regItem(id: String, creativeTab: Boolean = true, supplier: () -> Item): ObjectHolderDelegate<Item> {
        val item = ITEMS.registerObject(id, supplier)
        if (creativeTab) creativeTabItems.add(item)
        return item
    }
}
