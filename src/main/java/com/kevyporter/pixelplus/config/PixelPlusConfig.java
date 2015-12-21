package com.kevyporter.pixelplus.config;

import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Kevy on 8/12/2015.
 */
public class PixelPlusConfig {

    private Configuration config;

    public static final String PIXELPLUS_CATEGORY = "pixelplus";

    public boolean the_first_time;

    public boolean modlogo_enabled;
    public boolean modlogo_rainbow;

    public boolean infohud_enabled;
    public boolean infohud_left;
    public String infohud_mcolor;
    public String infohud_vcolor;
    public int infohud_x;
    public int infohud_y;
    public boolean infohud_showTime;
    public boolean infohud_showFPS;
    public boolean infohud_showPing;

    public boolean statushud_enabled;
    public String statushud_mcolor;
    public String statushud_vcolor;
    public int statushud_x;
    public int statushud_y;

    public boolean armorhud_enabled;
    public int armorhud_x;
    public int armorhud_y;

    public boolean dmghud_enabled;
    public String dmghud_mcolor;
    public String dmghud_vcolor;
    public int dmghud_x;
    public int dmghud_y;

    String[] colorValues = {EnumChatFormatting.AQUA + "Aqua", EnumChatFormatting.BLACK + "Black", EnumChatFormatting.BLUE + "Blue", EnumChatFormatting.DARK_AQUA + "Dark_Aqua", EnumChatFormatting.DARK_BLUE + "Dark_Blue", EnumChatFormatting.DARK_GRAY + "Dark_Gray", EnumChatFormatting.DARK_GREEN + "Dark_Green", EnumChatFormatting.DARK_PURPLE + "Dark_Purple", EnumChatFormatting.GOLD + "Gold", EnumChatFormatting.GRAY + "Gray", EnumChatFormatting.LIGHT_PURPLE + "Light_Purple", EnumChatFormatting.RED + "Red", EnumChatFormatting.WHITE + "White", EnumChatFormatting.YELLOW + "Yellow"};

    public PixelPlusConfig(File conf) {
        this.config = new Configuration(conf, "1");
        this.config.load();
    }

    public void syncConfig() {
        modlogo_enabled = this.config.get(PIXELPLUS_CATEGORY, "modlogo_enabled", true, "Show the mod logo").getBoolean(true);
        modlogo_rainbow = this.config.get(PIXELPLUS_CATEGORY, "modlogo_rainbow", true, "Mod logo will be animated").getBoolean(true);

        infohud_enabled = this.config.get(PIXELPLUS_CATEGORY, "infohud_enabled", true, "Show the InfoHud").getBoolean(true);
        infohud_left = this.config.get(PIXELPLUS_CATEGORY, "infohud_left", false, "InfoHud will be able to be set to the left side of the screen").getBoolean(false);
        infohud_mcolor = this.config.getString("infohud_mcolor", PIXELPLUS_CATEGORY, EnumChatFormatting.GOLD + "Gold", "Main color of InfoHud", colorValues);
        infohud_vcolor = this.config.getString("infohud_vcolor", PIXELPLUS_CATEGORY, EnumChatFormatting.YELLOW + "Yellow", "Value color of InfoHud", colorValues);
        infohud_x = this.config.get(PIXELPLUS_CATEGORY, "infohud_x", 0, "Where the InfoHud will be displayed").getInt();
        infohud_y = this.config.get(PIXELPLUS_CATEGORY, "infohud_y", 10, "Where the InfoHud will be displayed").getInt();
        infohud_showTime = this.config.get(PIXELPLUS_CATEGORY, "infohud_showTime", true, "Show the time in thee InfoHud").getBoolean(true);
        infohud_showFPS = this.config.get(PIXELPLUS_CATEGORY, "infohud_showFPS", true, "Show the FPS in the InfoHud").getBoolean(true);
        infohud_showPing = this.config.get(PIXELPLUS_CATEGORY, "infohud_showPing", true, "Show the ping in the InfoHud").getBoolean(true);

        statushud_enabled = this.config.get(PIXELPLUS_CATEGORY, "statushud_enabled", true, "Show the StatusHud").getBoolean(true);
        statushud_mcolor = this.config.getString("statushud_mcolor", PIXELPLUS_CATEGORY, EnumChatFormatting.GOLD + "Gold", "StatusHud main color", colorValues);
        statushud_vcolor = this.config.getString("statushud_vcolor", PIXELPLUS_CATEGORY, EnumChatFormatting.YELLOW + "Yellow", "StatusHud value color", colorValues);
        statushud_x = this.config.get(PIXELPLUS_CATEGORY, "statushud_x", 0, "Where the StatusHud will be displayed").getInt();
        statushud_y = this.config.get(PIXELPLUS_CATEGORY, "statushud_y", 50, "Where the StatusHud will be displayed").getInt();

        armorhud_enabled = this.config.get(PIXELPLUS_CATEGORY, "armorhud_enabled", true, "Show the ArmorHud").getBoolean(true);
        armorhud_x = this.config.get(PIXELPLUS_CATEGORY, "armorhud_x", 0, "Where the ArmorHud will be displayed").getInt();
        armorhud_y = this.config.get(PIXELPLUS_CATEGORY, "armorhud_y", 60, "Where the ArmorHud will be displayed").getInt();

        dmghud_enabled = this.config.get(PIXELPLUS_CATEGORY, "dmghud_enabled", true, "Show the DmgHud").getBoolean(true);
        dmghud_mcolor = this.config.getString("dmghud_mcolor", PIXELPLUS_CATEGORY, EnumChatFormatting.GOLD + "Gold", "The main color of the DmgHud", colorValues);
        dmghud_vcolor = this.config.getString("dmghud_vcolor", PIXELPLUS_CATEGORY, EnumChatFormatting.YELLOW + "Yellow", "The value color of the DmgHud", colorValues);
        dmghud_x = this.config.get(PIXELPLUS_CATEGORY, "dmghud_x", 0, "Where the DmgHud will be displayed").getInt();
        dmghud_y = this.config.get(PIXELPLUS_CATEGORY, "dmghud_y", 40, "Where the DmgHud will be displayed").getInt();

        if (this.config.hasChanged()) {
            this.config.save();
        }
    }

    public Configuration getConfig() {
        return config;
    }

}
