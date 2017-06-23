package com.mod.redtek.logicentities;

import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by RedstoneParadox on 6/22/2017.
 */
public interface ILogicEntityProvider {

    /**
     * Returns a new instance of a logic entity class.
     */
    @Nullable
    LogicEntity createNewLogicEntity(World worldIn, int meta);
}
