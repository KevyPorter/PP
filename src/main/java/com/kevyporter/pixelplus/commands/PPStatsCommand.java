package com.kevyporter.pixelplus.commands;

import com.kevyporter.pixelplus.PixelPlusMod;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.event.ClickEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevy on 3/12/2015.
 */
public class PPStatsCommand extends CommandBase {

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
        return "PPStats";
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/PPStats <name>";
    }

    public List getAliases() {
        List<String> aliases = new ArrayList<String>();
        aliases.add("PPStats");
        aliases.add("ppstats");
        return aliases;
    }

    public void execute(ICommandSender sender, String[] args) {
        if (PixelPlusMod.getInstance().hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            try {
                if (args.length == 1) {
                    new FormattedMessage(args[0] + "'s Stats", EnumChatFormatting.GREEN).send(true);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("Blitz Survival Games: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats bsg " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in Blitz Survival Games.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("UHC Champions: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats uhc " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in UHC Champions.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("Mega Walls: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats mw " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in Mega Walls.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("Walls: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats w " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in Walls.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("Arena: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats ar " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in Arena.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("Arcade: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats ac " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in Arcade.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("Paintball: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats pb " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in Paintball.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("Cops and Crims: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats cac " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in Cops and Crims.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("TNTGames: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats tnt " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in TNTGames.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("VampireZ: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats vz " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in VampireZ.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("Quake: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats q " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in Quake.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("Warlords: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats war " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in Warlords.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("SkyWars: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats sw " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in SkyWars.", EnumChatFormatting.GRAY)))))).send(false);
                    new FormattedMessage("    - ", EnumChatFormatting.GOLD).appendMessage(new FormattedMessage("Crazy Walls: ", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("(Click to view)", EnumChatFormatting.GRAY).addFormatting(EnumChatFormatting.ITALIC).makeClickable(ClickEvent.Action.RUN_COMMAND, "/getstats cw " + args[0], new FormattedMessage("Click to view ", EnumChatFormatting.GRAY).appendMessage(new FormattedMessage(args[0], EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("'s stats in Crazy Walls.", EnumChatFormatting.GRAY)))))).send(false);
                } else {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + getCommandUsage(sender)));
                }
            } catch (Exception e) {
                System.out.println("Error in PPStatsCommand.");
                e.printStackTrace();
            }
        }
    }
}