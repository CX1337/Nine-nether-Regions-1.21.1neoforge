package com.cx1337.nine_nether_regions.entity.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class CrazfireEntity extends Monster {
    private static final EntityDataAccessor<Integer> ATTACK_STATE =
            SynchedEntityData.defineId(CrazfireEntity.class, EntityDataSerializers.INT);
    private int attackCooldown = 0;
    public final AnimationState idleAnimationState = new AnimationState();
    public final  AnimationState walkAnimationState = new AnimationState();
    public final  AnimationState sweepAttackAnimationState = new AnimationState();
    public final  AnimationState slamAttackAnimationState = new AnimationState();

    public CrazfireEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 70;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ATTACK_STATE, 0);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 144.0D)
                .add(Attributes.ARMOR, 12.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 6.0D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28D)
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new CrazfireAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            updateAnimationStates();
            spawnSoulParticles();
        } else  {
            if (attackCooldown > 0) {
                --attackCooldown;
            }
        }
    }
    private void updateAnimationStates() {
        int state = this.getAttackState();
        if (state == 1) {
            this.sweepAttackAnimationState.start(this.tickCount);
            this.slamAttackAnimationState.stop();
            this.idleAnimationState.stop();
        } else if (state == 2) {
            this.slamAttackAnimationState.start(this.tickCount);
            this.sweepAttackAnimationState.stop();
            this.idleAnimationState.stop();
        } else {
            this.sweepAttackAnimationState.stop();
            this.slamAttackAnimationState.stop();
            this.idleAnimationState.startIfStopped(this.tickCount);
        }
        if (state == 0) {
            boolean moving = this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
            if (moving) {
                this.walkAnimationState.startIfStopped(this.tickCount);
            } else  {
                this.walkAnimationState.stop();
            }
        } else {
            this.walkAnimationState.stop();
        }
    }
    private void spawnSoulParticles() {
        if (this.random.nextFloat() < 0.15F) {
            double x = this.getX() + (this.random.nextDouble() - 0.5) * this.getBbWidth();
            double y = this.getY() + this.random.nextDouble() * this.getBbHeight();
            double z = this.getZ() + (this.random.nextDouble() - 0.5) * this.getBbWidth();
            this.level().addParticle(ParticleTypes.SOUL, x, y, z, 0.0D, 0.02D, 0.0D);
        }
    }

    public int getAttackState() {
        return this.entityData.get(ATTACK_STATE);
    }

    public void setAttackState(int state) {
        this.entityData.set(ATTACK_STATE, state);
    }

    public boolean isAttackReady() {
        return attackCooldown <= 0;
    }

    public void resetAttackCooldown() {
        this.attackCooldown = 20;
    }

    @Override
    protected void dropCustomDeathLoot(@NotNull ServerLevel level, @NotNull DamageSource damageSource,
                                       boolean recentlyHit) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHit);
        int count = 2 + this.random.nextInt(3);
        ItemStack scrapStack = new ItemStack(Items.NETHERITE_SCRAP, count);
        ItemStack rodStack = new ItemStack(Items.BLAZE_ROD, count);
        this.spawnAtLocation(rodStack);
        this.spawnAtLocation(scrapStack);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, @NotNull DamageSource source) {
        return false;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.BLAZE_AMBIENT;
    }

    @Override
    protected @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return SoundEvents.BLAZE_HURT;
    }
    @Override
    protected @NotNull SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }

    //横扫攻击。
    private void performSweepAttack() {
        double radius = 4.0D;
        AABB area = this.getBoundingBox().inflate(radius, 1.0D, radius);
        List<LivingEntity> targets = this.level().getEntitiesOfClass(LivingEntity.class, area,
                e -> e != this && e.isAlive() && !(e instanceof CrazfireEntity));

        for (LivingEntity target : targets) {
            float percentageDamage = target.getMaxHealth() * 0.22F;
            target.hurt(this.damageSources().mobAttack(this), 14.0F + percentageDamage);
            target.setRemainingFireTicks(120);
        }

        this.level().playSound(null, this.blockPosition(), SoundEvents.PLAYER_ATTACK_SWEEP,
                this.getSoundSource(), 1.0F, 1.0F);
    }
    //竖劈攻击。
    private void performSlamAttack() {
        Vec3 look = this.getLookAngle();
        Vec3 center = this.position().add(0, this.getEyeHeight() * 0.8, 0);
        double halfWidth = 2.0;
        double length = 6.0;
        double height = 1.5 * this.getBbHeight();
        Vec3 forward = look.scale(length / 2.0);
        Vec3 boxCenter = center.add(forward);

        AABB roughArea = new AABB(
                boxCenter.x - halfWidth, boxCenter.y - height / 2, boxCenter.z - halfWidth,
                boxCenter.x + halfWidth, boxCenter.y + height / 2, boxCenter.z + halfWidth
        ).inflate(length / 2, 0, length / 2);

        List<LivingEntity> candidates = this.level().getEntitiesOfClass(LivingEntity.class, roughArea,
                e -> e != this && e.isAlive() && !(e instanceof CrazfireEntity));

        for (LivingEntity target : candidates) {
            Vec3 relative = target.position().subtract(boxCenter);
            double dotForward = relative.dot(look);
            if (dotForward < 0 || dotForward > length) continue;
            if (Math.abs(relative.y) > height / 2.0) continue;
            Vec3 right = look.cross(new Vec3(0, 1, 0)).normalize();
            double dotRight = Math.abs(relative.dot(right));
            if (dotRight > halfWidth) continue;

            float percentageDamage = target.getMaxHealth() * 0.44F;
            target.hurt(this.damageSources().mobAttack(this), percentageDamage + 18.0F);
            target.setRemainingFireTicks(160);
        }

        this.level().playSound(null, this.blockPosition(), SoundEvents.ANVIL_FALL,
                this.getSoundSource(), 1.0F, 1.0F);
    }

    //AI
    static class CrazfireAttackGoal extends Goal {
        private final CrazfireEntity mob;
        private final double speedModifier;
        private final boolean followingTargetEvenIfNotSeen;
        private LivingEntity target;
        private int attackDelay = 0;
        private long lastCanUseCheck;

        public CrazfireAttackGoal(CrazfireEntity mob, double speedModifier, boolean followingEvenIfNotSeen) {
            this.mob = mob;
            this.speedModifier = speedModifier;
            this.followingTargetEvenIfNotSeen = followingEvenIfNotSeen;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            long gameTime = this.mob.level().getGameTime();
            if (gameTime - this.lastCanUseCheck < 20L) {
                return false;
            }
            this.lastCanUseCheck = gameTime;
            LivingEntity target = this.mob.getTarget();
            if (target == null || !target.isAlive()) {
                return false;
            }
            this.target = target;
            return true;
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity target = this.mob.getTarget();
            if (target == null || !target.isAlive()) {
                return false;
            }
            if (!this.followingTargetEvenIfNotSeen && this.mob.getNavigation().isDone()) {
                return false;
            }
            return true;
        }

        @Override
        public void start() {
            this.mob.setAggressive(true);
            this.attackDelay = 0;
        }

        @Override
        public void stop() {
            this.mob.setAggressive(false);
            this.mob.setAttackState(0);
            this.target = null;
        }

        @Override
        public void tick() {
            if (this.target == null) return;
            this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
            double distanceSq = this.mob.distanceToSqr(this.target);

            if (this.attackDelay > 0) {
                this.attackDelay--;
            }

            if (this.attackDelay <= 0 && distanceSq <= getAttackReachSqr(this.target)) {
                boolean useSlam = this.mob.getRandom().nextBoolean();

                if (useSlam) {
                    this.mob.setAttackState(2);
                    this.mob.performSlamAttack();
                } else {
                    this.mob.setAttackState(1);
                    this.mob.performSweepAttack();
                }

                this.mob.resetAttackCooldown();
                this.attackDelay = 65;
                this.mob.level().getServer().tell(new net.minecraft.server.TickTask(65, () -> {
                    if (this.mob.isAlive()) {
                        this.mob.setAttackState(0);
                    }
                }));
            } else {
                if (distanceSq > getAttackReachSqr(this.target) * 0.8) {
                    this.mob.getNavigation().moveTo(this.target, this.speedModifier);
                } else {
                    this.mob.getNavigation().stop();
                }
            }
        }

        private double getAttackReachSqr(LivingEntity target) {
            double reach = this.mob.getBbWidth() * 2.0F + target.getBbWidth() + 1.0F;
            return reach * reach;
        }
    }
}
