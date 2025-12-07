package com.cx1337.nine_nether_regions.event;

import com.cx1337.nine_nether_regions.block.ModBlocks;
import com.cx1337.nine_nether_regions.effect.ModEffects;
import com.cx1337.nine_nether_regions.item.ModItems;
import com.cx1337.nine_nether_regions.potion.ModPotions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModEvents {
    // 方块物品防火防雷防仙人掌
    private static final Set<Item> FIREPROOF_ITEMS = new HashSet<>();

    public static void register() {
        NeoForge.EVENT_BUS.register(new ModEvents());
    }
    public static void initFireProofItems() {
        FIREPROOF_ITEMS.clear();
        FIREPROOF_ITEMS.add(ModBlocks.BLOODBLADE_ORE.get().asItem());
        FIREPROOF_ITEMS.add(ModBlocks.HELLALLOY_BLOCK.get().asItem());
        FIREPROOF_ITEMS.add(ModBlocks.HELL_NUCLEUS.get().asItem());
        FIREPROOF_ITEMS.add(ModBlocks.STYX_BLOCK.get().asItem());
        FIREPROOF_ITEMS.add(ModItems.ALLOY_HILT.get());
        FIREPROOF_ITEMS.add(ModItems.BLOODBLADE_ESSENCE.get());
        FIREPROOF_ITEMS.add(ModItems.HELLALLOY_INGOT.get());
        FIREPROOF_ITEMS.add(ModItems.HELLALLOY_ROD.get());
        FIREPROOF_ITEMS.add(ModItems.HELLALLOY_LONGBOW.get());
        FIREPROOF_ITEMS.add(ModItems.HELLALLOY_HELMET.get());
        FIREPROOF_ITEMS.add(ModItems.HELLALLOY_CHESTPLATE.get());
        FIREPROOF_ITEMS.add(ModItems.HELLALLOY_LEGGINGS.get());
        FIREPROOF_ITEMS.add(ModItems.HELLALLOY_BOOTS.get());
        FIREPROOF_ITEMS.add(ModItems.HELLALLOY_AXE.get());
        FIREPROOF_ITEMS.add(ModItems.HELLALLOY_HOE.get());
        FIREPROOF_ITEMS.add(ModItems.HELLALLOY_PICKAXE.get());
        FIREPROOF_ITEMS.add(ModItems.HELLALLOY_SHOVEL.get());
        FIREPROOF_ITEMS.add(ModItems.HELLALLOY_SWORD.get());
        FIREPROOF_ITEMS.add(ModItems.STYX_FABRIC.get());
        FIREPROOF_ITEMS.add(ModItems.STYX_TEAR.get());
        FIREPROOF_ITEMS.add(ModItems.STYX_INGOT.get());
        FIREPROOF_ITEMS.add(ModItems.STYX_SWORD.get());
        FIREPROOF_ITEMS.add(ModItems.STYX_HELMET.get());
        FIREPROOF_ITEMS.add(ModItems.STYX_CHESTPLATE.get());
        FIREPROOF_ITEMS.add(ModItems.STYX_LEGGINGS.get());
        FIREPROOF_ITEMS.add(ModItems.STYX_BOOTS.get());
        FIREPROOF_ITEMS.add(ModItems.STYX_PICKAXE.get());
    }
    @SubscribeEvent
    public void makeItemFireproof(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof ItemEntity itemEntity &&
                FIREPROOF_ITEMS.contains(itemEntity.getItem().getItem())) {
            itemEntity.setUnlimitedLifetime();
            itemEntity.setInvulnerable(true);
        }
    }

    //血刃诅咒效果。
    @SubscribeEvent
    public void onBloodyDamage(LivingDamageEvent.Pre event) {
        LivingEntity entity = event.getEntity();

        if (entity.hasEffect(ModEffects.BLOODBLADE_CURSE)) {
            MobEffectInstance effectInstance = entity.getEffect(ModEffects.BLOODBLADE_CURSE);
            if (effectInstance != null) {
                int amplifier = effectInstance.getAmplifier();
                float damageAmount = event.getNewDamage();

                float damageMultiplier = 1.0f + (0.5f * (amplifier + 1));
                float finalDamage = damageAmount * damageMultiplier;

                event.setNewDamage(finalDamage);
            }
        }
    }

    //幽冥爆破效果
    private static final ThreadLocal<Boolean> IS_PROCESSING_HELL_BLAST =
            ThreadLocal.withInitial(() -> false);
    @SubscribeEvent
    public void onLivingDamageHellBlast(LivingDamageEvent.Post event) {
        if (IS_PROCESSING_HELL_BLAST.get()) {
            return;
        }
        LivingEntity victim = event.getEntity();
        if (victim.level().isClientSide) return;
        MobEffectInstance effect = victim.getEffect(ModEffects.HELL_BLAST);

        if (effect != null) {
            IS_PROCESSING_HELL_BLAST.set(true);
            try {
                int level = effect.getAmplifier();
                float damage = level + 2.0F;

                List<LivingEntity> entities = victim.level().getEntitiesOfClass(
                        LivingEntity.class,
                        new AABB(victim.blockPosition()).inflate(3.0));

                for (LivingEntity target : entities) {
                    target.hurt(victim.damageSources().indirectMagic(victim, victim), damage);
                    victim.level().levelEvent(2007,
                            BlockPos.containing(target.getX(), target.getY() + 1.0, target.getZ()),
                            0);
                }
                victim.level().playSound(null, victim.getX(), victim.getY(), victim.getZ(),
                        SoundEvents.FIREWORK_ROCKET_BLAST, SoundSource.PLAYERS, 1.0F, 0.8F);
            } finally {
                IS_PROCESSING_HELL_BLAST.set(false);
            }
        }
    }

    //樱花木套装效果
    @SubscribeEvent
    public void onPlayerTickCherry(PlayerTickEvent.Post event) {
        if (event.getEntity().level().isClientSide()) {
            return;
        }

        Player player = event.getEntity();
        boolean fullSet =
                player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.CHERRY_HELMET.get()) &&
                        player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.CHERRY_CHESTPLATE.get()) &&
                        player.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.CHERRY_LEGGINGS.get()) &&
                        player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.CHERRY_BOOTS.get());

        if (fullSet) {
           addIfMissingCherry(player, MobEffects.LUCK, 310, 0, false);
        }
    }
    private void addIfMissingCherry(Player player, Holder<MobEffect> effect, int duration, int amplifier, boolean particles) {
        MobEffectInstance inst = player.getEffect(effect);
        if (inst == null || inst.getAmplifier() < amplifier || inst.getDuration() < 300) {
            player.addEffect(new MobEffectInstance(effect, duration, amplifier, true, particles, true));
        }
    }

    //幽冥合金套全套效果
    private int hellalloyTickCounter = 0;
    @SubscribeEvent
    public void onPlayerTickHellalloy(PlayerTickEvent.Post event) {
        if (event.getEntity().level().isClientSide()) {
            return;
        }

        Player player = event.getEntity();
        boolean fullSet =
                player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.HELLALLOY_HELMET.get()) &&
                        player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.HELLALLOY_CHESTPLATE.get()) &&
                        player.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.HELLALLOY_LEGGINGS.get()) &&
                        player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.HELLALLOY_BOOTS.get());

        if (fullSet) {
            addIfMissingHellalloy(player, MobEffects.DAMAGE_RESISTANCE, 310, 1, false);

            // 强制恢复生命值
            hellalloyTickCounter++;

            if (hellalloyTickCounter >= 10) {
                hellalloyTickCounter = 0;

                float currentHealth = player.getHealth();
                float maxHealth = player.getMaxHealth();

                if (currentHealth < maxHealth && currentHealth > 0) {
                    float newHealth = Math.min(currentHealth + 0.7F, maxHealth);
                    player.setHealth(newHealth);
                }
            }
        } else {
            hellalloyTickCounter = 0;
        }
    }
    private void addIfMissingHellalloy(Player player, Holder<MobEffect> effect, int duration, int amplifier, boolean particles) {
        MobEffectInstance inst = player.getEffect(effect);
        if (inst == null || inst.getAmplifier() < amplifier || inst.getDuration() < 300) {
            player.addEffect(new MobEffectInstance(effect, duration, amplifier, true, particles, true));
        }
    }
    //减伤
    @SubscribeEvent
    public void onLivingDamageHellalloy(LivingDamageEvent.Pre event) {
        if (event.getEntity() instanceof Player player) {
            boolean fullSet =
                    player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.HELLALLOY_HELMET.get()) &&
                            player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.HELLALLOY_CHESTPLATE.get()) &&
                            player.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.HELLALLOY_LEGGINGS.get()) &&
                            player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.HELLALLOY_BOOTS.get());

            if (fullSet) {
                float originalDamage = event.getNewDamage();
                float reducedDamage = originalDamage * 0.66f;
                event.setNewDamage(reducedDamage);
            }
        }
    }

    //虹玉套减伤
    @SubscribeEvent
    public void onLivingDamageRainbowgem(LivingDamageEvent.Pre event) {
        if (event.getEntity() instanceof Player player) {
            boolean fullSet =
                    player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.RAINBOWGEM_HELMET.get()) &&
                            player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.RAINBOWGEM_CHESTPLATE.get()) &&
                            player.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.RAINBOWGEM_LEGGINGS.get()) &&
                            player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.RAINBOWGEM_BOOTS.get());

            if (fullSet) {
                float originalDamage = event.getNewDamage();
                float reducedDamage = originalDamage * 0.90f;
                event.setNewDamage(reducedDamage);
            }
        }
    }

    //冥河套全套效果。
    private int styxTickCounter = 0;
    @SubscribeEvent
    public void onPlayerTickStyx(PlayerTickEvent.Post event) {
        if (event.getEntity().level().isClientSide()) {
            return;
        }

        Player player = event.getEntity();
        boolean fullSet =
                player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.STYX_HELMET.get()) &&
                        player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.STYX_CHESTPLATE.get()) &&
                        player.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.STYX_LEGGINGS.get()) &&
                        player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.STYX_BOOTS.get());

        if (fullSet) {
            addIfMissingStyx(player, MobEffects.DAMAGE_RESISTANCE, 310, 2, false);
            addIfMissingStyx(player, MobEffects.ABSORPTION, 310, 1, false);

            //强制恢复生命值
            styxTickCounter++;
            if (styxTickCounter >= 10) {
                styxTickCounter = 0;

                float currentHealth = player.getHealth();
                float maxHealth = player.getMaxHealth();

                if (currentHealth < maxHealth && currentHealth > 0) {
                    float newHealth = Math.min(currentHealth + 1.5F, maxHealth);
                    player.setHealth(newHealth);
                }
            }
        } else {
            styxTickCounter = 0;
        }
    }
    private void addIfMissingStyx(Player player, Holder<MobEffect> effect, int duration, int amplifier, boolean particles) {
        MobEffectInstance inst = player.getEffect(effect);
        if (inst == null || inst.getAmplifier() < amplifier || inst.getDuration() < 300) {
            player.addEffect(new MobEffectInstance(effect, duration, amplifier, true, particles, true));
        }
    }
    //减伤
    @SubscribeEvent
    public void onLivingDamageStyx(LivingDamageEvent.Pre event) {
        if (event.getEntity() instanceof Player player) {
            boolean fullSet =
                    player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.STYX_HELMET.get()) &&
                            player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.STYX_CHESTPLATE.get()) &&
                            player.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.STYX_LEGGINGS.get()) &&
                            player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.STYX_BOOTS.get());
            if (fullSet) {
                DamageSource source = event.getSource();
                if (source.is(DamageTypes.MAGIC) || source.is(DamageTypes.DRAGON_BREATH)
                || source.is(DamageTypes.WITHER) || source.is(DamageTypes.INDIRECT_MAGIC)) {
                    return;
                }
                if (source.is(DamageTypeTags.IS_EXPLOSION)) {
                    event.setNewDamage(0);
                    return;
                }
                if (source.is(DamageTypeTags.IS_FREEZING)) {
                    event.setNewDamage(0);
                    return;
                }
                if (source.is(DamageTypes.SONIC_BOOM)) {
                    event.setNewDamage(0);
                    return;
                }
            }

            float originalDamage = event.getNewDamage();
                if (fullSet && originalDamage <= 3.0f) {
                    event.setNewDamage(0);
                    return;
            }
                if (fullSet) {
                    float reducedDamage = originalDamage * 0.28f;
                    event.setNewDamage(reducedDamage);
                }

            boolean hasBoots = player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.STYX_BOOTS.get());
                if (hasBoots && event.getSource().is(DamageTypes.FALL)) {
                    float reducedFallDamage = originalDamage * 0.15f;
                    event.setNewDamage(reducedFallDamage);
                }
        }
    }

    @SubscribeEvent
    public void onLivingDamageSkull(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        DamageSource source = event.getSource();

        if (source.getDirectEntity() instanceof WitherSkull witherSkull) {
            Entity owner = witherSkull.getOwner();
            if (target.equals(owner)) {
                event.setNewDamage(0.0f);
                return;
            }
        }
    }

    //药剂
    @SubscribeEvent
    public void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();
        builder.addMix(Potions.AWKWARD, ModItems.GHOSTLIUM.get(), ModPotions.DECLINE_POTION);
        builder.addMix(ModPotions.DECLINE_POTION, ModItems.RUBY.get(), ModPotions.S_DECLINE_POTION);
        builder.addMix(Potions.AWKWARD, ModBlocks.BLOODBLADE_ROCK.get().asItem(), ModPotions.BB_CURSE_POTION);
        builder.addMix(ModPotions.BB_CURSE_POTION, ModItems.RUBY.get(), ModPotions.S_BB_CURSE_POTION);
        builder.addMix(Potions.AWKWARD, Items.BLUE_ICE, ModPotions.FROST_POTION);
        builder.addMix(ModPotions.FROST_POTION, ModItems.RUBY.get(), ModPotions.S_FROST_POTION);
    }
}
