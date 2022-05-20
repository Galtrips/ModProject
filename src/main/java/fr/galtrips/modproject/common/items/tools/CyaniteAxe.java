package fr.galtrips.modproject.common.items.tools;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.galtrips.modproject.common.ModProject;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CyaniteAxe extends ItemAxe {

	public CyaniteAxe(ToolMaterial material) {
		super(material);

		this.setUnlocalizedName("cyanite_axe");
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureName("modproject:cyaniteAxe");
		
		GameRegistry.registerItem(this, "cyanite_axe");
		
		GameRegistry.addRecipe(new ItemStack(this), new Object[] {"XX", "XY"," Y", 'X', ModProject.cyaniteIngot, 'Y', Items.stick});
	}
	
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {
		if (repair.getItem() == ModProject.cyaniteIngot) {
			return true;
		}
		return false;
	}
	
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase living ) {
		for (int i = y; i < 256; i++) {
			if (world.getBlock(x, i, z).isWood(world, x, i, z)) {
				stack.damageItem(1, living);
				if (!world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
					float f = 0.7F;
					double d0 = (double)(world.rand.nextFloat() *f) + (double)(1.0F - f) * 0.5F;
					double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    EntityItem entityItem = new EntityItem(world, (double)x + d0, (double)i + d1, (double)z + d2, new ItemStack(world.getBlock(x, i, z), 1));
                    entityItem.delayBeforeCanPickup = 10;
                    world.spawnEntityInWorld(entityItem);
				}
				world.setBlockToAir(x,i,z);
			} else {
				return super.onBlockDestroyed(stack, world, block, x, i, z, living);
			}
		}
		return super.onBlockDestroyed(stack, world, block, x, y, z, living);
	}

}
