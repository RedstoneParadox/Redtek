package com.mod.redtek.old.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by RedstoneParadox on 9/23/2017.
 */
public class TileEntityHotAir extends TileEntity {

    public int temperature = 0;

    public TileEntityHotAir() {

    }

    public TileEntityHotAir(int temp) {
        temperature = temp;
        markDirty();
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        temperature = compound.getInteger("Temperature");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("Temperature", temperature);
        return compound;
    }

}
