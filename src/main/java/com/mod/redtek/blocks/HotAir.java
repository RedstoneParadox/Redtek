package com.mod.redtek.blocks;

import com.mod.redtek.Redtek;
import com.mod.redtek.tileentities.TileEntityHotAir;
import jline.internal.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
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
public class HotAir extends Block implements ITileEntityProvider{

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
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    @Nullable
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityHotAir(1);
    }
}
