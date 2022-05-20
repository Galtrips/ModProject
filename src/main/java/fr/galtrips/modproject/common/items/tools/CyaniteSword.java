package fr.galtrips.modproject.common.items.tools;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.galtrips.modproject.common.ModProject;
import net.minecraft.command.IEntitySelector;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class CyaniteSword extends ItemSword {

	public CyaniteSword(ToolMaterial material) {
		super(material);
		
		this.setUnlocalizedName("cyanite_sword");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setTextureName("modproject:cyaniteSword");
		
		GameRegistry.registerItem(this, "cyanite_sword");
		
		GameRegistry.addRecipe(new ItemStack(this), new Object[]{"X","X","Y",'X', ModProject.cyaniteIngot, 'Y', Items.stick});
	}

	public boolean getIsRepairable(ItemStack input, ItemStack repair) {
		if (repair.getItem() == ModProject.cyaniteIngot) {
			return true;
		}
		return false;
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player.isSneaking()) {
			if(!stack.hasTagCompound()) {
				stack.setTagCompound(new NBTTagCompound());
			}
			byte mode = stack.getTagCompound().getByte("mode");
			mode++;
			if (mode == 3) {
				mode = 0;
			}
			stack.getTagCompound().setByte("mode", mode);
			if (!world.isRemote) {
				player.addChatMessage(new ChatComponentTranslation("sword.mode.message." + mode));
			}
		} else {
			super.onItemRightClick(stack, world, player);
		}
		return stack;
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase attackedLiving, EntityLivingBase attackerLiving) {
		if (!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
		}
		IEntitySelector filter;
		if (stack.getTagCompound().getByte("mode") == 0) {
			filter = new IEntitySelector() {
				@Override
				public boolean isEntityApplicable(Entity entity) {
					if (entity instanceof EntityPlayer) {
						return true;
					}
					return false;
				}
			};
		} else if (stack.getTagCompound().getByte("mode") == 1) {
			filter = new IEntitySelector() {
				@Override
				public boolean isEntityApplicable(Entity entity) {
					if (entity instanceof EntityMob) {
						return true;
					}		
					return false;
				}
			};
		} else {
			filter = new IEntitySelector() {
				@Override
				public boolean isEntityApplicable(Entity entity) {
					if (entity instanceof EntityAnimal) {
						return true;
					}
					return false;
				}
			};
		}
		
		List entityTargetList = attackedLiving.worldObj.selectEntitiesWithinAABB(EntityLivingBase.class, attackedLiving.boundingBox.expand(8.0D, 2.0D, 8.0D), filter);
		for (Object entity : entityTargetList) {
			EntityLivingBase living = (EntityLivingBase) entity;
			if (!living.equals(attackerLiving)) {
				living.setFire(4);
			}
		}
		return super.hitEntity(stack, attackedLiving, attackerLiving);
	}
}
