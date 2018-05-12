package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class GenericSword extends ItemSword {

	public GenericSword(ToolMaterial localMaterial) {
		super(localMaterial);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean hitEntity(ItemStack yourItem, EntityLivingBase otherEntity, EntityLivingBase playerEntity)
    {

		otherEntity.addPotionEffect(new PotionEffect(Potion.blindness.id,140,10));
		otherEntity.addPotionEffect(new PotionEffect(Potion.invisibility.id, 140, 10));
		otherEntity.setVelocity(0, 2, 0);
		otherEntity.setFire(5);
		
		// do things to the player using playerEntity. and scroll through list
		playerEntity.addPotionEffect(new PotionEffect(Potion.invisibility.id,140,40));
		

		return true;
    }
}
