package com.example.examplemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MagicChickenNugget extends ItemFood {

	public MagicChickenNugget(int p_i45340_1_, boolean p_i45340_2_) {
		super(p_i45340_1_, p_i45340_2_);
		// TODO Auto-generated constructor stub
	}

	public MagicChickenNugget(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		// TODO Auto-generated constructor stub
	
	}
	
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World p_77659_2_, EntityPlayer p_77659_3_) {

		return super.onItemRightClick(itemStack, p_77659_2_, p_77659_3_);
	}
	
	
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World p_77654_2_, EntityPlayer p_77654_3_) {
		itemStack.stackSize = itemStack.stackSize + 1 ;
		return super.onEaten(itemStack, p_77654_2_, p_77654_3_);
	}

	
	
}
