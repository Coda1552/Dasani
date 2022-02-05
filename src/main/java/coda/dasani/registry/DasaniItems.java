package coda.dasani.registry;

import coda.dasani.Dasani;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DasaniItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Dasani.MOD_ID);

    public static final RegistryObject<Item> EPAULETTE_SHARK_SPAWN_EGG = ITEMS.register("epaulette_shark_spawn_egg", () -> new ForgeSpawnEggItem(DasaniEntities.EPAULETTE_SHARK, 0xd1c98b, 0x55523b, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> CLAM_SPAWN_EGG = ITEMS.register("clam_spawn_egg", () -> new ForgeSpawnEggItem(DasaniEntities.CLAM, 0xe280f4, 0xdbf5fb, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
