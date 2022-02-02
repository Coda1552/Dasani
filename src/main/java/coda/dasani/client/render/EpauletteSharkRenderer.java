package coda.dasani.client.render;

import coda.dasani.Dasani;
import coda.dasani.client.model.EpauletteSharkModel;
import coda.dasani.common.entities.EpauletteSharkEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EpauletteSharkRenderer extends MobRenderer<EpauletteSharkEntity, EpauletteSharkModel<EpauletteSharkEntity>> {
   private static final ResourceLocation TEXTURE = new ResourceLocation(Dasani.MOD_ID, "textures/entity/epaulette_shark.png");

   public EpauletteSharkRenderer(EntityRendererProvider.Context manager) {
      super(manager, new EpauletteSharkModel<>(manager.bakeLayer(EpauletteSharkModel.LAYER)), 0.3F);
   }

   public ResourceLocation getTextureLocation(EpauletteSharkEntity entity) {
      return TEXTURE;
   }
}
