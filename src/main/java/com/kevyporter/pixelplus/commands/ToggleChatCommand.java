package com.kevyporter.pixelplus.commands;

import com.kevyporter.pixelplus.PixelPlusMod;
import com.kevyporter.pixelplus.listeners.ToggleChatListener;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevy on 18/12/2015.
 */
public class ToggleChatCommand extends CommandBase {
    private boolean isOp(ICommandSender sender) {
        return (MinecraftServer.getServer().isSinglePlayer()) || (!(sender instanceof EntityPlayerMP)) || MinecraftServer.getServer().getConfigurationManager().canSendCommands(((EntityPlayerMP) sender).getGameProfile());
    }

    public String getName() {
        return "togglechat";
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public boolean canSenderUseCommand(ICommandSender sender) {
        return true;
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/togglechat <main, party, guild, pms, shouts>";
    }

    public List addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        List<String> tab = new ArrayList();
        tab.add("main");
        tab.add("party");
        tab.add("guild");
        tab.add("pms");
        tab.add("shouts");
        return tab;
    }

    public void execute(ICommandSender sender, String[] args) {
        if(PixelPlusMod.getInstance().hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            try {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("main")) {
                        Minecraft.getMinecraft().thePlayer.sendChatMessage("/togglechat");
                    } else if (args[0].equalsIgnoreCase("guild")) {
                        if (ToggleChatListener.guildChat) {
                            ToggleChatListener.guildChat = false;
                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "You will no longer see guild chat!"));
                        } else {
                            ToggleChatListener.guildChat = true;
                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "You will now see guild chat!"));
                        }
                    } else if (args[0].equalsIgnoreCase("party")) {
                        if (ToggleChatListener.partyChat) {
                            ToggleChatListener.partyChat = false;
                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "You will no longer see party chat!"));
                        } else {
                            ToggleChatListener.partyChat = true;
                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "You will now see party chat!"));
                        }
                    } else if (args[0].equalsIgnoreCase("pms")) {
                        if (ToggleChatListener.pmsChat) {
                            ToggleChatListener.pmsChat = false;
                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "You will no longer see PMs!"));
                        } else {
                            ToggleChatListener.pmsChat = true;
                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "You will now see PMs!"));
                        }
                    } else if (args[0].equalsIgnoreCase("shouts")) {
                        if (ToggleChatListener.pmsChat) {
                            ToggleChatListener.pmsChat = false;
                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "You will no longer see Shouts!"));
                        } else {
                            ToggleChatListener.pmsChat = true;
                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "You will now see Shouts!"));
                        }
                    }
                } else {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Usage: " + getCommandUsage(sender)));
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
