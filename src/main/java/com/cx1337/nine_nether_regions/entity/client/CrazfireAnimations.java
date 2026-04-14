package com.cx1337.nine_nether_regions.entity.client;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class CrazfireAnimations {
    // 空闲动画 (idle)
    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(2.5F).looping()
            .addAnimation("Core",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Head",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.posVec(-1.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Cannons",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, -357.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.25F, KeyframeAnimations.posVec(2.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .build();

    // 行走动画 (walk)
    public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(2.0F)
            .addAnimation("Core",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Core",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Cannons",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 352.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, -42.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.degreeVec(25.0F, -42.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .build();

    // 竖劈动画
    public static final AnimationDefinition SLAM = AnimationDefinition.Builder.withLength(3.0F)
            .addAnimation("Core",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6667F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.9583F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Core",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 4.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5417F, KeyframeAnimations.degreeVec(5.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9583F, KeyframeAnimations.degreeVec(5.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6667F, KeyframeAnimations.degreeVec(28.7139F, 18.8262F, 4.8596F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.degreeVec(-34.8207F, 2.6748F, 1.6206F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.degreeVec(-34.8207F, 2.6748F, 1.6206F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.9583F, KeyframeAnimations.degreeVec(2.6793F, 2.6748F, 1.6206F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Head",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, -6.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 7.02F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 6.4F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, -1.0F, 7.02F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 6.4F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.01F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.degreeVec(148.1197F, -6.6782F, -10.5906F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6667F, KeyframeAnimations.degreeVec(303.2313F, 8.0034F, -1.04F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.degreeVec(30.7963F, -8.4805F, -16.4078F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.degreeVec(30.7963F, -8.4805F, -16.4078F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.posVec(-4.0F, 27.0F, 12.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6667F, KeyframeAnimations.posVec(-4.0F, 10.0F, -11.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.posVec(-4.0F, -3.0F, 11.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.posVec(-4.0F, -3.0F, 11.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Cannons",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6667F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Cannons",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5F, KeyframeAnimations.degreeVec(-121.9292F, -53.9871F, -14.4224F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-121.9292F, -53.9871F, -14.4224F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25F, KeyframeAnimations.degreeVec(18.0708F, -53.9871F, -14.4224F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6667F, KeyframeAnimations.degreeVec(43.0708F, -53.9871F, -14.4224F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.degreeVec(-168.9815F, -65.637F, -4.9467F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.degreeVec(-168.9815F, -65.637F, -4.9467F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.75F, KeyframeAnimations.degreeVec(-121.9292F, -53.9871F, -14.4224F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5F, KeyframeAnimations.posVec(5.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9583F, KeyframeAnimations.posVec(5.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25F, KeyframeAnimations.posVec(5.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6667F, KeyframeAnimations.posVec(5.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.posVec(5.0F, 0.0F, 9.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.posVec(5.0F, 0.0F, 9.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.75F, KeyframeAnimations.posVec(5.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .build();

    // 横扫动画 (forces)
    public static final AnimationDefinition SWEEP = AnimationDefinition.Builder.withLength(3.0417F)
            .addAnimation("Core",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6667F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.7917F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.375F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Core",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.25F, KeyframeAnimations.degreeVec(-30.4077F, 24.1782F, -13.5158F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("Head",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 1.0F, 4.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.degreeVec(-54.3516F, -10.2124F, 57.7532F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5F, KeyframeAnimations.degreeVec(-69.3516F, -10.2124F, 57.7532F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75F, KeyframeAnimations.degreeVec(-69.3516F, -10.2124F, 57.7532F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.875F, KeyframeAnimations.degreeVec(57.4212F, 2.0269F, 69.4441F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0417F, KeyframeAnimations.degreeVec(121.4515F, 18.346F, 85.0319F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.25F, KeyframeAnimations.degreeVec(121.4515F, 18.346F, 85.0319F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.posVec(-13.0F, -5.0F, -14.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5F, KeyframeAnimations.posVec(-11.0F, -5.0F, -16.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75F, KeyframeAnimations.posVec(-11.0F, -5.0F, -16.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.7917F, KeyframeAnimations.posVec(-18.11F, -4.78F, -17.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.8333F, KeyframeAnimations.posVec(-21.1F, -4.56F, 3.62F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.875F, KeyframeAnimations.posVec(-11.41F, -3.45F, 21.88F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.9167F, KeyframeAnimations.posVec(-5.2F, -3.22F, 26.94F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.25F, KeyframeAnimations.posVec(-5.2F, -3.22F, 26.94F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.6667F, KeyframeAnimations.posVec(1.0F, -2.0F, 16.67F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.7083F, KeyframeAnimations.posVec(-1.13F, -1.75F, 14.59F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.75F, KeyframeAnimations.posVec(-3.97F, -1.5F, 12.51F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.7917F, KeyframeAnimations.posVec(-5.31F, -1.25F, 10.43F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.8333F, KeyframeAnimations.posVec(-6.25F, -1.0F, 8.34F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.875F, KeyframeAnimations.posVec(-6.69F, -0.75F, 6.26F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.9167F, KeyframeAnimations.posVec(-5.46F, -0.5F, 4.17F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.9583F, KeyframeAnimations.posVec(-3.73F, -0.25F, 2.08F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA2",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25F, KeyframeAnimations.degreeVec(-200.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.degreeVec(-275.7783F, -47.4514F, -79.8966F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5F, KeyframeAnimations.degreeVec(-308.761F, -47.4816F, -72.1305F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75F, KeyframeAnimations.degreeVec(-308.761F, -47.4816F, -72.1305F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.degreeVec(-123.8846F, -72.3409F, -74.8023F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-109.3792F, -66.4236F, -91.3996F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.2917F, KeyframeAnimations.degreeVec(-109.3792F, -66.4236F, -91.3996F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.degreeVec(-123.8846F, -72.3409F, -74.8023F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-120.9372F, -76.7813F, -24.1555F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-112.3928F, -74.6692F, -7.5583F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .addAnimation("SwordA2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25F, KeyframeAnimations.posVec(11.0F, 4.0F, 7.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0F, KeyframeAnimations.posVec(16.0F, -17.0F, 3.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75F, KeyframeAnimations.posVec(16.0F, -17.0F, 3.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0F, KeyframeAnimations.posVec(11.0F, -17.0F, 16.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0833F, KeyframeAnimations.posVec(11.0F, -21.0F, 16.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.2917F, KeyframeAnimations.posVec(11.0F, -21.0F, 16.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.posVec(11.0F, -17.0F, 16.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                    )
            )
            .build();
}
