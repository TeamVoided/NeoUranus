package org.teamvoided.neodonium.data.gen

import net.minecraft.data.DataGenerator
import net.minecraft.data.DataProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import org.teamvoided.neodonium.Neodonium
import org.teamvoided.neodonium.data.gen.prov.*


@Suppress("unused")
@Mod.EventBusSubscriber(modid = Neodonium.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object DataGenerators {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        val generator = event.generator
        val fh = event.existingFileHelper

        try {
            val enabledField = fh.javaClass.getDeclaredField("enable")
            enabledField.isAccessible = true
            enabledField.setBoolean(fh, false)
        } catch (e: Exception) {
            println("Error setting enable to false: ${e.message}")
        }

        val blockTags = BlockTags(event, fh)
        generator.addProvider(blockTags)
        generator.addProvider(NeoItemTags(event, blockTags))
//        generator.addProvider( EntityTags(generator.packOutput, FarmersDelight.MODID, helper))
        generator.addProvider(Recipes(event))
//        generator.addProvider( Advancements(generator))
        val blockStates = BlockStates(event)
        generator.addProvider(blockStates)
        generator.addProvider(ItemModels(event, fh))

        generator.addProvider(EnglishLanguage(event))
        generator.addProvider(LootTables(event))
    }

    fun <T : DataProvider> DataGenerator.addProvider(provider: T): T = this.addProvider(true, provider)
}
