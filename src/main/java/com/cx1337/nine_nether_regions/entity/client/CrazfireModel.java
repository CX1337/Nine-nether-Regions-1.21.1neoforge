package com.cx1337.nine_nether_regions.entity.client;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.entity.custom.CrazfireEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class CrazfireModel<T extends CrazfireEntity> extends HierarchicalModel<CrazfireEntity> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "crazfire"), "main");

    private final ModelPart root;
    private final ModelPart Body;
    private final ModelPart Core;
    private final ModelPart Armor;
    private final ModelPart Head;
    private final ModelPart Helmet;
    private final ModelPart Surroudings;
    private final ModelPart Cannons;
    private final ModelPart CannonA;
    private final ModelPart CannonAA;
    private final ModelPart CannonAB;
    private final ModelPart CannonAS;
    private final ModelPart CannonB;
    private final ModelPart Cannonc;
    private final ModelPart Cannond;
    private final ModelPart CannonBS;
    private final ModelPart Sword;
    private final ModelPart SwordA;
    private final ModelPart BodyS;
    private final ModelPart SwordA2;
    private final ModelPart BodySA;

    public CrazfireModel(ModelPart root) {
        this.root = root;
        this.Body = root.getChild("Body");
        this.Core = this.Body.getChild("Core");
        this.Armor = this.Core.getChild("Armor");
        this.Head = this.Body.getChild("Head");
        this.Helmet = this.Head.getChild("Helmet");
        this.Surroudings = root.getChild("Surroudings");
        this.Cannons = this.Surroudings.getChild("Cannons");
        this.CannonA = this.Cannons.getChild("CannonA");
        this.CannonAA = this.CannonA.getChild("CannonAA");
        this.CannonAB = this.CannonA.getChild("CannonAB");
        this.CannonAS = this.CannonA.getChild("CannonAS");
        this.CannonB = this.Cannons.getChild("CannonB");
        this.Cannonc = this.CannonB.getChild("Cannonc");
        this.Cannond = this.CannonB.getChild("Cannond");
        this.CannonBS = this.CannonB.getChild("CannonBS");
        this.Sword = this.Surroudings.getChild("Sword");
        this.SwordA = this.Sword.getChild("SwordA");
        this.BodyS = this.SwordA.getChild("BodyS");
        this.SwordA2 = this.Sword.getChild("SwordA2");
        this.BodySA = this.SwordA2.getChild("BodySA");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create(),
                PartPose.offset(3.0F, 9.0F, 13.0F));

        PartDefinition Core = Body.addOrReplaceChild("Core",
                CubeListBuilder.create().texOffs(0, 53).addBox(-2.0F, -18.0F, -2.0F, 4.0F, 23.0F, 4.0F),
                PartPose.offset(-4.0F, 10.0F, -12.0F));

        PartDefinition Armor = Core.addOrReplaceChild("Armor",
                CubeListBuilder.create()
                        .texOffs(74, 0).addBox(-5.0F, 15.0F, -8.0F, 2.0F, 3.0F, 2.0F)
                        .texOffs(58, 50).addBox(-7.0F, 11.0F, -6.0F, 6.0F, 6.0F, 6.0F),
                PartPose.offset(4.0F, -31.0F, 3.0F));

        PartDefinition Head = Body.addOrReplaceChild("Head",
                CubeListBuilder.create().texOffs(96, 0).addBox(-5.0F, -4.0F, -3.0F, 8.0F, 8.0F, 8.0F),
                PartPose.offset(-3.0F, -16.0F, -13.0F));

        PartDefinition Helmet = Head.addOrReplaceChild("Helmet",
                CubeListBuilder.create()
                        .texOffs(17, 73).addBox(-2.0F, -8.0F, 4.0F, 4.0F, 4.0F, 1.0F)
                        .texOffs(43, 65).addBox(-5.0F, -7.0F, 2.0F, 3.0F, 3.0F, 3.0F)
                        .texOffs(30, 65).addBox(2.0F, -7.0F, 2.0F, 3.0F, 3.0F, 3.0F)
                        .texOffs(88, 16).addBox(-5.0F, -4.0F, -5.0F, 10.0F, 9.0F, 10.0F),
                PartPose.offset(-1.0F, -1.0F, 1.0F));

        PartDefinition Surroudings = root.addOrReplaceChild("Surroudings", CubeListBuilder.create(),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Cannons = Surroudings.addOrReplaceChild("Cannons", CubeListBuilder.create(),
                PartPose.offset(-1.0F, -21.0F, 1.0F));

        PartDefinition CannonA = Cannons.addOrReplaceChild("CannonA", CubeListBuilder.create(),
                PartPose.offset(0.0F, 1.0F, 1.0F));

        PartDefinition CannonAA = CannonA.addOrReplaceChild("CannonAA",
                CubeListBuilder.create().texOffs(37, 20).addBox(-5.0F, 1.0F, -1.0F, 10.0F, 6.0F, 8.0F),
                PartPose.offset(0.0F, -5.0F, 16.0F));

        PartDefinition CannonAB = CannonA.addOrReplaceChild("CannonAB",
                CubeListBuilder.create().texOffs(0, 39).addBox(-6.0F, -1.0F, 2.0F, 10.0F, 4.0F, 8.0F),
                PartPose.offset(1.0F, 2.0F, 13.0F));

        PartDefinition CannonAS = CannonA.addOrReplaceChild("CannonAS",
                CubeListBuilder.create()
                        .texOffs(0, 20).addBox(-7.0F, -8.0F, 10.0F, 14.0F, 14.0F, 4.0F)
                        .texOffs(17, 53).addBox(-2.0F, -12.0F, 10.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offset(0.0F, 2.0F, 1.0F));

        CannonAS.addOrReplaceChild("OutD_r1",
                CubeListBuilder.create().texOffs(17, 53).addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(7.0F, -2.0F, 13.0F, 0.0F, 3.1416F, 1.5708F));

        CannonAS.addOrReplaceChild("OutC_r1",
                CubeListBuilder.create().texOffs(17, 53).addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(-1.0F, 6.0F, 11.0F, 0.0F, 0.0F, -3.1416F));

        CannonAS.addOrReplaceChild("OutB_r1",
                CubeListBuilder.create().texOffs(17, 53).addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(-7.0F, -2.0F, 11.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition CannonB = Cannons.addOrReplaceChild("CannonB", CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition Cannonc = CannonB.addOrReplaceChild("Cannonc",
                CubeListBuilder.create().texOffs(37, 20).addBox(-5.0F, -3.0F, 2.0F, 10.0F, 6.0F, 8.0F),
                PartPose.offset(1.0F, 0.0F, 15.0F));

        PartDefinition Cannond = CannonB.addOrReplaceChild("Cannond",
                CubeListBuilder.create().texOffs(0, 39).addBox(-5.0F, -2.0F, 1.0F, 10.0F, 4.0F, 8.0F),
                PartPose.offset(1.0F, 4.0F, 16.0F));

        PartDefinition CannonBS = CannonB.addOrReplaceChild("CannonBS",
                CubeListBuilder.create()
                        .texOffs(0, 20).addBox(-6.0F, -8.0F, -5.0F, 14.0F, 14.0F, 4.0F)
                        .texOffs(17, 53).addBox(-1.0F, -12.0F, -5.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offset(0.0F, 3.0F, 18.0F));

        CannonBS.addOrReplaceChild("Outd_r2",
                CubeListBuilder.create().texOffs(17, 53).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(7.0F, -2.0F, -2.0F, 0.0F, 3.1416F, 1.5708F));

        CannonBS.addOrReplaceChild("Outc_r2",
                CubeListBuilder.create().texOffs(17, 53).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(-1.0F, 6.0F, -4.0F, 0.0F, 0.0F, -3.1416F));

        CannonBS.addOrReplaceChild("Outb_r2",
                CubeListBuilder.create().texOffs(17, 53).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(-7.0F, -2.0F, -4.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition Sword = Surroudings.addOrReplaceChild("Sword", CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition SwordA = Sword.addOrReplaceChild("SwordA",
                CubeListBuilder.create()
                        .texOffs(37, 35).addBox(-2.1106F, -9.4929F, -2.0F, 3.0F, 22.0F, 7.0F)
                        .texOffs(43, 72).addBox(-2.1106F, 10.5071F, -5.0F, 3.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(-10.0F, -16.0F, 1.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition BodyS = SwordA.addOrReplaceChild("BodyS",
                CubeListBuilder.create()
                        .texOffs(30, 72).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F)
                        .texOffs(58, 63).addBox(-3.0F, -16.0F, 4.0F, 5.0F, 5.0F, 5.0F)
                        .texOffs(17, 62).addBox(-2.0F, -11.0F, 5.0F, 3.0F, 7.0F, 3.0F)
                        .texOffs(58, 35).addBox(-3.0F, -4.0F, 2.0F, 5.0F, 5.0F, 9.0F),
                PartPose.offset(-0.1106F, -10.4929F, -5.0F));

        PartDefinition SwordA2 = Sword.addOrReplaceChild("SwordA2",
                CubeListBuilder.create()
                        .texOffs(37, 35).addBox(5.0F, 7.0F, -7.0F, 3.0F, 22.0F, 7.0F)
                        .texOffs(43, 72).addBox(5.0F, 27.0F, -10.0F, 3.0F, 2.0F, 3.0F),
                PartPose.offsetAndRotation(-1.2099F, -27.1376F, -1.7572F, -2.4435F, 1.0908F, 0.0F));

        PartDefinition BodySA = SwordA2.addOrReplaceChild("BodySA",
                CubeListBuilder.create()
                        .texOffs(30, 72).addBox(18.0F, 49.0F, -23.0F, 3.0F, 3.0F, 3.0F)
                        .texOffs(58, 63).addBox(17.0F, 36.0F, -18.0F, 5.0F, 5.0F, 5.0F)
                        .texOffs(17, 62).addBox(18.0F, 41.0F, -17.0F, 3.0F, 7.0F, 3.0F)
                        .texOffs(58, 35).addBox(17.0F, 48.0F, -20.0F, 5.0F, 5.0F, 9.0F),
                PartPose.offset(-13.0F, -46.0F, 12.0F));

        return LayerDefinition.create(mesh, 128, 128);
    }

    @Override
    public @NotNull ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(@NotNull CrazfireEntity entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        int attackState = entity.getAttackState();
        if (attackState == 1){this.animate(entity.sweepAttackAnimationState, CrazfireAnimations.SWEEP, ageInTicks);}
        else if (attackState == 2){this.animate(entity.slamAttackAnimationState, CrazfireAnimations.SLAM, ageInTicks);}
        else {
            this.animate(entity.idleAnimationState, CrazfireAnimations.IDLE, ageInTicks);
            this.animateWalk(CrazfireAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        }
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30F, 30.0F);
        headPitch = Mth.clamp(headPitch, -25F, 45.0F);

        this.Head.yRot = headYaw * ((float)Math.PI / 180F);
        this.Head.xRot = headPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer,
                               int packedLight, int packedOverlay, int color) {
        this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
