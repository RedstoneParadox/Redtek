package com.mod.redtek.old.blocks;

import com.mod.redtek.old.MoltenGoldBlock;
import com.mod.redtek.old.MoltenIronBlock;
import com.mod.redtek.old.Steam;
import com.mod.redtek.old.tileentities.HeatVent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by RedstoneParadox on 3/11/2017.
 */
public class RedtekBlocks {


    @GameRegistry.ObjectHolder("redtek:heat_vent")
    public static HeatVent HEAT_VENT;
    @GameRegistry.ObjectHolder("redtek:molten_iron_block")
    public static MoltenIronBlock MOLTEN_IRON_BLOCK;
    @GameRegistry.ObjectHolder("redtek:molten_gold_block")
    public static MoltenGoldBlock MOLTEN_GOLD_BLOCK;
    @GameRegistry.ObjectHolder("redtek:turbine")
    public static Turbine TURBINE;
    @GameRegistry.ObjectHolder("redtek:steam")
    public static Steam STEAM;
    @GameRegistry.ObjectHolder("redtek:organic_generator")
    public static OrganicGenerator ORGANIC_GENERATOR;
    @GameRegistry.ObjectHolder("redtek:floodgate")
    public static FloodGate FLOODGATE;
    @GameRegistry.ObjectHolder("redtek:hot_air")
    public static HotAir HOT_AIR;
    @GameRegistry.ObjectHolder("redtek:heat_test_block")
    public static HeatTestBlock HEAT_TEST_BLOCK;

    public static void init() {
        HEAT_VENT = new HeatVent(true);
        MOLTEN_IRON_BLOCK = new MoltenIronBlock();
        MOLTEN_GOLD_BLOCK = new MoltenGoldBlock();
        TURBINE = new Turbine();
        STEAM = new Steam();
        ORGANIC_GENERATOR = new OrganicGenerator();
        FLOODGATE = new FloodGate();
        HOT_AIR = new HotAir();
        HEAT_TEST_BLOCK = new HeatTestBlock();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        HEAT_VENT.initModel();
        MOLTEN_IRON_BLOCK.initModel();
        MOLTEN_GOLD_BLOCK.initModel();
        TURBINE.initModel();
        STEAM.initModel();
        ORGANIC_GENERATOR.initModel();
        FLOODGATE.initModel();
        HOT_AIR.initModel();
        HEAT_TEST_BLOCK.initModel();
    }
}