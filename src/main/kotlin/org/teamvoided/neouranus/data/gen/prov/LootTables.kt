package org.teamvoided.neouranus.data.gen.prov

import org.teamvoided.neouranus.init.NeoUBlocks
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
        NeoUBlocks.CUT_SCRAP_METAL,
        NeoUBlocks.SCRAP_METAL_BRICKS,
        NeoUBlocks.INVERTED_SCRAP_METAL_BRICKS,
        NeoUBlocks.VERTICALLY_CUT_SCRAP_METAL,
        NeoUBlocks.FORMED_SCRAP_METAL,
        NeoUBlocks.REVERSE_FORMED_SCRAP_METAL,
        NeoUBlocks.SCRAP_METAL_TILES,
        NeoUBlocks.RUSTY_CUT_SCRAP_METAL,
        NeoUBlocks.RUSTY_SCRAP_METAL_BRICKS,
        NeoUBlocks.RUSTY_INVERTED_SCRAP_METAL_BRICKS,
        NeoUBlocks.RUSTY_VERTICALLY_CUT_SCRAP_METAL,
        NeoUBlocks.RUSTY_FORMED_SCRAP_METAL,
        NeoUBlocks.RUSTY_REVERSE_FORMED_SCRAP_METAL,
        NeoUBlocks.RUSTY_SCRAP_METAL_TILES,
    )

    override fun generate() {
        dropsSelf.forEach { dropSelf(it.get()) }
    }

    override fun getKnownBlocks(): Iterable<Block> {
        return NeoUBlocks.BLOCKS.entries.map { it.get() }
    }
}
