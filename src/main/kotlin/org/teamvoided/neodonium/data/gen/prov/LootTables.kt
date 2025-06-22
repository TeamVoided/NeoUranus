package org.teamvoided.neodonium.data.gen.prov

import org.teamvoided.neodonium.init.NeoBlocks
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
        NeoBlocks.COPPER_TILES,
        NeoBlocks.WAXED_COPPER_TILES,
        NeoBlocks.EXPOSED_COPPER_TILES,
        NeoBlocks.WAXED_EXPOSED_COPPER_TILES,
        NeoBlocks.WEATHERED_COPPER_TILES,
        NeoBlocks.WAXED_WEATHERED_COPPER_TILES,
        NeoBlocks.OXIDIZED_COPPER_TILES,
        NeoBlocks.WAXED_OXIDIZED_COPPER_TILES,
        NeoBlocks.CUT_BRASS,
        NeoBlocks.CUT_SCRAP_METAL,
        NeoBlocks.SCRAP_METAL_BRICKS,
        NeoBlocks.INVERTED_SCRAP_METAL_BRICKS,
        NeoBlocks.VERTICALLY_CUT_SCRAP_METAL,
        NeoBlocks.FORMED_SCRAP_METAL,
        NeoBlocks.REVERSE_FORMED_SCRAP_METAL,
        NeoBlocks.SCRAP_METAL_TILES,
        NeoBlocks.RUSTY_CUT_SCRAP_METAL,
        NeoBlocks.RUSTY_SCRAP_METAL_BRICKS,
        NeoBlocks.RUSTY_INVERTED_SCRAP_METAL_BRICKS,
        NeoBlocks.RUSTY_VERTICALLY_CUT_SCRAP_METAL,
        NeoBlocks.RUSTY_FORMED_SCRAP_METAL,
        NeoBlocks.RUSTY_REVERSE_FORMED_SCRAP_METAL,
        NeoBlocks.RUSTY_SCRAP_METAL_TILES,
    )

    override fun generate() {
        dropsSelf.forEach { dropSelf(it.get()) }
    }

    override fun getKnownBlocks(): Iterable<Block> {
        return NeoBlocks.BLOCKS.entries.map { it.get() }
    }
}
