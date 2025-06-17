package org.teamvoided.neouranus.data.gen

import org.teamvoided.neouranus.NeoUranus
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import org.teamvoided.neouranus.data.gen.prov.BlockStates
import org.teamvoided.neouranus.data.gen.prov.BlockTags
import org.teamvoided.neouranus.data.gen.prov.EnglishLanguage
import org.teamvoided.neouranus.data.gen.prov.ItemModels
import org.teamvoided.neouranus.data.gen.prov.ItemTags
import org.teamvoided.neouranus.data.gen.prov.LootTables
import org.teamvoided.neouranus.data.gen.prov.Recipes


@Suppress("unused")
@Mod.EventBusSubscriber(modid = NeoUranus.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object DataGenerators {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        val generator = event.generator

        val blockTags = BlockTags(event)

       /* try {
            val enabledField = fh.javaClass.getDeclaredField("enable")
            enabledField.isAccessible = true
            enabledField.setBoolean(fh, false)
        } catch (e: Exception) {
            println("Error setting enable to false: ${e.message}")
        }*/

        generator.addProvider(event.includeServer(), blockTags)
        generator.addProvider(event.includeServer(), ItemTags(event, blockTags))
//        generator.addProvider(event.includeServer(), EntityTags(generator.packOutput, FarmersDelight.MODID, helper))
        generator.addProvider(event.includeServer(), Recipes(event))
//        generator.addProvider(event.includeServer(), Advancements(generator))
        val blockStates = BlockStates(event)
        generator.addProvider(event.includeClient(), blockStates)
        generator.addProvider(event.includeClient(), ItemModels(event, blockStates.models().existingFileHelper))

        generator.addProvider(event.includeClient(), EnglishLanguage(event))
        generator.addProvider(event.includeClient(), LootTables(event))
    }
}
