package fr.galtrips.modproject.common.models.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.galtrips.modproject.common.ModProject;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CyaniteArmor extends ItemArmor {

	public CyaniteArmor(ArmorMaterial material, int type) {
		super(material, 0, type);
		
		if (type == 0) {
			
			this.setUnlocalizedName("cyaniteHelmet");
			this.setTextureName(ModProject.MODID + ":cyanite_helmet");
			this.setCreativeTab(CreativeTabs.tabCombat);
			GameRegistry.registerItem(this, "cyanite_helmet");
		} else if (type == 1) {
			
			this.setUnlocalizedName("cyaniteChestPlate");
			this.setTextureName(ModProject.MODID + ":cyanite_chestplate");
			this.setCreativeTab(CreativeTabs.tabCombat);
			GameRegistry.registerItem(this, "cyanite_chestplate");
		} else if (type == 2) {
			
			this.setUnlocalizedName("cyaniteLeggings");
			this.setTextureName(ModProject.MODID + ":cyanite_leggings");
			this.setCreativeTab(CreativeTabs.tabCombat);
			GameRegistry.registerItem(this, "cyanite_leggings");
		} else if (type == 3) {
			
			this.setUnlocalizedName("cyaniteBoots");
			this.setTextureName(ModProject.MODID + ":cyanite_boots");
			this.setCreativeTab(CreativeTabs.tabCombat);
			GameRegistry.registerItem(this, "cyanite_boots");
		}
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

        if(stack.getItem() == ModProject.cyaniteLeggings) {
            return ModProject.MODID + ":textures/models/armor/cyanite_layer_2.png";
        }
        return ModProject.MODID + ":textures/models/armor/cyanite_layer_1.png";
    }
	
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {
		if (repair.getItem() == ModProject.cyaniteIngot) {
			return true;
		}
		return false;
	}
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (this.armorType == 0 && world.getBlockLightValue(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ)) < 8) {
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 220, 0));
		}
	}
	
}
