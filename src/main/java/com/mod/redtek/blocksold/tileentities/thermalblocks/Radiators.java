package com.mod.redtek.blocksold.tileentities.thermalblocks;

import com.mod.redtek.blocks.RedtekBlocks;
import com.mod.redtek.blocksold.tileentities.TileEntityThermalBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by RedstoneParadox on 4/11/2017.
 */
public enum Radiators implements IThermalBlocks {
    FIRE(Blocks.FIRE, 4),
    MAGMA(Blocks.MAGMA, 8),
    MOLTEN_IRON_BLOCK(RedtekBlocks.MOLTEN_IRON_BLOCK, 8),
    MOLTEN_GOLD_BLOCK(RedtekBlocks.MOLTEN_GOLD_BLOCK, 8),
    LAVA(Blocks.LAVA, 16);

    private final Block block;
    private final int temperature;

    Radiators(Block block, int temperature) {
        this.block = block;
        this.temperature = temperature;
    }

    @Override
    public boolean matches(World world, BlockPos pos, IBlockState state) {
        return state.getBlock() == block;
    }

    @Override
    public void radiate(World world, BlockPos pos, IBlockState state, int vent_temperature, EnumFacing enumFacing, TileEntityThermalBase vent) {
        if(enumFacing != EnumFacing.UP) {
            vent.radiate(temperature);
        }
    }
}
