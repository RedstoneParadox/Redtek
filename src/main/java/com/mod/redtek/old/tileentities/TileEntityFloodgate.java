package com.mod.redtek.old.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

/**
 * Created by RedstoneParadox on 8/18/2017.
 */
public class TileEntityFloodgate extends TileEntity implements ITickable {

    private boolean isOn = false;
    private int flowTime = 0;

    public boolean redstoneSwitch(boolean isPowered) {
        boolean tempvar = isOn;
        isOn = isPowered;
        markDirty();
        return tempvar != isOn;
    }

    public boolean flowCount() {
        int tempvar = flowTime;
        flowTime =- 1;
        if (flowTime < 0) {
            flowTime = 0;
        }
        markDirty();
        return tempvar != flowTime;
    }

    @Override
    public void update() {
        if (!world.isRemote) {
            if(isOn = true && flowTime > 0) {

            }
            else if (flowTime < 0) {
                flowTime = 0;
            }
        }
    }
}
