package com.maxt2.tutorialmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSmelting {
	public static void init(){
		
		GameRegistry.addSmelting(ModBlocks.TRISTONIUM_ORE, new ItemStack(ModItems.TRISTONIUM_INGOT, 1), 1.0F);
		
	}

}
