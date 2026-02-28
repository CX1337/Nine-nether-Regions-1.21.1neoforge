package com.cx1337.nine_nether_regions;

import com.cx1337.nine_nether_regions.block.ModBlocks;
import com.cx1337.nine_nether_regions.client.event.ClientEvents;
import com.cx1337.nine_nether_regions.effect.ModEffects;
import com.cx1337.nine_nether_regions.enchantment.ModEnchantmentEffects;
import com.cx1337.nine_nether_regions.item.ModCreativeModeTabs;
import com.cx1337.nine_nether_regions.event.ModEvents;
import com.cx1337.nine_nether_regions.item.ModItems;
import com.cx1337.nine_nether_regions.potion.ModPotions;
import com.cx1337.nine_nether_regions.sound.ModSounds;
import com.cx1337.nine_nether_regions.util.ModItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.fml.common.EventBusSubscriber;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(NineNetherRegions.MODID)
public class NineNetherRegions {
    public static final String MODID = "nine_nether_regions";

    public static final Logger LOGGER = LogUtils.getLogger();

    public NineNetherRegions(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEvents.register();
        ModSounds.register(modEventBus);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModEnchantmentEffects.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public void onCommonSetup(FMLCommonSetupEvent event) {
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));

        event.enqueueWork(ModEvents::initFireProofItems);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @EventBusSubscriber(modid = NineNetherRegions.MODID)
    public class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLCommonSetupEvent event) {
            ModItemProperties.addCustomItemProperties();
        }
    }
}
