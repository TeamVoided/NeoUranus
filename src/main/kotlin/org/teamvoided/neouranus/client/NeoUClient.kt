package org.teamvoided.neouranus.client

import dev.kosmx.playerAnim.api.layered.IAnimation
import dev.kosmx.playerAnim.api.layered.ModifierLayer
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn
import net.minecraftforge.client.event.EntityRenderersEvent
import org.teamvoided.neouranus.NeoUranus.id
import org.teamvoided.neouranus.NeoUranus.log
import org.teamvoided.neouranus.client.render.entity.ThrownRebarRenderer
import org.teamvoided.neouranus.init.NeoUEntities
import thedarkcolour.kotlinforforge.forge.MOD_BUS


@OnlyIn(Dist.CLIENT)
object NeoUClient {
    val ANIM_FACTORY = id("animation")
    init {
        log.info("NeoUClient")
        ClientEvents

        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(ANIM_FACTORY, 42) { ModifierLayer<IAnimation>() }

        MOD_BUS.addListener(::regEntityRenderers)
       /* ItemProperties.register(
            NeoUItems.GALENA_RIFLE.get(), id("polarity")
        ) { stack, _, _, _ -> if (isScarlet(stack)) 1.0f else 0.0f }*/
    }

    fun regEntityRenderers(event: EntityRenderersEvent.RegisterRenderers) {
        event.registerEntityRenderer(NeoUEntities.THROWN_REBAR.get(), ::ThrownRebarRenderer)
        event.registerEntityRenderer(NeoUEntities.THROWN_AZURE_REBAR.get(), ::ThrownRebarRenderer)
    }
}
