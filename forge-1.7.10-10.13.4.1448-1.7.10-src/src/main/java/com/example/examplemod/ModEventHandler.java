package com.example.examplemod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import ibxm.Player;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class ModEventHandler {
	
	// check for a living entity falling event and negate fall damage
	@SubscribeEvent
	public void negateFallDamage(LivingFallEvent event){
		//if the entity is not a player, do nothing
		if(!(event.entity instanceof EntityPlayer)){
			//do nothing
			return;
		} else {
			// cancel the fall event
			EntityPlayer player = (EntityPlayer) event.entity;
			
			ItemStack[] equippedHelmet =  player.inventory.armorInventory;
			if(equippedHelmet[3] != null && equippedHelmet[3].getItem() instanceof GenericArmor ){
//				player.addPotionEffect(new PotionEffect(Potion.nightVision.id,1000,1));
				event.setCanceled(true);
			}
			
		}
	}
	
	
	//run code when the player hits a wall and make them climb
	@SubscribeEvent
	public void climbWall(PlayerTickEvent event){
		EntityPlayer player = event.player;
		if(!player.isCollidedHorizontally){
			return;	
		}
		if(player.isBlocking()){
			//if the player is blocking, they should fall
			player.motionY = -0.5;
		} else if(player.isSneaking()){
			// if the player is sneaking, they should stop climbing
			player.motionY = 0;
		} else {
			// when coliding, move player up verticaly
			player.motionY = 0.1;		
		}
	}
	
	
	
	
	public void updatePlayerStuff(LivingUpdateEvent event){
		
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			
			if(player.inventory.hasItem(ExampleMod.tristoniumIngot)){
				
//				FMTMethods.setExtraReach();
				
				
				
			}
			
			
			
			
		}
		
		
	}
	
	// player interact event.class
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
















//
//
//@SubscribeEvent
//public void killOnContact(PlayerTickEvent event){
//	// get the player
//	EntityPlayer player = event.player;
//	
//	if(!player.isCollidedHorizontally){
//		return;
//	} else {
//		if(event.player.worldObj.getBlock(event.player.serverPosX, event.player.serverPosY, 
//				event.player.serverPosZ).getMaterial() == Material.glass);
//		player.posX = player.posX + 2;
//		player.setHealth(0);
//	}
//}
