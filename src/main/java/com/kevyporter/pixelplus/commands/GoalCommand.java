package com.kevyporter.pixelplus.commands;

import com.kevyporter.pixelplus.PixelPlusMod;
import com.kevyporter.pixelplus.goals.BlitzGoals;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevy on 9/12/2015.
 */
public class GoalCommand extends CommandBase {

    private boolean isOp(ICommandSender sender) {
        return (MinecraftServer.getServer().isSinglePlayer()) || (!(sender instanceof EntityPlayerMP)) || MinecraftServer.getServer().getConfigurationManager().canSendCommands(((EntityPlayerMP) sender).getGameProfile());
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public boolean canSenderUseCommand(ICommandSender sender) {
        return true;
    }

    public String getName() {
        return "Goal";
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/Goal <game> <type> <amount>";
    }

    public List getAliases() {
        List<String> aliases = new ArrayList<String>();
        aliases.add("Goal");
        aliases.add("goal");
        return aliases;
    }

    public void execute(ICommandSender sender, String[] args) {
        if(PixelPlusMod.getInstance().hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            try {
                if (args.length == 3) {
                    if (args[0].equalsIgnoreCase("bsg") || args[0].equalsIgnoreCase("blitz")) {
                        if (args[1].equalsIgnoreCase("kills")) {
                            Integer i = 0;
                            try {
                                i = Integer.parseInt(args[2]);
                            } catch (Exception ex) {
                                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Invalid number."));
                            }
                            if (i > 0) {
                                BlitzGoals.setGoal(BlitzGoals.BlitzGoalType.KILL, i);
                            } else {
                                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Invalid number."));
                            }
                        }
                        if (args[1].equalsIgnoreCase("wins")) {
                            Integer i = 0;
                            try {
                                i = Integer.parseInt(args[2]);
                            } catch (Exception ex) {
                                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Invalid number."));
                            }
                            if (i > 0) {
                                BlitzGoals.setGoal(BlitzGoals.BlitzGoalType.WIN, i);
                            } else {
                                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Invalid number."));
                            }
                        }
                    }
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("list")) {
                        BlitzGoals.listGoals();
                    }
                } else {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + getCommandUsage(sender)));
                }
            } catch (Exception e) {
                System.out.println("Error in GoalCommand.");
                e.printStackTrace();
            }
        }
    }
}