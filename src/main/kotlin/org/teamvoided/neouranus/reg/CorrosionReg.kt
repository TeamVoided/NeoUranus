package org.teamvoided.neouranus.reg

import org.teamvoided.neouranus.init.NeoUBlocks
import net.minecraft.world.level.block.Block
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate

typealias RegBlock = ObjectHolderDelegate<Block>

object CorrosionReg {
    private val CORROSION_MAP = mutableMapOf<RegBlock, RegBlock>()
    @JvmStatic
    fun getCorrosionRegBlocks() = CORROSION_MAP.toMap()

    fun register(input: RegBlock, output: RegBlock): Boolean = CORROSION_MAP.putIfAbsent(input, output) != null

    fun registerDefault() {
        register(NeoUBlocks.CUT_SCRAP_METAL, NeoUBlocks.RUSTY_CUT_SCRAP_METAL)
        register(NeoUBlocks.SCRAP_METAL_BRICKS, NeoUBlocks.RUSTY_SCRAP_METAL_BRICKS)
        register(NeoUBlocks.INVERTED_SCRAP_METAL_BRICKS, NeoUBlocks.RUSTY_INVERTED_SCRAP_METAL_BRICKS)
        register(NeoUBlocks.VERTICALLY_CUT_SCRAP_METAL, NeoUBlocks.RUSTY_VERTICALLY_CUT_SCRAP_METAL)
        register(NeoUBlocks.FORMED_SCRAP_METAL, NeoUBlocks.RUSTY_FORMED_SCRAP_METAL)
        register(NeoUBlocks.REVERSE_FORMED_SCRAP_METAL, NeoUBlocks.RUSTY_REVERSE_FORMED_SCRAP_METAL)
        register(NeoUBlocks.SCRAP_METAL_TILES, NeoUBlocks.RUSTY_SCRAP_METAL_TILES)
        register(NeoUBlocks.COPPER_TILES, NeoUBlocks.EXPOSED_COPPER_TILES)
        register(NeoUBlocks.EXPOSED_COPPER_TILES, NeoUBlocks.WEATHERED_COPPER_TILES)
        register(NeoUBlocks.WEATHERED_COPPER_TILES, NeoUBlocks.OXIDIZED_COPPER_TILES)
    }
}
