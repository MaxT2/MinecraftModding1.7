package com.example.examplemod;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Wand extends GenericItem {

	public Wand() {
		// TODO Auto-generated constructor stub
		
	
	}

	@Override
	public ItemStack onItemRightClick(ItemStack yourItem, World world, EntityPlayer yourPlayer) {
		// TODO Auto-generated method stub
		//yourPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id,100,1));
		// duration 100 = 4-5 second?	
//		Random generator = new Random();
//		int i = generator.nextInt(10);
		
		//yourPlayer.setVelocity(0, 2, 0);
		//yourPlayer.velocityChanged = true;
		return super.onItemRightClick(yourItem, world, yourPlayer);
	}
	
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		// TODO Auto-generated method stub
		
		World world = entityLiving.worldObj;
		if(!world.isRemote){
		EntityLargeFireball fireball = new EntityLargeFireball(world, entityLiving, 10, 10, 10);
		fireball.motionX *= 1.5D;
		fireball.motionZ *= 1.5D;
		world.spawnEntityInWorld(fireball);
		
		
		
		
//		EntitySnowball snowball = new EntitySnowball(world,entityLiving);
		//ExplosiveSnowball snowball = new ExplosiveSnowball(world,entityLiving);
		
		} // end of isRemote
		
		return super.onEntitySwing(entityLiving, stack);
	}
	
	
	
}

