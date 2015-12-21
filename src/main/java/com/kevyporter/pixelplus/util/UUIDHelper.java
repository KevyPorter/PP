package com.kevyporter.pixelplus.util;

import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;
import net.minecraft.client.Minecraft;

/**
 * Created by Kevy on 18/12/2015.
 */
public class UUIDHelper {
    static int counter;

    private UUIDHelper() {}

    public static String getUsernameFormUUID(String uuid) {
            return Minecraft.getMinecraft().getSessionService().fillProfileProperties(new GameProfile(UUIDTypeAdapter.fromString(uuid), (String)null), false).getName();
    }

    public static String getUUID() {
        return Minecraft.getMinecraft().thePlayer.getGameProfile().getId().toString();
    }
}
