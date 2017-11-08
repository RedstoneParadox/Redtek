package com.mod.redtek.eventhandlers;

import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by RedstoneParadox on 7/31/2017.
 */
public class RedtekEventHandler {

    @SubscribeEvent
    public void heatCapabilityEvent(AttachCapabilitiesEvent<Chunk> event) {
        event.addCapability(null,null);
    }
}
