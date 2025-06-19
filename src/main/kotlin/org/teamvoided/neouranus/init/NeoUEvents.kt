package org.teamvoided.neouranus.init

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.github.alexmodguy.alexscaves.server.block.blockentity.HologramProjectorBlockEntity
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.DispenserBlock
import net.minecraftforge.event.level.BlockEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import org.teamvoided.neouranus.misc.DispensableRebar
import org.teamvoided.neouranus.mixin.HologramProjectorBlockEntityAccessor
import org.teamvoided.neouranus.reg.CorrosionReg
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS


object NeoUEvents {
    init {
        CorrosionReg.registerDefault()
        println("Hello from Misc")

        MOD_BUS.addListener(::miscInit)
        FORGE_BUS.addListener(::onBreakBlock)
    }


    fun miscInit(ignored: FMLCommonSetupEvent) {
        NeoUItems.setUp()
        DispenserBlock.registerBehavior(ACBlockRegistry.METAL_REBAR.get(), DispensableRebar())
    }

    fun onBreakBlock(event: BlockEvent.BreakEvent) {
        val level = event.level ?: return
        val pos = event.pos ?: return
        if (level.isClientSide) return
        if (level !is Level) return

        val be = level.getBlockEntity(pos)
        if (be !is HologramProjectorBlockEntity) return

        val holo = be as HologramProjectorBlockEntityAccessor
        if (holo.neo_getEntityType() == null) return

        level.addFreshEntity(
            ItemEntity(level, pos.x + 0.5, pos.y + 0.5, pos.z + 0.5, ACItemRegistry.HOLOCODER.get().defaultInstance)
        )
    }

}
