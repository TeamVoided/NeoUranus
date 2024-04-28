package example.examplemod.data.gen

import example.examplemod.NeoUranus
import example.examplemod.data.gen.prov.BlockTags
import example.examplemod.data.gen.prov.ItemTags
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod


@Suppress("unused")
@Mod.EventBusSubscriber(modid = NeoUranus.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object DataGenerators {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        val generator = event.generator

        val blockTags = BlockTags(event)
        generator.addProvider(event.includeServer(), blockTags)
        generator.addProvider(event.includeServer(), ItemTags(event, blockTags))
//        generator.addProvider(event.includeServer(), EntityTags(generator.packOutput, FarmersDelight.MODID, helper))
//        generator.addProvider(event.includeServer(), Recipes(generator.packOutput))
//        generator.addProvider(event.includeServer(), Advancements(generator))
//
//        val blockStates = BlockStates(generator, helper)
//        generator.addProvider(event.includeClient(), blockStates)
//        generator.addProvider(event.includeClient(), ItemModels(generator, blockStates.models().existingFileHelper))
    }
}
