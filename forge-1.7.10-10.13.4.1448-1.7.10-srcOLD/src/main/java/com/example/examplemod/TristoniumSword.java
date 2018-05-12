package com.example.examplemod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class TristoniumSword extends ItemSword {

	public TristoniumSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {

		// when someone swings with my sword...
		// spawn a potato! - do this on the server side
		
		World theWorld = entityLiving.worldObj;
		// check to see if we are running on the server
		if(!theWorld.isRemote){
			entityLiving.dropItem(Items.potato, 1);
			stack.stackSize = 0; 
		}
		
		
		
		
		return super.onEntitySwing(entityLiving, stack);
	}
	
	

}
