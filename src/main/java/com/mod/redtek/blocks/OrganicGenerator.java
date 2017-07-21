package com.mod.redtek.blocks;

import com.mod.redtek.Redtek;
import com.mod.redtek.tileentities.TileEntityOrganicGenerator;
import jline.internal.Nullable;
import net.minecraft.block.Block;
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
 * Created by RedstoneParadox on 7/18/2017.
 */
public class OrganicGenerator extends Block implements ITileEntityProvider {

    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    //This will get used later.
    public static final PropertyBool DUMMY_VALUE = PropertyBool.create("dummy_value");

    public OrganicGenerator() {
        super(Material.IRON);
        setCreativeTab(Redtek.creativeTab);
        setHarvestLevel("pickaxe", 1);
        setHardness(10);
        setResistance(30);
        setUnlocalizedName(Redtek.MODID + ".organic_generator");
        setRegistryName("organic_generator");
        GameRegistry.registerTileEntity(TileEntityOrganicGenerator.class, Redtek.MODID + "_organic_generator");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack item) {
        world.setBlockState(pos, state.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)), 2);
        powerCheck(world, pos);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        powerCheck(worldIn, pos);
    }

    public void powerCheck(World worldIn, BlockPos pos) {
        TileEntity ent = worldIn.getTileEntity(pos);
        if (ent instanceof TileEntityOrganicGenerator) {
            if (worldIn.isBlockPowered(pos)) {
                ((TileEntityOrganicGenerator) ent).redstoneSwitch(true);
            }
            else if (!worldIn.isBlockPowered(pos)) {
                ((TileEntityOrganicGenerator) ent).redstoneSwitch(false);
            }
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7)).withProperty(DUMMY_VALUE, Boolean.valueOf((meta & 8) > 0));
    }

    @Deprecated
    //This code is NOT to be deleted, I am still working on it.
    public int getMetaFromStateOld(IBlockState state) {
        int i = 0;
        i = i | (state.getValue(FACING)).getHorizontalIndex();

        if ((state.getValue(DUMMY_VALUE)).booleanValue()) {
            i |= 8;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, DUMMY_VALUE);
    }

    @Override
    @Nullable
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityOrganicGenerator();
    }
}
