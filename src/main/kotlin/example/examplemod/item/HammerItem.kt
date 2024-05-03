package example.examplemod.item

import com.google.common.collect.ImmutableMultimap
import com.google.common.collect.Multimap
import example.examplemod.util.HAMMER_SWING
import example.examplemod.util.getAnimatablePlayer
import example.examplemod.util.setFadeAnimation
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.ai.attributes.Attribute
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.*
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState


class HammerItem(damage: Double, attackSpeed: Double, properties: Properties) : Item(properties), Vanishable {
    private val defaultModifiers: Multimap<Attribute, AttributeModifier>

    init {
        val builder = ImmutableMultimap.builder<Attribute, AttributeModifier>()
        builder.put(
            Attributes.ATTACK_DAMAGE, AttributeModifier(
                BASE_ATTACK_DAMAGE_UUID, "Tool modifier", damage, AttributeModifier.Operation.ADDITION
            )
        )
        builder.put(
            Attributes.ATTACK_SPEED, AttributeModifier(
                BASE_ATTACK_SPEED_UUID, "Tool modifier", attackSpeed, AttributeModifier.Operation.ADDITION
            )
        )
        this.defaultModifiers = builder.build()
    }

    @Suppress("MagicNumber")
    constructor() : this(10.0, -3.2, Properties().rarity(Rarity.RARE))

    override fun use(world: Level, player: Player, hand: InteractionHand): InteractionResultHolder<ItemStack> {
        if (world.isClientSide) {
            val animPlayer = player.getAnimatablePlayer()

            when (hand) {
                InteractionHand.MAIN_HAND -> animPlayer?.setFadeAnimation(HAMMER_SWING)
                InteractionHand.OFF_HAND -> println("TODO")
            }
        } else {
            player.startUsingItem(hand)
        }
        return super.use(world, player, hand)
    }


//
//    override fun initializeClient(consumer: Consumer<IClientItemExtensions?>) =
//        consumer.accept(NeoUClient.itemRenderProperties)

    override fun getDefaultAttributeModifiers(equipmentSlot: EquipmentSlot): Multimap<Attribute, AttributeModifier> =
        if (equipmentSlot == EquipmentSlot.MAINHAND) this.defaultModifiers
        else super.getDefaultAttributeModifiers(equipmentSlot)


    override fun canAttackBlock(pState: BlockState, pLevel: Level, pPos: BlockPos, pPlayer: Player): Boolean =
        !pPlayer.isCreative

    override fun getUseAnimation(pStack: ItemStack): UseAnim = UseAnim.CUSTOM

    override fun getMaxDamage(stack: ItemStack): Int = 1000

    override fun getUseDuration(pStack: ItemStack): Int = 72000
}
