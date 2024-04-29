package example.examplemod.data.gen.prov

import example.examplemod.NeoUranus
import example.examplemod.init.NeoUBlocks
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.minecraftforge.client.model.generators.BlockStateProvider
import net.minecraftforge.client.model.generators.ConfiguredModel
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.registries.ForgeRegistries

class BlockStates(event: GatherDataEvent) :
    BlockStateProvider(event.generator.packOutput, NeoUranus.ID, event.existingFileHelper) {

    private fun blockId(block: Block): ResourceLocation = key(block)!!.withPrefix("block/")

    private fun key(block: Block): ResourceLocation? = ForgeRegistries.BLOCKS.getKey(block)
    private fun name(block: Block): String = key(block)!!.path

    val cubeAll = listOf(
        NeoUBlocks.COPPER_TILES,
        NeoUBlocks.EXPOSED_COPPER_TILES,
        NeoUBlocks.WEATHERED_COPPER_TILES,
        NeoUBlocks.OXIDIZED_COPPER_TILES,
        NeoUBlocks.CUT_BRASS
    )

    val copyModel = listOf(
        NeoUBlocks.COPPER_TILES to NeoUBlocks.WAXED_COPPER_TILES,
        NeoUBlocks.EXPOSED_COPPER_TILES to NeoUBlocks.WAXED_EXPOSED_COPPER_TILES,
        NeoUBlocks.WEATHERED_COPPER_TILES to NeoUBlocks.WAXED_WEATHERED_COPPER_TILES,
        NeoUBlocks.OXIDIZED_COPPER_TILES to NeoUBlocks.WAXED_OXIDIZED_COPPER_TILES
    )

    override fun registerStatesAndModels() {
        cubeAll.forEach { simpleCube(it.get()) }
        copyModel.forEach { (parent, child) -> copyModel(parent.get(), child.get()) }
    }

    private fun copyModel(parent: Block, block: Block) {
        getVariantBuilder(block).partialState().addModels(ConfiguredModel(models().getExistingFile(blockId(parent))))
        itemModels().getBuilder(name(block)).parent(models().getExistingFile(blockId(parent)))
    }

    private fun simpleCube(block: Block) = simpleBlockWithItem(block, cubeAll(block))

}
