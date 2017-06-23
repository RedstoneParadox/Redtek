package com.mod.redtek;

import com.mod.redtek.blocksold.RedtekBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static net.minecraft.item.Item.getItemFromBlock;

/**
 * Created by RedstoneParadox on 3/26/2017.
 */
public class MachineryTab extends CreativeTabs{

    public MachineryTab() {
        super("Machine Components (Redtek)");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(getItemFromBlock(RedtekBlocks.HEAT_VENT));
    }
}
