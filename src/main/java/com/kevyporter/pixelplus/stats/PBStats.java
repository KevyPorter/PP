package com.kevyporter.pixelplus.stats;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kevyporter.pixelplus.api.PlanckeAPI;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Kevy on 3/12/2015.
 */
public class PBStats {
    public static void display(String name) {
        JsonObject statistics = new JsonObject();
        JsonParser parser = new JsonParser();
        String json = PlanckeAPI.getPlayer(name);
        boolean hidden = false;
        if(json.contains("Player is hidden!")) {
            hidden = true;
        }
        if(hidden) {
            new FormattedMessage("Player is hidden!", EnumChatFormatting.RED).send(true);
            return;
        }
        statistics = (JsonObject)parser.parse(json);

        int coins = 0;
        int kills = 0;
        int wins = 0;

        try
        {
            coins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Paintball").getAsJsonObject().get("coins").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            kills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Paintball").getAsJsonObject().get("kills").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            wins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Paintball").getAsJsonObject().get("wins").getAsInt();
        }
        catch (Exception e) {}

        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
        new FormattedMessage(name + "'s stats in Paintball", EnumChatFormatting.GREEN).send();
        new FormattedMessage("Coins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + coins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + kills, EnumChatFormatting.GOLD)).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN)).appendMessage(new FormattedMessage("" + wins, EnumChatFormatting.GOLD)).send(false);
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
    }
}
