package example.examplemod.misc

import example.examplemod.entity.ThrownRebar
import net.minecraft.core.BlockSource
import net.minecraft.core.Direction
import net.minecraft.core.dispenser.DispenseItemBehavior
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.DispenserBlock

class DispensableRebar : DispenseItemBehavior {
    override fun dispense(source: BlockSource, stack: ItemStack): ItemStack {
        val direction: Direction = source.blockState.getValue(DispenserBlock.FACING)
        val world = source.level
        val pos = source.pos.offset(direction.normal)

        val rebar = ThrownRebar(world)
        rebar.shoot(pos.x + 0.5, pos.y + .5, pos.z + .5, 0.5f, 0f)
        world.addFreshEntity(rebar)
        return stack
    }
}
