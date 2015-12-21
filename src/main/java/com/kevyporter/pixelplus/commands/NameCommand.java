package com.kevyporter.pixelplus.commands;

import com.kevyporter.pixelplus.PixelPlusMod;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;

/**
 * Created by Kevy on 20/11/2015.
 */
public class NameCommand extends CommandBase
{
    private boolean isOp(ICommandSender sender)
    {
        return (MinecraftServer.getServer().isSinglePlayer())
                || (!(sender instanceof EntityPlayerMP))
                || MinecraftServer.getServer().getConfigurationManager().canSendCommands(((EntityPlayerMP) sender).getGameProfile());
    }

    public String getName()
    {
        return "names";
    }

    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    public boolean canSenderUseCommand(ICommandSender sender)
    {
        return true;
    }

    public String getCommandUsage(ICommandSender sender)
    {
        return "/names <player>";
    }

    public List getAliases() {
        List<String> aliases = new ArrayList<String>();
        aliases.add("names");
        aliases.add("name");
        aliases.add("grab");
        return aliases;
    }

    public void execute(ICommandSender sender, String[] args) {
        if(PixelPlusMod.getInstance().hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            try {
                final ICommandSender cSender = sender;
                if (args.length == 0) {
                    cSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Usage: /names <playername>"));
                    cSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Example: /names Kevy"));
                } else if (args.length == 1) {
                    final String playername = args[0].toString();
                    if (playername.length() < 3) {
                        cSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Usage: /names <playername>"));
                        cSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Example: /names Kevy"));
                    } else {
                        new Thread() {
                            @Override
                            public void run() {
                                try {
                                    URL uuidgrabber = new URL("https://api.mojang.com/users/profiles/minecraft/" + playername);
                                    BufferedReader br1 = new BufferedReader(new InputStreamReader(uuidgrabber.openStream()));
                                    String uuidfromweb;
                                    if ((uuidfromweb = br1.readLine()) != null) {
                                        String uuid = uuidfromweb.substring(7, 39);
                                        URL namegrabber = new URL("https://api.mojang.com/user/profiles/" + uuid + "/names");
                                        BufferedReader br2 = new BufferedReader(new InputStreamReader(namegrabber.openStream()));
                                        String webnames;
                                        if ((webnames = br2.readLine()) != null) {
                                            if (webnames.substring(10, webnames.length() - 3 - playername.length()).length() <= 0) {
                                                cSender.addChatMessage(new ChatComponentText(""));
                                                cSender.addChatMessage(new ChatComponentText(StringUtils.center("" + EnumChatFormatting.LIGHT_PURPLE + EnumChatFormatting.BOLD + playername, 65)));
                                                cSender.addChatMessage(new ChatComponentText(""));
                                                cSender.addChatMessage(new ChatComponentText(StringUtils.center(EnumChatFormatting.YELLOW + "Player has never changed their name.", 65)));
                                                cSender.addChatMessage(new ChatComponentText(""));
                                            } else {
                                                webnames = webnames.replace("{", "").replace("}", "").replaceAll(",", ".").replace('"', ' ').replace(" ", "").replace("[", "").replace("]", "").replace(".c", "-c").replace(".", ",");
                                                String[] split = webnames.split(Pattern.quote(","));

                                                cSender.addChatMessage(new ChatComponentText(""));
                                                for (String s : split) {
                                                    if ((s.startsWith("name")) && (s.contains("changed"))) {
                                                        String[] names = s.split(Pattern.quote("-"));
                                                        String p1 = "";
                                                        String p2 = "";
                                                        for (String d : names) {
                                                            if (d.startsWith("name")) {
                                                                p1 = "    " + EnumChatFormatting.GOLD + "- " + EnumChatFormatting.GREEN + d.replace("name:", "") + " ";
                                                            }
                                                            if (d.startsWith("changedToAt")) {
                                                                long unixSeconds = Long.parseLong(d.replace("changedToAt:", ""));
                                                                Date date = new Date(unixSeconds);
                                                                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                                                                sdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
                                                                String formattedDate = sdf.format(date);
                                                                p2 = EnumChatFormatting.GRAY + "(Changed on " + formattedDate + ")";
                                                            }
                                                        }
                                                        cSender.addChatMessage(new ChatComponentText("" + p1 + p2));
                                                    } else if ((s.startsWith("name")) && (!s.contains("changed"))) {
                                                        cSender.addChatMessage(new ChatComponentText(StringUtils.center("" + EnumChatFormatting.LIGHT_PURPLE + EnumChatFormatting.BOLD + s.replace("name:", ""), 65)));
                                                        cSender.addChatMessage(new ChatComponentText(""));
                                                    }
                                                }
                                                cSender.addChatMessage(new ChatComponentText(""));
                                            }
                                        } else {
                                            cSender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "ERROR: Could not find player '" + playername + "'."));
                                            cSender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "This person changed their name or never existed."));
                                        }
                                        br2.close();
                                    } else {
                                        cSender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "ERROR: Could not find player '" + playername + "'."));
                                        cSender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "This person changed their name or never existed."));
                                    }
                                    br1.close();
                                } catch (Throwable e) {
                                    e.printStackTrace();
                                }
                            }

                            ;
                        }.start();
                    }
                } else if (args.length > 1) {
                    cSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Usage: /names <playername>"));
                    cSender.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Example: /names Kevy"));
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}