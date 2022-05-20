package fr.galtrips.modproject.common.items.tools;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.galtrips.modproject.common.ModProject;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class CyaniteHoe extends ItemHoe {

	public CyaniteHoe(ToolMaterial material) {
		super(material);
		
		this.setUnlocalizedName("cyanite_hoe");
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureName("modproject:cyaniteHoe");
		
		GameRegistry.registerItem(this, "cyanite_hoe");
		
		GameRegistry.addRecipe(new ItemStack(this), new Object[] {"XX", " Y", " Y", 'X', ModProject.cyaniteIngot, 'Y', Items.stick});
	}
	
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {
		if (repair.getItem() == ModProject.cyaniteIngot) {
			return true;
		}
		return false;
	}

}
