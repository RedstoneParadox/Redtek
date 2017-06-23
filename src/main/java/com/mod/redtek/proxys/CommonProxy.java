package com.mod.redtek.proxys;

import com.mod.redtek.blocksold.RedtekBlocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by RedstoneParadox on 3/11/2017.
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        RedtekBlocks.init();

    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}

