package maxts2.tutorialmod.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ObsidianSword extends ItemSword {

	public ObsidianSword(ToolMaterial localMaterial) {
		super(localMaterial);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	@Override
	public boolean hitEntity(ItemStack yourItem, EntityLivingBase otherEntity, EntityLivingBase player)
    {
		otherEntity.setVelocity(0, 2, 0);
		otherEntity.velocityChanged = true;
		

		return true;
    }

	
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		// TODO Auto-generated method stub
		return super.onEntitySwing(entityLiving, stack);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
 @Override
public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
	// TODO Auto-generated method stu
	 
	 if(!world.isRemote){
	 world.spawnEntityInWorld(new EntityArrow(world, player, 1));
	//world.spawnEntityInWorld(new EntitySmallFireball(world));
	 }
	 
	return itemStack;
}

	
	
	
	
} // end of file


//------ other hit entity stuff -----
		// PotionEffect(Potion.type.id,durration,amplifier
		//otherEntity.addPotionEffect(new PotionEffect(Potion.invisibility.id, 140, 10));
		//otherEntity.setFire(1);
		//otherEntity.setVelocity(0, 2, 0);
		//otherEntity.setFire(5);
		
		
		// ---- add player potion effects
//		player.addPotionEffect(new PotionEffect(Potion.invisibility.id,140,10));
		//  ------ set player velocity  -------
//		player.addVelocity(0, 2, 0);
//		player.velocityChanged = true;
		// ------------------------------