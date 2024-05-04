package example.examplemod.data.gen.prov

import example.examplemod.NeoUranus
import example.examplemod.init.NeoUItems
import net.minecraft.world.item.Item
import net.minecraftforge.client.model.generators.ItemModelBuilder
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.data.event.GatherDataEvent

class ItemModels(event: GatherDataEvent, helper: ExistingFileHelper) :
    ItemModelProvider(event.generator.packOutput, NeoUranus.ID, helper) {

    override fun registerModels() {
        hammerItem(NeoUItems.BASIC_HAMMER.get())
//        heldItem(NeoUItems.GALENA_RIFLE.get())
    }

    fun heldItem(item: Item): ItemModelBuilder = basicItem(item).parent(UncheckedModelFile("item/handheld"))
    fun hammerItem(item: Item): ItemModelBuilder =
        basicItem(item).parent(UncheckedModelFile("neouranus:item/template/hammer"))

}
