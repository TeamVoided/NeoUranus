package org.teamvoided.neouranus.data.gen.prov

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.github.alexmodguy.alexscaves.server.misc.ACTagRegistry
import org.teamvoided.neouranus.NeoUranus
import org.teamvoided.neouranus.data.NeoUTags
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
        this.registerModTags()
        this.registerForgeTags()
        this.registerCompatibilityTags()
    }

    private fun registerModTags() {
    }

    private fun registerForgeTags() {
//        tag(ForgeTags.BERRIES).add(Items.SWEET_BERRIES, Items.GLOW_BERRIES)
    }

    fun registerCompatibilityTags() {
        tag(ACTagRegistry.MAGNETIC_ITEMS)
            .addTags(NeoUTags.METAL_SCRAP_ITEMS)
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
    }
}
