package com.mod.redtek.blocksold.tileentities.thermalblocks;

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
public enum SpecificStateReactors implements IThermalBlocks {
    WET_SPONGE(Blocks.SPONGE, Blocks.SPONGE, 1, 0, 20);

    private final Block block;
    private final Block result;
    private final int init_meta;
    private final int final_meta;
    private final int temperature;

    SpecificStateReactors(Block block, Block result, int init_meta, int final_meta, int temperature) {
        this.block = block;
        this.result = result;
        this.init_meta = init_meta;
        this.final_meta = final_meta;
        this.temperature = temperature;
    }

    @Override
    public boolean matches(World world, BlockPos pos, IBlockState state) {
        IBlockState base_state = block.getStateFromMeta(init_meta);
        if (state == base_state){
            return state.getBlock() == block;
        }
        else {
            return false;
        }
    }

    @Override
    public void radiate(World world, BlockPos pos, IBlockState state, int vent_temperature, EnumFacing enumFacing, TileEntityThermalBase vent) {
        if (vent_temperature - temperature >= 0 && enumFacing != EnumFacing.DOWN) {
            vent.radiate(-temperature);
            world.setBlockState(pos, result.getStateFromMeta(final_meta));
        }
    }
}
