package example.examplemod.data.gen.prov

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.github.alexmodguy.alexscaves.server.misc.ACTagRegistry
import example.examplemod.NeoUranus
import example.examplemod.data.NeoUTags
import example.examplemod.init.NeoUBlocks
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import net.minecraftforge.common.data.BlockTagsProvider
import net.minecraftforge.data.event.GatherDataEvent
import vectorwing.farmersdelight.common.registry.ModBlocks


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
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(NeoUBlocks.CUT_BRASS.get())
            .addTags(
                NeoUTags.METAL_SCRAP_BLOCKS,
                NeoUTags.COPPER_TILES
            )
        tag(BlockTags.NEEDS_STONE_TOOL)
//            .add()
            .addTags(
                NeoUTags.METAL_SCRAP_BLOCKS,
                NeoUTags.COPPER_TILES
            )

        tag(BlockTags.NEEDS_IRON_TOOL).add(
            NeoUBlocks.CUT_BRASS.get()
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
        tag(NeoUTags.METAL_SCRAP_BLOCKS)
            .add(
                ACBlockRegistry.SCRAP_METAL.get(),
                ACBlockRegistry.RUSTY_SCRAP_METAL.get(),
                ACBlockRegistry.SCRAP_METAL_PLATE.get(),
                ACBlockRegistry.RUSTY_SCRAP_METAL_PLATE.get(),
            )
            .add(
                NeoUBlocks.CUT_SCRAP_METAL_ONE.get(),
                NeoUBlocks.CUT_SCRAP_METAL_TWO.get(),
                NeoUBlocks.CUT_SCRAP_METAL_THREE.get(),
                NeoUBlocks.CUT_SCRAP_METAL_FOUR.get(),
                NeoUBlocks.CUT_SCRAP_METAL_FIVE.get(),
                NeoUBlocks.CUT_SCRAP_METAL_SIX.get(),
                NeoUBlocks.CUT_SCRAP_METAL_SEVEN.get(),
                NeoUBlocks.CUT_RUSTY_SCRAP_METAL_ONE.get(),
                NeoUBlocks.CUT_RUSTY_SCRAP_METAL_TWO.get(),
                NeoUBlocks.CUT_RUSTY_SCRAP_METAL_THREE.get(),
                NeoUBlocks.CUT_RUSTY_SCRAP_METAL_FOUR.get(),
                NeoUBlocks.CUT_RUSTY_SCRAP_METAL_FIVE.get(),
                NeoUBlocks.CUT_RUSTY_SCRAP_METAL_SIX.get(),
                NeoUBlocks.CUT_RUSTY_SCRAP_METAL_SEVEN.get(),
            )
        tag(NeoUTags.COPPER_TILES)
            .add(
                NeoUBlocks.COPPER_TILES.get(),
                NeoUBlocks.WAXED_COPPER_TILES.get(),
                NeoUBlocks.EXPOSED_COPPER_TILES.get(),
                NeoUBlocks.WAXED_EXPOSED_COPPER_TILES.get(),
                NeoUBlocks.WEATHERED_COPPER_TILES.get(),
                NeoUBlocks.WAXED_WEATHERED_COPPER_TILES.get(),
                NeoUBlocks.OXIDIZED_COPPER_TILES.get(),
                NeoUBlocks.WAXED_OXIDIZED_COPPER_TILES.get(),
            )
    }

    fun registerCompatibilityTags() {
        tag(ACTagRegistry.MAGNETIC_BLOCKS)
            .addTags(NeoUTags.METAL_SCRAP_BLOCKS)
            .add(
                ACBlockRegistry.RUSTY_BARREL.get(),
                ACBlockRegistry.RUSTY_SCAFFOLDING.get(),
            )
            .add(
                ModBlocks.SKILLET.get(),
                ModBlocks.COOKING_POT.get()
            )
//        tag(CompatibilityTags.CREATE_PASSIVE_BOILER_HEATERS).add(ModBlocks.STOVE.get())
    }
}
