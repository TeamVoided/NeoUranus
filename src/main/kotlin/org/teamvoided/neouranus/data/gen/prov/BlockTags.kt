package org.teamvoided.neouranus.data.gen.prov

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.github.alexmodguy.alexscaves.server.misc.ACTagRegistry
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Blocks
import net.minecraftforge.common.data.BlockTagsProvider
import net.minecraftforge.data.event.GatherDataEvent
import org.teamvoided.neouranus.NeoUranus
import org.teamvoided.neouranus.data.NeoUTags
import org.teamvoided.neouranus.init.NeoUBlocks
import vectorwing.farmersdelight.common.registry.ModBlocks as FDBlocks


class BlockTags(event: GatherDataEvent) :
    BlockTagsProvider(event.generator.packOutput, event.lookupProvider, NeoUranus.ID, event.existingFileHelper) {

    override fun addTags(provider: HolderLookup.Provider) {
        this.registerModTags()
        this.registerMinecraftTags()
        this.registerForgeTags()
        this.magnetism()
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
//        tag(BlockTags.CLIMBABLE).add(FDBlocks.ROPE.get(), FDBlocks.TOMATO_CROP.get())
    }

    fun registerForgeTags() {
//        tag(BlockTags.DIRT).add(FDBlocks.RICH_SOIL.get())
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
                NeoUBlocks.CUT_SCRAP_METAL.get(),
                NeoUBlocks.SCRAP_METAL_BRICKS.get(),
                NeoUBlocks.INVERTED_SCRAP_METAL_BRICKS.get(),
                NeoUBlocks.VERTICALLY_CUT_SCRAP_METAL.get(),
                NeoUBlocks.FORMED_SCRAP_METAL.get(),
                NeoUBlocks.REVERSE_FORMED_SCRAP_METAL.get(),
                NeoUBlocks.SCRAP_METAL_TILES.get(),
                NeoUBlocks.RUSTY_CUT_SCRAP_METAL.get(),
                NeoUBlocks.RUSTY_SCRAP_METAL_BRICKS.get(),
                NeoUBlocks.RUSTY_INVERTED_SCRAP_METAL_BRICKS.get(),
                NeoUBlocks.RUSTY_VERTICALLY_CUT_SCRAP_METAL.get(),
                NeoUBlocks.RUSTY_FORMED_SCRAP_METAL.get(),
                NeoUBlocks.RUSTY_REVERSE_FORMED_SCRAP_METAL.get(),
                NeoUBlocks.RUSTY_SCRAP_METAL_TILES.get(),
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

    fun magnetism() {
        // Magnetism
        tag(ACTagRegistry.MAGNETIC_BLOCKS)
            .addTag(NeoUTags.NEO_MAGNETIC_BLOCKS)
        tag(NeoUTags.NEO_MAGNETIC_BLOCKS)
            .addTag(NeoUTags.METAL_SCRAP_BLOCKS)
            .add(
                ACBlockRegistry.RUSTY_BARREL.get(),
                ACBlockRegistry.RUSTY_SCAFFOLDING.get(),
                ACBlockRegistry.HEART_OF_IRON.get(),
                ACBlockRegistry.DRAIN.get(),
                ACBlockRegistry.NUCLEAR_BOMB.get(),
                ACBlockRegistry.QUARRY.get(),
                Blocks.PISTON,
                Blocks.TRIPWIRE_HOOK,
            )
            .addOptional(FDBlocks.SKILLET.id)
            .addOptional(FDBlocks.COOKING_POT.id)
            .addOptional(FDBlocks.STOVE.id)
    }
}
