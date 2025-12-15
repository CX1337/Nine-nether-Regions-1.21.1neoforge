package com.cx1337.nine_nether_regions.item.custom;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import net.minecraft.resources.ResourceLocation;

public interface RangeWeapon {
    ResourceLocation BASE_ENTITY_INTERACTION_RANGE_ID =
            ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "base_entity_interaction_range");
    ResourceLocation BASE_BLOCK_INTERACTION_RANGE_ID =
            ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "base_block_interaction_range");
}
