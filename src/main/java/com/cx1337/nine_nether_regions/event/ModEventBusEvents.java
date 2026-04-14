package com.cx1337.nine_nether_regions.event;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.entity.ModEntities;
import com.cx1337.nine_nether_regions.entity.client.CrazfireModel;
import com.cx1337.nine_nether_regions.entity.client.StyxbugModel;
import com.cx1337.nine_nether_regions.entity.client.StyxbugRenderer;
import com.cx1337.nine_nether_regions.entity.custom.CrazfireEntity;
import com.cx1337.nine_nether_regions.entity.custom.StyxbugEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = NineNetherRegions.MODID)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CrazfireModel.LAYER_LOCATION, CrazfireModel::createBodyLayer);
        event.registerLayerDefinition(StyxbugModel.LAYER_LOCATION, StyxbugModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CRAZFIRE.get(), CrazfireEntity.createAttributes().build());
        event.put(ModEntities.STYXBUG.get(), StyxbugEntity.createAttributes().build());
    }
}
