/*
 * Welcome to Minecraft Modding at Einstein's Workshop! This mod file will help you structure your very own Minecraft mod.
 * There are a number of comments to help you understand the different parts of this file.
 * Please follow along with your instructor and put the code under the appropriate comment!
 * Write your own comments to help you understand what your code is doing!
 */
package com.example.examplemod;

import com.example.examplemod.testing.AmazingPickaxeClass;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import maxts2.tutorialmod.entities.EntityCustomSpider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
//@Mod is a tag that lets MinecraftForge know that it needs to load this file as a mod file
public class ExampleMod {

	// --------------------- Global Variables ---------------------
	// These two String variables are used by minecraftForge, just leave them as is!
	public static final String MODID = "examplemod";
	public static final String VERSION = "1.0";

	// Put your Item, Block and ToolMaterial global variables here!
    
	
	//public static ToolMaterial awesomeMaterial = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability)
	
	
	
	public static ArmorMaterial obsidianArmorMaterial = EnumHelper.addArmorMaterial("obsidianArmorMaterial", 15, new int[]{2,6,5,2},25);
	
	public static ToolMaterial obsidianMaterial = EnumHelper.addToolMaterial("obsidianMaterial", 3, 1000, 10.0F, 4.0F, 22);
	
	
	
	public static ToolMaterial tristoniumMaterial = EnumHelper.addToolMaterial("tristoniumMaterial", 3, 2000, 10.0F, 8.0F, 15);
	public static Item obsidianSword;
	public static Item cookedEgg;
	public static Item amazingPickaxe;
	public static Item obsidianHoe;
	public static Item testWand;
	// ore and ingot!
	public static Block tristoniumOre;
	public static Block rusticOre;	
	public static Item tristoniumIngot;
	public static Item tristoniumSword;
	// armor
	public static Item obsidianHelmet;
	public static Item obsidianChestplate;
	public static Item obsidianLeggings;
	public static Item obsidianBoots;
	public static Item tntWand;
	public static Item explosiveSnowball;
	
	ModEventHandler eventHandler = new ModEventHandler();
	
	// create world generation instance
	public static ModWorldGen eventWorldGen = new ModWorldGen();
	
	
	// get the mod instance for entity registrations
	@Instance(MODID)
	public ExampleMod instance;


	// --------------------- PreInitialization ---------------------
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		// Put "PREINIT" code here between the Open { and Closed } brackets

		// register our event handler file with minecraft forge
		// this lets our code run when events happen in minecraft
		FMLCommonHandler.instance().bus().register(eventHandler);
		MinecraftForge.EVENT_BUS.register(eventHandler);
		
		
		
		CreativeTabs tutorialTab = new CreativeTabs(MODID){
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return Items.diamond_sword;
			}
		};


		// --------------------- Code Custom Items, Tools and Blocks! ---------------------
		//Put your code to create Items, Tools and Blocks here!		
		
		tntWand = new TNTWand()
				.setUnlocalizedName("tntWand")
				.setTextureName(MODID + ":TNTWandTexture")
				.setCreativeTab(tutorialTab)
				;
		GameRegistry.registerItem(tntWand, "tntWand");
		
		
		
		// Tool items
		obsidianSword = new CustomObsidianSword(obsidianMaterial)
				.setUnlocalizedName("obsidianSword")
				.setTextureName(MODID + ":obsidianSword")
				.setCreativeTab(tutorialTab)
				;
		
		GameRegistry.registerItem(obsidianSword, "obsidianSword");

		cookedEgg = new CookedEggItem(6,0.6f,false)
				.setUnlocalizedName("cookedEgg")
				.setTextureName(MODID + ":cookedEggTexture")
				.setCreativeTab(tutorialTab)
				.setMaxStackSize(16)
				;
		GameRegistry.registerItem(cookedEgg, "cookedEgg");
	
		amazingPickaxe = new AmazingPickaxeClass(obsidianMaterial)
				.setUnlocalizedName("amazingPickaxe")
//				.setTextureName(MODID + ":amazingPickaxeTexture")
				.setTextureName(":diamond_pickaxe")
				.setCreativeTab(tutorialTab)		
				;
		
		GameRegistry.registerItem(amazingPickaxe, "amazingPickaxe");
		
		obsidianHoe = new ObsidianHoe(obsidianMaterial)
				.setUnlocalizedName("obsidianHoe")
				.setTextureName(":diamond_pickaxe")
				.setCreativeTab(tutorialTab)	
				;
		
		GameRegistry.registerItem(obsidianHoe, "obsidianHoe");
		
		// Ores and ingots
		tristoniumOre = new TristoniumOre()
				.setBlockName("tristoniumOre")
				.setBlockTextureName(MODID + ":tristoniumOreTexture")
				.setCreativeTab(tutorialTab)
				.setHardness(1.5f)
				;
		
		tristoniumOre.setHarvestLevel("pickaxe", 3);
	
		GameRegistry.registerBlock(tristoniumOre, "tristonium");
		
		
//		rusticOre = new RusticOre()
//				.setBlockTextureName(MODID + ":rusticOreTexture")
//				.setBlockName("rusticOre")
//				.setCreativeTab(tutorialTab)
//				.setHardness(1.5f)
//				;
//		
//		rusticOre.setHarvestLevel("pickaxe", 3);
//		
//		GameRegistry.registerBlock(rusticOre, "rusticOre");
		
		rusticOre = new RusticOre()
				.setBlockName("rusticOre")
				.setBlockTextureName(MODID + ":rusticOreTexture")
				.setCreativeTab(tutorialTab)
				.setHardness(1.5f)
				;
		
		rusticOre.setHarvestLevel("pickaxe", 2);
		
		GameRegistry.registerBlock(rusticOre, "rusticOre");
		
		
		
		
		
		
		// register ModWorldGen with minecraft
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		
		
		
		
		
		tristoniumIngot = new Item()
				.setUnlocalizedName("tristoniumIngot")
				.setTextureName(MODID + ":tristoniumIngotTexture")
				.setCreativeTab(tutorialTab)
				;
		GameRegistry.registerItem(tristoniumIngot, "tristoniumIngot");
		
		tristoniumSword = new TristoniumSword(tristoniumMaterial)
				.setUnlocalizedName("tristoniumSword")
				.setTextureName(MODID + ":tristoniumSwordTexture")
				.setCreativeTab(tutorialTab)
				;
		GameRegistry.registerItem(tristoniumSword, "tristoniumSword");
		
		testWand = new TestWand()
				.setUnlocalizedName("TestWand")
				.setTextureName(":stick")
				.setCreativeTab(tutorialTab)
				;
		GameRegistry.registerItem(testWand, "TestWand");
		
		
		obsidianHelmet = new GenericArmor(obsidianArmorMaterial, 0, "obsidianHelmet")
				.setTextureName(MODID + ":obsidianHelmet")
				.setCreativeTab(CreativeTabs.tabCombat)
				
				;
		GameRegistry.registerItem(obsidianHelmet, "obsidianHelment");
		
		obsidianChestplate = new GenericArmor(obsidianArmorMaterial, 1, "obsidianChestplate")
				.setTextureName(MODID + ":obsidianChestplate")
				.setCreativeTab(CreativeTabs.tabCombat)
				
				;
		GameRegistry.registerItem(obsidianChestplate, "obsidianChestplate");
		
		obsidianLeggings = new GenericArmor(obsidianArmorMaterial, 2, "obsidianLeggings")
				.setTextureName(MODID + ":obsidianLeggings")
				.setCreativeTab(CreativeTabs.tabCombat)
				
				;
		GameRegistry.registerItem(obsidianLeggings, "obsidianLeggings");
		
		obsidianBoots = new GenericArmor(obsidianArmorMaterial, 3, "obsidianBoots")
				.setTextureName(MODID + ":obsidianBoots")
				.setCreativeTab(CreativeTabs.tabCombat)
				
				;
		GameRegistry.registerItem(obsidianBoots, "obsidianBoots");

		
		
		
		
		
		
		
		
		



		// --------------------- Register Items, Tools and Blocks ---------------------
		//Register your custom Items, Tools and Blocks with the game registry here!


		// --------------------- ItemStacks ---------------------
				//make ItemStack variables for any item you would like to use in a smelting or crafting recipe
				ItemStack obsidianStack = new ItemStack(Blocks.obsidian);
				ItemStack stoneBrickStack = new ItemStack(Blocks.stonebrick);
				ItemStack quartzStack = new ItemStack(Blocks.quartz_block);
				ItemStack woolStack = new ItemStack(Blocks.wool);
				ItemStack commandBlockStack = new ItemStack(Blocks.command_block);
				// item stacks for my custom items/blocks
				ItemStack tristoniumOreStack = new ItemStack(tristoniumOre);
				ItemStack rusticOreStack = new ItemStack(rusticOre);
				ItemStack tristoniumIngotStack = new ItemStack(tristoniumIngot);
				ItemStack tristoniumSwordStack = new ItemStack(tristoniumSword);
				ItemStack stickStack = new ItemStack(Items.stick);


				// --------------------- Smelting Recipes ---------------------
				//create your smelting recipe by registering it with the GameRegistry here

				GameRegistry.addSmelting(tristoniumOreStack, tristoniumIngotStack , 3f);
				// --------------------- Shapeless Crafting Recipes ---------------------
				//Create your shapeless crafting recipe by registering it with the GameRegistry here
				GameRegistry.addShapedRecipe(commandBlockStack, new Object[]{
						"WQW",
						"BOB",
						"WQW",
						'W',woolStack,
						'Q',quartzStack,
						'B',stoneBrickStack,
						'O',obsidianStack	
				});
				
				GameRegistry.addShapedRecipe(tristoniumSwordStack, new Object[]{
					" T ",
					" T ",
					" S ",
					'T',tristoniumIngotStack,
					'S',stickStack
						
				});







				// --------------------- Shaped Crafting Recipes ---------------------
				//Create your shaped crafting recipe by registering it with the GameRegistry here		


				



	} // end of PREINIT method. ALL of your modding code for the intro class should be above this line!



	// --------------------- Initialization ---------------------
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Put "INIT" code here between the between the Open { and Closed } brackets

		// Register entity ID's
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		// register the mob globally
		EntityRegistry.registerGlobalEntityID(EntityCustomSpider.class, "Dangerous Spider", entityID);
		//Register the MOD entity
		EntityRegistry.registerModEntity(EntityCustomSpider.class, "Dangerous Spider", entityID, instance, 16, 3, true);
		// give it an egg
		EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, 255, 255));
		
	} // end of INIT

	// --------------------- PostInitialization ---------------------
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		// Put "POSTINIT" code here between the between the Open { and Closed } brackets

	} // end of POSTINIT
} // end of ExampleMod.java file
