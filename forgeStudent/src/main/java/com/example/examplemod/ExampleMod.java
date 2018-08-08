package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.Logger;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ItemStack leatherStack = new ItemStack(Items.LEATHER);
        ItemStack woolStack = new ItemStack(Blocks.WOOL);
        ItemStack iIngotStack = new ItemStack(Items.IRON_INGOT);
        ItemStack saddleStack = new ItemStack(Items.SADDLE);
        
        GameRegistry.addShapedRecipe(null, null, saddleStack, 
        "LLL",
        "LWL",
        "I I",
        'L', leatherStack,
        'W', woolStack,
        'I', iIngotStack
        );
        
        //ItemStack leatherStack = new ItemStack(Items.LEATHER);
        ItemStack eyeStack = new ItemStack(Items.ENDER_EYE);
        ItemStack blazeRodStack = new ItemStack(Items.BLAZE_ROD);
        ItemStack elytraStack = new ItemStack(Items.ELYTRA);
        
        GameRegistry.addShapedRecipe(null, null, elytraStack, 
        "LLL",
        "LEL",
        "B B",
        'L', leatherStack,
        'E', eyeStack,
        'B', blazeRodStack
        );
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
}

