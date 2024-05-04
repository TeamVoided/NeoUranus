package example.examplemod.client.render.entity

import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.math.Axis
import example.examplemod.entity.AbstractThrownRebar
import example.examplemod.util.EMPTY_TEXTURE
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.entity.EntityRenderer
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.client.renderer.texture.OverlayTexture
import net.minecraft.util.Mth
import net.minecraftforge.client.model.data.ModelData

class ThrownRebarRenderer(cxt: EntityRendererProvider.Context) : EntityRenderer<AbstractThrownRebar>(cxt) {
    private val blockerRenderer = cxt.blockRenderDispatcher

    @Suppress("MagicNumber")
    override fun render(
        entity: AbstractThrownRebar,
        yaw: Float, partialTick: Float, poseStack: PoseStack,
        buffer: MultiBufferSource, light: Int
    ) {
        poseStack.pushPose()
        poseStack.translate(-OFFSET.toDouble(), 0.0, -OFFSET.toDouble())

        poseStack.rotateAround(
            Axis.YP.rotationDegrees(Mth.lerp(partialTick, entity.yRotO, entity.yRot)),
            OFFSET, 0f, OFFSET
        )
        poseStack.rotateAround(
            Axis.XN.rotationDegrees(Mth.lerp(partialTick, entity.xRotO, entity.xRot) + 90),
            OFFSET, 0f, OFFSET
        )

        poseStack.translate(0.0, -.1, 0.0)

        blockerRenderer.renderSingleBlock(
            entity.rebarType, poseStack, buffer, light, OverlayTexture.NO_OVERLAY, ModelData.EMPTY, RenderType.solid()
        )
        poseStack.popPose()
        super.render(entity, yaw, partialTick, poseStack, buffer, light)
    }

    override fun getTextureLocation(entity: AbstractThrownRebar) = EMPTY_TEXTURE

    companion object {
        const val OFFSET = 0.5f
    }
}
