package example.examplemod.client


import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn


@OnlyIn(Dist.CLIENT)
object ClientEvents {

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
