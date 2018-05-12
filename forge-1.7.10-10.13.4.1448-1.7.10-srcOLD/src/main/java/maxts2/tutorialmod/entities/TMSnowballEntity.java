package maxts2.tutorialmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class TMSnowballEntity extends EntitySnowball {

	
	public TMSnowballEntity(World world) {
		super(world);
		// TODO Auto-generated constructor stub
		this.setSize(4F, 4F);

	}

	public TMSnowballEntity(World world, EntityLivingBase player) {
		super(world, player);
		// TODO Auto-generated constructor stub
		this.setSize(4F, 4F);
	}

	public TMSnowballEntity(World world, double x, double y, double z) {
		super(world, x, y, z);
		// TODO Auto-generated constructor stub
		this.setSize(4F, 4F);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		// TODO Auto-generated method stub
		{
			if (mop.entityHit != null)
			{
				byte b0 = 100; //// throw damage?

				if (mop.entityHit instanceof EntityBlaze)
				{
					b0 = 3; 
				}

				mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
			}

			for (int i = 0; i < 8; ++i)
			{
				this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
			}

			if (!this.worldObj.isRemote)
			{
				this.setDead();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
} // end of class 