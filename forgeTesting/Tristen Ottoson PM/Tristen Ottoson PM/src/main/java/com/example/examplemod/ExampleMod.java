/*
 
saly2604.yp@gmail.com - Carlo's mom

 
 
 
Welcome to Minecraft Modding at Einstein's Workshop! This mod file will help you structure your very own Minecraft mod.
 * There are a number of comments to help you understand the different parts of this file.
 * Please follow along with your instructor and put the code under the appropriate comment!
 * Write your own comments to help you understand what your code is doing!
 */ 
package com.example.examplemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
//@Mod is a tag that lets MinecraftForge know that it needs to load this file as a mod file
public class ExampleMod {

	// --------------------- Global Variables ---------------------
	// These two String variables are used by minecraftForge, just leave them as is!
	public static final String MODID = "examplemod";
	public static final String VERSION = "1.0";

	// Put your Item, Block and ToolMaterial global variables here!
	public static Item magicMapleCandy;
	public static Item tristoniumIngot;
	public static Block tristoniumBlock;
	// variables for custom tools
	public static Item tristoniumSword;
	public static Item tristoniumPickaxe;
	public static Item tristoniumAxe;

	//custom tool material
	//string name: tristoniumSword
	//HarvestLVL: 3 wood/g=0,stone=1,iron=2,d=3
	//maxUsed: 2000 w=60,s=132,i=251,d=1562,30
	//efficiency: 18  w=2,s=4,i=6,d=8,g=12
	//damage: 6 w/g=0,s=1,i=2,d=3
	//Enchantability= 16 w=15,s=5,i=14,d=10,g=22 

	public static ToolMaterial tristoniumMaterial =
			EnumHelper.addToolMaterial("tristoniumMaterial", 3, 2000, 18, 6, 16);
	


	// --------------------- PreInitialization ---------------------
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		// Put "PREINIT" code here between the Open { and Closed } brackets
		
		
		
		// --------------------- Code Custom Items, Tools and Blocks! ---------------------
		//Put your code to create Items, Tools and Blocks here!		
		
		//food item
		//(healAmmount 1-20, saturationModifer .1f - 1.2f, wolvesFavorite?
		magicMapleCandy = new MapleLeafCandy(5,0.4f,false)
				//(potionID,duration(sec),amplifier,chance(0-1f))
				.setPotionEffect(Potion.moveSpeed.id, 30, 5, 1f)
				.setMaxStackSize(8)
				.setUnlocalizedName("magicMapleCandy")
				.setTextureName(MODID + ":mapleCandy")
				.setCreativeTab(CreativeTabs.tabFood);
		//register our food item
		GameRegistry.registerItem(magicMapleCandy, "magicMapleCandy");
		
		//generic item (tristonium ingot)
		tristoniumIngot = new GenericItem()
				.setUnlocalizedName("tristoniumIngot")
				.setTextureName(MODID + ":tristonium_ingot")
				.setCreativeTab(CreativeTabs.tabMaterials);
		// register our item
		GameRegistry.registerItem(tristoniumIngot, "tristoniumIngot");
		
	
		// custom block Tristonium!
		tristoniumBlock = new TristoniumBlock(Material.rock)
				.setBlockName("tristoniumBlock")
				.setBlockTextureName(MODID + ":TristoniumBlock")
				.setCreativeTab(CreativeTabs.tabBlock)
				.setHardness(3.0f) // hardness rock 1.5, obsidian 50
				.setResistance(15f) // obsidian 2000, bedrock 6mil, 10 for stone
				.setStepSound(Block.soundTypeLadder)
				.setLightLevel(0) // between 0 and 1 (bright)
				.setLightOpacity(0); // lower number more light through block
		// tool class = "pickaxe" "spade" "axe"
		// level: wood/gold = 0, stone = 1, iron = 2 , diamond = 3
		tristoniumBlock.setHarvestLevel("pickaxe", 3);
		GameRegistry.registerBlock(tristoniumBlock, "tristoniumBlock");
		
		
		// custom tristonium sword
		tristoniumSword = new TristoniumSword(tristoniumMaterial)
				.setUnlocalizedName("tristoniumSword")
				.setTextureName(MODID + ":tristoniumSword")
				.setCreativeTab(CreativeTabs.tabTools);
		// register our custom tool sword
		GameRegistry.registerItem(tristoniumSword, "tristoniumSword");
		
		// custom tristonium pickaxe
		tristoniumPickaxe = new TristoniumPickaxe(tristoniumMaterial)
				.setUnlocalizedName("tristoniumPickaxe")
				.setTextureName(MODID + ":tristoniumPickaxe")
				.setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(tristoniumPickaxe, "tristoniumPickaxe");
		
		//custom tristonium axe
		tristoniumAxe = new TristoniumAxe(tristoniumMaterial)
				.setUnlocalizedName("tristoniumAxe")
				.setTextureName(MODID + ":tristoniumAxe")
				.setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(tristoniumAxe, "tristoniumAxe");
		
		
		
		// --------------------- ItemStacks ---------------------
		//make ItemStack variables for any item you would like to use in a smelting or crafting recipe

		// item stack of tristonium block 
		ItemStack tristoniumBlockStack = new ItemStack(tristoniumBlock);
		ItemStack tristoniumIngotStack = new ItemStack(tristoniumIngot);
		ItemStack mapleCandyStack = new ItemStack(magicMapleCandy);
		ItemStack tristoniumPickaxeStack = new ItemStack(tristoniumPickaxe);
		ItemStack tristoniumAxeStack = new ItemStack(tristoniumAxe);
		ItemStack tristoniumSwordStack = new ItemStack(tristoniumSword);
		
		
		
		




		// --------------------- Smelting Recipes ---------------------
		//create your smelting recipe by registering it with the GameRegistry here

		// smelting recipe 1
		// turns dirt blocks into diamonds!
		ItemStack dirtStack = new ItemStack(Blocks.dirt);
		ItemStack diamondStack = new ItemStack(Items.diamond,64);
		//register the smelting recipe
		GameRegistry.addSmelting(dirtStack, diamondStack, 1);
		
		//smelting recipe 2
		// turn rotten flesh into leather
		ItemStack rottenFleshStack = new ItemStack(Items.rotten_flesh);
		ItemStack leatherStack = new ItemStack(Items.leather);
		// register the smelting recipe
		GameRegistry.addSmelting(rottenFleshStack, leatherStack, 3);
		
		//smelting recipe 3
		// smelt tristoniumBlock into tristoniumIngot
		GameRegistry.addSmelting(tristoniumBlockStack, tristoniumIngotStack, 4);
		
		//smelting recipe 3
		GameRegistry.addSmelting(diamondStack, tristoniumBlockStack, 2);
		
		
		
		






		// --------------------- Shapeless Crafting Recipes ---------------------
		//Create your shapeless crafting recipe by registering it with the GameRegistry here

		//shapeless recipe 1
		// turn a SEED and STICK into a SAPLING
		ItemStack seedStack = new ItemStack(Items.wheat_seeds);
		ItemStack stickStack = new ItemStack(Items.stick);
		ItemStack darkOakSaplingStack = new ItemStack(Blocks.sapling,1,5);
		// register the shapeless recipe
		GameRegistry.addShapelessRecipe(darkOakSaplingStack, seedStack, stickStack);
		
		
		//shapeless recipe 2
		// turn a Iron Ore and Bucket of Lava into Smelted Iron Ingot
		ItemStack ironOreStack = new ItemStack(Blocks.iron_ore);
		ItemStack lavaBucketStack = new ItemStack(Items.lava_bucket,1);
		ItemStack ironIngotStack = new ItemStack(Items.iron_ingot);
		// register the shapeless recipe
		GameRegistry.addShapelessRecipe(ironIngotStack, ironOreStack, lavaBucketStack);
		
		// shapeless recipe 3
		ItemStack grassStack = new ItemStack(Blocks.tallgrass,1,1);
		ItemStack grassBlockStack = new ItemStack(Blocks.grass);
		// register the shaplesss recipe
		GameRegistry.addShapelessRecipe(grassBlockStack, grassStack, dirtStack);
		






		// --------------------- Shaped Crafting Recipes ---------------------
		//Create your shaped crafting recipe by registering it with the GameRegistry here		
		
		
		
		//shaped recipe 1!
		// turn LEATHER, WOOL, IRON INGOT into a SADDLE!
//		ItemStack leatherStack = new ItemStack(Items.leather);
		ItemStack woolStack = new ItemStack(Blocks.wool,4,0); //white wool
		ItemStack IronIngotStack = new ItemStack(Items.iron_ingot);
		ItemStack saddleStack = new ItemStack(Items.saddle);
		// register shaped recipe
		GameRegistry.addShapedRecipe(saddleStack, 
				"LLL",
				"LWL",
				"I I",
				'L',leatherStack,
				'W',woolStack,
				'I',ironIngotStack);
		
		
		
		// shaped recipe 2!
		// turn oak logs into 4 boats
		ItemStack oakLogStack = new ItemStack(Blocks.log,1,0);
		ItemStack boatStack = new ItemStack(Items.boat,4);
		GameRegistry.addShapedRecipe(boatStack, 
				"   ",
				"W W",
				"WWW",
				'W',oakLogStack);
		
		//Shaped recipe 3!
		// turn ingots and sticks into
		// GO!
		GameRegistry.addShapedRecipe(tristoniumSwordStack, 
				"  T",
				"DT ",
				"DD ",
				'T',tristoniumIngotStack,
				'D',diamondStack);
		
		
		
		
		
		
		
		
		
	
		





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
