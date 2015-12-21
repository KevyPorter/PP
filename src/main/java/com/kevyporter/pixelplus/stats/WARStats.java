package com.kevyporter.pixelplus.stats;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kevyporter.pixelplus.api.PlanckeAPI;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Kevy on 3/12/2015.
 */
public class WARStats {
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
        int repair = 0;
        int domwins = 0;
        int ctfwins = 0;
        int assists = 0;
        int kills = 0;

        try
        {
            coins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Battleground").getAsJsonObject().get("coins").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            kills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Battleground").getAsJsonObject().get("kills").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            assists = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Battleground").getAsJsonObject().get("assists").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            ctfwins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Battleground").getAsJsonObject().get("wins_capturetheflag").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            domwins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Battleground").getAsJsonObject().get("wins_domination").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            repair = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("Battleground").getAsJsonObject().get("repaired").getAsInt();
        }
        catch (Exception e) {}

        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
        new FormattedMessage(name + "'s stats in Warlords", EnumChatFormatting.GREEN).send();
        new FormattedMessage("     Coins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + coins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + kills, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Assists: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + assists, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     CTF Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + ctfwins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     DOM Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + domwins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Weapons Repaired: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + repair, EnumChatFormatting.GOLD)).send(false);
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
    }
}
