package org.teamvoided.neodonium.misc

import net.minecraft.core.Position
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior
import net.minecraft.world.entity.projectile.AbstractArrow
import net.minecraft.world.entity.projectile.Projectile
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import org.teamvoided.neodonium.entity.ThrownRebar

class DispensableRebar : AbstractProjectileDispenseBehavior() {
    override fun getProjectile(level: Level, pos: Position, stack: ItemStack): Projectile {
        val rebar = ThrownRebar(level, pos.x(), pos.y(), pos.z())
        rebar.pickup = AbstractArrow.Pickup.ALLOWED
        return rebar
    }
}
