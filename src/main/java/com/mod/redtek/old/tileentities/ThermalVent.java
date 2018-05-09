package com.mod.redtek.old.tileentities;

import com.mod.redtek.Redtek;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by RedstoneParadox on 5/22/2017.
 */
public class ThermalVent extends Block {

    private final boolean ignoreSimilarity;

    public ThermalVent(boolean ignoreSimilarityIn) {
        super(Material.IRON);
        setHarvestLevel("pickaxe", 1);
        setHardness(10);
        setResistance(30);
        this.ignoreSimilarity = ignoreSimilarityIn;
        setUnlocalizedName(Redtek.MODID + ".thermal_vent");
        setRegistryName("thermal_vent");

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        if (this == this)
        {
            if (blockState != iblockstate)
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }

        return !(!this.ignoreSimilarity && block == this) && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

}
