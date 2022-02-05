package coda.dasani.client.model;

import coda.dasani.Dasani;
import coda.dasani.common.entities.EpauletteSharkEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class EpauletteSharkModel extends AnimatedTickingGeoModel<EpauletteSharkEntity> {

    @Override
    public ResourceLocation getModelLocation(EpauletteSharkEntity object) {
        return new ResourceLocation(Dasani.MOD_ID, "geo/epaulette_shark.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EpauletteSharkEntity object) {
        return new ResourceLocation(Dasani.MOD_ID, "textures/entity/epaulette_shark.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EpauletteSharkEntity animatable) {
        return new ResourceLocation(Dasani.MOD_ID, "animations/epaulette_shark.animation.json");
    }

    @Override
    public void setLivingAnimations(EpauletteSharkEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone fish = this.getAnimationProcessor().getBone("fish");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);

        if (entity.isInWater()) {
            fish.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
            fish.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
        }
    }
}
