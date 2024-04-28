package example.examplemod.data.gen.prov

import example.examplemod.NeoUranus
import net.minecraft.core.HolderLookup
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraftforge.data.event.GatherDataEvent

class ItemTags(event: GatherDataEvent, blockTags: BlockTags) : ItemTagsProvider(
    event.generator.packOutput, event.lookupProvider, blockTags.contentsGetter(), NeoUranus.ID, event.existingFileHelper
) {
    override fun addTags(provider: HolderLookup.Provider) {
//        this.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS)
        this.registerModTags()
        this.registerForgeTags()
        this.registerCompatibilityTags()
    }

    private fun registerModTags() {
//        tag(ModTags.STRAW_HARVESTERS).addTag(ModTags.KNIVES)
    }

    private fun registerForgeTags() {
//        tag(ForgeTags.BERRIES).add(Items.SWEET_BERRIES, Items.GLOW_BERRIES)
    }

    fun registerCompatibilityTags() {
//        tag(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
//            .add(ModItems.MILK_BOTTLE.get())
    }
}
