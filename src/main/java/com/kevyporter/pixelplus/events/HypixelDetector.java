package com.kevyporter.pixelplus.events;

import com.kevyporter.pixelplus.PixelPlusMod;
import com.kevyporter.pixelplus.updater.PixelUpdater;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

/**
 * Created by Kevy on 12/08/2015.
 */
public class HypixelDetector {

    public static boolean isHypixelNetwork;

    private boolean sentWelcomeMessage = false;

    private static final String HYPIXEL_DOMAIN = "hypixel.net";
    private static final String HYPIXEL_MOTD = "Hypixel Network";
    private static final String HYPIXEL_NAME = "hypixel";

    public void check() {
        if (FMLClientHandler.instance().getClient().getCurrentServerData() == null) {
            if (isHypixelNetwork) {
                isHypixelNetwork = false;
            }
            return;
        }
        ServerData data = FMLClientHandler.instance().getClient().getCurrentServerData();
        String ip = data.serverIP;
        String motd = data.serverMOTD;
        String name = data.serverName;
        if (!isHypixelNetwork && (ip.toLowerCase().endsWith(HYPIXEL_DOMAIN.toLowerCase()) || motd.toLowerCase().contains(HYPIXEL_MOTD.toLowerCase()) || name.equalsIgnoreCase(HYPIXEL_NAME))) {
            isHypixelNetwork = true;
        } else if (isHypixelNetwork && !(ip.toLowerCase().endsWith(HYPIXEL_DOMAIN.toLowerCase()) || motd.toLowerCase().contains(HYPIXEL_MOTD.toLowerCase()) || name.equalsIgnoreCase(HYPIXEL_NAME))) {
            isHypixelNetwork = false;
        }
    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent e) {
        if (isHypixelNetwork) {
            if (!sentWelcomeMessage) {
                sentWelcomeMessage = true;
                new Thread() {
                    @Override
                    public void run() {
                        PixelUpdater.checkForUpdate();
                        welcomeMessage();
                    }

                    ;
                }.start();
            }
        }
    }

    private void welcomeMessage() {
        // Hello {PLAYER}! You are using Pixel+ v{VERSION}.
        new FormattedMessage("Hello ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("! You are using ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("Pixel", EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("+ ", EnumChatFormatting.DARK_AQUA).appendMessage(new FormattedMessage("v" + PixelPlusMod.VERSION, EnumChatFormatting.GOLD).appendMessage(new FormattedMessage(".", EnumChatFormatting.GREEN))))))).send(false);
        if (PixelUpdater.isUpdate) {
            // The version of Pixel+ you are currently using is out of date. Please update by going to {WEBSITE}.
            new FormattedMessage("You are using an outdated version of ", EnumChatFormatting.RED).appendMessage(new FormattedMessage("Pixel", EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("+", EnumChatFormatting.DARK_AQUA).appendMessage(new FormattedMessage(".", EnumChatFormatting.RED)))).send(false);
            new FormattedMessage("Click Here", EnumChatFormatting.GOLD).addFormatting(EnumChatFormatting.BOLD).makeClickable(ClickEvent.Action.OPEN_URL, "http://kevyporter.github.io/PixelPlus/download.html", new FormattedMessage("Download Link", EnumChatFormatting.GRAY)).appendMessage(new FormattedMessage(" to download the latest version.", EnumChatFormatting.RED)).send(false);
        } else {
            // You are using the latest version of the Pixel+ mod.
            new FormattedMessage("You are using the latest version of the ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("Pixel", EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("+ ", EnumChatFormatting.DARK_AQUA).appendMessage(new FormattedMessage("mod.", EnumChatFormatting.GREEN)))).send(false);
        }
        // Use '/pphelp' to view a list of commands.
        new FormattedMessage("Use ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("'/pphelp' ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("to view a list of commands.", EnumChatFormatting.GREEN))).send(false);
        // Press {CONFIG_KEY} to open the config menu.
        new FormattedMessage("Press ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(Keyboard.getKeyName(PixelPlusMod.getInstance().configKey.getKeyCode()) + " ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("to open the config menu.", EnumChatFormatting.GREEN))).send(false);
    }
}
