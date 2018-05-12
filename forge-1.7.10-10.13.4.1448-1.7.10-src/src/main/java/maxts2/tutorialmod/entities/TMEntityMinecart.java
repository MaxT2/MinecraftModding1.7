package maxts2.tutorialmod.entities;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.world.World;

public class TMEntityMinecart extends EntityMinecart {

	public TMEntityMinecart(World p_i1712_1_) {
		super(p_i1712_1_);
		this.setMaxSpeedAirLateral(1000f);
		this.setMaxSpeedAirVertical(1000f);
		// TODO Auto-generated constructor stub
	}

	public TMEntityMinecart(World p_i1713_1_, double p_i1713_2_, double p_i1713_4_, double p_i1713_6_) {
		super(p_i1713_1_, p_i1713_2_, p_i1713_4_, p_i1713_6_);
		this.setMaxSpeedAirLateral(1000f);
		this.setMaxSpeedAirVertical(1000f);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getMinecartType() {
		// TODO Auto-generated method stub
		return 0;
	}

}
