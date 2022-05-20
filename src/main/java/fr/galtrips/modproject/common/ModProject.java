package fr.galtrips.modproject.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.galtrips.modproject.common.items.CyaniteIngot;
import fr.galtrips.modproject.common.items.SteelIngot;
import fr.galtrips.modproject.common.items.tools.CyaniteAxe;
import fr.galtrips.modproject.common.items.tools.CyaniteHoe;
import fr.galtrips.modproject.common.items.tools.CyanitePickaxe;
import fr.galtrips.modproject.common.items.tools.CyaniteShovel;
import fr.galtrips.modproject.common.items.tools.CyaniteSword;
import fr.galtrips.modproject.common.models.armor.CyaniteArmor;
import fr.galtrips.modproject.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = "modproject", name = "Mod Project", version = "1.0.0")

public class ModProject {
	
	@Instance("modproject")
	public static ModProject instance;
	
	public static final String MODID = "modproject";
	
	@SidedProxy(clientSide = "fr.galtrips.modproject.proxy.ClientProxy", serverSide = "fr.galtrips.modproject.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	//Ingot Item
	public static Item cyaniteIngot, steelIngot;
	
	//Armor Item
	public static Item cyaniteHelmet, cyaniteChestPlate, cyaniteLeggings, cyaniteBoots;
	
	//Tool Item
	public static Item cyaniteSword, cyaniteAxe,cyaniteShovel, cyanitePickaxe, cyaniteHoe;
	
	//EnumType
	public static ArmorMaterial cyaniteArmor = EnumHelper.addArmorMaterial("cyaniteArmor", 25, new int[] {4, 6,5,4}, 20);
	public static ToolMaterial cyaniteTool = EnumHelper.addToolMaterial("cyaniteTool", 3, 855, 12.0F, 4.0F, 18);
	
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		//Ingots
		cyaniteIngot = new CyaniteIngot();
		steelIngot = new SteelIngot();
		
		//Armors
		cyaniteHelmet = new CyaniteArmor(cyaniteArmor, 0); 
		cyaniteChestPlate = new CyaniteArmor(cyaniteArmor, 1);
		cyaniteLeggings = new CyaniteArmor(cyaniteArmor, 2);
		cyaniteBoots = new CyaniteArmor(cyaniteArmor, 3);
		
		//Tools
		cyaniteSword = new CyaniteSword(cyaniteTool);
		cyanitePickaxe = new CyanitePickaxe(cyaniteTool);
		cyaniteAxe = new CyaniteAxe(cyaniteTool);
		cyaniteShovel = new CyaniteShovel(cyaniteTool);
		cyaniteHoe = new CyaniteHoe(cyaniteTool);	
    }
    	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
    	proxy.registerRender();
    }
    	
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
}