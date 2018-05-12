/*
 * This template is intended to be used as the base mod file for Einstein's Workshop classes.
 * Change the name of this class file to ExampleMod.java before loading onto a computer.
 * Then delete this comment 
 */

/*
 * Welcome to Minecraft Moding at Einstein's Workshop! This mod file will help you structure your very own Minecraft mod.
 * There are a number of comments to help you understand the different parts of this file.
 * Please follow along with your instructor and put the code under the appropriate comment!
 * Write your own comments to help you understand what your code is doing!
 */
package com.example.examplemod.teacher;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

//@Mod(modid = ExampleModSTUDENTTEMPLATE.MODID, version = ExampleModSTUDENTTEMPLATE.VERSION)
//@Mod is a tag that lets MinecraftForge know that it needs to load this file as a mod file
public class ExampleModSTUDENTTEMPLATE {

	// --------------------- Global Variables ---------------------
	// These two String variables are used by minecraftForge, just leave them as is!
	public static final String MODID = "examplemod";
	public static final String VERSION = "1.0";

	// Put your Item, Block and ToolMaterial global variables here!






	// --------------------- PreInitialization ---------------------
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		// Put "PREINIT" code here between the Open { and Closed } brackets

		// --------------------- ItemStacks ---------------------
		//make ItemStack variables for any item you would like to use in a smelting or crafting recipe








		// --------------------- Smelting Recipe's ---------------------
		//create your smelting recipe by registering it with the GameRegistry here








		// --------------------- Shapeless Crafting Recipe's ---------------------
		//Create your shapeless crafting recipe by registering it with the GameRegistry here








		// --------------------- Shaped Crafting Recipe's ---------------------
		//Create your shaped crafting recipe by registering it with the GameRegistry here		








		// --------------------- Code Custom Items, Tools and Blocks! ---------------------
		//Put your code to create Items, Tools and Blocks here!		

		
		
		
		
		
		
		
		// --------------------- Register Items, Tools and Blocks ---------------------
		//Register your custom Items, Tools and Blocks with the game registry here!
		
		





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
