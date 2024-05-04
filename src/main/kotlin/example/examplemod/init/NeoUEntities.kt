package example.examplemod.init

import example.examplemod.NeoUranus
import example.examplemod.entity.ThrownAzureRebar
import example.examplemod.entity.ThrownRebar
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.MOD_BUS

object NeoUEntities {
    val ENTITIES: DeferredRegister<EntityType<*>> = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NeoUranus.ID)

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
