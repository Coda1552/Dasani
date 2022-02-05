package coda.dasani.client.model;

import coda.dasani.Dasani;
import coda.dasani.common.entities.ClamEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ClamModel extends AnimatedTickingGeoModel<ClamEntity> {

    @Override
    public ResourceLocation getModelLocation(ClamEntity object) {
        return new ResourceLocation(Dasani.MOD_ID, "geo/clam.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ClamEntity object) {
        return new ResourceLocation(Dasani.MOD_ID, "textures/entity/clam/brown.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ClamEntity animatable) {
        return new ResourceLocation(Dasani.MOD_ID, "animations/clam.animation.json");
    }

    @Override
    public void setLivingAnimations(ClamEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone clam = this.getAnimationProcessor().getBone("clam");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);

        if (entity.isInWater() && entity.getDeltaMovement().x > 0.05D && entity.getDeltaMovement().z > 0.05D) {
            clam.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
            clam.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
        }
    }
}
