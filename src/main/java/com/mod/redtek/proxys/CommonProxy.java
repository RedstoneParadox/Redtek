package com.mod.redtek.proxys;

import com.mod.redtek.Redtek;
import com.mod.redtek.eventhandlers.RedtekEventHandler;
import com.mod.redtek.old.blocks.RedtekBlocks;
import com.mod.redtek.old.tileentities.HeatVent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by RedstoneParadox on 3/11/2017.
 */
@Mod.EventBusSubscriber(modid = Redtek.MODID)
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new RedtekEventHandler());
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new HeatVent(true));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(RedtekBlocks.HEAT_VENT).setRegistryName(RedtekBlocks.HEAT_VENT.getRegistryName()));
    }
}

