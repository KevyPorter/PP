package com.kevyporter.pixelplus.config;

import com.kevyporter.pixelplus.PixelPlusMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevy on 8/12/2015.
 */
public class PPConfigGui extends GuiConfig {

    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        Configuration configFile = PixelPlusMod.getInstance().CONFIG.getConfig();
        list.addAll(new ConfigElement(configFile.getCategory(PixelPlusConfig.PIXELPLUS_CATEGORY)).getChildElements());
        return list;
    }

    public PPConfigGui(GuiScreen parent) {
        super(parent, getConfigElements(), PixelPlusMod.MODID, false, false, "Pixel+ Config");
    }

}
