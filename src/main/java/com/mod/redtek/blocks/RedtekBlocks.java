package com.mod.redtek.blocks;

import com.mod.redtek.blocksold.MoltenGoldBlock;
import com.mod.redtek.blocksold.MoltenIronBlock;
import com.mod.redtek.blocksold.Steam;
import com.mod.redtek.blocksold.tileentities.HeatVent;
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
