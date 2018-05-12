package maxts2.tutorialmod.items;

import maxts2.tutorialmod.entities.TMSnowballEntity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TMSnowballItem extends ItemSnowball {

	public TMSnowballItem() {
		
		// TODO Auto-generated constructor stub
		this.maxStackSize = 16;
		this.setCreativeTab(CreativeTabs.tabCombat);

	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		{
			if (!player.capabilities.isCreativeMode)
			{
				--item.stackSize;
			}

			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!world.isRemote)
			{
				TMSnowballEntity localSnowball = new TMSnowballEntity(world, player);
				localSnowball.motionX = localSnowball.motionX * 2;
				localSnowball.motionY = localSnowball.motionY * 2;
				localSnowball.motionZ = localSnowball.motionZ * 2;
				localSnowball.velocityChanged = true;
				world.spawnEntityInWorld(localSnowball);
			}

			return item;


		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






