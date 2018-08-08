package com.example.examplemod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie; // import
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent; // import

public class ModEventHandler {

	ModEventHandler(){
		super();
	}
	
	
	@SubscribeEvent
	public void addZombieDrop(LivingDropsEvent event){
		if(event.entityLiving instanceof EntityZombie){
			
			event.drops.add( new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX,event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(ExampleMod.tristoniumIngot)));
		}
		
		
	}
}
