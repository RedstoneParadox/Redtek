package com.mod.redtek.blocksold;

import com.mod.redtek.Redtek;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Created by RedstoneParadox on 3/26/2017.
 */
public class MoltenIronBlock extends Block{

    public MoltenIronBlock() {
        super(Material.ROCK);
        setLightLevel(0.2f);
        setHarvestLevel("pickaxe", 1);
        setHardness(10);
        setResistance(30);
        setUnlocalizedName(Redtek.MODID + ".molten_iron_block");
        setRegistryName("molten_iron_block");
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
    }

    //Drop handling, I guess.
    public int quantityDropped(Random random)
    {
        return 2;
    }

    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.IRON_INGOT;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
