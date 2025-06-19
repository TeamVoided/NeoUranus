package org.teamvoided.neouranus.mixin;

import com.github.alexmodguy.alexscaves.server.block.blockentity.HologramProjectorBlockEntity;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HologramProjectorBlockEntity.class)
public interface HologramProjectorBlockEntityAccessor {

    @Accessor("entityType")
    EntityType<?> neo_getEntityType();
}
