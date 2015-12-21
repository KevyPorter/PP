package com.kevyporter.pixelplus.commands;

import com.kevyporter.pixelplus.PixelPlusMod;
import com.kevyporter.pixelplus.updater.PixelUpdater;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.event.ClickEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevy on 3/12/2015.
 */
public class CheckUpdateCommand extends CommandBase {

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
        return "CheckUpdate";
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/CheckUpdate";
    }

    public List getAliases() {
        List<String> aliases = new ArrayList<String>();
        aliases.add("CheckUpdate");
        aliases.add("checkupdate");
        return aliases;
    }

    public void execute(ICommandSender sender, String[] args) {
        if(PixelPlusMod.getInstance().hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            try {
                new Thread() {
                    @Override
                    public void run() {
                        PixelUpdater.checkForUpdate();
                    }

                    ;
                }.start();
                if (PixelUpdater.isUpdate) {
                    new FormattedMessage("You are using an outdated version of ", EnumChatFormatting.RED).appendMessage(new FormattedMessage("Pixel", EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("+", EnumChatFormatting.DARK_AQUA).appendMessage(new FormattedMessage(".", EnumChatFormatting.RED)))).send(false);
                    new FormattedMessage("Click Here", EnumChatFormatting.GOLD).addFormatting(EnumChatFormatting.BOLD).makeClickable(ClickEvent.Action.OPEN_URL, "http://kevyporter.github.io/PixelPlus/download.html", new FormattedMessage("Download Link", EnumChatFormatting.GRAY)).appendMessage(new FormattedMessage(" to download the latest version.", EnumChatFormatting.RED)).send(false);
                } else {
                    new FormattedMessage("You are using the latest version of the ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("Pixel", EnumChatFormatting.AQUA).appendMessage(new FormattedMessage("+ ", EnumChatFormatting.DARK_AQUA).appendMessage(new FormattedMessage("mod.", EnumChatFormatting.GREEN)))).send(false);
                }
            } catch (Exception e) {
                System.out.println("Error in CheckUpdateCommand.");
                e.printStackTrace();
            }
        }
    }
}