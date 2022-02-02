package coda.dasani.client;

import coda.dasani.Dasani;
import coda.dasani.client.render.EpauletteSharkRenderer;
import coda.dasani.registry.DasaniEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = {Dist.CLIENT}, bus = Mod.EventBusSubscriber.Bus.MOD, modid = Dasani.MOD_ID)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(DasaniEntities.EPAULETTE_SHARK.get(), EpauletteSharkRenderer::new);
    }
}
