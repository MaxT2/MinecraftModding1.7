package com.maxt2.tutorialmod.blocks;

import com.maxt2.tutorialmod.Main;
import com.maxt2.tutorialmod.init.ModBlocks;
import com.maxt2.tutorialmod.init.ModItems;
import com.maxt2.tutorialmod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel{
	
	public BlockBase(String name, Material material) {
		
		super(material);
		setUnlocalizedName(name); //set unlocalized name
		setRegistryName(name); // set registry name
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS); // set creative tab
		
		ModBlocks.BLOCKS.add(this); // have to add to blocks list
		// blocks have to be both a block and an item
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	
	

}
