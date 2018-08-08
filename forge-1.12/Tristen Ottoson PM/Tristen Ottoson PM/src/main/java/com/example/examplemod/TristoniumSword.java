package com.example.examplemod;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class TristoniumSword extends ItemSword {

	public TristoniumSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase otherEntity, EntityLivingBase p_77644_3_) {
		
		otherEntity.addPotionEffect(new PotionEffect(Potion.wither.id,4*20,0));
//		otherEntity.setDead(); // just kill the mob 
//		otherEntity.setFire(1);
		//change their velocity
		otherEntity.setVelocity(0, 2, 0);
		otherEntity.velocityChanged = true;
	
		return super.hitEntity(p_77644_1_, otherEntity, p_77644_3_);
	}
	
	
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		
		Random rand = new Random();
		// 0.0 1.0
		if(rand.nextFloat()<.20){
			entityLiving.addPotionEffect(new PotionEffect(Potion.heal.id,10*20,2));
		
			if(!entityLiving.worldObj.isRemote){
			EntityArrow arrow = new EntityArrow(entityLiving.worldObj, entityLiving, 5);
			entityLiving.worldObj.spawnEntityInWorld(arrow);
			}
			
		}
		
		
		return super.onEntitySwing(entityLiving, stack);
	}
	
	
	
	
	
} //end of file
