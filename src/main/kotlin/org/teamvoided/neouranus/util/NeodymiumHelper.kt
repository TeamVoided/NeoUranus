package org.teamvoided.neouranus.util

import net.minecraft.world.item.ItemStack

fun setPolarity(stack: ItemStack, scarlet: Boolean) {
    val tag = stack.getOrCreateTag()
    tag.putBoolean("polarity", scarlet)
}

fun isScarlet(stack: ItemStack): Boolean {
    val tag = stack.tag
    return tag?.getBoolean("polarity") ?: false
}
