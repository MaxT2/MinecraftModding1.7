package com.maxt2.tutorialmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TristoniumOre extends BlockBase {

	public TristoniumOre(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(0.1F);
		setResistance(15.0F);
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}

}
