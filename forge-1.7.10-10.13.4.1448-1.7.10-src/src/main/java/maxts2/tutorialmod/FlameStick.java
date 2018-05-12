package maxts2.tutorialmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FlameStick extends Item {

	public FlameStick() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		// TODO Auto-generated method stub
		EntityLargeFireball ball = new EntityLargeFireball(world, player, 0, -2, 0);
		
		if(!world.isRemote){
				world.spawnEntityInWorld(ball);
		}
		return super.onItemRightClick(item, world, player);
	}
	
	
	

}
