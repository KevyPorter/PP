package com.kevyporter.pixelplus.stats;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kevyporter.pixelplus.api.PlanckeAPI;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Kevy on 3/12/2015.
 */
public class ARStats {
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

        int v4wins = 0;
        int v4kills = 0;
        int v2wins = 0;
        int v2kills = 0;
        int v1wins = 0;
        int v1kills = 0;

        try
        {
            v2kills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arena").getAsJsonObject().get("kills_2v2").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            v2wins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arena").getAsJsonObject().get("wins_2v2").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            v4kills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arena").getAsJsonObject().get("kills_4v4").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            v4wins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arena").getAsJsonObject().get("wins_4v4").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            v1wins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arena").getAsJsonObject().get("wins_1v1").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            v1kills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Arena").getAsJsonObject().get("kills_1v1").getAsInt();
        }
        catch (Exception e) {}

        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
        new FormattedMessage(name + "'s stats in Arena Brawl", EnumChatFormatting.GREEN).send();
        new FormattedMessage("     1v1", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + v1kills, EnumChatFormatting.GOLD).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + v1wins, EnumChatFormatting.GOLD)))).send(false);
        new FormattedMessage("     2v2", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + v2kills, EnumChatFormatting.GOLD).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + v2wins, EnumChatFormatting.GOLD)))).send(false);
        new FormattedMessage("     4v4", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + v4kills, EnumChatFormatting.GOLD).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + v4wins, EnumChatFormatting.GOLD)))).send(false);
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
    }
}
