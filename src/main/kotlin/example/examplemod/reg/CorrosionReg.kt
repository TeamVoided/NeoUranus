package example.examplemod.reg

import example.examplemod.init.NeoUBlocks
import net.minecraft.world.level.block.Block
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate

typealias RegBlock = ObjectHolderDelegate<Block>

object CorrosionReg {

    private val CORROSION_MAP = mutableMapOf<RegBlock, RegBlock>()

    @JvmStatic
    fun getCorrosionBlocks() = CORROSION_MAP.toMap()

    @Suppress("MemberVisibilityCanBePrivate")
    fun register(input: RegBlock, output: RegBlock): Boolean = CORROSION_MAP.putIfAbsent(input, output) != null

    fun registerDefault() {
        register(NeoUBlocks.CUT_SCRAP_METAL_ONE, NeoUBlocks.CUT_RUSTY_SCRAP_METAL_ONE)
        register(NeoUBlocks.CUT_SCRAP_METAL_TWO, NeoUBlocks.CUT_RUSTY_SCRAP_METAL_TWO)
        register(NeoUBlocks.CUT_SCRAP_METAL_THREE, NeoUBlocks.CUT_RUSTY_SCRAP_METAL_THREE)
        register(NeoUBlocks.CUT_SCRAP_METAL_FOUR, NeoUBlocks.CUT_RUSTY_SCRAP_METAL_FOUR)
        register(NeoUBlocks.CUT_SCRAP_METAL_FIVE, NeoUBlocks.CUT_RUSTY_SCRAP_METAL_FIVE)
        register(NeoUBlocks.CUT_SCRAP_METAL_SIX, NeoUBlocks.CUT_RUSTY_SCRAP_METAL_SIX)
        register(NeoUBlocks.CUT_SCRAP_METAL_SEVEN, NeoUBlocks.CUT_RUSTY_SCRAP_METAL_SEVEN)
        register(NeoUBlocks.COPPER_TILES, NeoUBlocks.EXPOSED_COPPER_TILES)
        register(NeoUBlocks.EXPOSED_COPPER_TILES, NeoUBlocks.WEATHERED_COPPER_TILES)
        register(NeoUBlocks.WEATHERED_COPPER_TILES, NeoUBlocks.OXIDIZED_COPPER_TILES)
    }
}
