package example.examplemod.client

import dev.kosmx.playerAnim.api.layered.IAnimation
import dev.kosmx.playerAnim.api.layered.ModifierLayer
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory
import example.examplemod.NeoUranus.id
import example.examplemod.NeoUranus.log
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

object NeoUClient {
    val ANIM_FACTORY = id("animation")

    init {
        log.info("NeoUClient")
        ClientEvents

        MOD_BUS.addListener(::onClientSetup)
    }

    @Suppress("MagicNumber")
    private fun onClientSetup(ignored: FMLClientSetupEvent) {
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(ANIM_FACTORY, 42) { ModifierLayer<IAnimation>() }
        log.info("Registered animation factory")
    }
}
