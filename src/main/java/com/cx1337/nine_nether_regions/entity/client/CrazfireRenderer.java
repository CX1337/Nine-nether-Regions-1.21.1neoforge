package com.cx1337.nine_nether_regions.entity.client;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.entity.custom.CrazfireEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CrazfireRenderer extends MobRenderer<CrazfireEntity, CrazfireModel<CrazfireEntity>> {
    public CrazfireRenderer(EntityRendererProvider.Context context) {
        super(context, new CrazfireModel<>(context.bakeLayer(CrazfireModel.LAYER_LOCATION)), 0.6f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull CrazfireEntity crazfireEntity) {
        return ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "textures/entity/crazfire.png");
    }

    @Override
    public void render(@NotNull CrazfireEntity entity, float entityYaw, float partialTicks,
                       @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        try {
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));

            if (entity.isBaby()) {
                poseStack.scale(0.5f, 0.5f, 0.5f);
            } else {
                poseStack.scale(1f, 1f, 1f);
            }
            super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        } finally {
            poseStack.popPose();
        }
    }
}
