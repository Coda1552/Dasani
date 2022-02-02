package coda.dasani.client.render;

import coda.dasani.client.model.EpauletteSharkModel;
import coda.dasani.common.entities.EpauletteSharkEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EpauletteSharkRenderer extends GeoEntityRenderer<EpauletteSharkEntity> {

    public EpauletteSharkRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EpauletteSharkModel());
        this.shadowRadius = 0.4F;
    }
}