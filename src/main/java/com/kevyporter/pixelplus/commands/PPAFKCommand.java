package com.kevyporter.pixelplus.commands;

import com.kevyporter.pixelplus.PixelPlusMod;
import com.kevyporter.pixelplus.listeners.PPAFKListener;
import com.kevyporter.pixelplus.util.FormattedMessage;
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
 * Created by Kevy on 20/11/2015.
 */
public class PPAFKCommand extends CommandBase {

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
        return "PPAFK";
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/PPAFK";
    }

    public List getAliases() {
        List<String> aliases = new ArrayList<String>();
        aliases.add("PPAFK");
        aliases.add("ppafk");
        return aliases;
    }

    public void execute(ICommandSender sender, String[] args) {
        if(PixelPlusMod.getInstance().hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            try {
                if (PPAFKListener.isAFK) {
                    PPAFKListener.isAFK = false;
                    new FormattedMessage("No longer AFK!", EnumChatFormatting.BLUE).send(true);
                    for (int i = 0; i < PPAFKListener.awayMessages.size(); i++) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(PPAFKListener.awayMessages.get(i)));
                    }
                    PPAFKListener.awayMessages.clear();
                } else {
                    PPAFKListener.isAFK = true;
                    new FormattedMessage("You are now AFK!", EnumChatFormatting.BLUE).send(true);
                }
            } catch (Exception e) {
                System.out.println("Error in PPAFKCommand.");
                e.printStackTrace();
            }
        }
    }
}