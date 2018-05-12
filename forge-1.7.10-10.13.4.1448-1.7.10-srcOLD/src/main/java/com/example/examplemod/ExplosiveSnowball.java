package com.example.examplemod;

import net.minecraft.client.particle.EntityDropParticleFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ExplosiveSnowball extends EntitySnowball {

	public ExplosiveSnowball(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}

	public ExplosiveSnowball(World world, EntityLivingBase entityLiving) {
		super(world, entityLiving);
		// TODO Auto-generated constructor stub
	}

	public ExplosiveSnowball(World world, double x, double y, double z) {
		super(world, x, y, z);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public void onCollideWithPlayer(EntityPlayer player) {
//		// TODO Auto-generated method stub
//		player.addPotionEffect(new PotionEffect(Potion.invisibility.id,100,10));
//		
//		super.onCollideWithPlayer(player);
//	}
	
	
	@Override
	protected void onImpact(MovingObjectPosition object) {
		// TODO Auto-generated method stub
		
		World world = worldObj;
		//worldObj.createExplosion(this, posX, posY, posZ, 10, true);
		
		
		
		if(!world.isRemote){
			//worldObj.createExplosion(this, posX, posY, posZ, 10, true);
//		EntityLightningBolt bolt = new EntityLightningBolt(world, posX, posY, posZ);
//		world.spawnEntityInWorld(bolt);
		}
		
		super.onImpact(object);
	}
	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		super.onUpdate();
		//this.worldObj.spawnParticle(, posX, posX, posZ, p_72869_6_, p_72869_8_, p_72869_10_, p_72869_12_);
		EntityDropParticleFX fx = new EntityDropParticleFX(worldObj, posX, posY, posZ, null);
		worldObj.spawnEntityInWorld(fx);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
