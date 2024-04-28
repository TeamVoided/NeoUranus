package example.examplemod.data.gen.prov

import example.examplemod.NeoUranus
import example.examplemod.init.NeoUBlocks
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import net.minecraftforge.common.data.BlockTagsProvider
import net.minecraftforge.data.event.GatherDataEvent


class BlockTags(event: GatherDataEvent) :
    BlockTagsProvider(event.generator.packOutput, event.lookupProvider, NeoUranus.ID, event.existingFileHelper) {

    override fun addTags(provider: HolderLookup.Provider) {
        this.registerModTags()
        this.registerMinecraftTags()
        this.registerForgeTags()
        this.registerCompatibilityTags()
        this.registerBlockMineables()
    }

    fun registerBlockMineables() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
            NeoUBlocks.COPPER_TILES,
            NeoUBlocks.WAXED_COPPER_TILES,
            NeoUBlocks.EXPOSED_COPPER_TILES,
            NeoUBlocks.WAXED_EXPOSED_COPPER_TILES,
            NeoUBlocks.WEATHERED_COPPER_TILES,
            NeoUBlocks.WAXED_WEATHERED_COPPER_TILES,
            NeoUBlocks.OXIDIZED_COPPER_TILES,
            NeoUBlocks.WAXED_OXIDIZED_COPPER_TILES
        )
    }

    fun registerMinecraftTags() {
//        tag(BlockTags.CLIMBABLE).add(ModBlocks.ROPE.get(), ModBlocks.TOMATO_CROP.get())
    }

    fun registerForgeTags() {
//        tag(BlockTags.DIRT).add(ModBlocks.RICH_SOIL.get())
//        this.tag(ForgeTags.MINEABLE_WITH_KNIFE)
    }

    fun registerModTags() {
//        tag(ModTags.TERRAIN).addTag(BlockTags.DIRT).addTag(BlockTags.SAND)
    }

    fun registerCompatibilityTags() {
//        tag(CompatibilityTags.CREATE_PASSIVE_BOILER_HEATERS).add(ModBlocks.STOVE.get())
    }
}
