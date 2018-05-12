package com.example.examplemod;

import net.minecraft.block.BlockOre;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class TristoniumOre extends BlockOre {

	public TristoniumOre() {
		// TODO Auto-generated constructor stub
	}

 @Override
public void dropXpOnBlockBreak(World p_149657_1_, int p_149657_2_, int p_149657_3_, int p_149657_4_,
		int p_149657_5_) {
	 int i1 = EntityXPOrb.getXPSplit(p_149657_5_);
     p_149657_5_ -= i1;
     p_149657_1_.spawnEntityInWorld(new EntityXPOrb(p_149657_1_, (double)p_149657_2_ + 0.5D, (double)p_149657_3_ + 0.5D, (double)p_149657_4_ + 0.5D, i1));
}
	
}
