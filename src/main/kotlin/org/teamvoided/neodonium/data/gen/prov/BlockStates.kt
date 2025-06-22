package org.teamvoided.neodonium.data.gen.prov

import org.teamvoided.neodonium.Neodonium
import org.teamvoided.neodonium.Neodonium.id
import org.teamvoided.neodonium.init.NeoBlocks
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.minecraftforge.client.model.generators.BlockStateProvider
import net.minecraftforge.client.model.generators.ConfiguredModel
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.registries.ForgeRegistries
import org.teamvoided.neodonium.Neodonium.alexId
import org.teamvoided.neodonium.Neodonium.mc

class BlockStates(event: GatherDataEvent) :
    BlockStateProvider(event.generator.packOutput, Neodonium.ID, event.existingFileHelper) {

    private fun blockId(block: Block): ResourceLocation = key(block)!!.withPrefix("block/")

    private fun key(block: Block): ResourceLocation? = ForgeRegistries.BLOCKS.getKey(block)
    private fun name(block: Block): String = key(block)!!.path

    val cubeAll = listOf(
        NeoBlocks.COPPER_TILES.get(),
        NeoBlocks.EXPOSED_COPPER_TILES.get(),
        NeoBlocks.WEATHERED_COPPER_TILES.get(),
        NeoBlocks.OXIDIZED_COPPER_TILES.get(),

        NeoBlocks.CUT_BRASS.get()
    )

    val copyModel = listOf(
        NeoBlocks.COPPER_TILES to NeoBlocks.WAXED_COPPER_TILES,
        NeoBlocks.EXPOSED_COPPER_TILES to NeoBlocks.WAXED_EXPOSED_COPPER_TILES,
        NeoBlocks.WEATHERED_COPPER_TILES to NeoBlocks.WAXED_WEATHERED_COPPER_TILES,
        NeoBlocks.OXIDIZED_COPPER_TILES to NeoBlocks.WAXED_OXIDIZED_COPPER_TILES
    )
    val scrap = listOf(
        NeoBlocks.CUT_SCRAP_METAL to alexId("block/scrap_metal_0"),
        NeoBlocks.SCRAP_METAL_BRICKS to alexId("block/scrap_metal_1"),
        NeoBlocks.INVERTED_SCRAP_METAL_BRICKS to alexId("block/scrap_metal_2"),
        NeoBlocks.VERTICALLY_CUT_SCRAP_METAL to alexId("block/scrap_metal_3"),
        NeoBlocks.FORMED_SCRAP_METAL to id("block/scrap_metal_custom"),
        NeoBlocks.REVERSE_FORMED_SCRAP_METAL to alexId("block/scrap_metal_4"),
        NeoBlocks.SCRAP_METAL_TILES to alexId("block/scrap_metal_5"),

        NeoBlocks.RUSTY_CUT_SCRAP_METAL to alexId("block/rusty_scrap_metal_0"),
        NeoBlocks.RUSTY_SCRAP_METAL_BRICKS to alexId("block/rusty_scrap_metal_1"),
        NeoBlocks.RUSTY_INVERTED_SCRAP_METAL_BRICKS to alexId("block/rusty_scrap_metal_2"),
        NeoBlocks.RUSTY_VERTICALLY_CUT_SCRAP_METAL to alexId("block/rusty_scrap_metal_3"),
        NeoBlocks.RUSTY_FORMED_SCRAP_METAL to alexId("block/rusty_scrap_metal_4"),
        NeoBlocks.RUSTY_REVERSE_FORMED_SCRAP_METAL to alexId("block/rusty_scrap_metal_5"),
        NeoBlocks.RUSTY_SCRAP_METAL_TILES to alexId("block/rusty_scrap_metal_6"),
    )

    override fun registerStatesAndModels() {
        cubeAll.forEach { simpleCube(it) }
        copyModel.forEach { (parent, child) -> copyModel(parent.get(), child.get()) }
        scrap.forEach { (block, texture) -> scrap(block.get(), texture) }
    }

    fun scrap(block: Block, texture: ResourceLocation) {
        val model = models()
            .getBuilder(name(block))
            .parent(ConfiguredModel(exFile(mc("block/cube_all"))).model)
            .texture("all", texture)
        getVariantBuilder(block)
            .partialState()
            .addModels(ConfiguredModel(model))
        simpleBlockItem(block, model)
    }

    private fun copyModel(parent: Block, block: Block) {
        getVariantBuilder(block)
            .partialState()
            .addModels(ConfiguredModel(exFile(blockId(parent))))
        itemModels()
            .getBuilder(name(block))
            .parent(exFile(blockId(parent)))
    }

    private fun simpleCube(block: Block) = simpleBlockWithItem(block, cubeAll(block))


    private fun exFile(id: ResourceLocation) = models().getExistingFile(id)
}
