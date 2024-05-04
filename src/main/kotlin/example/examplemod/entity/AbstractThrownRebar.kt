package example.examplemod.entity

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.github.alexmodguy.alexscaves.server.misc.ACSoundRegistry
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.projectile.AbstractArrow
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState

abstract class AbstractThrownRebar : AbstractArrow {
    open val rebarType: BlockState = ACBlockRegistry.METAL_REBAR.get().defaultBlockState()

    constructor(type: EntityType<out AbstractArrow>, world: Level) : super(type, world)
    constructor(type: EntityType<out AbstractArrow>, level: Level, x: Double, y: Double, z: Double)
            : super(type, x, y, z, level)

    constructor(type: EntityType<out AbstractArrow>, shooter: LivingEntity, level: Level)
            : super(type, shooter, level)

    override fun getPickupItem(): ItemStack = ItemStack(ACBlockRegistry.METAL_REBAR.get())

    override fun getDefaultHitGroundSoundEvent(): SoundEvent = ACSoundRegistry.SCRAP_METAL_BREAK.get()
}
