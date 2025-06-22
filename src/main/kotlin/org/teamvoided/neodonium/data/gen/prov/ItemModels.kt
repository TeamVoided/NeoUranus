package org.teamvoided.neodonium.data.gen.prov

import net.minecraft.world.item.Item
import net.minecraftforge.client.model.generators.ItemModelBuilder
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.data.event.GatherDataEvent
import org.teamvoided.neodonium.Neodonium
import org.teamvoided.neodonium.init.NeoItems

class ItemModels(event: GatherDataEvent, helper: ExistingFileHelper) :
    ItemModelProvider(event.generator.packOutput, Neodonium.ID, helper) {

    val simpleFlat = listOf(
        NeoItems.REINFORCED_HAZMAT_MASK,
        NeoItems.REINFORCED_HAZMAT_CHESTPLATE,
        NeoItems.REINFORCED_HAZMAT_LEGGINGS,
        NeoItems.REINFORCED_HAZMAT_BOOTS,
    )
    val handHeld = listOf(
        NeoItems.SCARLET_NEODYMIUM_KNIFE,
        NeoItems.AZURE_NEODYMIUM_KNIFE,
    )

    override fun registerModels() {
        hammerItem(NeoItems.BASIC_HAMMER.get())
        for (item in simpleFlat) {
            this.basicItem(item.registryObject.id)
        }
        for (item in handHeld) {
            heldItem(item.get())
        }
    }

    fun heldItem(item: Item): ItemModelBuilder = basicItem(item).parent(UncheckedModelFile("item/handheld"))
    fun hammerItem(item: Item): ItemModelBuilder =
        basicItem(item).parent(UncheckedModelFile("neodonium:item/template/hammer"))

}
