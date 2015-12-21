package com.kevyporter.pixelplus.stats;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kevyporter.pixelplus.api.PlanckeAPI;
import com.kevyporter.pixelplus.util.FormattedMessage;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Kevy on 3/12/2015.
 */
public class CWStats {
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
        int solo_normal_kills = 0;
        int solo_lucky_kills = 0;
        int team_normal_kills = 0;
        int team_lucky_kills = 0;
        int solo_normal_wins = 0;
        int solo_lucky_wins = 0;
        int team_normal_wins = 0;
        int team_lucky_wins = 0;

        try {
            coins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TrueCombat").getAsJsonObject().get("coins").getAsInt();
        } catch (Exception e) {}
        try {
            solo_normal_kills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TrueCombat").getAsJsonObject().get("crazywalls_kills_solo").getAsInt();
        } catch (Exception e) {}
        try {
            solo_lucky_kills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TrueCombat").getAsJsonObject().get("crazywalls_kills_solo_chaos").getAsInt();
        } catch (Exception e) {}
        try {
            team_normal_kills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TrueCombat").getAsJsonObject().get("crazywalls_kills_team").getAsInt();
        } catch (Exception e) {}
        try {
            team_lucky_kills = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TrueCombat").getAsJsonObject().get("crazywalls_kills_team_chaos").getAsInt();
        } catch (Exception e) {}
        try {
            solo_normal_wins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TrueCombat").getAsJsonObject().get("crazywalls_wins_solo").getAsInt();
        } catch (Exception e) {}
        try {
            solo_lucky_wins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TrueCombat").getAsJsonObject().get("crazywalls_wins_solo_chaos").getAsInt();
        } catch (Exception e) {}
        try {
            team_normal_wins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TrueCombat").getAsJsonObject().get("crazywalls_wins_team").getAsInt();
        } catch (Exception e) {}
        try {
            team_lucky_wins = statistics.get("record").getAsJsonObject().get("stats").getAsJsonObject().get("TrueCombat").getAsJsonObject().get("crazywalls_wins_team_chaos").getAsInt();
        } catch (Exception e) {}

        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);
        new FormattedMessage(name + "'s stats in Crazy Walls", EnumChatFormatting.GREEN).send();
        new FormattedMessage("     Coins: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + coins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Solo Normal: ", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + solo_normal_kills, EnumChatFormatting.GOLD)).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN)).appendMessage(new FormattedMessage("" + solo_normal_wins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Solo Lucky: ", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + solo_lucky_wins, EnumChatFormatting.GOLD)).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN)).appendMessage(new FormattedMessage("" + solo_lucky_wins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Team Normal: ", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + team_normal_kills, EnumChatFormatting.GOLD)).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN)).appendMessage(new FormattedMessage("" + team_normal_wins, EnumChatFormatting.GOLD)).send(false);
        new FormattedMessage("     Team Lucky: ", EnumChatFormatting.GREEN).send(false);
        new FormattedMessage("     Kills: ", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("" + team_lucky_kills, EnumChatFormatting.GOLD)).appendMessage(new FormattedMessage(" Wins: ", EnumChatFormatting.GREEN)).appendMessage(new FormattedMessage("" + team_lucky_wins, EnumChatFormatting.GOLD)).send(false);
        FormattedMessage.printSeparationMessage(EnumChatFormatting.YELLOW);

    }
}
