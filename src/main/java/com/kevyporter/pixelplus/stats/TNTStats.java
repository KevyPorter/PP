package com.kevyporter.pixelplus.stats;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kevyporter.pixelplus.api.PlanckeAPI;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Kevy on 3/12/2015.
 */
public class TNTStats {
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

        int twins = 0;
        int wwins = 0;
        int bwins = 0;
        int rwins = 0;
        int coins = 0;

        try
        {
            coins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TNTGames").getAsJsonObject().get("coins").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            rwins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TNTGames").getAsJsonObject().get("wins_tntrun").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            bwins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TNTGames").getAsJsonObject().get("wins_bowspleef").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            wwins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TNTGames").getAsJsonObject().get("wins_capture").getAsInt();
        }
        catch (Exception e) {}
        try
        {
            twins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TNTGames").getAsJsonObject().get("wins_tnttag").getAsInt();
        }
        catch (Exception e) {}

        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
        new FormattedMessage(name + "'s stats in TNTGames", EnumChatFormatting.GREEN).send();
        new FormattedMessage("     Coins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + coins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Bowspleef Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + bwins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     TNTRun Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + rwins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     TNTTag Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + twins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Wizards Wins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + wwins, EnumChatFormatting.GOLD)).send(false);
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
    }
}
