package com.kevyporter.pixelplus.listeners;

import com.kevyporter.pixelplus.PixelPlusMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Kevy on 18/12/2015.
 */
public class ToggleChatListener {
    public static Boolean guildChat = true;
    public static Boolean partyChat = true;
    public static Boolean pmsChat = true;
    public static Boolean shoutsChat = true;

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent e) {
        if(PixelPlusMod.getInstance().hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            String msg = e.message.getUnformattedText();
            if (!partyChat) {
                if (msg.startsWith("Party >")) {
                    e.setCanceled(true);
                }
            }
            if (!guildChat) {
                if (msg.startsWith("Guild >")) {
                    e.setCanceled(true);
                }
            }
            if (!pmsChat) {
                if (msg.startsWith("From")) {
                    e.setCanceled(true);
                }
            }
            if (!shoutsChat) {
                if (msg.startsWith("[SHOUT]")) {
                    e.setCanceled(true);
                }
            }
        }
    }
}
