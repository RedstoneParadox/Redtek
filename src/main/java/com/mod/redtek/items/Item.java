package com.mod.redtek.items;

import com.mod.redtek.Redtek;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by RedstoneParadox on 3/12/2017.
 */
public class Item extends net.minecraft.item.Item{

    public Item() {
        setRegistryName("firstitem");
        setUnlocalizedName(Redtek.MODID + ".item");
        GameRegistry.register(this);
    }
}
