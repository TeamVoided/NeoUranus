package org.teamvoided.neouranus.item

import com.github.alexmodguy.alexscaves.server.item.HazmatArmorItem
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.ItemStack
import org.teamvoided.neouranus.NeoUranus.id
import org.teamvoided.neouranus.init.NeoUItems.REINFORCED_HAZMAT_SUIT_ARMOR_MATERIAL

class ReinforcedHazmatArmorItem(armorMaterial: ArmorMaterial, slot: Type) : HazmatArmorItem(armorMaterial, slot) {
    constructor(slot: Type) : this(REINFORCED_HAZMAT_SUIT_ARMOR_MATERIAL, slot)

    override fun getArmorTexture(stack: ItemStack?, entity: Entity?, slot: EquipmentSlot?, type: String?): String? {
        return (
                if (slot == EquipmentSlot.LEGS) id("textures/armor/reinforced_hazmat_suit_1.png")
                else id("textures/armor/reinforced_hazmat_suit_0.png")
                ).toString()

    }

}