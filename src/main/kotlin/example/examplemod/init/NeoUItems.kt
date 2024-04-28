package example.examplemod.init

import example.examplemod.NeoUranus
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.registerObject


object NeoUItems {

    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, NeoUranus.ID)

    val creativeTabItems = mutableListOf<Item>()

    fun init() = ITEMS.register(MOD_BUS)

    fun regItem(id: String, creativeTab: Boolean = true, supplier: () -> Item): Item {
        val item by ITEMS.registerObject(id, supplier)
        if (creativeTab) creativeTabItems.add(item)
        return item
    }
}