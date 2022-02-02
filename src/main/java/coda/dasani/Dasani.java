package coda.dasani;

import coda.dasani.common.entities.EpauletteSharkEntity;
import coda.dasani.registry.DasaniEntities;
import coda.dasani.registry.DasaniItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(Dasani.MOD_ID)
public class Dasani {
    public static final String MOD_ID = "dasani";

    public Dasani() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        DasaniEntities.ENTITIES.register(bus);
        DasaniItems.ITEMS.register(bus);

        bus.addListener(this::registerEntityAttributes);

        GeckoLib.initialize();
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(DasaniEntities.EPAULETTE_SHARK.get(), EpauletteSharkEntity.createAttributes().build());
    }
}
