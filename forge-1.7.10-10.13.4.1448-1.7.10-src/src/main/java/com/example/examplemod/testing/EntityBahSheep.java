package com.example.examplemod.testing;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.World;

public class EntityBahSheep extends EntitySheep {

	public EntityBahSheep(World p_i1691_1_) {
		super(p_i1691_1_);
		// TODO Auto-generated constructor stub
	}
	
@Override
protected void applyEntityAttributes() {
	// TODO Auto-generated method stub
	super.applyEntityAttributes();
	 this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
//     this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
	 this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1D);
}
	

	

}
