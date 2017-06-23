package com.mod.redtek.logicentities;

import net.minecraftforge.fml.common.registry.LegacyNamespacedRegistry;

/**
 * Created by RedstoneParadox on 6/22/2017.
 */
public class LogicEntityRegistry {

    private static final LogicEntityRegistry mainData = new LogicEntityRegistry();

    public LogicEntityRegistry() {
        iLogicEntityRegistry = new LegacyNamespacedRegistry<Class<? extends LogicEntity>>();
    }

    protected static LogicEntityRegistry getMain()
    {
        return mainData;
    }

    private final LegacyNamespacedRegistry<Class<? extends LogicEntity>> iLogicEntityRegistry;

    public static LegacyNamespacedRegistry<Class<? extends LogicEntity>> getLogicEntityRegistry(){ return getMain().iLogicEntityRegistry; }
}
