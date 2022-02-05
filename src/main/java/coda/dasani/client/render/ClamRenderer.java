package coda.dasani.client.render;

import coda.dasani.client.model.ClamModel;
import coda.dasani.common.entities.ClamEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ClamRenderer extends GeoEntityRenderer<ClamEntity> {

    public ClamRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ClamModel());
        this.shadowRadius = 0.15F;
    }
}