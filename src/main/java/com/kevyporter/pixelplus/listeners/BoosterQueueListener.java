package com.kevyporter.pixelplus.listeners;

import com.kevyporter.pixelplus.PixelPlusMod;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Kevy on 18/12/2015.
 */
public class BoosterQueueListener {

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent e) {
        if (PixelPlusMod.getInstance().hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            String f = e.message.getFormattedText();
            String u = e.message.getUnformattedText();
            if (u.startsWith("Quakecraft - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("Quakecraft - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("Arcade - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("Arcade - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("Blitz Survival Games - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("Blitz Survival Games - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("Walls - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("Walls - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("Mega Walls - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("Mega Walls - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("Paintball - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("Paintball - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("Arena Brawl - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("Arena Brawl - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("TNT Games - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("TNT Games - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("VampireZ - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("VampireZ - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("Cops and Crims - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("Cops and Crims - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("UHC Champions - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("UHC Champions - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("Warlords - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("Warlords - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("Turbo Kart Racers - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("Turbo Kart Racers - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("SkyWars - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("SkyWars - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
            if (u.startsWith("Crazy Walls - Triple Coins from ")) {
                e.setCanceled(true);
                String user = "";
                u = u.replace("Crazy Walls - Triple Coins from ", "");
                if (u.contains(",")) {
                    user = u.substring(0, u.indexOf(","));
                } else {
                    user = u;
                }
                new FormattedMessage(f).makeClickable(ClickEvent.Action.RUN_COMMAND, "/tip " + user, new FormattedMessage("Click to tip " + user, EnumChatFormatting.GRAY)).send(false);
            }
        }
    }
}
