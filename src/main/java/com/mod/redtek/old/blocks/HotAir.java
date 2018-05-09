package com.mod.redtek.old.blocks;

import com.mod.redtek.Redtek;
import com.mod.redtek.old.tileentities.TileEntityHotAir;
import jline.internal.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by RedstoneParadox on 9/23/2017.
 */
public class HotAir extends Block implements ITileEntityProvider {

    public static final PropertyBool HEAT_CHECK = PropertyBool.create("heat_check");

    public HotAir() {
        super(Material.AIR);
        setUnlocalizedName(Redtek.MODID + ".hot_air");
        setRegistryName("hot_air");
        GameRegistry.registerTileEntity(TileEntityHotAir.class, Redtek.MODID + "_hot_air");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid)
    {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        if(state == getDefaultState().withProperty(HEAT_CHECK, true)) {
            return 1;
        }
        else if (state == getDefaultState().withProperty(HEAT_CHECK, false)) {
            return 0;
        }
        else {
            throw new IllegalArgumentException(state + "does not exist for" + getUnlocalizedName());
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        if (meta==0) {
            return getDefaultState().withProperty(HEAT_CHECK, false);
        }
        if (meta==1) {
            return getDefaultState().withProperty(HEAT_CHECK, true);
        }
        else {
            throw new IllegalArgumentException(meta + "is not a valid number");
        }
    }

    private int getActualMeta() {
        return 0;
    }

    @Override
    protected BlockStateContainer createBlockState() { return new BlockStateContainer(this, HEAT_CHECK);}

    @Override
    @Nullable
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        if (getDefaultState().withProperty(HEAT_CHECK, true) == getBlockState()) {
            return new TileEntityHotAir(getActualMeta());
        } else {
            return new TileEntityHotAir();
        }
    }
}
