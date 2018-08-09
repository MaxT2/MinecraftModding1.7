package com.maxt2.tutorialmod.items;

import com.maxt2.tutorialmod.Main;
import com.maxt2.tutorialmod.init.IHasModel;
import com.maxt2.tutorialmod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{

	public ItemBase(String name){
		setUnlocalizedName(name); //set unlocalized name
		setRegistryName(name); // set registry name
		setCreativeTab(CreativeTabs.MATERIALS); // set creative tab
		
		// tell minecraft this is an item
		ModItems.ITEMS.add(this); // add this item to mod items list
	}
	
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRender(this, 0, "inventory");
	}

}
