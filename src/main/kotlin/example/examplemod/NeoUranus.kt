package example.examplemod

import example.examplemod.init.NeoUBlocks
import example.examplemod.init.NeoUCreativeTabs
import example.examplemod.init.NeoUItems
import example.examplemod.init.NeoUMisc
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(NeoUranus.ID)
object NeoUranus {
    const val ID = "neouranus"

    // the logger for our mod
    val LOGGER: Logger = LogManager.getLogger(ID)
    fun id(path: String) = ResourceLocation(ID, path)

    init {
        LOGGER.log(Level.INFO, "Hello world!")

        NeoUBlocks.init()
        NeoUItems.init()
        NeoUCreativeTabs.init()
        NeoUMisc

        /*
                val obj = runForDist(
                    clientTarget = {
                        MOD_BUS.addListener(::onClientSetup)
                        Minecraft.getInstance()
                    },
                    serverTarget = {
                        MOD_BUS.addListener(::onServerSetup)
                        "test"
                    })

                println(obj)

         */
    }


    /* private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client...")
    }

    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }
    */
}
