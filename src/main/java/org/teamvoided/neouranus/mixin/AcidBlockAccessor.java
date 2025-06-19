package org.teamvoided.neouranus.mixin;

import com.github.alexmodguy.alexscaves.server.block.AcidBlock;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(AcidBlock.class)
public interface AcidBlockAccessor {
    @Accessor("CORRODES_INTERACTIONS")
    static Map<Block, Block> neo_CORRODES_INTERACTIONS() {
        throw new IllegalStateException();
    }
}
