package com.cx1337.nine_nether_regions.entity;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.entity.custom.CrazfireEntity;
import com.cx1337.nine_nether_regions.entity.custom.StyxbugEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, NineNetherRegions.MODID);

    public static final Supplier<EntityType<CrazfireEntity>> CRAZFIRE =
            ENTITY_TYPES.register("crazfire", () -> EntityType.Builder.of(CrazfireEntity :: new, MobCategory.MONSTER)
                    .sized(1.25f, 2.25f).build("crazfire"));
    public static final Supplier<EntityType<StyxbugEntity>> STYXBUG =
            ENTITY_TYPES.register("styxbug", () -> EntityType.Builder.of(StyxbugEntity :: new, MobCategory.CREATURE)
                    .sized(0.22f, 0.18f).build("styxbug"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
