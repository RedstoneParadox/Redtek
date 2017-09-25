package com.mod.redtek.tileentities;

import net.minecraft.tileentity.TileEntity;

/**
 * Created by RedstoneParadox on 9/23/2017.
 */
public class TileEntityHotAir extends TileEntity {

    public int temperature = 0;

    public TileEntityHotAir() {

    }

    public TileEntityHotAir(int temp) {
        this.temperature = temp;
    }

    @Override
    public void onLoad(){
        System.out.println("hi");
    }

}
