package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class TestWand extends Item {

	public TestWand() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		// TODO Auto-generated method stub
		
		
		player.getEntityAttribute(null);
		
		item.stackSize = item.stackSize - 1;
		
		
//		if(world.isRemote){
//			EntityFireworkRocket firework = new EntityFireworkRocket(world);
//			Vec3 looking = player.getLookVec();
//			 if (looking != null) {
////			 firework.motionX = looking.xCoord;
////			 firework.motionY = looking.yCoord;
////			 firework.motionZ = looking.zCoord;
////			 firework.accelerationX = firework.motionX * 0.1D;
////			 firework.accelerationY = firework.motionY * 0.1D;
////			 firework.accelerationZ = firework.motionZ * 0.1D;
//			 }
////			world.spawnEntityInWorld(firework);
//			 
//		}
		
		
		
		if(!world.isRemote){
			Block blockLookingAt = null;
			MovingObjectPosition mop = Minecraft.getMinecraft().renderViewEntity.rayTrace(200,  1.0f);
			if(mop != null){
				int blockHitSide = mop.sideHit;
				blockLookingAt = world.getBlock(mop.blockX, mop.blockY, mop.blockZ);
				
			}
			
			int targX = mop.blockX;
			int targY = mop.blockY;
			int targZ = mop.blockZ;
			
			if(blockLookingAt != null){
				for(int offset = 0; offset < 20; offset++ ){
				
				world.setBlock(targX+offset, targY + offset, targZ, Blocks.tnt);

				}
				
			}
			
//			world.setBlock(targX, targY+1, targZ, Blocks.tnt);
//			world.setBlock(targX, targY+2, targZ, Blocks.tnt);
//			world.setBlock(targX, targY+3, targZ, Blocks.tnt);
//			world.setBlock(targX, targY+4, targZ, Blocks.tnt);
			
//			world.createExplosion(player, targX, targY, targZ, 99.0f, true);
			
			
		}
		
		
		return super.onItemRightClick(item, world, player);
	}
	

}














//@Override
//public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
//	// TODO Auto-generated method stub
//	
//	
//	if(!world.isRemote){
//		EntityWitherSkull witherScull = new EntityWitherSkull(world, player, 0, 0, 0);
//		Vec3 looking = player.getLookVec();
//		 if (looking != null) {
//		 witherScull.motionX = looking.xCoord;
//		 witherScull.motionY = looking.yCoord;
//		 witherScull.motionZ = looking.zCoord;
//		 witherScull.accelerationX = witherScull.motionX * 0.1D;
//		 witherScull.accelerationY = witherScull.motionY * 0.1D;
//		 witherScull.accelerationZ = witherScull.motionZ * 0.1D;
//		 }
//		world.spawnEntityInWorld(witherScull);
//	}
//	
//	return super.onItemRightClick(item, world, player);
//}