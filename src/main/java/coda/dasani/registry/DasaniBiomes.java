package coda.dasani.registry;

import coda.dasani.Dasani;
import coda.dasani.common.world.JungleBasinBiome;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class DasaniBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Dasani.MOD_ID);
    public static final RegistryObject<Biome> JUNGLE_BASIN = BIOMES.register("jungle_basin", JungleBasinBiome::create);

    public static final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
    public static ResourceKey<Biome> JUNGLE_BASIN_KEY;

    public static void init(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {

        if (JUNGLE_BASIN_KEY == null)
            JUNGLE_BASIN_KEY = registerResourceKey("jungle_basin");

        consumer.accept(Pair.of(Climate.parameters(Climate.Parameter.span(0.8F, 1.0F), FULL_RANGE, FULL_RANGE, FULL_RANGE, FULL_RANGE, Climate.Parameter.span(0.03F, 1.0F), 0.0F), JUNGLE_BASIN_KEY));
    }

    @NotNull
    private static ResourceKey<Biome> registerResourceKey(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Dasani.MOD_ID, name));
    }


}
