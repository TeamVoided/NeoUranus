package org.teamvoided.neodonium.client.render.item

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer
import net.minecraftforge.client.extensions.common.IClientItemExtensions

class NeoItemRenderProperties : IClientItemExtensions {
    override fun getCustomRenderer(): BlockEntityWithoutLevelRenderer {
        return NeoItemstackRenderer()
    }


}
