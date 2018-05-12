package maxts2.tutorialmod.entities;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.World;

public class TMSlimeEntity extends EntitySlime {

	public TMSlimeEntity(World p_i1742_1_) {
		super(p_i1742_1_);

		this.setSlimeSize(this.getSlimeSize()*40);
		// TODO Auto-generated constructor stub
	}

}
