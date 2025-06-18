package org.teamvoided.neouranus.init

import com.github.alexmodguy.alexscaves.server.block.ACSoundTypes
import org.teamvoided.neouranus.NeoUranus
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.WeatheringCopper.WeatherState
import net.minecraft.world.level.block.WeatheringCopperFullBlock
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject


object NeoUBlocks {
    val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, NeoUranus.ID)

    val COPPER_TILES = regBlockWItem("copper_tiles") {
        copperBlock(WeatherState.UNAFFECTED, MapColor.COLOR_ORANGE)
    }
    val WAXED_COPPER_TILES = regBlockWItem("waxed_copper_tiles") { copyBlock(COPPER_TILES) }

    val EXPOSED_COPPER_TILES = regBlockWItem("exposed_copper_tiles") {
        copperBlock(WeatherState.EXPOSED, MapColor.TERRACOTTA_LIGHT_GRAY)
    }
    val WAXED_EXPOSED_COPPER_TILES = regBlockWItem("waxed_exposed_copper_tiles") { copyBlock(EXPOSED_COPPER_TILES) }
    val WEATHERED_COPPER_TILES = regBlockWItem("weathered_copper_tiles") {
        copperBlock(WeatherState.WEATHERED, MapColor.WARPED_STEM)
    }
    val WAXED_WEATHERED_COPPER_TILES =
        regBlockWItem("waxed_weathered_copper_tiles") { copyBlock(WEATHERED_COPPER_TILES) }
    val OXIDIZED_COPPER_TILES = regBlockWItem("oxidized_copper_tiles") {
        copperBlock(WeatherState.OXIDIZED, MapColor.WARPED_NYLIUM)
    }
    val WAXED_OXIDIZED_COPPER_TILES = regBlockWItem("waxed_oxidized_copper_tiles") { copyBlock(OXIDIZED_COPPER_TILES) }

    val CUT_BRASS = regBlockWItem("cut_brass") {
        Block(
            BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                .requiresCorrectToolForDrops()
                .mapColor(MapColor.TERRACOTTA_YELLOW)
        )
    }

    val CUT_SCRAP_METAL = regBlockWItem("cut_scrap_metal") { scarpBlock() }
    val VERTICALLY_CUT_SCRAP_METAL = regBlockWItem("vertically_cut_scrap_metal") { scarpBlock() }
    val SCRAP_METAL_BRICKS = regBlockWItem("scrap_metal_bricks") { scarpBlock() }
    val INVERTED_SCRAP_METAL_BRICKS = regBlockWItem("inverted_scrap_metal_bricks") { scarpBlock() }
    val FORMED_SCRAP_METAL = regBlockWItem("formed_scrap_metal") { scarpBlock() }
    val REVERSE_FORMED_SCRAP_METAL = regBlockWItem("reverse_formed_scrap_metal") { scarpBlock() }
    val SCRAP_METAL_TILES = regBlockWItem("scrap_metal_tiles") { scarpBlock() }

    val RUSTY_CUT_SCRAP_METAL = regBlockWItem("rusty_cut_scrap_metal") { scarpBlock() }
    val RUSTY_VERTICALLY_CUT_SCRAP_METAL = regBlockWItem("rusty_vertically_cut_scrap_metal") { scarpBlock() }
    val RUSTY_SCRAP_METAL_BRICKS = regBlockWItem("rusty_scrap_metal_bricks") { scarpBlock() }
    val RUSTY_INVERTED_SCRAP_METAL_BRICKS = regBlockWItem("rusty_inverted_scrap_metal_bricks") { scarpBlock() }
    val RUSTY_FORMED_SCRAP_METAL = regBlockWItem("rusty_formed_scrap_metal") { scarpBlock() }
    val RUSTY_REVERSE_FORMED_SCRAP_METAL = regBlockWItem("rusty_reverse_formed_scrap_metal") { scarpBlock() }
    val RUSTY_SCRAP_METAL_TILES = regBlockWItem("rusty_scrap_metal_tiles") { scarpBlock() }

    init {
        BLOCKS.register(MOD_BUS)
    }

    private fun copperBlock(state: WeatherState, mapColor: MapColor) =
        WeatheringCopperFullBlock(
            state, BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .requiresCorrectToolForDrops()
                .strength(3.0f, 6.0f)
                .sound(SoundType.COPPER)
        )

    private fun scarpBlock() = Block(
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.METAL)
            .requiresCorrectToolForDrops()
            .strength(5.0f, 15.0f)
            .sound(ACSoundTypes.SCRAP_METAL)
    )


    private fun copyBlock(block: ObjectHolderDelegate<Block>) = Block(BlockBehaviour.Properties.copy(block.get()))


    private fun regBlockWItem(id: String, creativeTab: Boolean = true, supplier: () -> Block):
            ObjectHolderDelegate<Block> {
        val block = BLOCKS.registerObject(id, supplier)
        NeoUItems.regItem(id, creativeTab) { BlockItem(block.get(), Item.Properties()) }

        return block
    }
}
