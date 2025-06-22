package org.teamvoided.neodonium.reg

import org.teamvoided.neodonium.init.NeoBlocks
import net.minecraft.world.level.block.Block
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate

typealias RegBlock = ObjectHolderDelegate<Block>

object CorrosionReg {
    private val CORROSION_MAP = mutableMapOf<RegBlock, RegBlock>()
    @JvmStatic
    fun getCorrosionRegBlocks() = CORROSION_MAP.toMap()

    fun register(input: RegBlock, output: RegBlock): Boolean = CORROSION_MAP.putIfAbsent(input, output) != null

    fun registerDefault() {
        register(NeoBlocks.CUT_SCRAP_METAL, NeoBlocks.RUSTY_CUT_SCRAP_METAL)
        register(NeoBlocks.SCRAP_METAL_BRICKS, NeoBlocks.RUSTY_SCRAP_METAL_BRICKS)
        register(NeoBlocks.INVERTED_SCRAP_METAL_BRICKS, NeoBlocks.RUSTY_INVERTED_SCRAP_METAL_BRICKS)
        register(NeoBlocks.VERTICALLY_CUT_SCRAP_METAL, NeoBlocks.RUSTY_VERTICALLY_CUT_SCRAP_METAL)
        register(NeoBlocks.FORMED_SCRAP_METAL, NeoBlocks.RUSTY_FORMED_SCRAP_METAL)
        register(NeoBlocks.REVERSE_FORMED_SCRAP_METAL, NeoBlocks.RUSTY_REVERSE_FORMED_SCRAP_METAL)
        register(NeoBlocks.SCRAP_METAL_TILES, NeoBlocks.RUSTY_SCRAP_METAL_TILES)
        register(NeoBlocks.COPPER_TILES, NeoBlocks.EXPOSED_COPPER_TILES)
        register(NeoBlocks.EXPOSED_COPPER_TILES, NeoBlocks.WEATHERED_COPPER_TILES)
        register(NeoBlocks.WEATHERED_COPPER_TILES, NeoBlocks.OXIDIZED_COPPER_TILES)
    }
}
