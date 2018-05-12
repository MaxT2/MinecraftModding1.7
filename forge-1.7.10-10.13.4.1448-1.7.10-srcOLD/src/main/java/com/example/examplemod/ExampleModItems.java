package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;

//@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleModItems
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
   
    
    // Block and Item Definitions
    public static Block myBlock;
    public static Item cookedEgg;
    public static Item obsidianShard;
    public static Item obsidianSword;

	// create a custom Material for the obsidian tool
    //(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability)    
    public static ToolMaterial obsidianToolMaterial = EnumHelper.addToolMaterial("Obsidian Tool Material", 3, 1000, 10.0F, 4.0F, 15);
   
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	// ---------- instantiate new blocks ---------- 
    	// create myBlock Block from myBlock.java class
    	myBlock = new myBlock(Material.rock) // means it will act like rock (you need a stone pickaxe or better to pick it up)
    			.setBlockName("myBlock")  					//should always set this (same as variable name)
    			.setCreativeTab(CreativeTabs.tabBlock)		//should always set this
    			.setBlockTextureName(MODID + ":myBlock")	//should always set this - MODID + ":(variable name)"
    			.setHardness(1.5f) 							// hardness of stone
    			.setResistance(10f) 						// resistance to explosions of stone
    			.setStepSound(Block.soundTypeStone) 		// sounds like stone when you walk on it
    			.setLightLevel(1f);							 // between 0.0f and 1.0f (1f is as bright as the sun)    											
    	
    			// create cookedEgg Item from GenericFood.java class
    	cookedEgg = new GenericFood(5, 0.6F, false)
    			//setPotionEffect(int potionId, int duration (will be multiplied by 20), int amplifier, float probability of effect happening)
    			.setPotionEffect(Potion.regeneration.id, 5, 0, 1.0F)	//(int potionId, int duration (will be multiplied by 20), int amplifier, float probability of effect happening
    			.setCreativeTab(CreativeTabs.tabFood)
		    	.setTextureName(MODID + ":cookedEgg")
		    	.setUnlocalizedName("cookedEgg")
		    	.setMaxStackSize(16); // Can hold up to 16 in a stack (like Eggs)
		    	
    	// create obsidianShard Item from GenericItem.java class
    	obsidianShard = new GenericItem()
    			.setCreativeTab(CreativeTabs.tabMaterials)    			
    			.setTextureName(MODID + ":obsidianShard")		
    			.setUnlocalizedName("obsidianShard");
    	
    	// create obsidianSword Tool Item from GenericSword.java class
    	obsidianSword = new GenericSword(obsidianToolMaterial)
    			.setUnlocalizedName("obsidianSword")
    		    .setTextureName(MODID + ":obsidianSword")
    		    .setCreativeTab(CreativeTabs.tabCombat);

    	// --------- Register new Blocks and Items with GameRegistry ---------
    	GameRegistry.registerBlock(myBlock, "myBlock");
		GameRegistry.registerItem(cookedEgg, "cookedEgg");
		GameRegistry.registerItem(obsidianShard, "obsidianShard");
		GameRegistry.registerItem(obsidianSword, "obsidianSword");
    	
    	// ----------- Create ItemStacks for crafting recipes -----------
		ItemStack cookedEggStack = new ItemStack(cookedEgg);    			//stack with 1 cookedEgg
		ItemStack eggStack = new ItemStack(Items.egg);						// stack with 1 egg
		ItemStack obsidianSwordStack = new ItemStack(obsidianSword);		//stack with one obsidianSword
		ItemStack obsidianShardStack_9 = new ItemStack(obsidianShard, 9);	// stack with 9 obsidianShards 
    	ItemStack obsidianStack = new ItemStack(Blocks.obsidian, 1);		// stack with 1 obsidian
		ItemStack stoneStack = new ItemStack(Blocks.stone);					// stack with 1 stone
		ItemStack myBlockStack = new ItemStack(myBlock);					// stack with on myBlock
		
		// --------- Register Recipes with GameRegistry ---------
		// Smelting
		GameRegistry.addSmelting(eggStack, cookedEggStack, 1000f);				// smelts egg into cooked egg
		GameRegistry.addSmelting(stoneStack,myBlockStack, 10f);					// smelts stone into myBlock
		// Shapeless
	 	GameRegistry.addShapelessRecipe(obsidianShardStack_9, obsidianStack);	// crafts 1 obsiidan into 9 shards
    	GameRegistry.addShapelessRecipe(obsidianStack, new Object[]				// crafts 9 shards into 1 obsidian
    			{
    	    			obsidianShard,obsidianShard,obsidianShard,obsidianShard,obsidianShard,
    	    			obsidianShard,obsidianShard,obsidianShard,obsidianShard,
    			});
		// Shaped
		GameRegistry.addShapedRecipe(obsidianSwordStack, new Object[]		//craft an obsidian sword from 2 obsidian, 1 stick, and 2 shards
				{
						" O ",
						" O ",
						"BSB",
						'O',Blocks.obsidian,
						'S',Items.stick,
						'B',obsidianShard
				});

    } // end of preinit()
} // end of class file