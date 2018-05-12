package maxts2.tutorialmod.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import maxts2.tutorialmod.entities.TMEntityCreeper;
import maxts2.tutorialmod.entities.TMEntityMinecart;
import maxts2.tutorialmod.entities.TMSnowballEntity;
import maxts2.tutorialmod.entities.TMZombieEntity;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.*;
// make sure to import all entity classes using import net.minecraft.entity.*;
public class TMWand extends Item {
private boolean debug = false; // debug = true for debug messages
	
	public TMWand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack onItemRightClick(ItemStack thisItem, World world, EntityPlayer player) {

		// check to see if we are running this code on ther server.
		// if we are then spawn a fireball
		if(!world.isRemote){
			EntityLargeFireball fireball = new EntityLargeFireball(world, player, 0, 0, 0);
			Vec3 looking = player.getLookVec();
			 if (looking != null) {
			 fireball.motionX = looking.xCoord;
			 fireball.motionY = looking.yCoord;
			 fireball.motionZ = looking.zCoord;
			 fireball.accelerationX = fireball.motionX * 0.1D;
			 fireball.accelerationY = fireball.motionY * 0.1D;
			 fireball.accelerationZ = fireball.motionZ * 0.1D;
			 }
			world.spawnEntityInWorld(fireball);
		}
		return  thisItem;
	}	
}
		





















//
//
//@Override
//public ItemStack onItemRightClick(ItemStack thisItem, World world, EntityPlayer player) {
//
//	//System.out.println("StickWand.OnItemRightClick ---- CALLLED ----------------------------------------");
//	int posX = player.getPlayerCoordinates().posX;
//	int posY = player.getPlayerCoordinates().posY;
//	int posZ = player.getPlayerCoordinates().posZ;
//	
//	// -------------- get block player is looking at ------------------
//	MovingObjectPosition mop = Minecraft.getMinecraft().renderViewEntity.rayTrace(200, 1.0F);
//	if(mop != null)
//	{
//		int blockHitSide = mop.sideHit;
//		Block blockLookingAt = world.getBlock(mop.blockX, mop.blockY, mop.blockZ) ; 
//
//	}
//	int targX = mop.blockX;
//	int targY = mop.blockY;
//	int targZ = mop.blockZ;
//	Vec3 angle = mop.hitVec.normalize();
//	System.out.println(angle.xCoord);
//	System.out.println(angle.yCoord);
//	System.out.println(angle.zCoord);
//	// -----------------------------------------------------------------
//	
//	if(!world.isRemote){
//		EntityLargeFireball fireball = new EntityLargeFireball(world, player, 0, 0, 0);
//		Vec3 looking = player.getLookVec();
//		 if (looking != null) {
//		 fireball.motionX = looking.xCoord;
//		 fireball.motionY = looking.yCoord;
//		 fireball.motionZ = looking.zCoord;
//		 fireball.accelerationX = fireball.motionX * 0.1D;
//		 fireball.accelerationY = fireball.motionY * 0.1D;
//		 fireball.accelerationZ = fireball.motionZ * 0.1D;
//		 }
//		world.spawnEntityInWorld(fireball);
//	}
//	return  thisItem;
//}	
//}
//
//
//
//



















//TMZombieEntity tZombie = new TMZombieEntity(world);
//tZombie.setPosition(posX, posY, posZ);
//
//EntityZombie zom = new EntityZombie(world);
//zom.setPosition(posX, posY, posZ);
//
//TMEntityCreeper mob = new TMEntityCreeper(world);
//mob.setPosition(posX, posY+2, posZ);
//
		
		
		
		//		EntityLargeFireball fireball = new EntityLargeFireball(world);
//		fireball.copyLocationAndAnglesFrom(player);
//		fireball.setVelocity(look.xCoord, look.yCoord, look.zCoord);
//		fireball.accelerationX = fireball.accelerationY = fireball.accelerationZ = 0;
		
		
		
		
		
//		fireball.setVelocity(angle.xCoord, angle.yCoord, angle.zCoord);
//		fireball.velocityChanged = true;
	
//		TMSnowballEntity localSnowball = new TMSnowballEntity(world, player);
//		localSnowball.motionX = localSnowball.motionX * 2;
//		localSnowball.motionY = localSnowball.motionY * 2;
//		localSnowball.motionZ = localSnowball.motionZ * 2;
//		localSnowball.velocityChanged = true;
//		world.spawnEntityInWorld(localSnowball);
		

		
		
		
		
		
		// --------- spawn entitys ---------------
		// spawn blaze
//		EntityBlaze testBlaze = new EntityBlaze(world);
//		testBlaze.setPosition(targX, targY, targZ);
//		world.spawnEntityInWorld(testBlaze); // spawn new entity

		
		
		// ---------- spawn lightning bolt --------------
//		EntityLightningBolt lightingBolt = new EntityLightningBolt(world, targX, targY, targZ); // set x y z coordinates before spawning
//		world.spawnEntityInWorld(lightingBolt); // spawn new entity
		// ----------------------------------------------

//		 spawn T-Zombie - still spawns doubles
//		if(debug){
//		System.out.println("Player is looking at ------ (" +targX+"," + targY+","+targZ+") <<<<<<<<<<<<<<<<" );
//		System.out.println("T-Zombie Spawnning At ------ (" +targX+"," + (targY+2) +","+targZ+") <<<<<<<<<<<<<<<<" );
//		}
		
		
//		TMZombieEntity tZombie = new TMZombieEntity(world);
//		tZombie.setPosition(posX, posY, posZ);
//		if(!world.isRemote){
//		world.spawnEntityInWorld(tZombie);
//		}
		
		
		

//		TSlimeEntity slime = new TSlimeEntity(world);
//		slime.setPosition(targX, targY + 2, targZ);
//		if(!world.isRemote){
//			world.spawnEntityInWorld(slime);
//			
//		}
		
		
		// spawn T-Blaze
//		TBlazeEntity tBlaze = new TBlazeEntity(world);
//		tBlaze.setPosition(targX, targY, targZ);
//		tBlaze.setPosition(targX, targY, targZ);
//		if(!world.isRemote){
//		world.spawnEntityInWorld(tBlaze);
//		}
		




//EntitySpider spider = new EntitySpider(world);
	//	spider.setPosition(posX, posY, posZ);
	//	
	//	world.spawnEntityInWorld(spider);

	//EntityFireball fireBall = new EntityFireball();
	//	EntityLightningBolt lightingBolt = new EntityLightningBolt(world, posX + 4, posY, posZ);

//@Override
//	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
//			float hitX, float hitY, float hitZ) {
//		// TODO Auto-generated method stub
//		System.out.println("StickWand.onItemUseFirst --- CALLED ---");
//		return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
//		
//
//	}
//	
//	



//if(!world.isRemote){
//	EntitySnowball ball = new EntitySnowball(world, player);
//	ball.setPosition(targX, targY, targZ);
	//ball.setVelocity(0, 0, 0);
//	ball.motionX = ball.motionX * 2;
//	ball.motionY = ball.motionY * 2;
//	ball.motionZ = ball.motionZ * 2;
//	ball.velocityChanged = true;
//	world.spawnEntityInWorld(ball);			
//	 world.spawnEntityInWorld(new EntityArrow(world, player, 1));
	//world.spawnEntityInWorld(new EntitySmallFireball(world));
//	 }