package com.mod.redtek;

import com.mod.redtek.old.blocks.RedtekBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static net.minecraft.item.Item.getItemFromBlock;

/**
 * Created by RedstoneParadox on 3/26/2017.
 */
public class MachineryTab extends CreativeTabs{

    public MachineryTab() {
        super("Machines (Redtek)");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(getItemFromBlock(RedtekBlocks.HEAT_VENT));
    }
}
