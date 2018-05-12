package com.example.examplemod.testing;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AmazingPickaxeClass extends ItemPickaxe {

	public AmazingPickaxeClass(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		// TODO Auto-generated constructor stub
	}






	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) {
		// TODO Auto-generated method stub
		
		return super.onBlockStartBreak(itemstack, X, Y, Z, player);
	}


	@Override
	public boolean onBlockDestroyed(ItemStack item, World world, Block block, int x,
			int y, int z, EntityLivingBase entity) {
		// TODO Auto-generated method stub
		
		
		
		return super.onBlockDestroyed(item, world, block, x, y, z,
				entity);
	}
	
	@Override
	public boolean func_150897_b(Block p_150897_1_) {
		// TODO Auto-generated method stub
		return super.func_150897_b(p_150897_1_);
	}
	
	@Override
	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_,
			int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		// TODO Auto-generated method stub
		return super.onItemUse(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_,
				p_77648_9_, p_77648_10_);
	}
	
}
