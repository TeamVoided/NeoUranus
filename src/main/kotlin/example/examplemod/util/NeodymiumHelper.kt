package example.examplemod.util

import net.minecraft.world.item.ItemStack

fun setPolarity(stack: ItemStack, scarlet: Boolean) {
    val tag = stack.getOrCreateTag()
    tag.putBoolean("Polarity", scarlet)
}

fun isScarlet(stack: ItemStack): Boolean {
    val tag = stack.tag
    return tag?.getBoolean("Polarity") ?: false
}
