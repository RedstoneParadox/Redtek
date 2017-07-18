package com.mod.redtek.proxys;

import com.mod.redtek.Redtek;
import com.mod.redtek.blocks.RedtekBlocks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by RedstoneParadox on 3/11/2017.
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Redtek.MODID)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        RedtekBlocks.initModels();
    }
}
