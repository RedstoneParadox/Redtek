package com.mod.redtek.interfaces.thermalblocks;

import com.mod.redtek.blocksold.tileentities.TileEntityThermalBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by RedstoneParadox on 4/11/2017.
 */
public enum OreDictionaryReactors implements IThermalBlocks {
    LOG("logWood", Blocks.STONE, 20);

    private final String ore_entry;
    private final Block result;
    private final int temperature;

    OreDictionaryReactors(String block_name, Block result, int temperature) {
        this.ore_entry = block_name;
        this.result = result;
        this.temperature = temperature;
    }

    @Override
    public boolean matches(World world, BlockPos pos, IBlockState state) {
        return isBlockOreDictionary(state, ore_entry);
    }

    public static boolean isBlockOreDictionary(IBlockState state, String block_name){
        Block block = state.getBlock();
        for (ItemStack stack : OreDictionary.getOres(block_name)) {
            Block stackBlock = Block.getBlockFromItem(stack.getItem());
            if (stackBlock == block) {
                int meta = stack.getMetadata();
                if (meta == OreDictionary.WILDCARD_VALUE || meta == block.damageDropped(state)) {
                    return true;
                }
            }
        }
        return false;
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
