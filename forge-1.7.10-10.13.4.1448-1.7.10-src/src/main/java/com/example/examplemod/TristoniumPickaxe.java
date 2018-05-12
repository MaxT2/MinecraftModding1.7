package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TristoniumPickaxe extends ItemPickaxe {

	public TristoniumPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		// TODO Auto-generated method stub
		return super.onEntitySwing(entityLiving, stack);
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) {
		// TODO Auto-generated method stub
		
		return super.onBlockStartBreak(itemstack, X, Y, Z, player);
	}
	
	
	
	
	@Override
	public boolean onBlockDestroyed(ItemStack item, World world, Block brokenBlock, int x,
			int y, int z, EntityLivingBase entityPlayer) {
		// write code here for what happens when a block is broken
//		if(!world.isRemote){
			Block left = world.getBlock(x-1, y, z);
			left.harvestBlock(world, (EntityPlayer) entityPlayer, x-1, y, z, 1);
			world.setBlockToAir(x-1, y, z);
			
			Block right = world.getBlock(x+1, y, z);
			right.harvestBlock(world, (EntityPlayer) entityPlayer, x+1, y, z, 1);
			world.setBlockToAir(x+1, y, z);
//			world.destroyBlockInWorldPartially(x+1, y, z, left.getIdFromBlock(left), 100);
////		}




		return super.onBlockDestroyed(item, world, brokenBlock, x, y, z,
				entityPlayer);
	}







}
