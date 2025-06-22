package org.teamvoided.neodonium.data.gen.prov

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.github.alexmodguy.alexscaves.server.misc.ACTagRegistry
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Blocks
import net.minecraftforge.common.data.BlockTagsProvider
import net.minecraftforge.data.event.GatherDataEvent
import org.teamvoided.neodonium.Neodonium
import org.teamvoided.neodonium.data.NeodoniumTags
import org.teamvoided.neodonium.init.NeoBlocks
import vectorwing.farmersdelight.common.registry.ModBlocks as FDBlocks


class BlockTags(event: GatherDataEvent) :
    BlockTagsProvider(event.generator.packOutput, event.lookupProvider, Neodonium.ID, event.existingFileHelper) {

    override fun addTags(provider: HolderLookup.Provider) {
        this.registerModTags()
        this.registerMinecraftTags()
        this.registerForgeTags()
        this.magnetism()
        this.registerBlockMineables()
    }

    fun registerBlockMineables() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(NeoBlocks.CUT_BRASS.get())
            .addTags(
                NeodoniumTags.METAL_SCRAP_BLOCKS,
                NeodoniumTags.COPPER_TILES
            )
        tag(BlockTags.NEEDS_STONE_TOOL)
//            .add()
            .addTags(
                NeodoniumTags.METAL_SCRAP_BLOCKS,
                NeodoniumTags.COPPER_TILES
            )

        tag(BlockTags.NEEDS_IRON_TOOL).add(
            NeoBlocks.CUT_BRASS.get()
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
        tag(NeodoniumTags.METAL_SCRAP_BLOCKS)
            .add(
                ACBlockRegistry.SCRAP_METAL.get(),
                ACBlockRegistry.RUSTY_SCRAP_METAL.get(),
                ACBlockRegistry.SCRAP_METAL_PLATE.get(),
                ACBlockRegistry.RUSTY_SCRAP_METAL_PLATE.get(),
            )
            .add(
                NeoBlocks.CUT_SCRAP_METAL.get(),
                NeoBlocks.SCRAP_METAL_BRICKS.get(),
                NeoBlocks.INVERTED_SCRAP_METAL_BRICKS.get(),
                NeoBlocks.VERTICALLY_CUT_SCRAP_METAL.get(),
                NeoBlocks.FORMED_SCRAP_METAL.get(),
                NeoBlocks.REVERSE_FORMED_SCRAP_METAL.get(),
                NeoBlocks.SCRAP_METAL_TILES.get(),
                NeoBlocks.RUSTY_CUT_SCRAP_METAL.get(),
                NeoBlocks.RUSTY_SCRAP_METAL_BRICKS.get(),
                NeoBlocks.RUSTY_INVERTED_SCRAP_METAL_BRICKS.get(),
                NeoBlocks.RUSTY_VERTICALLY_CUT_SCRAP_METAL.get(),
                NeoBlocks.RUSTY_FORMED_SCRAP_METAL.get(),
                NeoBlocks.RUSTY_REVERSE_FORMED_SCRAP_METAL.get(),
                NeoBlocks.RUSTY_SCRAP_METAL_TILES.get(),
            )
        tag(NeodoniumTags.COPPER_TILES)
            .add(
                NeoBlocks.COPPER_TILES.get(),
                NeoBlocks.WAXED_COPPER_TILES.get(),
                NeoBlocks.EXPOSED_COPPER_TILES.get(),
                NeoBlocks.WAXED_EXPOSED_COPPER_TILES.get(),
                NeoBlocks.WEATHERED_COPPER_TILES.get(),
                NeoBlocks.WAXED_WEATHERED_COPPER_TILES.get(),
                NeoBlocks.OXIDIZED_COPPER_TILES.get(),
                NeoBlocks.WAXED_OXIDIZED_COPPER_TILES.get(),
            )
    }

    fun magnetism() {
        // Magnetism
        tag(ACTagRegistry.MAGNETIC_BLOCKS)
            .addTag(NeodoniumTags.NEO_MAGNETIC_BLOCKS)
        tag(NeodoniumTags.NEO_MAGNETIC_BLOCKS)
            .addTag(NeodoniumTags.METAL_SCRAP_BLOCKS)
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
