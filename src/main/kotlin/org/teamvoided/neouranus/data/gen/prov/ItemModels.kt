package org.teamvoided.neouranus.data.gen.prov

import net.minecraft.world.item.Item
import net.minecraftforge.client.model.generators.ItemModelBuilder
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.data.event.GatherDataEvent
import org.teamvoided.neouranus.NeoUranus
import org.teamvoided.neouranus.init.NeoUItems

class ItemModels(event: GatherDataEvent, helper: ExistingFileHelper) :
    ItemModelProvider(event.generator.packOutput, NeoUranus.ID, helper) {

    val simpleFlat = listOf(
        NeoUItems.REINFORCED_HAZMAT_MASK,
        NeoUItems.REINFORCED_HAZMAT_CHESTPLATE,
        NeoUItems.REINFORCED_HAZMAT_LEGGINGS,
        NeoUItems.REINFORCED_HAZMAT_BOOTS,
    )

    override fun registerModels() {
        hammerItem(NeoUItems.BASIC_HAMMER.get())
        for (item in simpleFlat) {
            this.basicItem(item.registryObject.id)
        }
    }

    fun heldItem(item: Item): ItemModelBuilder = basicItem(item).parent(UncheckedModelFile("item/handheld"))
    fun hammerItem(item: Item): ItemModelBuilder =
        basicItem(item).parent(UncheckedModelFile("neouranus:item/template/hammer"))

}
