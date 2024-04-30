package example.examplemod.data.gen.prov

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.simibubi.create.AllBlocks
import example.examplemod.NeoUranus.id
import example.examplemod.init.NeoUBlocks
import net.minecraft.advancements.critereon.InventoryChangeTrigger
import net.minecraft.data.recipes.*
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Blocks
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.registries.ForgeRegistries
import java.util.function.Consumer

@Suppress("MagicNumber", "TooManyFunctions")
class Recipes(event: GatherDataEvent) : RecipeProvider(event.generator.packOutput) {

    private fun key(item: Item): ResourceLocation? = ForgeRegistries.ITEMS.getKey(item)
    private fun name(item: Item): String = key(item)!!.path

    override fun buildRecipes(c: Consumer<FinishedRecipe>) {
        crafting(c)
        stonecutting(c)
        shapeless(c)
    }

    fun crafting(c: Consumer<FinishedRecipe>) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, NeoUBlocks.CUT_BRASS.get(), 4)
            .pattern("##")
            .pattern("##")
            .define('#', AllBlocks.BRASS_BLOCK.get())
            .unlockedBy(AllBlocks.BRASS_BLOCK.get())
            .save(c, NeoUBlocks.CUT_BRASS.get())

    }

    fun shapeless(c: Consumer<FinishedRecipe>) {
        c.waxRecipe(NeoUBlocks.WAXED_COPPER_TILES.get(), NeoUBlocks.COPPER_TILES.get())
        c.waxRecipe(NeoUBlocks.WAXED_EXPOSED_COPPER_TILES.get(), NeoUBlocks.EXPOSED_COPPER_TILES.get())
        c.waxRecipe(NeoUBlocks.WAXED_WEATHERED_COPPER_TILES.get(), NeoUBlocks.WEATHERED_COPPER_TILES.get())
        c.waxRecipe(NeoUBlocks.WAXED_OXIDIZED_COPPER_TILES.get(), NeoUBlocks.OXIDIZED_COPPER_TILES.get())

    }

    fun stonecutting(c: Consumer<FinishedRecipe>) {
        c.stonecuttingResult4(AllBlocks.BRASS_BLOCK.get(), NeoUBlocks.CUT_BRASS.get())
        c.stonecuttingResult4(Blocks.COPPER_BLOCK, NeoUBlocks.COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.EXPOSED_COPPER, NeoUBlocks.EXPOSED_COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.WEATHERED_COPPER, NeoUBlocks.WEATHERED_COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.OXIDIZED_COPPER, NeoUBlocks.OXIDIZED_COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.WAXED_COPPER_BLOCK, NeoUBlocks.WAXED_COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.WAXED_EXPOSED_COPPER, NeoUBlocks.WAXED_EXPOSED_COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.WAXED_WEATHERED_COPPER, NeoUBlocks.WAXED_WEATHERED_COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.WAXED_OXIDIZED_COPPER, NeoUBlocks.WAXED_OXIDIZED_COPPER_TILES.get())

        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoUBlocks.CUT_SCRAP_METAL_ONE.get())
        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoUBlocks.CUT_SCRAP_METAL_TWO.get())
        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoUBlocks.CUT_SCRAP_METAL_THREE.get())
        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoUBlocks.CUT_SCRAP_METAL_FOUR.get())
        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoUBlocks.CUT_SCRAP_METAL_FIVE.get())
        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoUBlocks.CUT_SCRAP_METAL_SIX.get())
        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoUBlocks.CUT_SCRAP_METAL_SEVEN.get())

        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoUBlocks.CUT_RUSTY_SCRAP_METAL_ONE.get())
        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoUBlocks.CUT_RUSTY_SCRAP_METAL_TWO.get())
        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoUBlocks.CUT_RUSTY_SCRAP_METAL_THREE.get())
        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoUBlocks.CUT_RUSTY_SCRAP_METAL_FOUR.get())
        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoUBlocks.CUT_RUSTY_SCRAP_METAL_FIVE.get())
        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoUBlocks.CUT_RUSTY_SCRAP_METAL_SIX.get())
        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoUBlocks.CUT_RUSTY_SCRAP_METAL_SEVEN.get())

    }


    fun Consumer<FinishedRecipe>.waxRecipe(result: ItemLike, ingredient: ItemLike) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result)
            .requires(ingredient)
            .requires(Items.HONEYCOMB)
            .unlockedBy(Items.HONEYCOMB)
            .save(this, result)
    }

    fun Consumer<FinishedRecipe>.stonecuttingResult4(source: ItemLike, result: ItemLike) =
        this.stonecutting(source, result, 4)

    fun Consumer<FinishedRecipe>.stonecutting(
        source: ItemLike, result: ItemLike, resultAmount: Int, category: RecipeCategory = RecipeCategory.DECORATIONS
    ) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(source), category, result.asItem(), resultAmount)
            .unlockedBy(source)
            .save(this, id(name(result.asItem()) + "_from_" + name(source.asItem()) + "_stonecutting"))
    }

    fun RecipeBuilder.unlockedBy(item: ItemLike) = this.unlockedBy(
        "has_${name(item.asItem())}",
        InventoryChangeTrigger.TriggerInstance.hasItems(item)
    )

    fun RecipeBuilder.save(c: Consumer<FinishedRecipe>, item: ItemLike) =
        this.save(c, id(name(item.asItem())))


//    fun SingleItemRecipeBuilder.saveStoneCutting(c: Consumer<FinishedRecipe>, item: ItemLike) =
//        this.save(c, id("${name(item.asItem())}_stonecutting"))

}
