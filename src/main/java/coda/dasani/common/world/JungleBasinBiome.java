package coda.dasani.common.world;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class JungleBasinBiome {

    public static Biome create() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder genSettings = new BiomeGenerationSettings.Builder();

        BiomeDefaultFeatures.farmAnimals(spawnSettings);
        BiomeDefaultFeatures.commonSpawns(spawnSettings);
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
        BiomeDefaultFeatures.addFossilDecoration(genSettings);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(genSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genSettings);
        BiomeDefaultFeatures.addDefaultSprings(genSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(genSettings);
        BiomeDefaultFeatures.addDefaultOres(genSettings);
        BiomeDefaultFeatures.addSwampClayDisk(genSettings);
        BiomeDefaultFeatures.addSwampVegetation(genSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(genSettings);
        BiomeDefaultFeatures.addSwampExtraVegetation(genSettings);
        genSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SWAMP).temperature(0.8F).downfall(0.9F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(6388580).waterFogColor(2302743).fogColor(12638463).skyColor(calculateSkyColor()).foliageColorOverride(6975545).grassColorModifier(BiomeSpecialEffects.GrassColorModifier.SWAMP).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(genSettings.build()).build();
    }

    public static int calculateSkyColor() {
        return Mth.hsvToRgb(0.60872227f, 0.527f, 1.0F);
    }
}
