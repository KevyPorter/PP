package com.kevyporter.pixelplus.commands;

import com.kevyporter.pixelplus.PixelPlusMod;
import com.kevyporter.pixelplus.stats.*;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevy on 20/11/2015.
 */
public class GetStatsCommand extends CommandBase {

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
        return "GetStats";
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/GetStats";
    }

    public List getAliases() {
        List<String> aliases = new ArrayList<String>();
        aliases.add("GetStats");
        aliases.add("getstats");
        return aliases;
    }

    public void execute(ICommandSender sender, final String[] args) {
        if (PixelPlusMod.getInstance().hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            try {
                if (args.length == 2) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("BSG")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    BSGStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("UHC")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    UHCStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("MW")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    MWStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("W")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    WStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("AR")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    ARStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("AC")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    ACStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("PB")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    PBStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("CAC")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    CACStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("TNT")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    TNTStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("VZ")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    VZStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("Q")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    QStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("WAR")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    WARStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("SW")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    SWStats.display(args[1]);
                                }
                            }.start();
                        } else if (args[0].equalsIgnoreCase("CW")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    CWStats.display(args[1]);
                                }
                            }.start();
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error in GetStatsCommand.");
                e.printStackTrace();
            }
        }
    }
}