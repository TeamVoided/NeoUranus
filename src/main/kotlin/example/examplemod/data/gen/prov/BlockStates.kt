package example.examplemod.data.gen.prov

import com.github.alexmodguy.alexscaves.AlexsCaves
import example.examplemod.NeoUranus
import example.examplemod.NeoUranus.id
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
        NeoUBlocks.COPPER_TILES.get(),
        NeoUBlocks.EXPOSED_COPPER_TILES.get(),
        NeoUBlocks.WEATHERED_COPPER_TILES.get(),
        NeoUBlocks.OXIDIZED_COPPER_TILES.get(),

        NeoUBlocks.CUT_BRASS.get()
    )

    val copyModel = listOf(
        NeoUBlocks.COPPER_TILES to NeoUBlocks.WAXED_COPPER_TILES,
        NeoUBlocks.EXPOSED_COPPER_TILES to NeoUBlocks.WAXED_EXPOSED_COPPER_TILES,
        NeoUBlocks.WEATHERED_COPPER_TILES to NeoUBlocks.WAXED_WEATHERED_COPPER_TILES,
        NeoUBlocks.OXIDIZED_COPPER_TILES to NeoUBlocks.WAXED_OXIDIZED_COPPER_TILES
    )
    val scrap = listOf(
        NeoUBlocks.CUT_SCRAP_METAL_ONE to ResourceLocation(AlexsCaves.MODID, "block/scrap_metal_0"),
        NeoUBlocks.CUT_SCRAP_METAL_TWO to ResourceLocation(AlexsCaves.MODID, "block/scrap_metal_1"),
        NeoUBlocks.CUT_SCRAP_METAL_THREE to ResourceLocation(AlexsCaves.MODID, "block/scrap_metal_2"),
        NeoUBlocks.CUT_SCRAP_METAL_FOUR to ResourceLocation(AlexsCaves.MODID, "block/scrap_metal_3"),
        NeoUBlocks.CUT_SCRAP_METAL_FIVE to id("block/scrap_metal_custom"),
        NeoUBlocks.CUT_SCRAP_METAL_SIX to ResourceLocation(AlexsCaves.MODID, "block/scrap_metal_4"),
        NeoUBlocks.CUT_SCRAP_METAL_SEVEN to ResourceLocation(AlexsCaves.MODID, "block/scrap_metal_5"),

        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_ONE to ResourceLocation(AlexsCaves.MODID, "block/rusty_scrap_metal_0"),
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_TWO to ResourceLocation(AlexsCaves.MODID, "block/rusty_scrap_metal_1"),
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_THREE to ResourceLocation(AlexsCaves.MODID, "block/rusty_scrap_metal_2"),
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_FOUR to ResourceLocation(AlexsCaves.MODID, "block/rusty_scrap_metal_3"),
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_FIVE to ResourceLocation(AlexsCaves.MODID, "block/rusty_scrap_metal_4"),
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_SIX to ResourceLocation(AlexsCaves.MODID, "block/rusty_scrap_metal_5"),
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_SEVEN to ResourceLocation(AlexsCaves.MODID, "block/rusty_scrap_metal_6"),
    )

    override fun registerStatesAndModels() {
        cubeAll.forEach { simpleCube(it) }
        copyModel.forEach { (parent, child) -> copyModel(parent.get(), child.get()) }
        scrap.forEach { (block, texture) -> scrap(block.get(), texture) }
    }

    fun scrap(block: Block, texture: ResourceLocation) {
        val model = models()
            .getBuilder(name(block))
            .parent(ConfiguredModel(exFile(ResourceLocation("block/cube_all"))).model)
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
