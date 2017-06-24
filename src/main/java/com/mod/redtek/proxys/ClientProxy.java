package com.mod.redtek.proxys;

import com.mod.redtek.blocks.RedtekBlocks;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by RedstoneParadox on 3/11/2017.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        RedtekBlocks.initModels();
    }
}
