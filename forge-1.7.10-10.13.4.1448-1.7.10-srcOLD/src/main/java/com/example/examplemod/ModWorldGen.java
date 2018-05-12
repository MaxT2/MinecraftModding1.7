package com.example.examplemod;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class ModWorldGen implements IWorldGenerator {

	public ModWorldGen() {
	
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId){
		
		case 0: //Overworld
			generateSurface(world, random, chunkX*16, chunkZ*16);
			break;
			
		case -1: //nether
			
			break;
			
		case 1: //end
			
			break;
		
		
		}
		
		

	}

	private void generateSurface(World world, Random random, int x, int z) {
		this.addOreSpawn(ExampleMod.tristoniumOre, world, random, x, z, 16, 16, 4+random.nextInt(6),25,40, 100);
		
	}

	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int veinSize, int chanceToSpawn,
			int minY, int maxY) {
		
		for(int i = 0; i < chanceToSpawn;i++){
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinable(block, veinSize).generate(world,random, posX, posY, posZ);
			
			
			
		}
		
		
	}

}
