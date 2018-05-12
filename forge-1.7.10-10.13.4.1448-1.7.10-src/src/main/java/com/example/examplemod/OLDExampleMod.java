package com.example.examplemod;

// Imported files that you want to use in this project.
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

//@Mod registers this java class file as the main file of your mod and loads it into forge when MC starts
//@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class OLDExampleMod
{
	public static final String MODID = "examplemod";
	public static final String VERSION = "1.0";


	// Global variable Definitions
	// Put new items or tool materials here
	public static Item cookedEgg;  //empty variable for a food item
	public static Item obsidianSword; //empty variable for a food item
	// create our tool material variable and assign it to a new tool with imputted stats
	// more info no the tool material can be found at Bedrock Miners Tutorial Page
	//https://bedrockminer.jimdo.com/modding-tutorials/basic-modding-1-7/custom-tools-swords/
	//obsidianMaterial = EnumHelper.addToolMaterial(String name, int harvestLevel (0-3), int maxUses(Diamond = ~1500), float efficiency(how much faster than your hand), float damage(+4.0F for sword) , int enchantability)	
	public static ToolMaterial obsidianMaterial = EnumHelper.addToolMaterial("obsidianMaterial", 3, 1000, 12.0f, 6.0f, 22);            

	// preinit is run 
	@EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		// ------- first smelting recipe -------
		ItemStack dirtStack = new ItemStack(Blocks.dirt);
		ItemStack bedrockStack = new ItemStack(Blocks.bedrock);

		GameRegistry.addSmelting(dirtStack, bedrockStack, 100f);


		// ----- second smelting recipe ------
		ItemStack stoneStack = new ItemStack(Blocks.stone);
		ItemStack clayStack = new ItemStack(Blocks.clay);

		GameRegistry.addSmelting(stoneStack, clayStack, 10f);

		ItemStack potatoStack = new ItemStack(Items.baked_potato);

		// ----- craft recipe ------

		ItemStack saddleStack = new ItemStack(Items.saddle);
		ItemStack leatherStack = new ItemStack(Items.leather);

		GameRegistry.addShapelessRecipe(saddleStack, new Object[]
				{
						leatherStack, leatherStack, leatherStack, leatherStack, leatherStack
				}
				);

		// ------- crafting recipe  ------ 

		//ItemStack dyeStack = new ItemStack(Items.dye.);


		// ------- shaped crafting recipe  ------ 

		ItemStack logStack = new ItemStack(Blocks.log);
		ItemStack boatStack = new ItemStack(Items.boat, 4);

		GameRegistry.addShapedRecipe(boatStack, new Object[]
				{
						"   ",
						"L L",
						"LLL",
						'L',logStack
				}
				);


		//// ---- recipe 2 ----

		ItemStack ironIngotStack = new ItemStack(Items.iron_ingot);

		GameRegistry.addShapedRecipe(saddleStack, new Object []
				{
						"LLL",
						"LLL",
						"I I",
						'I',ironIngotStack,
						'L',leatherStack

				}
				);

		// //// ---- recipe 3 ----
		ItemStack ironBarStack = new ItemStack(Blocks.iron_bars);
		ItemStack chainMailHelmStack = new ItemStack(Items.chainmail_helmet);

		GameRegistry.addShapedRecipe(saddleStack, new Object []
				{
						"III",
						"I I",
						"   ",
						'I',ironBarStack,

				}
				);


		cookedEgg = new GenericFood(5,0.4f,false)
				.setCreativeTab(CreativeTabs.tabFood)
				.setUnlocalizedName("cookedEgg")
				.setTextureName(MODID + ":cookedEgg")
				.setMaxStackSize(16);

		GameRegistry.registerItem(cookedEgg, "cookedEgg");

		obsidianSword = new GenericSword(obsidianMaterial)
				.setUnlocalizedName("obsidianSword")
				.setTextureName(MODID + ":obsidianSword")
				.setTextureName(":diamond_sword")
				.setCreativeTab(CreativeTabs.tabCombat)

				;

		GameRegistry.registerItem(obsidianSword, "obsidianSword");



















	} // end of preinit
} // end of file
