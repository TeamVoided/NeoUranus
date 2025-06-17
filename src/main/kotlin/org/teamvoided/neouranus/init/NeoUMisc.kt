package org.teamvoided.neouranus.init

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import org.teamvoided.neouranus.misc.DispensableRebar
import org.teamvoided.neouranus.reg.CorrosionReg
import net.minecraft.world.level.block.DispenserBlock
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS


object NeoUMisc {
    init {
        CorrosionReg.registerDefault()
        println("Hello from Misc")

        MOD_BUS.addListener(::miscInit)
    }


    fun miscInit(ignored: FMLCommonSetupEvent){
        DispenserBlock.registerBehavior(ACBlockRegistry.METAL_REBAR.get(), DispensableRebar())
    }

}
