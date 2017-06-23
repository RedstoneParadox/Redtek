package com.mod.redtek.logicentities;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.world.World;

/**
 * Created by RedstoneParadox on 6/22/2017.
 */
public abstract class LogicEntity {

    private static final RegistryNamespaced<ResourceLocation, Class<? extends LogicEntity>> REGISTRY = LogicEntityRegistry.getLogicEntityRegistry();
    /** the instance of the world the logic entity is in. */
    protected World world;
    protected BlockPos pos = BlockPos.ORIGIN;
    protected boolean logicEntityInvalid;

    private static void register() {
        REGISTRY.putObject(null, null);
    }

    /**
     * Returns the worldObj for this logicEntity.
     */
    public World getWorld()
    {
        return this.world;
    }

    /**
     * Sets the worldObj for this logicEntity.
     */
    public void setWorld(World worldIn)
    {
        this.world = worldIn;
    }

    /**
     * Returns true if the worldObj isn't null.
     */
    public boolean hasWorld()
    {
        return this.world != null;
    }

    /**
     * invalidates a logic entity
     */
    public void invalidate()
    {
        this.logicEntityInvalid = true;
    }

    /**
     * validates a logic entity
     */
    public void validate()
    {
        this.logicEntityInvalid = false;
    }
}
