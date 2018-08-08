package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.Logger;

@Mod(modid = ExampleMod2.MODID, name = ExampleMod2.NAME, version = ExampleMod2.VERSION)
public class ExampleMod2
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    	//recipe 1
    	
    	
        ItemStack leatherStack = new ItemStack(Items.LEATHER);
        ItemStack woolStack = new ItemStack(Blocks.WOOL);
        ItemStack iIngotStack = new ItemStack(Items.IRON_INGOT);
        ItemStack saddleStack = new ItemStack(Items.SADDLE);
        
     // must create a ResourceLocation for each recipe along with item stacks
    	// the string that you put in the quotes will be the name of the recipe when
    	// you click the green book in the crafting table
    	// use the ResourceLocation variable name as the first two parameters when creating
    	// new shaped crafting recipes
    	ResourceLocation saddle = new ResourceLocation("saddle");
        
        GameRegistry.addShapedRecipe( saddle, saddle, saddleStack, new Object[]{
        "LLL",
        "LWL",
        "I I",
        'L', leatherStack,
        'W', woolStack,
        'I', iIngotStack}
        );
        
        
        
        //ItemStack leatherStack = new ItemStack(Items.LEATHER);
        ItemStack eyeStack = new ItemStack(Items.ENDER_EYE);
        ItemStack blazeRodStack = new ItemStack(Items.BLAZE_ROD);
        ItemStack elytraStack = new ItemStack(Items.ELYTRA);
        
//        GameRegistry.addShapedRecipe(null, null, elytraStack, 
//        "LLL",
//        "LEL",
//        "B B",
//        'L', leatherStack,
//        'E', eyeStack,
//        'B', blazeRodStack
//        );
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
}

