package example.examplemod.init

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import example.examplemod.misc.DispensableRebar
import example.examplemod.reg.CorrosionReg
import net.minecraft.world.level.block.DispenserBlock
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS


object NeoUMisc {
    init {
        CorrosionReg.registerDefault()
        CorrosionReg.registerCreate()
        println("Hello from Misc")

        MOD_BUS.addListener(::miscInit)
    }


    fun miscInit(ignored: FMLCommonSetupEvent){
        DispenserBlock.registerBehavior(ACBlockRegistry.METAL_REBAR.get(), DispensableRebar())
    }

}
