package fr.galtrips.modproject.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.galtrips.modproject.common.ModProject;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SteelIngot extends Item {

	public SteelIngot() {
		this.setUnlocalizedName("steel_ingot");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		
		GameRegistry.registerItem(this, "steel_ingot");
	}
	
	@Override
	public void registerIcons(IIconRegister iconregister) {
		this.itemIcon = iconregister.registerIcon(ModProject.MODID +":steelIngot");
	}
}
