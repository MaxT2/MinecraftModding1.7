package maxts2.tutorialmod;
import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDeathEvent;


public class PigDropDiamons {

	@SubscribeEvent
	public void dropDiamonds(LivingDeathEvent event){
//		if (!(event.entity instanceof EntityPig)) {
//			return;
//		}
//
//		Random random = new Random();
//
//		if (event.entity.worldObj.isRemote) {
////			event.entity.dropItem(Items.diamond, random.nextInt(3));
//			event.entity.dropItem(Items.diamond, 3);
//		}
		event.entity.dropItem(Items.diamond, 3);
	}
}