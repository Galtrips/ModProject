package fr.galtrips.modproject.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.galtrips.modproject.common.ModProject;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CyaniteIngot extends Item {
	
	public CyaniteIngot() {
		this.setUnlocalizedName("cyanite_ingot");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		//this.setTextureName("modproject:cyaniteIngot");
		
		GameRegistry.registerItem(this, "cyanite_ingot");
	}
	
	@Override
	public void registerIcons(IIconRegister iconregister) {
		this.itemIcon = iconregister.registerIcon("modproject:cyaniteIngot");
	}
}
