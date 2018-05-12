package com.example.examplemod;

import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class CookedEggItem extends ItemFood {

	public CookedEggItem(int healAmmount, boolean wolvesFavorite) {
		super(healAmmount, wolvesFavorite);
		// TODO Auto-generated constructor stub
	}

	public CookedEggItem(int healAmmount, float saturationModifier, boolean wolvesFavorite) {
		super(healAmmount, saturationModifier, wolvesFavorite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack onEaten(ItemStack item, World world, EntityPlayer player) {



		if(!world.isRemote){
			// create local entity
			EntityBlaze blaze = new EntityBlaze(world);
			// set entity location to the player location
			blaze.posX = player.posX;
			blaze.posY = player.posY;
			blaze.posZ = player.posZ;
			// spawn entity in world at location
			world.spawnEntityInWorld(blaze);
		}

		return super.onEaten(item, world, player);
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
		// TODO Auto-generated method stub
		return super.onDroppedByPlayer(item, player);
	}



} // end of cookedEgg file
