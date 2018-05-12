package maxts2.tutorialmod.tile.entity;

import cpw.mods.fml.common.registry.GameRegistry;
import maxts2.tutorialmod.ATutorialMod;

public class TMTileEntity {

	public static void mainRegistry(){
		registerTileEntity();
		
	}

	private static void registerTileEntity() {
		// TODO Auto-generated method stub
		GameRegistry.registerTileEntity(TileEntityTChest.class, ATutorialMod.MODID);
	}
	
	
}
