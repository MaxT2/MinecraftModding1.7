package com.examplemod.examplemod.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ExampleHandler {

	public ExampleHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@SubscribeEvent
	public void onUpdate(PlayerTickEvent event){
		
		if(event.player.ticksExisted == 20%0){
		System.out.println(event.player.motionY);
		}
		
	}
	

}
