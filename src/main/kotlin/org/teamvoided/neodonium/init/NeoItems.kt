package org.teamvoided.neodonium.init

import com.github.alexmodguy.alexscaves.server.item.ACArmorMaterial
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry
import net.minecraft.sounds.SoundEvents
import net.minecraft.tags.BlockTags
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.SwordItem
import net.minecraft.world.item.Tier
import net.minecraft.world.item.crafting.Ingredient
import net.minecraftforge.common.ForgeTier
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import org.teamvoided.neodonium.Neodonium
import org.teamvoided.neodonium.Neodonium.isModLoaded
import org.teamvoided.neodonium.item.EdibleCaveInfoItem
import org.teamvoided.neodonium.item.GalenaRifle
import org.teamvoided.neodonium.item.HammerItem
import org.teamvoided.neodonium.item.ReinforcedHazmatArmorItem
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject
import vectorwing.farmersdelight.common.item.KnifeItem


object NeoItems {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, Neodonium.ID)

    val REINFORCED_HAZMAT_SUIT_ARMOR_MATERIAL =
        ACArmorMaterial("hazmat_suit", 37, intArrayOf(3, 8, 6, 3), 30, SoundEvents.ARMOR_EQUIP_IRON, 2.25f)
    val SCARLET_NEODYMIUM_MATERIAL = ForgeTier(2, 350, 6.0f, 2.0f, 25, BlockTags.NEEDS_IRON_TOOL) {
        Ingredient.of(ACItemRegistry.SCARLET_NEODYMIUM_INGOT.get())
    }
    val AZURE_NEODYMIUM_MATERIAL = ForgeTier(2, 350, 6.0f, 2.0f, 25, BlockTags.NEEDS_IRON_TOOL) {
        Ingredient.of(ACItemRegistry.AZURE_NEODYMIUM_INGOT.get())
    }


    val creativeTabItems = mutableListOf<ObjectHolderDelegate<Item>>()

    val BASIC_HAMMER = regItem("basic_hammer") { HammerItem() }
    val GALENA_RIFLE = regItem("galena_rifle") { GalenaRifle() }

    val REINFORCED_HAZMAT_MASK = regItem("reinforced_hazmat_mask") { ReinforcedHazmatArmorItem(ArmorItem.Type.HELMET) }
    val REINFORCED_HAZMAT_CHESTPLATE =
        regItem("reinforced_hazmat_chestplate") { ReinforcedHazmatArmorItem(ArmorItem.Type.CHESTPLATE) }
    val REINFORCED_HAZMAT_LEGGINGS =
        regItem("reinforced_hazmat_leggings") { ReinforcedHazmatArmorItem(ArmorItem.Type.LEGGINGS) }
    val REINFORCED_HAZMAT_BOOTS = regItem("reinforced_hazmat_boots") { ReinforcedHazmatArmorItem(ArmorItem.Type.BOOTS) }

    val SCARLET_NEODYMIUM_KNIFE = regItem("scarlet_neodymium_knife") { knife(SCARLET_NEODYMIUM_MATERIAL) }
    val AZURE_NEODYMIUM_KNIFE = regItem("azure_neodymium_knife") { knife(AZURE_NEODYMIUM_MATERIAL) }
    
    val TABLET_FOOD = FoodProperties.Builder().alwaysEat().nutrition(1).build()
    val EDIBLE_CAVE_TABLET =
        regItem("edible_cave_tablet") { EdibleCaveInfoItem(Item.Properties().food(TABLET_FOOD), true) }

    init {
        ITEMS.register(MOD_BUS)
    }

    fun setUp() {
        REINFORCED_HAZMAT_SUIT_ARMOR_MATERIAL.setRepairMaterial(Ingredient.of(ACItemRegistry.POLYMER_PLATE.get()))
    }

    fun knife(tier: Tier): Item {
        return if (isModLoaded("farmersdelight")) KnifeItem(tier, 0.5f, -2.0f, Item.Properties())
        else SwordItem(tier, 3, -2.4F, Item.Properties())
    }

    fun regItem(id: String, creativeTab: Boolean = true, supplier: () -> Item): ObjectHolderDelegate<Item> {
        val item = ITEMS.registerObject(id, supplier)
        if (creativeTab) creativeTabItems.add(item)
        return item
    }
}
