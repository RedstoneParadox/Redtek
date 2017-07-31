package com.mod.redtek.blocksold.tileentities;

import com.google.common.collect.ImmutableList;
import com.mod.redtek.interfaces.thermalblocks.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by RedstoneParadox on 3/25/2017.
 */
public class TileEntityHeatVent extends TileEntityThermalBase implements ITickable, IThermalBlocks{

    //Static variables.
    private static final int MAX_TEMP = 96000;
    private static final int RADIATE_RATE = 10;

    //List of blocksold to search. Does not require changing so it is kept immutable.
    private static final ImmutableList<IThermalBlocks> THERMAL_BLOCKS = ImmutableList.<IThermalBlocks>builder()
            .add(Radiators.values())
            .add(Reactors.values())
            .add(SpecificStateReactors.values())
            .add(OreDictionaryReactors.values())
            .build();

    EnumFacing[] facingValues = {
            EnumFacing.UP,
            EnumFacing.NORTH,
            EnumFacing.EAST,
            EnumFacing.SOUTH,
            EnumFacing.WEST,
            EnumFacing.DOWN
    };

    //Regular variables.
    private int radiateTimer = 0;
    private int ventTemperature = 0;

    //Position variables.

    @Override
    public void setPos(BlockPos pos) {
        this.pos = pos;
    }

    //Timer handling.
    private int increaseRadiateTimer() {
        radiateTimer++;
        markDirty();
        return radiateTimer;
    }

    private int resetRadiateTimer() {
        radiateTimer = 0;
        markDirty();
        return radiateTimer;
    }

    @Override
    public boolean matches(World world, BlockPos pos, IBlockState state) {
        return false;
    }

    @Override
    public void radiate(World world, BlockPos pos, IBlockState state, int temperature, EnumFacing enumFacing, TileEntityThermalBase tileEntity) {

    }

    @Override
    public boolean radiate(int value) {
        int temp = ventTemperature;
        ventTemperature += value;
        if(ventTemperature < 0)
        {
            ventTemperature = 0;
        }
        markDirty();
        return temp != ventTemperature;
    }

    //NBT Handling.
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        ventTemperature = compound.getInteger("Temperature");
        radiateTimer = compound.getInteger("RadiateTimer");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("Temperature", ventTemperature);
        compound.setInteger("RadiateTimer", radiateTimer);
        return compound;
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
        return oldState.getBlock() != newState.getBlock();
    }

    //Main update method. so Mainstream
    @Override
    public void update() {
        if (!world.isRemote) {
            if (radiateTimer >= RADIATE_RATE) {
                resetRadiateTimer();
                radiateCheck();
                if (ventTemperature > MAX_TEMP) {
                    destroy(getWorld(), getPos());
                }
            }
            else {
                increaseRadiateTimer();
            }
        }
    }

    //Heat control.
    private void radiateCheck() {
        EnumFacing[] dirs = facingValues;
        for (int i=0; i < 6; i++) {
            BlockPos neighbor = pos.offset(dirs[i]);
            EnumFacing pos_var = dirs[i];
            if(radiateCheck(neighbor, world.getBlockState(neighbor), pos_var)) {
                continue;
            }
        }
    }

    private boolean radiateCheck(BlockPos pos, IBlockState state, EnumFacing enumFacing) {
        for(IThermalBlocks block : THERMAL_BLOCKS) {
            if(block.matches(world, pos, state)) {
                block.radiate(world, pos, state, ventTemperature, enumFacing,this);
                return true;
            }
        }
        return false;
    }

    //The most basic method of permanently and mercilessly eradicating blocksold from existence.
    private void destroy(World worldIn, BlockPos pos) {
        worldIn.destroyBlock(pos, false);
    }

}
