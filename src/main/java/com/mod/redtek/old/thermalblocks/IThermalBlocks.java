package com.mod.redtek.old.thermalblocks;

/**
 * Created by RedstoneParadox on 4/11/2017.
 */

import com.mod.redtek.old.tileentities.TileEntityThermalBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IThermalBlocks {
    boolean matches(World world, BlockPos pos, IBlockState state);
    void radiate(World world, BlockPos pos, IBlockState state, int temperature, EnumFacing enumFacing, TileEntityThermalBase tileEntity);
}
