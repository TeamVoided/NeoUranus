package org.teamvoided.neodonium.data.gen.prov

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry
import com.github.alexmodguy.alexscaves.server.misc.ACTagRegistry
import net.minecraft.core.HolderLookup
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.Items
import net.minecraftforge.data.event.GatherDataEvent
import org.teamvoided.neodonium.Neodonium
import org.teamvoided.neodonium.data.NeodoniumTags
import org.teamvoided.neodonium.init.NeoItems
import vectorwing.farmersdelight.common.registry.ModItems
import vectorwing.farmersdelight.common.tag.ForgeTags
import vectorwing.farmersdelight.common.tag.ModTags

class NeoItemTags(event: GatherDataEvent, blockTags: BlockTags) : ItemTagsProvider(
    event.generator.packOutput, event.lookupProvider, blockTags.contentsGetter(), Neodonium.ID, event.existingFileHelper
) {
    override fun addTags(provider: HolderLookup.Provider) {
        copy(NeodoniumTags.NEO_MAGNETIC_BLOCKS, NeodoniumTags.NEO_MAGNETIC_ITEMS)
        copy(NeodoniumTags.METAL_SCRAP_BLOCKS, NeodoniumTags.METAL_SCRAP_ITEMS)

        hazmat()
        magnetism()
        compatibility()
    }

    private fun hazmat() {
        tag(NeodoniumTags.HAZMAT_ARMOR)
            .add(
                ACItemRegistry.HAZMAT_MASK.get(),
                ACItemRegistry.HAZMAT_CHESTPLATE.get(),
                ACItemRegistry.HAZMAT_LEGGINGS.get(),
                ACItemRegistry.HAZMAT_BOOTS.get(),
                NeoItems.REINFORCED_HAZMAT_MASK.get(),
                NeoItems.REINFORCED_HAZMAT_CHESTPLATE.get(),
                NeoItems.REINFORCED_HAZMAT_LEGGINGS.get(),
                NeoItems.REINFORCED_HAZMAT_BOOTS.get(),
            )
        tag(NeodoniumTags.HAZMAT_PROTECTION)
            .addTag(NeodoniumTags.HAZMAT_ARMOR)
    }

    fun magnetism() {
        tag(ACTagRegistry.MAGNETIC_ITEMS)
            .addTag(NeodoniumTags.NEO_MAGNETIC_ITEMS)
        tag(ACTagRegistry.GALENA_GAUNTLET_CRYSTALLIZATION_ITEMS)
            .addTag(NeodoniumTags.NEO_CRYSTALLIZATION_ITEMS)

        tag(NeodoniumTags.NEO_MAGNETIC_ITEMS)
            .add(
                Items.IRON_HORSE_ARMOR,
                ACItemRegistry.DEPTH_CHARGE.get(),
                ACBlockRegistry.METAL_REBAR.get().asItem(),
                ACBlockRegistry.RUSTY_REBAR.get().asItem(),
                NeoItems.REINFORCED_HAZMAT_MASK.get(),
                NeoItems.REINFORCED_HAZMAT_CHESTPLATE.get(),
                NeoItems.REINFORCED_HAZMAT_LEGGINGS.get(),
                NeoItems.REINFORCED_HAZMAT_BOOTS.get(),
            )
            .addOptional(ModItems.IRON_KNIFE.id)
            .addOptional(ModItems.NETHERITE_KNIFE.id)

        tag(NeodoniumTags.NEO_CRYSTALLIZATION_ITEMS)
            .add(
                // Amethyst
                Items.AMETHYST_BLOCK,
                Items.BUDDING_AMETHYST,
                Items.SMALL_AMETHYST_BUD,
                Items.MEDIUM_AMETHYST_BUD,
                Items.LARGE_AMETHYST_BUD,
                Items.AMETHYST_CLUSTER,
                // Quartz
                Items.QUARTZ_BLOCK,
                Items.QUARTZ_SLAB,
                Items.QUARTZ_STAIRS,
                Items.QUARTZ_PILLAR,
                Items.QUARTZ_BRICKS,
                Items.CHISELED_QUARTZ_BLOCK,
                Items.NETHER_QUARTZ_ORE,
                Items.SMOOTH_QUARTZ,
                Items.SMOOTH_QUARTZ_STAIRS,
                Items.SMOOTH_QUARTZ_SLAB,
                // Diamond
                Items.DIAMOND_BLOCK,
                Items.DIAMOND_HELMET,
                Items.DIAMOND_CHESTPLATE,
                Items.DIAMOND_LEGGINGS,
                Items.DIAMOND_BOOTS,
                Items.DIAMOND_HORSE_ARMOR,
                // Emerald
                Items.EMERALD,
                Items.EMERALD_BLOCK,
                // Lapis
                Items.LAPIS_LAZULI,
                Items.LAPIS_BLOCK,
                // Misc
                Items.CALIBRATED_SCULK_SENSOR,
                Items.TINTED_GLASS,
                Items.PRISMARINE_CRYSTALS,
                Items.SEA_LANTERN
            )
            .addTags(
                ItemTags.EMERALD_ORES,
                ItemTags.LAPIS_ORES,
                ItemTags.DIAMOND_ORES,
            )
            .addOptional(ModItems.DIAMOND_KNIFE.id)

    }

    fun compatibility() {
        tag(ModTags.KNIVES).add(
            ACItemRegistry.DESOLATE_DAGGER.get(),
            NeoItems.SCARLET_NEODYMIUM_KNIFE.get(),
            NeoItems.AZURE_NEODYMIUM_KNIFE.get()
        )
        tag(ForgeTags.TOOLS_KNIVES).add(
            ACItemRegistry.DESOLATE_DAGGER.get(),
            NeoItems.SCARLET_NEODYMIUM_KNIFE.get(),
            NeoItems.AZURE_NEODYMIUM_KNIFE.get()
        )
        tag(ACTagRegistry.TELETOR_SPAWNS_WITH)
            .addOptional(ModItems.IRON_KNIFE.id)
    }
}
