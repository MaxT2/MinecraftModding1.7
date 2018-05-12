package maxts2.tutorialmod.entities;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import maxts2.tutorialmod.ATutorialMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class TMZombieEntity extends EntityZombie {
	// global variables
	
	// ----- debug flag
	private boolean debug = false; //set to true to print debug messages

	public static final Logger logger = LogManager.getFormatterLogger(ATutorialMod.MODID);
	
	public TMZombieEntity(World world) {
		super(world);
		// TODO Auto-generated constructor stub
		this.setHealth(5); //set health to 5
		this.setCustomNameTag("T-Zombie");  // set NameTag
		this.setSize(0.2f, 0.2f);
		ItemStack swordStack = new ItemStack(ATutorialMod.obsidianSword);
		this.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
		

		
//		AxisAlignedBB zBB = this.getBoundingBox();
//		zBB.setBounds(.2, .2, .2, .4, .4, .4);
//		this.getBoundingBox().setBounds(1,1,1,1,1,1);
		
		logger.debug("New TZombie ID = " + this.getEntityId() + "-----------------------------------");
		
	}
	

	// you don't have to call this as it is called automatically during EntityLiving subclass creation
	@Override
	protected void applyEntityAttributes()
	{
	    super.applyEntityAttributes(); 

	    // standard attributes registered to EntityLivingBase
	   getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
	   getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
	   getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.8D);
	   getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);

	    // need to register any additional attributes
	 //  getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
	   getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
	}
	
	@Override
	public void onDeath(DamageSource damageSource) {
		// TODO Auto-generated method stub
		super.onDeath(damageSource);
		
//		if(ThreadLocalRandom.current().nextInt(1, 10 + 1) == 1){
		if(  Math.random() < .4   ){
		TMZombieEntity one = new TMZombieEntity(worldObj);
		one.setPosition(this.posX + 1, this.posY, this.posZ);
		
		if(!worldObj.isRemote){
		worldObj.spawnEntityInWorld(one);
		
		
		
		}
		
		TMZombieEntity two = new TMZombieEntity(worldObj);
		two.setPosition(this.posX - 1, this.posY, this.posZ);
		
		if(!worldObj.isRemote){
		worldObj.spawnEntityInWorld(two);
		}
		
		}
	}


 





}
	
	

	
	
	
	
	
	
