package fr.galtrips.modproject.common.items.tools;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.galtrips.modproject.common.ModProject;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class CyanitePickaxe extends ItemPickaxe {

	public CyanitePickaxe(ToolMaterial material) {
		super(material);

		this.setUnlocalizedName("cyanite_pickaxe");
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureName("modproject:cyanitePickaxe");
		
		GameRegistry.registerItem(this, "cyanite_pickaxe");
		
		GameRegistry.addRecipe(new ItemStack(this), new Object[] {"XXX"," Y ", " Y ", 'X', ModProject.cyaniteIngot, 'Y', Items.stick});
	}
	
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {
		if (repair.getItem() == ModProject.cyaniteIngot) {
			return true;
		}
		return false;
	}

}
