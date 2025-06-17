package org.teamvoided.neouranus

import com.github.alexmodguy.alexscaves.AlexsCaves
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.teamvoided.neouranus.client.NeoUClient
import org.teamvoided.neouranus.init.*
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.runWhenOn

@Mod(NeoUranus.ID)
object NeoUranus {
    const val ID = "neouranus"

    // the logger for our mod
    val log: Logger = LogManager.getLogger(ID)
    fun id(path: String) = ResourceLocation.fromNamespaceAndPath(ID, path)
    fun mc(id: String) = ResourceLocation.withDefaultNamespace(id)
    fun alexId(path: String) = ResourceLocation.fromNamespaceAndPath(AlexsCaves.MODID, path)

    init {
        log.info("Loading NeoUranus")

        NeoUBlocks
        NeoUItems
        NeoUEntities
        NeoUCreativeTabs
        NeoUMisc

        runWhenOn(Dist.CLIENT) { NeoUClient }
        MOD_BUS.addListener(::commonInit)
    }

    fun commonInit(event: FMLCommonSetupEvent) {
        NeoUItems.setUp()
    }

}
