package org.teamvoided.neouranus.mixin;

import com.github.alexmodguy.alexscaves.server.block.AcidBlock;
import example.examplemod.reg.CorrosionReg;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(AcidBlock.class)
public class AcidBlockAccessor {
    @Shadow(remap = false)
    private static Map<Block, Block> CORRODES_INTERACTIONS;

    @Unique
    @Inject(method = "initCorrosion()V", at = @At("TAIL"), remap = false)
    private static void neoUranus$registerCorrosion(CallbackInfo ci) {
        if (CORRODES_INTERACTIONS != null) {
            CorrosionReg.getCorrosionRegBlocks().forEach((i, o) -> CORRODES_INTERACTIONS.putIfAbsent(i.get(), o.get()));
            CorrosionReg.getCorrosionBlocks().forEach((i, o) -> CORRODES_INTERACTIONS.putIfAbsent(i.get(), o.get()));
        }
    }
}
