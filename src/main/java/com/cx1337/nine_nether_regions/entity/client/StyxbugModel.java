package com.cx1337.nine_nether_regions.entity.client;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.entity.custom.StyxbugEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class StyxbugModel<T extends StyxbugEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "styxbug"), "main");

    private final ModelPart root;
    private final ModelPart bug;
    private final ModelPart body;
    private final ModelPart head;

    public StyxbugModel(ModelPart root) {
        this.root = root;
        this.bug = root.getChild("bug");
        this.body = this.bug.getChild("body");
        this.head = this.bug.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bug = partdefinition.addOrReplaceChild("bug", CubeListBuilder.create(),
                PartPose.offset(0.0F, 23.1F, -0.75F));

        PartDefinition body = bug.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(0, 8).addBox(-3.0F, -2.5F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(-1.5F)),
                PartPose.offset(0.0F, -0.1F, 0.75F));

        PartDefinition head = bug.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -2.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.3F)),
                PartPose.offset(0.0F, 0.1F, -0.55F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public @NotNull ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(@NotNull StyxbugEntity entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(StyxbugAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, StyxbugAnimations.IDLE, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30F, 30.0F);
        headPitch = Mth.clamp(headPitch, -25F, 45.0F);

        this.head.yRot = headYaw * ((float)Math.PI / 180F);
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer,
                               int packedLight, int packedOverlay, int color) {
        this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
