package com.mod.redtek.blocksold.tileentities.thermalblocks;

import com.mod.redtek.blocksold.RedtekBlocks;
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
public enum Reactors implements IThermalBlocks {
    WATER(Blocks.WATER, Blocks.AIR, 10),
    SEA_LANTERN(Blocks.SEA_LANTERN, null, 5),
    ICE(Blocks.ICE, Blocks.WATER, 20),
    SNOW(Blocks.SNOW, Blocks.WATER, 20),
    PACKED_ICE(Blocks.PACKED_ICE, Blocks.ICE, 40),
    IRON_ORE(Blocks.IRON_ORE, RedtekBlocks.MOLTEN_IRON_BLOCK, 20),
    GOLD_ORE(Blocks.GOLD_ORE, RedtekBlocks.MOLTEN_GOLD_BLOCK, 20),
    SAND(Blocks.SAND, Blocks.GLASS, 20),
    SLIME(Blocks.SLIME_BLOCK, Blocks.AIR, 200),
    BONE_BLOCK(Blocks.BONE_BLOCK, Blocks.COAL_ORE, 100),
    COAL_BLOCK(Blocks.COAL_BLOCK, Blocks.DIAMOND_ORE, 9000),
    AIR(Blocks.AIR, null, 1);

    private final Block block;
    private final Block result;
    private final int temperature;

    Reactors(Block block, Block result, int temperature) {
        this.block = block;
        this.result = result;
        this.temperature = temperature;
    }

    @Override
    public boolean matches(World world, BlockPos pos, IBlockState state) {
        return state.getBlock() == block;
    }

    @Override
    public void radiate(World world, BlockPos pos, IBlockState state, int vent_temperature, EnumFacing enumFacing, TileEntityThermalBase vent) {
        if (vent_temperature - temperature >= 0 && enumFacing != EnumFacing.DOWN) {
            if (result != null) {
                vent.radiate(-temperature);
                world.setBlockState(pos, result.getDefaultState());
            }
            else {
                vent.radiate(-temperature);
            }
        }
    }
}
