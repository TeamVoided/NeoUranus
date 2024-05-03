@file:Suppress("unused")

package example.examplemod.util

import dev.kosmx.playerAnim.api.layered.IAnimation
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer
import dev.kosmx.playerAnim.api.layered.ModifierLayer
import dev.kosmx.playerAnim.api.layered.modifier.AbstractFadeModifier
import dev.kosmx.playerAnim.core.util.Ease
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry
import example.examplemod.client.NeoUClient.ANIM_FACTORY
import net.minecraft.client.player.AbstractClientPlayer
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.InteractionHand
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item

fun LivingEntity.whichHandHasItem(predicate: (Item) -> Boolean): InteractionHand? =
    if (predicate(this.getItemInHand(InteractionHand.MAIN_HAND).item)) InteractionHand.MAIN_HAND
    else if (predicate(this.getItemInHand(InteractionHand.OFF_HAND).item)) InteractionHand.OFF_HAND
    else null


@Suppress("UNCHECKED_CAST")
fun Player.getAnimatablePlayer(): ModifierLayer<IAnimation>? {
    return PlayerAnimationAccess
        .getPlayerAssociatedData(this as AbstractClientPlayer)
        .get(ANIM_FACTORY) as ModifierLayer<IAnimation>?

}

fun ModifierLayer<IAnimation>.setKeyframeAnimation(id: ResourceLocation) {
    this.animation = PlayerAnimationRegistry.getAnimation(id)?.let { KeyframeAnimationPlayer(it) }
}

fun ModifierLayer<IAnimation>.setFadeAnimation(id: ResourceLocation) {
    this.replaceAnimationWithFade(
        AbstractFadeModifier.standardFadeIn(3, Ease.INBACK),
        PlayerAnimationRegistry.getAnimation(id)?.let { KeyframeAnimationPlayer(it) })
}
