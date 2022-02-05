package coda.dasani.registry;

import coda.dasani.Dasani;
import coda.dasani.common.entities.ClamEntity;
import coda.dasani.common.entities.EpauletteSharkEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DasaniEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Dasani.MOD_ID);

    public static final RegistryObject<EntityType<EpauletteSharkEntity>> EPAULETTE_SHARK = create("epaulette_shark", EntityType.Builder.of(EpauletteSharkEntity::new, MobCategory.WATER_CREATURE).sized(0.85F, 0.35F));
    public static final RegistryObject<EntityType<ClamEntity>> CLAM = create("clam", EntityType.Builder.of(ClamEntity::new, MobCategory.WATER_CREATURE).sized(0.45F, 0.35F));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(Dasani.MOD_ID + "." + name));
    }
}