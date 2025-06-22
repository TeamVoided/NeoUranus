package org.teamvoided.neodonium

import com.github.alexmodguy.alexscaves.AlexsCaves
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.ModList
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.teamvoided.neodonium.client.NeodoniumClient
import org.teamvoided.neodonium.init.*
import thedarkcolour.kotlinforforge.forge.runWhenOn

@Mod(Neodonium.ID)
object Neodonium {
    const val ID = "neodonium"

    // the logger for our mod
    val log: Logger = LogManager.getLogger(ID)
    fun id(path: String) = ResourceLocation.fromNamespaceAndPath(ID, path)
    fun mc(id: String) = ResourceLocation.withDefaultNamespace(id)
    fun alexId(path: String) = ResourceLocation.fromNamespaceAndPath(AlexsCaves.MODID, path)
    fun isModLoaded(modId: String): Boolean = ModList.get().isLoaded(modId)

    init {
        log.info("Loading Neodonium")

        NeoBlocks
        NeoItems
        NeoEntities
        NeoCreativeTabs
        NeoEvents

        runWhenOn(Dist.CLIENT) { NeodoniumClient }
    }

}
