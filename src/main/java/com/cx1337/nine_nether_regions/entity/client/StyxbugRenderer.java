package com.cx1337.nine_nether_regions.entity.client;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.entity.StyxbugVariant;
import com.cx1337.nine_nether_regions.entity.custom.StyxbugEntity;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class StyxbugRenderer extends MobRenderer<StyxbugEntity, StyxbugModel<StyxbugEntity>> {
    private static final Map<StyxbugVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(StyxbugVariant.class), map -> {
                map.put(StyxbugVariant.RED,
                        ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "textures/entity/styxbug/styxbug.png"));
                map.put(StyxbugVariant.GREEN,
                        ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "textures/entity/styxbug/styxbug_green.png"));
            });

    public StyxbugRenderer(EntityRendererProvider.Context context) {
        super(context, new StyxbugModel<>(context.bakeLayer(StyxbugModel.LAYER_LOCATION)), 0.15f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull StyxbugEntity styxbugEntity) {
        return LOCATION_BY_VARIANT.get(styxbugEntity.getVariant());
    }

    @Override
    public void render(@NotNull StyxbugEntity entity, float entityYaw, float partialTicks,
                       @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.45F, 0.45F, 0.45F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
