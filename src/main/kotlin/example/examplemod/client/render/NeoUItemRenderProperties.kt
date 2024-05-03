package example.examplemod.client.render

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer
import net.minecraftforge.client.extensions.common.IClientItemExtensions

class NeoUItemRenderProperties : IClientItemExtensions {
    override fun getCustomRenderer(): BlockEntityWithoutLevelRenderer {
        return NeoUItemstackRenderer()
    }


}
