package fr.galtrips.modproject.common.items.tools;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.galtrips.modproject.common.ModProject;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class CyaniteShovel extends ItemSpade {

	public CyaniteShovel(ToolMaterial material) {
		super(material);

		this.setUnlocalizedName("cyanite_shovel");
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureName("modproject:cyaniteShovel");
		
		GameRegistry.registerItem(this, "cyanite_shovel");
		
		GameRegistry.addRecipe(new ItemStack(this), new Object[]{"X","Y","Y",'X', ModProject.cyaniteIngot, 'Y', Items.stick});
	}
	
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {
		if (repair.getItem() == ModProject.cyaniteIngot) {
			return true;
		}
		return false;
	}

}
