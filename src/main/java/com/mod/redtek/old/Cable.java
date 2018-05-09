package com.mod.redtek.old;

import com.mod.redtek.Redtek;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by RedstoneParadox on 5/29/2017.
 */
public class Cable extends Block {

    public Cable() {
        super(Material.IRON);
        setCreativeTab(Redtek.creativeTab);
        setHardness(5);
        setResistance(10);
        setUnlocalizedName(Redtek.MODID + ".cable");
        setRegistryName("cable");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
