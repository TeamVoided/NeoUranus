package example.examplemod

import example.examplemod.client.NeoUClient
import example.examplemod.init.*
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

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
