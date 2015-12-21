package com.kevyporter.pixelplus.hud;

import com.kevyporter.pixelplus.PixelPlusMod;
import com.kevyporter.pixelplus.util.UUIDHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kevy on 3/12/2015.
 */
public class InfoHud {

    private static String getFPS() {
        String fps = "0";
        try {
            fps = Minecraft.getMinecraft().debug.substring(0, Minecraft.getMinecraft().debug.indexOf(' '));
        } catch (Exception e) {
        }
        return fps;
    }

    private static String getTime() {
        return new SimpleDateFormat("h:mm a").format(Calendar.getInstance().getTime());
    }

    private static String getPing() {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        if (player == null) {
            return "" + Minecraft.getMinecraft().getCurrentServerData().pingToServer;
        }
        if(Minecraft.getMinecraft().getNetHandler().getPlayerInfo(UUID.fromString(UUIDHelper.getUUID())) != null) {
            return "" + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(UUID.fromString(UUIDHelper.getUUID())).getResponseTime();
        }
        return "" + Minecraft.getMinecraft().getCurrentServerData().pingToServer;
    }

    private static List<String> display = new ArrayList<String>();

    private static List getDisplay() {
        List<String> a = new ArrayList<String>();
        if (PixelPlusMod.getInstance().CONFIG.infohud_left) {
            if (PixelPlusMod.getInstance().CONFIG.infohud_showFPS) {
                a.add(PixelPlusMod.getInstance().CONFIG.infohud_vcolor.substring(0, 2) + getFPS() + " " + EnumChatFormatting.GRAY + EnumChatFormatting.BOLD + "<" + PixelPlusMod.getInstance().CONFIG.infohud_mcolor.substring(0, 2) + "FPS");
            }
            if (PixelPlusMod.getInstance().CONFIG.infohud_showPing) {
                a.add(PixelPlusMod.getInstance().CONFIG.infohud_vcolor.substring(0, 2) + getPing() + " " + EnumChatFormatting.GRAY + EnumChatFormatting.BOLD + "<" + PixelPlusMod.getInstance().CONFIG.infohud_mcolor.substring(0, 2) + "PING");
            }
            if (PixelPlusMod.getInstance().CONFIG.infohud_showTime) {
                a.add(PixelPlusMod.getInstance().CONFIG.infohud_vcolor.substring(0, 2) + getTime() + " " + EnumChatFormatting.GRAY + EnumChatFormatting.BOLD + "<" + PixelPlusMod.getInstance().CONFIG.infohud_mcolor.substring(0, 2) + "TIME");
            }
        } else {
            if (PixelPlusMod.getInstance().CONFIG.infohud_showFPS) {
                a.add(PixelPlusMod.getInstance().CONFIG.infohud_mcolor.substring(0, 2) + "FPS" + EnumChatFormatting.GRAY + EnumChatFormatting.BOLD + "> " + PixelPlusMod.getInstance().CONFIG.infohud_vcolor.substring(0, 2) + getFPS());
            }
            if (PixelPlusMod.getInstance().CONFIG.infohud_showPing) {
                a.add(PixelPlusMod.getInstance().CONFIG.infohud_mcolor.substring(0, 2) + "PING" + EnumChatFormatting.GRAY + EnumChatFormatting.BOLD + "> " + PixelPlusMod.getInstance().CONFIG.infohud_vcolor.substring(0, 2) + getPing());
            }
            if (PixelPlusMod.getInstance().CONFIG.infohud_showTime) {
                a.add(PixelPlusMod.getInstance().CONFIG.infohud_mcolor.substring(0, 2) + "TIME" + EnumChatFormatting.GRAY + EnumChatFormatting.BOLD + "> " + PixelPlusMod.getInstance().CONFIG.infohud_vcolor.substring(0, 2) + getTime());
            }
        }
        return a;
    }

    public static void onRender() {
        if (PixelPlusMod.getInstance().CONFIG.infohud_enabled) {
            display = getDisplay();
            int y = PixelPlusMod.getInstance().CONFIG.infohud_y;
            if (PixelPlusMod.getInstance().CONFIG.infohud_left) {
                for (int i = 0; i < display.size(); i++) {
                    if ((display.get(i) != null) && (!(display.get(i)).isEmpty())) {
                        Minecraft.getMinecraft().fontRendererObj.drawString(display.get(i), PixelPlusMod.getInstance().CONFIG.infohud_x - Minecraft.getMinecraft().fontRendererObj.getStringWidth(display.get(i)), y, 0xFFFFFF);
                        y += 10;
                    }
                }
            } else {
                for (int i = 0; i < display.size(); i++) {
                    if ((display.get(i) != null) && (!(display.get(i)).isEmpty())) {
                        Minecraft.getMinecraft().fontRendererObj.drawString(display.get(i), PixelPlusMod.getInstance().CONFIG.infohud_x, y, 0xFFFFFF);
                        y += 10;
                    }
                }
            }
        }
    }
}


