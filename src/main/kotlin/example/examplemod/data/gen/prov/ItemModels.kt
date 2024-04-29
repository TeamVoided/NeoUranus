package example.examplemod.data.gen.prov

import example.examplemod.NeoUranus
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.data.event.GatherDataEvent

class ItemModels(event: GatherDataEvent, helper: ExistingFileHelper) :
    ItemModelProvider(event.generator.packOutput, NeoUranus.ID, helper) {

    override fun registerModels() {}
}
