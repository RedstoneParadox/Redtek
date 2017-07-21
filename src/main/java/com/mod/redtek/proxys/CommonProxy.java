package com.mod.redtek.proxys;

import com.mod.redtek.Redtek;
import com.mod.redtek.blocks.OrganicGenerator;
import com.mod.redtek.blocks.RedtekBlocks;
import com.mod.redtek.blocks.Turbine;
import com.mod.redtek.blocksold.MoltenGoldBlock;
import com.mod.redtek.blocksold.MoltenIronBlock;
import com.mod.redtek.blocksold.Steam;
import com.mod.redtek.blocksold.tileentities.HeatVent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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

    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new HeatVent(true));
        event.getRegistry().register(new MoltenIronBlock());
        event.getRegistry().register(new MoltenGoldBlock());
        event.getRegistry().register(new Turbine());
        event.getRegistry().register(new Steam());
        event.getRegistry().register(new OrganicGenerator());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(RedtekBlocks.HEAT_VENT).setRegistryName(RedtekBlocks.HEAT_VENT.getRegistryName()));
        event.getRegistry().register(new ItemBlock(RedtekBlocks.MOLTEN_IRON_BLOCK).setRegistryName(RedtekBlocks.MOLTEN_IRON_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(RedtekBlocks.MOLTEN_GOLD_BLOCK).setRegistryName(RedtekBlocks.MOLTEN_GOLD_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(RedtekBlocks.TURBINE).setRegistryName(RedtekBlocks.TURBINE.getRegistryName()));
        event.getRegistry().register(new ItemBlock(RedtekBlocks.STEAM).setRegistryName(RedtekBlocks.STEAM.getRegistryName()));
        event.getRegistry().register(new ItemBlock(RedtekBlocks.ORGANIC_GENERATOR).setRegistryName(RedtekBlocks.ORGANIC_GENERATOR.getRegistryName()));
    }
}

