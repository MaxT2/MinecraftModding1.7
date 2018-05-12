package maxts2.tutorialmod.blocks;

import java.util.Random;

import com.example.examplemod.ExampleMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TBlock extends Block {

	public TBlock(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setBlockTextureName("tm:tBlock");


	}

	public boolean isOpaqueCube() {

		return false;

		
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_,
			int p_149646_5_) {
		// TODO Auto-generated method stub
		return super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
	}




	@Override
	public boolean canDropFromExplosion(Explosion p_149659_1_) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		// TODO Auto-generated method stub
		//	return Item.getItemFromBlock(this);

		return Item.getItemById(264);
	}

	
	
	
	
}
