package com.kevyporter.pixelplus;

import com.kevyporter.pixelplus.commands.*;
import com.kevyporter.pixelplus.events.HypixelDetector;
import com.kevyporter.pixelplus.goals.BlitzGoals;
import com.kevyporter.pixelplus.hud.ArmorHud;
import com.kevyporter.pixelplus.hud.DmgHud;
import com.kevyporter.pixelplus.hud.InfoHud;
import com.kevyporter.pixelplus.hud.StatusHud;
import com.kevyporter.pixelplus.listeners.BoosterQueueListener;
import com.kevyporter.pixelplus.config.PPConfigGui;
import com.kevyporter.pixelplus.config.PixelPlusConfig;
import com.kevyporter.pixelplus.listeners.PPAFKListener;
import com.kevyporter.pixelplus.listeners.ToggleChatListener;
import com.kevyporter.pixelplus.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by PixelModders on 12/08/2015.
 */
@Mod(
        modid = PixelPlusMod.MODID,
        name = PixelPlusMod.NAME,
        version = PixelPlusMod.VERSION,
        guiFactory = "com.kevyporter.pixelplus.config.PPGuiFactory"
)
public class PixelPlusMod {

    public static final String MODID = "pixelplus";
    public static final String NAME = "PixelPlus";
    public static final String VERSION = "1.0";

    public PixelPlusConfig CONFIG;

    private static PixelPlusMod instance;

    private String PP_KEY_CAT = "Pixel+ Keys";

    public KeyBinding configKey;

    public static PixelPlusMod getInstance() {
        return instance;
    }

    public HypixelDetector hypixelDetector;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        instance = this;
        this.CONFIG = new PixelPlusConfig(e.getSuggestedConfigurationFile());
        this.CONFIG.syncConfig();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);

        MinecraftForge.EVENT_BUS.register(new HypixelDetector());
        MinecraftForge.EVENT_BUS.register(new PPAFKListener());
        MinecraftForge.EVENT_BUS.register(new DmgHud());
        MinecraftForge.EVENT_BUS.register(new BlitzGoals());
        MinecraftForge.EVENT_BUS.register(new BoosterQueueListener());
        MinecraftForge.EVENT_BUS.register(new ToggleChatListener());

        ClientCommandHandler.instance.registerCommand(new CheckUpdateCommand());
        ClientCommandHandler.instance.registerCommand(new GetStatsCommand());
        ClientCommandHandler.instance.registerCommand(new NameCommand());
        ClientCommandHandler.instance.registerCommand(new PPAFKCommand());
        ClientCommandHandler.instance.registerCommand(new PPStatsCommand());
        ClientCommandHandler.instance.registerCommand(new GoalCommand());
        ClientCommandHandler.instance.registerCommand(new ToggleChatCommand());
        ClientCommandHandler.instance.registerCommand(new PPHelpCommand());

        this.hypixelDetector = new HypixelDetector();

        this.configKey = new KeyBinding("Open Config", Keyboard.KEY_RSHIFT, PP_KEY_CAT);
        ClientRegistry.registerKeyBinding(this.configKey);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        Util.getInstance().admins = new ArrayList<String>();
        String[] a = Util.getInstance().getAdmins().split(",");
        for(int i = 0; i < a.length; i++) {
            Util.getInstance().admins.add(a[i]);
            System.out.println("Adding " + a[i] + " to admins.");
        }
    }

    @SubscribeEvent
    public void onChatEvent(ClientChatReceivedEvent e) {
        if(hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            String f = e.message.getFormattedText();
            String u = e.message.getUnformattedText();
            if (u.trim().endsWith(" joined.") || u.trim().endsWith(" left.")) {
                String user = u.substring(0, u.indexOf(" "));
                if (Util.getInstance().admins.contains(user.trim())) {
                    e.setCanceled(true);
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "[" + EnumChatFormatting.AQUA + "P" + EnumChatFormatting.DARK_AQUA + "+ " + EnumChatFormatting.RED + "Admin" + EnumChatFormatting.GRAY + "] " + f));
                }
            }
            if (u.trim().startsWith("[MVP+] ") || u.trim().startsWith("[VIP+] ")) {
                String user = "";
                u = u.replace("[MVP+] ", "").replace("[VIP+] ", "");
                user = u.substring(0, u.indexOf(" "));
                if (user.contains(":")) {
                    user = user.replace(":", "");
                }
                if (Util.getInstance().admins.contains(user.trim())) {
                    e.setCanceled(true);
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "[" + EnumChatFormatting.AQUA + "P" + EnumChatFormatting.DARK_AQUA + "+ " + EnumChatFormatting.RED + "Admin" + EnumChatFormatting.GRAY + "] " + f));
                }
            }
        }
    }

    private String str = "" + EnumChatFormatting.AQUA + EnumChatFormatting.BOLD + "Pixel";
    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent e) {
        try {
            if(hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
                if (Minecraft.getMinecraft().inGameHasFocus) {
                    if (PixelPlusMod.getInstance().CONFIG.modlogo_enabled) {
                        if (PixelPlusMod.getInstance().CONFIG.modlogo_rainbow) {
                            FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
                            fr.drawString(str, 0, 0, 0xFFFFFF);
                            fr.drawString(EnumChatFormatting.GOLD + "v" + VERSION, 1 + fr.getStringWidth(str + " "), 1, 0xFFFFFF);
                        } else {
                            FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
                            fr.drawString("" + EnumChatFormatting.AQUA + EnumChatFormatting.BOLD + "Pixel" + EnumChatFormatting.DARK_AQUA + EnumChatFormatting.BOLD + "+ " + EnumChatFormatting.DARK_GREEN + "v" + VERSION, 1, 1, 0xFFFFFF);
                        }
                    }
                }
                if (Minecraft.getMinecraft().inGameHasFocus) {
                    DmgHud.onRender();
                    ArmorHud.render();
                    InfoHud.onRender();
                    StatusHud.render();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int ticks = 0;
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent e) {
        if(hypixelDetector.isHypixelNetwork || Minecraft.getMinecraft().getCurrentServerData() == null) {
            if (Minecraft.getMinecraft().inGameHasFocus) {
                if (ticks == 0) {
                    Random r = new Random();
                    String[] a = {
                            "" + EnumChatFormatting.RED + EnumChatFormatting.BOLD + "+",
                            "" + EnumChatFormatting.GOLD + EnumChatFormatting.BOLD + "+",
                            "" + EnumChatFormatting.YELLOW + EnumChatFormatting.BOLD + "+",
                            "" + EnumChatFormatting.GREEN + EnumChatFormatting.BOLD + "+",
                            "" + EnumChatFormatting.DARK_AQUA + EnumChatFormatting.BOLD + "+",
                            "" + EnumChatFormatting.BLUE + EnumChatFormatting.BOLD + "+",
                            "" + EnumChatFormatting.LIGHT_PURPLE + EnumChatFormatting.BOLD + "+",
                    };
                    str = "" + EnumChatFormatting.AQUA + EnumChatFormatting.BOLD + "Pixel" + a[r.nextInt(a.length)];
                    ticks = 5;
                } else {
                    ticks--;
                }
            }
        }
    }

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent e) {
        try {
            this.hypixelDetector.check();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SubscribeEvent
    public void keyPress(InputEvent.KeyInputEvent e) {
        if(this.configKey.isPressed()) {
            FMLClientHandler.instance().getClient().displayGuiScreen(new PPConfigGui(null));
        }
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e) {
        try {
            if(e.modID.equals(MODID)){
                this.CONFIG.syncConfig();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}

