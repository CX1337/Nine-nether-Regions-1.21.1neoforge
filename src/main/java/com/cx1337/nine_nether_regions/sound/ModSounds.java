package com.cx1337.nine_nether_regions.sound;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, NineNetherRegions.MODID);

    public static final Supplier<SoundEvent> BUG_IDLE = registerSoundEvent("bug_idle");
    public static final Supplier<SoundEvent> BUG_HURT = registerSoundEvent("bug_hurt");
    public static final Supplier<SoundEvent> BUG_DEATH = registerSoundEvent("bug_death");

    public static final Supplier<SoundEvent> DAWN_OF_THE_APOCALYPSE = registerSoundEvent("dawn_of_the_apocalypse");
    public static final ResourceKey<JukeboxSong> DAWN_OF_THE_APOCALYPSE_KEY = createSong("dawn_of_the_apocalypse");
    public static final Supplier<SoundEvent> LONELY_MOUNTAIN = registerSoundEvent("lonely_mountain");
    public static final ResourceKey<JukeboxSong> LONELY_MOUNTAIN_KEY = createSong("lonely_mountain");
    public static final Supplier<SoundEvent> MYSTERIOUS_LIGHTS = registerSoundEvent("mysterious_lights");
    public static final ResourceKey<JukeboxSong> MYSTERIOUS_LIGHTS_KEY = createSong("mysterious_lights");
    public static final Supplier<SoundEvent> NIGHT_VIGIL = registerSoundEvent("night_vigil");
    public static final ResourceKey<JukeboxSong> NIGHT_VIGIL_KEY = createSong("night_vigil");
    public static final Supplier<SoundEvent> THINK_ABOUT_IT = registerSoundEvent("think_about_it");
    public static final ResourceKey<JukeboxSong> THINK_ABOUT_IT_KEY = createSong("think_about_it");
    public static final Supplier<SoundEvent> GO_ON_WITHOUT_ME = registerSoundEvent("go_on_without_me");
    public static final ResourceKey<JukeboxSong> GO_ON_WITHOUT_ME_KEY = createSong("go_on_without_me");
    public static final Supplier<SoundEvent> SATIN_DANGER = registerSoundEvent("satin_danger");
    public static final ResourceKey<JukeboxSong> SATIN_DANGER_KEY = createSong("satin_danger");


    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
