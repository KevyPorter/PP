package com.kevyporter.pixelplus.listeners;

import com.kevyporter.pixelplus.PixelPlusMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevy on 3/12/2015.
 */
public class PPAFKListener {

    public static boolean isAFK = false;
    public static List<String> awayMessages = new ArrayList<String>();

    private String afkReply = "Currently AFK!, I will message you later.";

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent e) {
        if (PixelPlusMod.getInstance().hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            if (isAFK) {
                if (e.message.getUnformattedText().startsWith("From ")) {
                    awayMessages.add(e.message.getFormattedText());
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/r " + afkReply);
                }
            }
        }
    }

}
