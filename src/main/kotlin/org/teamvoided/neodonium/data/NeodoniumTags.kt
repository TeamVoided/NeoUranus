package org.teamvoided.neodonium.data

import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import org.teamvoided.neodonium.Neodonium.id

object NeodoniumTags {
    val NEO_MAGNETIC_BLOCKS = blockTag("neo_ferromagnetic_blocks")

    val COPPER_TILES = blockTag("copper_tiles")
    val METAL_SCRAP_BLOCKS = blockTag("metal_scrap")

    val NEO_MAGNETIC_ITEMS = itemTag("neo_ferromagnetic_items")
    val NEO_CRYSTALLIZATION_ITEMS = itemTag("neo_galena_gauntlet_crystallization_items")

    val METAL_SCRAP_ITEMS = itemTag("metal_scrap")

    val HAZMAT_ARMOR = itemTag("hazmat_armor")

    @JvmField
    val HAZMAT_PROTECTION = itemTag("hazmat_protection")

    private fun itemTag(name: String): TagKey<Item> = TagKey.create(Registries.ITEM, id(name))
    private fun blockTag(name: String): TagKey<Block> = TagKey.create(Registries.BLOCK, id(name))

}
