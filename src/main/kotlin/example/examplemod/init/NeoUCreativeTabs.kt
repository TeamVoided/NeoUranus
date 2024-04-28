package example.examplemod.init

import example.examplemod.NeoUranus
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Suppress("HasPlatformType", "unused")
object NeoUCreativeTabs {
    private val CREATIVE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NeoUranus.ID)


    val TAB_NEO_URANUS = CREATIVE_TABS.register("neouranus") {
        CreativeModeTab.builder()
            .title(Component.translatable("NeoUranus"))
            .icon { ItemStack(NeoUBlocks.COPPER_TILES) }
            .displayItems { _, output ->
                NeoUItems.creativeTabItems.forEach(output::accept)
            }.build()
    }

    fun init() = CREATIVE_TABS.register(MOD_BUS)
}
