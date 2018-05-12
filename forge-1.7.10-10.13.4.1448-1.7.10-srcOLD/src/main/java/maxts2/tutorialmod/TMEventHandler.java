// this file is to handle event based code

package maxts2.tutorialmod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class TMEventHandler {
	
	// run when the player logs in
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		
		
		
	}
	
	// run when the player right clicks
	@SubscribeEvent
	public void onRightClick(PlayerInteractEvent event)
	{
		if(event.entityPlayer.getHeldItem() != null && event.entityPlayer.getHeldItem().getItem() == Items.blaze_rod)
		event.entityPlayer.displayGUIChest(event.entityPlayer.getInventoryEnderChest());
		
	}
	
	
	// run when the player climbs a wall
	@SubscribeEvent
	public void climbWall(PlayerTickEvent event) {

		EntityPlayer player = event.player;

		if (!player.isCollidedHorizontally) {
			return;
		}

		if(player.isBlocking()){
			player.motionY = -0.5;
		} else if (player.isSneaking()) {
			player.motionY = 0;
		} else {
			player.motionY = 0.1;
		}

	}

	@SubscribeEvent
	public void negateFallDamage(LivingFallEvent event) {
		if (!(event.entity instanceof EntityPlayer)) {
			return;
		}

		event.setCanceled(true);
	}
	
	
	
	
	
	
	
	
	
	
}
