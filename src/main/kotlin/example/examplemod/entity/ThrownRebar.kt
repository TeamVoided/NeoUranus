package example.examplemod.entity

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.github.alexmodguy.alexscaves.server.misc.ACSoundRegistry
import example.examplemod.init.NeoUEntities
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.projectile.AbstractArrow
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState

class ThrownRebar : AbstractThrownRebar {
    override val rebarType: BlockState = ACBlockRegistry.METAL_REBAR.get().defaultBlockState()

    constructor(type: EntityType<out AbstractArrow>, world: Level) : super(type, world)
    constructor(world: Level) : this(NeoUEntities.THROWN_REBAR.get(), world)
    constructor(level: Level, x: Double, y: Double, z: Double) : super(NeoUEntities.THROWN_REBAR.get(), level, x, y, z)
    constructor(shooter: LivingEntity, level: Level) : super(NeoUEntities.THROWN_REBAR.get(), shooter, level)

    override fun getPickupItem(): ItemStack = ItemStack(ACBlockRegistry.METAL_REBAR.get())

    override fun getDefaultHitGroundSoundEvent(): SoundEvent = ACSoundRegistry.SCRAP_METAL_BREAK.get()
}
