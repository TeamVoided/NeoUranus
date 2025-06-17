package org.teamvoided.neouranus

import org.teamvoided.neouranus.client.NeoUClient
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.teamvoided.neouranus.init.NeoUBlocks
import org.teamvoided.neouranus.init.NeoUCreativeTabs
import org.teamvoided.neouranus.init.NeoUEntities
import org.teamvoided.neouranus.init.NeoUItems
import org.teamvoided.neouranus.init.NeoUMisc

@Mod(NeoUranus.ID)
object NeoUranus {
    const val ID = "neouranus"

    // the logger for our mod
    val log: Logger = LogManager.getLogger(ID)
    fun id(path: String) = ResourceLocation(ID, path)

    init {
        log.info("Loading NeoUranus")

        NeoUBlocks
        NeoUItems
        NeoUEntities
        NeoUCreativeTabs
        NeoUMisc


        NeoUClient
    }
}
