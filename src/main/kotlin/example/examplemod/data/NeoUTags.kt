package example.examplemod.data

import example.examplemod.NeoUranus.id
import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey

object NeoUTags {
    val COPPER_TILES = createBlockTag("copper_tiles")
    val METAL_SCRAP_BLOCKS = createBlockTag("metal_scrap")

    val METAL_SCRAP_ITEMS = createItemTag("metal_scrap")

    private fun createItemTag(name: String) = TagKey.create(Registries.ITEM, id(name))
    private fun createBlockTag(name: String) = TagKey.create(Registries.BLOCK, id(name))

}
