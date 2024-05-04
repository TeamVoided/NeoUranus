package example.examplemod.entity

import com.github.alexmodguy.alexscaves.client.particle.ACParticleRegistry
import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.github.alexmodguy.alexscaves.server.entity.item.MovingMetalBlockEntity
import com.github.alexmodguy.alexscaves.server.entity.util.FallingBlockEntityAccessor
import com.github.alexmodguy.alexscaves.server.entity.util.MagnetUtil
import com.github.alexmodguy.alexscaves.server.misc.ACSoundRegistry
import example.examplemod.init.NeoUEntities
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntitySelector
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.projectile.AbstractArrow
import net.minecraft.world.entity.projectile.Projectile
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.AABB
import net.minecraft.world.phys.Vec3
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sqrt

class ThrownAzureRebar : AbstractThrownRebar {
    override val rebarType: BlockState = ACBlockRegistry.RUSTY_REBAR.get().defaultBlockState()
    private val range = 4.0

    constructor(type: EntityType<out AbstractArrow>, world: Level) : super(type, world)
    constructor(world: Level) : this(NeoUEntities.THROWN_AZURE_REBAR.get(), world)
    constructor(level: Level, x: Double, y: Double, z: Double)
            : super(NeoUEntities.THROWN_AZURE_REBAR.get(), level, x, y, z)

    constructor(shooter: LivingEntity, level: Level) : super(NeoUEntities.THROWN_AZURE_REBAR.get(), shooter, level)

    override fun getPickupItem(): ItemStack = ItemStack(ACBlockRegistry.RUSTY_REBAR.get())

    override fun getDefaultHitGroundSoundEvent(): SoundEvent = ACSoundRegistry.SCRAP_METAL_BREAK.get()

    override fun tick() {
        super.tick()
        val world = this.level()
        if (world.random.nextInt(5) == 0) {
            world.addParticle(
                ACParticleRegistry.AZURE_MAGNETIC_ORBIT.get(),
                this.x, this.y, this.z,
                this.x, this.y, this.z
            )
        }
        if (this.inGround) {
            val entities = world.getEntitiesOfClass(Entity::class.java, getRangeBB(), EntitySelector.NO_SPECTATORS)
            entities.forEach { pushEntity(it) }
        }
    }

    fun getRangeBB(): AABB {
        return AABB.ofSize(this.position(), range, range, range)
    }


    private fun pushEntity(entity: Entity) {
        var strength = 0.2
        val prev = entity.deltaMovement
        val blockVec = this.position()
        var push = entity.position().subtract(blockVec)
        if (push.length() > 1.0) {
            push = push.normalize()
        }

        if (entity is MovingMetalBlockEntity) {
            val distance = sqrt(entity.distanceToSqr(blockVec))
            strength = 0.04

            val f = range - 1.0
            val f1 = (f - distance + 1.0) / f
            strength *= max(f1, 0.0)


            entity.setPlacementCooldown(2)
        }

        if (entity is FallingBlockEntityAccessor) {
            entity.setFallBlockingTime()
            strength = 0.04
            entity.deltaMovement = prev.multiply(0.5, 0.5, 0.5)
        }

        if (entity is LivingEntity || entity is Projectile) {
            strength = 0.05
            if (abs(push.x) > abs(push.y) && abs(push.x) > abs(push.z)) {
                push = Vec3(push.x, 0.0, 0.0)
            }
            if (abs(push.y) > abs(push.x) && abs(push.y) > abs(push.z)) {
                push = Vec3(0.0, push.y, 0.0)
            }
            if (abs(push.z) > abs(push.x) && abs(push.z) > abs(push.y)) {
                push = Vec3(0.0, 0.0, push.z)
            }

            entity.fallDistance = 0.0f
        }

        if (!MagnetUtil.isEntityOnMovingMetal(entity)) {
            entity.deltaMovement =
                entity.deltaMovement.add(
                    strength * push.x,
                    strength * push.y,
                    strength * push.z
                )
        }

    }
}

