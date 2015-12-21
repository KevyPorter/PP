package com.kevyporter.pixelplus.commands;

import com.kevyporter.pixelplus.PixelPlusMod;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevy on 21/12/2015.
 */
public class PPHelpCommand extends CommandBase {

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
        return "PPHelp";
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/PPHelp";
    }

    public List getAliases() {
        List<String> aliases = new ArrayList<String>();
        aliases.add("PPHelp");
        aliases.add("pphelp");
        return aliases;
    }

    public void execute(ICommandSender sender, String[] args) {
        if(PixelPlusMod.getInstance().hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            try {
                new FormattedMessage((EnumChatFormatting.RED + "    - " + EnumChatFormatting.AQUA + "Pixel" + EnumChatFormatting.DARK_AQUA + "+ " + EnumChatFormatting.GOLD + "Help " + EnumChatFormatting.RED + "-    ")).send(false);
                new FormattedMessage(" - /CheckUpdate: Checks for an update.", EnumChatFormatting.GREEN).send(false);
                new FormattedMessage(" - /Goal <game> <type> <amount>: Sets a goal for the <amount> of <type> in that <game>. (Currently only blitz)", EnumChatFormatting.GREEN).send(false);
                new FormattedMessage(" - /Names <player>: Views a player's previous names.", EnumChatFormatting.GREEN).send(false);
                new FormattedMessage(" - /PPAFK: Sets you to afk, use the command again to return from afk mode.", EnumChatFormatting.GREEN).send(false);
                new FormattedMessage(" - /PPStats: Displays the stats for the user in that gamemode.", EnumChatFormatting.GREEN).send(false);
                new FormattedMessage(" - /ToggleChat: Toggles specific chat lines off.", EnumChatFormatting.GREEN).send(false);
                new FormattedMessage(" - /PPHelp: Prints this help message.", EnumChatFormatting.GREEN).send(false);
                new FormattedMessage(" - Press" + Keyboard.getKeyName(PixelPlusMod.getInstance().configKey.getKeyCode()) + ": Press to open the config.", EnumChatFormatting.GREEN).send(false);
            } catch (Exception e) {
                System.out.println("Error in PPHelpCommand.");
                e.printStackTrace();
            }
        }
    }
}