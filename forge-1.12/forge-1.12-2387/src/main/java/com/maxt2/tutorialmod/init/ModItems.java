package com.maxt2.tutorialmod.init;

import java.util.ArrayList;
import java.util.List;

import com.maxt2.tutorialmod.items.ItemBase;
import com.maxt2.tutorialmod.items.tools.ToolSword;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	// list of minecraft items
	public static final List<Item> ITEMS = new ArrayList<Item>();

	//Material
	public static ToolMaterial TRISTONIUM_MATERIAL = EnumHelper.addToolMaterial("tristoniumMaterial", 3, 2000, 10.0F, 8.0F, 15);
	
	// Items
	public static final Item RUBY = new ItemBase("ruby");
	public static final Item TRISTONIUM_INGOT = new ItemBase("tristonium_ingot");
	
	//tools
	public static final ItemSword TRISTONIUM_SWORD = new ToolSword("tristonium_sword",TRISTONIUM_MATERIAL);

}
