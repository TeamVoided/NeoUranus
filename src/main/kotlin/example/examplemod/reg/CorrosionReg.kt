package example.examplemod.reg

import com.simibubi.create.AllBlocks
import com.simibubi.create.foundation.block.CopperBlockSet
import com.tterrag.registrate.util.entry.BlockEntry
import example.examplemod.init.NeoUBlocks
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.WeatheringCopper.WeatherState
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate

typealias RegBlock = ObjectHolderDelegate<Block>

object CorrosionReg {

    private val CORROSION_MAP = mutableMapOf<RegBlock, RegBlock>()

    private val CORROSION_BLOCK_MAP = mutableMapOf<BlockEntry<*>, BlockEntry<*>>()

    @JvmStatic
    fun getCorrosionRegBlocks() = CORROSION_MAP.toMap()

    @JvmStatic
    fun getCorrosionBlocks() = CORROSION_BLOCK_MAP.toMap()

    @Suppress("MemberVisibilityCanBePrivate")
    fun register(input: RegBlock, output: RegBlock): Boolean = CORROSION_MAP.putIfAbsent(input, output) != null

    @Suppress("MemberVisibilityCanBePrivate")
    fun register(input: BlockEntry<*>, output: BlockEntry<*>): Boolean =
        CORROSION_BLOCK_MAP.putIfAbsent(input, output) != null

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

    fun registerCreate() {
        register(AllBlocks.COPPER_SHINGLES)
        register(AllBlocks.COPPER_TILES)
    }

    private fun register(set: CopperBlockSet) = set.variants.forEach {
        val unaffected = set.get(it, WeatherState.UNAFFECTED, false)
        val exposed = set.get(it, WeatherState.EXPOSED, false)
        val weathered = set.get(it, WeatherState.WEATHERED, false)
        val oxidized = set.get(it, WeatherState.OXIDIZED, false)
        register(unaffected, exposed)
        register(exposed, weathered)
        register(weathered, oxidized)
    }

}
