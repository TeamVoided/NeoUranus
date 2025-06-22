package org.teamvoided.neodonium.item

import com.github.alexmodguy.alexscaves.client.particle.ACParticleRegistry
import com.github.alexmodguy.alexscaves.server.item.HazmatArmorItem
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.tags.DamageTypeTags
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.phys.Vec3
import org.teamvoided.neodonium.Neodonium.id
import org.teamvoided.neodonium.init.NeoItems.REINFORCED_HAZMAT_SUIT_ARMOR_MATERIAL
import kotlin.math.cos

class ReinforcedHazmatArmorItem(armorMaterial: ArmorMaterial, slot: Type) : HazmatArmorItem(armorMaterial, slot) {
    constructor(slot: Type) : this(REINFORCED_HAZMAT_SUIT_ARMOR_MATERIAL, slot)

    override fun isFireResistant(): Boolean = true
    override fun canBeHurtBy(pDamageSource: DamageSource): Boolean = !pDamageSource.`is`(DamageTypeTags.IS_FIRE)

    override fun onArmorTick(stack: ItemStack, level: Level, player: Player) {
        if (stack.item is ArmorItem && (stack.item as ArmorItem).getType() == Type.HELMET && cos((player.tickCount.toFloat() * 0.05f).toDouble()) >= 0.9) {
            val eyes = player.eyePosition
            if (level.random.nextBoolean()) {
                val leftOffset =
                    (Vec3(0.25, -0.3, 0.25)).xRot(Math.toRadians((-player.xRot).toDouble()).toFloat()).yRot(
                        Math.toRadians((-player.getYHeadRot()).toDouble()).toFloat()
                    )
                level.addParticle(
                    ACParticleRegistry.BLUE_HAZMAT_BREATHE.get() as ParticleOptions,
                    eyes.x + leftOffset.x,
                    eyes.y + leftOffset.y,
                    eyes.z + leftOffset.z,
                    ((level.random.nextFloat() - 0.5f) * 0.1f).toDouble(),
                    ((level.random.nextFloat() - 0.5f) * 0.1f).toDouble(),
                    ((level.random.nextFloat() - 0.5f) * 0.1f).toDouble()
                )
            }

            if (level.random.nextBoolean()) {
                val rightOffset =
                    (Vec3(-0.25, -0.3, 0.25)).xRot(Math.toRadians((-player.xRot).toDouble()).toFloat()).yRot(
                        Math.toRadians((-player.getYHeadRot()).toDouble()).toFloat()
                    )
                level.addParticle(
                    ACParticleRegistry.BLUE_HAZMAT_BREATHE.get() as ParticleOptions,
                    eyes.x + rightOffset.x,
                    eyes.y + rightOffset.y,
                    eyes.z + rightOffset.z,
                    ((level.random.nextFloat() - 0.5f) * 0.1f).toDouble(),
                    ((level.random.nextFloat() - 0.5f) * 0.1f).toDouble(),
                    ((level.random.nextFloat() - 0.5f) * 0.1f).toDouble()
                )
            }
        }
    }

    override fun getArmorTexture(stack: ItemStack?, entity: Entity?, slot: EquipmentSlot?, type: String?): String? {
        return (
                if (slot == EquipmentSlot.LEGS) id("textures/armor/reinforced_hazmat_suit_1.png")
                else id("textures/armor/reinforced_hazmat_suit_0.png")
                ).toString()

    }

}