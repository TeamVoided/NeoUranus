package example.examplemod.data.gen.prov

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.github.alexmodguy.alexscaves.server.misc.ACTagRegistry
import com.simibubi.create.AllItems
import example.examplemod.NeoUranus
import example.examplemod.data.NeoUTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraftforge.data.event.GatherDataEvent
import vectorwing.farmersdelight.common.registry.ModBlocks
import vectorwing.farmersdelight.common.registry.ModItems

class ItemTags(event: GatherDataEvent, blockTags: BlockTags) : ItemTagsProvider(
    event.generator.packOutput, event.lookupProvider, blockTags.contentsGetter(), NeoUranus.ID, event.existingFileHelper
) {
    override fun addTags(provider: HolderLookup.Provider) {
        copy(NeoUTags.METAL_SCRAP_BLOCKS, NeoUTags.METAL_SCRAP_ITEMS)
        copy(NeoUTags.CREATE_MAGNETIC_BLOCKS, NeoUTags.CREATE_MAGNETIC_ITEMS)
        this.registerModTags()
        this.registerForgeTags()
        this.registerCompatibilityTags()
    }

    private fun registerModTags() {
        tag(NeoUTags.CREATE_MAGNETIC_ITEMS)
            .add(
                AllItems.NETHERITE_DIVING_BOOTS.get(),
                AllItems.NETHERITE_DIVING_HELMET.get(),

                AllItems.PROPELLER.get(),
                AllItems.WHISK.get(),
                AllItems.MINECART_COUPLING.get(),
                AllItems.MINECART_CONTRAPTION.get(),
                AllItems.CHEST_MINECART_CONTRAPTION.get(),
                AllItems.FURNACE_MINECART_CONTRAPTION.get()
            )
    }

    private fun registerForgeTags() {
//        tag(ForgeTags.BERRIES).add(Items.SWEET_BERRIES, Items.GLOW_BERRIES)
    }

    fun registerCompatibilityTags() {
        tag(ACTagRegistry.MAGNETIC_ITEMS)
            .addTags(
                NeoUTags.METAL_SCRAP_ITEMS,
                NeoUTags.CREATE_MAGNETIC_ITEMS
            )
            .add(
                ACBlockRegistry.RUSTY_BARREL.get().asItem(),
                ACBlockRegistry.RUSTY_SCAFFOLDING.get().asItem(),
                ACBlockRegistry.METAL_REBAR.get().asItem(),
                ACBlockRegistry.RUSTY_REBAR.get().asItem(),
            )
            .add(
                ModBlocks.SKILLET.get().asItem(),
                ModBlocks.COOKING_POT.get().asItem(),
                ModItems.IRON_KNIFE.get(),
                ModItems.NETHERITE_KNIFE.get()
            )
        //        tag(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
//            .add(ModItems.MILK_BOTTLE.get())
    }
}
