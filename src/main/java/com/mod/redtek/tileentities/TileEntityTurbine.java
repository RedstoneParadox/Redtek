package com.mod.redtek.tileentities;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.IEnergyStorage;

import static com.mod.redtek.blocks.Turbine.FACING;
import static com.mod.redtek.blocks.Turbine.ROTATING;

/**
 * Created by RedstoneParadox on 4/21/2017.
 */
public class TileEntityTurbine extends TileEntity implements ITickable, ICapabilityProvider {

    private static final ImmutableList<GeneratingBlocks> GENERATING_BLOCKS = ImmutableList.<GeneratingBlocks>builder()
            .add(Generators.values())
            .build();

    private int power = 0;
    private boolean isOn = false;
    private boolean isRotating = false;

    @CapabilityInject(IEnergyStorage.class)
    public static Capability<IEnergyStorage> ENERGY = null;

    private final TurbineEnergyStorage energy = new TurbineEnergyStorage(256, 0, 256);

    //Power Level
    public boolean generate(int powerlevel) {
        int tempvar = power;
        power = powerlevel;
        markDirty();
        return tempvar != power;
    }

    public boolean redstoneSwitch(boolean isPowered) {
        boolean tempvar = isOn;
        isOn = isPowered;
        markDirty();
        return tempvar != isOn;
    }

    public boolean shouldRotate(boolean isTurning) {
        boolean tempvar = isRotating;
        isRotating = isTurning;
        markDirty();
        return tempvar != isRotating;
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
        return oldState.getBlock() != newState.getBlock();
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        power = compound.getInteger("PowerOutput");
        isOn = compound.getBoolean("IsOn");
        isRotating = compound.getBoolean("IsRotating");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("PowerOutput", power);
        compound.setBoolean("IsOn", isOn);
        compound.setBoolean("IsRotating", isRotating);
        return compound;
    }

    @Override
    public void update() {
        if(!world.isRemote) {
            if (isOn==true) {
                System.out.println("Is true!");
            }
            else {
                System.out.println("The cake is a lie!");
            }
        }
    }

    @Deprecated
    public void generateEnergy(World world, BlockPos pos) {
        EnumFacing turbineDirection = EnumFacing.getHorizontal(getBlockMetadata());
        BlockPos neighbor = pos.offset(turbineDirection);
        for(GeneratingBlocks block : GENERATING_BLOCKS) {
            int i = 0;
            if (i >= 1) {
                generate(0);
                world.setBlockState(pos, world.getBlockState(pos).withProperty(FACING, EnumFacing.getHorizontal(getBlockMetadata())).withProperty(ROTATING, false));
            }
            else if (i < 1) {
                if (block.matches(world, neighbor, world.getBlockState(neighbor))) {
                    block.generate(world, pos, world.getBlockState(neighbor), turbineDirection,this);
                    world.setBlockState(pos, world.getBlockState(pos).withProperty(FACING, EnumFacing.getHorizontal(getBlockMetadata())).withProperty(ROTATING, true));
                }
                i++;
            }
        }
    }

    private interface GeneratingBlocks {
        boolean matches(World world, BlockPos pos, IBlockState state);
        void generate(World world, BlockPos pos, IBlockState state, EnumFacing enumFacing, TileEntityTurbine tileEntity);
    }

    private enum Generators implements GeneratingBlocks {
        WATER(Blocks.WATER, Blocks.FLOWING_WATER, 40, 5);

        private final Block block;
        private final Block block2;
        private final int energy;
        private final int energyReduction;

        Generators(Block block, Block block2, int energy, int energy_reduction) {
            this.block = block;
            this.block2 = block2;
            this.energy = energy;
            this.energyReduction = energy_reduction;
        }

        @Override
        public boolean matches(World world, BlockPos pos, IBlockState state) {
            return state.getBlock() == block || state.getBlock() == block2;
        }

        @Override
        public void generate(World world, BlockPos pos, IBlockState state, EnumFacing enumFacing, TileEntityTurbine tileEntity) {
            if (1==1) {
                tileEntity.generate(energy - (block.getMetaFromState(state)*energyReduction));
            }
        }
    }
}
