package com.maxt2.tutorialmod.init;

import java.util.ArrayList;
import java.util.List;

import com.maxt2.tutorialmod.items.ItemBase;

import net.minecraft.item.Item;

public class ModItems {
	
	// list of minecraft items
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	
	// ItemBase("nameOfItem")
	public static final Item RUBY = new ItemBase("ruby");
	public static final Item TRISTONIUM_INGOT = new ItemBase("tristonium_ingot");

}
