package org.teamvoided.neouranus.emi

import com.github.alexmodguy.alexscaves.AlexsCaves.MODID
import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.github.alexmodguy.alexscaves.server.block.AcidBlock
import com.github.alexmodguy.alexscaves.server.block.fluid.ACFluidRegistry
import dev.emi.emi.api.EmiEntrypoint
import dev.emi.emi.api.EmiPlugin
import dev.emi.emi.api.EmiRegistry
import dev.emi.emi.api.recipe.EmiRecipe
import dev.emi.emi.api.recipe.EmiRecipeCategory
import dev.emi.emi.api.recipe.EmiWorldInteractionRecipe
import dev.emi.emi.api.render.EmiTexture
import dev.emi.emi.api.stack.EmiIngredient
import dev.emi.emi.api.stack.EmiStack
import dev.emi.emi.api.widget.WidgetHolder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.material.Fluids
import org.teamvoided.neouranus.NeoUranus.id
import org.teamvoided.neouranus.NeoUranus.log
import org.teamvoided.neouranus.mixin.AcidBlockAccessor
import java.util.function.Supplier

val CORROSION_WORKSTATION = EmiStack.of(ACFluidRegistry.ACID_FLUID_SOURCE.get())
val CORROSION_CATEGORY = EmiRecipeCategory(id("corrosion"), CORROSION_WORKSTATION)
private fun sid(type: String, name: String): ResourceLocation {
    return id("/$type/$name")
}

@EmiEntrypoint
class NeoEmiPlugin : EmiPlugin {
    override fun register(registry: EmiRegistry) {
        registry.addCategory(CORROSION_CATEGORY);
        registry.addWorkstation(CORROSION_CATEGORY, CORROSION_WORKSTATION);
        registry.addDeferredRecipes { consumer ->
            AcidBlock.doesBlockCorrode(Blocks.AIR.defaultBlockState())
            for ((input, output) in AcidBlockAccessor.neo_CORRODES_INTERACTIONS()) {
                try {
                    val inputItem = input.asItem()
                    val outputItem = output.asItem()
                    consumer.accept(CorrosionRecipe(inputItem, outputItem))
                } catch (_: Exception) {
                    log.error("Failed to fetch item for $input & $output !")
                }
            }
        }

        val water = EmiStack.of(Fluids.WATER, 1000)
        val lava = EmiStack.of(Fluids.LAVA, 1000)
        val acid = EmiStack.of(ACFluidRegistry.ACID_FLUID_SOURCE.get())
        val soda = EmiStack.of(ACFluidRegistry.PURPLE_SODA_FLUID_SOURCE.get())

        val waterCatalyst = water.copy().setRemainder(water)
        val lavaCatalyst = lava.copy().setRemainder(lava)
        val acidCatalyst = acid.copy().setRemainder(acid)
        val sodaCatalyst = soda.copy().setRemainder(soda)

        // Fluids
        addRecipeSafe(registry) {
            EmiWorldInteractionRecipe.builder()
                .id(sid("world/fluid_interaction", "$MODID/mud"))
                .leftInput(acidCatalyst)
                .rightInput(waterCatalyst, true)
                .output(EmiStack.of(Items.MUD))
                .build()
        }
        addRecipeSafe(registry) {
            EmiWorldInteractionRecipe.builder()
                .id(sid("world/fluid_interaction", "$MODID/radrock"))
                .leftInput(acidCatalyst)
                .rightInput(lavaCatalyst, true)
                .output(EmiStack.of(ACBlockRegistry.RADROCK.get()))
                .build()
        }
        addRecipeSafe(registry) {
            EmiWorldInteractionRecipe.builder()
                .id(sid("world/fluid_interaction", "$MODID/blue_rock_candy"))
                .leftInput(sodaCatalyst)
                .rightInput(waterCatalyst, true)
                .output(EmiStack.of(ACBlockRegistry.BLUE_ROCK_CANDY.get()))
                .build()
        }
        addRecipeSafe(registry) {
            EmiWorldInteractionRecipe.builder()
                .id(sid("world/fluid_interaction", "$MODID/orange_rock_candy"))
                .leftInput(sodaCatalyst)
                .rightInput(lavaCatalyst, true)
                .output(EmiStack.of(ACBlockRegistry.ORANGE_ROCK_CANDY.get()))
                .build()
        }
        addRecipeSafe(registry) {
            EmiWorldInteractionRecipe.builder()
                .id(sid("world/fluid_interaction", "$MODID/green_rock_candy"))
                .leftInput(sodaCatalyst)
                .rightInput(acidCatalyst, true)
                .output(EmiStack.of(ACBlockRegistry.GREEN_ROCK_CANDY.get()))
                .build()
        }
    }

    fun addRecipeSafe(registry: EmiRegistry, supplier: Supplier<EmiRecipe>) {
        try {
            registry.addRecipe(supplier.get())
        } catch (e: Throwable) {
            log.error("Exception thrown when parsing EMI recipe (no ID available)", e)
        }
    }
}

class CorrosionRecipe(val input: EmiStack, val output: EmiStack) : EmiRecipe {
    constructor(input: Item, output: Item) : this(EmiStack.of(input), EmiStack.of(output))

    override fun getCategory(): EmiRecipeCategory = CORROSION_CATEGORY
    override fun getId(): ResourceLocation = sid("corrosion", "${input.id.path}_${output.id.path}")
    override fun getInputs(): List<EmiIngredient> = listOf(input)
    override fun getOutputs(): List<EmiStack> = listOf(output)
    override fun getDisplayWidth(): Int = 76
    override fun getDisplayHeight(): Int = 18
    override fun addWidgets(widgets: WidgetHolder) {
        widgets.addTexture(EmiTexture.EMPTY_ARROW, 26, 1)
        widgets.addSlot(input, 0, 0)
        widgets.addSlot(output, 58, 0).recipeContext(this)

    }
}