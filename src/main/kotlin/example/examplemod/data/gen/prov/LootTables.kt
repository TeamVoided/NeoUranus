package example.examplemod.data.gen.prov

import example.examplemod.init.NeoUBlocks
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.minecraftforge.data.event.GatherDataEvent


class LootTables(event: GatherDataEvent) :
    LootTableProvider(
        event.generator.packOutput, setOf(), listOf(SubProviderEntry(::ModBlockLootTables, LootContextParamSets.BLOCK))
    )

class ModBlockLootTables : BlockLootSubProvider(setOf(), FeatureFlags.REGISTRY.allFlags()) {
    val dropsSelf = listOf(
        NeoUBlocks.COPPER_TILES,
        NeoUBlocks.WAXED_COPPER_TILES,
        NeoUBlocks.EXPOSED_COPPER_TILES,
        NeoUBlocks.WAXED_EXPOSED_COPPER_TILES,
        NeoUBlocks.WEATHERED_COPPER_TILES,
        NeoUBlocks.WAXED_WEATHERED_COPPER_TILES,
        NeoUBlocks.OXIDIZED_COPPER_TILES,
        NeoUBlocks.WAXED_OXIDIZED_COPPER_TILES,
        NeoUBlocks.CUT_BRASS,
        NeoUBlocks.CUT_SCRAP_METAL_ONE,
        NeoUBlocks.CUT_SCRAP_METAL_TWO,
        NeoUBlocks.CUT_SCRAP_METAL_THREE,
        NeoUBlocks.CUT_SCRAP_METAL_FOUR,
        NeoUBlocks.CUT_SCRAP_METAL_FIVE,
        NeoUBlocks.CUT_SCRAP_METAL_SIX,
        NeoUBlocks.CUT_SCRAP_METAL_SEVEN,
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_ONE,
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_TWO,
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_THREE,
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_FOUR,
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_FIVE,
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_SIX,
        NeoUBlocks.CUT_RUSTY_SCRAP_METAL_SEVEN,
    )

    override fun generate() {
        dropsSelf.forEach { dropSelf(it.get()) }
    }

    override fun getKnownBlocks(): Iterable<Block> {
        return NeoUBlocks.BLOCKS.entries.map { it.get() }
    }
}
