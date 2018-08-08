/*
 * Teacher Guide!
 * This guide it to have an example of everything covered in the intro to Minecraft Modding class
 * This guide is structured the same as the student template and kids should put their code in
 * the apropriate sections.
 */

/*
 * Welcome to Minecraft Moding at Einstein's Workshop! This mod file will help you structure your very own Minecraft mod.
 * There are a number of comments to help you understand the different parts of this file.
 * Please follow along with your instructor and put the code under the appropriate comment!
 * Write your own comments to help you understand what your code is doing!
 * 
 * Class FLow (1 Hour)
 * Day 1: ItemStacks + Smelting Recipe
 * Day 2: Shapeless Crafting
 * Day 3: Shaped Crafting
 * Day 4: Custom Item + Textures?
 * Day 5: Custom Block + Textures?\
 * Day 6:
 * Day 7:
 * Day 8:
 * 
 */
package com.example.examplemod.teacher;

import com.example.examplemod.obsidianSword;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import maxts2.tutorialmod.blocks.TBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

//@Mod(modid = ExampleModSTUDENTTEMPLATE.MODID, version = ExampleModSTUDENTTEMPLATE.VERSION)
//@Mod is a tag that lets MinecraftForge know that it needs to load this file as a mod file
public class ExampleModTEACHER {

	// --------------------- Global Variables ---------------------
	// These two String variables are used by minecraftForge, just leave them as is!
	public static final String MODID = "examplemod";
	public static final String VERSION = "1.0";

	// Put your Item, Block and ToolMaterial global variables here!
	//(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability)
	// string name same as variable name
	// Harvest Level = 3: hand(0) stone(1) iron(2) diamond(3)
	// maxUses = 3, how many times can you use the tool or weapon?
	// efficiency = 100?????? faster than hands?
	// damage = 4 + (3 for sword)
	//enchantability = 15????????????
	public static ToolMaterial obsidianMaterial = EnumHelper.addToolMaterial("obsidianMaterial", 3, 1000, 100.0F, 4.0F, 15); 
	public static Item obsidianSword;
	// import Item ^^^ (net.minecraft.item)
	public static Block tBlock;


	// --------------------- PreInitialization ---------------------
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		// Put "PREINIT" code here between the Open { and Closed } brackets


		// --------------------- ItemStacks ---------------------
		//Smelting: Create ItemStack for input and output items
		// and Import the ItemStack class file

		// Smelting Recipe 1 ItemStacks
		// turn rotten flesh into leather
		ItemStack rottenFleshStack = new ItemStack(Items.rotten_flesh);
		ItemStack leatherStack = new ItemStack(Items.leather);
		// then register the recipe down below

		// Smelting Recipe 2 ItemStacks 
		//turn cake into coal
		ItemStack cakeStack = new ItemStack(Items.cake);
		ItemStack coalStack = new ItemStack(Items.coal);
		// then register the recipe down below

		// Shapeless crafting ItemStacks
		//turn 2 seeds and a stick into a sappling
		ItemStack seedStack = new ItemStack(Items.wheat_seeds);
		ItemStack stickStack = new ItemStack(Items.stick);
		ItemStack sapplingStack =new ItemStack(Blocks.sapling);
		// then register the recipe down below

		//Shaped Crafting ItemStacks
		// turn leather and iron ingots into a saddle
		// Need leather itemstack but we have one arleady!
		ItemStack ironIngotStack = new ItemStack(Items.iron_ingot);
		ItemStack saddleStack = new ItemStack(Items.saddle);
		// then register the recipe down below


		// --------------------- Smelting Recipe's ---------------------
		//create smelting recipe by register it with the GameRegistry here

		// Example: Smelt Iron Ore into two Iron Ingots
		// Smelting Recipe 1 Registration
		GameRegistry.addSmelting(rottenFleshStack, leatherStack, 10f);
		// Smelting Recipe 2 Registration
		GameRegistry.addSmelting(cakeStack, coalStack, 0f);


		// --------------------- Shapeless Crafting Recipe's ---------------------
		//Create shapeless crafting recipes and register it with GameRegistry here
		// list your ItemStack variable names for each item in the recipe
		// between the {} after new Object[]
		GameRegistry.addShapelessRecipe(sapplingStack, new Object[]{
				seedStack,seedStack,stickStack
		});


		// --------------------- Shaped Crafting Recipe's ---------------------
		//Create shaped crafting recipe and register it with the GameRegistry here
		// for a 3 x 3 crafting table in the code, label the spot that items go in
		// and define the lables using 'S',itemStackVariable
		GameRegistry.addShapedRecipe(saddleStack, new Object[]{
				"SSS",
				"SSS",
				"I I",
				'S',saddleStack,
				'I',ironIngotStack
		});


		// --------------------- Code Custom Items, Tools and Blocks! ---------------------
		//Put your code to create Items, Tools and Blocks here!		

		obsidianSword = new obsidianSword(obsidianMaterial)
				.setUnlocalizedName("obsidianSword")
				//				.setTextureName(MODID + ":obsidianSword")
				.setTextureName(":diamond_sword")
				.setCreativeTab(CreativeTabs.tabCombat)
				;
		// register Item with the GameRegistry below
		// create tBlock Block from tBlock.java class
		tBlock = new TBlock(Material.cloth) // means it will act like cloth - it will mine like this material
				.setBlockName("tBlock")  					//should always set this
				.setCreativeTab(CreativeTabs.tabBlock)		//should always set this
				.setBlockTextureName(MODID + ":tBlock")	//should always set this
				.setHardness(1.5f) 							// hardness of stone
				.setResistance(10f) 						// resistance to explosions of stone
				.setStepSound(Block.soundTypeCloth) 		// sounds like stone when you walk on it
				.setLightLevel(0.0f);			






	} // end of PREINIT method. ALL of your modding code for the intro class should be above this line!



	// --------------------- Initialization ---------------------
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Put "INIT" code here between the between the Open { and Closed } brackets

	} // end of INIT

	// --------------------- PostInitialization ---------------------
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		// Put "POSTINIT" code here between the between the Open { and Closed } brackets

	} // end of POSTINIT
} // end of ExampleMod.java file
