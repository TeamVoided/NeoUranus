package org.teamvoided.neodonium.data.gen.prov

import com.github.alexmodguy.alexscaves.AlexsCaves.MODID
import net.minecraft.world.item.Item
import net.minecraftforge.client.model.generators.ItemModelBuilder
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.data.event.GatherDataEvent
import org.teamvoided.neodonium.Neodonium.ID
import org.teamvoided.neodonium.init.NeoItems

class ItemModels(event: GatherDataEvent, helper: ExistingFileHelper) :
    ItemModelProvider(event.generator.packOutput, ID, helper) {

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
        tablet(NeoItems.EDIBLE_CAVE_TABLET.get())
        for (item in simpleFlat) {
            this.basicItem(item.registryObject.id)
        }
        for (item in handHeld) {
            heldItem(item.get())
        }
    }


    fun heldItem(item: Item) = parented(item, "item/handheld")
    fun hammerItem(item: Item) = parented(item, "$ID:item/template/hammer")
    fun tablet(item: Item): ItemModelBuilder = getBuilder(item.toString()).parent(UncheckedModelFile( "$MODID:item/cave_tablet"))

    fun parented(item: Item, parent: String): ItemModelBuilder =
        basicItem(item).parent(UncheckedModelFile(parent))
}
