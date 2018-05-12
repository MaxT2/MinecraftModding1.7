package maxts2.tutorialmod;

import java.awt.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.examplemod.GenericItem;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.WorldAccessContainer;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import maxts2.tutorialmod.blocks.TBlock;
import maxts2.tutorialmod.entities.TMBlazeEntity;
import maxts2.tutorialmod.entities.TMEntityCreeper;
import maxts2.tutorialmod.entities.TMSnowballEntity;
import maxts2.tutorialmod.entities.TMSlimeEntity;
import maxts2.tutorialmod.entities.TMZombieEntity;
import maxts2.tutorialmod.items.CookedEgg;
import maxts2.tutorialmod.items.ObsidianPickaxe;
import maxts2.tutorialmod.items.ObsidianArrow;
import maxts2.tutorialmod.items.ObsidianAxe;
import maxts2.tutorialmod.items.ObsidianSword;
import maxts2.tutorialmod.items.TMPotion;
import maxts2.tutorialmod.items.TMSnowballItem;
import maxts2.tutorialmod.items.TMWand;
import maxts2.tutorialmod.render.TMZombieRenderer;
import maxts2.tutorialmod.tile.entity.TileEntityTChest;
import maxts2.tutorialmod.render.TMSnowballRenderer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemMinecart;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = ATutorialMod.MODID, version = ATutorialMod.VERSION, name = ATutorialMod.NAME)
public class ATutorialMod {

	public static final String MODID = "tm";
	public static final String VERSION = "1.0";
	public static final String NAME = "TutoriaMod";
	// setup logger after editing forgesrc1.7.10.jar log4j.xml with INFO >> DEBUG
	public static final Logger logger = LogManager.getFormatterLogger(MODID);

	// --------- Instantiation of Global Variables ----------
	public static Item cookedEgg;
	public static Block tBlock;
	public static Item obsidianSword;
	public static Item obsidianPickaxe;
	// public static Item glassSword;

	// create a custom Material for the obsidian tool
	//(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability)
	public static ToolMaterial obsidianToolMaterial = EnumHelper.addToolMaterial("Obsidian Tool Material", 3, 1000, 100.0F, 4.0F, 15);

	// ----- Extra Stuff ------
	public static Item obsidianShard;
	public static Item tMinecart;
	public static Item tWand;
	public static Item obsidianBow;
	public static Item obsidianArrow;
	public static Item strongPotion;
	public static TMZombieEntity tZombie;
	public static TMBlazeEntity tBlaze;
	public static TMSlimeEntity tSlime;
	public static Item tmSnowball;
	public static Item obsidianAxe;
	public static Block chest;
	public static Item flameStick;

	public static MinecraftForgeClient MFC = new MinecraftForgeClient();
	// event handler class
	TMEventHandler handler = new TMEventHandler();
	
	
	//trying to replace existing recipe
	//private CraftingManager cm = CraftingManager.getInstance();

	// ---- grab the instantly of this mod ----
	 @Instance(MODID)
     public ATutorialMod instance;

	// /effect ID 10 20 10


	@EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		// register event handler with FML and Forge
		FMLCommonHandler.instance().bus().register(handler);
		MinecraftForge.EVENT_BUS.register(handler);
		
		// testing to replace a recpie...
//		List recipeList = new List();
//		ItemStack recipeToChange = new ItemStack(Items.stick);
//		cm.findMatchingRecipe(p_82787_1_, )
		
		
		
		
		 // set constructor to 0 (canProvidePower)
		chest = new TChest(0)
				.setBlockName("TChest")
				.setCreativeTab(CreativeTabs.tabBlock)
				.setBlockTextureName(":chest")
				;
		
		GameRegistry.registerBlock(chest, "TChest");
		GameRegistry.registerTileEntity(TileEntityTChest.class, ATutorialMod.MODID);
	
		
		
		
		
		
		
		
		
		//Item/Block Registering
				//Config Handling


		// ---------- instantiate new blocks ----------
		// create cookedEgg Item from GenericFood.java class
		// heal amount, saturation modifier, wolves favorite food
		cookedEgg = new CookedEgg(5, 0.6F, false)
				//setPotionEffect(int potionId, int duration (will be multiplied by 20), int amplifier, float probability of effect happening)
				.setPotionEffect(Potion.regeneration.id, 5, 0, 1.0F)	//(int potionId, int duration (will be multiplied by 20), int amplifier, float probability of effect happening
				.setCreativeTab(CreativeTabs.tabFood)
				//.setTextureName(MODID + ":cookedEgg")
				.setTextureName(":apple")
				.setUnlocalizedName("cookedEgg")
				.setMaxStackSize(16); // Can hold up to 16 in a stack (like Eggs)

		// use the command "/effect @p 17 200 10
		
		
		
		// create obsidianSword Tool Item from GenericSword.java class
		obsidianSword = new ObsidianSword(obsidianToolMaterial)
				.setUnlocalizedName("obsidianSword")
				.setTextureName(MODID + ":obsidianSword")
				.setCreativeTab(CreativeTabs.tabCombat);



		// create tBlock Block from tBlock.java class
		tBlock = new TBlock(Material.cloth) // means it will act like cloth - it will mine like this material
				.setBlockName("tBlock")  					//should always set this
				.setCreativeTab(CreativeTabs.tabBlock)		//should always set this
				.setBlockTextureName(MODID + ":tBlock")	//should always set this
				.setHardness(1.5f) 							// hardness of stone
				.setResistance(10f) 						// resistance to explosions of stone
				.setStepSound(Block.soundTypeCloth) 		// sounds like stone when you walk on it
				.setLightLevel(0.0f)							 // between 0.0f and 1.0f (1f is as bright as the sun)
				;
		// create obsidianShard Item from GenericItem.java class
		obsidianShard = new GenericItem()
				.setCreativeTab(CreativeTabs.tabMaterials)
				.setTextureName(MODID + ":obsidianShard")
				.setUnlocalizedName("obsidianShard")

				;

		obsidianPickaxe = new ObsidianPickaxe(obsidianToolMaterial)
				.setUnlocalizedName("obsidianPickaxe")
				.setTextureName(MODID + ":obsidianPickaxe")
				.setCreativeTab(CreativeTabs.tabTools)
				;

		tWand = new TMWand()
				.setUnlocalizedName("tWand")
				.setTextureName(":stick")
				.setCreativeTab(CreativeTabs.tabTools)
				;

		obsidianBow = new ItemBow()
				.setUnlocalizedName("obsidianBow")
				.setTextureName(MODID + ":obsidianBow")
				.setCreativeTab(CreativeTabs.tabCombat)
				.setMaxDamage(1000)
				;

		obsidianArrow = new ObsidianArrow()
				.setUnlocalizedName("obsidianArrow")
				.setCreativeTab(CreativeTabs.tabCombat)
				.setTextureName(":arrow")
				;
		strongPotion = new TMPotion();


		tmSnowball = new TMSnowballItem()
				.setUnlocalizedName("TMSnowball")
				.setTextureName(":snowball")
				;

		obsidianAxe = new ObsidianAxe(obsidianToolMaterial)
				.setUnlocalizedName("obsidianAxe")
				.setTextureName(MODID + ":obsidianAxe")
				.setCreativeTab(CreativeTabs.tabCombat)
				;

		flameStick = new FlameStick()
				.setUnlocalizedName("flameStick")
				.setTextureName(":stick")
				.setCreativeTab(CreativeTabs.tabCombat)
				;
		GameRegistry.registerItem(flameStick, "flameStick");
		
		
		
		
		
		
		
		

		// --------- Register new Blocks and Items with GameRegistry ---------
		GameRegistry.registerBlock(tBlock, tBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(cookedEgg, cookedEgg.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(obsidianShard, obsidianShard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(obsidianSword, obsidianSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(obsidianPickaxe, obsidianPickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tWand, tWand.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(obsidianBow, obsidianBow.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(obsidianArrow, obsidianArrow.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tmSnowball, tmSnowball.getUnlocalizedName().substring(5));

		// name items without .lang file
		LanguageRegistry.addName(obsidianBow, "Obsidian Bow");



		// ----------- Create ItemStacks for crafting recipes -----------
		ItemStack cookedEggStack = new ItemStack(cookedEgg);    			//stack with 1 cookedEgg
		ItemStack eggStack = new ItemStack(Items.egg);						// stack with 1 egg
		ItemStack obsidianSwordStack = new ItemStack(obsidianSword);		//stack with one obsidianSword
		ItemStack obsidianShardStack_9 = new ItemStack(obsidianShard, 9);	// stack with 9 obsidianShards
		ItemStack obsidianStack = new ItemStack(Blocks.obsidian, 1);		// stack with 1 obsidian
		ItemStack stoneStack = new ItemStack(Blocks.stone);					// stack with 1 stone
		ItemStack myBlockStack = new ItemStack(tBlock);					// stack with on tBlock




		// create item
		ItemStack woodStack = new ItemStack(Blocks.planks);
		ItemStack seedStack = new ItemStack(Items.wheat_seeds);

		GameRegistry.addShapelessRecipe(woodStack, new Object[]{
				seedStack

		});




		// --------- Register Recipes with GameRegistry ---------
		// Smelting
		GameRegistry.addSmelting(eggStack, cookedEggStack, 1000f);				// smelts egg into cooked egg
		GameRegistry.addSmelting(stoneStack,myBlockStack, 10f);					// smelts stone into tBlock
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


		/// ---- Extra Stuff ----
		//		tMinecart = new GenericMinecart(WorldAccessContainer);

		// register entity renderer with
		RenderingRegistry.registerEntityRenderingHandler(TMZombieEntity.class, new TMZombieRenderer(new ModelZombie(),2f)); // ModelZombie means shape of the texutre!
		RenderingRegistry.registerEntityRenderingHandler(TMSnowballEntity.class, new TMSnowballRenderer(tmSnowball,1));




		// register entity spawner
		EntityRegistry.addSpawn(TMZombieEntity.class, 100000, 1, 2, EnumCreatureType.monster,
			      BiomeGenBase.plains); //change the values to vary the spawn rarity, biome, etc.


		FMLCommonHandler.instance().bus().register(new WallClimber());
		MinecraftForge.EVENT_BUS.register(new WallClimber());


		MinecraftForge.EVENT_BUS.register(new ArrowShotgun());
		MinecraftForge.EVENT_BUS.register(new PlayerEventBase());






	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Proxy, TileEntity, entity, GUI and Packet Registering


		// register new mod entities!
		EntityRegistry.registerModEntity(TMZombieEntity.class, "T-Zombie", 30, instance, 30, 1, true);
		EntityRegistry.registerModEntity(TMBlazeEntity.class, "T-Blaze", 31, instance, 30, 1, true);;
		EntityRegistry.registerModEntity(TMSlimeEntity.class, "T-Slime", 32, instance, 200, 1, true);
		EntityRegistry.registerModEntity(TMSnowballEntity.class, "TMSnowball", 33, instance, 30, 1, true);
		EntityRegistry.registerModEntity(TMEntityCreeper.class, "TM-Creeper", 34, instance, 30, 1, true);
		EntityRegistry.registerGlobalEntityID(TMEntityCreeper.class, "TM-Creeper", 34);


	}

	@EventHandler
	public void Postinit(FMLPostInitializationEvent event)
	{
		//Proxy, TileEntity, entity, GUI and Packet Registering

	}




}
