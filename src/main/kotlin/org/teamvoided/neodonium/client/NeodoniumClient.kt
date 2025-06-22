package org.teamvoided.neodonium.client

import dev.kosmx.playerAnim.api.layered.IAnimation
import dev.kosmx.playerAnim.api.layered.ModifierLayer
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn
import net.minecraftforge.client.event.EntityRenderersEvent
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import org.teamvoided.neodonium.Neodonium.id
import org.teamvoided.neodonium.Neodonium.log
import org.teamvoided.neodonium.client.render.entity.ThrownRebarRenderer
import org.teamvoided.neodonium.init.NeoEntities
import org.teamvoided.neodonium.init.NeoItems
import org.teamvoided.neodonium.util.isScarlet
import thedarkcolour.kotlinforforge.forge.MOD_BUS


@OnlyIn(Dist.CLIENT)
object NeodoniumClient {
    val ANIM_FACTORY = id("animation")

    init {
//        log.info("Neodonium")
        ClientEvents

        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(ANIM_FACTORY, 42) { ModifierLayer<IAnimation>() }

        MOD_BUS.addListener(::regEntityRenderers)
        MOD_BUS.addListener(::clientInit)
    }

    fun regEntityRenderers(event: EntityRenderersEvent.RegisterRenderers) {
        event.registerEntityRenderer(NeoEntities.THROWN_REBAR.get(), ::ThrownRebarRenderer)
        event.registerEntityRenderer(NeoEntities.THROWN_AZURE_REBAR.get(), ::ThrownRebarRenderer)
    }

    fun clientInit(event: FMLClientSetupEvent) {
        ItemProperties.register(
            NeoItems.GALENA_RIFLE.get(), id("polarity")
        ) { stack, _, _, _ -> if (isScarlet(stack)) 1.0f else 0.0f }
    }
}
