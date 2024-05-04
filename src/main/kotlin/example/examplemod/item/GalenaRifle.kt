package example.examplemod.item

import com.github.alexmodguy.alexscaves.server.misc.ACSoundRegistry
import example.examplemod.entity.ThrownAzureRebar
import example.examplemod.entity.ThrownRebar
import example.examplemod.util.isScarlet
import example.examplemod.util.setPolarity
import net.minecraft.core.BlockPos
import net.minecraft.sounds.SoundSource
import net.minecraft.stats.Stats
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Rarity
import net.minecraft.world.item.Vanishable
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState


class GalenaRifle : Item(Properties().stacksTo(1).rarity(Rarity.UNCOMMON)), Vanishable {

    override fun use(level: Level, player: Player, hand: InteractionHand): InteractionResultHolder<ItemStack> {
        val stack = player.getItemInHand(hand)
        player.startUsingItem(hand)
        if (player.isShiftKeyDown) {
            setPolarity(stack, !isScarlet(stack))
            player.playSound(ACSoundRegistry.RESITOR_SHIELD_SPIN.get())
            return InteractionResultHolder.consume(stack)
        }

        val spearEntity = if (isScarlet(stack)) ThrownRebar(player, level)
        else ThrownAzureRebar(player, level)
        spearEntity.shootFromRotation(player, player.xRot, player.yRot, 0.0f, 5f, 0f)

        level.addFreshEntity(spearEntity)

        level.playSound(
            null, spearEntity, ACSoundRegistry.METAL_BARREL_LID.get(),
            SoundSource.PLAYERS, 1.0f, 1.0f
        )

        player.awardStat(Stats.ITEM_USED[this])


        return InteractionResultHolder.consume(stack)
    }

    override fun canAttackBlock(state: BlockState, world: Level, pos: BlockPos, player: Player): Boolean =
        !player.isCreative

}
