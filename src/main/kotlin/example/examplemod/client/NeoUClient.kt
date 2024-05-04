package example.examplemod.client

import dev.kosmx.playerAnim.api.layered.IAnimation
import dev.kosmx.playerAnim.api.layered.ModifierLayer
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory
import example.examplemod.NeoUranus.id
import example.examplemod.NeoUranus.log
import example.examplemod.client.render.entity.ThrownRebarRenderer
import example.examplemod.init.NeoUEntities
import example.examplemod.init.NeoUItems
import example.examplemod.util.isScarlet
import net.minecraft.client.renderer.entity.EntityRenderers
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS


@OnlyIn(Dist.CLIENT)
object NeoUClient {
    val ANIM_FACTORY = id("animation")

    init {
        log.info("NeoUClient")
        ClientEvents

        MOD_BUS.addListener(::onClientSetup)
    }

    @Suppress("MagicNumber")
    private fun onClientSetup(event: FMLClientSetupEvent) {
        log.info("Registering animations")
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(ANIM_FACTORY, 42) { ModifierLayer<IAnimation>() }

        log.info("Registering renderers")
        regEntityRenderers()
        log.info("Registering item properties")
        event.enqueueWork {
            ItemProperties.register(NeoUItems.GALENA_RIFLE.get(), id("polarity"))
            { stack, _, _, _ -> if (isScarlet(stack)) 1.0f else 0.0f }
        }
    }


    private fun regEntityRenderers() {
        EntityRenderers.register(NeoUEntities.THROWN_REBAR.get(), ::ThrownRebarRenderer)
        EntityRenderers.register(NeoUEntities.THROWN_AZURE_REBAR.get(), ::ThrownRebarRenderer)


    }
}
