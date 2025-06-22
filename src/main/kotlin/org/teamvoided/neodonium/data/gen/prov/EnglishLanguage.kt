@file:Suppress("DEPRECATION")

package org.teamvoided.neodonium.data.gen.prov

import org.teamvoided.neodonium.Neodonium
import org.teamvoided.neodonium.init.NeoItems
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraftforge.common.data.LanguageProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.registries.ForgeRegistries
import org.apache.commons.lang3.text.WordUtils


class EnglishLanguage(event: GatherDataEvent) : LanguageProvider(event.generator.packOutput, Neodonium.ID, "en_us") {
    val items = NeoItems.creativeTabItems + listOf()

    public override fun addTranslations() {
        items.forEach { add(it.get().descriptionId, genLang(id(it.get().asItem()))) }
        add("emi.category.neodonium.corrosion", "Corrosion")
    }

    private fun genLang(id: ResourceLocation): String = WordUtils.capitalize(id.path.replace("_", " "))


    private fun id(item: Item): ResourceLocation = ForgeRegistries.ITEMS.getKey(item)!!
}
