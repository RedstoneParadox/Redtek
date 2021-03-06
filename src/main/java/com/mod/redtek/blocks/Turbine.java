package com.mod.redtek.blocks;

import com.mod.redtek.Redtek;
import com.mod.redtek.tileentities.TileEntityTurbine;
import jline.internal.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by RedstoneParadox on 4/21/2017.
 */
public class Turbine extends Block implements ITileEntityProvider {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final PropertyBool ROTATING = PropertyBool.create("rotating");

    public Turbine() {
        super(Material.IRON);
        setCreativeTab(Redtek.creativeTab);
        setHarvestLevel("pickaxe", 1);
        setHardness(10);
        setResistance(30);
        setUnlocalizedName(Redtek.MODID + ".turbine");
        setRegistryName("turbine");
        GameRegistry.registerTileEntity(TileEntityTurbine.class, Redtek.MODID + "_turbine");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack item) {
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(ROTATING, false), 2);
        powerCheck(world, pos);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        powerCheck(worldIn, pos);
    }

    public void powerCheck(World worldIn, BlockPos pos) {
        TileEntity ent = worldIn.getTileEntity(pos);
        if (ent instanceof TileEntityTurbine) {
            if (worldIn.isBlockPowered(pos)) {
                ((TileEntityTurbine) ent).redstoneSwitch(true);
            }
            else if (!worldIn.isBlockPowered(pos)) {
                ((TileEntityTurbine) ent).redstoneSwitch(false);
            }
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 7)).withProperty(ROTATING, Boolean.valueOf((meta & 8) > 0));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | (state.getValue(FACING)).getHorizontalIndex();

        if ((state.getValue(ROTATING)).booleanValue()) {
            i |= 8;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, ROTATING);
    }

    @Override
    @Nullable
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTurbine();
    }
}
