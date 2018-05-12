package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OldGenericArmor extends ItemArmor {

	public OldGenericArmor(ArmorMaterial material, int armorType, String name) {
		super(material, 0, armorType);
		this.setUnlocalizedName(name);
		this.setTextureName(ExampleMod.MODID + ":" + getUnlocalizedName().substring(5));
		
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		// TODO Auto-generated method stub
		if(stack.getItem()==ExampleMod.obsidianHelmet || 
				stack.getItem()==ExampleMod.obsidianChestplate || 
				stack.getItem()==ExampleMod.obsidianBoots)
		{
		return ExampleMod.MODID + ":textures/models/armor/Obsidian_layer_1.png";	
		}
		else if(stack.getItem()==ExampleMod.obsidianLeggings)
		{
			return ExampleMod.MODID + ":textures/models/armor/Obsidian_layer_2.png";	
		}
		
		
		
		return null;
	}

	

}
