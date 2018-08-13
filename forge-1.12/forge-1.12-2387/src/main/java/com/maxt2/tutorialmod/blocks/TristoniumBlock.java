package com.maxt2.tutorialmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TristoniumBlock extends BlockBase {

	public TristoniumBlock(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setHarvestLevel("pickaxe", 3);
//		setLightLevel(1.0F);
		setResistance(15.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}

}
