package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ObsidianPickaxe extends ItemPickaxe {

	public ObsidianPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	  public boolean onBlockDestroyed(ItemStack item, World world, Block block, int x, int y, int z, EntityLivingBase player)
	    {
	        if ((double)block.getBlockHardness(world, x, y, z) != 0.0D)
	        {
	            item.damageItem(1, player);
	        }

	        return true;
	    }
	
}
