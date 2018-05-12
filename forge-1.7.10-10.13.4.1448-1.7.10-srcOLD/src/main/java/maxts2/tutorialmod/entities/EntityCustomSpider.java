package maxts2.tutorialmod.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityCustomSpider extends EntitySpider {

	public EntityCustomSpider(World world) {
		super(world);
		this.setCustomNameTag("Dangerous Spider");
	}// end of constructor

	
	
	@Override
	 protected void applyEntityAttributes()
	    {
			// do whatever other spiders do for attributes
	        super.applyEntityAttributes();
	        // set custom attributes
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.6D);
	        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D); //base value for spiders is 1D
	        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0D);
	    }
	
	
	@Override
	public void onDeath(DamageSource p_70645_1_) {
		// TODO Auto-generated method stub
		
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 10, true);
		
		super.onDeath(p_70645_1_);
	}
	
	
} // end of file!
