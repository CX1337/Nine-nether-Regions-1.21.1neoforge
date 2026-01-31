package com.cx1337.nine_nether_regions.client.event;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import com.cx1337.nine_nether_regions.effect.ModEffects;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;

@OnlyIn(Dist.CLIENT)
public class ClientEvents {
    private static int displayHealth;
    private static int lastHealth;
    private static long lastHealthTime;
    private static long healthBlinkTime;
    private static final RandomSource random = RandomSource.create();

    //归寂
    @SubscribeEvent
    public static void onRenderGuiLayerDecline(RenderGuiLayerEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        if (player == null || !player.hasEffect((ModEffects.DECLINE))) {
            return;
        }
        if (player.isCreative() || player.isSpectator()) {
            return;
        }
        CustomHealthDecline(event);
    }

    private static void CustomHealthDecline(RenderGuiLayerEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        Minecraft mc = Minecraft.getInstance();
        GuiGraphics stack = event.getGuiGraphics();

        ResourceLocation EFFECT_HEART_DECLINE =
                ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "textures/gui/effect_heart_decline.png");

        int width = stack.guiWidth();
        int height = stack.guiHeight();
        stack.pose().pushPose();

        int health = Mth.ceil(player.getHealth());
        int tickCount = (int) (System.currentTimeMillis() / 50);

        boolean highlight =
                healthBlinkTime > (long) tickCount && (healthBlinkTime - (long) tickCount) / 3L % 2L == 1L;

        if (health < lastHealth && player.invulnerableTime > 0) {
            lastHealthTime = Util.getMillis();
            healthBlinkTime = (long) (tickCount + 20);
        } else if (health > lastHealth && player.invulnerableTime > 0) {
            lastHealthTime = Util.getMillis();
            healthBlinkTime = (long) (tickCount + 10);
        }

        if (Util.getMillis() - lastHealthTime > 1000L) {
            lastHealth = health;
            displayHealth = health;
            lastHealthTime = Util.getMillis();
        }

        lastHealth = health;
        int healthLast = displayHealth;
        AttributeInstance maxHealth = player.getAttribute(Attributes.MAX_HEALTH);
        float healthMax = maxHealth != null ? (float) maxHealth.getValue() : 20.0f;
        int absorption = Mth.ceil(player.getAbsorptionAmount());
        int healthRows = Mth.ceil((healthMax + (float) absorption) / 2.0F / 10.0F);
        int rowHeight = Math.max(10 - (healthRows - 2), 3);

        random.setSeed((long) (tickCount * 312871L));
        int left = width / 2 - 91;
        int top = height - 39;
        int leftHeight = 39;
        leftHeight += healthRows * rowHeight;
        if (rowHeight != 10) {
            leftHeight += 10 - rowHeight;
        }

        int regen = -1;
        if (player.hasEffect(MobEffects.REGENERATION)) {
            regen = tickCount % Mth.ceil(healthMax + 5.0F);
        }

        int TOP = player.level().getLevelData().isHardcore() ? 9 : 0;
        int BACKGROUND = highlight ? 25 : 16;
        int margin = 34;
        float absorptionRemaining = (float) absorption;

        for (int i = Mth.ceil((healthMax + (float) absorption) / 2.0F) - 1; i >= 0; --i) {
            int row = Mth.ceil((float) (i + 1) / 10.0F) - 1;
            int x = left + i % 10 * 8;
            int y = top - row * rowHeight;
            if (health <= 4) {
                y += random.nextInt(2);
            }

            if (i == regen) {
                y -= 2;
            }

            stack.blit(EFFECT_HEART_DECLINE, x, y, BACKGROUND, TOP, 9, 9);
            if (highlight) {
                if (i * 2 + 1 < healthLast) {
                    stack.blit(EFFECT_HEART_DECLINE, x, y, margin, TOP, 9, 9);
                } else if (i * 2 + 1 == healthLast) {
                    stack.blit(EFFECT_HEART_DECLINE, x, y, margin + 9, TOP, 9, 9);
                }
            }

            if (absorptionRemaining > 0.0F) {
                if (absorptionRemaining == (float) absorption && (float) absorption % 2.0F == 1.0F) {
                    stack.blit(EFFECT_HEART_DECLINE, x, y, margin + 9, TOP, 9, 9);
                    --absorptionRemaining;
                } else {
                    stack.blit(EFFECT_HEART_DECLINE, x, y, margin, TOP, 9, 9);
                    absorptionRemaining -= 2.0F;
                }
            } else if (i * 2 + 1 < health) {
                stack.blit(EFFECT_HEART_DECLINE, x, y, margin, TOP, 9, 9);
            } else if (i * 2 + 1 == health) {
                stack.blit(EFFECT_HEART_DECLINE, x, y, margin + 9, TOP, 9, 9);
            }
        }
        stack.pose().popPose();
    }

    //冰冻
    @SubscribeEvent
    public static void onRenderGuiLayerFrost(RenderGuiLayerEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        if (player == null || !player.hasEffect((ModEffects.FROST))) {
            return;
        }
        if (player.isCreative() || player.isSpectator()) {
            return;
        }
        CustomHealthFrost(event);
    }

    private static void CustomHealthFrost(RenderGuiLayerEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        Minecraft mc = Minecraft.getInstance();
        GuiGraphics stack = event.getGuiGraphics();

        ResourceLocation EFFECT_HEART_FROST =
                ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "textures/gui/effect_heart_frost.png");

        int width = stack.guiWidth();
        int height = stack.guiHeight();
        stack.pose().pushPose();

        int health = Mth.ceil(player.getHealth());
        int tickCount = (int) (System.currentTimeMillis() / 50);

        boolean highlight =
                healthBlinkTime > (long) tickCount && (healthBlinkTime - (long) tickCount) / 3L % 2L == 1L;

        if (health < lastHealth && player.invulnerableTime > 0) {
            lastHealthTime = Util.getMillis();
            healthBlinkTime = (long) (tickCount + 20);
        } else if (health > lastHealth && player.invulnerableTime > 0) {
            lastHealthTime = Util.getMillis();
            healthBlinkTime = (long) (tickCount + 10);
        }

        if (Util.getMillis() - lastHealthTime > 1000L) {
            lastHealth = health;
            displayHealth = health;
            lastHealthTime = Util.getMillis();
        }

        lastHealth = health;
        int healthLast = displayHealth;
        AttributeInstance maxHealth = player.getAttribute(Attributes.MAX_HEALTH);
        float healthMax = maxHealth != null ? (float) maxHealth.getValue() : 20.0f;
        int absorption = Mth.ceil(player.getAbsorptionAmount());
        int healthRows = Mth.ceil((healthMax + (float) absorption) / 2.0F / 10.0F);
        int rowHeight = Math.max(10 - (healthRows - 2), 3);

        random.setSeed((long) (tickCount * 312871L));
        int left = width / 2 - 91;
        int top = height - 39;
        int leftHeight = 39;
        leftHeight += healthRows * rowHeight;
        if (rowHeight != 10) {
            leftHeight += 10 - rowHeight;
        }

        int regen = -1;
        if (player.hasEffect(MobEffects.REGENERATION)) {
            regen = tickCount % Mth.ceil(healthMax + 5.0F);
        }

        int TOP = player.level().getLevelData().isHardcore() ? 9 : 0;
        int BACKGROUND = highlight ? 25 : 16;
        int margin = 34;
        float absorptionRemaining = (float) absorption;

        for (int i = Mth.ceil((healthMax + (float) absorption) / 2.0F) - 1; i >= 0; --i) {
            int row = Mth.ceil((float) (i + 1) / 10.0F) - 1;
            int x = left + i % 10 * 8;
            int y = top - row * rowHeight;
            if (health <= 4) {
                y += random.nextInt(2);
            }

            if (i == regen) {
                y -= 2;
            }

            stack.blit(EFFECT_HEART_FROST, x, y, BACKGROUND, TOP, 9, 9);
            if (highlight) {
                if (i * 2 + 1 < healthLast) {
                    stack.blit(EFFECT_HEART_FROST, x, y, margin, TOP, 9, 9);
                } else if (i * 2 + 1 == healthLast) {
                    stack.blit(EFFECT_HEART_FROST, x, y, margin + 9, TOP, 9, 9);
                }
            }

            if (absorptionRemaining > 0.0F) {
                if (absorptionRemaining == (float) absorption && (float) absorption % 2.0F == 1.0F) {
                    stack.blit(EFFECT_HEART_FROST, x, y, margin + 9, TOP, 9, 9);
                    --absorptionRemaining;
                } else {
                    stack.blit(EFFECT_HEART_FROST, x, y, margin, TOP, 9, 9);
                    absorptionRemaining -= 2.0F;
                }
            } else if (i * 2 + 1 < health) {
                stack.blit(EFFECT_HEART_FROST, x, y, margin, TOP, 9, 9);
            } else if (i * 2 + 1 == health) {
                stack.blit(EFFECT_HEART_FROST, x, y, margin + 9, TOP, 9, 9);
            }
        }
        stack.pose().popPose();
    }

    //磁锢
    @SubscribeEvent
    public static void onRenderGuiLayerMagConfine(RenderGuiLayerEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        if (player == null || !player.hasEffect((ModEffects.MAG_CONFINE))) {
            return;
        }
        if (player.isCreative() || player.isSpectator()) {
            return;
        }
        CustomHealthMagConfine(event);
    }

    private static void CustomHealthMagConfine(RenderGuiLayerEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        Minecraft mc = Minecraft.getInstance();
        GuiGraphics stack = event.getGuiGraphics();

        ResourceLocation EFFECT_HEART_MAG_DEFINE =
                ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "textures/gui/effect_heart_mag_confine.png");

        int width = stack.guiWidth();
        int height = stack.guiHeight();
        stack.pose().pushPose();

        int health = Mth.ceil(player.getHealth());
        int tickCount = (int) (System.currentTimeMillis() / 50);

        boolean highlight =
                healthBlinkTime > (long) tickCount && (healthBlinkTime - (long) tickCount) / 3L % 2L == 1L;

        if (health < lastHealth && player.invulnerableTime > 0) {
            lastHealthTime = Util.getMillis();
            healthBlinkTime = (long) (tickCount + 20);
        } else if (health > lastHealth && player.invulnerableTime > 0) {
            lastHealthTime = Util.getMillis();
            healthBlinkTime = (long) (tickCount + 10);
        }

        if (Util.getMillis() - lastHealthTime > 1000L) {
            lastHealth = health;
            displayHealth = health;
            lastHealthTime = Util.getMillis();
        }

        lastHealth = health;
        int healthLast = displayHealth;
        AttributeInstance maxHealth = player.getAttribute(Attributes.MAX_HEALTH);
        float healthMax = maxHealth != null ? (float) maxHealth.getValue() : 20.0f;
        int absorption = Mth.ceil(player.getAbsorptionAmount());
        int healthRows = Mth.ceil((healthMax + (float) absorption) / 2.0F / 10.0F);
        int rowHeight = Math.max(10 - (healthRows - 2), 3);

        random.setSeed((long) (tickCount * 312871L));
        int left = width / 2 - 91;
        int top = height - 39;
        int leftHeight = 39;
        leftHeight += healthRows * rowHeight;
        if (rowHeight != 10) {
            leftHeight += 10 - rowHeight;
        }

        int regen = -1;
        if (player.hasEffect(MobEffects.REGENERATION)) {
            regen = tickCount % Mth.ceil(healthMax + 5.0F);
        }

        int TOP = player.level().getLevelData().isHardcore() ? 9 : 0;
        int BACKGROUND = highlight ? 25 : 16;
        int margin = 34;
        float absorptionRemaining = (float) absorption;

        for (int i = Mth.ceil((healthMax + (float) absorption) / 2.0F) - 1; i >= 0; --i) {
            int row = Mth.ceil((float) (i + 1) / 10.0F) - 1;
            int x = left + i % 10 * 8;
            int y = top - row * rowHeight;
            if (health <= 4) {
                y += random.nextInt(2);
            }

            if (i == regen) {
                y -= 2;
            }

            stack.blit(EFFECT_HEART_MAG_DEFINE, x, y, BACKGROUND, TOP, 9, 9);
            if (highlight) {
                if (i * 2 + 1 < healthLast) {
                    stack.blit(EFFECT_HEART_MAG_DEFINE, x, y, margin, TOP, 9, 9);
                } else if (i * 2 + 1 == healthLast) {
                    stack.blit(EFFECT_HEART_MAG_DEFINE, x, y, margin + 9, TOP, 9, 9);
                }
            }

            if (absorptionRemaining > 0.0F) {
                if (absorptionRemaining == (float) absorption && (float) absorption % 2.0F == 1.0F) {
                    stack.blit(EFFECT_HEART_MAG_DEFINE, x, y, margin + 9, TOP, 9, 9);
                    --absorptionRemaining;
                } else {
                    stack.blit(EFFECT_HEART_MAG_DEFINE, x, y, margin, TOP, 9, 9);
                    absorptionRemaining -= 2.0F;
                }
            } else if (i * 2 + 1 < health) {
                stack.blit(EFFECT_HEART_MAG_DEFINE, x, y, margin, TOP, 9, 9);
            } else if (i * 2 + 1 == health) {
                stack.blit(EFFECT_HEART_MAG_DEFINE, x, y, margin + 9, TOP, 9, 9);
            }
        }
        stack.pose().popPose();
    }

    //电击
    @SubscribeEvent
    public static void onRenderGuiLayerStrike(RenderGuiLayerEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        if (player == null || !player.hasEffect((ModEffects.STRIKE))) {
            return;
        }
        if (player.isCreative() || player.isSpectator()) {
            return;
        }
        CustomHealthStrike(event);
    }

    private static void CustomHealthStrike(RenderGuiLayerEvent.Pre event) {
        Player player = Minecraft.getInstance().player;
        Minecraft mc = Minecraft.getInstance();
        GuiGraphics stack = event.getGuiGraphics();

        ResourceLocation EFFECT_HEART_STRIKE =
                ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "textures/gui/effect_heart_strike.png");

        int width = stack.guiWidth();
        int height = stack.guiHeight();
        stack.pose().pushPose();

        int health = Mth.ceil(player.getHealth());
        int tickCount = (int) (System.currentTimeMillis() / 50);

        boolean highlight =
                healthBlinkTime > (long) tickCount && (healthBlinkTime - (long) tickCount) / 3L % 2L == 1L;

        if (health < lastHealth && player.invulnerableTime > 0) {
            lastHealthTime = Util.getMillis();
            healthBlinkTime = (long) (tickCount + 20);
        } else if (health > lastHealth && player.invulnerableTime > 0) {
            lastHealthTime = Util.getMillis();
            healthBlinkTime = (long) (tickCount + 10);
        }

        if (Util.getMillis() - lastHealthTime > 1000L) {
            lastHealth = health;
            displayHealth = health;
            lastHealthTime = Util.getMillis();
        }

        lastHealth = health;
        int healthLast = displayHealth;
        AttributeInstance maxHealth = player.getAttribute(Attributes.MAX_HEALTH);
        float healthMax = maxHealth != null ? (float) maxHealth.getValue() : 20.0f;
        int absorption = Mth.ceil(player.getAbsorptionAmount());
        int healthRows = Mth.ceil((healthMax + (float) absorption) / 2.0F / 10.0F);
        int rowHeight = Math.max(10 - (healthRows - 2), 3);

        random.setSeed((long) (tickCount * 312871L));
        int left = width / 2 - 91;
        int top = height - 39;
        int leftHeight = 39;
        leftHeight += healthRows * rowHeight;
        if (rowHeight != 10) {
            leftHeight += 10 - rowHeight;
        }

        int regen = -1;
        if (player.hasEffect(MobEffects.REGENERATION)) {
            regen = tickCount % Mth.ceil(healthMax + 5.0F);
        }

        int TOP = player.level().getLevelData().isHardcore() ? 9 : 0;
        int BACKGROUND = highlight ? 25 : 16;
        int margin = 34;
        float absorptionRemaining = (float) absorption;

        for (int i = Mth.ceil((healthMax + (float) absorption) / 2.0F) - 1; i >= 0; --i) {
            int row = Mth.ceil((float) (i + 1) / 10.0F) - 1;
            int x = left + i % 10 * 8;
            int y = top - row * rowHeight;
            if (health <= 4) {
                y += random.nextInt(2);
            }

            if (i == regen) {
                y -= 2;
            }

            stack.blit(EFFECT_HEART_STRIKE, x, y, BACKGROUND, TOP, 9, 9);
            if (highlight) {
                if (i * 2 + 1 < healthLast) {
                    stack.blit(EFFECT_HEART_STRIKE, x, y, margin, TOP, 9, 9);
                } else if (i * 2 + 1 == healthLast) {
                    stack.blit(EFFECT_HEART_STRIKE, x, y, margin + 9, TOP, 9, 9);
                }
            }

            if (absorptionRemaining > 0.0F) {
                if (absorptionRemaining == (float) absorption && (float) absorption % 2.0F == 1.0F) {
                    stack.blit(EFFECT_HEART_STRIKE, x, y, margin + 9, TOP, 9, 9);
                    --absorptionRemaining;
                } else {
                    stack.blit(EFFECT_HEART_STRIKE, x, y, margin, TOP, 9, 9);
                    absorptionRemaining -= 2.0F;
                }
            } else if (i * 2 + 1 < health) {
                stack.blit(EFFECT_HEART_STRIKE, x, y, margin, TOP, 9, 9);
            } else if (i * 2 + 1 == health) {
                stack.blit(EFFECT_HEART_STRIKE, x, y, margin + 9, TOP, 9, 9);
            }
        }
        stack.pose().popPose();
    }
}
