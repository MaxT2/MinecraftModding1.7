package maxts2.tutorialmod.items;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import java.util.concurrent.ThreadLocalRandom;

public class ObsidianPickaxe extends ItemPickaxe {

	public ObsidianPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		// TODO Auto-generated constructor stub

	}
	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entity)
	{

		// create random explotions
//		if(ThreadLocalRandom.current().nextInt(1, 3 + 1) == 1){
//			world.createExplosion(entity, x, y, z, 20.0f, false);
//		}

		if ((double)block.getBlockHardness(world, x, y, z) != 0.0D)
		{
			itemStack.damageItem(1, entity);
		}


//		entity.addPotionEffect(new PotionEffect(Potion.invisibility.id,140,10));

		return true;
	}



}
