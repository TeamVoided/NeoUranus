package org.teamvoided.neodonium.data.gen.prov

import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry
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
import org.teamvoided.neodonium.Neodonium.id
import org.teamvoided.neodonium.init.NeoBlocks
import org.teamvoided.neodonium.init.NeoItems
import java.util.function.Consumer

@Suppress("MagicNumber", "TooManyFunctions")
class Recipes(event: GatherDataEvent) : RecipeProvider(event.generator.packOutput) {

    private fun key(item: Item): ResourceLocation? = ForgeRegistries.ITEMS.getKey(item)
    private fun name(item: Item): String = key(item)!!.path

    override fun buildRecipes(c: Consumer<FinishedRecipe>) {
        crafting(c)
        stonecutting(c)
        shapeless(c)
        smithing(c)
    }

    fun crafting(c: Consumer<FinishedRecipe>) {
         ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, NeoItems.SCARLET_NEODYMIUM_KNIFE.get())
             .pattern("#")
             .pattern("I")
             .define('#', ACItemRegistry.SCARLET_NEODYMIUM_INGOT.get())
             .define('I', Items.STICK)
             .unlockedBy(ACItemRegistry.SCARLET_NEODYMIUM_INGOT.get())
             .save(c, NeoItems.SCARLET_NEODYMIUM_KNIFE.get())
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, NeoItems.AZURE_NEODYMIUM_KNIFE.get())
            .pattern("#")
            .pattern("I")
            .define('#', ACItemRegistry.AZURE_NEODYMIUM_INGOT.get())
            .define('I', Items.STICK)
            .unlockedBy(ACItemRegistry.AZURE_NEODYMIUM_INGOT.get())
            .save(c, NeoItems.AZURE_NEODYMIUM_KNIFE.get())
    }

    fun shapeless(c: Consumer<FinishedRecipe>) {
        c.waxRecipe(NeoBlocks.WAXED_COPPER_TILES.get(), NeoBlocks.COPPER_TILES.get())
        c.waxRecipe(NeoBlocks.WAXED_EXPOSED_COPPER_TILES.get(), NeoBlocks.EXPOSED_COPPER_TILES.get())
        c.waxRecipe(NeoBlocks.WAXED_WEATHERED_COPPER_TILES.get(), NeoBlocks.WEATHERED_COPPER_TILES.get())
        c.waxRecipe(NeoBlocks.WAXED_OXIDIZED_COPPER_TILES.get(), NeoBlocks.OXIDIZED_COPPER_TILES.get())

    }

    fun stonecutting(c: Consumer<FinishedRecipe>) {
        c.stonecuttingResult4(Blocks.COPPER_BLOCK, NeoBlocks.COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.EXPOSED_COPPER, NeoBlocks.EXPOSED_COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.WEATHERED_COPPER, NeoBlocks.WEATHERED_COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.OXIDIZED_COPPER, NeoBlocks.OXIDIZED_COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.WAXED_COPPER_BLOCK, NeoBlocks.WAXED_COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.WAXED_EXPOSED_COPPER, NeoBlocks.WAXED_EXPOSED_COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.WAXED_WEATHERED_COPPER, NeoBlocks.WAXED_WEATHERED_COPPER_TILES.get())
        c.stonecuttingResult4(Blocks.WAXED_OXIDIZED_COPPER, NeoBlocks.WAXED_OXIDIZED_COPPER_TILES.get())

        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoBlocks.CUT_SCRAP_METAL.get())
        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoBlocks.SCRAP_METAL_BRICKS.get())
        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoBlocks.INVERTED_SCRAP_METAL_BRICKS.get())
        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoBlocks.VERTICALLY_CUT_SCRAP_METAL.get())
        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoBlocks.FORMED_SCRAP_METAL.get())
        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoBlocks.REVERSE_FORMED_SCRAP_METAL.get())
        c.stonecuttingResult4(ACBlockRegistry.SCRAP_METAL.get(), NeoBlocks.SCRAP_METAL_TILES.get())

        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoBlocks.RUSTY_CUT_SCRAP_METAL.get())
        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoBlocks.RUSTY_SCRAP_METAL_BRICKS.get())
        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoBlocks.RUSTY_INVERTED_SCRAP_METAL_BRICKS.get())
        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoBlocks.RUSTY_VERTICALLY_CUT_SCRAP_METAL.get())
        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoBlocks.RUSTY_FORMED_SCRAP_METAL.get())
        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoBlocks.RUSTY_REVERSE_FORMED_SCRAP_METAL.get())
        c.stonecuttingResult4(ACBlockRegistry.RUSTY_SCRAP_METAL.get(), NeoBlocks.RUSTY_SCRAP_METAL_TILES.get())

    }

    fun smithing(c: Consumer<FinishedRecipe>) {
        netheriteSmithing(
            c, ACItemRegistry.HAZMAT_MASK.get(), RecipeCategory.COMBAT, NeoItems.REINFORCED_HAZMAT_MASK.get()
        )
        netheriteSmithing(
            c, ACItemRegistry.HAZMAT_CHESTPLATE.get(),
            RecipeCategory.COMBAT, NeoItems.REINFORCED_HAZMAT_CHESTPLATE.get()
        )
        netheriteSmithing(
            c, ACItemRegistry.HAZMAT_LEGGINGS.get(), RecipeCategory.COMBAT, NeoItems.REINFORCED_HAZMAT_LEGGINGS.get()
        )
        netheriteSmithing(
            c, ACItemRegistry.HAZMAT_BOOTS.get(), RecipeCategory.COMBAT, NeoItems.REINFORCED_HAZMAT_BOOTS.get()
        )
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
        source: ItemLike, result: ItemLike, resultAmount: Int, category: RecipeCategory = RecipeCategory.DECORATIONS,
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
