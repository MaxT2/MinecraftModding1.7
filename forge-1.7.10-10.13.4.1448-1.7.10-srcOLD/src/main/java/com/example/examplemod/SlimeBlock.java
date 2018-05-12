package com.example.examplemod;

import net.minecraft.block.BlockSoulSand;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class SlimeBlock extends BlockSoulSand {

	public SlimeBlock() {
		// TODO Auto-generated constructor stub
	}

	
	
	  /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox((double)p_149668_2_, (double)p_149668_3_, (double)p_149668_4_, (double)(p_149668_2_ + 1), (double)((float)(p_149668_3_ + 1) - f), (double)(p_149668_4_ + 1));
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity player)
    {
        player.motionX *= .9D;
        player.motionZ *= .9D;
        
        
        player.motionY = 2.0D;
        
        
    }
	
	
	
	
	
}
