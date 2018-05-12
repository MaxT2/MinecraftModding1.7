package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class GenericArmor extends ItemArmor {

	public GenericArmor(ArmorMaterial material, int armorType, String name) {
		super(material, 0, armorType); // this code runs when you use "new GenericArmor(stuff);
		this.setUnlocalizedName(name); // set the name to the name input we give when making a new GenericArmor();
		this.setTextureName(ExampleMod.MODID + ":" + getUnlocalizedName().substring(5)); // set texture name

	}

// we have to Override the getArmorTexture();
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		// if the item is a helmet, chestplate or boots then return layer 1
		if(stack.getItem() == ExampleMod.obsidianHelmet ||
				stack.getItem() == ExampleMod.obsidianChestplate ||
				stack.getItem() == ExampleMod.obsidianBoots){
			return ExampleMod.MODID + ":textures/mdels/armor/Obsidian_layer_1.png";
			
			// otherwise if the item are boots then return layer 2
		} else if(stack.getItem() == ExampleMod.obsidianLeggings){
			return ExampleMod.MODID + ":textures/.models/armor/Obsidian_layer_2.png";
		}
		
		// if not armor return nothing
		return null;
	}
	
	

@Override
public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
	
	// use the player to get the ItemStack equpiment in slot 1
	// get the Item from the Item stack
	// see if it is an instance of GenericArmor
//	player.inventory.armorInventory
//	ItemStack[] equippedArmor = player.inventory.armorInventory;
//	System.out.println(equippedArmor.length);
//	System.out.println(equippedArmor[0]);
//	System.out.println(equippedArmor[1]);
//	System.out.println(equippedArmor[2]);
//	System.out.println(equippedArmor[3]);
	
	
	// 3 = helmet, 2 = chestplate?, 1 = leggins?, 0 = boots?
	ItemStack[] equippedHelmet = player.inventory.armorInventory;
	if(equippedHelmet[3] != null && equippedHelmet[3].getItem() instanceof GenericArmor ){
		player.addPotionEffect(new PotionEffect(Potion.nightVision.id,1000,1));
	}
	
	
	super.onArmorTick(world, player, itemStack);
}


}