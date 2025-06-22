package org.teamvoided.neodonium.client


import com.github.alexmodguy.alexscaves.AlexsCaves
import com.github.alexmodguy.alexscaves.server.item.CaveInfoItem
import net.minecraft.client.Minecraft
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn
import net.minecraftforge.client.event.EntityRenderersEvent
import net.minecraftforge.client.event.RegisterColorHandlersEvent
import net.minecraftforge.eventbus.api.IEventBus
import org.teamvoided.neodonium.client.render.entity.ThrownRebarRenderer
import org.teamvoided.neodonium.init.NeoEntities
import org.teamvoided.neodonium.init.NeoItems


@OnlyIn(Dist.CLIENT)
object ClientEvents {

    fun init(bus: IEventBus) {
        bus.addListener(::onRegisterRenderers)
        bus.addListener(::onItemColors)
    }

    fun onRegisterRenderers(event: EntityRenderersEvent.RegisterRenderers) {
        event.registerEntityRenderer(NeoEntities.THROWN_REBAR.get(), ::ThrownRebarRenderer)
        event.registerEntityRenderer(NeoEntities.THROWN_AZURE_REBAR.get(), ::ThrownRebarRenderer)
    }

    fun onItemColors(event: RegisterColorHandlersEvent.Item) {
        AlexsCaves.LOGGER.info("loaded in item colorizer")
        event.register({ stack, colorIn ->
            if (colorIn != 1) -1 else CaveInfoItem.getBiomeColorOf(Minecraft.getInstance().level, stack, false)
        }, NeoItems.EDIBLE_CAVE_TABLET.get())
    }

    /*fun onPoseHand(event: EventPosePlayerHand) {
        val player = event.entityIn as LivingEntity
        val f = Minecraft.getInstance().frameTime
        var leftHammer = 0.0
        var rightHammer = 0.0

        var useProgress: Double

        val hammerHand = player.whichHandHasItem { it is HammerItem }
        if (hammerHand != null && player.isUsingItem && player.useItemRemainingTicks > 0) {
            useProgress =
                (player.getItemInHand(hammerHand).useDuration - (player.useItemRemainingTicks - f + 1.0f)) / 10.0

            val isRightHand = player.mainArm == HumanoidArm.RIGHT
            if (hammerHand == InteractionHand.MAIN_HAND) {
                if (isRightHand) rightHammer = max(rightHammer, useProgress)
                else leftHammer = max(leftHammer, useProgress)
            } else {
                if (isRightHand) leftHammer = max(leftHammer, useProgress)
                else rightHammer = max(rightHammer, useProgress)
            }
        }


        var useProgressMiddle: Double

        if (leftHammer > 0.0f) {
            useProgress = min(1.0, leftHammer)
            useProgressMiddle = sin(useProgress * Math.PI)
            event.model.leftArm.xRot = (useProgress * (Math.toRadians(-180.0) + event.model.head.xRot)).toFloat()
//            event.model.leftArm.yRot = (useProgressMiddle * (Math.toRadians(-25.0) - event.model.head.yRot)).toFloat()
//            event.model.leftArm.zRot = (usei thiProgress * Math.toRadians(50.0) - Math.toRadians(25.0)).toFloat()
            event.result = Event.Result.ALLOW
        }


        if (rightHammer > 0.0f) {
            useProgress = min(1.0, rightHammer)
            useProgressMiddle = sin(useProgress * Math.PI)
//            event.model.rightArm.xRot = (useProgress * (Math.toRadians(-180.0) + event.model.head.xRot)).toFloat()
//            event.model.rightArm.yRot = (useProgress * Math.toRadians(180.0)).toFloat()
            event.model.rightArm.zRot = (useProgress * Math.toRadians(90.0)).toFloat()
            event.model.rightArm
//            event.model.rightArm.yRot = (useProgressMiddle * (Math.toRadians(25.0) - event.model.head.yRot)).toFloat()
//            event.model.rightArm.zRot = (useProgress * -(Math.toRadians(50.0)) + Math.toRadians(25.0)).toFloat()
            event.result = Event.Result.ALLOW
        }


    }*/
}
