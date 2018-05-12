package maxts2.tutorialmod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import maxts2.tutorialmod.ATutorialMod;
import maxts2.tutorialmod.entities.TMObsidianEntityArrow;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ObsidianBow extends ItemBow {

	  public static final String[] bowPullIconNameArray = new String[] {"pulling_0", "pulling_1", "pulling_2"};
	    @SideOnly(Side.CLIENT)
	    private IIcon[] iconArray;
	    private static final String __OBFID = "CL_00001777";

	    public ObsidianBow()
	    {
	        this.maxStackSize = 1;
	        this.setMaxDamage(1000);
	        this.setCreativeTab(CreativeTabs.tabCombat)
	        ;
	    }

	    /**
	     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	     */
	    @Override
	    public void onPlayerStoppedUsing(ItemStack item, World world, EntityPlayer player, int intNum)
	    {
	    	// j = charge
	        int j = this.getMaxItemUseDuration(item) - intNum;
	   
	    	
	    	
	        ArrowLooseEvent event = new ArrowLooseEvent(player, item, j);
	        MinecraftForge.EVENT_BUS.post(event);
	        if (event.isCanceled())
	        {
	            return;
	        }
	        j = event.charge;

	        boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, item) > 0;

	        if (flag || player.inventory.hasItem(ATutorialMod.obsidianArrow))
	        {
	            float f = (float)j / 20.0F;
	            f = (f * f + f * 2.0F) / 3.0F;

	            if ((double)f < 0.1D)
	            {
	                return;
	            }

	            if (f > 1.0F)
	            {
	                f = 1.0F;
	            }

	            TMObsidianEntityArrow entityarrow = new TMObsidianEntityArrow(world, player, f * 2.0F);

	            if (f == 1.0F)
	            {
	                entityarrow.setIsCritical(true);
	            }

	            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, item);

	            if (k > 0)
	            {
	                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
	            }

	            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, item);

	            if (l > 0)
	            {
	                entityarrow.setKnockbackStrength(l);
	            }

	            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, item) > 0)
	            {
	                entityarrow.setFire(100);
	            }

	            item.damageItem(1, player);
	            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

	            if (flag)
	            {
	                entityarrow.canBePickedUp = 2;
	            }
	            else
	            {
	                player.inventory.consumeInventoryItem(ATutorialMod.obsidianArrow);
	            }

	            if (!world.isRemote)
	            {
	            	// change velocity of arrow before spawning
//	            	entityarrow.setVelocity(entityarrow.motionX*10, entityarrow.motionY*10, entityarrow.motionZ*10);
	            //	entityarrow.setVelocity(entityarrow.getVelocityX() * 99999D , entityarrow.getVelocityY() * 9999D, entityarrow.getVelocityZ() * 999D);
	                world.spawnEntityInWorld(entityarrow);
	            }
	        }
	    }
	    @Override
	    public ItemStack onEaten(ItemStack item, World world, EntityPlayer player)
	    {
	        return item;
	    }

	    /**
	     * How long it takes to use or consume an item
	     */
	    @Override
	    public int getMaxItemUseDuration(ItemStack item)
	    {
	        return 72000;
	    }

	    /**
	     * returns the action that specifies what animation to play when the items is being used
	     */
	    @Override
	    public EnumAction getItemUseAction(ItemStack item)
	    {
	        return EnumAction.bow;
	    }

	    /**
	     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	     */
	    @Override
	    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
	    {
	        ArrowNockEvent event = new ArrowNockEvent(player, item);
	        MinecraftForge.EVENT_BUS.post(event);
	        if (event.isCanceled())
	        {
	            return event.result;
	        }

	        if (player.capabilities.isCreativeMode || player.inventory.hasItem(ATutorialMod.obsidianArrow))
	        {
	            player.setItemInUse(item, this.getMaxItemUseDuration(item));
	        }

	        return item;
	    }

	    /**
	     * Return the enchantability factor of the item, most of the time is based on material.
	     */
	    @Override
	    public int getItemEnchantability()
	    {
	        return 1;
	    }
//	    @Override
//	    @SideOnly(Side.CLIENT)
//	    public void registerIcons(IIconRegister p_94581_1_)
//	    {
////	        this.itemIcon = p_94581_1_.registerIcon(this.getIconString() + "_standby");
//	        this.itemIcon = p_94581_1_.registerIcon("tm:obsidianBow" + "_standby");
//	        this.iconArray = new IIcon[bowPullIconNameArray.length];
//
//	        for (int i = 0; i < this.iconArray.length; ++i)
//	        {
//	//            this.iconArray[i] = p_94581_1_.registerIcon(this.getIconString() + "_" + bowPullIconNameArray[i]);
//	            this.iconArray[i] = p_94581_1_.registerIcon("tm:obsidianBow_" + bowPullIconNameArray[i]);
//	            
//	           System.out.println( this.getIconString() + "_" + bowPullIconNameArray[i] + "---------------------");
//	            
//	        }
//	    }

	   
	    @Override
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IIconRegister iconRegister){
	    iconArray = new IIcon[4];
	    iconArray[0] = iconRegister.registerIcon("tm:obsidianBow_standby");
	    iconArray[1] = iconRegister.registerIcon("tm:obsidianBow_pulling_0");
	    iconArray[2] = iconRegister.registerIcon("tm:obsidianBow_pulling_1");
	    iconArray[3] = iconRegister.registerIcon("tm:obsidianBow_pulling_2");
	    }
	    
	    
	    
	    @Override
	    @SideOnly(Side.CLIENT)
	    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
	    if (usingItem == null) { return itemIcon; }
	    int ticksInUse = stack.getMaxItemUseDuration() - useRemaining;
	    if (ticksInUse > 17) {
	    return iconArray[2];
	    } else if (ticksInUse > 13) {
	    return iconArray[1];
	    } else if (ticksInUse > 0) {
	    return iconArray[0];
	    } else {
	    return itemIcon;
	    }
	    }
	    
	    /**
	     * used to cycle through icons based on their used duration, i.e. for the bow
	     */
	    @Override
	    @SideOnly(Side.CLIENT)
	    public IIcon getItemIconForUseDuration(int p_94599_1_)
	    {
	        return this.iconArray[p_94599_1_];
	    }

	    
//	    @Override
//	    @SideOnly(Side.CLIENT)
//	    public IIcon getIcon (ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
//	    {
//	    	System.out.println("------------ ObsidianBow.getIcon() CALLED ----------------");
//	    	
//	        if (usingItem != null)
//	        {
//	            int time = 72000 - useRemaining;
//	            if (time < 8)
//	                return iconArray[0];
//	            if (time < 14)
//	                return iconArray[1];
//	            return iconArray[2];
//	        }
//	        return getIcon(stack, renderPass);
//	    }
	    
//	    @Override
//	    @SideOnly(Side.CLIENT)
//	    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
//	            if (usingItem == null) { return itemIcon; }
//	            int ticksInUse = stack.getMaxItemUseDuration() - useRemaining;
//	            if (ticksInUse > 17) {
//	                return iconArray[2];
//	            } else if (ticksInUse > 13) {
//	                return iconArray[1];
//	            } else if (ticksInUse > 0) {
//	                return iconArray[0];
//	            } else {
//	                return itemIcon;
//	            }
//	        }
	    
	    
	    

}
