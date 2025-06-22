package org.teamvoided.neodonium.item

import com.github.alexmodguy.alexscaves.server.item.CaveInfoItem
import com.github.alexmodguy.alexscaves.server.misc.ACSoundRegistry
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class EdibleCaveInfoItem(properties: Properties, hideCaveId: Boolean) : CaveInfoItem(properties, hideCaveId) {
    override fun use(level: Level, player: Player, hand: InteractionHand): InteractionResultHolder<ItemStack?> {
        val stack: ItemStack = player.getItemInHand(hand)
        if (stack.isEdible) {
            if (player.canEat(stack.getFoodProperties(player)!!.canAlwaysEat())) {
                player.startUsingItem(hand)
                return InteractionResultHolder.consume(stack)
            } else {
                return InteractionResultHolder.fail(stack)
            }
        }
        return super.use(level, player, hand)
    }

    override fun getEatingSound(): SoundEvent = ACSoundRegistry.SPELUNKERY_TABLE_CRACK.get()
}
