package example.examplemod.client.render.item

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.world.item.ItemDisplayContext
import net.minecraft.world.item.ItemStack

class NeoUItemstackRenderer : BlockEntityWithoutLevelRenderer(null, null) {

    override fun renderByItem(
        stack: ItemStack,
        transformType: ItemDisplayContext,
        poseStack: PoseStack,
        buffer: MultiBufferSource,
        packedLight: Int,
        packedOverlay: Int
    ) {
//        val heldIn3d = transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND
//                || transformType == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND
//                || transformType == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND
//                || transformType == ItemDisplayContext.FIRST_PERSON_LEFT_HAND
//
//        if (stack.item is HammerItem) {
//            poseStack.pushPose()
//            poseStack.translate(0.0f, 0.25f, 0.125f)
//        }
    }
}
