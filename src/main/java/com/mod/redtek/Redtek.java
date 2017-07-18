package com.mod.redtek;

import com.mod.redtek.proxys.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

/**
 * Created by RedstoneParadox on 3/11/2017.
 */

@Mod(modid = Redtek.MODID, name = Redtek.MODNAME, version = Redtek.VERSION, dependencies = "required-after:forge@[14.21.1.2387,)", useMetadata = true)
public class Redtek {

    public static final String MODID = "redtek";
    public static final String MODNAME = "redtek";
    public static final String VERSION = "0.0.1";
    public static final MachineryTab creativeTab = new MachineryTab();

    @SidedProxy(clientSide = "com.mod.redtek.proxys.ClientProxy", serverSide = "com.mod.redtek.proxys.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Redtek instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
