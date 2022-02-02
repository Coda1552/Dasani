package coda.dasani.client.model;// Made with Blockbench 4.1.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import coda.dasani.Dasani;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class EpauletteSharkModel<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER = new ModelLayerLocation(new ResourceLocation(Dasani.MOD_ID, "eupalette_shark"), "main");
	private final ModelPart fish;

	public EpauletteSharkModel(ModelPart root) {
		this.fish = root.getChild("fish");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition fish = partdefinition.addOrReplaceChild("fish", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition right_fin_2 = fish.addOrReplaceChild("right_fin_2", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.75F, -1.0F));

		PartDefinition cube_r1 = right_fin_2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -0.25F, -0.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, -0.5F, -0.0057F, 0.1308F, -0.044F));

		PartDefinition right_fin_1 = fish.addOrReplaceChild("right_fin_1", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.75F, -6.0F));

		PartDefinition cube_r2 = right_fin_1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 4).addBox(-5.0F, -0.25F, -1.0F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.0F, -0.0154F, 0.1739F, -0.0886F));

		PartDefinition left_fin_2 = fish.addOrReplaceChild("left_fin_2", CubeListBuilder.create(), PartPose.offset(3.0F, 0.75F, -1.0F));

		PartDefinition cube_r3 = left_fin_2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(30, 16).addBox(0.0F, -0.25F, -0.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, -0.5F, -0.0057F, -0.1308F, 0.044F));

		PartDefinition left_fin_1 = fish.addOrReplaceChild("left_fin_1", CubeListBuilder.create(), PartPose.offset(3.0F, 0.75F, -6.0F));

		PartDefinition cube_r4 = left_fin_1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, -0.25F, -1.0F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.0F, -0.0154F, -0.1739F, 0.0886F));

		PartDefinition body = fish.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -11.0F, 6.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition tail = fish.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = tail.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r6 = tail.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 6.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition tail_fin = tail.addOrReplaceChild("tail_fin", CubeListBuilder.create().texOffs(17, 18).addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		fish.render(poseStack, buffer, packedLight, packedOverlay);
	}
}