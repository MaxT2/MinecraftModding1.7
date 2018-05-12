package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class TNTWand extends Item {

	public TNTWand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {


		// get the block the player is look at
		MovingObjectPosition mop = Minecraft.getMinecraft().renderViewEntity.rayTrace(200, 1.0f);
		// get x,y and z postion of block the ray hit
		int targX = mop.blockX;
		int targY = mop.blockY;
		int targZ = mop.blockZ;
		
		if(!world.isRemote){
		// replace that block with something else
		world.setBlock(targX, targY, targZ, Blocks.tnt);
		}
		
		
		return super.onItemRightClick(item, world, player);
	}
	
	
	
	
	
	
	
}
