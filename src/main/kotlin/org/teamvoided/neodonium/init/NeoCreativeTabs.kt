package org.teamvoided.neodonium.init

import org.teamvoided.neodonium.Neodonium
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Suppress("HasPlatformType", "unused")
object NeoCreativeTabs {
    private val CREATIVE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Neodonium.ID)


    val TAB_NEODONIUM = CREATIVE_TABS.register("neodonium") {
        CreativeModeTab.builder()
            .title(Component.translatable("Neodonium"))
            .icon { ItemStack(NeoItems.REINFORCED_HAZMAT_MASK) }
            .displayItems { _, output -> NeoItems.creativeTabItems.forEach { output.accept(it.get()) } }
            .build()
    }

    init {
        CREATIVE_TABS.register(MOD_BUS)
    }
}
