package com.example.examplemod;


import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
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
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		
		
		Random rand = new Random();
		if(rand.nextFloat() <.30){
		
		entityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id ,3*20 ,0));
		}
		
		
		return super.onEntitySwing(entityLiving, stack);
	}
	
	
	
	
	
	
}
