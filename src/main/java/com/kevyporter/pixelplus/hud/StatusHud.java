package com.kevyporter.pixelplus.hud;

import com.kevyporter.pixelplus.PixelPlusMod;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Kevy on 3/12/2015.
 */
public class StatusHud {

    private static ResourceLocation inventoryResourceLocation = new ResourceLocation("textures/gui/container/inventory.png");

    public static float potionScale = 1.0F;

    private static Minecraft mc = Minecraft.getMinecraft();

    public static void render() {
        if (PixelPlusMod.getInstance().CONFIG.statushud_enabled) {
            Collection potionEffects = mc.thePlayer.getActivePotionEffects();
            Iterator it = potionEffects.iterator();

            int x = PixelPlusMod.getInstance().CONFIG.statushud_x;
            int y = PixelPlusMod.getInstance().CONFIG.statushud_y;

            x /= potionScale;
            y /= potionScale;
            GL11.glScalef(potionScale, potionScale, potionScale);

            int i = 0;
            while (it.hasNext()) {
                PotionEffect potionEffect = (PotionEffect) it.next();
                Potion potion = Potion.potionTypes[potionEffect.getPotionID()];
                Boolean isFromBeacon = potionEffect.getIsAmbient();

                if (!isFromBeacon) {
                    drawPotionIcon(x, y, potion);
                    drawPotionDuration(x + 10, y, potion, potionEffect);
                    y -= 10;
                    i++;
                }
            }

            GL11.glScalef(1f / potionScale, 1f / potionScale, 1f / potionScale);
        }
    }

    private static void drawPotionDuration(int x1, int y1, Potion potion, PotionEffect potionEffect) {
        String durationString = Potion.getDurationString(potionEffect);

        String potionAmp = "I";
        if (potionEffect.getAmplifier() == 1) {
            potionAmp = "II";
        } else if (potionEffect.getAmplifier() == 2) {
            potionAmp = "III";
        } else if (potionEffect.getAmplifier() == 3) {
            potionAmp = "IV";
        } else if (potionEffect.getAmplifier() == 4) {
            potionAmp = "V";
        } else if (potionEffect.getAmplifier() == 5) {
            potionAmp = "VI";
        } else if (potionEffect.getAmplifier() == 6) {
            potionAmp = "VII";
        } else if (potionEffect.getAmplifier() == 7) {
            potionAmp = "VIII";
        } else if (potionEffect.getAmplifier() == 8) {
            potionAmp = "IX";
        } else if (potionEffect.getAmplifier() == 9) {
            potionAmp = "X";
        } else if (potionEffect.getAmplifier() > 9) {
            potionAmp = "" + (potionEffect.getAmplifier() + 1);
        }

        mc.fontRendererObj.drawString(PixelPlusMod.getInstance().CONFIG.statushud_mcolor.substring(0, 2) + potionAmp + " " + PixelPlusMod.getInstance().CONFIG.statushud_vcolor.substring(0, 2) + durationString, x1, y1, 0xffffff);
    }

    private static void drawPotionIcon(int x1, int y1, Potion potion) {
        mc.getTextureManager().bindTexture(inventoryResourceLocation);

        if (potion.hasStatusIcon()) {
            int iconIndex = potion.getStatusIconIndex();
            int u = iconIndex % 8 * 18;
            int v = 198 + iconIndex / 8 * 18;
            int width = 18;
            int height = 18;
            float scaler = 0.5f;

            GL11.glColor4f(1f, 1f, 1f, 1f);

            renderCustomTexture(x1, y1, u, v, width, height, null, scaler);
        }
    }

    public static void renderCustomTexture(int x1, int y1, int u, int v, int width, int height, ResourceLocation resourceLocation, float scale) {
        x1 /= scale;
        y1 /= scale;

        GL11.glPushMatrix();
        GL11.glScalef(scale, scale, scale);

        if (resourceLocation != null)
            mc.getTextureManager().bindTexture(resourceLocation);

        mc.ingameGUI.drawTexturedModalRect(x1, y1, u, v, width, height);

        GL11.glPopMatrix();
    }

}
