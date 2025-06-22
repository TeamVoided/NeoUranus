package org.teamvoided.neodonium.init

import org.teamvoided.neodonium.Neodonium
import org.teamvoided.neodonium.entity.ThrownAzureRebar
import org.teamvoided.neodonium.entity.ThrownRebar
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.MOD_BUS

object NeoEntities {
    val ENTITIES: DeferredRegister<EntityType<*>> = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Neodonium.ID)

    val THROWN_REBAR = ENTITIES.register("thrown_rebar") {
        EntityType.Builder.of(::ThrownRebar, MobCategory.MISC)
            .sized(0.3f, 0.3f)
            .setUpdateInterval(1)
            .setShouldReceiveVelocityUpdates(true)
            .build("thrown_rebar")
    }
    val THROWN_AZURE_REBAR = ENTITIES.register("thrown_azure_rebar") {
        EntityType.Builder.of(::ThrownAzureRebar, MobCategory.MISC)
            .sized(0.3f, 0.3f)
            .setUpdateInterval(1)
            .setShouldReceiveVelocityUpdates(true)
            .build("thrown_azure_rebar")
    }

    init {
        ENTITIES.register(MOD_BUS)
    }
}
