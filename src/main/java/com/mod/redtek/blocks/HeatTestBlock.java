package com.mod.redtek.blocks;

import com.mod.redtek.Redtek;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by RedstoneParadox on 11/4/2017.
 */
public class HeatTestBlock extends Block {

    public HeatTestBlock() {
        super(Material.ROCK);
        setLightLevel(0.2F);
        setHardness(10);
        setResistance(30);
        setUnlocalizedName(Redtek.MODID + ".heat_test_block");
        setRegistryName("heat_test_block");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
