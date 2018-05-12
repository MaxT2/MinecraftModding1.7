package maxts2.tutorialmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class WallClimber {

//	@SubscribeEvent
//	public void climbWall(PlayerTickEvent event) {
//
//		EntityPlayer player = event.player;
//
//		if (!player.isCollidedHorizontally) {
//			return;
//		}
//
//		if(player.isBlocking()){
//			player.motionY = -0.5;
//		} else if (player.isSneaking()) {
//			player.motionY = 0;
//		} else {
//			player.motionY = 0.1;
//		}
//
//	}
//
//	@SubscribeEvent
//	public void negateFallDamage(LivingFallEvent event) {
//		if (!(event.entity instanceof EntityPlayer)) {
//			return;
//		}
//
//		event.setCanceled(true);
//	}
}