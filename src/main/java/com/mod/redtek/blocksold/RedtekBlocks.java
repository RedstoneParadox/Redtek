package com.mod.redtek.blocksold;

import com.mod.redtek.blocksold.tileentities.HeatVent;
import com.mod.redtek.blocksold.tileentities.Turbine;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by RedstoneParadox on 3/11/2017.
 */
public class RedtekBlocks {

    public static HeatVent HEAT_VENT;
    public static MoltenIronBlock MOLTEN_IRON_BLOCK;
    public static MoltenGoldBlock MOLTEN_GOLD_BLOCK;
    public static Turbine TURBINE;
    public static Steam STEAM;

    public static void init() {
        HEAT_VENT = new HeatVent(true);
        MOLTEN_IRON_BLOCK = new MoltenIronBlock();
        MOLTEN_GOLD_BLOCK = new MoltenGoldBlock();
        TURBINE = new Turbine();
        STEAM = new Steam();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        HEAT_VENT.initModel();
        MOLTEN_IRON_BLOCK.initModel();
        MOLTEN_GOLD_BLOCK.initModel();
        TURBINE.initModel();
        STEAM.initModel();
    }
}
